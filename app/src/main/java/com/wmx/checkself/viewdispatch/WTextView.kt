package com.wmx.viewcomponent.dispatch

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import androidx.appcompat.widget.AppCompatTextView


class WTextView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : AppCompatTextView(context, attrs, defStyle){


    override fun onTouchEvent(event: MotionEvent?): Boolean {
        Log.e("eeee","child onTouchEvent")
        return false

    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        Log.e("eeee","child dispatchTouchEvent")
        return super.dispatchTouchEvent(ev)
    }


}