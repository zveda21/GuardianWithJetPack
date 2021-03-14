package com.example.common

import am.myapp.networker.ApiCallBack
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BaseCommonViewModel(private val commonRepository: CommonRepository) : ViewModel() {
    private var _getSection: MutableLiveData<Any?> = MutableLiveData()
    var getSection: LiveData<Any?> = _getSection

    var getCurrentSectionAsContent: MutableLiveData<Any?> = MutableLiveData()

    fun getCurrentSection() {
        commonRepository.getSection(object : ApiCallBack<Any> {
            override fun success(response: Any) {
                _getSection.value = response
            }

            override fun error(error: String) {
                _getSection.value = error
            }

            override fun failure() {
                _getSection.value = null
            }

        })
    }

    fun getCurrentSectionAsContent(id: String) {
        commonRepository.getCurrentSectionAsContent(id, object : ApiCallBack<Any> {
            override fun success(response: Any) {
                getCurrentSectionAsContent.value = response
            }

            override fun error(error: String) {

                getCurrentSectionAsContent.value = error
            }

            override fun failure() {
                getCurrentSectionAsContent.value = null
            }

        })
    }
}