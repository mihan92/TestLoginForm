package com.example.testloginform.domain.usecases

import com.example.testloginform.domain.models.UserModel
import com.example.testloginform.domain.UserModelRepository
import javax.inject.Inject


class SaveUserUseCase @Inject constructor(private val userModelRepository: UserModelRepository) {

    fun saveUser(userModel: UserModel) {
        userModelRepository.saveData(userModel)
    }
}