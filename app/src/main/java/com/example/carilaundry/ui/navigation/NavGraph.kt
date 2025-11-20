package com.example.carilaundry.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.carilaundry.ui.feature.auth.RoleSelectionScreen
import com.example.carilaundry.ui.feature.customer.login.CustomerLoginScreen
import com.example.carilaundry.ui.feature.customer.register.CustomerRegisterScreen
import com.example.carilaundry.ui.feature.owner.login.OwnerLoginScreen
import com.example.carilaundry.ui.feature.owner.register.OwnerRegisterScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "customer/login") {
        composable("customer/login") {
            CustomerLoginScreen(
                onLogin = { email, password ->
//                    blom
                },
                onRegisterClicked = { navController.navigate("roleSelection") },
                onSwitchToOwner = { navController.navigate("owner/login") }
            )
        }

        composable("owner/login") {
            OwnerLoginScreen(
                onLogin = { email, password ->
//                    blom
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
//                    blom
                    navController.popBackStack("customer/login", false)
                },
                onSignInClicked = { navController.popBackStack() }
            )
        }

        composable("owner/register") {
            OwnerRegisterScreen(
                onRegister = { businessName, ownerName, email, phone, address, password ->
//                    blom
                    navController.popBackStack("owner/login", false)
                },
                onSignInClicked = { navController.popBackStack() }
            )
        }
    }
}
