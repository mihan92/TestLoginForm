package com.example.testloginform.domain.models

import javax.inject.Inject

data class UserModel @Inject constructor(
    val firstName: String,
    val lastName: String
)