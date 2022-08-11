package br.com.fcr.searchusergithub.data.endpoint

import br.com.fcr.searchusergithub.data.model.Repositories
import br.com.fcr.searchusergithub.data.model.RepositorysItem
import br.com.fcr.searchusergithub.data.model.User
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiGithubInterface{
    @GET("{user}")
    suspend fun getUser(@Path("user")user:String):User
    @GET("{user}/repos")
    suspend fun getRepositories(@Path("user")user: String):List<RepositorysItem>
}