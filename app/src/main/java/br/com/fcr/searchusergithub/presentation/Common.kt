package br.com.fcr.searchusergithub.presentation

import androidx.navigation.NavHostController

class Common {
    companion object{
        var navController:NavHostController? = null
    }
    fun setNavHost(_navController:NavHostController){
        navController = _navController
    }
}
sealed class Screen(val route:String){
    class Search:Screen("Search")
    class Perfil:Screen("Perfil")
}