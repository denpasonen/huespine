package com.rightcode.huespine.util.ext

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData


inline fun <T, R> LiveData<T>.map(
    defaultValue: R? = null,
    crossinline block: ((T?) -> R?)
): LiveData<R> {
    return MediatorLiveData<R>().apply {
        value = defaultValue
        addSource(this@map) { item: T? ->
            this.value = block.invoke(item)
        }
    }
}

inline fun <T1, T2, R> LiveData<T1>.combineLatest(
    source: LiveData<T2>,
    defaultValue: R? = null,
    crossinline block: ((T1?, T2?) -> R?)
): LiveData<R> {
    return MediatorLiveData<R>().apply {
        value = defaultValue
        addSource(this@combineLatest) { item: T1? ->
            this.value = block.invoke(item, source.value)
        }
        addSource(source) { item: T2? ->
            this.value = block.invoke(this@combineLatest.value, item)
        }
    }
}

inline fun <T1, T2, T3, R> LiveData<T1>.combineLatest(
    source2: LiveData<T2>,
    source3: LiveData<T3>,
    defaultValue: R? = null,
    crossinline block: ((T1?, T2?, T3?) -> R?)
): LiveData<R> {
    return MediatorLiveData<R>().apply {
        value = defaultValue
        addSource(this@combineLatest) { item: T1? ->
            this.value = block.invoke(item, source2.value, source3.value)
        }
        addSource(source2) { item: T2? ->
            this.value = block.invoke(this@combineLatest.value, item, source3.value)
        }
        addSource(source3) { item: T3? ->
            this.value = block.invoke(this@combineLatest.value, source2.value, item)
        }
    }
}

inline fun <T1, T2, T3, T4, R> LiveData<T1>.combineLatest(
    source2: LiveData<T2>,
    source3: LiveData<T3>,
    source4: LiveData<T4>,
    defaultValue: R? = null,
    crossinline block: ((T1?, T2?, T3?, T4?) -> R?)
): LiveData<R> {
    return MediatorLiveData<R>().apply {
        value = defaultValue
        addSource(this@combineLatest) { item: T1? ->
            this.value = block.invoke(
                item,
                source2.value,
                source3.value,
                source4.value
            )
        }
        addSource(source2) { item: T2? ->
            this.value = block.invoke(
                this@combineLatest.value,
                item,
                source3.value,
                source4.value
            )
        }
        addSource(source3) { item: T3? ->
            this.value = block.invoke(
                this@combineLatest.value,
                source2.value,
                item,
                source4.value
            )
        }
        addSource(source4) { item: T4? ->
            this.value = block.invoke(
                this@combineLatest.value,
                source2.value,
                source3.value,
                item
            )
        }
    }
}


inline fun <T1, T2, T3, T4, T5, R> LiveData<T1>.combineLatest(
    source2: LiveData<T2>,
    source3: LiveData<T3>,
    source4: LiveData<T4>,
    source5: LiveData<T5>,
    defaultValue: R? = null,
    crossinline block: ((T1?, T2?, T3?, T4?, T5?) -> R?)
): LiveData<R> {
    return MediatorLiveData<R>().apply {
        value = defaultValue
        addSource(this@combineLatest) { item: T1? ->
            this.value = block.invoke(
                item, source2.value,
                source3.value, source4.value,
                source5.value
            )
        }
        addSource(source2) { item: T2? ->
            this.value = block.invoke(
                this@combineLatest.value, item,
                source3.value, source4.value,
                source5.value
            )
        }
        addSource(source3) { item: T3? ->
            this.value = block.invoke(
                this@combineLatest.value, source2.value,
                item, source4.value,
                source5.value
            )
        }
        addSource(source4) { item: T4? ->
            this.value = block.invoke(
                this@combineLatest.value, source2.value,
                source3.value, item,
                source5.value
            )
        }
        addSource(source5) { item: T5? ->
            this.value = block.invoke(
                this@combineLatest.value, source2.value,
                source3.value, source4.value,
                item
            )
        }
    }
}

inline fun <T1, T2, T3, T4, T5, T6, R> LiveData<T1>.combineLatest(
    source2: LiveData<T2>,
    source3: LiveData<T3>,
    source4: LiveData<T4>,
    source5: LiveData<T5>,
    source6: LiveData<T6>,
    defaultValue: R? = null,
    crossinline block: ((T1?, T2?, T3?, T4?, T5?, T6?) -> R?)
): LiveData<R> {
    return MediatorLiveData<R>().apply {
        value = defaultValue
        addSource(this@combineLatest) { item: T1? ->
            this.value = block.invoke(
                item, source2.value,
                source3.value, source4.value,
                source5.value, source6.value
            )
        }
        addSource(source2) { item: T2? ->
            this.value = block.invoke(
                this@combineLatest.value, item,
                source3.value, source4.value,
                source5.value, source6.value
            )
        }
        addSource(source3) { item: T3? ->
            this.value = block.invoke(
                this@combineLatest.value, source2.value,
                item, source4.value,
                source5.value, source6.value
            )
        }
        addSource(source4) { item: T4? ->
            this.value = block.invoke(
                this@combineLatest.value, source2.value,
                source3.value, item,
                source5.value, source6.value
            )
        }
        addSource(source5) { item: T5? ->
            this.value = block.invoke(
                this@combineLatest.value, source2.value,
                source3.value, source4.value,
                item, source6.value
            )
        }
        addSource(source6) { item: T6? ->
            this.value = block.invoke(
                this@combineLatest.value, source2.value,
                source3.value, source4.value,
                source5.value, item
            )
        }
    }
}

inline fun <T1, T2, T3, T4, T5, T6, T7, R> LiveData<T1>.combineLatest(
    source2: LiveData<T2>,
    source3: LiveData<T3>,
    source4: LiveData<T4>,
    source5: LiveData<T5>,
    source6: LiveData<T6>,
    source7: LiveData<T7>,
    defaultValue: R? = null,
    crossinline block: ((T1?, T2?, T3?, T4?, T5?, T6?, T7?) -> R?)
): LiveData<R> {
    return MediatorLiveData<R>().apply {
        value = defaultValue
        addSource(this@combineLatest) { item: T1? ->
            this.value = block.invoke(
                item, source2.value,
                source3.value, source4.value,
                source5.value, source6.value,
                source7.value
            )
        }
        addSource(source2) { item: T2? ->
            this.value = block.invoke(
                this@combineLatest.value, item,
                source3.value, source4.value,
                source5.value, source6.value,
                source7.value
            )
        }
        addSource(source3) { item: T3? ->
            this.value = block.invoke(
                this@combineLatest.value, source2.value,
                item, source4.value,
                source5.value, source6.value,
                source7.value
            )
        }
        addSource(source4) { item: T4? ->
            this.value = block.invoke(
                this@combineLatest.value, source2.value,
                source3.value, item,
                source5.value, source6.value,
                source7.value
            )
        }
        addSource(source5) { item: T5? ->
            this.value = block.invoke(
                this@combineLatest.value, source2.value,
                source3.value, source4.value,
                item, source6.value,
                source7.value
            )
        }
        addSource(source6) { item: T6? ->
            this.value = block.invoke(
                this@combineLatest.value, source2.value,
                source3.value, source4.value,
                source5.value, item,
                source7.value
            )
        }
        addSource(source7) { item: T7? ->
            this.value = block.invoke(
                this@combineLatest.value, source2.value,
                source3.value, source4.value,
                source5.value, source6.value,
                item
            )
        }
    }
}

inline fun <T1, T2, T3, T4, T5, T6, T7, T8, R> LiveData<T1>.combineLatest(
    source2: LiveData<T2>,
    source3: LiveData<T3>,
    source4: LiveData<T4>,
    source5: LiveData<T5>,
    source6: LiveData<T6>,
    source7: LiveData<T7>,
    source8: LiveData<T8>,
    defaultValue: R? = null,
    crossinline block: ((T1?, T2?, T3?, T4?, T5?, T6?, T7?, T8?) -> R?)
): LiveData<R> {
    return MediatorLiveData<R>().apply {
        value = defaultValue
        addSource(this@combineLatest) { item: T1? ->
            this.value = block.invoke(
                item, source2.value,
                source3.value, source4.value,
                source5.value, source6.value,
                source7.value, source8.value
            )
        }
        addSource(source2) { item: T2? ->
            this.value = block.invoke(
                this@combineLatest.value, item,
                source3.value, source4.value,
                source5.value, source6.value,
                source7.value, source8.value
            )
        }
        addSource(source3) { item: T3? ->
            this.value = block.invoke(
                this@combineLatest.value, source2.value,
                item, source4.value,
                source5.value, source6.value,
                source7.value, source8.value
            )
        }
        addSource(source4) { item: T4? ->
            this.value = block.invoke(
                this@combineLatest.value, source2.value,
                source3.value, item,
                source5.value, source6.value,
                source7.value, source8.value
            )
        }
        addSource(source5) { item: T5? ->
            this.value = block.invoke(
                this@combineLatest.value, source2.value,
                source3.value, source4.value,
                item, source6.value,
                source7.value, source8.value
            )
        }
        addSource(source6) { item: T6? ->
            this.value = block.invoke(
                this@combineLatest.value, source2.value,
                source3.value, source4.value,
                source5.value, item,
                source7.value, source8.value
            )
        }
        addSource(source7) { item: T7? ->
            this.value = block.invoke(
                this@combineLatest.value, source2.value,
                source3.value, source4.value,
                source5.value, source6.value,
                item, source8.value
            )
        }
        addSource(source8) { item: T8? ->
            this.value = block.invoke(
                this@combineLatest.value, source2.value,
                source3.value, source4.value,
                source5.value, source6.value,
                source7.value, item
            )
        }
    }
}
