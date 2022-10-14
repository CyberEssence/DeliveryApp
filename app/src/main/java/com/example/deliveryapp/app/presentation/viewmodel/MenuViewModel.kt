package com.example.deliveryapp.app.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.deliveryapp.data.Repository
import com.example.deliveryapp.domain.model.BaseModel
import com.example.deliveryapp.domain.model.MealsList
import kotlinx.coroutines.launch
import retrofit2.Response

class MenuViewModel(application: Application): AndroidViewModel(application) {

    private val repository = Repository()
    val menuList: MutableLiveData<Response<MealsList>> = MutableLiveData()

    fun getMenu() {
        viewModelScope.launch {
            menuList.value = repository.getMenu()
        }
    }

}