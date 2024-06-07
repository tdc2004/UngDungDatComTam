package com.nhom2_kot104.ungdungdatcomtam.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import com.nhom2_kot104.ungdungdatcomtam.R

@Composable
fun LoginScreen() {
    var phoneNumber by remember { mutableStateOf("") }
    var phuong by remember { mutableStateOf("") }
    var duong by remember { mutableStateOf("") }
    var sonha by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color("#373232".toColorInt()))
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight(0.45F)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Row() {}
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "",
                modifier = Modifier.size(275.dp)
            )
            Text(
                text = "Hello Phước",
                fontSize = 20.sp,
                color = Color.White,
            )
            Text(
                text = "Vui lòng cập nhật thông tin chính xác để\n" +
                        " thuận tiện cho việc giao hàng",
                fontSize = 15.sp,
                color = Color.White,
                textAlign = TextAlign.Center
            )
        }
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            InputField(label = "Số điện thoại", value = phoneNumber) {
                    newValue ->
                phoneNumber = newValue
            }
            InputField(label = "Phường", value = phuong) {
                newValue -> phuong = newValue

            }
            InputField(label = "Đường", value = duong) {
                    newValue -> duong = newValue
            }
            InputField(label = "Số nhà", value = sonha) {
                    newValue -> sonha = newValue
            }
            Row(
                modifier = Modifier
                    .clip(RoundedCornerShape(30.dp))
                    .width(150.dp)
                    .height(50.dp)
                    .background(color = Color("#FE724C".toColorInt())),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(text = "Xác nhận", color = Color.White, fontSize = 18.sp)
            }


        }
    }
}

@Composable
fun InputField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit
) {
    Column(
    ) {
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
                .height(50.dp)
                ,
        )
    }
}

@Preview(
    showSystemUi = true, showBackground = true,
    device = "spec:parent=pixel_6_pro"
)
@Composable
fun PreviewLogin() {
    LoginScreen()
}