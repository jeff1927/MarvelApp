package com.apps.marvelapp.presentation.fragments.heroes


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.apps.marvelapp.domain.models.HeroModel
import com.apps.marvelapp.domain.usecase.GetHeroesListUseCase
import com.apps.marvelapp.domain.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HeroesViewModel @Inject constructor(private val getHeroesListUseCase: GetHeroesListUseCase) : ViewModel() {

    private val _heroesList = MutableLiveData<Resource<PagingData<HeroModel>>>()
    val heroesList: LiveData<Resource<PagingData<HeroModel>>> = _heroesList
    init {
        getHeroesPageList()
    }

    private fun getHeroesPageList() = viewModelScope.launch {
        _heroesList.postValue(Resource.Loading())
        withContext(Dispatchers.IO){
            getHeroesListUseCase().cachedIn(viewModelScope)
                .catch {
                    _heroesList.postValue(Resource.Error(this.toString()))
                }
                .collect {
                    _heroesList.postValue(Resource.Success(it))
                }
            }
        }
}