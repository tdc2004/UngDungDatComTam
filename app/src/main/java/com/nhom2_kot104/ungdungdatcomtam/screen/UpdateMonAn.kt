package com.nhom2_kot104.ungdungdatcomtam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavHostController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddDishScreen(navController: NavHostController) {
    var tenMon by remember { mutableStateOf("") }
    var gia by remember { mutableStateOf("") }
    MaterialTheme {
        Surface(color = Color.Black, modifier = Modifier.fillMaxSize()) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .safeDrawingPadding()
                    .background(color = Color("#252121".toColorInt()))
            ) {
                TopAppBar(
                    title = {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxHeight()
                        ) {
                            Spacer(modifier = Modifier.width(8.dp))
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = "Back",
                                tint = Color.White,
                                modifier = Modifier.clickable {
                                navController.navigateUp()/* Xử lý khi nhấn nút quay lại */ }
                            )
                            Spacer(modifier = Modifier.width(16.dp))
                            Icon(
                                painter = painterResource(id = R.drawable.logo),
                                contentDescription = "Logo",
                                tint = Color.Unspecified,
                                modifier = Modifier.size(60.dp)
                            )
                            Spacer(modifier = Modifier.width(16.dp))
                            Text(
                                text = "Cum tứm đim",
                                color = Color.White
                            )
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(containerColor = Color("#252121".toColorInt()))
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Black)
                        .height(5.dp)
                ) {}

                Spacer(modifier = Modifier.height(16.dp))

                val imagePaninter: Painter = painterResource(id = R.drawable.ig_mon)
                Box(
                    modifier = Modifier
                        .size(180.dp)
                        .background(Color("#D9DCDF".toColorInt()), shape = RoundedCornerShape(8.dp))
                        .border(1.dp, Color.LightGray, shape = RoundedCornerShape(8.dp))
                        .clickable { /* Xử lý khi nhấn vào hình ảnh */ }
                        .clip(RoundedCornerShape(8.dp)),
                ) {
                    Image(
                        painter = imagePaninter,
                        contentDescription = null,
                        modifier = Modifier
                            .size(180.dp)
                            .align(Alignment.Center)
                    )
                }
                Column(
                    modifier = Modifier
                        .fillMaxHeight(0.9F)
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Input(
                        label = "Tên món ăn",
                        value = tenMon
                    ) { newValue ->
                        tenMon = newValue
                    }
                    Input(
                        label = "Giá",
                        value = gia
                    ) { newValue ->
                        gia = newValue
                    }

                    Spacer(modifier = Modifier.height(50.dp)) // Thêm khoảng cách giữa các thành phần và nút "Thêm"

                    Button(
                        onClick = { /* Xử lý khi nhấn nút thêm */ },
                        modifier = Modifier
                            .width(174.dp)
                            .height(50.dp)
                            .border(
                                10.dp,
                                color = Color("#FFB703".toColorInt()),
                                shape = RoundedCornerShape(10.dp)
                            ),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color("#FFB703".toColorInt())
                        )
                    ) {
                        Text(text = "Lưu", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }
}

@Composable
fun InPut(
    label: String,
    value: String,
    onValueChange: (String) -> Unit
) {
    Column {
        Text(text = label, fontSize = 16.sp, color = Color.White)
        Spacer(modifier = Modifier.height(5.dp))
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(10.dp))
                .background(Color("#D9D9D9".toColorInt()))
                .height(50.dp),
        )
    }
}
//
//@Preview(showBackground = true, showSystemUi = true, device = "spec: parent=pixel_6_pro")
//@Composable
//fun PreviewAddDish() {
//    AddDishScreen()
//}
