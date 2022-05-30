package com.example.testloginform.domain

import com.example.testloginform.domain.models.UserModel

interface UserModelRepository {

    fun getData(): UserModel

    fun saveData(userModel: UserModel)
}