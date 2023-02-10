package ca.ulaval.ima.tp1

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myProfile = Profile("Jobin", "Kevin", GregorianCalendar(1994, 12, 29).time, "536777791")
        val urlToLoad = "https://kevinjobin1.github.io"

        val launchBrowserButton = findViewById<Button>(R.id.button_web_ext)
        launchBrowserButton.setOnClickListener{
            val uriToLoad = Uri.parse(urlToLoad)
            val launchBrowserIntent = Intent(Intent.ACTION_VIEW, uriToLoad)
            startActivity(launchBrowserIntent)
        }

        val startWebViewButton = findViewById<Button>(R.id.button_web_wv)
        startWebViewButton.setOnClickListener {
            val startWebViewIntent = Intent(this, WebViewActivity::class.java)
            startWebViewIntent.putExtra("urlToLoad", urlToLoad)
            startActivity(startWebViewIntent)
        }

        val openULavalActivityButton = findViewById<Button>(R.id.button_u_laval)
        openULavalActivityButton.setOnClickListener {
            val openULavalActivityIntent = Intent(this, ULavalActivity::class.java)
            startActivity(openULavalActivityIntent)
        }

        val openProfileViewButton = findViewById<Button>(R.id.button_my_profile)
        openProfileViewButton.setOnClickListener {
            val openProfileViewIntent = Intent(this, ProfileViewActivity::class.java)
            openProfileViewIntent.putExtra("profileData", myProfile)
            startActivity(openProfileViewIntent)
        }
    }
}