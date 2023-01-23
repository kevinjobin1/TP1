package ca.ulaval.ima.tp1

import android.os.Parcel
import android.os.Parcelable
import java.util.*

class Profil (private val nom: String?, private val prenom: String?, private val dateDeNaissance: Date?, private val IDUL: String?) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readDate(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nom)
        parcel.writeString(prenom)
        parcel.writeDate(dateDeNaissance)
        parcel.writeString(IDUL)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Profil> {
        override fun createFromParcel(parcel: Parcel): Profil {
            return Profil(parcel)
        }

        override fun newArray(size: Int): Array<Profil?> {
            return arrayOfNulls(size)
        }
    }
}

private fun <T> Parcel.readNullable(reader: () -> T) =
    if (readInt() != 0) reader() else null

private fun <T> Parcel.writeNullable(value: T?, writer: (T) -> Unit) {
    if (value != null) {
        writeInt(1)
        writer(value)
    } else {
        writeInt(0)
    }
}

fun Parcel.writeDate(value: Date?) =
    writeNullable(value) { writeLong(it.time) }

private fun Parcel.readDate() =
    readNullable { Date(readLong()) }

