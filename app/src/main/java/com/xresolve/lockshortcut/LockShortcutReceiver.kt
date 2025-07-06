package com.xresolve.lockshortcut

import android.app.admin.DevicePolicyManager
import android.content.BroadcastReceiver
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.provider.Settings

class LockShortcutReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val dpm = context.getSystemService(Context.DEVICE_POLICY_SERVICE) as DevicePolicyManager
        val adminComponent = ComponentName(context, LockDeviceAdminReceiver::class.java)

        if (dpm.isAdminActive(adminComponent)) {
            dpm.lockNow()
        } else {
	    Toast.makeText(context, "Lock require device admin", Toast.LENGTH_LONG).show()

            val settingsIntent = Intent(Settings.ACTION_SECURITY_SETTINGS).apply {
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }
            context.startActivity(settingsIntent)
        }
    }
}
