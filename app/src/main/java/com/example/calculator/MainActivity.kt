package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.lang.StringBuilder

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val TAG: String = "Calculator"

    private val numList: ArrayList<Long> = ArrayList()
    private val operateList: ArrayList<Char> = ArrayList()
    private val mixList: ArrayList<String> = ArrayList()

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
    private lateinit var mBtnCln: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        setClickEvent()
    }

    fun addNum(num: Long) {
        if (numList.size == 0 || operateList.size == numList.size) {
            numList.add(num)
            mixList.add(num.toString())
        } else {
            val numPlus: Long = numList.get(numList.size - 1) * 10 + num
            numList.set(numList.size - 1, numPlus)
            mixList.set(mixList.size - 1, numPlus.toString())
        }
        show(mixList)
    }

    fun addOperate(operate: Char) {
        if (numList.size == 0) return
        if (operateList.size < numList.size) {
            operateList.add(operate)
            mixList.add(operate.toString())
        } else if (operateList.size == numList.size) {
            operateList.set(operateList.size - 1, operate)
            mixList.set(mixList.size - 1, operate.toString())
        }
        show(mixList)
    }

    fun calculate(): String {
        for (i in mixList.indices) {
            if (i > mixList.size - 1) break;
            if (mixList.get(i).equals("*")) {
                val tmp: Long = mixList.get(i - 1).toLong() * mixList.get(i + 1).toLong()
                mixList.set(i - 1, tmp.toString())
                mixList.removeAt(i)
                mixList.removeAt(i)
            } else if (mixList.get(i).equals("/")) {
                if (mixList.get(i + 1).equals("0")) break;
                val tmp: Long = mixList.get(i - 1).toLong() / mixList.get(i + 1).toLong()
                mixList.set(i - 1, tmp.toString())
                mixList.removeAt(i)
                mixList.removeAt(i)
            }
        }

        for(i in mixList.indices) {
            if (i > mixList.size - 1) break;
            if (mixList.get(i).equals("+")) {
                val tmp: Long = mixList.get(i - 1).toLong() + mixList.get(i + 1).toLong()
                mixList.set(i - 1, tmp.toString())
                mixList.removeAt(i)
                mixList.removeAt(i)
            } else if (mixList.get(i).equals("-")) {
                val tmp: Long = mixList.get(i - 1).toLong() - mixList.get(i + 1).toLong()
                mixList.set(i - 1, tmp.toString())
                mixList.removeAt(i)
                mixList.removeAt(i)
            }
        }
        return mixList.toString()
    }

    fun cln() {
        numList.clear()
        operateList.clear()
        mTvResult.setText("0")
    }

    fun equal() {
        if (operateList.size == 0) return
        if (numList.size == operateList.size) {
            mixList.removeAt(mixList.size - 1)
            operateList.removeAt(operateList.size - 1)
        }
        calculate()
        show(mixList)
    }

    fun show(list: ArrayList<String>) {
        if (list.size == 0) mTvResult.setText("0")
        var sb: StringBuilder  = StringBuilder()
        for (item in list) {
            sb.append(item)
            mTvResult.setText(sb)
        }
    }

    fun setClickEvent() {
        mBtnCalculate.setOnClickListener(this)
        mBtnAdd.setOnClickListener(this)
        mBtnMultiply.setOnClickListener(this)
        mBtnSubtract.setOnClickListener(this)
        mBtnDivide.setOnClickListener(this)
        mBtnOne.setOnClickListener(this)
        mBtnTwo.setOnClickListener(this)
        mBtnThree.setOnClickListener(this)
        mBtnFour.setOnClickListener(this)
        mBtnFive.setOnClickListener(this)
        mBtnSix.setOnClickListener(this)
        mBtnSeven.setOnClickListener(this)
        mBtnEight.setOnClickListener(this)
        mBtnNine.setOnClickListener(this)
        mBtnZero.setOnClickListener(this)
        mBtnCln.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        Log.d("baowenbei", "click")
        when (p0?.id) {
            R.id.btn_zero -> addNum(0)
            R.id.btn_one -> addNum(1)
            R.id.btn_two -> addNum(2)
            R.id.btn_three -> addNum(3)
            R.id.btn_four -> addNum(4)
            R.id.btn_five -> addNum(5)
            R.id.btn_six -> addNum(6)
            R.id.btn_seven -> addNum(7)
            R.id.btn_eight -> addNum(8)
            R.id.btn_nine -> addNum(9)
            R.id.btn_calculate -> equal()
            R.id.btn_add -> addOperate('+')
            R.id.btn_subtract -> addOperate('-')
            R.id.btn_multiply -> addOperate('*')
            R.id.btn_divide -> addOperate('/')
            R.id.btn_clean -> cln()
        }
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
        mBtnCln = findViewById(R.id.btn_clean)
    }

}