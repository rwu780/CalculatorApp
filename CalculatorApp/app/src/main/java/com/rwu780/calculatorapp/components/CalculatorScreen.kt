package com.rwu780.calculatorapp.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.rwu780.calculatorapp.ui.theme.ColorWhite

@Composable
fun CalculatorScreen(
    operatorText: String,
    numberText: String,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 4.dp),
            contentAlignment = Alignment.CenterEnd
        ) {
            Text(
                text = operatorText,
                style = MaterialTheme.typography.displayMedium,
                color = ColorWhite,
                maxLines = 1
            )
        }

        Box(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 4.dp),
            contentAlignment = Alignment.CenterEnd
        ) {
            Text(
                text = numberText,
                style = MaterialTheme.typography.displayLarge,
                color = ColorWhite,
                maxLines = 1

            )
        }


    }
}
