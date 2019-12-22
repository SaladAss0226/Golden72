package com.example.golden72.desert

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import com.example.golden72.R
import kotlinx.android.synthetic.main.dialog_take_it.*

class DialogTakeIt(context: Context) : Dialog(context) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_take_it)

        btn_cancel.setOnClickListener { dismiss() }


    }
}