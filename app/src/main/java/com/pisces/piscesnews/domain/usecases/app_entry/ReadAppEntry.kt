package com.pisces.piscesnews.domain.usecases.app_entry

import com.pisces.piscesnews.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow

class ReadAppEntry (
    private val localUserManager: LocalUserManager
) {
     operator fun invoke():Flow<Boolean>{
        return localUserManager.readAppEntry()
    }
}