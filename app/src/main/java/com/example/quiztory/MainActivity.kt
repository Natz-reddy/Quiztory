package com.example.quiztory

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.contextaware.ContextAwareHelper
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
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

            var description by remember { mutableStateOf("") }//stores the app description
            var instructions by remember { mutableStateOf(false) }//stores the instructions description

// the background image
            Box(
                modifier = Modifier.fillMaxSize()
            ){
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_foreground1),
                    contentDescription ="",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier.fillMaxSize()//fills the whole screen
                )
            }



            Surface(modifier = Modifier.fillMaxSize(),
                color= Color(0x79FFB252)//a semi transparent colour to go over the image
            )
            {
                Column (//main layout
                    horizontalAlignment = Alignment.CenterHorizontally,//everything becomes centered
                    verticalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)

                )

                {
                   Spacer(modifier = Modifier.height(220.dp))//adds spacing between functions

                    

                    OutlinedTextField(value = "", onValueChange ={ },//textfield to hold the description
                        enabled = false,//user cant change the description
                        placeholder = {
                            Column(horizontalAlignment = Alignment.CenterHorizontally)
                            {



                            Text(text = "Welcome To Quiztory",
                                color = Color(0xFFEA9610),
                                fontSize = 20.sp,
                                fontFamily = FontFamily.SansSerif,
                                textAlign = TextAlign.Center)

                            Spacer(modifier = Modifier.height(4.dp))

                            Text(text = " Put your knowledge to the test. Answer five history questions , " +
                                    "True/ False about South African History events and figures",
                                color = Color.DarkGray,
                                fontSize = 20.sp,
                                fontFamily = FontFamily.SansSerif,
                                textAlign = TextAlign.Center)
                        }
                                      },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(190.dp)
                            .padding(horizontal = 16.dp),
                        colors = TextFieldDefaults.colors(
                            focusedIndicatorColor = Color.White,
                            unfocusedIndicatorColor = Color.White
                        )
                        )



                    Spacer(modifier = Modifier.height(30.dp))

                    Button(onClick = {//start button to begin the quiz
                        val start = Intent(this@MainActivity, History2::class.java)//create an Intent to navigate from MainActivity to History2 activity and start it
                        startActivity(start)},
                        colors = ButtonDefaults.buttonColors(
                            containerColor =Color(0xFF8FD93A),
                            contentColor = Color.White
                        ),
                       modifier = Modifier
                           .padding(bottom = 50.dp)
                           .width(300.dp)
                           .height(50.dp)


                    ){
                        Text(text = "Start",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.W900,
                            fontFamily = FontFamily.Serif
                        )
                    }
                    Spacer(modifier = Modifier.height(15.dp))

                    Button(onClick =
                        { instructions= !instructions},//toggles the visibility of the instructions text when the Help button is clicked
                        colors = ButtonDefaults.buttonColors(
                        containerColor =Color(0xFF5DA7AD),
                        contentColor = Color.White
                    ),modifier= Modifier.width(80.dp).align(Alignment.End)//aligns the button to the end of the column

                        ){
                        Text(text = if (instructions)" Close " else "Help? ",//if the button is clicked close will show else help? will show
                            fontSize = 8.sp,
                            fontWeight = FontWeight.W900,
                            fontFamily = FontFamily.Serif
                        )

                    }

                    if (instructions){
                        Text(text= "Welcome to Quiztory. " +
                                "How it works?   " +
                                "Begin the flashcrad app by pressing start.  " +
                                "5 true/false questions will appear , answer it by simply pressing whether the statement is true or false.  " +
                                "Press next question when you are done with the previous.   " +
                                "Once you have completed the quiz it will take you to the score screen where you are able to view your score out of 5, you can review , play again,or exit")
                    }
                    }
                }

            }




        }
    }


