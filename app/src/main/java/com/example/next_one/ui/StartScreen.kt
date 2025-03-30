package com.example.next_one.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.next_one.R

@Composable
fun NextAppStartingScreen(navController: NavController, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(colorResource(R.color.black)),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 80.dp),
            text = stringResource(R.string.app_name),
            textAlign = TextAlign.Center,
            style = TextStyle(
                color = colorResource(R.color.white),
                fontSize = 50.sp,
                fontWeight = FontWeight.Bold
            )
        )
        Spacer(modifier.weight(1f))
        SelectionMenu(navController)
        Spacer(modifier.weight(1f))
    }
}

@Composable
fun SelectionMenu(navController: NavController, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
    ) {
        val menuItems = listOf("Start", "How to play", "About")
        menuItems.forEachIndexed { index, label ->
            MenuItem(label, index = index, onButtonClicked = { selectedIndex ->
                when(selectedIndex) {
                    0 -> navController.navigate("game_Screen")
                    1 -> navController.navigate("htp_Screen")
                    2 -> navController.navigate("about_Screen")
                }
            }
            )
            if(index < menuItems.size - 1) Spacer(modifier.height(16.dp)) //Ensures that there is space between elements but not after last one
        }
    }
}

@Composable
fun MenuItem(
    text: String,
    index: Int,
    onButtonClicked: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .border(width = 2.dp, color = Color.White)
            .background(colorResource(R.color.light_black))
            .size(width = 200.dp, height = 50.dp)
            .clickable { onButtonClicked(index) },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            style = TextStyle(
                color = colorResource(R.color.white),
                fontSize = 25.sp,
            fontWeight = FontWeight.Bold
            )
        )
    }
}

@Composable
@Preview
fun AppPreview() {
    NextAppStartingScreen(navController = rememberNavController())
}