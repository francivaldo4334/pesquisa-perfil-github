package br.com.fcr.searchusergithub.presentation.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import br.com.fcr.searchusergithub.presentation.model.Repository
import br.com.fcr.searchusergithub.presentation.model.User
import br.com.fcr.searchusergithub.presentation.theme.*
import br.com.fcr.searchusergithub.presentation.viewmodel.MyViewModel
import br.com.fcr.searchusergithub.presentation.widget.Repository
import coil.compose.rememberAsyncImagePainter

@Composable
fun PerfilPage(){
    var user = MyViewModel.responseuser

    val imagePerfil = rememberAsyncImagePainter(model = user.avatar_url)
    val name = user.name
    val _fllowers = user.fllowers
    val _fllowing = user.fllowing
    val _link = user.link
    val repositories = MyViewModel.responserepositories
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = _72)
    ){

        Card(
            shape = RoundedCornerShape(topEnd = _16, topStart = _16),
            backgroundColor = MaterialTheme.colors.background,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = _32)
        ) {
           Column(
               modifier = Modifier
                   .padding(_16)
           ) {
               Spacer(modifier = Modifier.size(_56))
               Text(text = name, fontSize = h2, fontWeight = FontWeight.Bold)
               Spacer(modifier = Modifier.size(_16))
               Card(
                   elevation = _8,
                   shape = RoundedCornerShape(_8),
                   backgroundColor = MaterialTheme.colors.background,
                   modifier = Modifier
                       .fillMaxWidth()
               ) {
                   Row(
                       modifier = Modifier
                           .fillMaxWidth()
                           .padding(_16)
                   ) {
                       Column(
                           horizontalAlignment = Alignment.CenterHorizontally,
                           modifier = Modifier
                               .fillMaxWidth(0.5f)
                       ) {
                           Text(text = "$_fllowers", fontSize = h5)
                           Spacer(modifier = Modifier.size(_8))
                           Text(text = "Fllowers", fontSize = h2, fontWeight = FontWeight.Bold)
                       }
                       Column(
                           horizontalAlignment = Alignment.CenterHorizontally,
                           modifier = Modifier
                               .fillMaxWidth()
                       ) {
                           Text(text = "$_fllowing", fontSize = h5)
                           Spacer(modifier = Modifier.size(_8))
                           Text(text = "Fllowing", fontSize = h2, fontWeight = FontWeight.Bold)
                       }
                   }
               }
               Spacer(modifier = Modifier.size(_16))
               Text(text = "Github link:", fontSize = h5)
               Text(text = "$_link", fontSize = h2, fontWeight = FontWeight.Bold)
               Spacer(modifier = Modifier.size(_16))
               Text(text = "Repositories:", fontSize = h2, fontWeight = FontWeight.Bold)
               Box(modifier = Modifier
                   .fillMaxWidth()
                   .height(2.dp)
                   .background(MaterialTheme.colors.onBackground))
               Spacer(modifier = Modifier.size(_4))
               LazyColumn{
                   items(repositories){
                        Repository(item = it)
                   }
               }

           }
        }
        Box(
            modifier = Modifier
                .padding(start = _16)
        ){
            Image(
                painter = imagePerfil,
                contentDescription = null,
                modifier = Modifier
                    .clip(CircleShape)
                    .size(_72)
                    .background(MaterialTheme.colors.surface)
            )
        }
    }
}