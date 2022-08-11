package br.com.fcr.searchusergithub.data.model

import br.com.fcr.searchusergithub.domain.controller.RepositoriesController

class Repositories(val list:List<RepositorysItem> = ArrayList<RepositorysItem>())
fun Repositories.getList():List<RepositorysItem>{
    return list
}