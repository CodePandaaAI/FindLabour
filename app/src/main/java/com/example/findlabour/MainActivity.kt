package com.example.findlabour

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.findlabour.ui.theme.FindLabourTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FindLabourTheme {
                // Create the NavController here
                val navController = rememberNavController()
                // Pass the NavController to the navigation setup
                AppNavigation(navController)
            }
        }
    }
}

@Composable
fun AppNavigation(navController: NavHostController) {
    // set up NavHost here, don't call composable to show any view
    NavHost(navController = navController, startDestination = "welcome") {
        composable("welcome") {
            WelcomeScreen(navController)
        }
        composable("signup") {
            SignUpScreen()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WelcomeScreen(navController: NavHostController) {
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
                .fillMaxSize()
                .padding(innerPadding), // Apply padding here
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box {
                Image(
                    painter = painterResource(R.drawable.circle),
                    contentDescription = "Login",
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(200.dp)
                )
                Image(
                    painter = painterResource(R.drawable.welcome),
                    contentDescription = "Greeting",
                    modifier = Modifier.size(200.dp)
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedButton(onClick = {
                // Navigate to the "login" screen
                navController.navigate("signup")
            }) {
                Text("I am finding Labour \uD83D\uDD0E!")
            }
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedButton(onClick = {
                // Navigate to the "login" screen
                navController.navigate("signup")
            }) {
                Text("I Want to become a Manager \uD83E\uDDD1\u200D\uD83D\uDCBC!")
            }
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedButton(onClick = {
                // Navigate to the "login" screen
                navController.navigate("signup")
            }) {
                Text("I want to Work \uD83D\uDCBC!")
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, device = Devices.PIXEL_7_PRO)
@Composable
fun GreetingPreview() {
    FindLabourTheme {
        // You need to wrap this with navigation for preview to work.
        val navController = rememberNavController()
        AppNavigation(navController)
    }
}