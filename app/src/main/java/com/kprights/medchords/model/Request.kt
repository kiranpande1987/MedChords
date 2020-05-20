package com.kprights.medchords.model

import com.google.gson.annotations.SerializedName


/**
 * Copyright (c) 2020 for KPrights
 *
 * User : Kiran Pande
 * Date : 21/05/20
 * Time : 1:09 AM
 */

data class Request(@SerializedName("bname") val bname: String)