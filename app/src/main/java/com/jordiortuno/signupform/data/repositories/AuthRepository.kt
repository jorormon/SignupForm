package com.jordiortuno.signupform.data.repositories

import com.jordiortuno.signupform.data.datasources.AuthRemoteDataSource
import com.jordiortuno.signupform.framework.data.network.Provider
import com.jordiortuno.signupform.domain.ResultWrapper
import com.jordiortuno.signupform.domain.responses.LoginResponse

class AuthRepository(private val authRemoteDataSource: AuthRemoteDataSource) {

    suspend fun login(email:String,password:String) : ResultWrapper<LoginResponse> {
        val response = authRemoteDataSource.login(email,password)
        if(response is ResultWrapper.Success){
                saveAccessTokens(response.value.accessToken,response.value.refreshToken)
        }
        return response
    }

    suspend fun register():Boolean = authRemoteDataSource.register()



    private suspend fun saveAccessTokens(accessToken:String, refreshToken:String){
        Provider.saveAccessTokens(accessToken, refreshToken)
    }
}