package com.example.ArtSpace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ArtSpace.ui.theme.LoginAppTheme
import com.example.loginapp.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginAppTheme {

            }
        }
    }
}

@Composable
fun ImageGalleryLayout() {
    val img1 = R.drawable.img1
    val img2 = R.drawable.img2
    val img3 = R.drawable.img3
    val img4 = R.drawable.img4

    var currentImg by remember{
        mutableStateOf(img1)
    }
    
    Column (modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        ){
        currentImage(imgResource = currentImg)

        Spacer(modifier = Modifier.padding(bottom = 32.dp))

        Row (modifier = Modifier.padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally)){
            Button(onClick = {
                    when(currentImg){
                        img1 -> currentImg = img4
                        img2 -> currentImg = img1
                        img3 -> currentImg = img2
                        else -> currentImg = img3
                    }
                }) {
                Text(text = "Backward")
            }

            Button(onClick = {
                     when(currentImg){
                        img1 -> currentImg = img2
                        img2 -> currentImg = img3
                        img3 -> currentImg = img4
                        else -> currentImg = img1
                     }
                 }) {
                Text(text = "Forward")
            }
        }
    }
}


@Composable
fun currentImage(modifier: Modifier = Modifier ,imgResource: Int) {
    Image(modifier = modifier.fillMaxWidth(),
        painter = painterResource(imgResource),
        contentDescription = "No des",
        contentScale = ContentScale.FillWidth)
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    LoginAppTheme {
        ImageGalleryLayout()
    }
}
