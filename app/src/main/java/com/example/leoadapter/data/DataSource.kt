package com.example.leoadapter.data


data class Person (
    val id:Int,
    val age:Int,
    val name:String
)

val data:ArrayList<Person> = arrayListOf(
    Person(1,21,"Adam"),
    Person(2,22,"Brus"),
    Person(3,32,"Peter"),
    Person(6,54,"Jonh"),
    Person(4,21,"Artur"),
    Person(5,3,"Joseph")
)

val colors: Array<Int> = arrayOf(
    android.R.color.holo_blue_bright,
    android.R.color.holo_blue_dark,
    android.R.color.holo_green_light,
    android.R.color.holo_red_light,
    android.R.color.holo_purple
)