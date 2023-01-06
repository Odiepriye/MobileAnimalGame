package com.odiepriye.mymobilegame

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.SurfaceHolder
import android.view.SurfaceView

class MySurfaceView(context: Context?, attrs: AttributeSet?) : SurfaceView(context, attrs), Runnable {
    var paint = Paint()
    var isRunning = true
    lateinit var myThread: Thread
    lateinit var myHolder: SurfaceHolder
    var myGameObjects = ArrayList<LevelThreeObject>()

    var frog = LevelThreeObject(400,100,10,10,context!!.resources.getDrawable(R.drawable.frog,null))
    init {
    paint.color= Color.WHITE
    val fly = context!!.resources.getDrawable(R.drawable.fly,null)
    myGameObjects.add(LevelThreeObject(600,1000,10,10,fly))
    val fly2 = context!!.resources.getDrawable(R.drawable.fly,null)
    val fly3 = context!!.resources.getDrawable(R.drawable.fly,null)
    val fly4 = context!!.resources.getDrawable(R.drawable.fly,null)
    val fly5 = context!!.resources.getDrawable(R.drawable.fly,null)
    val fly6 = context!!.resources.getDrawable(R.drawable.fly,null)
    val fly7 = context!!.resources.getDrawable(R.drawable.fly,null)
    myGameObjects.add(LevelThreeObject(300,500,10,10,fly2))
    myGameObjects.add(LevelThreeObject(100,200,10,10,fly3))
    myGameObjects.add(LevelThreeObject(800,700,10,10,fly4))
    myGameObjects.add(LevelThreeObject(650,200,10,10,fly5))
    myGameObjects.add(LevelThreeObject(100,1000,10,10,fly6))
    myGameObjects.add(LevelThreeObject(350,1000,10,10,fly))
    myThread = Thread(this)
    myThread.start()
    myHolder = holder
}
    override fun run() {
        while(isRunning) {
            if(!myHolder.surface.isValid)
                continue
            val canvas: Canvas = myHolder.lockCanvas()
            canvas.drawRect(0f,0f,canvas.width.toFloat(),canvas.height.toFloat(),paint)
            frog.appear(canvas)
            var temp:LevelThreeObject? = null
            for(animal in myGameObjects){
                if(frog.collide.intersect(animal.collide)) temp = animal
                else animal.appear(canvas)
            }
            if(temp != null) myGameObjects.remove(temp)
            myHolder.unlockCanvasAndPost(canvas)
        }

    }

}