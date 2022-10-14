package com.example.deliveryapp.domain.api

import com.example.deliveryapp.domain.model.MealsList
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("/api/json/v1/1/filter.php?c=Dessert")
    suspend fun getMenu() : Response<MealsList>

}