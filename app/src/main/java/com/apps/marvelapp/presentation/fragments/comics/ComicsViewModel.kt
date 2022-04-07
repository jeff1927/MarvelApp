package com.apps.marvelapp.presentation.fragments.comics

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.apps.marvelapp.domain.models.ComicModel
import com.apps.marvelapp.domain.usecase.GetComicsUseCase
import com.apps.marvelapp.domain.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ComicsViewModel @Inject constructor(private val getComicsUseCase: GetComicsUseCase) : ViewModel() {

    private val _comicsList = MutableLiveData<Resource<PagingData<ComicModel>>>()
    val comicsList: LiveData<Resource<PagingData<ComicModel>>> = _comicsList
    init {
        getComicsPageList()
    }

    private fun getComicsPageList() = viewModelScope.launch{
        _comicsList.postValue(Resource.Loading())
        withContext(Dispatchers.IO){
            getComicsUseCase().cachedIn(viewModelScope)
                .catch {
                    _comicsList.postValue(Resource.Error(this.toString()))
                }
                .collect {
                    _comicsList.postValue(Resource.Success(it))
                }
        }
    }
}