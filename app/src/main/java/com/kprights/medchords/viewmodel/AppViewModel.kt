package com.kprights.infosys.newsfeed.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.kprights.medchords.viewmodel.AppRepository


/**
 * Copyright (c) 2020 for KPrights
 *
 * User : Kiran Pande
 * Date : 10/04/20
 * Time : 4:57 PM
 */

class AppViewModel : ViewModel() {
    private val appRepository = AppRepository()
    val response: LiveData<String> = Transformations.map(appRepository.result) { it }

    fun postTextOnButton(textOnButton: String) {
        if (textOnButton.isNotEmpty()) appRepository.postTextOnButton(textOnButton)
    }

    override fun onCleared() {
        appRepository.cancel()
    }
}