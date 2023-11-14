package com.loc.newsapp.domain.usecases

import kotlinx.coroutines.flow.Flow
import com.loc.newsapp.domain.manager.LocalUserManager

class ReadAppEntry(private val localUserManager: LocalUserManager) {
    operator fun invoke(): Flow<Boolean> = localUserManager.readAppEntry()
}
