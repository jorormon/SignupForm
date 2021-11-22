package com.jordiortuno.signupform.data.repositories

import com.jordiortuno.signupform.data.datasources.MainRemoteDataSource
import com.jordiortuno.signupform.domain.ResultWrapper
import com.jordiortuno.signupform.domain.responses.UserResponse

class MainRepository(private val mainRemoteDataSource: MainRemoteDataSource) {

    suspend fun getUser():ResultWrapper<UserResponse>{
        return mainRemoteDataSource.getUser()
    }
}