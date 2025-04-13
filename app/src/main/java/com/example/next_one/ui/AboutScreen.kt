package com.example.next_one.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.next_one.R

@Composable
fun AboutTheGame(modifier: Modifier = Modifier) {

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlertDialogAbout(
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier
) {
    val aboutText = stringResource(id = R.string.aboutTheGameText)

    val annotatedText = remember(aboutText) {
        buildAnnotatedString {
            append(aboutText.replace("\n", "\n"))
        }
    }

    AlertDialog(
        text = {
            Text(
                text = stringResource(R.string.aboutTheGameText),
                style = TextStyle(
                    color = colorResource(R.color.white),
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center
                )
            )
        },
        onDismissRequest = onDismiss,
        confirmButton = { /*TODO*/ },
        modifier = modifier
            .wrapContentSize()
    )

}

@Composable
@Preview
fun AboutPreview() {
    AlertDialogAbout( onDismiss = {} )
}