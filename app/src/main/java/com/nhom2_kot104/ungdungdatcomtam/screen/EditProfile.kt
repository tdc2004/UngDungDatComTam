package com.nhom2_kot104.ungdungdatcomtam.screen

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.core.graphics.toColorInt
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.nhom2_kot104.ungdungdatcomtam.BottomNavigationBar
import com.nhom2_kot104.ungdungdatcomtam.R
import com.nhom2_kot104.ungdungdatcomtam.model.UserAccount

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun EditProfile(navController: NavHostController) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .safeDrawingPadding()
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF111111))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.TopCenter)
                    .padding(bottom = 50.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(140.dp)
                        .padding(top = 40.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.back),
                            contentDescription = "Back",
                            modifier = Modifier
                                .size(24.dp)
                                .clickable {
                                    navController.navigateUp()
                                },
                            tint = Color.White
                        )
                        Text(
                            text = "Sửa hồ sơ",
                            textAlign = TextAlign.Center,

                            fontSize = 25.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                        Row(
                            modifier = Modifier.width(24.dp)
                        ) {

                        }
                    }
                }
            }

            // Profile Picture chồng lên
            Image(
                painter = painterResource(id = R.drawable.logo), // Thay đổi id để phù hợp với dự án của bạn
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(100.dp)
                    .align(Alignment.TopCenter) // Đặt hình ảnh lên trên và căn giữa
                    .offset(y = 90.dp) // Điều chỉnh vị trí theo trục y để nằm giữa
                    .clip(CircleShape)
                    .zIndex(1f)
                    .background(Color.White)
            )
            Image(
                painter = painterResource(id = R.drawable.camera),
                contentDescription = "",
                modifier = Modifier
                    .size(60.dp)
                    .align(Alignment.TopCenter) // Đặt hình ảnh lên trên và căn giữa
                    .offset(y = 150.dp, x = 30.dp) // Điều chỉnh vị trí theo trục y để nằm giữa
                    .clip(CircleShape)
                    .zIndex(1f)
                    .clickable {
                        navController.navigate("edit_image")
                    }
            )
            Text(
                text = "Tong Doanh Chinh",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .offset(y = 200.dp)
                    .zIndex(1f)// Điều chỉnh offset y để nằm dưới hình ảnh
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .padding(top = 140.dp) // Đảm bảo rằng column này không che khuất hình ảnh
                    .clip(shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                    .background(Color(0xFF252121))
//                .padding(top = 60.dp) // Tạo khoảng trống phía trên cho hình ảnh
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row {

                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(18.dp),
                ) {
                    Input(label = "Số điện thoại", value = "") {
                        // Xử lý input
                    }
                    Spacer(modifier = Modifier.height(10.dp))

                    Input(label = "Phường", value = "") {
                        // Xử lý input
                    }
                    Spacer(modifier = Modifier.height(10.dp))

                    Input(label = "Đường", value = "") {
                        // Xử lý input
                    }
                    Spacer(modifier = Modifier.height(10.dp))

                    Input(label = "Số nhà", value = "") {
                        // Xử lý input
                    }
                }
                Row(
                    modifier = Modifier
                        .clip(RoundedCornerShape(30.dp))
                        .width(150.dp)
                        .height(50.dp)
                        .background(color = Color("#FE724C".toColorInt()))
//                               navController?.navigate("login")
                    ,
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(text = "Lưu", color = Color.White, fontSize = 18.sp)
                }

            }
        }
    }
}

@Composable
fun ProfileEdit() {

}

@Preview(showSystemUi = true, showBackground = true, device = "id:pixel_6_pro")
@Composable
fun preview() {
    val navController = rememberNavController()
    EditProfile(navController = navController)
}