package com.isg.kotlindemo.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.isg.kotlindemo.R
import com.isg.kotlindemo.helper.showToast
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val bundle: Bundle? = intent.extras
        val msg = bundle!!.getString("user_msg")
        textView.text = msg

        showToast(msg.toString())
    }
}