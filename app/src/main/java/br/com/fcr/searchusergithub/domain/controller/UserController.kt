package br.com.fcr.searchusergithub.domain.controller

import br.com.fcr.searchusergithub.data.model.RepositorysItem
import br.com.fcr.searchusergithub.data.model.User
import br.com.fcr.searchusergithub.presentation.model.Repositories
import br.com.fcr.searchusergithub.presentation.model.Repository

data class UserController(
    val name:String = "",
    val fllowers:Int = 0,
    val fllowing:Int = 0,
    val link:String = "",
    val avatar_url:String = ""
)
fun UserController.toUiUser() = br.com.fcr.searchusergithub.presentation.model.User(
    name = this.name,
    fllowers = this.fllowers,
    fllowing = this.fllowing,
    link = this.link,
    avatar_url = this.avatar_url
)

fun UserController.forUserController(user:User) = UserController(
    name = user.name,
    fllowers = user.followers,
    fllowing = user.following,
    link = user.html_url,
    avatar_url = user.avatar_url
)
class RepositoriesController:ArrayList<RepositoryController>()
fun RepositoriesController.from(repos:br.com.fcr.searchusergithub.data.model.Repositories):RepositoriesController{
    repos.list.forEach {
        this.add(
            RepositoryController(
            name = it.name,
            language = if(it.language == null) "" else it.language ,
            description = if(it.description == null) "" else it.description
        )
        )
    }
    return this
}
fun RepositoriesController.toUiRepository():Repositories{
    var result = Repositories()
    this.forEach {
        result.add(it.toUiRepository())
    }
    return result
}
data class RepositoryController(
    val name:String = "",
    val language:String = "",
    val description:String = ""
)
fun RepositoryController.toUiRepository() = Repository(
    name = this.name,
    language = this.language,
    description = this.description
)