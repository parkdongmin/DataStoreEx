package com.example.datastoreex.Application

import android.app.Application
import com.example.datastoreex.Module.DataStoreModule

class SampleApplication : Application() {

    private lateinit var dataStore : DataStoreModule

    companion object {
        private lateinit var sampleApplication: SampleApplication
        fun getInstance() : SampleApplication = sampleApplication
    }

    override fun onCreate() {
        super.onCreate()
        sampleApplication = this
        dataStore = DataStoreModule(this)
    }

    fun getDataStore() : DataStoreModule = dataStore
}