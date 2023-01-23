package ca.ulaval.ima.tp1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val monProfil: Profil = Profil("Jobin", "Kevin", GregorianCalendar(1994, 12, 29).time, "536777791")
        val urlToLoad : String = "https://google.com"

    }
}