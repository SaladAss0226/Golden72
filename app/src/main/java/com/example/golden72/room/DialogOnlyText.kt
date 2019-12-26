package com.example.golden72.room

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import com.example.golden72.R
import kotlinx.android.synthetic.main.dialog_only_text.*
import kotlinx.android.synthetic.main.dialog_take_it.*
import kotlinx.android.synthetic.main.dialog_take_it.btn_cancel
import kotlinx.android.synthetic.main.dialog_take_it.tv_are_you_sure

class DialogOnlyText(context: Context, val text:String) : Dialog(context) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_only_text)

        tv_are_you_sure.setText(text)
        btn_cancel.setOnClickListener { dismiss() }


    }
}