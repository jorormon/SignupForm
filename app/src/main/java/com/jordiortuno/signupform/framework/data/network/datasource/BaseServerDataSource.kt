package com.jordiortuno.signupform.framework.data.network.datasource

import com.jordiortuno.signupform.data.datasources.BaseRemoteDataSource
import com.jordiortuno.signupform.framework.data.network.api.BaseAPI

class BaseServerDataSource(private val api:BaseAPI):BaseRemoteDataSource {
    override suspend fun logOut(): Boolean {
        return api.logout().body()!!
    }
}