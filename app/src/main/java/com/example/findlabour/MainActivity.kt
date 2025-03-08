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
                val navController = rememberNavController()
                AppNavigation(navController)
            }
        }
    }
}

// Define navigation routes as constants
object AppDestinations {
    const val WELCOME = "welcome"
    const val SIGNUP = "signup"
}

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = AppDestinations.WELCOME) {
        composable(AppDestinations.WELCOME) {
            WelcomeScreen(navController)
        }
        composable(AppDestinations.SIGNUP) {
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
                        stringResource(R.string.login_screen), // Use string resource for better i18n
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
                .padding(innerPadding)
                .padding(horizontal = 16.dp), // Add horizontal padding to the column
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(24.dp)) // increased space
            Box {
                Image(
                    painter = painterResource(R.drawable.circle),
                    contentDescription = stringResource(R.string.login),// Use string resource for better a11y
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(180.dp)
                )
                Image(
                    painter = painterResource(R.drawable.welcome),
                    contentDescription = stringResource(R.string.greeting),// Use string resource for better a11y
                    modifier = Modifier.size(180.dp)
                )
            }
            Spacer(modifier = Modifier.height(32.dp)) // Increased space

            val titles = listOf(
                R.string.find,
                R.string.become_manager,
                R.string.work_as_labour
            )
            titles.forEach { titleResId ->
                ChoosingButton(navController, stringResource(titleResId))
            }
        }
    }
}

@Composable
private fun ChoosingButton(navController: NavHostController, brief: String) {
    OutlinedButton(
        onClick = {
            navController.navigate(AppDestinations.SIGNUP)
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp) // Use height instead of size when you want to control just the height.
    ) {
        Text(brief)
    }
    Spacer(modifier = Modifier.height(16.dp)) // Increased spacing
}

@Preview(showBackground = true, showSystemUi = true, device = Devices.PIXEL_7_PRO)
@Composable
fun GreetingPreview() {
    FindLabourTheme {
        val navController = rememberNavController()
        AppNavigation(navController)
    }
}