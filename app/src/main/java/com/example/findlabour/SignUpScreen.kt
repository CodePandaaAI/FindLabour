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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF004aad),
                    titleContentColor = Color.White
                )
            )
        }) { innerPadding ->
        Column(
            modifier = Modifier
                //remove inner padding to not apply the padding from scaffold
                .fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(14.dp))
            // add padding to make it like before and not touching the borders
            Box(modifier = Modifier.padding(innerPadding)) {
                Image(
                    painter = painterResource(R.drawable.circle),
                    contentDescription = "Login",
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(180.dp)
                )
                Image(
                    painter = painterResource(R.drawable.signup),
                    contentDescription = "Greeting",
                    alignment = Alignment.Center,
                    modifier = Modifier.size(180.dp)
                )
                Spacer(modifier = Modifier.height(14.dp))
            }
            Text(
                "Create an Account",
                fontSize = MaterialTheme.typography.headlineLarge.fontSize,
            )
            val state = rememberScrollState()
            Column(
                modifier = Modifier.verticalScroll(state),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(14.dp))
                InputButton("Name")

                Spacer(modifier = Modifier.height(14.dp))
                InputButton("Phone Number")

                Spacer(modifier = Modifier.height(14.dp))
                InputButton("Email")

                Spacer(modifier = Modifier.height(14.dp))
                InputButton("Password")

                Spacer(modifier = Modifier.height(14.dp))

                Button(
                    onClick = {},
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(48.dp)
                        .padding(horizontal = 40.dp),
                    colors = ButtonDefaults.buttonColors(Color(0xFF004aad))
                ) {
                    Text("Sign Up", fontSize = 20.sp)
                }
            }
        }
    }
}


@Composable
private fun InputButton(title: String) {
    var inputText by remember { mutableStateOf("") }
    Text(
        text = title,
        fontSize = 20.sp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 40.dp),
    )
    Spacer(Modifier.height(16.dp))
    OutlinedTextField(
        value = inputText,
        onValueChange = {inputText = it},
        shape = CircleShape,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 40.dp)
    )
}

@Preview(showBackground = true, showSystemUi = true, device = Devices.PIXEL_7_PRO)
@Composable
fun SignUpScreenPreview() {
    SignUpScreen()
}