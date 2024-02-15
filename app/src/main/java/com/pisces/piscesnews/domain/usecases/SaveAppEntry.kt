package com.pisces.piscesnews.domain.usecases

import com.pisces.piscesnews.domain.manager.LocalUserManager

class SaveAppEntry(
    private val localUserManager:LocalUserManager
) {
    suspend operator fun invoke(){
        localUserManager.saveAppEntry()
    }
}