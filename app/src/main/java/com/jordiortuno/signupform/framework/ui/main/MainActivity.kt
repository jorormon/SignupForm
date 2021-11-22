package com.jordiortuno.signupform.framework.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jordiortuno.signupform.databinding.MainActivityBinding
import com.jordiortuno.signupform.framework.ui.auth.AuthActivity

class MainActivity : AppCompatActivity() {//,ShowDialogRealtimeListener
    private lateinit var binding: MainActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        RealtimeDatabaseFacade.setShowDialogRealtime(this)
    }


    fun closeSession(){
        val startIntent = Intent(applicationContext, AuthActivity::class.java)
        startIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(startIntent)
        finish()
    }

    /*override fun showDialog(dialogType: DialogType) {
        DialogsRealtime.manageDialogsRealtime(this,dialogType)
    }*/

}