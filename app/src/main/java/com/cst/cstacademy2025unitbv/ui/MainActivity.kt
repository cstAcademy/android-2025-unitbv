package com.cst.cstacademy2025unitbv.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cst.cstacademy2025unitbv.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val button = findViewById<Button>(R.id.btn_click_me)
        button.setOnClickListener {
            goToSecondActivity()

            Log.e("TAG", "button clicked")
        }

        Log.e("TAG", "onCreate")
    }

    fun goToSecondActivity() {
       // Intent intent = new Intent (this, SecondActivity.class)
        val intent = Intent(this, ControllerActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onStart() {
        super.onStart()

        Log.e("TAG", "onStart")
    }

    override fun onResume() {
        super.onResume()

        Log.e("TAG", "onResume")
    }

    override fun onPause() {
        super.onPause()

        Log.e("TAG", "onPause")
    }

    override fun onStop() {
        super.onStop()

        Log.e("TAG", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.e("TAG", "onDestroy")
    }
}