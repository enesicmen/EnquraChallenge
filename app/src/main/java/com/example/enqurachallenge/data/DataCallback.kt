package com.example.enqurachallenge.data

interface DataCallback <T> {
    fun onSuccess(data: T)
    fun onError(message: String)
}