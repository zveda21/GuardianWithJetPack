package com.example.guardianchangeapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.common.BaseCommonViewModel
import com.example.common.CommonRepository

class MainFactory(private var commonRepository: CommonRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return BaseCommonViewModel(commonRepository) as T
    }
}