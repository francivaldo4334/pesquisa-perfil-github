package br.com.fcr.searchusergithub.presentation.widget

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun Background(){
    val colorCircle = 0x74D9D9D9
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = Brush.linearGradient(
                colors = listOf(
                    Color(0xff8F00FF),
                    Color(0xff0038FF),
                )
            ))
    ){
        Canvas(
            modifier = Modifier
                .fillMaxSize()
        ){
            drawCircle(
                color = Color(colorCircle),
                radius = 205f,
                center = Offset(-57f + (204/2),-2f+(204/2))
            )
            drawCircle(
                color = Color(colorCircle),
                radius = 158f,
                center = Offset(-57f + (158/2),-25f + (158/2))
            )
            drawCircle(
                color = Color(colorCircle),
                radius = 156f,
                center = Offset(1063f,600f)
            )
        }
    }
}