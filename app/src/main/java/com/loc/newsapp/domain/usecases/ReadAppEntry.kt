package com.loc.newsapp.domain.usecases

import android.text.BoringLayout
import com.loc.newsapp.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow

class ReadAppEntry (private val localUserManager: LocalUserManager) {
    suspend fun invoke (): Flow<Boolean> = localUserManager.readAppEntry()
}
