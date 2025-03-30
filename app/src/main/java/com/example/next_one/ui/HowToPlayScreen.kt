package com.example.next_one.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.next_one.R

@Composable
fun HowToPlay(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .border(width = 2.dp, color = Color.White)
            .background(colorResource(R.color.light_black))
            .size(width = 300.dp, height = 200.dp)
            .padding(start = 40.dp, top = 60.dp, end = 40.dp, bottom = 60.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = modifier,
            text = "How to play preview",
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

@Composable
@Preview
fun HTPPreview() {
    HowToPlay()
}