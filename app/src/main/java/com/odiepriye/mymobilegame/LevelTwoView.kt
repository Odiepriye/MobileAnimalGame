package com.odiepriye.mymobilegame

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.media.MediaPlayer
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

class LevelTwoView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    var paint= Paint()
    var myX:Float = 100f
    var myY:Float = 100f
    lateinit var myBitmap: Bitmap
    lateinit var myBitmapCanvas: Canvas
    var myWidth: Int = 800
    var myHeight: Int = 800

    init{
        paint.color = Color.WHITE
        paint.textSize=80f
    }

    override fun onDrawForeground(canvas: Canvas?) {
        super.onDrawForeground(canvas)
        canvas!!.drawText("Drawing App",myX,myY,paint)
        myBitmapCanvas.drawCircle(myX,myY,10f,paint)
        canvas!!.drawBitmap(myBitmap,0f,0f,null)
    }
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if(event!!.action==MotionEvent.ACTION_MOVE){
           myX = event!!.x
           myY = event!!.y
            invalidate()
        }
        return true
    }
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        myWidth=measuredWidth
        myHeight=measuredHeight
        myBitmap= Bitmap.createBitmap(myWidth,myHeight,Bitmap.Config.RGB_565)
        myBitmapCanvas=Canvas(myBitmap)
    }
}