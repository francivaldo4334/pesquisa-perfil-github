package br.com.fcr.searchusergithub.data.repository

import android.util.Log
import br.com.fcr.searchusergithub.data.model.Repositories
import br.com.fcr.searchusergithub.data.model.RepositorysItem
import br.com.fcr.searchusergithub.data.request.RetrofitService

class GithubRepositories : GithubRepositoriesInterface{
    val TAG = "TAG"
    override suspend fun getRepositories(user: String): Repositories{
        return try {
            Log.i(TAG,"sucessRepos:")
            Repositories(RetrofitService.getService().getRepositories(user))
        }catch (e:Exception){
            Log.i(TAG,"errorRopos:${e.message.toString()}")
            Repositories()
        }
    }
}
private interface GithubRepositoriesInterface{
    suspend fun getRepositories(user:String):Repositories
}