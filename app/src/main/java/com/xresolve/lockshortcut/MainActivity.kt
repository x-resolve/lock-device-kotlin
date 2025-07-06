package com.xresolve.lockshortcut

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Redirige inmediatamente al BroadcastReceiver
        val intent = Intent("com.xresolve.lockshortcut.ACTION_LOCK_SCREEN")
        intent.setClass(this, LockShortcutReceiver::class.java)
        sendBroadcast(intent)

        finish()
    }
}
