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
    private val KEY_VALUE = stringPreferencesKey("KEY_VALUE")

    fun loadKeyValue(context: Context) = context.dataStore.data.map { preferences ->
        preferences[KEY_VALUE] ?: ""
    }

    suspend fun saveKeyValue(context: Context, name: String) {
        context.dataStore.edit { preferences ->
            preferences[KEY_VALUE] = name
        }
    }

    suspend fun removeKeyValue(context: Context) {
        context.dataStore.edit { preferences ->
            preferences.remove(KEY_VALUE)
        }
    }
}