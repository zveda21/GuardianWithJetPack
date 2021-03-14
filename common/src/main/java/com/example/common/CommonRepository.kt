package com.example.common

import am.myapp.networker.ApiCallBack
import am.myapp.networker.smartCalls

const val API_KEY = "5a3ab8d2-0dda-47fa-9604-8c9d54d6a3bf"
const val BASE_URL = "https://content.guardianapis.com/"


interface CommonRepository {
    fun getSection(apiCallBack: ApiCallBack<Any>)
    fun getCurrentSectionAsContent(id: String, apiCallBack: ApiCallBack<Any>)
}

class CommonRepositoryImpl(private val apiCall: ApiCalls) : CommonRepository {
    override fun getSection(apiCallBack: ApiCallBack<Any>) {
        apiCall.getSections().enqueue(smartCalls(apiCallBack))
    }

    override fun getCurrentSectionAsContent(id: String, apiCallBack: ApiCallBack<Any>) {
        apiCall.getCurrentPath(id).enqueue(smartCalls(apiCallBack))
    }

}