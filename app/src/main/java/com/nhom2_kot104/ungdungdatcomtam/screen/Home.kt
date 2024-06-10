package com.nhom2_kot104.ungdungdatcomtam.screen

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
        },
        modifier = Modifier
            .fillMaxSize()
            .safeDrawingPadding()
    ) {
        HomeContent(paddingValues = it)
    }
}

@Composable
fun HomeContent(paddingValues: PaddingValues) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(color = Color("#252121".toColorInt())),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .height(70.dp),
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
            OrderItem(
                orderId = "CTE22E",
                amount = "162.000 đ",
                status = "Từ chối"
            )
            OrderItem(
                orderId = "CTE22E06",
                amount = "157.000 đ",
                status = "Từ chối"
            )
            OrderItem(
                orderId = "CTE22E3E",
                amount = "160.000 đ",
                status = "Chấp nhận"
            )
            OrderItem(
                orderId = "CTE22E",
                amount = "160.000 đ",
                status = "Chấp nhận"
            )
            Spacer (modifier = Modifier.weight(1f))
        }
    }
}

@Composable
fun OrderItem( orderId: String, amount: String, status: String) {
    var isExpanded by remember { mutableStateOf(false) }
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
            .clickable {
                isExpanded = !isExpanded
            }
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
        AnimatedVisibility(visible = isExpanded) {

            Column {
                // Thông tin chi tiết đơn hàng
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 15.dp),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        modifier = Modifier
                            .clip(RoundedCornerShape(10.dp))
                            .width(140.dp)
                            .height(40.dp)
                            .background(color = Color("#2F2D2D".toColorInt()))
                        ,
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(text = "Xác nhận", color = Color.White, fontSize = 18.sp)
                    }
                    Row(
                        modifier = Modifier
                            .clip(RoundedCornerShape(10.dp))
                            .width(140.dp)
                            .height(40.dp)
                            .background(color = Color("#2F2D2D".toColorInt()))
                        ,
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(text = "Hủy", color = Color.White, fontSize =18.sp)
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
                FoodSection("Món chính", listOf(
                    FoodItem("Sườn lợn", "58K", 2),
                    FoodItem("Bò chả", "78K", 1),
                    FoodItem("Bò thường", "25K", 1)
                ))
                Spacer(modifier = Modifier.height(6.dp))
                Divider(modifier = Modifier.height(2.dp), color = Color("#8B898A".toColorInt()))
                Spacer(modifier = Modifier.height(6.dp))
                FoodSection("Món thêm", listOf(
                    FoodItem("Sườn", "10K", 1),
                    FoodItem("Sườn mỡ", "10K", 1),
                    FoodItem("Trứng", "5K", 1)
                ))
                Spacer(modifier = Modifier.height(6.dp))
                Divider(modifier = Modifier.height(2.dp), color = Color("#8B898A".toColorInt()))
                Spacer(modifier = Modifier.height(6.dp))
                FoodSection("Topping", listOf(
                    FoodItem("Hành khô", "Free", 1),
                    FoodItem("Tóp mỡ", "Free", 1)
                ))
                Spacer(modifier = Modifier.height(6.dp))
                Divider(modifier = Modifier.height(2.dp), color = Color("#8B898A".toColorInt()))
                Spacer(modifier = Modifier.height(6.dp))
                FoodSection("Khác", listOf(
                    FoodItem("Khăn lạnh", "2K", 1),
                    FoodItem("Khăn giấy", "Free", 1)
                ))
                Spacer(modifier = Modifier.height(6.dp))
                Divider(modifier = Modifier.height(2.dp), color = Color.White)
                Spacer(modifier = Modifier.height(6.dp))

                OrderSummary()
            }
        }
    }
}
@Composable
fun FoodSection(title: String, items: List<FoodItem>) {
    Column {
        Text(text = title, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 18.sp)
        Spacer(modifier = Modifier.height(8.dp))
        items.forEach { item ->
            FoodItemRow(item)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun FoodItemRow(item: FoodItem) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF2F2F2F), RoundedCornerShape(8.dp))
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.food_placeholder), // Replace with your image resource
            contentDescription = null,
            modifier = Modifier.size(48.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(text = item.name, color = Color.White)
            Text(text = item.price, color = Color.Gray, fontSize = 12.sp)
        }
        Text(text = item.quantity.toString(), color = Color.White, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun OrderSummary() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF2F2F2F), RoundedCornerShape(8.dp))
            .padding(16.dp)
    ) {
        Text(text = "Số nhà: 54", color = Color.White)
        Text(text = "Đường: 14", color = Color.White)
        Text(text = "Phường: Đông Hưng Thuận", color = Color.White)
        Text(text = "Quận: 12", color = Color.White)
        Text(text = "Thành phố: Hồ Chí Minh", color = Color.White)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Giờ: 19h59p", color = Color.White)
        Text(text = "SĐT: 0866706364", color = Color.White)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Tổng số lượng món ăn: 4", color = Color.White)
        Text(text = "Tổng số lượng món ăn thêm: 3", color = Color.White)
        Text(text = "Tổng số lượng toppings: 2", color = Color.White)
        Text(text = "Tổng số lượng khác: 2", color = Color.White)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Tổng tiền: 133K", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 18.sp)
    }
}

data class FoodItem(val name: String, val price: String, val quantity: Int)

@Preview(showSystemUi = true, showBackground = true, device = "id:pixel_6_pro")
@Composable
fun previewHome() {
    val navController = rememberNavController()
    HomeAdminScreen(navController)
}
