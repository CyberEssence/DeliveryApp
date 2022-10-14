package com.example.deliveryapp.data

import com.example.deliveryapp.domain.model.BaseModel
import com.example.deliveryapp.domain.model.MealsList
import retrofit2.Response

class Repository {
    suspend fun getMenu() : Response<MealsList> {
        return RetrofitInstance.api.getMenu()
    }
}