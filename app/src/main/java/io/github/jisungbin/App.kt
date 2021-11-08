package io.github.jisungbin

import android.app.Application
import io.github.jisungbin.logeukes.Logeukes

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Logeukes.setup()
        }
    }
}
