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
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
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

            Box(modifier = Modifier.fillMaxSize()) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_foreground1),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier.fillMaxSize().alpha(0.9f)
                )
            }

            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color.Transparent
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
                        val review = Intent(this@Score,Review::class.java)
                        review.putExtra("Questions",arrayOf(
                            "Nelson Mandela was imprisoned for 27 years before becoming South Africa's first Black president",
                            "The Great Trek was a movement of Afrikaans-speaking settlers...",
                            "The Soweto Uprising of 1976 was a protest...",
                            "The Union of South Africa was formed in 1910...",
                            "The Anglo-Zulu War (1879) ended with a decisive Zulu victory..."
                        ))
                        review.putExtra("answers",booleanArrayOf(false, true, true, true, false))
                        startActivity(review)


                    }) {
                        Text(text = "review answers")
                    }

                    Spacer(modifier = Modifier.height(16.dp))

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
