package com.rightcode.huespine.view.base

interface ViewModelType<out Input : ViewModelType.Input, out Output : ViewModelType.Output> {
    val input: Input
    val output: Output

    interface Input

    interface Output
}
