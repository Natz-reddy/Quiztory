package com.example.quiztory

import android.content.Intent
import android.os.Bundle
import android.widget.GridLayout
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf

import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.AbsoluteAlignment
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
//retrieves data passed from the other screens
            val score = intent.getIntExtra("score", 0)//score = 0
            val total = intent.getIntExtra("total", 5)
            val answers = intent.getBooleanArrayExtra("answers")?: BooleanArray(0)
            val questions = intent.getStringArrayExtra("questions")?: arrayOf()
            val userAnswers = intent.getBooleanArrayExtra("userAnswers")?: booleanArrayOf()
            val correctAnswers = intent.getBooleanArrayExtra("correctAnswers") ?: booleanArrayOf()
            var showAnswers by remember { mutableStateOf(false) }//toggles the review section
            var instructions by remember { mutableStateOf(false) }//toggles the help / instructions text

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
                        .verticalScroll(rememberScrollState())
                ) {

                    Text(
                        text = "Quiz Completed",
                        fontSize = 40.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        "You scored $score out of $total  ",//displays the score count out of the total amount of questions
                        fontSize = 25.sp
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = if (score >= 3) "Great job " else//if the score is less than 3 is greta job else keep trying
                            "Keep practicing",
                        fontSize = 30.sp,
                        color = if (score >= 3) Color(0xFF7DB927) else Color(0xFFF33424)//green is for great job else red is fro keep trying
                    )

                    Spacer(modifier = Modifier.height(24.dp))
//review answers button
                    Button(
                        onClick = {
                            showAnswers = !showAnswers

                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFEAD662),
                            contentColor = Color.White
                        )

                    ) {
                        Text(text = if (showAnswers) " Hide answers" else " Review answers")//if not clicked hide else show the answers and questions
                    }
                    Spacer(modifier = Modifier.height(16.dp))


                    if (showAnswers) {//show user's answers with question review if toggled on
                        Column(
                            modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp)
                        ) {
                            for (i in questions.indices) {


                                Text(
                                    text = questions[i],//displays questions while keeping a count
                                    fontSize = 16.sp
                                )
                                Spacer(modifier = Modifier.height(4.dp))

                                val userAns =
                                    if (userAnswers.getOrNull(i) == true) "True" else "False"//displays users answer and if correct or not
                                val isCorrect =
                                    userAnswers.getOrNull(i) == correctAnswers.getOrNull(i)

                                Text(
                                    text = "Your answer: $userAns",//your answer and rhe variable that stores the answer
                                    color = if (isCorrect) Color.Green else Color.Red,//changes color depending on answer
                                    fontSize = 16.sp
                                )


                            }


                        }

                    }
                    Spacer(modifier = Modifier.height(10.dp))

                    Button(
                        onClick = {
                            val playagain = Intent(this@Score, History2::class.java)//variable to play again
                            startActivity(playagain)
                            finish()
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFFF9800),
                            contentColor = Color.White
                        )
                    ) {
                        Text(text = "Play again")
                    }

                    Spacer(modifier = Modifier.height(16.dp))


                    Button(
                        onClick = {
                            finishAffinity()
                        }, colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFDA3829),
                            contentColor = Color.White
                        )
                    ) {
                        Text("Exit")
                    }
                    Spacer(modifier = Modifier.height(70.dp))


                        Button(
                            onClick =
                                { instructions = !instructions },//stores the instructtions
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFF5DA7AD),
                                contentColor = Color.White
                            ), modifier = Modifier.width(80.dp).align(AbsoluteAlignment.Right)

                        ) {
                            Text(
                                text = if (instructions) " Close " else "Help? ",
                                fontSize = 8.sp,
                                fontWeight = FontWeight.W900,
                                fontFamily = FontFamily.Serif
                            )

                        }

                        if (instructions) {
                            Text(
                                text = " In this screen press review to see your answers along with the questions " +
                                        "If the answer is colored red than that is the wrong you got wrong, if it is green you have got it correct" +
                                        "Play again to do the quiz again and exit to go out of the app "
                            )



                    }
                }




                }


            }
        }
    }

