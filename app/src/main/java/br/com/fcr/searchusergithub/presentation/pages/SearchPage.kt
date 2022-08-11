package br.com.fcr.searchusergithub.presentation.pages

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import br.com.fcr.R
import br.com.fcr.searchusergithub.presentation.Common
import br.com.fcr.searchusergithub.presentation.Screen
import br.com.fcr.searchusergithub.presentation.theme.*

@Composable
fun SearchPage(){
    val fillWidth = LocalConfiguration.current.screenWidthDp.dp
    var sizeTextField by remember {
        mutableStateOf(fillWidth)
    }
    val transition = updateTransition(targetState = sizeTextField)
    val size by transition.animateDp () { state ->
        when(state){
            fillWidth -> 0.dp
            else -> fillWidth
        }
    }
    //
    var valueTF by remember {
        mutableStateOf("")
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(_16)
    ){
        Box(
            contentAlignment = Alignment.CenterStart
        ){
            Row(
                modifier = Modifier
                    .width(size)
            ) {
                Spacer(modifier = Modifier.width(_72).height(_56).padding(start = _32).background(MaterialTheme.colors.background))
                TextField(
                    value = valueTF,
                    onValueChange = {valueTF = it},
                    keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                    keyboardActions = KeyboardActions(onSearch = {
                        Common.navController?.navigate(Screen.Perfil().route.replace("search",valueTF))
                    }),
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = MaterialTheme.colors.background,
                        focusedIndicatorColor = Color.Transparent,
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(topEnd = _24, bottomEnd = _24))
                )
            }
            IconButton(
                onClick = {
                    sizeTextField = if(sizeTextField == 0.dp) fillWidth else 0.dp
                },
                modifier = Modifier
                    .size(_72)
                    .clip(CircleShape)
                    .background(MaterialTheme.colors.background)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_search),
                    contentDescription = null
                )
            }
        }
    }
}