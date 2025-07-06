package com.xresolve.lockshortcut

import android.accessibilityservice.AccessibilityService
import android.accessibilityservice.AccessibilityServiceInfo
import android.view.accessibility.AccessibilityEvent
import android.widget.Toast
import android.app.admin.DevicePolicyManager
import android.content.ComponentName

class LockAccessibilityService : AccessibilityService() {

    override fun onServiceConnected() {
        val info = AccessibilityServiceInfo().apply {
            eventTypes = AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED
            feedbackType = AccessibilityServiceInfo.FEEDBACK_GENERIC
            flags = AccessibilityServiceInfo.FLAG_REQUEST_TOUCH_EXPLORATION_MODE
        }
        serviceInfo = info
        Toast.makeText(this, "Lock Service activo", Toast.LENGTH_SHORT).show()
    }

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        // No usamos eventos, solo bloqueo desde shortcut
    }

    override fun onInterrupt() {}

    fun lockScreen() {
        val dpm = getSystemService(DevicePolicyManager::class.java)
        val admin = ComponentName(this, LockDeviceAdminReceiver::class.java)
        if (dpm.isAdminActive(admin)) {
            dpm.lockNow()
        } else {
            Toast.makeText(this, "Activa permisos de administrador", Toast.LENGTH_LONG).show()
            startActivity(
              Intent(android.provider.Settings.ACTION_SECURITY_SETTINGS)
                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            )
        }
    }
}
