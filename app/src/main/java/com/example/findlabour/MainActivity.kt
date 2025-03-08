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
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF004aad),
                    titleContentColor = Color.White
                )
            )
        }) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding), // Apply padding here
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(14.dp))
            Box {
                Image(
                    painter = painterResource(R.drawable.circle),
                    contentDescription = "Login",
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(180.dp)
                )
                Image(
                    painter = painterResource(R.drawable.welcome),
                    contentDescription = "Greeting",
                    modifier = Modifier.size(180.dp)
                )
            }
            ChoosingButton(navController, stringResource(R.string.find))
            ChoosingButton(navController, stringResource(R.string.become_manager))
            ChoosingButton(navController, stringResource(R.string.work_as_labour))
        }
    }
}

@Composable
private fun ChoosingButton(navController: NavHostController, brief: String) {
    Spacer(modifier = Modifier.height(14.dp))
    OutlinedButton(
        onClick = {
            // Navigate to the "login" screen
            navController.navigate("signup")
        }, modifier = Modifier
            .fillMaxWidth()
            .size(48.dp)
            .padding(horizontal = 40.dp)
    ) {
        Text(brief)
    }
    Spacer(modifier = Modifier.height(8.dp))
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