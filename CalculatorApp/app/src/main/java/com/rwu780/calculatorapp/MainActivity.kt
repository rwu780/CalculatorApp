package com.rwu780.calculatorapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rwu780.calculatorapp.components.CalculatorPad
import com.rwu780.calculatorapp.components.CalculatorScreen
import com.rwu780.calculatorapp.ui.theme.CalculatorAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val viewModel by viewModels<CalculatorViewModel>()

            CalculatorAppTheme {
                CalculatorApp(viewModel)
            }
        }
    }
}

@Composable
fun CalculatorApp(
    viewModel : CalculatorViewModel
) {

    Column(
        modifier = Modifier.fillMaxSize().background(Color.Black).padding(bottom = 30.dp),
        verticalArrangement = Arrangement.Bottom
    ) {
        CalculatorScreen(operatorText = viewModel.operatorText.value, numberText = viewModel.numberText.value)
        CalculatorPad(viewModel.operatorState.value) {
            viewModel.handleAction(it)
        }
    }
}

@Preview
@Composable
fun PreviewCalculatorApp() {
    CalculatorAppTheme {
//        CalculatorApp()
    }
}