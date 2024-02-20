package com.pisces.piscesnews.domain.usecases.app_entry

import com.pisces.piscesnews.domain.manager.LocalUserManager

class SaveAppEntry(
    private val localUserManager:LocalUserManager
) {
    suspend operator fun invoke(){
        localUserManager.saveAppEntry()
    }
}