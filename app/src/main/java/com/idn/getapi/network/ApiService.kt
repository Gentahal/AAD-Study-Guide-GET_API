package com.idn.getapi.network

import com.idn.getapi.GunungResponse
import com.idn.getapi.GunungResponseItem
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.internal.operators.flowable.FlowableAll
import retrofit2.http.GET

interface ApiService {
    @GET("volcanoes")
    fun getVolcanicMount() : Flowable<List<GunungResponseItem>>
}