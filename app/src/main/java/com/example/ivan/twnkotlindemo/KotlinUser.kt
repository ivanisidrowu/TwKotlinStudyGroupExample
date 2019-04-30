package com.example.ivan.twnkotlindemo

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class KotlinUser(val id: Long,
                      val name: String,
                      val description: String,
                      val profileImageUrl: String) : Parcelable