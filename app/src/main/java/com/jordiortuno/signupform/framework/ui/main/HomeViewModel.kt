package com.jordiortuno.signupform.framework.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jordiortuno.signupform.domain.ResultWrapper
import com.jordiortuno.signupform.domain.responses.UserResponse
import com.jordiortuno.signupform.usecases.auth.GetUserUseCase
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel() {
    private val _getUser = MutableLiveData<ResultWrapper<UserResponse>>()
    val getUser: LiveData<ResultWrapper<UserResponse>> get() = _getUser
    fun getUser(){
        viewModelScope.launch {
            _getUser.value = ResultWrapper.Loading
            _getUser.value = GetUserUseCase().invoke()
        }
    }

}