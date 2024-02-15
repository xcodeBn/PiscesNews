package com.pisces.piscesnews.domain.usecases

import com.pisces.piscesnews.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow

class ReadAppEntry (
    private val localUserManager: LocalUserManager
) {
    suspend operator fun invoke():Flow<Boolean>{
        return localUserManager.readAppEntry()
    }
}