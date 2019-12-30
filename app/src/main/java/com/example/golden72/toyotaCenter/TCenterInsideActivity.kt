package com.example.golden72.toyotaCenter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.golden72.R
import com.example.golden72.backpack.BackpackActivity
import com.example.golden72.backpack.BackpackAdapter.Companion.unAssignList
import com.example.golden72.backpack.MyPackage
import com.example.golden72.publicFunction.putIn
import com.example.golden72.room.DialogTakeIt
import kotlinx.android.synthetic.main.activity_tcenter_inside.*
import kotlinx.android.synthetic.main.dialog_take_it.*

class TCenterInsideActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tcenter_inside)

        imgv_drugs_case.setOnClickListener {
            val dialog = DialogTakeIt(this, R.drawable.test_tube)
            dialog.show()
            dialog.btn_accept.setOnClickListener {
                unAssignList.add(MyPackage(R.drawable.test_tube, "不知名的藥劑","試管中裝了一些紅色液體。", false, 1,1))
                dialog.dismiss()
            }
        }

        btn_backpack_tcenter_inside.setOnClickListener { startActivity(Intent(this, BackpackActivity::class.java)) }

        btn_leave.setOnClickListener { startActivity(Intent(this,TCenterOutsideActivity::class.java)) }
    }
}
