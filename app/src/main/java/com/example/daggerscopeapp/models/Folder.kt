package com.example.daggerscopeapp.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Folder(
    val name: String
) : Parcelable