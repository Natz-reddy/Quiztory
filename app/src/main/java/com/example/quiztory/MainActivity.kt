package com.example.quiztory

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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

            var description by remember { mutableStateOf("") }


            Box(
                modifier = Modifier.fillMaxSize()
            ){
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_foreground1),
                    contentDescription ="",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier.fillMaxSize()
                )
            }



            Surface(modifier = Modifier.fillMaxSize(),
                color= Color(0x79FFB252)
            )
            {
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)

                )

                {
                   Spacer(modifier = Modifier.height(90.dp))

                    
                  Spacer(modifier = Modifier.height(5.dp))

                    OutlinedTextField(value = "", onValueChange ={ },
                        enabled = false,
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
                                    "True/ False about the world history events and figures",
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



                    Spacer(modifier = Modifier.height(50.dp))

                    Button(onClick = {
                        val start = Intent(this@MainActivity, History2::class.java)
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
                    Spacer(modifier = Modifier.height(35.dp))
                }

            }




        }
    }
}

