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
            SignUpTopAppBar()
        }
    ) { innerPadding ->
        SignUpContent(innerPadding)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpTopAppBar() {
    TopAppBar(
        title = {
            Text(
                "Sign Up",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xFF004aad),
            titleContentColor = Color.White
        )
    )
}

@Composable
fun SignUpContent(innerPadding: androidx.compose.foundation.layout.PaddingValues) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(24.dp)) // Increased spacing
        ProfileImageSection()
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            "Create an Account",
            style = MaterialTheme.typography.headlineLarge, // Use style instead of fontSize
        )
        Spacer(modifier = Modifier.height(24.dp))

        val state = rememberScrollState()
        Column(
            modifier = Modifier
                .weight(1f) //take remaining space
                .verticalScroll(state),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val inputFields = listOf("Name", "Phone Number", "Email", "Password")
            inputFields.forEach { title ->
                InputTextField(title = title)
                Spacer(modifier = Modifier.height(16.dp))
            }
            Spacer(modifier = Modifier.height(24.dp))
        }
        SignUpButton()
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
private fun ProfileImageSection() {
    Box(contentAlignment = Alignment.Center) {
        Image(
            painter = painterResource(R.drawable.circle),
            contentDescription = "Profile Background",
            modifier = Modifier
                .clip(CircleShape)
                .size(180.dp)
        )
        Image(
            painter = painterResource(R.drawable.signup),
            contentDescription = "Profile",
            modifier = Modifier.size(120.dp) // Reduced size for visual hierarchy
        )
    }
}

@Composable
private fun InputTextField(title: String) {
    var inputText by remember { mutableStateOf("") }
    Column(modifier = Modifier.fillMaxWidth().padding(horizontal = 40.dp)) {
        Text(
            text = title,
            style = MaterialTheme.typography.bodyMedium, // Use style instead of fontSize
        )
        Spacer(Modifier.height(8.dp)) // Reduced spacing
        OutlinedTextField(
            value = inputText,
            onValueChange = { inputText = it },
            shape = CircleShape,
            modifier = Modifier.fillMaxWidth()
        )
    }

}

@Composable
private fun SignUpButton() {
    Button(
        onClick = { /*  */ },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .padding(horizontal = 40.dp),
        colors = ButtonDefaults.buttonColors(Color(0xFF004aad))
    ) {
        Text("Sign Up", fontSize = 16.sp) // Reduced font size
    }
}

@Preview(showBackground = true, showSystemUi = true, device = Devices.PIXEL_7_PRO)
@Composable
fun SignUpScreenPreview() {
    SignUpScreen()
}