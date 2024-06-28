package com.example.easppb.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.easppb.R
import com.example.easppb.Screen
import com.example.easppb.model.Item


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController, items: List<Item>, email: String, nama: String, namaToko: String, balance: String) {
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
            BottomNavigationBar(navController = navController, email = email, nama = nama, namaToko = namaToko, balance = balance)
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = "",
                onValueChange = {},
                placeholder = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            painter = painterResource(id = R.drawable.icon_search),
                            contentDescription = "Search",
                            modifier = Modifier.size(18.dp)
                        )
                        Text("Cari produk", modifier = Modifier.padding(start = 8.dp))
                    }
                },
                enabled = false,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                shape = RoundedCornerShape(16.dp),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.LightGray,
                    disabledIndicatorColor = Color.Transparent,
                    disabledTextColor = Color.Gray
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Rekomendasi Produk",
                color = Color.Red,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(start = 16.dp, top = 8.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(16.dp)
            ) {
                items(items.chunked(2)) { rowItems ->
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        rowItems.forEach { item ->
                            ItemCard(item = item, modifier = Modifier.weight(1f))
                        }
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }
}

@Composable
fun ItemCard(item: Item, modifier: Modifier = Modifier) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = modifier
            .padding(8.dp)
            .height(250.dp)
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = item.imageRes),
                contentDescription = item.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = item.title, fontWeight = FontWeight.Medium, fontSize = 16.sp)
            Text(text = item.category, fontSize = 14.sp, color = Color.Gray)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "Rp. ${item.price},00", fontWeight = FontWeight.Bold, fontSize = 16.sp)
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavController, email: String, nama: String, namaToko: String, balance: String) {
    BottomAppBar(
        containerColor = Color.White,
        contentColor = Color.Black,
        content = {
            IconButton(
                onClick = { navController.navigate(Screen.TopupScreen.withArgs(email, nama, namaToko, balance)) },
                modifier = Modifier.weight(1f)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.icon_topup),
                        contentDescription = "Top Up",
                        modifier = Modifier.size(24.dp)
                    )
                    Text("Top Up")
                }
            }

            IconButton(
                onClick = { /* Handle navigation */ },
                modifier = Modifier.weight(1f)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.icon_home),
                        contentDescription = "Home",
                        tint = Color.Red,
                        modifier = Modifier.size(24.dp)
                    )
                    Text(
                        text = "Home",
                        color = Color.Red
                    )
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
                    Text("Profile")
                }
            }
        }
    )
}