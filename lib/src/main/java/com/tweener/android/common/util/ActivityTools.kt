package com.tweener.android.common.util

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_CLEAR_TASK
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK

/**
 * Utils for {@link Activity}.
 *
 * @author Vivien Mahe
 */
class ActivityTools {

    companion object {
        /**
         * @return A intent to launch an Activity clearing the history stack (i.e. hitting back on the next screen will quit the app).
         */
        fun createNoHistoryIntent(context: Context, activityClass: Class<out Activity>): Intent {
            val intent = Intent(context, activityClass)
            clearHistoryIntent(intent)
            return intent
        }

        fun clearHistoryIntent(intent: Intent) {
            intent.addFlags(FLAG_ACTIVITY_CLEAR_TASK or FLAG_ACTIVITY_NEW_TASK)
        }
    }
}