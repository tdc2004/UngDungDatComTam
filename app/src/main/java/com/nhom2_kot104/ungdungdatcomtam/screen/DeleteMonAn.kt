package com.nhom2_kot104.ungdungdatcomtam

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt

data class FoodsItem(val id: Int, val name: String, val price: String, val image: Int, val icon: Int)

class DeleteMonAn : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DeleteMonAnScreen()
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DeleteMonAnScreen() {
    Scaffold(modifier = Modifier.fillMaxSize()) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
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
                            modifier = Modifier.clickable { /* Xử lý khi nhấn nút quay lại */ }
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
                            color = Color.White,
                            fontSize = 20.sp
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
            FoodsListScreen()
        }
    }
}

@Composable
fun FoodsListScreen() {
    val foodsItem = listOf(
        FoodsItem(1, "Sườn bì", "28K", R.drawable.ig_mon, R.drawable.ic_delete),
        FoodsItem(2, "Bì chả", "25K", R.drawable.ig_mon, R.drawable.ic_delete),
        FoodsItem(3, "Trứng chả", "25K", R.drawable.ig_mon, R.drawable.ic_delete),
        FoodsItem(4, "Sườn chả", "28K", R.drawable.ig_mon, R.drawable.ic_delete),
        FoodsItem(5, "Sườn bì chả", "35K", R.drawable.ig_mon, R.drawable.ic_delete),
        FoodsItem(6, "Sườn cầy", "35K", R.drawable.ig_mon, R.drawable.ic_delete),
        FoodsItem(7, "Sườn trứng", "30K", R.drawable.ig_mon, R.drawable.ic_delete)
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        items(foodsItem) { foodItem ->
            FoodsItemRow(foodItem)
        }
    }
}

@Composable
fun FoodsItemRow(foodItem: FoodsItem) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .background(Color("#2F2D2D".toColorInt()))
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier
                .padding(5.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = foodItem.id.toString(),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Spacer(modifier = Modifier.width(15.dp))
            Image(
                painter = painterResource(id = foodItem.image),
                contentDescription = foodItem.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(64.dp)
                    .padding(end = 16.dp)
            )
        }
        Column(
            modifier = Modifier
                .weight(0.1f)
                .padding(end = 1.dp)
        ) {
            Text(
                text = foodItem.name,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Text(
                text = foodItem.price,
                fontSize = 16.sp,
                color = Color.Red
            )
        }
        Icon(
            painter = painterResource(id = foodItem.icon),
            contentDescription = "Edit Icon",
            tint = Color.White,
            modifier = Modifier.size(80.dp)
        )
    }
}


@Preview(showSystemUi = true, showBackground = true, device = "spec:parent=pixel_6_pro")
@Composable
fun PreviewDeleteMonAn() {
    DeleteMonAnScreen()
}
