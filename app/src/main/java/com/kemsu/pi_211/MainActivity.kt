package com.kemsu.pi_211

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import org.jsoup.Jsoup
import java.net.HttpURLConnection
import java.net.URL
import java.text.SimpleDateFormat
import java.util.*

val calendar = Calendar.getInstance()
val date = calendar.time
val dayOfWeek = SimpleDateFormat("EEEE").format(date.time)
var whatWeek: String = ""

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.btFind)

        button.setOnClickListener {
            setDay()
            notiffy()
        }
    }

    override fun onStart() {
        super.onStart()
        val daySpinner = findViewById<Spinner>(R.id.spinDay)
        val evenSpinner = findViewById<Spinner>(R.id.spinEven)

        Thread {
            var doc = Jsoup.connect("https://kemsu.ru/education/schedule//").get()
            whatWeek = doc.select("body > main > div > div > div > div.calendar-week > div:nth-child(2)").toString()
            Log.d("UrlTest", whatWeek)
            runOnUiThread {
                if (whatWeek.contains("нечетная")) {
                    evenSpinner.setSelection(1)
                } else  {
                    evenSpinner.setSelection(0)
                }
            }
        }.start()

        when (dayOfWeek) {
            "понедельник" -> daySpinner.setSelection(0)
            "вторник" -> daySpinner.setSelection(1)
            "среда" -> daySpinner.setSelection(2)
            "четверг" -> daySpinner.setSelection(3)
            "пятница" -> daySpinner.setSelection(4)
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

        Toast.makeText(this, dayOfWeek.toString(), Toast.LENGTH_LONG).show()
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
            Day("Вторник", "Четная", "Первая") -> {
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
            Day("Понедельник", "Нечетная", "Вторая") -> {
                lesson1.text = "Информатика, 2143ауд"
                lesson2.text = "Русский, 5301ауд"
                lesson3.text = "Русский, 5204ауд"
                lesson4.text = "ИСиТ, 2206/1ауд"
                lesson5.text = ""
            }

            Day("Понедельник", "Четная", "Вторая") -> {
                lesson1.text = "Информатика 2143ауд"
                lesson2.text = "ВышМат, 2206/1ауд"
                lesson3.text = "Русский, 5204ауд"
                lesson4.text = ""
                lesson5.text = ""
            }
            Day("Вторник", "Нечетная", "Вторая") -> {
                lesson1.text = "Ф-ра"
                lesson2.text = "ВПД, 2139ауд"
                lesson3.text = "Информатика, 3205ауд"
                lesson4.text = ""
                lesson5.text = ""
            }
            Day("Вторник", "Четная", "Вторая") -> {
                lesson1.text = "Ф-ра"
                lesson2.text = "ВПД, 2139ауд"
                lesson3.text = ""
                lesson4.text = ""
                lesson5.text = ""
            }
            Day("Среда", "Нечетная", "Вторая") -> {
                lesson1.text = "Ф-ра"
                lesson2.text = "ВышМат, 3205ауд"
                lesson3.text = "ИСиТ, 2131в ауд"
                lesson4.text = ""
            }
            Day("Среда", "Четная", "Вторая  ") -> {
                lesson1.text = "История, 5104ауд"
                lesson2.text = "ВышМат, 3205ауд"
                lesson3.text = "ИСиТ, 2131в ауд"
                lesson4.text = ""
                lesson5.text = ""
            }
            Day("Четверг", "Нечетная", "Вторая") -> {
                lesson1.text = ""
                lesson2.text = "Программирование, 1313ауд"
                lesson3.text = "Агл. ЯЗ, 2218ауд"
                lesson4.text = "ВышМат, 3205ауд"
                lesson5.text = "История, 4бл"
            }
            Day("Четверг", "Четная", "Вторая") -> {
                lesson1.text = ""
                lesson2.text = "Программирование, 1313ауд"
                lesson3.text = "Агл. ЯЗ, 2218ауд"
                lesson4.text = "Фра, 4бл"
                lesson5.text = ""
            }
            Day("Пятница", "Нечетная", "Вторая") -> {
                lesson1.text = ""
                lesson2.text = "ВПД, 3205"
                lesson3.text = "Программирование, 3205ауд"
                lesson4.text = "История, 1517ауд"
                lesson5.text = ""
            }
            Day("Пятница", "Четная", "Вторая") -> {
                lesson1.text = ".спи"
                lesson2.text = ".спи"
                lesson3.text = ".спи"
                lesson4.text = ".спи"
                lesson5.text = ".спи"
            }
        }
    }

    fun notiffy() {
        val NOTIFY_ID: Int = 100;
        val notificationIntent = Intent(this, MainActivity::class.java)
        val contentIntent = PendingIntent.getActivity(
            this,
            0,
            notificationIntent,
            PendingIntent.FLAG_CANCEL_CURRENT
        )
        val builder = NotificationCompat.Builder(this)
        builder.setContentIntent(contentIntent)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("Уведомление")
            .setContentText("Тест")
        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(NOTIFY_ID, builder.build())
    }
}