package com.kemsu.pi_211.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.kemsu.pi_211.R
import com.kemsu.pi_211.databinding.ActivityMainBinding
import timber.log.Timber

//val date = Calendar.getInstance().time
//val dayOfWeek = SimpleDateFormat("EEEE").format(date.time)
//var whatWeek: String = ""

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initBottomNavigation()
    }

    private fun initBottomNavigation() {
        binding.bnMain.setupWithNavController(findNavController(R.id.frMain))
    }


//    private fun setToday() {
//        val daySpinner = findViewById<Spinner>(R.id.spinDay)
//        val evenSpinner = findViewById<Spinner>(R.id.spinEven)
//        val groupSpinner = findViewById<Spinner>(R.id.spinGroup)
//
//        when (dayOfWeek) {
//            "понедельник" -> daySpinner.setSelection(0)
//            "вторник" -> daySpinner.setSelection(1)
//            "среда" -> daySpinner.setSelection(2)
//            "четверг" -> daySpinner.setSelection(3)
//            "пятница" -> daySpinner.setSelection(4)
//        }
//
//        Thread {
//            try {
//                val doc = Jsoup.connect("https://kemsu.ru/education/schedule//").get()
//                whatWeek =
//                    doc.select("body > main > div > div > div > div.calendar-week > div:nth-child(2)")
//                        .text()
//            } catch (e: Exception) {
//                runOnUiThread {
//                    evenSpinner.setSelection(0)
//                }
//            }
//            runOnUiThread {
//                if (whatWeek.contains("нечетная")) {
//                    evenSpinner.setSelection(1)
//                } else {
//                    evenSpinner.setSelection(0)
//                }
//            }
//            Thread.sleep(1000)
//            setDay()
//        }.start()
//
//        val groupState = getSharedPreferences("Group state", MODE_PRIVATE)
//        groupSpinner.setSelection(groupState.getInt("Group", 0))
//    }
//
//
//    private fun setDay() {
//        val day = findViewById<Spinner>(R.id.spinDay).selectedItem
//        val even = findViewById<Spinner>(R.id.spinEven).selectedItem
//        val group = findViewById<Spinner>(R.id.spinGroup).selectedItem
//        val groupSpinner = findViewById<Spinner>(R.id.spinGroup)
//        val thisDay = Day(day.toString(), even.toString(), group.toString())
//
//        val groupState: SharedPreferences.Editor =
//            getSharedPreferences("Group state", MODE_PRIVATE).edit()
//        groupState.putInt("Group", groupSpinner.selectedItemPosition)
//        groupState.apply()
//
//        val lesson1 = findViewById<TextView>(R.id.tvLesson1)
//        val lesson2 = findViewById<TextView>(R.id.tvLesson2)
//        val lesson3 = findViewById<TextView>(R.id.tvLesson3)
//        val lesson4 = findViewById<TextView>(R.id.tvLesson4)
//        val lesson5 = findViewById<TextView>(R.id.tvLesson5)
//
//        when (thisDay) {
//            Day("Понедельник", "Нечетная", "Первая") -> {
//                lesson1.text = ""
//                lesson2.text = "Русский, 5301ауд"
//                lesson3.text = "Русский, 5204ауд"
//                lesson4.text = "ИСиТ, 2206/1ауд"
//                lesson5.text = ""
//            }
//            Day("Понедельник", "Четная", "Первая") -> {
//                lesson1.text = ""
//                lesson2.text = "ВышМат, 2206/1ауд"
//                lesson3.text = "Русский, 5204ауд"
//                lesson4.text = ""
//                lesson5.text = ""
//            }
//            Day("Вторник", "Нечетная", "Первая") -> {
//                lesson1.text = "Ф-ра"
//                lesson2.text = "Англ. яз, 2218ауд"
//                lesson3.text = "Информатика, 3205ауд"
//                lesson4.text = "Программирование, 2220ауд"
//                lesson5.text = ""
//            }
//            Day("Вторник", "Четная", "Первая") -> {
//                lesson1.text = "Ф-ра"
//                lesson2.text = "Англ. яз, 2218ауд"
//                lesson3.text = ""
//                lesson4.text = ""
//                lesson5.text = ""
//            }
//            Day("Среда", "Нечетная", "Первая") -> {
//                lesson1.text = "Ф-ра"
//                lesson2.text = "ВышМат, 3205ауд"
//                lesson3.text = "Информатика, 2220ауд"
//                lesson4.text = "ИСиТ, 2220ауд"
//            }
//            Day("Среда", "Четная", "Первая") -> {
//                lesson1.text = "История, 5104ауд"
//                lesson2.text = "ВышМат, 3205ауд"
//                lesson3.text = "Информатика, 2220ауд"
//                lesson4.text = "ИСиТ, 2220ауд"
//                lesson5.text = ""
//            }
//            Day("Четверг", "Нечетная", "Первая") -> {
//                lesson1.text = ""
//                lesson2.text = ""
//                lesson3.text = "ВПД, 2220ауд"
//                lesson4.text = "ВышМат, 3205ауд"
//                lesson5.text = "История, 4бл"
//            }
//            Day("Четверг", "Четная", "Первая") -> {
//                lesson1.text = ""
//                lesson2.text = ""
//                lesson3.text = "ВПД, 2220ауд"
//                lesson4.text = "Фра, 4бл"
//                lesson5.text = ""
//            }
//            Day("Пятница", "Нечетная", "Первая") -> {
//                lesson1.text = "Программирование, 2220ауд"
//                lesson2.text = "ВПД, 3205"
//                lesson3.text = "Программирование, 3205ауд"
//                lesson4.text = "История, 1517ауд"
//                lesson5.text = ""
//            }
//            Day("Пятница", "Четная", "Первая") -> {
//                lesson1.text = ".спи"
//                lesson2.text = ".спи"
//                lesson3.text = ".спи"
//                lesson4.text = ".спи"
//                lesson5.text = ".спи"
//            }
//            Day("Понедельник", "Нечетная", "Вторая") -> {
//                lesson1.text = "Информатика, 2143ауд"
//                lesson2.text = "Русский, 5301ауд"
//                lesson3.text = "Русский, 5204ауд"
//                lesson4.text = "ИСиТ, 2206/1ауд"
//                lesson5.text = ""
//            }
//
//            Day("Понедельник", "Четная", "Вторая") -> {
//                lesson1.text = "Информатика 2143ауд"
//                lesson2.text = "ВышМат, 2206/1ауд"
//                lesson3.text = "Русский, 5204ауд"
//                lesson4.text = ""
//                lesson5.text = ""
//            }
//            Day("Вторник", "Нечетная", "Вторая") -> {
//                lesson1.text = "Ф-ра"
//                lesson2.text = "ВПД, 2139ауд"
//                lesson3.text = "Информатика, 3205ауд"
//                lesson4.text = ""
//                lesson5.text = ""
//            }
//            Day("Вторник", "Четная", "Вторая") -> {
//                lesson1.text = "Ф-ра"
//                lesson2.text = "ВПД, 2139ауд"
//                lesson3.text = ""
//                lesson4.text = ""
//                lesson5.text = ""
//            }
//            Day("Среда", "Нечетная", "Вторая") -> {
//                lesson1.text = "Ф-ра"
//                lesson2.text = "ВышМат, 3205ауд"
//                lesson3.text = "ИСиТ, 2131в ауд"
//                lesson4.text = ""
//            }
//            Day("Среда", "Четная", "Вторая") -> {
//                lesson1.text = "История, 5104ауд"
//                lesson2.text = "ВышМат, 3205ауд"
//                lesson3.text = "ИСиТ, 2131в ауд"
//                lesson4.text = ""
//                lesson5.text = ""
//            }
//            Day("Четверг", "Нечетная", "Вторая") -> {
//                lesson1.text = ""
//                lesson2.text = "Программирование, 1313ауд"
//                lesson3.text = "Агл. ЯЗ, 2218ауд"
//                lesson4.text = "ВышМат, 3205ауд"
//                lesson5.text = "История, 4бл"
//            }
//            Day("Четверг", "Четная", "Вторая") -> {
//                lesson1.text = ""
//                lesson2.text = "Программирование, 1313ауд"
//                lesson3.text = "Агл. ЯЗ, 2218ауд"
//                lesson4.text = "Фра, 4бл"
//                lesson5.text = ""
//            }
//            Day("Пятница", "Нечетная", "Вторая") -> {
//                lesson1.text = ""
//                lesson2.text = "ВПД, 3205"
//                lesson3.text = "Программирование, 3205ауд"
//                lesson4.text = "История, 1517ауд"
//                lesson5.text = ""
//            }
//            Day("Пятница", "Четная", "Вторая") -> {
//                lesson1.text = ".спи"
//                lesson2.text = ".спи"
//                lesson3.text = ".спи"
//                lesson4.text = ".спи"
//                lesson5.text = ".спи"
//            }
//        }
//    }
}
