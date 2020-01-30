package com.example.android.dagger.splash

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.example.android.dagger.MyApplication
import com.example.android.dagger.login.LoginActivity
import com.example.android.dagger.main.MainActivity
import com.example.android.dagger.registration.RegistrationActivity
import javax.inject.Inject

class SplashActivity : FragmentActivity() {
    @Inject
    lateinit var splashViewModel: SplashViewModel;

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as MyApplication).appComponent.inject(this)
        super.onCreate(savedInstanceState)

        when (splashViewModel.loadAccountStatus()) {
            LoggedOn -> startActivity(Intent(this, MainActivity::class.java))
            UnLoggedOn -> startActivity(Intent(this, LoginActivity::class.java))
            UnRegistered -> startActivity(Intent(this, RegistrationActivity::class.java))
        }
        finish()
    }
}