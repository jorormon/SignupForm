package com.jordiortuno.signupform.framework.data.network.api

import com.jordiortuno.signupform.framework.data.network.base.Retry
import com.jordiortuno.signupform.domain.responses.BaseResponse
import com.jordiortuno.signupform.domain.responses.UserResponse
import retrofit2.http.GET

interface UserAPI: BaseAPI {

    @Retry
    @GET("profile")
    suspend fun getUser(): BaseResponse<UserResponse>
}