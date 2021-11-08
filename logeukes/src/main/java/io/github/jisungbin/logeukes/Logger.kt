/*
 * Copyright (c) 2021. Sungbin Ji. All rights reserved. 
 *
 * Logeukes license is under the MIT license.
 * SEE LICENSE : https://github.com/jisungbin/logeukes/blob/master/LICENSE
 */

@file:Suppress("unused", "SpellCheckingInspection")

package io.github.jisungbin.logeukes

import android.util.Log

enum class LoggerType {
    W, V, D, E, I
}

@JvmOverloads
inline fun Any.logeukes(
    tag: String = getClassName(),
    type: LoggerType = LoggerType.D,
    content: () -> Any?
) {
    log(tag, type, content().getLogContent())
}

@PublishedApi
internal fun log(tag: String, type: LoggerType, content: String) {
    if (!Logeukes.setup) return
    else {
        when (type) {
            LoggerType.D -> Log.d(tag, content)
            LoggerType.E -> Log.e(tag, content)
            LoggerType.I -> Log.i(tag, content)
            LoggerType.W -> Log.w(tag, content)
            LoggerType.V -> Log.v(tag, content)
        }
    }
}

@PublishedApi
internal fun Any?.getLogContent(): String {
    val dataBuilder = StringBuilder()
    when (this) {
        is Iterable<*> -> {
            for ((index, element) in withIndex()) {
                dataBuilder.append("\n[$index] $element")
            }
        }
        is Map<*, *> -> {
            for ((index, element) in asIterable().withIndex()) {
                dataBuilder.append("\n[$index] ${element.key} - ${element.value}")
            }
        }
        is Array<*> -> {
            for ((index, element) in asIterable().withIndex()) {
                dataBuilder.append("\n[$index] $element")
            }
        }
        else -> dataBuilder.append(toString())
    }
    val logDataBuilder = StringBuilder()
    val splitData = dataBuilder.toString().replaceFirst("\n", "").split("\n")
    for ((index, element) in splitData.withIndex()) {
        val value = StringBuilder().apply {
            append("\n│${"\t".repeat(5)}$element")
            if (index == splitData.size - 1) {
                append("\n${"─".repeat(50)}")
                if (element.length >= 30) {
                    append("─".repeat(element.length - 20))
                }
            }
        }
        logDataBuilder.append(value.toString())
    }
    return " $logDataBuilder"
}

// Thanks: https://github.com/square/logcat/blob/main/logcat/src/main/java/logcat/Logcat.kt#L86
@PublishedApi
internal fun Any.getClassName(): String {
    val javaClass = this::class.java
    val fullClassName = javaClass.name
    val outerClassName = fullClassName.substringBefore('$')
    val simplerOuterClassName = outerClassName.substringAfterLast('.')
    return if (simplerOuterClassName.isEmpty()) {
        fullClassName
    } else {
        simplerOuterClassName.removeSuffix("Kt")
    }
}
