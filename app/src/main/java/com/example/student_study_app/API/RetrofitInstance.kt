package com.example.student_study_app.API

import com.example.student_study_app.APIutils.AuthInterceptor
import com.example.student_study_app.APIutils.JwtTokenInterceptor
import com.example.student_study_app.APIutils.TokenManager
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

object RetrofitInstance {
    private const val BASE_URL = "http://10.0.2.2:5213"
    // Initialize the TokenManager with context

    private val logging = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val client = OkHttpClient.Builder()
        .addInterceptor(logging)
        .addInterceptor { chain ->
            val original: Request = chain.request()
            val jwtToken = ""
            val requestBuilder = original.newBuilder()
                .header("Authorization", "Bearer $jwtToken")
            val request = requestBuilder.build()
            chain.proceed(request)
        }
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .build()


    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    val api: APIservice = retrofit.create(APIservice::class.java)


}