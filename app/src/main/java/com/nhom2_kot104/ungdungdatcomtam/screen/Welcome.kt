package com.nhom2_kot104.ungdungdatcomtam.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.graphics.toColorInt
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.nhom2_kot104.ungdungdatcomtam.R
import kotlinx.coroutines.delay

@Composable
fun WelcomeScreen(navController: NavController){
    LaunchedEffect(Unit) {
        delay(3000)
        navController.navigate("login")
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .safeDrawingPadding()
            .background(color = Color("#282222".toColorInt())),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,

    ) {
        Image(painter = painterResource(id = R.drawable.logo), contentDescription ="", modifier = Modifier.fillMaxSize() )
    }
}
@Preview(showSystemUi = true, showBackground = true, device = "id:pixel_6_pro")
@Composable
fun PreviewWelcome(){
    val navController = rememberNavController()
    WelcomeScreen(navController)
}