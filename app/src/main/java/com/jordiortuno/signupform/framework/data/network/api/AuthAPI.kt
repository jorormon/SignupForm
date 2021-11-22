package com.jordiortuno.signupform.framework.data.network.api

import com.jordiortuno.signupform.framework.data.network.base.Retry
import com.jordiortuno.signupform.domain.responses.LoginResponse
import com.jordiortuno.signupform.domain.responses.BaseResponse
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthAPI : BaseAPI {

    @Retry
    @POST("login")
    suspend fun login(@Body requestBody: RequestBody): BaseResponse<LoginResponse>
}