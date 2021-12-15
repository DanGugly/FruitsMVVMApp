package com.example.fruitmvvmapp.utils

sealed class UIState(val state: ResponseState) {
    class Loading(val isLoading : Boolean = true): UIState(ResponseState.LOADING)
    class Success<T>(val data : T): UIState(ResponseState.SUCCESS)
    class Error(val error: Throwable): UIState(ResponseState.ERROR)
}

enum class ResponseState {
    LOADING,
    SUCCESS,
    ERROR;
}