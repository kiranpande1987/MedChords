package com.kprights.medchords.viewmodel

import androidx.lifecycle.MutableLiveData
import com.kprights.medchords.common.WebService
import com.kprights.medchords.model.Request
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch


/**
 * Copyright (c) 2020 for KPrights
 *
 * User : Kiran Pande
 * Date : 21/05/20
 * Time : 12:40 AM
 */

class AppRepository {
    private val job = Job()
    private val scope = CoroutineScope(job)

    val result: MutableLiveData<String> = MutableLiveData()

    fun postTextOnButton(textOnButton: String) {
        scope.launch {

            try {
                val post = WebService.postTextOnButton(Request(textOnButton))

                post.await().let { base -> result.postValue(base.data.rstr) }
            } catch (e: Exception) {
                result.postValue(e.localizedMessage)
            }
        }
    }

    fun cancel() {
        job.cancel()
    }
}