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
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quiztory.ui.theme.QuiztoryTheme

class History2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            data class Question(val text: String, val answer: Boolean)



            val quiz_questions = arrayOf(
                "Nelson Mandela was imprisoned for 27 years before becoming South Africa's first Black president",
                "The Great Trek was a movement of Afrikaans-speaking settlers into the interior of South Africa to escape British rule in the 1830s.",
                "The Soweto Uprising of 1976 was a protest against the forced teaching of Afrikaans in Black schools",
                "The Union of South Africa was formed in 1910, uniting the British Cape Colony and the Boer Republics under British rule.",
                "The Anglo-Zulu War (1879) ended with a decisive Zulu victory, preventing British colonization of Natal."

            )

            val answers = arrayOf(
                false,true,true,true,false
                ,true
            )
            
            var questioncount by remember { mutableStateOf(0) }
            var isCorrect by remember { mutableStateOf<Boolean?>(null) }




            Box( modifier = Modifier.fillMaxSize()){
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
                Column ( horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)

                )
                {
                    Text(text=" Choose the correct answer ",
                        fontSize = 55.sp,
                        fontWeight = FontWeight.ExtraBold,
                        fontFamily = FontFamily.SansSerif,
                        color = Color(0xFFE7CC6A),
                        textAlign = TextAlign.Center
                    )

Spacer(modifier = Modifier.height(60.dp))

                    Row {
                        Button(onClick = {isCorrect= answers[questioncount].}) {
                            Text(text="True")
                        }

                        Button(onClick = {isCorrect= answers[questioncount]}) {
                            Text(text="False")
                    }




                }

            }

        }
    }
}