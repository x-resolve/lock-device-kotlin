package com.xresolve.lockshortcut

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        overridePendingTransition(0, 0)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE or WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE or WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
        )

        super.onCreate(savedInstanceState)

        // Redirige inmediatamente al BroadcastReceiver
        val intent = Intent("com.xresolve.lockshortcut.ACTION_LOCK_SCREEN")
        intent.setClass(this, LockShortcutReceiver::class.java)
        sendBroadcast(intent)

        finish()
        overridePendingTransition(0, 0)
    }
}
