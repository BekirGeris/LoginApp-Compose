package com.example.loginappcompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.loginappcompose.ui.theme.LoginAppComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginAppComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Page()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Page() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.primary
    ) {
        val tfUserName = remember { mutableStateOf("") }
        val tfPassword = remember { mutableStateOf("") }
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.img),
                contentDescription = "",
                Modifier.size(200.dp)
            )

            TextField(
                value = tfUserName.value,
                onValueChange = { tfUserName.value = it },
                label = { Text(text = "User Name") },
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Color.Black,
                    containerColor = Color.White,
                    focusedIndicatorColor = Color.Red
                )
            )

            TextField(
                value = tfPassword.value,
                onValueChange = { tfPassword.value = it },
                label = { Text(text = "Password") },
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Color.Black,
                    containerColor = Color.White,
                    focusedIndicatorColor = Color.Red
                )
            )

            Button(
                onClick = { Log.d("bekbek", "Giriş Yapıldı") },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Red,
                    contentColor = Color.White
                ),
                modifier = Modifier.size(250.dp, 50.dp)
            ) {
                Text(text = "Login")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LoginAppComposeTheme {
        Page()
    }
}