package io.coroutines.cache.dao

import android.content.Context
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.Date

class RealmDatabase(private val context: Context) {

    fun initDatabase() {
        Realm.init(context)

        val realmConfiguration = RealmConfiguration.Builder()
            .name(context.packageName + CACHE_PREFIX)
            .schemaVersion(VERSION)
            .deleteRealmIfMigrationNeeded()
            .build()

        Realm.setDefaultConfiguration(realmConfiguration)
    }

    fun getDatabase(): Realm {
        return Realm.getDefaultInstance()
    }

    companion object {
        private const val VERSION = 1L
        private const val CACHE_PREFIX = "cache"
    }

}