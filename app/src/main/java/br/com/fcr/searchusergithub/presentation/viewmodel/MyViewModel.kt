package br.com.fcr.searchusergithub.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.fcr.searchusergithub.domain.controller.toUiRepository
import br.com.fcr.searchusergithub.domain.controller.toUiUser
import br.com.fcr.searchusergithub.domain.repository.GitHubRepositoriesDomain
import br.com.fcr.searchusergithub.domain.repository.GithubUserDoamain
import br.com.fcr.searchusergithub.presentation.model.Repositories
import br.com.fcr.searchusergithub.presentation.model.User
import kotlinx.coroutines.launch

class MyViewModel:ViewModel() {
    var responserepositories by mutableStateOf(Repositories())
    var responseuser by mutableStateOf(User())
    fun getUser(user:String){
        viewModelScope.launch {
            responseuser = GithubUserDoamain().getUser(user).toUiUser()
        }
    }
    fun getRepositories(user:String){
        viewModelScope.launch {
            responserepositories = GitHubRepositoriesDomain().getRepositories(user).toUiRepository()

        }
    }
}