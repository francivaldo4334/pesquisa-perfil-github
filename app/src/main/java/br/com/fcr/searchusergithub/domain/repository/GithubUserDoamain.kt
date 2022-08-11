package br.com.fcr.searchusergithub.domain.repository

import br.com.fcr.searchusergithub.data.repository.GithubUser
import br.com.fcr.searchusergithub.domain.controller.UserController
import br.com.fcr.searchusergithub.domain.controller.forUserController

class GithubUserDoamain :GithubUserInterface{
    override suspend fun getUser(user: String): UserController {
        return UserController().forUserController(GithubUser().getUser(user))
    }
}
private interface GithubUserInterface{
    suspend fun getUser(user:String):UserController
}