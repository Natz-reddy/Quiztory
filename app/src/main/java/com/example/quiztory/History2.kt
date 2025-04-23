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
                    Text(text="Choose a genre",
                        fontSize = 55.sp,
                        fontWeight = FontWeight.ExtraBold,
                        fontFamily = FontFamily.SansSerif,
                        color = Color(0xFFE7CC6A),
                        textAlign = TextAlign.Center
                    )

Spacer(modifier = Modifier.height(60.dp))

                    OutlinedTextField(value = "", onValueChange ={},
                        enabled = false,
                        placeholder = {
                            Column (
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(text = " Ancient history",
                                    color = Color(0xFFE7CC6A),
                                    fontSize = 20.sp,
                                    fontFamily = FontFamily.SansSerif,
                                    textAlign = TextAlign.Center )

                                Spacer(modifier = Modifier.height(20.dp))

                                Text(text = "description",
                                    color = Color.Gray,
                                    fontSize = 20.sp,
                                    fontFamily = FontFamily.SansSerif,
                                    textAlign = TextAlign.Center )

                            }
                                      },


                                modifier = Modifier
                                .fillMaxWidth()
                            .height(120.dp)
                            .padding(horizontal = 8.dp),
                        colors = TextFieldDefaults.colors(
                            focusedIndicatorColor = Color.White,
                            unfocusedIndicatorColor = Color.White
                        )
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Button(onClick = {
                    val start1 = Intent(this@History2, Theme1::class.java)
                        startActivity(start1) },
                        colors = ButtonDefaults.buttonColors(
                            containerColor =Color(0xFFE7CC6A),
                            contentColor = Color.White
                        ),
                        modifier = Modifier
                            .padding(bottom = 50.dp)
                            .width(300.dp)
                            .height(50.dp)
                    )
                     {
                        Text(text=" Ancient History",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.ExtraBold,
                            fontFamily = FontFamily.SansSerif,
                            textAlign = TextAlign.Center
                        )


                     }

                    Spacer(modifier =Modifier.height(5.dp))


                    OutlinedTextField(value = "", onValueChange ={},
                        enabled = false,
                        placeholder = {
                            Column (
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(text = "South African history",
                                    color = Color(0xFFE7CC6A),
                                    fontSize = 20.sp,
                                    fontFamily = FontFamily.SansSerif,
                                    textAlign = TextAlign.Center )

                                Spacer(modifier = Modifier.height(16.dp))

                                Text(text = "description",
                                    color = Color.Gray,
                                    fontSize = 20.sp,
                                    fontFamily = FontFamily.SansSerif,
                                    textAlign = TextAlign.Center )

                            }
                        },


                        modifier = Modifier
                            .fillMaxWidth()
                            .height(120.dp)
                            .padding(horizontal = 8.dp),
                        colors = TextFieldDefaults.colors(
                            focusedIndicatorColor = Color.White,
                            unfocusedIndicatorColor = Color.White
                        )
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Button(onClick = {
                        val start2 = Intent(this@History2, Theme2::class.java)
                        startActivity(start2) },
                        colors = ButtonDefaults.buttonColors(
                            containerColor =Color(0xFFE7CC6A),
                            contentColor = Color.White
                        ),
                        modifier = Modifier
                            .padding(bottom = 50.dp)
                            .width(300.dp)
                            .height(50.dp)
                    )
                    {
                        Text(text=" South African history ",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.ExtraBold,
                            fontFamily = FontFamily.SansSerif,
                            textAlign = TextAlign.Center
                        )


                    }

                    Spacer(modifier =Modifier.height(5.dp))


                    OutlinedTextField(value = "", onValueChange ={},
                        enabled = false,
                        placeholder = {
                            Column (
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(text = "Greek",
                                    color = Color(0xFFE7CC6A),
                                    fontSize = 20.sp,
                                    fontFamily = FontFamily.SansSerif,
                                    textAlign = TextAlign.Center )

                                Spacer(modifier = Modifier.height(8.dp))

                                Text(text = "description",
                                    color = Color.Gray,
                                    fontSize = 16.sp,
                                    fontFamily = FontFamily.SansSerif,
                                    textAlign = TextAlign.Center )

                            }
                        },


                        modifier = Modifier
                            .fillMaxWidth()
                            .height(120.dp)
                            .padding(horizontal = 8.dp),
                        colors = TextFieldDefaults.colors(
                            focusedIndicatorColor = Color.White,
                            unfocusedIndicatorColor = Color.White
                        )
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Button(onClick = {
                        val start3 = Intent(this@History2, Theme3::class.java)
                        startActivity(start3) },
                        colors = ButtonDefaults.buttonColors(
                            containerColor =Color(0xFFE7CC6A),
                            contentColor = Color.White
                        ),
                        modifier = Modifier
                            .padding(bottom = 50.dp)
                            .width(300.dp)
                            .height(50.dp)
                    )
                    {
                        Text(text=" Greek history ",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.ExtraBold,
                            fontFamily = FontFamily.SansSerif,
                            textAlign = TextAlign.Center
                        )


                    }

                }

            }

        }
    }
}