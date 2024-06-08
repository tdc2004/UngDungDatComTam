package com.nhom2_kot104.ungdungdatcomtam.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.nhom2_kot104.ungdungdatcomtam.R

@Composable
fun LoginScree(navController: NavController) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var pass by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight(0.5f)
                .fillMaxWidth()
                .background(color = Color("#252121".toColorInt())),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Đăng nhập",
                fontSize = 32.sp,
                color = Color.White,
                fontWeight = FontWeight(900)
            )
            Image(
                painter = painterResource(id = R.drawable.logo), contentDescription = "",
                modifier = Modifier.fillMaxSize(0.8f)
            )
        }
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .background(color = Color("#373232".toColorInt()))
                .padding(18.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            InputText(label = "Username: ", value = username) { newValue ->
                username = newValue
            }
            Column {
                Text(text = "Password", fontSize = 16.sp, color = Color.White)
                Spacer(modifier = Modifier.height(5.dp))
                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    visualTransformation = if (pass) VisualTransformation.None else PasswordVisualTransformation(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(shape = RoundedCornerShape(10.dp))
                        .background(Color("#D9D9D9".toColorInt()))
                        .height(50.dp),

                    trailingIcon = {
                        val icon = if (pass) {
                            painterResource(id = R.drawable.eyenot)
                        } else {
                            painterResource(id = R.drawable.eye)
                        }
                        Icon(
                            painter = icon,
                            contentDescription = "Toggle password visibility",
                            modifier = Modifier
                                .clickable {
                                    pass = !pass
                                }
                                .height(25.dp)
                                .width(25.dp)
                        )
                    }
                )
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
                Text(text = "Login", color = Color.White, fontSize = 18.sp)
            }
            Row {
                Text(text = "Do not have an account ? ", color = Color.White, fontSize = 18.sp)
                Text(text = "Sign Up", color = Color("#FE724C".toColorInt()), fontSize = 18.sp)
            }
        }
    }
}

@Composable
fun InputText(
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
                .height(50.dp),
        )
    }
}

@Preview(showSystemUi = true, showBackground = true, device = "id:pixel_6_pro")
@Composable
fun PreviewLogi() {
    val navController = rememberNavController()
    LoginScree(navController)
}