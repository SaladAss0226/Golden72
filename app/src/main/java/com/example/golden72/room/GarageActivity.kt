package com.example.golden72.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.golden72.R
import kotlinx.android.synthetic.main.activity_garage.*

class GarageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_garage)

        btn_back_garage.setOnClickListener { this.finish() }
    }
}
