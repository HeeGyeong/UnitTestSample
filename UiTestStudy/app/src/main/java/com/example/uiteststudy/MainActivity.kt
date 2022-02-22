package com.example.uiteststudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var text1: TextView? = null
    var text2: TextView? = null
    var text3: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        text1 = findViewById(R.id.text1)
        text2 = findViewById(R.id.text2)
        text3 = findViewById(R.id.text3)

    }

    fun btnClick(view: View) {
        when (view.id) {
            R.id.toast -> {
                Toast.makeText(this, "toast .. ${text1!!.text} : ${text2!!.text} : ${text3!!.text}", Toast.LENGTH_SHORT).show()
            }
            R.id.clear -> {
                text1!!.text = ""
                text2!!.text = ""
                text3!!.text = ""
            }
        }
    }
}