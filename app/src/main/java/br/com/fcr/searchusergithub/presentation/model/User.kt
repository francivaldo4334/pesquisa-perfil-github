package br.com.fcr.searchusergithub.presentation.model

data class User(
    val name:String = "",
    val fllowers:Int = 0,
    val fllowing:Int = 0,
    val link:String = "",
    val avatar_url:String = ""
)