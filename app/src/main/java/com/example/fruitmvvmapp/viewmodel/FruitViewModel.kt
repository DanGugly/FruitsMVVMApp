package com.example.fruitmvvmapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fruitmvvmapp.model.Fruits
import com.example.fruitmvvmapp.rest.NetworkApi
import com.example.fruitmvvmapp.utils.UIState
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class FruitViewModel : ViewModel() {

    @Inject lateinit var fruitApi: NetworkApi

    private val disposable by lazy {
        CompositeDisposable()
    }

    /**
     * Live data to be set in rxjava call (Mutable live data)
     */
    private var _allFruits: MutableLiveData<UIState> = MutableLiveData(UIState.Loading())

    /**
     * Mutable live data to be observed in the UI thread
     * UI state will propogate the loaded, success or error, depending on the response
     */
    val allFruits: LiveData<UIState> get() = _allFruits

    private var _searchFruitLiveData : MutableLiveData<UIState> = MutableLiveData(UIState.Loading())
    val searchFruit: LiveData<UIState> get() = _searchFruitLiveData

    fun getAllFruits(){
        val allFruitsDisposable = fruitApi.retrieveAllFruits()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { _allFruits.postValue(UIState.Success(it)) },
                { _allFruits.postValue(UIState.Error(it)) }
            )
        disposable.add(allFruitsDisposable)
    }

    fun searchSpecificFruit(fruitName: String){
        val searchFruit = fruitApi.searchFruit(fruitName)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { _searchFruitLiveData.postValue(UIState.Success(it)) },
                { _searchFruitLiveData.postValue(UIState.Error(it)) }
            )
    }

}