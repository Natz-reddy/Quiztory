package com.example.quiztory

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quiztory.History2
import com.example.quiztory.ui.theme.QuiztoryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {



            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
                .background(Color(0xFF2E3131))
            ){
                Text(text = "WELCOME",
                    fontSize = 45.sp,// font size
                    fontWeight = FontWeight.W400,
                    fontFamily = FontFamily.Monospace)

                Spacer(modifier = Modifier.height(600.dp))

                Button(onClick = {
                    val start = Intent(this@MainActivity, History2::class.java)
                    startActivity(start)}
                    ){
                    Text(text = "Start",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.W900,
                        fontFamily = FontFamily.Serif
                    )
                }
                 Spacer(modifier = Modifier.height(155.dp))
            }
        }
    }
}

