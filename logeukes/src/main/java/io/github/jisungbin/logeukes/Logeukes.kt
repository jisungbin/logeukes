/*
 * Copyright (c) 2021. Sungbin Ji. All rights reserved.
 *
 * Logeukes license is under the MIT license.
 * SEE LICENSE : https://github.com/jisungbin/logeukes/blob/master/LICENSE
 */

@file:Suppress("SpellCheckingInspection")

package io.github.jisungbin.logeukes

object Logeukes {
    internal var setup = false
    internal var usePrintln = false

    fun setup(usePrintln: Boolean = false) {
        setup = true
        this.usePrintln = usePrintln
    }
}
