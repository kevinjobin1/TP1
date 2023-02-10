package ca.ulaval.ima.tp1

import android.annotation.SuppressLint
import android.icu.text.SimpleDateFormat
import android.os.Build
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProfileViewActivity : AppCompatActivity() {
    @SuppressLint("SimpleDateFormat")
    @Suppress("UNNECESSARY_NOT_NULL_ASSERTION")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_view)

        val profileData = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("profileData", Profile::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Profile>("profileData")
        }

        val firstNameField = findViewById<TextView>(R.id.first_name)
        firstNameField.text = profileData!!.firstName

        val lastNameField = findViewById<TextView>(R.id.last_name)
        lastNameField.text = profileData!!.lastName

        val dateOfBirthField = findViewById<TextView>(R.id.date_of_birth)
        val dateOfBirth = profileData!!.dateOfBirth
        dateOfBirthField.text = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            SimpleDateFormat("dd-MM-yyyy").format(dateOfBirth)
        } else {
            @Suppress("DEPRECATION")
            String.format("%d-%d-%d",  dateOfBirth.day, dateOfBirth.month, dateOfBirth.year)
        }

        val idulField = findViewById<TextView>(R.id.idul)
        idulField.text = profileData!!.idul

    }
}