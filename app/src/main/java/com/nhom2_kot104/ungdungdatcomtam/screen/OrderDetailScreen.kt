package com.nhom2_kot104.ungdungdatcomtam.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun OrderDetailScreen(orderId: String?) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray)
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Chi tiết đơn hàng",
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(16.dp))
            orderId?.let {
                Text(
                    text = "Mã đơn hàng: $it",
                    color = Color.White,
                    fontSize = 20.sp
                )
                // Hiển thị thông tin chi tiết đơn hàng
                Spacer(modifier = Modifier.height(8.dp))
                // Ví dụ: Thêm các chi tiết đơn hàng khác như món chính, món thêm, topping, v.v.
                Text(
                    text = "Món chính: Sườn bì",
                    color = Color.White,
                    fontSize = 16.sp
                )
                Text(
                    text = "Món thêm: Sườn mỡ",
                    color = Color.White,
                    fontSize = 16.sp
                )
                Text(
                    text = "Topping: Mỡ hành",
                    color = Color.White,
                    fontSize = 16.sp
                )
            }
        }
    }
}
@Preview(showSystemUi = true, showBackground = true, device = "id:pixel_6_pro")
@Composable
fun previewOder(){
    OrderDetailScreen(orderId = "CTE22E3E")
}
