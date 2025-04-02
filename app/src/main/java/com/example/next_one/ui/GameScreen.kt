package com.example.next_one.ui


import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.next_one.R


@Composable
fun NextApp(modifier: Modifier = Modifier) {
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
        Spacer(modifier = modifier.weight(1f))
        TextCard()
        Spacer(modifier = modifier.weight(1.5f))
    }
}


@Composable
fun TextCard(modifier: Modifier = Modifier, gameViewModel: GameViewModel = viewModel()) {
    val gameUiState = gameViewModel.uiState.collectAsState().value

    Box(
        modifier = modifier
            .border(width = 2.dp, color = Color.White)
            .background(colorResource(R.color.light_black))
            .size(width = 300.dp, height = 200.dp)
            .padding(start = 40.dp, top = 60.dp, end = 40.dp, bottom = 60.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = modifier
                .clickable { gameViewModel.pickRandomText() },
            text = if(gameUiState.currentText.isBlank()) {
                "Click to uncover first sentence"
            } else { gameUiState.currentText },
            textAlign = TextAlign.Center,
            maxLines = 3,
            softWrap = true,
            style = TextStyle(
                color = colorResource(R.color.white),
                fontSize = 20.sp
            )
        )
    }
}


@Preview
@Composable
fun CardPreview() {
    NextApp()
}

