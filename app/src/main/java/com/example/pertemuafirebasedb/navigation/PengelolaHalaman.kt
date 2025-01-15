package com.example.pertemuafirebasedb.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pertemuafirebasedb.ui.home.pages.DetailScreen
import com.example.pertemuafirebasedb.ui.home.pages.HomeScreen
import com.example.pertemuafirebasedb.ui.home.pages.InsertView

@Composable
fun PengelolaHalman(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
){
    NavHost(
        navController = navController,
        startDestination = DestinasiHome.route,
        modifier = Modifier
    ){
        composable(DestinasiHome.route){
            HomeScreen(
                onDetailClick = {nim ->
                    navController.navigate("${DestinasiDetail.route}/$nim")
                },
                navigateToItemEntry = {
                    navController.navigate(DestinasiInsert.route)
                }
            )
        }
        composable(DestinasiInsert.route){
            InsertView(
                onBack = {navController.popBackStack() },
                onNavigate = {
                    navController.navigate(DestinasiHome.route)
                }
            )
        }
        composable(DestinasiDetail.routesWithArg){

        }
    }
}