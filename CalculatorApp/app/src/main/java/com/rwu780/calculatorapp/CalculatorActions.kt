package com.rwu780.calculatorapp

import android.graphics.Path

sealed class CalculatorActions {
    class NumberClicked(val number: Int): CalculatorActions()
    object ACClicked: CalculatorActions()
    object ReversedSignClicked: CalculatorActions()
    object PercentedClicked: CalculatorActions()
    class OperatorClicked(val operator: Operator): CalculatorActions()
    object DecimalClicked: CalculatorActions()
    object EqualClicked: CalculatorActions()
}

sealed class Operator(val symbol: String){
    object Add : Operator("+")
    object Minus : Operator("-")
    object Multiply : Operator("×")
    object Divide : Operator("÷")
}
