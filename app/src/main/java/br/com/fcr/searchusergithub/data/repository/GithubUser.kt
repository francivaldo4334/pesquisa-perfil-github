package br.com.fcr.searchusergithub.data.repository

import android.util.Log
import br.com.fcr.searchusergithub.data.model.User
import br.com.fcr.searchusergithub.data.request.RetrofitService

class GithubUser : GithubUserInterface{
    val TAG = "TAG"
    override suspend fun getUser(user: String): User {
        return try {
            Log.i(TAG,"sucessUser:")
            RetrofitService.getService().getUser(user)
        }catch (e:Exception){
            Log.i(TAG,"errorUser:${e.message.toString()}")
            User()
        }
    }
}
private interface GithubUserInterface{
    suspend fun getUser(user:String):User
}