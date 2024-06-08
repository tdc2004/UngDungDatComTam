package com.nhom2_kot104.ungdungdatcomtam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.nhom2_kot104.ungdungdatcomtam.screen.HomeContent
import com.nhom2_kot104.ungdungdatcomtam.screen.LoginScreen
import com.nhom2_kot104.ungdungdatcomtam.ui.theme.UngDungDatComTamTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UngDungDatComTamTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HomeContent(innerPadding)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    UngDungDatComTamTheme {
        Greeting("Android")
    }
}

sealed class BottomNavItem(val route: String, val title: String, @DrawableRes val icon: Int) {
    object Home : BottomNavItem("home", "Home", R.drawable.ic_home)
    object Favorites : BottomNavItem("favorites", "Favorites", R.drawable.ic_ls)
    object Notification : BottomNavItem("profile", "Profile", R.drawable.ic_ql)
    object Profile : BottomNavItem("profile", "Profile", R.drawable.ic_per)
}
