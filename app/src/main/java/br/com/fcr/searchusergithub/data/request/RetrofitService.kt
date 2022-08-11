package br.com.fcr.searchusergithub.data.request

import br.com.fcr.searchusergithub.data.endpoint.ApiGithubInterface
import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class RetrofitService(){
    companion object{
        private val BASE_URL = "https://api.github.com/users/"
        private val retrofit = Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create().asLenient())
            .build()
        fun getService():ApiGithubInterface{
            return retrofit.create(ApiGithubInterface::class.java)
        }
    }
}