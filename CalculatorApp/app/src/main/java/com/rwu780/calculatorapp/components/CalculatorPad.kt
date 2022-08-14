package com.rwu780.calculatorapp.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rwu780.calculatorapp.CalculatorActions
import com.rwu780.calculatorapp.Operator
import com.rwu780.calculatorapp.OperatorState
import com.rwu780.calculatorapp.ui.theme.*

@Composable
fun CalculatorPad(
    operatorState: OperatorState,
    modifier: Modifier = Modifier,
    onButtonClicked: (CalculatorActions) -> Unit
) {
    val spacer = 16.dp
    Column(
        modifier = modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(spacer)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(spacer)
        ) {
            CalculatorButton(
                text = "AC",
                onClick = {
                    onButtonClicked(CalculatorActions.ACClicked)
                },
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                backgroundColor = LightGrey,
                textColor = ColorBlack
            )
            CalculatorButton(
                text = "+/-", onClick = {
                    onButtonClicked(CalculatorActions.ReversedSignClicked)
                }, modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                backgroundColor = LightGrey,
                textColor = ColorBlack
            )
            CalculatorButton(
                text = "%", onClick = {
                    onButtonClicked(CalculatorActions.PercentedClicked)
                }, modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                backgroundColor = LightGrey,
                textColor = ColorBlack
            )
            CalculatorButton(
                text = "÷", onClick = {
                    onButtonClicked(CalculatorActions.OperatorClicked(Operator.Divide))
                }, modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                backgroundColor = if (operatorState.divisionSelected) ColorWhite else ColorYellow,
                textColor = if (operatorState.divisionSelected) ColorYellow else ColorWhite
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(spacer)
        ) {
            CalculatorButton(
                text = "7", onClick = {
                    onButtonClicked(CalculatorActions.NumberClicked(7))
                }, modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                backgroundColor = Color.DarkGray,
                textColor = ColorWhite
            )
            CalculatorButton(
                text = "8", onClick = {
                    onButtonClicked(CalculatorActions.NumberClicked(8))
                }, modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                backgroundColor = Color.DarkGray,
                textColor = ColorWhite
            )
            CalculatorButton(
                text = "9", onClick = {
                    onButtonClicked(CalculatorActions.NumberClicked(9))
                }, modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                backgroundColor = Color.DarkGray,
                textColor = ColorWhite
            )
            CalculatorButton(
                text = "×", onClick = {
                    onButtonClicked(CalculatorActions.OperatorClicked(Operator.Multiply))
                }, modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                backgroundColor = if (operatorState.multiplySelected) ColorWhite else ColorYellow,
                textColor = if (operatorState.multiplySelected) ColorYellow else ColorWhite
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(spacer)
        ) {
            CalculatorButton(
                text = "4", onClick = {
                    onButtonClicked(CalculatorActions.NumberClicked(4))
                }, modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                backgroundColor = Color.DarkGray,
                textColor = ColorWhite
            )
            CalculatorButton(
                text = "5", onClick = {
                    onButtonClicked(CalculatorActions.NumberClicked(5))
                }, modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                backgroundColor = Color.DarkGray,
                textColor = ColorWhite
            )
            CalculatorButton(
                text = "6", onClick = {
                    onButtonClicked(CalculatorActions.NumberClicked(6))
                }, modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                backgroundColor = Color.DarkGray,
                textColor = ColorWhite
            )
            CalculatorButton(
                text = "-", onClick = {
                    onButtonClicked(CalculatorActions.OperatorClicked(Operator.Minus))
                }, modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                backgroundColor = if (operatorState.subtractSelected) ColorWhite else ColorYellow,
                textColor = if (operatorState.subtractSelected) ColorYellow else ColorWhite
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(spacer)
        ) {
            CalculatorButton(
                text = "1", onClick = {
                    onButtonClicked(CalculatorActions.NumberClicked(1))
                }, modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                backgroundColor = Color.DarkGray,
                textColor = ColorWhite
            )
            CalculatorButton(
                text = "2", onClick = {
                    onButtonClicked(CalculatorActions.NumberClicked(2))
                }, modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                backgroundColor = Color.DarkGray,
                textColor = ColorWhite
            )
            CalculatorButton(
                text = "3", onClick = {
                    onButtonClicked(CalculatorActions.NumberClicked(3))
                }, modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                backgroundColor = Color.DarkGray,
                textColor = ColorWhite
            )
            CalculatorButton(
                text = "+", onClick = {
                    onButtonClicked(CalculatorActions.OperatorClicked(Operator.Add))
                }, modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                backgroundColor = if (operatorState.addSelected) ColorWhite else ColorYellow,
                textColor = if (operatorState.addSelected) ColorYellow else ColorWhite
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            CalculatorButton(
                text = "0",
                onClick = {
                    onButtonClicked(CalculatorActions.NumberClicked(0))
                },
                modifier = Modifier
                    .aspectRatio(2f)
                    .weight(2f),
                backgroundColor = Color.DarkGray,
                textColor = ColorWhite
            )
            CalculatorButton(
                text = ".",
                onClick = {
                    onButtonClicked(CalculatorActions.DecimalClicked)
                },
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                backgroundColor = Color.DarkGray,
                textColor = ColorWhite
            )
            CalculatorButton(
                text = "=",
                onClick = {
                    onButtonClicked(CalculatorActions.EqualClicked)
                },
                modifier = Modifier
                    .aspectRatio(1f)
                    .weight(1f),
                backgroundColor = ColorYellow,
                textColor = ColorWhite
            )
        }

    }
}

@Preview
@Composable
fun PreviewCalculatorPad() {
    CalculatorAppTheme {
        CalculatorPad(
            operatorState = OperatorState(true, false, true, false)
        ) {

        }
    }

}