package com.jordiortuno.signupform.framework.data.network.datasource

import com.jordiortuno.signupform.data.datasources.MainRemoteDataSource
import com.jordiortuno.signupform.domain.ResultWrapper
import com.jordiortuno.signupform.domain.responses.UserResponse
import com.jordiortuno.signupform.framework.data.network.api.UserAPI
import com.jordiortuno.signupform.framework.data.network.base.SafeApiCall

class MainServerDataSource(private val userAPI:UserAPI):MainRemoteDataSource,SafeApiCall {
    override suspend fun getUser(): ResultWrapper<UserResponse> {
        return safeApiCall {
            userAPI.getUser()
        }
    }

    override suspend fun logOut(): Boolean {
        TODO("Not yet implemented")
    }
}