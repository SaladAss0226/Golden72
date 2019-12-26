package com.example.golden72.room

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import com.example.golden72.R
import com.example.golden72.backpack.MyPackage
import kotlinx.android.synthetic.main.dialog_take_it.*

class DialogEditText(context: Context) : Dialog(context) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_edit_text)

        btn_cancel.setOnClickListener { dismiss() }


    }
}