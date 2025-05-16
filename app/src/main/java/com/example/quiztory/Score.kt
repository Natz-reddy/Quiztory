package com.example.quiztory

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf

import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quiztory.ui.theme.QuiztoryTheme

class Score : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val score = intent.getIntExtra("score", 0)
            val total = intent.getIntExtra("total", 5)
            val answers = intent.getBooleanArrayExtra("answers")?: BooleanArray(0)
            val questions = intent.getStringArrayExtra("questions")?: arrayOf()
            var showAnswers by remember { mutableStateOf(false) }


            Box(modifier = Modifier.fillMaxSize()) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_foreground1),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier.fillMaxSize()
                )
            }

            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color(0xAAFFB252)
            )
            {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ){

                    Text(text= "Quiz Completed",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold)

                    Spacer(modifier = Modifier.height(20.dp))

                    Text("You scored $score out of 5  ",
                        fontSize = 20.sp )

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = if (score>=3)"Great job " else
                        "keep practicing",
                        fontSize = 20.sp,
                        color = if (score >= 3) Color.Green else Color.Red
                    )

Spacer(modifier = Modifier.height(30.dp))

                    Button(onClick = {
                        showAnswers = !showAnswers

                    }) {
                        Text(text = if (showAnswers)" Hide answers" else " Review answers")
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                    if (showAnswers){
                        Text(text = "Nelson mandela")
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(text = "False")

                    }


                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    Button(onClick = {
                        val playagain = Intent(this@Score, History2::class.java)
                        startActivity(playagain)
                        finish()
                    }) {
                        Text(text = "Play again")
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Button(onClick = {
                        finishAffinity()
                    }) {
                        Text("Exit")
                    }

                }


            }
        }
    }
}
