package com.nhom2_kot104.ungdungdatcomtam.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
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
import androidx.core.graphics.toColorInt
import com.nhom2_kot104.ungdungdatcomtam.R

@Composable
fun OTPScreen() {
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
                text = "Chúng tôi sẽ gửi bạn mã OTP qua số điện thoại này",
                fontSize = 15.sp,
                color = Color.White,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = "0904866137",
                fontSize = 15.sp,
                color = Color.White,
                textAlign = TextAlign.Center
            )
        }
        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    InputOTP(value = "") {

                    }
                    InputOTP(value = "") {

                    }
                    InputOTP(value = "") {

                    }
                    InputOTP(value = "") {

                    }
                }
                Text(
                    text = "00:30", modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    fontSize = 15.sp,
                    color = Color.White,
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Không nhân được mã OTP ? ", fontSize = 14.sp,
                        color = Color.White,
                        fontWeight = FontWeight(700)
                    )
                    Text(
                        text = "Gửi lại OTP", fontSize = 14.sp,
                        color = Color("#FE724C".toColorInt()),
                        fontWeight = FontWeight(700)
                    )
                }
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
fun InputOTP(
    value: String,
    onValueChange: (String) -> Unit
) {
    Box(
        modifier = Modifier
            .border(3.dp, Color("#FE724C".toColorInt()), RoundedCornerShape(30.dp))
            .size(60.dp)
            .clip(RoundedCornerShape(30.dp))
    ) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            singleLine = true,
            modifier = Modifier
                .clip(shape = RoundedCornerShape(30.dp))
                .size(60.dp)
                .background(Color.White),

            )
    }
}

@Preview(device = "id:pixel_6_pro", showSystemUi = true, showBackground = true)
@Composable
fun PreviewOTP() {
    OTPScreen()
}