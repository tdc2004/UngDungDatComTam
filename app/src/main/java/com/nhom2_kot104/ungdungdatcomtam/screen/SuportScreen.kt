package com.nhom2_kot104.ungdungdatcomtam.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.nhom2_kot104.ungdungdatcomtam.BottomNavigationBar
import com.nhom2_kot104.ungdungdatcomtam.R

//@Preview(showBackground = true, showSystemUi = true, device = "id:pixel_6_pro")
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HoTro(navController: NavHostController) {
    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController = navController)
        },
        modifier = Modifier
            .fillMaxSize()
            .safeDrawingPadding()
    ) {


        Box(
            modifier = Modifier
                .fillMaxSize()
                .safeDrawingPadding()
                .background(Color(0xFF252121)),
        ) {
            Divider(
                color = Color.Black,
                thickness = 3.dp,
                modifier = Modifier.fillMaxWidth()
            )
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
                        .clickable {
                                navController.navigate("profile")
                        }
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Cum tấm dim",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
                Spacer(modifier = Modifier.weight(1f))
            }
            Divider(modifier = Modifier.height(3.dp), color = Color.Black)
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(70.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Spacer(modifier = Modifier.padding(15.dp))
                    Image(
                        painter = painterResource(id = R.drawable.zalo),
                        contentDescription = null,
                        modifier = Modifier
                            .width(70.dp)
                            .height(70.dp),
                        contentScale = ContentScale.FillBounds
                    )
                    Spacer(modifier = Modifier.padding(20.dp))
                    Text(
                        text = "0879175310",
                        fontSize = 19.sp,
                        color = Color.White
                    )
                }

                Spacer(modifier = Modifier.padding(20.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(70.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Spacer(modifier = Modifier.padding(15.dp))

                    Image(
                        painter = painterResource(id = R.drawable.gmail),
                        contentDescription = null,
                        modifier = Modifier
                            .width(70.dp)
                            .height(70.dp),
                        contentScale = ContentScale.FillBounds
                    )
                    Spacer(modifier = Modifier.padding(20.dp))
                    Text(
                        text = "vuthanhnam2102@gmail.com",
                        fontSize = 19.sp,
                        color = Color.White
                    )
                }

                Spacer(modifier = Modifier.padding(20.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(70.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Spacer(modifier = Modifier.padding(15.dp))

                    Image(
                        painter = painterResource(id = R.drawable.dienthoai),
                        contentDescription = null,
                        modifier = Modifier
                            .width(70.dp)
                            .height(70.dp),
                        contentScale = ContentScale.FillBounds
                    )
                    Spacer(modifier = Modifier.padding(20.dp))
                    Text(
                        text = "0879175310",
                        fontSize = 19.sp,
                        color = Color.White
                    )
                }


            }
        }
    }

}