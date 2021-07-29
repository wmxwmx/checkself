package com.wmx.viewcomponent.dispatch

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.VelocityTracker
import android.widget.LinearLayout

class WLinearLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0,

    ) : LinearLayout(context, attrs, defStyle) {

    val onGeListener: GestureDetector.SimpleOnGestureListener =
        object : GestureDetector.SimpleOnGestureListener() {
            override fun onScroll(
                e1: MotionEvent?,
                e2: MotionEvent?,
                distanceX: Float,
                distanceY: Float
            ): Boolean {
                return super.onScroll(e1, e2, distanceX, distanceY)
            }

            override fun onDoubleTap(e: MotionEvent?): Boolean {
                return super.onDoubleTap(e)
            }
            //......

        }

    val doubleGe: GestureDetector.OnDoubleTapListener =
        object : GestureDetector.OnDoubleTapListener {
            override fun onSingleTapConfirmed(e: MotionEvent?): Boolean {
                TODO("Not yet implemented")
            }

            override fun onDoubleTap(e: MotionEvent?): Boolean {
                TODO("Not yet implemented")
            }

            override fun onDoubleTapEvent(e: MotionEvent?): Boolean {
                TODO("Not yet implemented")
            }
        }

    val gestureDetector = GestureDetector(onGeListener)


    init {
        gestureDetector.setOnDoubleTapListener(doubleGe)

    }


    //这些事件分发方法的返回值一般都是标识是否消费的意思，如果返回true 表示消费，如果返回false标识不消费
    //此方法标识是否消费事件，如果返回true 表示消费，事件讲不在向他的childeren传递
    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        Log.e("eeee", " parent000 onInterceptTouchEvent")
        return false
    }

    //如果我设限制setonTouchListener,但是这个listener返回false并且他的子view中没有消费此事件,那么此方法也会被调用，
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        Log.e("eeee", "parent000 onTouchEvent")
        gestureDetector.onTouchEvent(event)

        //一段时间内划过的像素，速度测量 左 -》 右为正  右到左 为负
        // VelocityTracker:速度追踪
        val vo: VelocityTracker = VelocityTracker.obtain()
        vo.addMovement(event)
        vo.computeCurrentVelocity(1000)
        vo.getXVelocity()
        vo.getYVelocity()
        vo.clear()
        vo.recycle()



        return super.onTouchEvent(event)
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        Log.e("eeee", "parent000 dispatchTouchEvent")
        return super.dispatchTouchEvent(ev)
    }


}