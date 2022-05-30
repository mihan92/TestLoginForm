package com.example.testloginform.data.storage

import android.content.Context
import com.example.testloginform.domain.models.UserModel
import javax.inject.Inject

private const val SHARED_PREF_KEY = "shared_pref"
private const val KEY_FIRST_NAME = "firstName"
private const val KEY_LAST_NAME = "lastName"


class SharedPreferences @Inject constructor(private val context: Context): SharedPrefStorage {

    private val sharedPreferences =
        context.getSharedPreferences(SHARED_PREF_KEY, Context.MODE_PRIVATE)

    override fun getData(): UserModel {
        val firstName = sharedPreferences.getString(KEY_FIRST_NAME, KEY_FIRST_NAME) ?: KEY_FIRST_NAME
        val lastName = sharedPreferences.getString(KEY_LAST_NAME, KEY_LAST_NAME) ?: KEY_LAST_NAME
        return UserModel(firstName, lastName)
    }

    override fun saveData(userModel: UserModel) {
        sharedPreferences.edit().putString(KEY_FIRST_NAME, userModel.firstName).apply()
        sharedPreferences.edit().putString(KEY_LAST_NAME, userModel.lastName).apply()
    }
}