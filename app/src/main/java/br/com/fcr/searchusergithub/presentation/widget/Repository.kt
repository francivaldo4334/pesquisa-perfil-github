package br.com.fcr.searchusergithub.presentation.widget

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import br.com.fcr.searchusergithub.presentation.model.Repository
import br.com.fcr.searchusergithub.presentation.theme.*

//data class RepositoryItem(val name:String,val language:String,val description:String)
@Composable
fun Repository(item:Repository){
    Card(
        elevation = _8,
        shape = RoundedCornerShape(_8),
        backgroundColor = Color(0xFFF3F3F3),
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = _16, end = _16, bottom = _16)
    ) {
        Column(
            modifier = Modifier
                .padding(_8)
        ) {
            Text(text = "Name:", fontSize = h5)
            Text(text = item.name, fontSize = h2, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.size(_8))
            Text(text = "Language:", fontSize = h5)
            Text(text = item.language, fontSize = h2, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.size(_8))
            Text(text = "Description:", fontSize = h5)
            Text(text = item.description, fontSize = h2, fontWeight = FontWeight.Bold)
        }
    }
}