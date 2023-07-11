package com.bbbrrr8877.coremvvmtest.weatherList.data

import android.content.Context
import android.util.AttributeSet
import com.bumptech.glide.Glide
import com.github.johnnysc.coremvvm.presentation.adapter.MyImageView
import com.github.johnnysc.coremvvm.presentation.adapter.MyView


class ConditionImageView : MyImageView {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun loadImage(url: String) {
        Glide.with(this)
            .load(url)
            .into(this)
    }
}

class MyTextView : androidx.appcompat.widget.AppCompatTextView, MyView {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun show(text: CharSequence) {
        setText(text)
    }

    override fun show(textId: Int) {
        setText(textId)
    }

    override fun handleClick(listener: OnClickListener) = setOnClickListener(listener)

}