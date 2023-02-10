package ca.ulaval.ima.tp1

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class WebViewActivity : AppCompatActivity() {
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        val webView = findViewById<WebView>(R.id.webView)
        webView.webViewClient = WebViewClient()

        val urlToLoad = intent.extras!!.getString("urlToLoad")
        if (urlToLoad != null) {
            webView.loadUrl(urlToLoad)
        }

        val webSettings = webView.settings
        webSettings.javaScriptEnabled = true
        webSettings.setSupportZoom(true)

        val closeButton = findViewById<Button>(R.id.button_close_web_view)
        closeButton.setOnClickListener { finish() }

    }


}