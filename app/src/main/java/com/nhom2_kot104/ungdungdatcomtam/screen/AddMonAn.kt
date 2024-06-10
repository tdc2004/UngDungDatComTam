package com.nhom2_kot104.ungdungdatcomtam

import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
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
import coil.compose.AsyncImage
import com.nhom2_kot104.ungdungdatcomtam.model.Dish
import com.nhom2_kot104.ungdungdatcomtam.viewmodel.CategoryViewModel
import com.nhom2_kot104.ungdungdatcomtam.viewmodel.DishViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddMonAnScreen(navController: NavHostController) {
    var context = LocalContext.current

    val dishViewModel: DishViewModel = viewModel()


    var gia by remember { mutableStateOf("") }
    var tenMon by remember { mutableStateOf("") }
    val categoryViewModel: CategoryViewModel = viewModel()
    val categories by categoryViewModel.allCategories.observeAsState(initial = emptyList())
    val categoryNames = categories.map { it.name }
    var selectedCategoryName by remember { mutableStateOf(categoryNames.firstOrNull() ?: "") }
    var selectedCategory by remember { mutableStateOf(categories.firstOrNull()) }

    var selectedImageUri by remember { mutableStateOf<Uri?>(null) }
    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
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
                        },
                    contentAlignment = Alignment.Center
                ) {
                    if(selectedImageUri != null){
                        AsyncImage(
                            model = selectedImageUri,
                            contentDescription = "Selected Image",
                            modifier = Modifier.fillMaxSize()
                        )
                    }else{
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(
                                imageVector = Icons.Default.Add,
                                contentDescription = "Add",
                                tint = Color("#4E4B66".toColorInt()),
                                modifier = Modifier.size(24.dp)
                            )
                            Text(text = "Thêm hình ảnh", color = Color("#4E4B66".toColorInt()))
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
                    Dropdown(
                        label = "Loại Món",
                        items = categoryNames,
                        selectedItem = selectedCategoryName,
                        onItemSelected = { newItem ->
                            selectedCategoryName = newItem
                            selectedCategory = categories.find { it.name == newItem }
                        }
                    )
                    Input(
                        label = "Giá",
                        value = gia
                    ) { newValue ->
                        gia = newValue
                    }
                    Input(
                        label = "Tên Món",
                        value = tenMon
                    ) { newValue ->
                        tenMon = newValue
                    }

                    Spacer(modifier = Modifier.height(50.dp)) // Thêm khoảng cách giữa các thành phần và nút "Thêm"

                    Button(
                        onClick = {
                            val priceDouble = gia.toDoubleOrNull()
                            if (priceDouble != null && selectedCategory != null) {
                                val dish = selectedImageUri?.toString()?.let {
                                    Dish(
                                        null,
                                        name = tenMon,
                                        price = priceDouble,
                                        categoryId = selectedCategory!!.uid ?: 0,
                                        image = it
                                    )
                                }
                                dish?.let { dishViewModel.insert(it) }
                                Toast.makeText(context,"Thêm thành công",Toast.LENGTH_SHORT).show()
                                navController.navigateUp()
                            } else {
                                // Xử lý lỗi: giá không phải là số hoặc không chọn được loại món
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
                        Text(text = "Thêm", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }
}

@Composable
fun Input(
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


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Dropdown(
    label: String,
    items: List<String>,
    selectedItem: String,
    onItemSelected: (String) -> Unit
) {
    var isExpanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth(),
    ) {
        Text(text = label, fontSize = 16.sp, color = Color.White)
        Spacer(modifier = Modifier.height(5.dp))
        ExposedDropdownMenuBox(
            expanded = isExpanded,
            onExpandedChange = { isExpanded = !isExpanded }
        ) {
            TextField(
                modifier = Modifier
                    .menuAnchor()
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(10.dp))
                    .background(Color("#D9D9D9".toColorInt()))
                    .height(50.dp),
                value = selectedItem,
                onValueChange = {},
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded) }
            )
            ExposedDropdownMenu(expanded = isExpanded, onDismissRequest = { isExpanded = false }) {
                items.forEach { item ->
                    DropdownMenuItem(
                        text = { Text(text = item) },
                        onClick = {
                            onItemSelected(item)
                            isExpanded = false
                        },
                        contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, device = "spec: parent=pixel_6_pro")
@Composable
fun PreviewAddMonAn() {
    val navController = rememberNavController()
    AddMonAnScreen(navController)
}
