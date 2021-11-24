package com.kemsu.pi_211

import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
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

        val lesson1 = findViewById<TextView>(R.id.tvLesson1)
        val lesson2 = findViewById<TextView>(R.id.tvLesson2)
        val lesson3 = findViewById<TextView>(R.id.tvLesson3)
        val lesson4 = findViewById<TextView>(R.id.tvLesson4)
        val lesson5 = findViewById<TextView>(R.id.tvLesson5)

        val thisDay = Day(day.toString(), even.toString(), group.toString())

        when (thisDay) {
            Day("Понедельник", "Нечетная", "Первая") -> {
                lesson1.text = ""
                lesson2.text = "Русский, 5301ауд"
                lesson3.text = "Русский, 5204ауд"
                lesson4.text = "ИСиТ, 2206/1ауд"
                lesson5.text = ""
            }
            Day("Понедельник", "Четная", "Первая") -> {
                lesson1.text = ""
                lesson2.text = "ВышМат, 2206/1ауд"
                lesson3.text = "Русский, 5204ауд"
                lesson4.text = ""
                lesson5.text = ""
            }
            Day("Вторник", "Нечетная", "Первая") -> {
                lesson1.text = "Ф-ра"
                lesson2.text = "Англ. яз, 2218ауд"
                lesson3.text = "Информатика, 3205ауд"
                lesson4.text = "Программирование, 2220ауд"
                lesson5.text = ""
            }
            Day("Вторник","Четная","Первая") -> {
                lesson1.text = "Ф-ра"
                lesson2.text = "Англ. яз, 2218ауд"
                lesson3.text = ""
                lesson4.text = ""
                lesson5.text = ""
            }
            Day("Среда", "Нечетная", "Первая") -> {
                lesson1.text = "Ф-ра"
                lesson2.text = "ВышМат, 3205ауд"
                lesson3.text = "Информатика, 2220ауд"
                lesson4.text = "ИСиТ, 2220ауд"
            }
            Day("Среда", "Четная", "Первая") -> {
                lesson1.text = "История, 5104ауд"
                lesson2.text = "ВышМат, 3205ауд"
                lesson3.text = "Информатика, 2220ауд"
                lesson4.text = "ИСиТ, 2220ауд"
                lesson5.text = ""
            }
            Day("Четверг", "Нечетная", "Первая") -> {
                lesson1.text = ""
                lesson2.text = ""
                lesson3.text = "ВПД, 2220ауд"
                lesson4.text = "ВышМат, 3205ауд"
                lesson5.text = "История, 4бл"
            }
            Day("Четверг", "Четная", "Первая") -> {
                lesson1.text = ""
                lesson2.text = ""
                lesson3.text = "ВПД, 2220ауд"
                lesson4.text = "Фра, 4бл"
                lesson5.text = ""
            }
            Day("Пятница", "Нечетная", "Первая") -> {
                lesson1.text = "Программирование, 2220ауд"
                lesson2.text = "ВПД, 3205"
                lesson3.text = "Программирование, 3205ауд"
                lesson4.text = "История, 1517ауд"
                lesson5.text = ""
            }
            Day("Пятница", "Четная", "Первая") -> {
                lesson1.text = ".спи"
                lesson2.text = ".спи"
                lesson3.text = ".спи"
                lesson4.text = ".спи"
                lesson5.text = ".спи"
            }
        }
    }
}