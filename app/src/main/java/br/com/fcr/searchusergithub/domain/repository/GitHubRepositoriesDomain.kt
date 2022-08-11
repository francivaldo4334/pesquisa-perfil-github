package br.com.fcr.searchusergithub.domain.repository

import android.util.Log
import br.com.fcr.searchusergithub.data.repository.GithubRepositories
import br.com.fcr.searchusergithub.domain.controller.RepositoriesController
import br.com.fcr.searchusergithub.domain.controller.RepositoryController
import br.com.fcr.searchusergithub.domain.controller.from

class GitHubRepositoriesDomain :GitHubRepositoriesDomainInterface{
    override suspend fun getRepositories(user: String): RepositoriesController {
        return  RepositoriesController().from(GithubRepositories().getRepositories(user))
    }
}
private interface GitHubRepositoriesDomainInterface{
    suspend fun getRepositories(user:String):RepositoriesController
}