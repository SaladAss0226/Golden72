package com.example.golden72.backpack

data class MyPackage(
    val img:Int,
    val itemName:String,
    val describe:String,
    var done:Boolean,
    var availableUseTime:Int,
    var type:Int
)

//type=1是有限制使用次數 type2為無限使用