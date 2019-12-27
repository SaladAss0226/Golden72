package com.example.golden72.backpack

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import com.example.golden72.R
import kotlinx.android.synthetic.main.dialog_imageview.*
import kotlinx.android.synthetic.main.dialog_take_it.*
import kotlinx.android.synthetic.main.dialog_take_it.dialog_imgv

class DialogImageview(context: Context, val photo:Int) : Dialog(context) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_imageview)

        dialog_imgv.setImageResource(photo)


    }
}