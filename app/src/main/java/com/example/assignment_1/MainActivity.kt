package com.example.assignment_1

import Course
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

/**
 * MainActivity - Displays list of courses
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val bars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(bars.left, bars.top, bars.right, bars.bottom)
            insets
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewCourses)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = CourseAdapter(getCourses()) { course ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("code", course.code)
            intent.putExtra("name", course.name)
            intent.putExtra("description", course.description)
            startActivity(intent)
        }

        recyclerView.adapter = adapter
    }

    /**
     * Returns list of courses
     */
    private fun getCourses(): List<Course> {
        return listOf(
            Course("MAD307", "3D Graphics and Animation",
                "Learn 3D modeling, rendering, and animation techniques."),
            Course("MAD402", "iOS Development",
                "Develop iOS applications using Swift."),
            Course("MAD407", "App Store Optimization",
                "Improve app ranking and visibility."),
            Course("MAD411", "Testing and QA",
                "Learn testing and debugging techniques."),
            Course("MAD317", "Project Development",
                "Build real-world mobile apps."),
            Course("MAD302", "Android Development",
                "Create Android apps using Kotlin.")
        )
    }
}