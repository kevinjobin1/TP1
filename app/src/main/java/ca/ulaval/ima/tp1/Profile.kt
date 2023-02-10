package ca.ulaval.ima.tp1

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.*

@Parcelize
class Profile(var lastName: String, var firstName: String, var dateOfBirth: Date, var idul: String): Parcelable

