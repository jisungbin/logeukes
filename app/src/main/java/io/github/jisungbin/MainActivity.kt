package io.github.jisungbin

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.setPadding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val textview = TextView(this).apply {
            text = getString(R.string.app_name)
            setPadding(30)
        }
        setContentView(textview)
    }
}
