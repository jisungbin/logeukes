package io.github.jisungbin

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import io.github.jisungbin.logeukes.logeukes
import kotlin.random.Random

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        logeukes { "HI" }
        val textview = Button(this).apply {
            text = getString(R.string.app_name)
            setPadding(30, 30, 30, 30)
            setOnClickListener {
                logeukes { Random.nextInt() }
            }
        }
        setContentView(textview)
    }
}
