package com.nhom2_kot104.ungdungdatcomtam

import android.annotation.SuppressLint
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import androidx.core.graphics.toColorInt
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.compose.rememberImagePainter
import com.nhom2_kot104.ungdungdatcomtam.model.Dish
import com.nhom2_kot104.ungdungdatcomtam.viewmodel.DishViewModel

data class FoodsItem(
    val id: Int,
    val name: String,
    val price: String,
    val image: Int,
    val icon: Int
)


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DeleteMonAnScreen(navController: NavHostController) {
    val dishViewModel: DishViewModel = viewModel()
    val dishes by dishViewModel.allDishs.observeAsState(initial = emptyList())
    Scaffold(modifier = Modifier.fillMaxSize()) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .safeDrawingPadding()
                .background(color = Color("#252121".toColorInt()))
        ) {
//            TopAppBar(
//                title = {
//                    Row(
//                        verticalAlignment = Alignment.CenterVertically,
//                        modifier = Modifier.fillMaxHeight()
//                    ) {
//                        Spacer(modifier = Modifier.width(8.dp))
//                        Icon(
//                            imageVector = Icons.Default.ArrowBack,
//                            contentDescription = "Back",
//                            tint = Color.White,
//                            modifier = Modifier.clickable {
//                                navController.navigateUp()/* Xử lý khi nhấn nút quay lại */
//                            }
//                        )
//                        Spacer(modifier = Modifier.width(16.dp))
//                        Icon(
//                            painter = painterResource(id = R.drawable.logo),
//                            contentDescription = "Logo",
//                            tint = Color.Unspecified,
//                            modifier = Modifier.size(60.dp)
//                        )
//                        Spacer(modifier = Modifier.width(16.dp))
//                        Text(
//                            text = "Cum tứm đim",
//                            color = Color.White,
//                            fontSize = 20.sp
//                        )
//                    }
//                },
//                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color("#252121".toColorInt()))
//            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .height(70.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.back),
                    contentDescription = "Back",
                    modifier = Modifier
                        .size(24.dp)
                        .padding(end = 8.dp)
                        .clickable {
                            navController.navigateUp()
                        },
                    tint = Color.White
                )
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

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
            ) {
                items(dishes) { foodItem ->
                    FoodsItemRow(foodItem, onDelete = {
                        dishViewModel.delete(foodItem)
                    })
                }
            }
        }
    }
}

//@Composable
//fun FoodsListScreen(dish: List<Dish>) {
//
//
//    LazyColumn(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(8.dp)
//    ) {
//        items() { foodItem ->
//            FoodsItemRow(foodItem)
//        }
//    }
//}


@Composable
fun FoodsItemRow(dish: Dish, onDelete: () -> Unit) {
    val imagePath: String = dish.image

    val showDialog = remember { mutableStateOf(false) }
    if (showDialog.value) {
        AlertDialog(
            onDismissRequest = { showDialog.value = false },
            title = { Text(text = "Thông báo") },
            text = { Text("Bạn có chắc chắn muốn xóa hay không?") },
            confirmButton = {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Button(
                        onClick = { showDialog.value = false },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Yellow)
                    ) {
                        Text(
                            "Hủy",
                            color = Color.Black,
                            fontWeight = FontWeight.Bold)
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    Button(
                        onClick = {
                            onDelete()
                            showDialog.value = false
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Yellow)
                    ) {
                        Text(
                            "OK",
                            color = Color.Black,
                            fontWeight = FontWeight.Bold)
                    }
                }
            },
            dismissButton = {}
        )
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Color("#2F2D2D".toColorInt()))
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier
                .padding(5.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = dish.uid.toString(),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Spacer(modifier = Modifier.width(15.dp))
            Log.e("Image", dish.image)
            val placeholderPainter = painterResource(id = R.drawable.ig_mon)
            AsyncImage(
                model = imagePath,
                contentDescription = dish.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(50.dp),
                placeholder = placeholderPainter

            )
        }
        Column(
            modifier = Modifier
                .weight(0.1f)
                .padding(end = 1.dp)
        ) {
            Text(
                text = dish.name,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Text(
                text = dish.price.toString(),
                fontSize = 16.sp,
                color = Color.Red
            )
        }
        Icon(
            painter = painterResource(id = R.drawable.delete),
            contentDescription = "Edit",
            modifier = Modifier
                .size(24.dp)
                .clickable {
                    showDialog.value = true
                },
            tint = Color.White
        )
    }
}

//
//@Preview(showSystemUi = true, showBackground = true, device = "spec:parent=pixel_6_pro")
//@Composable
//fun PreviewDeleteMonAn() {
//    DeleteMonAnScreen()
//}
