package com.example.calculator

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {
    private val _equationText = MutableLiveData("")
    val equationText: LiveData<String> = _equationText

    private val _resultText = MutableLiveData("")
    val resultText: LiveData<String> = _resultText

    private val _historyList = MutableLiveData<List<String>>(emptyList())
    val historyList: LiveData<List<String>> = _historyList

    private var lastOperator: String? = null

    fun onButtonClick(btn: String) {
        val currentEquation = _equationText.value ?: ""
        when (btn) {
            "AC" -> reset()
            "DEL" -> deleteLastCharacter()
            "=" -> calculateAndSave()
            else -> {
                if (isOperator(btn)) {
                    if (lastOperator == btn) return
                    lastOperator = btn
                } else {
                    lastOperator = null
                }
                _equationText.value = currentEquation + btn
                calculateResult()
            }
        }
    }

    private fun reset() {
        _equationText.value = ""
        _resultText.value = "0"
    }

    private fun deleteLastCharacter() {


        if (_equationText.value.isNullOrEmpty()) {
            _resultText.value = ""  // Reset result if no input is available
        } else {
            _equationText.value = _equationText.value?.dropLast(1)

            if (_equationText.value.isNullOrEmpty()) {
                _resultText.value = ""
            } else {
                calculateResult()
            }
        }


    }

    private fun calculateAndSave() {
        val result = _resultText.value
        if (!result.isNullOrEmpty()) {
            _historyList.value = _historyList.value?.plus("${_equationText.value} = $result")
            _equationText.value = result
        }
    }

    private fun calculateResult() {
        try {
            _resultText.value = calculateExpression(_equationText.value.toString())
        } catch (e: Exception) {
            _resultText.value = "Error"
        }
    }

    private fun calculateExpression(expression: String): String {
        val context: org.mozilla.javascript.Context = org.mozilla.javascript.Context.enter()
        context.optimizationLevel = -1
        val scriptable: org.mozilla.javascript.Scriptable = context.initStandardObjects()
        var result = context.evaluateString(scriptable, expression, "JavaScript", 1, null).toString()
        if (result.endsWith(".0")) result = result.replace(".0", "")
        return result
    }

    private fun isOperator(char: String) = char in listOf("+", "-", "*", "/", ".")

    fun clearHistory() {
        _historyList.value = emptyList()
    }
}

//change1