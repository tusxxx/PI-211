package com.kemsu.pi_211.ui.first_group

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kemsu.pi_211.domain.Day
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.jsoup.Jsoup
import timber.log.Timber
import java.text.SimpleDateFormat
import java.util.*

class FirstGroupViewModel : ViewModel() {
    private val _currentDay = MutableLiveData<Day>()
    var currentDay: LiveData<Day> = _currentDay

    init {
        _currentDay.value = generateToday()
    }

    private fun generateToday(): Day = Day(getDayOfWeek(), getEvenOrNotWeek(), 1)

    private fun getEvenOrNotWeek(): Boolean {
        var whatWeek = ""
        GlobalScope.launch(Dispatchers.IO){
            try {
                val doc = Jsoup.connect("https://kemsu.ru/education/schedule//").get()
                whatWeek =
                    doc.select("body > main > div > div > div > div.calendar-week > div:nth-child(2)")
                        .text()
            } catch (e: Exception) {
                Timber.e(e)
            }
        }.start()
        return whatWeek.contains(" четная")
    }

    private fun getDayOfWeek(): String {
        GlobalScope.launch(Dispatchers.IO) {
            getDayOfWeek()
        }.start()
        val date = Calendar.getInstance().time
        return SimpleDateFormat("EEEE", Locale.ENGLISH).format(date.time)
    }
}