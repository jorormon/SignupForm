package com.jordiortuno.signupform.data.datasources

interface BaseRemoteDataSource {
    suspend fun logOut():Boolean
}