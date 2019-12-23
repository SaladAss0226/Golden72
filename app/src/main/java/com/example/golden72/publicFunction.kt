package com.example.golden72

import android.view.View
import com.example.golden72.backpack.BackpackAdapter
import com.example.golden72.backpack.MyPackage

object publicFunction {
    fun putIn(item: MyPackage, imgv: View){
        BackpackAdapter.unAssignList.add(item)
        imgv.visibility = View.GONE
    }
}