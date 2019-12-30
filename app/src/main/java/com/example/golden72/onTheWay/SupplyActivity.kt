package com.example.golden72.onTheWay

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.golden72.R
import com.example.golden72.backpack.BackpackActivity
import com.example.golden72.backpack.MyPackage
import com.example.golden72.publicFunction.putIn
import kotlinx.android.synthetic.main.activity_supply.*

class SupplyActivity : AppCompatActivity() {

    var level:String? = ""
    var nextFlag = 0
    var itemFlag = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_supply)

        intent.extras!!.let {
            level = it.getString("level")
        }

        btn_backpack_supply.setOnClickListener {
            startActivity(Intent(this,BackpackActivity::class.java))
        }

        tv_next_supply.setOnClickListener {
            if(nextFlag==0){
                if(level=="1"){
                    imgv_m9.visibility = View.VISIBLE
                    imgv_m9_02.visibility = View.VISIBLE
                    imgv_gas_02.visibility = View.VISIBLE
                }
                else if(level=="2"){
                    imgv_gas_03.visibility = View.VISIBLE
                    imgv_gas_02.visibility = View.VISIBLE
                    imgv_m9.visibility = View.VISIBLE
                    imgv_eagal.visibility = View.VISIBLE
                }
                else if(level=="3"){
                    imgv_gas.visibility = View.VISIBLE
                    imgv_gas_02.visibility = View.VISIBLE
                    imgv_gas_03.visibility = View.VISIBLE
                    imgv_eagal.visibility = View.VISIBLE
                    imgv_ak47_02.visibility = View.VISIBLE
                }
                else if(level=="4"){
                    imgv_gas.visibility = View.VISIBLE
                    imgv_gas_02.visibility = View.VISIBLE
                    imgv_gas_03.visibility = View.VISIBLE
                    imgv_gas_04.visibility = View.VISIBLE
                    imgv_eagal.visibility = View.VISIBLE
                    imgv_ak47.visibility = View.VISIBLE
                    imgv_ak47_02.visibility = View.VISIBLE
                    imgv_c4.visibility = View.VISIBLE
                }
                nextFlag = 1
            }
            else this.finish()

        }

        btn_take_it_supply.setOnClickListener {
            when(itemFlag){
                "m9" -> putIn(MyPackage(R.drawable.ic_m9,"貝瑞塔M9",resources.getString(R.string.str_m9),false,15,1),imgv_m9)
                "m9_02" -> putIn(MyPackage(R.drawable.ic_m9,"貝瑞塔M9",resources.getString(R.string.str_m9),false,15,1),imgv_m9_02)
                "eagal" -> putIn(MyPackage(R.drawable.eagal,"沙漠之鷹",resources.getString(R.string.str_eagal),false,7,1),imgv_eagal)
                "ak47" -> putIn(MyPackage(R.drawable.ak_47,"AK-47突擊步槍",resources.getString(R.string.str_ak47),false,30,1),imgv_ak47)
                "ak47_02" -> putIn(MyPackage(R.drawable.ak_47,"AK-47突擊步槍",resources.getString(R.string.str_ak47),false,30,1),imgv_ak47_02)
                "c4" -> putIn(MyPackage(R.drawable.c4,"手榴彈",resources.getString(R.string.str_c4),false,1,1),imgv_c4)
                "gas" -> putIn(MyPackage(R.drawable.gallons_5,"一小桶汽油",resources.getString(R.string.str_gas),false,1,1),imgv_gas)
                "gas_02" -> putIn(MyPackage(R.drawable.gallons_5,"一小桶汽油",resources.getString(R.string.str_gas),false,1,1),imgv_gas_02)
                "gas_03" -> putIn(MyPackage(R.drawable.gallons_5,"一小桶汽油",resources.getString(R.string.str_gas),false,1,1),imgv_gas_03)
                "gas_04" -> putIn(MyPackage(R.drawable.gallons_5,"一小桶汽油",resources.getString(R.string.str_gas),false,1,1),imgv_gas_04)

            }
        }

        imgv_m9.setOnClickListener {
            itemFlag = "m9"
            tv_content_supply.setText(R.string.str_m9)
        }
        imgv_m9_02.setOnClickListener {
            itemFlag = "m9_02"
            tv_content_supply.setText(R.string.str_m9)
        }
        imgv_eagal.setOnClickListener {
            itemFlag = "eagal"
            tv_content_supply.setText(R.string.str_eagal)
        }
        imgv_ak47.setOnClickListener {
            itemFlag = "ak47"
            tv_content_supply.setText(R.string.str_ak47)
        }
        imgv_ak47_02.setOnClickListener {
            itemFlag = "ak47_02"
            tv_content_supply.setText(R.string.str_ak47)
        }
        imgv_c4.setOnClickListener {
            itemFlag = "c4"
            tv_content_supply.setText(R.string.str_c4)
        }
        imgv_gas.setOnClickListener {
            itemFlag = "gas"
            tv_content_supply.setText(R.string.str_gas)
        }
        imgv_gas_02.setOnClickListener {
            itemFlag = "gas_02"
            tv_content_supply.setText(R.string.str_gas)
        }
        imgv_gas_03.setOnClickListener {
            itemFlag = "gas_03"
            tv_content_supply.setText(R.string.str_gas)
        }
        imgv_gas_04.setOnClickListener {
            itemFlag = "gas_04"
            tv_content_supply.setText(R.string.str_gas)
        }









    }
}
