package com.nhom2_kot104.ungdungdatcomtam.screen

import android.widget.Toast
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
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.nhom2_kot104.ungdungdatcomtam.R
import com.nhom2_kot104.ungdungdatcomtam.database.DbHelper
import com.nhom2_kot104.ungdungdatcomtam.model.UserAccount
import com.nhom2_kot104.ungdungdatcomtam.repositotry.UserRepository
import com.nhom2_kot104.ungdungdatcomtam.viewmodel.UserViewModel

@Composable
fun LoginScreen(navController: NavController) {
    val context = LocalContext.current
    val userDao = DbHelper.getInstance(context).getUserDao()
    val repository = UserRepository(userDao)
    val userViewModel: UserViewModel = viewModel(factory = UserViewModel.ViewModelFactory(repository))
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var repass by remember { mutableStateOf("") }
    var pass by remember { mutableStateOf(false) }
    var name by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .safeDrawingPadding()
            .background(color = Color("#373232".toColorInt()))
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight(0.4F)
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
                text = "Đăng Ký",
                fontSize = 20.sp,
                color = Color.White,
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
            InputField(label = "Họ tên", value = name) {
                    newValue ->
                name = newValue
            }
            InputField(label = "Tên tài khoản", value = username) {
                newValue -> username = newValue

            }
            Column {
                Text(text = "Mật khẩu", fontSize = 16.sp, color = Color.White)
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
            Column {
                Text(text = "Nhắc lại mật khẩu", fontSize = 16.sp, color = Color.White)
                Spacer(modifier = Modifier.height(5.dp))
                OutlinedTextField(
                    value = repass,
                    onValueChange = { repass = it },
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
                    .background(color = Color("#FE724C".toColorInt()))
                    .clickable {
                        if (repass.equals(password)) {
                            try {
                                var user = UserAccount(null, name, username, password, 1)
                                userViewModel.register(user)
                                Toast
                                    .makeText(context, "Đăng ký thành công", Toast.LENGTH_SHORT)
                                    .show()
                                navController.navigate("login")

                            } catch (e: Exception) {
                                Toast
                                    .makeText(context, "Đăng ký thất bại", Toast.LENGTH_SHORT)
                                    .show()
                            }
                        } else {
                            Toast
                                .makeText(context, "Mật khẩu không trùng khớp", Toast.LENGTH_SHORT)
                                .show()
                        }

//                               navController?.navigate("login")
                    },
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(text = "Đăng kí", color = Color.White, fontSize = 18.sp)
            }
            Row(
                modifier = Modifier.clickable { navController.navigate("login") }
            ) {
                Text(text = "Already have an account ? ", color = Color.White, fontSize = 18.sp)
                Text(text = "Sign In", color = Color("#FE724C".toColorInt()), fontSize = 18.sp)
            }
//            loginState.let {
//                if(loginState.value != null){
//                    if (loginState.value == true) {
//                        Toast.makeText(context, "Đăng nhập thành công", Toast.LENGTH_SHORT).show()
//                    }else{
//                        Toast.makeText(context, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show()
//                    }
//                }
//            }
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
    var navController = rememberNavController()
    LoginScreen(navController)
}