package com.example.tarea

import android.content.Context
import android.os.Environment
import java.io.File

class WriteReadUserPass {
    companion object {
        fun saveUserPassFile(context: Context, user: String, pass: String): String {
            val estadoAlmacenamiento = Environment.getExternalStorageState()
            val file_name = "user.txt"

            if (estadoAlmacenamiento == Environment.MEDIA_MOUNTED) {
                try {
                    val directorio = context.filesDir
                    val archivo = File(directorio,file_name )

                    val data = "$user:$pass\n"
                    archivo.appendText(data)

                    return "User added"
                } catch (e: Exception) {
                    e.printStackTrace()
                    return "Error saving user"
                }
            }

        }
    }
}