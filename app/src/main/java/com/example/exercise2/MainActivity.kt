package com.example.exercise2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val reset : Button = findViewById(R.id.buttonReset)
        val calculateBMI : Button = findViewById(R.id.buttonCalculate)
        calculateBMI.setOnClickListener{calculateBMI()}
        reset.setOnClickListener{reset()}
    }
    private fun calculateBMI(){
        val weightInKg : EditText = findViewById(R.id.editTextWeight)
        val heightInCm : EditText = findViewById(R.id.editTextHeight)
        if(weightInKg.text.isEmpty() || heightInCm.text.isEmpty()){
            Toast.makeText(this, getString(R.string.input_error),
                Toast.LENGTH_SHORT).show()
        }else{
            val heightInMeter : Double = heightInCm.text.toString().toDouble() / 100
            val bmi : Double = weightInKg.text.toString().toDouble() / (heightInMeter * heightInMeter)
            val bmiText : TextView = findViewById(R.id.textViewBMI)
            bmiText.text = String.format("%s %.2f",getString(R.string.bmi),bmi)
            val imageBMI : ImageView = findViewById(R.id.imageViewProfile)
            if(bmi<18.5)
            {
                imageBMI.setImageResource(R.drawable.under)
            }else if(bmi in 18.5..24.9){
                imageBMI.setImageResource(R.drawable.normal)
            }
            else if(bmi>25){
                imageBMI.setImageResource(R.drawable.over)
            }
        }
    }

    private fun reset(){
        val weightInKg : EditText = findViewById(R.id.editTextWeight)
        val heightInCm : EditText = findViewById(R.id.editTextHeight)
        val bmiText : TextView = findViewById(R.id.textViewBMI)
        weightInKg.text.clear()
        heightInCm.text.clear()
        bmiText.text = getString(R.string.bmi)
        val imageBMI : ImageView = findViewById(R.id.imageViewProfile)
        imageBMI.setImageResource(R.drawable.empty)
        //weightInKg.hint = getString(R.string.weight)
        //heightInCm.hint = getString(R.string.height)
    }

}
