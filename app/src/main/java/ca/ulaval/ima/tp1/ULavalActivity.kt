package ca.ulaval.ima.tp1

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ULavalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ulaval)

        val closeButton = findViewById<Button>(R.id.button_close_u_laval)
        closeButton.setOnClickListener{finish()}
    }
}