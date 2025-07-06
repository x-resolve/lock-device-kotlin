package com.xresolve.lockshortcut

import android.app.admin.DeviceAdminReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class LockDeviceAdminReceiver : DeviceAdminReceiver() {

    override fun onEnabled(context: Context, intent: Intent) {}

    override fun onDisabled(context: Context, intent: Intent) {}
}
