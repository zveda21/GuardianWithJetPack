package com.example.guardianchangeapp

import am.myapp.networker.ApiCallBack
import am.myapp.networker.smartCalls
import com.example.common.ApiCalls
import com.example.common.CommonRepository

class MainRepositoryImpl(private val apiCall: ApiCalls) : CommonRepository {
    override fun getSection(apiCallBack: ApiCallBack<Any>) {
        apiCall.getSections().enqueue(smartCalls(apiCallBack))
    }

    override fun getCurrentSectionAsContent(id: String, apiCallBack: ApiCallBack<Any>) {
        apiCall.getCurrentPath(id).enqueue(smartCalls(apiCallBack))
    }
}