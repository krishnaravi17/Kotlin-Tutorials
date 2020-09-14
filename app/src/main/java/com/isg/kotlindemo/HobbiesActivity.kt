package com.isg.kotlindemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.isg.kotlindemo.adapter.AdapterHobbies
import com.isg.kotlindemo.model.Supplier
import kotlinx.android.synthetic.main.activity_hobbies.*

class HobbiesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hobbies)
        setupRecyclerView()

    }


    private fun setupRecyclerView() {

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = layoutManager

        val adapter = AdapterHobbies(this, Supplier.hobbies)
        recyclerView.adapter = adapter
    }
}