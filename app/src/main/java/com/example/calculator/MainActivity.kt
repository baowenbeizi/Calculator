package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Switch
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private val TAG: String = "Calculator"

    private lateinit var mTvResult: TextView
    private lateinit var mBtnOne: Button
    private lateinit var mBtnTwo: Button
    private lateinit var mBtnThree: Button
    private lateinit var mBtnFour: Button
    private lateinit var mBtnFive: Button
    private lateinit var mBtnSix: Button
    private lateinit var mBtnSeven: Button
    private lateinit var mBtnEight: Button
    private lateinit var mBtnNine: Button
    private lateinit var mBtnZero: Button
    private lateinit var mBtnAdd: Button
    private lateinit var mBtnSubtract: Button
    private lateinit var mBtnMultiply: Button
    private lateinit var mBtnDivide: Button
    private lateinit var mBtnCalculate: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        val onClick = OnClick()
        setClickEvent(onClick)
    }

    class OnClick: View.OnClickListener {
        override fun onClick(p0: View?) {
            when (p0?.id) {
                R.id.btn_zero -> Log.d("123","x == 0")
                R.id.btn_one -> Log.d("123","x == 1")
                R.id.btn_two -> Log.d("123","x == 2")
                R.id.btn_three -> Log.d("123","x == 3")
                R.id.btn_four -> Log.d("123","x == 4")
                R.id.btn_five -> Log.d("123","x == 5")
                R.id.btn_six -> Log.d("123","x == 6")
                R.id.btn_seven -> Log.d("123","x == 7")
                R.id.btn_eight -> Log.d("123","x == 8")
                R.id.btn_nine -> Log.d("123","x == 9")
                R.id.btn_calculate -> Log.d("123","x == 0")
                R.id.btn_add -> Log.d("123","x == +")
                R.id.btn_subtract -> Log.d("123","x == -")
                R.id.btn_multiply -> Log.d("123","x == *")
                R.id.btn_divide -> Log.d("123","x == /")
            }
        }

    }

    fun setClickEvent(onClick: OnClick) {
        mBtnCalculate.setOnClickListener(onClick)
        mBtnAdd.setOnClickListener(onClick)
        mBtnMultiply.setOnClickListener(onClick)
        mBtnSubtract.setOnClickListener(onClick)
        mBtnDivide.setOnClickListener(onClick)
        mBtnOne.setOnClickListener(onClick)
        mBtnTwo.setOnClickListener(onClick)
        mBtnThree.setOnClickListener(onClick)
        mBtnFour.setOnClickListener(onClick)
        mBtnFive.setOnClickListener(onClick)
        mBtnSix.setOnClickListener(onClick)
        mBtnSeven.setOnClickListener(onClick)
        mBtnEight.setOnClickListener(onClick)
        mBtnNine.setOnClickListener(onClick)
        mBtnZero.setOnClickListener(onClick)
    }

    fun init() {
        mTvResult = findViewById(R.id.mtv_result)
        mBtnAdd = findViewById(R.id.btn_add)
        mBtnSubtract = findViewById(R.id.btn_subtract)
        mBtnMultiply = findViewById(R.id.btn_multiply)
        mBtnDivide = findViewById(R.id.btn_divide)
        mBtnCalculate = findViewById(R.id.btn_calculate)
        mBtnOne = findViewById(R.id.btn_one)
        mBtnTwo = findViewById(R.id.btn_two)
        mBtnThree = findViewById(R.id.btn_three)
        mBtnFour = findViewById(R.id.btn_four)
        mBtnFive = findViewById(R.id.btn_five)
        mBtnSix = findViewById(R.id.btn_six)
        mBtnSeven = findViewById(R.id.btn_seven)
        mBtnEight = findViewById(R.id.btn_eight)
        mBtnNine = findViewById(R.id.btn_nine)
        mBtnZero = findViewById(R.id.btn_zero)
    }

}