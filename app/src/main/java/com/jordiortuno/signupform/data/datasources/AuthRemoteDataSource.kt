package com.jordiortuno.signupform.data.datasources

import com.jordiortuno.signupform.domain.ResultWrapper
import com.jordiortuno.signupform.domain.responses.LoginResponse

interface AuthRemoteDataSource {

    suspend fun login(email:String,password:String): ResultWrapper<LoginResponse>
    suspend fun register():Boolean
    suspend fun changePassword():Boolean
}