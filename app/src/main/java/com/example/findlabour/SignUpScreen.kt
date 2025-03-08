package com.example.findlabour

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Login Screen",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                    )
                })
        }) { innerPadding ->
        Column(
            modifier = Modifier
                //remove inner padding to not apply the padding from scaffold
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // add padding to make it like before and not touching the borders
            Box(modifier = Modifier.padding(innerPadding)) {
                Image(
                    painter = painterResource(R.drawable.circle_with_blue_border),
                    contentDescription = "Login",
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(200.dp)
                )
                Image(
                    painter = painterResource(R.drawable.signup),
                    contentDescription = "Greeting",
                    alignment = Alignment.Center,
                    modifier = Modifier.size(200.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                UserInput()
            }
        }
    }
}

@Composable
fun UserInput() {

}

@Preview
@Composable
fun SignUpScreenPreview() {
    SignUpScreen()
}