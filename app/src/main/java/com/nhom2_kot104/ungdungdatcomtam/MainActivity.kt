package com.nhom2_kot104.ungdungdatcomtam

import android.annotation.SuppressLint
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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.nhom2_kot104.ungdungdatcomtam.screen.HomeAdminScreen
import com.nhom2_kot104.ungdungdatcomtam.screen.LoginScree
import com.nhom2_kot104.ungdungdatcomtam.screen.ManagerScreen
import com.nhom2_kot104.ungdungdatcomtam.screen.OrderHistoryScreen
import com.nhom2_kot104.ungdungdatcomtam.screen.WelcomeScreen
import com.nhom2_kot104.ungdungdatcomtam.ui.theme.UngDungDatComTamTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            Scaffold() {
                NavHost(navController = navController, startDestination = "welcome"){
                    composable("welcome") { WelcomeScreen(navController = navController) }
                    composable("home") { HomeAdminScreen(navController = navController) }
                    composable("history") { OrderHistoryScreen(orders = null,navController = navController) }
                    composable("login") { LoginScree(navController = navController) }
                    composable("profile") { WelcomeScreen(navController = navController) }
                    composable("managers") { ManagerScreen(navController = navController) }
                }
            }
        }
    }
}


sealed class BottomNavItem(val route: String, val title: String, @DrawableRes val icon: Int) {
    object Home : BottomNavItem("home", "Home", R.drawable.ic_home)
    object History : BottomNavItem("history", "History", R.drawable.ic_ls)
    object Managers : BottomNavItem("managers", "Managers", R.drawable.ic_ql)
    object Profile : BottomNavItem("profile", "Profile", R.drawable.ic_per)
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.History,
        BottomNavItem.Managers,
        BottomNavItem.Profile
    )

    NavigationBar(containerColor = Color.White) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { screen ->
            NavigationBarItem(
                icon = {
                    Icon(
                        painter = painterResource(id = screen.icon),
                        contentDescription = screen.title,
                        modifier = Modifier.size(24.dp),
                    )
                },
                selected = currentRoute == screen.route,
                onClick = {
                    navController.navigate(screen.route) {
                        launchSingleTop = true
                        restoreState = true
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = colorResource(id = android.R.color.black),
                    unselectedIconColor = Color.Gray,
                )
            )
        }
    }
}
