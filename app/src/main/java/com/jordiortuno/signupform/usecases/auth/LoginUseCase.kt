package com.jordiortuno.signupform.usecases.auth

import com.jordiortuno.signupform.data.repositories.AuthRepository
import com.jordiortuno.signupform.framework.data.network.RemoteClient
import com.jordiortuno.signupform.framework.data.network.api.AuthAPI
import com.jordiortuno.signupform.domain.ResultWrapper
import com.jordiortuno.signupform.framework.data.network.datasource.AuthServerDataSource
import com.jordiortuno.signupform.domain.responses.LoginResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

public class LoginUseCase() {
    suspend fun invoke(): ResultWrapper<LoginResponse> = withContext(Dispatchers.IO){
        val authRepository = AuthRepository(AuthServerDataSource(RemoteClient.buildAuthApi(AuthAPI::class.java)))
        authRepository.login("email@example.com","password")

    }
}