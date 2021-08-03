package com.rightcode.huespine.view.base

import android.os.Bundle
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import com.rightcode.huespine.BR
import com.rightcode.huespine.util.lifecycle.observeNotNull
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.Subject
import java.util.concurrent.TimeUnit

abstract class BaseActivity<VDB, VM> :
    AppCompatActivity() where VDB : ViewDataBinding, VM : ViewModelType<*, *> {
    private val backPressSubject: Subject<Unit> = PublishSubject.create()

    @LayoutRes
    protected open val layoutResId: Int = 0
    protected val compositeDisposable = CompositeDisposable()

    protected lateinit var viewDataBinding: VDB
    protected abstract val viewModel: VM
    protected open val useDoubleBackPress: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewDataBinding = DataBindingUtil.setContentView<VDB>(this, layoutResId).apply {
            lifecycleOwner = this@BaseActivity
        }

        onWillAttachViewModel(this, viewDataBinding, viewModel)
        viewDataBinding.setVariable(BR.input, viewModel.input)
        viewDataBinding.setVariable(BR.output, viewModel.output)
        onDidAttachViewModel(this, viewDataBinding, viewModel)

        backPressSubject
            .map { System.currentTimeMillis() }
            .startWith(System.currentTimeMillis())
            .buffer(2, 1)
            .map { it[0] to it[1] }
            .map { (prev, curr) ->
                this.shouldFinishActivity(prev, curr)
            }
            .subscribe(this::onShouldFinishChanged)
            .addTo(compositeDisposable)
    }

    protected open fun shouldFinishActivity(prevTimeMills: Long, currTimeMills: Long): Boolean {
        return ((currTimeMills - prevTimeMills) < TimeUnit.SECONDS.toMillis(2))
    }

    protected open fun onShouldFinishChanged(shouldFinish: Boolean) {
        if (shouldFinish) {
            finish()
        }

        Toast.makeText(applicationContext, "한번 더 '뒤로' 누르면 종료", Toast.LENGTH_SHORT).show()
    }

    protected open fun onWillAttachViewModel(
        lifecycleOwner: LifecycleOwner,
        viewDataBinding: VDB,
        viewModel: VM
    ) {
        //nothing
    }

    protected open fun onDidAttachViewModel(
        lifecycleOwner: LifecycleOwner,
        viewDataBinding: VDB,
        viewModel: VM
    ) {
        //nothing
    }

    override fun onBackPressed() {
        if (this.useDoubleBackPress) {
            backPressSubject.onNext(Unit)
            return
        }
        super.onBackPressed()
    }

    override fun onDestroy() {
        compositeDisposable.clear()
        super.onDestroy()
    }

    protected fun <T> LiveData<T>.observe(observer: (T) -> Unit) =
        observeNotNull(this@BaseActivity, observer)

    companion object {
    }
}