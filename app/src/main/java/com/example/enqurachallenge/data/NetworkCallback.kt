package com.example.enqurachallenge.data

interface NetworkCallback <T> {
    fun onSuccess(data: T)
    fun onError(message: String)
}