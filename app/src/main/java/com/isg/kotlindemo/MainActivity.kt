package com.isg.kotlindemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println("Hello World")
        printMessage("method 1")
        sum(2, 4)

        //initialising the btn listner

        btn_helloWorld.setOnClickListener {

            val strFromUser = et_anything.text.toString();

            Toast.makeText(this, strFromUser, Toast.LENGTH_LONG).show();

            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("user_msg", strFromUser)
            startActivity(intent)

        }

        btn_share.setOnClickListener {
            val strFromUser = et_anything.text.toString();
            val intent = Intent();
            intent.action=Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, strFromUser)
            intent.type="text/plain"
            startActivity(Intent.createChooser(intent,"Share to"))
        }

        //recyclerview Demo
        btn_recyclerView.setOnClickListener {

            val intent = Intent(this, HobbiesActivity::class.java)
            startActivity(intent)

        }


    }

    fun printMessage(message: String): Unit {                               // 1
        println(message)
    }


    fun sum(x: Int, y: Int): Int {                                          // 3
        return x + y
    }

}