package com.example.easppb

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.easppb.data.Datasource
import com.example.easppb.screen.LoginScreen
import com.example.easppb.screen.RegisterScreen
import com.example.easppb.screen.HomeScreen
import com.example.easppb.screen.TopupScreen
import com.example.easppb.screen.TopupConfirmScreen
import com.example.easppb.screen.TopupSuccessScreen
import com.example.easppb.screen.ProfileScreen

@Composable
fun AppScreen(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.LoginScreen.route) {
        composable(route = Screen.LoginScreen.route) {
            LoginScreen(navController = navController)
        }
        composable(route = Screen.RegisterScreen.route) {
            RegisterScreen(navController = navController)
        }
        composable(
            route = Screen.HomeScreen.route + "/{email}" + "/{nama}" + "/{namaToko}" + "/{balance}",
            arguments = listOf(
                navArgument("email") {
                    type = NavType.StringType
                },
                navArgument("nama") {
                    type = NavType.StringType
                },
                navArgument("namaToko") {
                    type = NavType.StringType
                },
                navArgument("balance") {
                    type = NavType.StringType
                },
            )
        ) { entry ->
            val email = entry.arguments?.getString("email") ?: ""
            val nama = entry.arguments?.getString("nama") ?: ""
            val namaToko = entry.arguments?.getString("namaToko") ?: ""
            val balance = entry.arguments?.getString("balance") ?: "0"
            val datasource = Datasource()
            val items = datasource.loadItems()

            HomeScreen(
                navController = navController,
                items = items,
                email = email,
                nama = nama,
                namaToko = namaToko,
                balance = balance,
            )
        }
        composable(
            route = Screen.ProfileScreen.route + "/{email}" + "/{nama}" + "/{namaToko}" + "/{balance}",
            arguments = listOf(
                navArgument("email") {
                    type = NavType.StringType
                },
                navArgument("nama") {
                    type = NavType.StringType
                },
                navArgument("namaToko") {
                    type = NavType.StringType
                },
                navArgument("balance") {
                    type = NavType.StringType
                },
            )
        ) { entry ->
            val email = entry.arguments?.getString("email") ?: ""
            val nama = entry.arguments?.getString("nama") ?: ""
            val namaToko = entry.arguments?.getString("namaToko") ?: ""
            val balance = entry.arguments?.getString("balance") ?: "0"

            ProfileScreen(
                navController = navController,
                email = email,
                nama = nama,
                namaToko = namaToko,
                balance = balance,
            )
        }
        composable(
            route = Screen.TopupScreen.route + "/{email}" + "/{nama}" + "/{namaToko}" + "/{balance}",
            arguments = listOf(
                navArgument("email") {
                    type = NavType.StringType
                },
                navArgument("nama") {
                    type = NavType.StringType
                },
                navArgument("namaToko") {
                    type = NavType.StringType
                },
                navArgument("balance") {
                    type = NavType.StringType
                },
            )
        ) { entry ->
            val email = entry.arguments?.getString("email") ?: ""
            val nama = entry.arguments?.getString("nama") ?: ""
            val namaToko = entry.arguments?.getString("namaToko") ?: ""
            val balance = entry.arguments?.getString("balance") ?: "0"

            TopupScreen(
                navController = navController,
                email = email,
                nama = nama,
                namaToko = namaToko,
                balance = balance,
            )
        }
        composable(
            route = Screen.TopupConfirmScreen.route + "/{email}" + "/{nama}" + "/{namaToko}" + "/{balance}"+ "/{selectedMethod}" + "/{amount}",
            arguments = listOf(
                navArgument("email") {
                    type = NavType.StringType
                },
                navArgument("nama") {
                    type = NavType.StringType
                },
                navArgument("namaToko") {
                    type = NavType.StringType
                },
                navArgument("balance") {
                    type = NavType.StringType
                },
                navArgument("selectedMethod") {
                    type = NavType.StringType
                },
                navArgument("amount") {
                    type = NavType.StringType
                },
            )
        ) { entry ->
            val email = entry.arguments?.getString("email") ?: ""
            val nama = entry.arguments?.getString("nama") ?: ""
            val namaToko = entry.arguments?.getString("namaToko") ?: ""
            val balance = entry.arguments?.getString("balance") ?: "0"
            val selectedMethod = entry.arguments?.getString("selectedMethod") ?: ""
            val amount = entry.arguments?.getString("amount") ?: "0"

            TopupConfirmScreen(
                navController = navController,
                email = email,
                nama = nama,
                namaToko = namaToko,
                balance = balance,
                selectedMethod = selectedMethod,
                amount = amount
            )
        }
        composable(
            route = Screen.TopupSuccessScreen.route + "/{email}" + "/{nama}" + "/{namaToko}" + "/{balance}",
            arguments = listOf(
                navArgument("email") {
                    type = NavType.StringType
                },
                navArgument("nama") {
                    type = NavType.StringType
                },
                navArgument("namaToko") {
                    type = NavType.StringType
                },
                navArgument("balance") {
                    type = NavType.StringType
                },
            )
        ) { entry ->
            val email = entry.arguments?.getString("email") ?: ""
            val nama = entry.arguments?.getString("nama") ?: ""
            val namaToko = entry.arguments?.getString("namaToko") ?: ""
            val balance = entry.arguments?.getString("balance") ?: "0"

            TopupSuccessScreen(
                navController = navController,
                email = email,
                nama = nama,
                namaToko = namaToko,
                balance = balance,
            )
        }
    }
}

