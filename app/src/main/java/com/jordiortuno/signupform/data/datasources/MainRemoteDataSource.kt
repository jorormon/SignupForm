package com.jordiortuno.signupform.data.datasources

import com.jordiortuno.signupform.domain.ResultWrapper
import com.jordiortuno.signupform.domain.responses.UserResponse

interface MainRemoteDataSource:BaseRemoteDataSource {
    suspend fun getUser():ResultWrapper<UserResponse>

}