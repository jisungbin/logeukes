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

private val TAG get() = "test"

@JvmOverloads
fun logeukes(tag: String = TAG, type: LoggerType = LoggerType.D, content: () -> Any?) {
    log(tag, type, content().getLogContent())
}

private fun log(tag: String, type: LoggerType, content: String) {
    if (!Logeukes.setup) return
    else {
        when (type) {
            LoggerType.D -> Log.d(tag, content)
            LoggerType.E -> Log.e(tag, content)
            LoggerType.I -> Log.i(tag, content)
            LoggerType.W -> Log.w(tag, content)
            LoggerType.V -> Log.v(tag, content)
        }
        if (Logeukes.usePrintln) println(content)
    }
}

private fun Any?.getLogContent(): String {
    var data = ""
    when (this) {
        is Iterable<*> -> {
            for ((index, element) in withIndex()) {
                data += "\n[$index] $element"
            }
        }
        is Map<*, *> -> {
            for ((index, element) in asIterable().withIndex()) {
                data += "\n[$index] ${element.key} - ${element.value}"
            }
        }
        is Array<*> -> {
            for ((index, element) in asIterable().withIndex()) {
                data += "\n[$index] $element"
            }
        }
        else -> data = toString()
    }
    var logData = ""
    val splitData = data.replaceFirst("\n", "").split("\n")
    for ((index, element) in splitData.withIndex()) {
        var value = ""
        value += "\n│${"\t".repeat(5)}$element"
        if (index == splitData.size - 1) {
            value += "\n${"─".repeat(50)}"
            if (element.length >= 30) {
                value += "─".repeat(element.length - 20)
            }
        }
        logData += value
    }
    return " $logData"
}
