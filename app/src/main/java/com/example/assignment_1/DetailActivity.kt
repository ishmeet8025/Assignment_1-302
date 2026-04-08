package com.example.assignment_1

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * Displays course details
 */
class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val code = intent.getStringExtra("code")
        val name = intent.getStringExtra("name")
        val description = intent.getStringExtra("description")

        findViewById<TextView>(R.id.textCode).text = code
        findViewById<TextView>(R.id.textName).text = name
        findViewById<TextView>(R.id.textDescription).text = description
    }
}