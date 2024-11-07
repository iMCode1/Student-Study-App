package com.studyappdatabase

import android.app.Application
import com.studyappdatabase.database.AppDatabase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class StudyApp : Application() {
    val database: AppDatabase by lazy { AppDatabase.getDatabase(this) }
}
