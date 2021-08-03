package com.rightcode.huespine.buildsrc

import org.gradle.api.Action
import org.gradle.api.NamedDomainObjectContainer

fun <T> NamedDomainObjectContainer<T>.getOrCreate(name: String, configureAction: Action<T>) {
    try {
        this.getByName(name, configureAction)
    } catch (e: Throwable) {
        this.create(name, configureAction)
    }
}