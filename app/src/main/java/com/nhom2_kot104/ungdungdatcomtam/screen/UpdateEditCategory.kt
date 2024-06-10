package com.nhom2_kot104.ungdungdatcomtam.screen

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
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
import com.nhom2_kot104.ungdungdatcomtam.R
import com.nhom2_kot104.ungdungdatcomtam.model.Category
import com.nhom2_kot104.ungdungdatcomtam.viewmodel.CategoryViewModel
import kotlinx.coroutines.launch
import java.util.UUID

@Composable
fun UpdateEditCategory(navController: NavHostController,categoryId: Int) {
    val context = LocalContext.current;
    val categoryViewModel: CategoryViewModel = viewModel()
    val category by categoryViewModel.getCategory(categoryId).observeAsState()
    var categoryNew by remember { mutableStateOf(category?.name.orEmpty()) } // Khởi tạo và lưu trữ tên danh mục mới

    val scope = rememberCoroutineScope()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .safeDrawingPadding()
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
            Icon(
                painter = painterResource(id = R.drawable.back),
                contentDescription = "Back",
                modifier = Modifier
                    .size(24.dp)
                    .padding(end = 8.dp)
                    .clickable { navController.navigateUp() },
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
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            category?.let {
                OutlinedTextField(
                    value = categoryNew,
                    onValueChange = { categoryNew = it },
                    singleLine = true,
                    placeholder = { Text(text = category!!.name) },
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .clip(shape = RoundedCornerShape(10.dp))
                        .background(Color("#D9D9D9".toColorInt()))
                        .height(50.dp),
                )
            }
            Row(
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .width(170.dp)
                    .height(40.dp)
                    .background(color = Color("#FFB703".toColorInt()))
                    .clickable {
                        scope.launch {
                            val newCategory = Category(categoryId, categoryNew)
                            categoryViewModel.update(newCategory)
                            categoryNew = ""
                            Toast.makeText(context, "Sửa loại món ăn thành công", Toast.LENGTH_SHORT).show()
                        }
                        navController.navigateUp()
                    },
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(text = "Xác nhận", color = Color.White, fontSize = 18.sp)
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true, device = "id:pixel_6_pro")
@Composable
fun PreviewDCatogory() {
    var navController = rememberNavController()
    UpdateEditCategory(navController = navController,1)
}