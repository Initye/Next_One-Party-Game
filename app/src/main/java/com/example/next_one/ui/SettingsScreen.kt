package com.example.next_one.ui

import android.R.attr.onClick
import android.app.Activity
import androidx.compose.runtime.Composable
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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

import com.example.next_one.ui.HowToPlay
import com.example.next_one.ui.SettingsScreen
import kotlin.String
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.zIndex
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.next_one.LanguageUtils
import kotlin.math.exp
import androidx.compose.ui.platform.LocalContext
import com.example.next_one.MainActivity
import java.io.StringReader


@Composable
fun SettingsScreen(modifier: Modifier = Modifier) {

    //Title text
    Column(
        modifier = modifier
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
                fontSize = 60.sp,
                fontWeight = FontWeight.Bold
            )
        )
        Spacer(modifier.weight(0.2f))
        LanguageSetting()
        Spacer(modifier.padding(10.dp))
        MatureContentSetting()
        Spacer(modifier.weight(1f))
    }
}

@Composable
fun LanguageSetting(
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current

    //Stan z SharedPreferences
    LaunchedEffect(Unit) {
        LanguageUtils.currentLanguage.value =
            LanguageUtils.getSavedLanguage(context) ?: "en"
    }
    val currentLang = LanguageUtils.currentLanguage.value

    Column(
        modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text(
            text = stringResource(R.string.language),
            style = TextStyle(
                color = colorResource(R.color.white),
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
            )
        )
        Spacer(modifier.padding(8.dp))
        Row(
            modifier = modifier
                .wrapContentWidth(),
            horizontalArrangement = Arrangement.spacedBy(36.dp)
        ) {
            Box(
                modifier = modifier
                    .border(width = 2.dp, color = Color.White)
                    .background(
                        if (currentLang == "en")
                            colorResource(R.color.teal_700)
                        else
                            colorResource(R.color.light_black)
                    )
                    .size(width = 100.dp, height = 50.dp)
                    .clickable {
                        LanguageUtils.setLanguage(context, "en")
                        (context as? Activity)?.recreate()
                    },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "English",
                    style = TextStyle(
                        color = colorResource(R.color.white),
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
                Box(
                    modifier = modifier
                        .border(width = 2.dp, color = Color.White)
                        .background(
                            if (currentLang == "pl")
                                colorResource(R.color.teal_700)
                            else
                                colorResource(R.color.light_black)
                        )
                        .size(width = 100.dp, height = 50.dp)
                        .clickable {
                            LanguageUtils.setLanguage(context, "pl")
                            (context as? Activity)?.recreate()
                                   },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Polski",
                        style = TextStyle(
                            color = colorResource(R.color.white),
                            fontSize = 25.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                }
        }
    }
}
@Composable
fun MatureContentSetting(
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current

    //Stan z SharedPreferences
    LaunchedEffect(Unit) {
        LanguageUtils.matureContentEnabled.value =
            LanguageUtils.getMatureContentEnabled(context)
    }

    val isMatureEnabled = LanguageUtils.matureContentEnabled.value

    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.mature_content),
            style = TextStyle(
                color = colorResource(R.color.white),
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
            )
        )
        Spacer(modifier = Modifier.padding(8.dp))
        Row(
            horizontalArrangement = Arrangement.spacedBy(36.dp)
        ) {
            // NO button
            Box(
                modifier = Modifier
                    .border(width = 2.dp, color = Color.White)
                    .background(
                        if (!isMatureEnabled)
                            colorResource(R.color.teal_700)
                        else
                            colorResource(R.color.light_black)
                    )
                    .size(width = 100.dp, height = 50.dp)
                    .clickable {
                        LanguageUtils.setMatureContent(context, false)
                    },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(R.string.no),
                    style = TextStyle(
                        color = colorResource(R.color.white),
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }

            // YES button
            Box(
                modifier = Modifier
                    .border(width = 2.dp, color = Color.White)
                    .background(
                        if (isMatureEnabled)
                            colorResource(R.color.teal_700)
                        else
                            colorResource(R.color.light_black)
                    )
                    .size(width = 100.dp, height = 50.dp)
                    .clickable {
                        LanguageUtils.setMatureContent(context, true)
                    },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(R.string.yes),
                    style = TextStyle(
                        color = colorResource(R.color.white),
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        }
    }
}






@Composable
@Preview
fun SettingsPreview() {
    SettingsScreen()
}