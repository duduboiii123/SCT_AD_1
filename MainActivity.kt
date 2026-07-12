package com.example.calculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var firstNumber = ""
    private var secondNumber = ""
    private var operator = ""
    private var isOperatorClicked = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val numberButtons = listOf(
            binding.btn0,binding.btn1,binding.btn2,binding.btn3,binding.btn4,
            binding.btn5,binding.btn6,binding.btn7,binding.btn8,binding.btn9
        )

        numberButtons.forEach { button ->
            button.setOnClickListener {

                if(!isOperatorClicked){
                    firstNumber += button.text
                    binding.tvResult.text = firstNumber
                }else{
                    secondNumber += button.text
                    binding.tvResult.text = secondNumber
                }

            }
        }

        binding.btnAdd.setOnClickListener{
            operator="+"
            isOperatorClicked=true
        }

        binding.btnSub.setOnClickListener{
            operator="-"
            isOperatorClicked=true
        }

        binding.btnMul.setOnClickListener{
            operator="*"
            isOperatorClicked=true
        }

        binding.btnDiv.setOnClickListener{
            operator="/"
            isOperatorClicked=true
        }

        binding.btnClear.setOnClickListener{
            firstNumber=""
            secondNumber=""
            operator=""
            isOperatorClicked=false
            binding.tvResult.text="0"
        }

        binding.btnEqual.setOnClickListener{

            if(firstNumber.isEmpty() || secondNumber.isEmpty()) return@setOnClickListener

            val a = firstNumber.toDouble()
            val b = secondNumber.toDouble()

            val answer = when(operator){

                "+" -> a+b
                "-" -> a-b
                "*" -> a*b
                "/" -> if(b!=0.0) a/b else 0.0
                else -> 0.0
            }

            binding.tvResult.text=answer.toString()

            firstNumber=answer.toString()
            secondNumber=""
            operator=""
            isOperatorClicked=false

        }

    }

}
