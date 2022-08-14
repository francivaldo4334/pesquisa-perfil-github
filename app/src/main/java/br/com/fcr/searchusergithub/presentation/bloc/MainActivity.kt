package br.com.fcr.searchusergithub.presentation.bloc

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.fcr.searchusergithub.presentation.Common
import br.com.fcr.searchusergithub.presentation.Screen
import br.com.fcr.searchusergithub.presentation.pages.PerfilPage
import br.com.fcr.searchusergithub.presentation.pages.SearchPage
import br.com.fcr.searchusergithub.presentation.theme.PesquisarPerfilNoGihubTheme
import br.com.fcr.searchusergithub.presentation.viewmodel.MyViewModel
import br.com.fcr.searchusergithub.presentation.widget.Background

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window,false)
        setContent {
            PesquisarPerfilNoGihubTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Background()
                    Common.navController = rememberNavController()
                    NavHost(navController = Common.navController as NavHostController, startDestination = Screen.Search().route){
                        composable(Screen.Search().route){
                            SearchPage()
                        }
                        composable(Screen.Perfil().route){
                            PerfilPage()
                        }
                    }
                }
            }
        }
    }
}