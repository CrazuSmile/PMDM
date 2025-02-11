package com.juanjosesanz.taskmanager.model.preferences

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.map

object AppPreferences {
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "preferences")
    private val USERNAME_VALUE = stringPreferencesKey("USER_VALUE")

    fun loadUsernameValue(context: Context) = context.dataStore.data.map { preferences ->
        preferences[USERNAME_VALUE] ?: ""
    }

    suspend fun saveUsernameValue(context: Context, name: String) {
        context.dataStore.edit { preferences ->
            preferences[USERNAME_VALUE] = name
        }
    }

    suspend fun removeUsernameValue(context: Context) {
        context.dataStore.edit { preferences ->
            preferences.remove(USERNAME_VALUE)
        }
    }
}