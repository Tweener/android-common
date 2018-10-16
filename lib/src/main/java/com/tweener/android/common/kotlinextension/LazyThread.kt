package com.tweener.android.common.kotlinextension

/**
 * @author Vivien Mahe
 */

fun <T> lazyThreadSafetyNone(initializer: () -> T): Lazy<T> = lazy(LazyThreadSafetyMode.NONE, initializer)
