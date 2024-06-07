package com.nhom2_kot104.ungdungdatcomtam.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.nhom2_kot104.ungdungdatcomtam.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ManagerScreen(navController: NavHostController){
    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController = navController)
        }
    ) {
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
                    painter = painterResource(id = R.drawable.logo),
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

            }
            Divider(modifier = Modifier.height(3.dp), color = Color.Black)
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.logo),
                        contentDescription = "Profile Image",
                        modifier = Modifier
                            .size(50.dp)
                            .clip(CircleShape)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Quản lý loại món ăn",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                    Spacer(modifier = Modifier.weight(1f))
                }
                Spacer(modifier = Modifier.height(20.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.logo),
                        contentDescription = "Profile Image",
                        modifier = Modifier
                            .size(50.dp)
                            .clip(CircleShape)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Quản lý món ăn",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                    Spacer(modifier = Modifier.weight(1f))

                }
            }
        }
    }
}
@Preview(showSystemUi = true, showBackground = true, device = "id:pixel_6_pro")
@Composable
fun PreviewManager(){
    val navController = rememberNavController()
    ManagerScreen(navController = navController)
}