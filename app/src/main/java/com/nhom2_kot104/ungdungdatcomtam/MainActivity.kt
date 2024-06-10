package com.nhom2_kot104.ungdungdatcomtam

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.nhom2_kot104.ungdungdatcomtam.screen.AddCategory
import com.nhom2_kot104.ungdungdatcomtam.screen.CatergoryScreen
import com.nhom2_kot104.ungdungdatcomtam.screen.DeleteCategory
import com.nhom2_kot104.ungdungdatcomtam.screen.EditImage
import com.nhom2_kot104.ungdungdatcomtam.screen.EditProfile
import com.nhom2_kot104.ungdungdatcomtam.screen.HoTro
import com.nhom2_kot104.ungdungdatcomtam.screen.HomeAdminScreen
import com.nhom2_kot104.ungdungdatcomtam.screen.LoginScree
import com.nhom2_kot104.ungdungdatcomtam.screen.LoginScreen
import com.nhom2_kot104.ungdungdatcomtam.screen.ManagerMain
import com.nhom2_kot104.ungdungdatcomtam.screen.ManagerScreen
import com.nhom2_kot104.ungdungdatcomtam.screen.Order
import com.nhom2_kot104.ungdungdatcomtam.screen.OrderHistoryScreen
import com.nhom2_kot104.ungdungdatcomtam.screen.ProfileScreen
import com.nhom2_kot104.ungdungdatcomtam.screen.UpdateCategory
import com.nhom2_kot104.ungdungdatcomtam.screen.UpdateEditCategory
import com.nhom2_kot104.ungdungdatcomtam.screen.UpdateEditMonAn
import com.nhom2_kot104.ungdungdatcomtam.screen.WelcomeScreen

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            val orders = listOf(
                Order("Đơn hàng đã chấp nhận", "10/03/2023", "9:20", "3 món", "98k"),
                Order("Đơn hàng đã bị huỷ", "10/03/2023", "9:20", "3 món", "98k"),
                Order("Đơn hàng đã bị huỷ", "10/03/2023", "9:20", "3 món", "98k"),
                Order("Đơn hàng đã được giao", "10/03/2023", "9:20", "3 món", "98k"),
                Order("Đơn hàng đã được giao", "10/03/2023", "9:20", "3 món", "98k"),
                Order("Đơn hàng đã được giao", "10/03/2023", "9:20", "3 món", "98k")
            )
            Scaffold() {
                NavHost(navController = navController, startDestination = "welcome") {
                    composable("welcome") { WelcomeScreen(navController = navController) }
                    composable("home") { HomeAdminScreen(navController = navController) }
                    composable("history") {
                        OrderHistoryScreen(
                            orders = orders,
                            navController = navController
                        )
                    }
                    composable("login") { LoginScree(navController = navController) }
                    composable("profile") { ProfileScreen(navController = navController) }
                    composable("managers") { ManagerScreen(navController = navController) }
                    composable("register") { LoginScreen(navController = navController) }
                    composable("mn_category") { CatergoryScreen(navController = navController) }
                    composable("mn_main") { ManagerMain(navController = navController) }
                    composable("support") { HoTro(navController = navController) }
                    composable("edit_pro") { EditProfile(navController = navController) }
                    composable("edit_image") { EditImage(navController = navController) }
                    composable("add_cate") { AddCategory(navController = navController) }
                    composable("update_cate") { UpdateCategory(navController = navController) }
                    composable("del_cate") { DeleteCategory(navController = navController) }
                    composable("add_monan") { AddMonAnScreen(navController = navController) }
                    composable("update_monan") { UpdateMonAnScreen(navController = navController) }
                    composable("del_monan") { DeleteMonAnScreen(navController = navController) }
                    composable(
                        "edit_category/{categoryId}",
                        arguments = listOf(navArgument("categoryId") { type = NavType.IntType })
                    ) { backStackEntry ->
                        val categoryId = backStackEntry.arguments?.getInt("categoryId") ?: -1
                        UpdateEditCategory(navController = navController, categoryId = categoryId)
                    }
                    composable(
                        "edit_monan/{dishId}",
                        arguments = listOf(navArgument("dishId") { type = NavType.IntType })
                    ) { backStackEntry ->
                        val dishId = backStackEntry.arguments?.getInt("dishId") ?: -1
                        UpdateEditMonAn(navController = navController, dishId = dishId)
                    }
                }
            }
        }
    }
}


sealed class BottomNavItem(val route: String, val title: String, @DrawableRes val icon: Int) {
    object Home : BottomNavItem("home", "Home", R.drawable.ic_home)
    object History : BottomNavItem("history", "History", R.drawable.ic_ls)
    object Managers : BottomNavItem("managers", "Managers", R.drawable.ic_ql)
    object Profile : BottomNavItem("support", "Profile", R.drawable.ic_per)
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.History,
        BottomNavItem.Managers,
        BottomNavItem.Profile
    )

    NavigationBar(containerColor = Color("#312C2C".toColorInt())) {
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
                    selectedIconColor = Color("#FFB703".toColorInt()),
                    unselectedIconColor = Color.Gray,
                    indicatorColor = Color("#312C2C".toColorInt())
                )
            )
        }
    }
}
