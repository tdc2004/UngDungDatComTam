package com.nhom2_kot104.ungdungdatcomtam.screen

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.nhom2_kot104.ungdungdatcomtam.BottomNavItem
import com.nhom2_kot104.ungdungdatcomtam.BottomNavigationBar
import com.nhom2_kot104.ungdungdatcomtam.R

@Composable
fun HomeAdminScreen(navController: NavHostController) {
    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController = navController)
        }
    ) {
        HomeContent(paddingValues = it)
    }
}

    @Composable
    fun HomeContent(paddingValues: PaddingValues){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color("#252121".toColorInt())),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .height(80.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo), // Thay đổi thành tài nguyên hình ảnh của bạn
                    contentDescription = "Profile Image",
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Cum tấm dim",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
                Spacer(modifier = Modifier.weight(1f))
                Image(
                    painter = painterResource(id = R.drawable.ic_notifi),
                    contentDescription = "Notification Icon",
                    modifier = Modifier.size(25.dp)
                )
            }
            Divider(modifier = Modifier.height(3.dp), color = Color.Black)
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Today: 19-05-2023\nSố lượng đơn: 2\nDoanh thu: 320.000 đ",
                    color = Color.White,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                OrderItem(orderId = "CTE22E", amount = "162.000 đ", status = "Từ chối")
                OrderItem(orderId = "CTE22E06", amount = "157.000 đ", status = "Từ chối")
                OrderItem(orderId = "CTE22E3E", amount = "160.000 đ", status = "Chấp nhận")
                OrderItem(orderId = "CTE22E", amount = "160.000 đ", status = "Chấp nhận")
                Spacer(modifier = Modifier.weight(1f))
            }
        }
    }

@Composable
fun OrderItem(orderId: String, amount: String, status: String) {
    val statusColor = when (status) {
        "Từ chối" -> Color.Red
        "Chấp nhận" -> Color.Green
        else -> Color.Gray
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .background(Color.DarkGray, shape = RoundedCornerShape(8.dp))
            .padding(16.dp)
    ) {
        Text(
            text = "Đơn hàng $orderId",
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(4.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = amount, color = Color.White, fontSize = 16.sp)
            Spacer(modifier = Modifier.weight(1f))
            Text(text = status, color = statusColor, fontSize = 16.sp, fontWeight = FontWeight.Bold)
        }
    }
}



@Composable
fun BottomNavigationItem(iconId: Int, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(
            painter = painterResource(id = iconId),
            contentDescription = label,
            modifier = Modifier.size(24.dp),
            tint = Color.White
        )
        Text(text = label, color = Color.White, fontSize = 12.sp)
    }
}

@Preview(showSystemUi = true, showBackground = true, device = "id:pixel_6_pro")
@Composable
fun previewHome() {
    val navController = rememberNavController()
    HomeAdminScreen(navController)
}
