package com.nhom2_kot104.ungdungdatcomtam.screen

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.nhom2_kot104.ungdungdatcomtam.BottomNavigationBar
import com.nhom2_kot104.ungdungdatcomtam.ui.theme.UngDungDatComTamTheme

data class Order(
    val status: String,
    val date: String,
    val time: String,
    val items: String,
    val price: String
)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun OrderHistoryScreen(orders: List<Order>,navController: NavHostController) {
    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController = navController)
        },
        modifier = Modifier.fillMaxSize()
            .safeDrawingPadding()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color("#000000".toColorInt()))

        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color("#252121".toColorInt()))
                    .height(80.dp),
                contentAlignment = Alignment.Center
            ) {
                Text("Lịch sử", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            }

            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .padding(16.dp)
            ) {
                items(orders) { order ->
                    OrderItem(order)
                }
            }


        }
    }
}

@Composable
fun OrderItem(order: Order) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color("#2F2D2D".toColorInt()))

    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(0.9f),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(
                    order.status,
                    color = if (order.status.contains("bị huỷ")) Color.Red else Color.Green,
                    fontWeight = FontWeight.Bold
                )
                Text(order.items, color = Color.White)
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(0.9f),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Text("${order.date} ${order.time}", color = Color.White)
                Text(order.price, color = Color.White)
            }
        }
    }
}





@Preview(showSystemUi = true, showBackground = true, device = "id:pixel_6_pro")
@Composable
fun PreviewOrderHistory() {
    val orders = listOf(
        Order("Đơn hàng đã chấp nhận", "10/03/2023", "9:20", "3 món", "98k"),
        Order("Đơn hàng đã bị huỷ", "10/03/2023", "9:20", "3 món", "98k"),
        Order("Đơn hàng đã bị huỷ", "10/03/2023", "9:20", "3 món", "98k"),
        Order("Đơn hàng đã được giao", "10/03/2023", "9:20", "3 món", "98k"),
        Order("Đơn hàng đã được giao", "10/03/2023", "9:20", "3 món", "98k"),
        Order("Đơn hàng đã được giao", "10/03/2023", "9:20", "3 món", "98k")
    )
    val navController = rememberNavController()
    OrderHistoryScreen(orders,navController )
}