package com.rwu780.calculatorapp

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlin.math.round

class CalculatorViewModel : ViewModel() {

    private val _numberText = mutableStateOf<String>("")
    val numberText: State<String> = _numberText

    var operatorText = mutableStateOf("")
        private set

    private val _operatorState = mutableStateOf(OperatorState())
    val operatorState = _operatorState

    private var number1: Double? = null
    private var number2: Double? = null

    private var inputNum: Double = 0.0
    private var decimalClicked: Boolean = false
    private var decimalMultipler : Double = 0.1

    private var currentOperatorSelected: Operator? = null

    fun handleAction(action: CalculatorActions) {

        when (action) {
            is CalculatorActions.NumberClicked -> {
                if (decimalClicked){
                    inputNum += action.number * decimalMultipler
                    decimalMultipler /= 10
                    _numberText.value = inputNum.toString()
                } else {
                    inputNum = inputNum * 10 + action.number
                    _numberText.value = inputNum.toInt().toString()
                }

                setOperatorState(null)
            }
            is CalculatorActions.ACClicked -> {
                _numberText.value = ""
                operatorText.value = ""
                _operatorState.value = OperatorState()
                number1 = null
                number2 = null
                resetInputNumber()
                currentOperatorSelected = null

            }
            is CalculatorActions.ReversedSignClicked -> {
                if (inputNum != 0.0) {
                    inputNum *= -1
                    _numberText.value =
                        if (decimalClicked) inputNum.toString() else inputNum.toInt().toString()
                } else {
                    number1 = -1 * number1!!
                    _numberText.value = if (decimalClicked) String.format("%.2f", number1) else number1!!.toInt().toString()

                }
            }
            is CalculatorActions.PercentedClicked -> {
                if (inputNum != 0.0) {
                    inputNum /= 100
                    _numberText.value =
                        if (decimalClicked) inputNum.toString() else inputNum.toInt().toString()
                } else {
                    number1 = number1!! / 100
                    _numberText.value = number1.toString()
                }
            }
            is CalculatorActions.OperatorClicked -> {
                if (number1 == null){
                    number1 = inputNum
                } else {
                    number2 = inputNum
                }
                calculate()

                setOperatorState(action.operator)
                currentOperatorSelected = action.operator
                operatorText.value = action.operator.symbol

                resetInputNumber()
            }
            is CalculatorActions.DecimalClicked -> {
                decimalClicked = true
                _numberText.value += "."
            }
            is CalculatorActions.EqualClicked -> {

                if (number1 == null){
                    number1 = inputNum
                } else {
                    number2 = inputNum
                }

                calculate()

                currentOperatorSelected = null
                setOperatorState(null)
                operatorText.value = ""

                resetInputNumber()

            }

        }
    }

    private fun calculate() {
        if (currentOperatorSelected == null || number1 == null || number2 == null)
            return

        when (currentOperatorSelected) {
            is Operator.Add -> {
                number1 = number1!! + number2!!
            }
            is Operator.Minus -> {
                number1 = number1!! - number2!!
            }
            is Operator.Multiply -> {
                number1 = number1!! * number2!!
            }
            is Operator.Divide -> {
                if (number2!! == 0.0){
                    return
                }

                number1 = number1!! / number2!!
            }
            else -> Unit
        }
        number2 = null

        _numberText.value = if (decimalClicked) String.format("%.2f", number1) else number1!!.toInt().toString()
    }

    private fun setOperatorState(op: Operator?){
        _operatorState.value = when (op) {
            is Operator.Add -> OperatorState(addSelected = true)
            is Operator.Minus -> OperatorState(subtractSelected = true)
            is Operator.Multiply -> OperatorState(multiplySelected = true)
            is Operator.Divide -> OperatorState(divisionSelected = true)
            else -> OperatorState()
        }
    }

    private fun resetInputNumber() {
        decimalClicked = false
        decimalMultipler = 0.1
        inputNum = 0.0
    }
}

data class OperatorState(
    val divisionSelected: Boolean = false,
    val multiplySelected: Boolean = false,
    val subtractSelected: Boolean = false,
    val addSelected: Boolean = false,
)