package com.nhom2_kot104.ungdungdatcomtam.screen

import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.nhom2_kot104.ungdungdatcomtam.R
import com.nhom2_kot104.ungdungdatcomtam.model.Dish
import com.nhom2_kot104.ungdungdatcomtam.viewmodel.DishViewModel
import kotlinx.coroutines.launch
import kotlin.text.toDoubleOrNull



@Composable
fun UpdateEditMonAn(navController: NavHostController, dishId: Int) {
    val context = LocalContext.current;
    var dishViewModel: DishViewModel = viewModel()
    val dish by dishViewModel.getDish(dishId).observeAsState()
    var dishNew by remember { mutableStateOf(dish?.name.orEmpty()) } // Khởi tạo và lưu trữ tên danh mục mới
    var giaMonMoi by remember { mutableStateOf(dish?.price ?: 0.0) }
    val scope = rememberCoroutineScope()



    var selectedImageUri by remember { mutableStateOf<Uri?>(null) }
    val launcher =
        rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
            selectedImageUri = uri
        }
    MaterialTheme {
        Surface(color = Color.White, modifier = Modifier.fillMaxSize()) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .safeDrawingPadding()
                    .background(color = Color("#252121".toColorInt()))
            ) {

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
                Spacer(modifier = Modifier.height(16.dp))

                Box(
                    modifier = Modifier
                        .size(180.dp)
                        .background(Color("#D9DCDF".toColorInt()), shape = RoundedCornerShape(8.dp))
                        .border(1.dp, Color.LightGray, shape = RoundedCornerShape(8.dp))
                        .clickable {
                            launcher.launch("image/*")
                        }
                        .clip(RoundedCornerShape(8.dp)),
                ) {
                    dish?.let { dish ->
                        val imagePath: String = dish.image
                        if (selectedImageUri != null) {
                            AsyncImage(
                                model = selectedImageUri,
                                contentDescription = "Selected Image",
                                modifier = Modifier.fillMaxSize()
                            )
                        } else {
                            val placeholderPainter = painterResource(id = R.drawable.ig_mon)
                            AsyncImage(
                                model = imagePath,
                                contentDescription = "",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .size(180.dp),
                                placeholder = placeholderPainter
                            )
                        }
                    }
                }
                Column(
                    modifier = Modifier
                        .fillMaxHeight(0.9F)
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Column {
                        Text(text = "Tên món ăn", fontSize = 16.sp, color = Color.White)
                        Spacer(modifier = Modifier.height(5.dp))
                        OutlinedTextField(
                            value = dishNew,
                            onValueChange = { dishNew = it },
                            placeholder = { dish?.let { Text(text = it.name) } },
                            singleLine = true,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(shape = RoundedCornerShape(10.dp))
                                .background(Color("#D9D9D9".toColorInt()))
                                .height(50.dp),
                        )
                    }
                    Column {
                        Text(text = "Giá", fontSize = 16.sp, color = Color.White)
                        Spacer(modifier = Modifier.height(5.dp))
                        OutlinedTextField(
                            value = giaMonMoi.toString(),
                            onValueChange = { giaMonMoi = it.toDoubleOrNull()!! },
                            placeholder = { Text(text = dish!!.price.toString()) },
                            singleLine = true,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(shape = RoundedCornerShape(10.dp))
                                .background(Color("#D9D9D9".toColorInt()))
                                .height(50.dp),
                        )
                    }

                    Spacer(modifier = Modifier.height(50.dp)) // Thêm khoảng cách giữa các thành phần và nút "Thêm"

                    Button(
                        onClick = {
                            scope.launch {
                                val imageUriString: String = selectedImageUri?.toString() ?: ""
                                dish?.let { existingDish ->
                                    val newDish = Dish(
                                        uid = existingDish.uid,
                                        name = dishNew,
                                        price = giaMonMoi,
                                        image = imageUriString,
                                        categoryId = existingDish.categoryId
                                    )
                                    dishViewModel.update(newDish)
                                    Toast.makeText(context, "Sửa món ăn thành công", Toast.LENGTH_SHORT).show()
                                }
                                navController.navigateUp()
                            }
                        },
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
fun InPutEdit(
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

@Preview(showBackground = true, showSystemUi = true, device = "spec: parent=pixel_6_pro")
@Composable
fun PreviewAddDish() {
    var navController = rememberNavController()
    UpdateEditMonAn(navController, 1)
}
