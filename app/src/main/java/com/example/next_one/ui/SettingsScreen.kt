package com.example.next_one.ui

import androidx.compose.runtime.Composable
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import androidx.navigation.compose.rememberNavController
import com.example.next_one.ui.NextApp
import com.example.next_one.ui.theme.Next_OneTheme
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost
import com.example.next_one.R
import com.example.next_one.ui.NextAppStartingScreen
import com.example.next_one.ui.AboutScreen
import com.example.next_one.ui.HowToPlay
import com.example.next_one.ui.SettingsScreen
import kotlin.String
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.zIndex
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlin.math.exp


@Composable
fun SettingsScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(colorResource(R.color.black)),
        horizontalAlignment = Alignment.CenterHorizontally,)
    {
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
        SettingsOptions()
        Spacer(modifier.weight(1f))
    }
}

@Composable
fun SettingsOptions(modifier: Modifier = Modifier) {
    val items = listOf("Language", "Mature Content", "Theme")
    var selectedSetting by remember { mutableStateOf<Int?>(null) } //State of selected setting
    var expanded by remember { mutableStateOf(false) }

    Column{
        items.forEachIndexed { index, label ->
            SettingsBox(index = index, text = label, onButtonClicked = { selectedIndex ->
                selectedSetting = if (selectedSetting == selectedIndex) null else selectedIndex
            }
            )
            if (selectedSetting == index)
                Box(Modifier.zIndex(100f)) {
                    when (index) {
                        0 -> LanguageDropDown(expanded = !expanded, onDismiss = { selectedSetting = null })
                        1 -> {}
                        2 -> {}
                    }
                }
            if (index < items.size - 1) Spacer(modifier.height(16.dp))
        }
    }
}

@Composable
fun SettingsBox(
    modifier: Modifier = Modifier,
    index: Int,
    onButtonClicked: (Int) -> Unit,
    text: String,
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
fun LanguageDropDown(
    gameViewModel: GameViewModel = viewModel(),
    expanded: Boolean, onDismiss: () -> Unit,
    modifier: Modifier = Modifier)
{
    val gameUiState = gameViewModel.uiState.collectAsState().value

    DropdownMenu(
        expanded = expanded,
        onDismissRequest = onDismiss ,
        modifier = modifier
            .width(200.dp),
    ){
        DropdownMenuItem(
            text = { Text("English") },
            onClick = {
                gameViewModel.updateLanguage("English")
            }
        )
        DropdownMenuItem(
            text = { Text("Polish") },
            onClick = {
                gameViewModel.updateLanguage("Polish")
            }
        )
    }
}


@Composable
@Preview
fun SettingsPreview() {
    SettingsScreen()
}