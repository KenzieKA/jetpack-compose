package kenz.jetpacktumblr.ui.screen.profile

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import kenz.jetpacktumblr.R

@Composable
fun ProfileScreen(navigateBack: () -> Unit) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, top = 30.dp, end = 20.dp)
    ) {
        item {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
            ) {
                IconButton(onClick = navigateBack) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        modifier = Modifier
                            .size(70.dp)
                    )
                }
                Text(
                    text = "About Me",
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                        .weight(1F)
                        .fillMaxWidth()
                )
            }
        }
        item {
            if(LocalConfiguration.current.orientation == Configuration.ORIENTATION_LANDSCAPE){
                Row (Modifier.padding(20.dp), verticalAlignment = Alignment.CenterVertically){
                    ProfilePicture()
                    Profile()
                }
            } else {
                Column(Modifier.padding(20.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                    ProfilePicture()
                    Profile()
                }
            }


        }
    }
}

@Composable
fun ProfilePicture() {
    Image(
        painter = painterResource(
            id = androidx.compose.foundation.layout.R.drawable.ic_launcher_foreground
        ),
        contentDescription = "my_photo",
        alignment = Alignment.Center,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .clip(CircleShape)
            .width(250.dp)
            .height(250.dp)
            .fillMaxHeight()
    )
}

@Composable
fun Profile(){
    Column (Modifier.padding(start = 20.dp, end = 20.dp)){
        Text(text = "Kenzie Kyle Anderson")
        Divider()
        Text(text = "a181dkx4437@bangkit.academy")
    }
}