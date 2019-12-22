package com.example.golden72.backpack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.golden72.building.BuildingActivity.Companion.key
import com.example.golden72.R
import kotlinx.android.synthetic.main.activity_backpack.*
import kotlinx.android.synthetic.main.dialog_take_it.*

class BackpackActivity : AppCompatActivity() {

    val backpackAdapter = BackpackAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_backpack)

        recyclerview_backpack.layoutManager = LinearLayoutManager(this)
        recyclerview_backpack.adapter = backpackAdapter

        btn_back.setOnClickListener {
            this.finish()
        }

        BackpackAdapter.setToClick(object :BackpackAdapter.ItemClickListener{
            override fun toClick(item: Package) {
                val dialog = DialogUseIt(this@BackpackActivity,item)
                dialog.show()
                dialog.btn_accept.setOnClickListener {
                    key = item.itemName
                    item.done = true
                    backpackAdapter.notifyDataSetChanged()
                    Toast.makeText(this@BackpackActivity,"公事包已解鎖",Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                }
            }
        })
    }

    override fun onBackPressed() {}
}
