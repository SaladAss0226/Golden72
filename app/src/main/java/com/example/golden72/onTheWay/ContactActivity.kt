package com.example.golden72.onTheWay

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.golden72.R
import com.example.golden72.backpack.BackpackActivity
import kotlinx.android.synthetic.main.activity_contact.*

class ContactActivity : AppCompatActivity() {

    var nextFlag  = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)

        tv_next_contact.setOnClickListener {
            if(nextFlag==0){
                tv_content_contact.setText(R.string.str_earthquake)
                nextFlag=1
            }
            else if(nextFlag==1) this.finish()
        }

        btn_backpack_contact.setOnClickListener { startActivity(Intent(this,BackpackActivity::class.java)) }

    }
}
