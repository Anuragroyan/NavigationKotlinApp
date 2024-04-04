package com.example.navigationkotlin

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SecondScreen(name: String, navigateToThirdScreen: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "This is the Second Screen",
            fontSize = 24.sp,
            fontFamily = FontFamily.Monospace
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "My name is $name and 27 yrs old and this is second screen",
            fontSize = 10.sp,
            fontFamily = FontFamily.Monospace
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navigateToThirdScreen(name) }) {
            Text(text = "Go to Third Screen",
                fontFamily = FontFamily.Monospace,
                fontSize = 14.sp,
            )
        }
    }
}

@Preview
@Composable
fun SecondScreenPreview(){
    SecondScreen("Anurag",{})
}
