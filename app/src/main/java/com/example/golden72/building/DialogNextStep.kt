package com.example.golden72.building

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import com.example.golden72.R
import kotlinx.android.synthetic.main.dialog_take_it.*

class DialogNextStep(context: Context) : Dialog(context) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_next_step)

        btn_cancel.setOnClickListener { dismiss() }


    }
}