package com.example.dropdownmenu

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.dropdownmenu.ui.theme.DropDownMenuTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DropDownMenuTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DropdownSample()
                }
            }
        }
    }
}

@Composable
fun DropdownSample() {
    val selectedItem = remember { mutableStateOf("Brazil") }
    val dropdownState = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .clickable { dropdownState.value = true }
        ) {
            Text(
                text = selectedItem.value,
                color = Color(0xff11537D),
                modifier = Modifier
                    .clickable { dropdownState.value = true }
            )
            Image(
                painter = painterResource(R.drawable.baseline_dropdown_24),
                contentDescription = selectedItem.value,
                modifier = Modifier
                    .clickable { dropdownState.value = true }
            )
        }
        DropdownMenu(
            expanded = dropdownState.value,
            onDismissRequest = { dropdownState.value = false }
        ) {
            DropdownMenuItem(
                text = {
                    Text(text = "Brazil")

                },
                onClick = {
                    dropdownState.value = false
                    selectedItem.value = "Brazil"
                }
            )

            DropdownMenuItem(
                text = {
                    Text(text = "Ireland")

                },
                onClick = {
                    dropdownState.value = false
                    selectedItem.value = "Ireland"
                }
            )

            DropdownMenuItem(
                text = {
                    Text(text = "Canada")

                },
                onClick = {
                    dropdownState.value = false
                    selectedItem.value = "Canada"
                }
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    DropDownMenuTheme {
        DropdownSample()
    }
}