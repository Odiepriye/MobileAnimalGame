package com.odiepriye.mymobilegame

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.drawable.Drawable

class LevelThreeObject(var x:Int,var y:Int,var dx:Int,var dy:Int,var image: Drawable) {
    var width:Int = 100
    var height:Int = 100
    var collide = Rect(x.toInt(),y.toInt(),(x+width).toInt(),(y+height).toInt())

    open fun show(x1:Int,y1:Int){
        dx = x1
        dy = y1
        x += dx
        y += dy
    }
    open fun appear(canvas: Canvas){
        update(canvas)
        image.setBounds(x, y,x+width,y+height)
        image.draw(canvas)
    }
    open fun update(canvas: Canvas){
        if(x>(canvas.width-width))
            x = canvas.width-width
        if(y>(canvas.height-height))
            y = canvas.height-height

        if (x < 0) x = 0
        if (y < 0) y = 0
        collide.set(x,y,(x+width),(y+height))
    }
}