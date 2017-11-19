package com.tallrocket.trial.helpers

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

/**
 * Created by user on 11/15/17.
 */

class SharedPrefHelper(context: Context?) {

    init {
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
    }

    public companion object {

        private var mSharedPreferences: SharedPreferences? = null

        fun putString(key: String, value: String) {
            mSharedPreferences?.edit()?.putString(key, value)?.apply()
        }

        fun putFloat(key: String, value: Float) {
            mSharedPreferences?.edit()?.putFloat(key, value)?.apply()
        }

        fun putInt(key: String, value: Int) {
            mSharedPreferences?.edit()?.putInt(key, value)?.apply()
        }

        fun putBoolean(key: String, value: Boolean) {
            mSharedPreferences?.edit()?.putBoolean(key, value)?.apply()
        }

        fun getString(key: String): String {
            return mSharedPreferences!!.getString(key, "")
        }

        fun putFloat(key: String): Float {
            return mSharedPreferences!!.getFloat(key, 0.0f)
        }

        fun getInt(key: String, value: Int): Int {
            return mSharedPreferences!!.getInt(key, 0)
        }

        fun getBoolean(key: String): Boolean {
            return mSharedPreferences!!.getBoolean(key, false)
        }
    }
}
