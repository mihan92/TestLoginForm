package com.example.testloginform.data.storage

import com.example.testloginform.domain.models.UserModel

interface SharedPrefStorage {

    fun getData(): UserModel

    fun saveData(userModel: UserModel)
}