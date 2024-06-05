package com.flexath.corner.core.data.manager

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.flexath.corner.core.data.constants.LocalUserManagerConst
import com.flexath.corner.core.data.manager.LocalUserManagerImpl.PreferencesKeys.APP_ENTRY
import com.flexath.corner.core.domain.manager.LocalUserManager
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LocalUserManagerImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : LocalUserManager {

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = LocalUserManagerConst.USER_SETTING.setting)

    private object PreferencesKeys {
        val APP_ENTRY = booleanPreferencesKey(LocalUserManagerConst.APP_ENTRY_SETTING.setting)
    }

    override suspend fun saveAppEntry() {
        context.dataStore.edit {
            it[APP_ENTRY] = true
        }
    }

    override fun readAppEntry(): Flow<Boolean> {
        return context.dataStore.data.map {
            it[APP_ENTRY] ?: false
        }
    }
}