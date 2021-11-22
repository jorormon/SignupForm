package com.jordiortuno.signupform.usecases.auth

import com.jordiortuno.signupform.data.repositories.MainRepository
import com.jordiortuno.signupform.framework.data.network.RemoteClient
import com.jordiortuno.signupform.framework.data.network.api.UserAPI
import com.jordiortuno.signupform.domain.ResultWrapper
import com.jordiortuno.signupform.domain.responses.UserResponse
import com.jordiortuno.signupform.framework.data.network.datasource.MainServerDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetUserUseCase {
    suspend fun invoke(): ResultWrapper<UserResponse> = withContext(Dispatchers.IO){
        val mainRepository = MainRepository(MainServerDataSource(RemoteClient.buildApi(UserAPI::class.java)))

        mainRepository.getUser()

    }
}