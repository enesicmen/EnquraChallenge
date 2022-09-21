package com.example.enqurachallenge.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class BankBranch (

    @PrimaryKey
    @SerializedName("ID")
    val id: Int,

    @SerializedName("dc_SEHIR")
    val city: String ?= null,

    @SerializedName("dc_ILCE")
    val district: String?= null,

    @SerializedName("dc_ADRES_ADI")
    val addressName: String ?= null,

    @SerializedName("dc_ADRES")
    val address: String ?= null,

    @SerializedName("dc_BANKA_SUBE")
    val bankBranch: String ?= null,

    @SerializedName("dc_BANKA_TIPI")
    val bankType: String ?= null,

    @SerializedName("dc_BANK_KODU")
    val bankCode: String ?= null,

    @SerializedName("dc_POSTA_KODU")
    val postCode: String ?= null,

    @SerializedName("dc_ON_OFF_LINE")
    val onOffLine: String ?= null,

    @SerializedName("dc_ON_OFF_SITE")
    val onOffSite: String ?= null,

    @SerializedName("dc_BOLGE_KOORDINATORLUGU")
    val regionalCoordinator: String ?= null,

    @SerializedName("dc_EN_YAKIM_ATM")
    val nearestAtm: String ?= null,

): Parcelable
