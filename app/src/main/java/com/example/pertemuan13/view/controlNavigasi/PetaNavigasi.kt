package com.example.pertemuan13.view.controlNavigasi

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.pertemuan13.view.DetailScreen
import com.example.pertemuan13.view.EntrySiswaScreen
import com.example.pertemuan13.view.HomeScreen
import com.example.pertemuan13.view.ItemEditScreen
import com.example.pertemuan13.view.route.DestinasiDetail
import com.example.pertemuan13.view.route.DestinasiEdit
import com.example.pertemuan13.view.route.DestinasiEntry
import com.example.pertemuan13.view.route.DestinasiHome

@Composable
fun PengelolaHalaman(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = DestinasiHome.route,
        modifier = modifier
    ) {
        composable(DestinasiHome.route) {
            HomeScreen(
                navigateToItemEntry = { navController.navigate(DestinasiEntry.route) },
                onDetailClick = { itemId ->
                    navController.navigate("${DestinasiDetail.route}/$itemId")
                }
            )
        }

        composable(DestinasiEntry.route) {
            EntrySiswaScreen(navigateBack = { navController.popBackStack() })
        }

        composable(
            route = DestinasiDetail.routeWithArgs,
            arguments = listOf(navArgument(DestinasiDetail.itemIdArg) { type = NavType.StringType })
        ) {
            DetailScreen(
                navigateBack = { navController.navigateUp() },
                navigateToEditItem = { itemId ->
                    navController.navigate("${DestinasiEdit.route}/$itemId")
                }
            )
        }

        composable(
            route = DestinasiEdit.routeWithArgs,
            arguments = listOf(navArgument(DestinasiEdit.itemIdArg) { type = NavType.StringType })
        ) {
            ItemEditScreen(
                navigateBack = { navController.popBackStack() },
                onNavigateUp = { navController.navigateUp() }
            )
        }
    }
}