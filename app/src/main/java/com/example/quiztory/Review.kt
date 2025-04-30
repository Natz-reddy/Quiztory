package com.example.quiztory

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quiztory.ui.theme.QuiztoryTheme

class Review : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val quiz_questions = intent.getStringArrayExtra("questions") ?: arrayOf()
            val answers = intent.getBooleanArrayExtra("answers") ?: booleanArrayOf()

            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ){
                Text(text = "Review answers",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(
                        bottom = 16.dp
                    )
                )

                for (i in quiz_questions.indices){
                    val question = quiz_questions[i]
                    val answer = answers[i]

                    Text(text= "Question Number${i + 1}:$question",
                        fontSize = 20.sp)

                    Text(text = "Answer: ${if (answer) "True" else "False"}",
                        fontSize = 16.sp)

                    Spacer(modifier = Modifier.height(16.dp))
                }
            }





            }
        }
    }
