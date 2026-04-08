package com.example.assignment_1

import Course
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * Adapter for RecyclerView
 */
class CourseAdapter(
    private val courseList: List<Course>,
    private val onClick: (Course) -> Unit
) : RecyclerView.Adapter<CourseAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val code: TextView = view.findViewById(R.id.textCode)
        val name: TextView = view.findViewById(R.id.textName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val course = courseList[position]

        holder.code.text = course.code
        holder.name.text = course.name

        holder.itemView.setOnClickListener {
            onClick(course)
        }
    }

    override fun getItemCount(): Int = courseList.size
}