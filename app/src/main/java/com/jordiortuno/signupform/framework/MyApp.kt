package com.jordiortuno.signupform.framework

import android.app.Application
import com.jordiortuno.signupform.BuildConfig
import com.jordiortuno.signupform.framework.data.network.Provider

class MyApp:Application() {
    enum class Environment{
        PRODUCTION,
        DEVELOPMENT,
        TEST
    }

    override fun onCreate() {
        super.onCreate()
        Provider.initialize(this)
       // FirebaseCrashlyticsFacade.init(applicationContext) TODO("Uncomment when Crashlytics added")
    }

    companion object {
        private const val PRODUCTION_DEBUG_BUILD = "debug"
        private const val TEST_BUILD = "vtest"
        private const val PRODUCTION_RELEASE_BUILD = "release"
        private const val DEVELOP_BUILD = "develop"


        val appStatus: Environment = getStatus()

        private fun getStatus(): Environment {
            return when (BuildConfig.BUILD_TYPE) {
                TEST_BUILD -> {
                    Environment.TEST
                }
                PRODUCTION_DEBUG_BUILD -> {
                    Environment.PRODUCTION
                }
                PRODUCTION_RELEASE_BUILD -> {
                    Environment.PRODUCTION
                }
                DEVELOP_BUILD -> {
                    Environment.DEVELOPMENT
                }
                else -> Environment.DEVELOPMENT
            }
        }

    }

}