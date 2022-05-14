package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.lang.StringBuilder

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var numCount = 0
    private var operateCount = 0
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
        // 进行控件绑定
        init()
        // 设置点击事件
        setClickEvent()
        // 首次进入，重置一次程序
        cln()
    }

    /**
     * 点击数字时调用此函数
     * */
    fun addNum(num: Long) {
        if (operateCount == numCount) {
            // 当前为1位的数字
            numCount++
            mixList.add(num.toString())
        } else {
            // 当前为多位的数字
            val numPlus: Long = mixList.get(mixList.size - 1).toLong() * 10 + num
            mixList.set(mixList.size - 1, numPlus.toString())
        }
        // 实时展示界面变化
        show(mixList)
    }

    /**
     * 点击运算符时调用此函数
     * */
    fun addOperate(operate: Char) {
        if (numCount == 0) return
        if (operateCount < numCount) {
            operateCount++
            mixList.add(operate.toString())
        } else if (operateCount == numCount) {
            mixList.set(mixList.size - 1, operate.toString())
        }
        show(mixList)
    }

    /**
     * 具体的计算函数
     * */
    fun calculate() {
        // 优先进行乘除运算
        for (i in mixList.indices) {
            // 兜底判断，防止后续的删除操作导致List长度减小，导致下标溢出
            if (i > mixList.size - 1) break;
            if (mixList.get(i).equals("*")) {
                // 计算“乘”
                val tmp: Long = mixList.get(i - 1).toLong() * mixList.get(i + 1).toLong()
                // 更新值并删除相关操作数
                mixList.set(i - 1, tmp.toString())
                mixList.removeAt(i)
                mixList.removeAt(i)
            } else if (mixList.get(i).equals("/")) {
                // 对非法输入“除0”进行判断
                if (mixList.get(i + 1).equals("0")) break;
                val tmp: Long = mixList.get(i - 1).toLong() / mixList.get(i + 1).toLong()
                mixList.set(i - 1, tmp.toString())
                mixList.removeAt(i)
                mixList.removeAt(i)
            }
        }

        // 进行加减运算
        for(i in mixList.indices) {
            // 兜底判断，防止后续的删除操作导致List长度减小，导致下标溢出
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
    }

    /**
     * 点击“=”后调用此函数
     * */
    fun equal() {
        // 当前只输入数字，不需要计算，直接返回
        if (operateCount == 0) return
        // 当前最后一位为运算符，不合法，对最后一位运算符进行删除
        if (operateCount == numCount) {
            mixList.removeAt(mixList.size - 1)
        }
        // 计算表达式的值
        calculate()
        // 进行界面展示
        show(mixList)
    }

    /**
     * 重置操作
     * */
    fun cln() {
        operateCount = 0
        numCount = 0
        mixList.clear()
        mTvResult.setText("0")
    }

    /**
     * 构建表达式的String形式并展示
     * */
    fun show(list: ArrayList<String>) {
        if (list.size == 0) mTvResult.setText("0")
        var sb = StringBuilder()
        for (item in list) {
            sb.append(item)
        }
        mTvResult.setText(sb)
    }

    /**
     * 设置点击事件
     * */
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

    /**
     * 点击事件的具体代码
     * */
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

    /**
     * 对控件进行初始化
     * */
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