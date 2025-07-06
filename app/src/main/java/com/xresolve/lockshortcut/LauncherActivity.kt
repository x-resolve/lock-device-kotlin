package com.xresolve.lockshortcut

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class LauncherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Crear el shortcut al instalar la app
        ShortcutHelper.createShortcut(this)

        // Cerrar inmediatamente para evitar dejar la app visible
        finish()
    }
}
