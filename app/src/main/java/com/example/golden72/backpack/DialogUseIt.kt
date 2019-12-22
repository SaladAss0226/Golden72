package com.example.golden72.backpack

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import com.example.golden72.R
import kotlinx.android.synthetic.main.dialog_take_it.*

class DialogUseIt(context: Context,val item: Package) : Dialog(context) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_take_it)


        tv_are_you_sure.text = "確定要使用嗎?"
        dialog_imgv.setImageResource(item.img)
        btn_cancel.setOnClickListener { dismiss() }


    }
}