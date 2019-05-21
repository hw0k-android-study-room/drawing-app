package com.hw0k.drawingapp

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.support.v7.widget.AppCompatImageView
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View

class DrawingView : AppCompatImageView, View.OnTouchListener {

    var paint: Paint? = null
    var path: Path? = null
    var paths: MutableList<Path>? = null
    var color: Int? = null
    var colors: MutableList<Int>? = null

    constructor(context: Context) : super(context) {
        init()
    }
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet) {
        init()
    }
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    private fun init() {
        paint = Paint()
        paint!!.color = Color.BLACK
        paint!!.style = Paint.Style.STROKE
        paint!!.strokeCap = Paint.Cap.ROUND
        paint!!.strokeWidth = 10f
        paint!!.isAntiAlias = true

        path = Path()
        paths = ArrayList()
        color = Color.BLACK
        colors = ArrayList()
        setOnTouchListener(this)
    }

    private fun setColor(c: Int) {
        path = Path()
        color = c
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        for ((i, path) in paths!!.withIndex()) {
            Log.d("DV", "stored Path: $i")
            paint!!.color = colors!![i]
            canvas!!.drawPath(path, paint!!)
        }

        canvas!!.drawPath(path!!, paint!!)
    }

    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
        when (event!!.action) {
            MotionEvent.ACTION_MOVE -> {
                path!!.lineTo(event.x, event.y)
            }
            MotionEvent.ACTION_DOWN -> {
                path!!.moveTo(event.x, event.y)
            }
            MotionEvent.ACTION_UP -> {
                paths!!.add(path!!)
                colors!!.add(color!!)
            }
        }
        invalidate()
        return false
    }
}
