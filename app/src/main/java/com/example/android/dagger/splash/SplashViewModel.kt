package com.example.android.dagger.splash

import com.example.android.dagger.user.UserManager
import javax.inject.Inject

class SplashViewModel @Inject constructor(private val userManager: UserManager) {

    fun loadAccountStatus(): AccountStatus {
        return if (!userManager.isUserLoggedIn()) {
            if (!userManager.isUserRegistered()) {
                UnRegistered
            } else {
                UnLoggedOn
            }
        } else {
            userManager.userJustLoggedIn()
            LoggedOn
        }
    }
}

sealed class AccountStatus;
object LoggedOn : AccountStatus()
object UnRegistered : AccountStatus()
object UnLoggedOn : AccountStatus()