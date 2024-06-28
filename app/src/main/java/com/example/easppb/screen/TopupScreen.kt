package com.example.easppb.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.easppb.R
import com.example.easppb.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopupScreen(navController: NavController, email: String, nama: String, namaToko: String, balance: String) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color(0xFFE53935),
                ),
                title = {
                    Image(
                        painter = painterResource(id = R.drawable.icon_alfamind),
                        contentDescription = "Logo",
                        modifier = Modifier
                            .fillMaxHeight()
                            .padding(vertical = 8.dp)
                    )
                },
            )
        },
        bottomBar = {
            BottomNavigationBarTopup(navController = navController, email = email, nama = nama, namaToko = namaToko, balance = balance)
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Metode Pembayaran:",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            var selectedMethod by remember { mutableStateOf("Pilih Metode Pembayaran") }
            val paymentMethods = listOf("Gopay", "OVO", "BNI", "BRI", "Mandiri")

            var expanded by remember { mutableStateOf(false) }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White, shape = RoundedCornerShape(8.dp))
                    .clickable { expanded = true }
                    .padding(8.dp)
            ) {

                DynamicSelectTextField(
                    selectedValue = selectedMethod,
                    options = paymentMethods,
                    label = "Metode Pembayaran",
                    onValueChangedEvent = { selectedMethod = it }
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Jumlah Nominal:",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            var amount by remember { mutableStateOf("") }

            TextField(
                value = amount,
                onValueChange = { amount = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White, shape = RoundedCornerShape(8.dp))
                    .padding(8.dp),
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                singleLine = true
            )

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = { navController.navigate(Screen.TopupConfirmScreen.withArgs(email, nama, namaToko, balance, selectedMethod, amount)) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE53935))
            ) {
                Text(text = "Lanjutkan", color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DynamicSelectTextField(
    selectedValue: String,
    options: List<String>,
    label: String,
    onValueChangedEvent: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded },
        modifier = modifier
    ) {
        OutlinedTextField(
            readOnly = true,
            value = selectedValue,
            onValueChange = {},
            label = { Text(text = label) },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
            },
            colors = OutlinedTextFieldDefaults.colors(),
            modifier = Modifier
                .menuAnchor()
                .fillMaxWidth()
        )

        ExposedDropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            options.forEach { option: String ->
                DropdownMenuItem(
                    text = { Text(text = option) },
                    onClick = {
                        expanded = false
                        onValueChangedEvent(option)
                    }
                )
            }
        }
    }
}

@Composable
fun BottomNavigationBarTopup(navController: NavController, email: String, nama: String, namaToko: String, balance: String) {
    BottomAppBar(
        containerColor = Color.White,
        contentColor = Color.Black,
        content = {
            IconButton(
                onClick = { /* Handle navigation */ },
                modifier = Modifier.weight(1f)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.icon_topup),
                        contentDescription = "Top Up",
                        tint = Color.Red,
                        modifier = Modifier.size(24.dp)
                    )
                    Text(
                        text = "Top Up",
                        color = Color.Red
                    )
                }
            }

            IconButton(
                onClick = { navController.navigate(Screen.HomeScreen.withArgs(email, nama, namaToko, balance)) },
                modifier = Modifier.weight(1f)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.icon_home),
                        contentDescription = "Home",
                        modifier = Modifier.size(24.dp)
                    )
                    Text(text = "Home")
                }
            }

            IconButton(
                onClick = { navController.navigate(Screen.ProfileScreen.withArgs(email, nama, namaToko, balance)) },
                modifier = Modifier.weight(1f)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.icon_profile),
                        contentDescription = "Profile",
                        modifier = Modifier.size(24.dp)
                    )
                    Text(text = "Profile")
                }
            }
        }
    )
}
