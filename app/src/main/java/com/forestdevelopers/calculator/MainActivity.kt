 package com.forestdevelopers.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    private lateinit var text_display: TextView
    private var input1 = ""
    private var input2 = ""
    private var operation = ""
    private var numberFloatCheck = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.text_display)
        text_display = findViewById(R.id.text_equation)
    }

    fun buttonClick(view:View) {

        when(view.id) {

            R.id.button_one -> {
                textView.append("1")
                text_display.append("1")
            }
            R.id.button_two -> {
                textView.append("2")
                text_display.append("2")
            }
            R.id.button_three -> {
                textView.append("3")
                text_display.append("3")
            }
            R.id.button_four -> {
                textView.append("4")
                text_display.append("4")

            }
            R.id.button_five -> {
                textView.append("5")
                text_display.append("5")
            }
            R.id.button_six -> {
                textView.append("6")
                text_display.append("6")
            }
            R.id.button_seven -> {
                textView.append("7")
                text_display.append("7")
            }
            R.id.button_eight -> {
                textView.append("8")
                text_display.append("8")
            }
            R.id.button_nine -> {
                textView.append("9")
                text_display.append("9")
            }
            R.id.button_zero -> {
                textView.append("0")
                text_display.append("0")
            }
            R.id.button_dot -> {
                textView.append(".")
                text_display.append(".")
                numberFloatCheck = true
            }

            R.id.button_percent -> {
                text_display.append("%")
                operation = "percent"
                initializePercentVariable()
                clearResult()
            }

            R.id.button_plus -> {
                initializeVariableFirst()
                operation = "add"
                text_display.append("+")
                clearResult()
            }
            R.id.button_minus -> {
                if (text_display.text == "" && textView.text == "")
                {
                    text_display.append("-")
                    textView.append("-")
                    return
                }
                initializeVariableFirst()
                operation = "sub"
                text_display.append("-")
                clearResult()
            }
            R.id.button_mul -> {
               initializeVariableFirst()
                operation = "mul"
                text_display.append("x")
                clearResult()
            }
            R.id.button_div -> {
                initializeVariableFirst()
                operation = "div"
                text_display.append("/")
                clearResult()
            }
            R.id.button_equal -> initializeVariableSecond()
            R.id.button_Clear -> {
                clearResult()
                clearResultLater()
            }

        }
    }

    private fun initializePercentVariable() {
        try {
                val input = textView.text.toString().toDouble()
                val number = input / 100
                input1 = number.toString()
                Toast.makeText(baseContext,number.toString(),Toast.LENGTH_LONG).show()

        }catch (e:Exception) {
            Toast.makeText(baseContext,"Enter Correct Number", Toast.LENGTH_SHORT).show()
        }

    }

    private fun initializeVariableFirst() {
        try {
            input1 = textView.text.toString()
        }
        catch (e:Exception) {
            Toast.makeText(baseContext,"Enter Correct Number", Toast.LENGTH_SHORT).show()
        }
    }

    private fun initializeVariableSecond() {
        try {
            input2 = textView.text.toString()
            Toast.makeText(baseContext,input2,Toast.LENGTH_LONG).show()
            result()
        }
        catch (e:Exception) {
            Toast.makeText(baseContext,"Enter Correct Number", Toast.LENGTH_SHORT).show()
        }
    }

    private fun clearResult() {
        textView.text = null
    }

    private fun clearResultLater() {
        text_display.text = null
    }

    private fun result() {
        when(operation) {
            "add" -> {
                if (numberFloatCheck) {
                    val result: Double = input1.toDouble() + input2.toDouble()
                    textView.text = result.toString()
                }
                else {
                    val result: Int = Integer.parseInt(input1) + Integer.parseInt(input2)
                    textView.text = result.toString()
                }
            }
            "sub" -> {
                if (numberFloatCheck) {
                    val result: Double = input1.toDouble() - input2.toDouble()
                    textView.text = result.toString()
                }
                else {
                    val result: Int = Integer.parseInt(input1) - Integer.parseInt(input2)
                    textView.text = result.toString()
                }

            }

            "mul" -> {
                if (numberFloatCheck) {
                    val result: Double = input1.toDouble() * input2.toDouble()
                    textView.text = result.toString()
                }
                else {
                    val result: Int = Integer.parseInt(input1) * Integer.parseInt(input2)
                    textView.text = result.toString()
                }
            }

            "div" -> {
                if (input2 == "0")
                {
                    textView.text = getString(R.string.infinity)
                    return
                }
                if (numberFloatCheck) {
                    val result: Double = input1.toDouble() / input2.toDouble()
                    textView.text = result.toString()
                }
                else {
                    val result: Int = Integer.parseInt(input1) / Integer.parseInt(input2)
                    textView.text = result.toString()
                }
            }
            "percent" -> {
                    val result: Double = input1.toDouble() * input2.toDouble()
                    textView.text = result.toString()
            }
        }
        numberFloatCheck = false
    }
}