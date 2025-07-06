package com.xresolve.lockshortcut

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.pm.ShortcutInfo
import android.content.pm.ShortcutManager
import android.graphics.drawable.Icon

object ShortcutHelper {
    fun createShortcut(context: Context) {
        val shortcutManager = context.getSystemService(ShortcutManager::class.java)

        if (shortcutManager != null && shortcutManager.isRequestPinShortcutSupported) {
            val intent = Intent("com.xresolve.lockshortcut.ACTION_LOCK_SCREEN")
            intent.setClass(context, LockShortcutReceiver::class.java)

            val shortcut = ShortcutInfo.Builder(context, "lock_shortcut")
                .setShortLabel("Lock")
                .setLongLabel("Lock Screen")
                .setIcon(Icon.createWithResource(context, R.drawable.ic_lock))
                .setIntent(intent)
                .build()

            shortcutManager.requestPinShortcut(shortcut, null)
        }
    }
}
