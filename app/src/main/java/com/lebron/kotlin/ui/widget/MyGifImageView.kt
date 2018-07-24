package com.lebron.kotlin.ui.widget

import android.content.Context
import android.util.AttributeSet
import pl.droidsonroids.gif.GifImageView

class MyGifImageView: GifImageView{

    constructor(context: Context) : super(context)

    constructor(context: Context,attributeSet: AttributeSet):super(context,attributeSet)
    constructor(context: Context?, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle)

}