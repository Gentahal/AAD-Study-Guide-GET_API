package com.idn.getapi

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GunungResponse(

	@field:SerializedName("GunungResponse")
	val gunungResponse: List<GunungResponseItem?>? = null
) : Parcelable

@Parcelize
data class GunungResponseItem(

	@field:SerializedName("bentuk")
	val bentuk: String? = null,

	@field:SerializedName("nama")
	val nama: String? = null,

	@field:SerializedName("estimasi_letusan_terakhir")
	val estimasiLetusanTerakhir: String? = null,

	@field:SerializedName("tinggi_meter")
	val tinggiMeter: String? = null,

	@field:SerializedName("geolokasi")
	val geolokasi: String? = null

) : Parcelable
