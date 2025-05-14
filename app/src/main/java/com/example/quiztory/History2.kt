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

            val quiz_questions = arrayOf(
                "Nelson Mandela was imprisoned for 27 years before becoming South Africa's first Black president",
                "The Great Trek was a movement of Afrikaans-speaking settlers into the interior of South Africa to escape British rule in the 1830s.",
                "The Soweto Uprising of 1976 was a protest against the forced teaching of Afrikaans in Black schools",
                "The Union of South Africa was formed in 1910, uniting the British Cape Colony and the Boer Republics under British rule.",
                "The Anglo-Zulu War (1879) ended with a decisive Zulu victory, preventing British colonization of Natal."

            )

            val answers = booleanArrayOf(
                false, true, true, true, false, true
            )

            var questioncount by remember { mutableStateOf(0) }
            var isCorrect by remember { mutableStateOf("") }
            var score by remember { mutableStateOf(0) }
            var scorescreen by remember { mutableStateOf(false) }
            var reviewscreen by remember { mutableStateOf(false) }




                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFFFB252)
                )
                {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Top,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp)

                    )
                    {
                        Text(
                            text = " Choose the correct answer ",
                            fontSize = 55.sp,
                            fontWeight = FontWeight.ExtraBold,
                            fontFamily = FontFamily.SansSerif,
                            color = Color(0xFF000000),
                            textAlign = TextAlign.Center
                        )

                        Spacer(modifier = Modifier.height(60.dp))


                        OutlinedTextField(
                            value = "", onValueChange = {},
                            enabled = false,
                            placeholder = {
                                Column(horizontalAlignment = Alignment.CenterHorizontally)
                                {
                                    Text(
                                        text = quiz_questions[questioncount],
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.Bold,
                                        textAlign = TextAlign.Center,
                                        color = Color.Black
                                    )
                                }


                            },
                            modifier = Modifier
                                .width(3500.dp)
                                .height(150.dp)
                                .padding(horizontal = 10.dp),
                            colors = TextFieldDefaults.colors(
                                focusedIndicatorColor = Color.White,
                                unfocusedIndicatorColor = Color.White
                            )
                        )



                        Spacer(modifier = Modifier.height(40.dp))

                        Row {
                            Button(
                                onClick = {
                                    if (answers[questioncount]) {
                                        isCorrect = "Correct"
                                        score++
                                    } else {
                                        isCorrect = "Incorrect"
                                    }


                                },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(0xFF070706),
                                    contentColor = Color.White
                                )
                            ) {
                                Text(text = "True")
                            }

                            Spacer(modifier = Modifier.width(30.dp))

                            Button(
                                onClick = {
                                    if (!answers[questioncount]) {
                                        isCorrect = "Correct"
                                        score++
                                    } else {

                                        isCorrect = "Incorrect"
                                    }

                                },

                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(0xFF000000),
                                    contentColor = Color.White
                                )
                            ) {
                                Text(text = "False")
                            }


                        }

                        Spacer(modifier = Modifier.height(15.dp))

                        Text(
                            text = isCorrect,
                            fontSize = 30.sp,
                            fontWeight = FontWeight.ExtraBold,
                            fontFamily = FontFamily.SansSerif,
                            textAlign = TextAlign.Center,
                            color = if (isCorrect == "Correct") Color.Green
                            else
                                Color.Red
                        )

                        Button(onClick = {
                            if (questioncount < quiz_questions.size - 1) {
                                questioncount++
                                isCorrect = ""
                            } else {
                                val score1 = Intent(this@History2, Score::class.java)
                                score1.putExtra("score", score)
                                startActivity(score1)
                                finish()
                            }
                        }) {

                            Text(text = "Next Question")
                        }

                    }

                }
            }
        }
    }

