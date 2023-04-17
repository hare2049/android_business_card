package com.example.businesscard

import android.media.Image
import androidx.compose.foundation.Image
import android.media.TimedText
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Main()
                }
            }
        }
    }
}

@Composable
fun Contact(image: Painter, text: String, modifier: Modifier = Modifier) {
    Row(modifier.fillMaxWidth().padding(start = 80.dp)) {
        Icon(
           painter = image,
           contentDescription = null,
            modifier = Modifier
                .height(32.dp)
                .width(32.dp)
        )
        Text(
            text = text,
            color = Color(0xFF3ddc84),
            modifier = modifier.padding(start = 15.dp)
        )
    }
}

@Composable
fun FirstSection(image: Painter, name: String, title: String, modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .height(128.dp)
                .width(128.dp)
        )
        Text(
            text = name,
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp,
            color = Color.White
        )
        Text(
            text = title,
            color = Color(0xFF3ddc84),
            fontSize = 24.sp
        )
    }
}

@Composable
fun SecondSection(modifier: Modifier = Modifier) {
    Column(modifier = Modifier.fillMaxWidth(),horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Bottom) {
        var image = painterResource(R.drawable.android_logo)
        Contact(image = image, text = "+387 63 763 307", modifier = modifier)
        Contact(image = image, text = "@hare2049", modifier = modifier)
        Contact(image = image, text = "harun.hadzic44@gmail.com", modifier = modifier)
    }
}

@Composable
fun Main(modifier: Modifier = Modifier) {
    Column(modifier = Modifier.fillMaxSize().background(Color(0xFF12202D))) {
        val image = painterResource(R.drawable.android_logo)
        FirstSection(image = image, name = "Harun Hadžić", title = "Student", modifier = modifier.weight(1f))
        SecondSection(modifier = modifier)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BusinessCardTheme {
        Main()
    }
}