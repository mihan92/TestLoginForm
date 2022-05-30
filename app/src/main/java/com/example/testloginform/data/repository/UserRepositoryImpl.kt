package com.example.testloginform.data.repository

import com.example.testloginform.data.storage.SharedPrefStorage
import com.example.testloginform.domain.models.UserModel
import com.example.testloginform.domain.UserModelRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val sharedPrefStorage: SharedPrefStorage
) : UserModelRepository {
    override fun getData(): UserModel {
        return sharedPrefStorage.getData()
    }

    override fun saveData(userModel: UserModel) {
        sharedPrefStorage.saveData(userModel)
    }
}