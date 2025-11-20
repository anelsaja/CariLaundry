package com.example.carilaundry.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.carilaundry.ui.feature.auth.RoleSelectionScreen
import com.example.carilaundry.ui.feature.customer.login.CustomerLoginScreen
import com.example.carilaundry.ui.feature.customer.register.CustomerRegisterScreen
import com.example.carilaundry.ui.feature.customer.home.CustomerHomeScreen
import com.example.carilaundry.ui.feature.owner.login.OwnerLoginScreen
import com.example.carilaundry.ui.feature.owner.register.OwnerRegisterScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "customer/login") {
        composable("customer/login") {
            CustomerLoginScreen(
                onLogin = { email, password ->
                    if(email == "customer" && password == "123")
                    navController.navigate("customer/home")
                },
                onRegisterClicked = { navController.navigate("roleSelection") },
                onSwitchToOwner = { navController.navigate("owner/login") }
            )
        }

        composable("owner/login") {
            OwnerLoginScreen(
                onLogin = { email, password ->
                    if (email == "owner" && password == "123") {
                        navController.navigate("owner/home")
                    }
                },
                onRegisterClicked = { navController.navigate("roleSelection") },
                onSwitchToCustomer = { navController.navigate("customer/login") }
            )
        }

        composable("roleSelection") {
            RoleSelectionScreen(
                onSelectCustomer = { navController.navigate("customer/register") },
                onSelectOwner = { navController.navigate("owner/register") },
                onSignInClicked = { navController.navigate("customer/login") }
            )
        }

        composable("customer/register") {
            CustomerRegisterScreen(
                onRegister = { name, email, phone, password ->
                    navController.navigate("customer/home") {
                        popUpTo("customer/login") { inclusive = true }
                    }
                },
                onSignInClicked = { navController.popBackStack() }
            )
        }

        composable("owner/register") {
            OwnerRegisterScreen(
                onRegister = { businessName, ownerName, email, phone, address, password ->
                    navController.navigate("owner/home") {
                        popUpTo("owner/login") { inclusive = true }
                    }
                },
                onSignInClicked = { navController.popBackStack() }
            )
        }

        composable("customer/home") {
            CustomerHomeScreen(
                onItemClick = { id -> /* navigate to detail if needed */ },
                onOpenFavorites = { navController.navigate("favorites") },
                onOpenNotifications = { navController.navigate("notifications") },
                onOpenProfile = { navController.navigate("customer/profile") }
            )
        }
    }
}
