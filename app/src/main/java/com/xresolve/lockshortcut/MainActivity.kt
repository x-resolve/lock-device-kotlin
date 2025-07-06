package com.xresolve.lockshortcut

import android.app.admin.DevicePolicyManager
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.provider.Settings

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val devicePolicyManager = getSystemService(Context.DEVICE_POLICY_SERVICE) as DevicePolicyManager
        val adminComponent = ComponentName(this, LockDeviceAdminReceiver::class.java)

        if (devicePolicyManager.isAdminActive(adminComponent)) {
            devicePolicyManager.lockNow()
            finish()
        } else {
            Toast.makeText(this, "Please activate device admin", Toast.LENGTH_LONG).show()

            val intent = Intent(Settings.ACTION_SECURITY_SETTINGS).apply {
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }
            startActivity(intent)
	    finish()
        }
    }
}
