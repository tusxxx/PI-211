package com.kemsu.pi_211

import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.btFind)
        button.setOnClickListener {
            setDay()
        }
    }

    fun setDay() {
        val day = findViewById<Spinner>(R.id.spinDay).selectedItem
        val even = findViewById<Spinner>(R.id.spinEven).selectedItem
        val group = findViewById<Spinner>(R.id.spinGroup).selectedItem
        val time1: TextView = findViewById(R.id.tvTime1)
        val time2: TextView = findViewById(R.id.tvTime2)
        val time3: TextView = findViewById(R.id.tvTime3)
        val time4: TextView = findViewById(R.id.tvTime4)
        val time5: TextView = findViewById(R.id.tvTime5)
        val lesson1: TextView = findViewById(R.id.tvLesson1)
        val lesson2: TextView = findViewById(R.id.tvLesson2)
        val lesson3: TextView = findViewById(R.id.tvLesson3)
        val lesson4: TextView = findViewById(R.id.tvLesson4)
        val lesson5: TextView = findViewById(R.id.tvLesson5)

        if (even == "Не четная"&& day == "Понедельник" && group == "Первая") {
            time1.text = "9.45"
            lesson1.text = "Русский язык - 5301 аудю"
        } else if (even == "Четная" && day == "Понедельник" && group == "Первая") {
            time1.text = "9.45"
            lesson1.text = "ВышМат"
        }

    }
}