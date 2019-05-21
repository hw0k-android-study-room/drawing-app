package com.hw0k.drawingapp

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    private var drawingView: DrawingView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        drawingView = findViewById(R.id.drawingView)
    }

    fun onColorClick(view: View) = when (view.id) {
        R.id.radioBlack -> {
            drawingView!!.color = Color.BLACK
        }
        R.id.radioRed -> {
            drawingView!!.color = Color.RED
        }
        R.id.radioBlue -> {
            drawingView!!.color = Color.BLUE
        }
        else -> {

        }
    }
}
