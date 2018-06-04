package com.jinglu.studydemo.kotlin

import android.os.Bundle
import com.jinglu.studydemo.R
import com.longruan.appframe.base.BaseActivity

class KotlinActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initToolbar(R.layout.activity_kotlin, getString(R.string.kotlin_title))
    }
}
