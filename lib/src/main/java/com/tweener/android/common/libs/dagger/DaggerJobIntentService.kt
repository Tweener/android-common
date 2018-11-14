package com.tweener.android.common.libs.dagger

import androidx.core.app.JobIntentService
import dagger.android.AndroidInjection

/**
 * A [JobIntentService] that injects its members in {@link #onCreate()}.
 */
abstract class DaggerJobIntentService : JobIntentService() {

    override fun onCreate() {
        AndroidInjection.inject(this)
        super.onCreate()
    }
}