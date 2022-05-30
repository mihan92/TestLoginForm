package com.example.testloginform.di

import com.example.testloginform.data.repository.UserRepositoryImpl
import com.example.testloginform.domain.UserModelRepository
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun providesRepository(userRepositoryImpl: UserRepositoryImpl): UserModelRepository {
        return userRepositoryImpl
    }

}