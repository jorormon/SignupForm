package com.jordiortuno.signupform.framework.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jordiortuno.signupform.framework.extraTools.CheckDatabaseListener
import com.jordiortuno.signupform.framework.extraTools.DialogType
import com.jordiortuno.signupform.framework.extraTools.ShowDialogRealtimeListener
import com.jordiortuno.signupform.framework.ui.auth.AuthActivity
import com.jordiortuno.signupform.framework.ui.main.common.DialogsRealtime

class SplashScreen:AppCompatActivity(),CheckDatabaseListener,ShowDialogRealtimeListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //RealtimeDatabaseFacade.init(this,this)
        startActivity(Intent(this, AuthActivity::class.java))
        finish()
    }



    fun goToMainActivity(){
        startActivity(Intent(this, MainActivity::class.java))
    }
    fun goToAuthActivity(){
        startActivity(Intent(this, AuthActivity::class.java))
    }

    override fun onCheckDatabaseFinish(canPass: Boolean) {
        //loginCorrect
        goToMainActivity()
        //loginIncorrect
        goToAuthActivity()
    }

    override fun showDialog(dialogType: DialogType) {
        DialogsRealtime.manageDialogsRealtime(this,dialogType)
    }

}