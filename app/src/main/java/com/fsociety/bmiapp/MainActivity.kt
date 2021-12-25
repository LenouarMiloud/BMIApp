package com.fsociety.bmiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    var height: Double? = 0.0
    var weight: Double? = 0.0
    var BMI : Double? = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.calculateBMI).setOnClickListener(View.OnClickListener {
            height =  heightInput.text.toString().toDouble()
            weight =  weightInput.text.toString().toDouble()
            if((height!! >0) && (weight!! >0)){
                BMI = weight!! / (height!! * height!!)
                //Weight Category
                if(BMI!! < 18.5){
                    bmiValueText.text = "BMI = ${DecimalFormat("##.##").format(BMI!!)}"
                    rootContainer.setBackgroundResource(R.color.underweightColor)
                }else if((BMI!! >= 18.5)&&(BMI!! <= 24.9)){
                    bmiValueText.text = "BMI = ${DecimalFormat("##.##").format(BMI!!)}"
                    rootContainer.setBackgroundResource(R.color.normalColor)
                }else if((BMI!! >= 25)&&(BMI!! <= 29.9)){
                    bmiValueText.text = "BMI = ${DecimalFormat("##.##").format(BMI!!)}"
                    rootContainer.setBackgroundResource(R.color.overweightColor)
                }else if((BMI!! >= 30)&&(BMI!! <= 34.9)){
                    bmiValueText.text = "BMI = ${DecimalFormat("##.##").format(BMI!!)}"
                    rootContainer.setBackgroundResource(R.color.obeseColor)
                }else if(BMI!! > 35){
                    bmiValueText.text = "BMI = ${DecimalFormat("##.##").format(BMI!!)}"
                    rootContainer.setBackgroundResource(R.color.extremlyObeseColor)
                }
            }else{
                Toast.makeText(this," Enter a valid value",Toast.LENGTH_LONG).show()
            }

        })


    }
}




