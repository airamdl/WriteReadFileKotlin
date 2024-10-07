package com.example.tarea

import android.content.Context
import android.os.Environment
import android.util.Log
import java.io.File

class WriteReadUserPass {
    companion object {
        fun saveUserPassFile(context: Context, nombreArchivo:String, user: String, pass: String): String {
            val estadoAlmacenamiento = Environment.getExternalStorageState()
            val file_name = "user.txt"

            if (estadoAlmacenamiento == Environment.MEDIA_MOUNTED) {
                try {
                    val directorio = context.filesDir
                    val archivo = File(directorio,file_name )

                    val data = "$user:$pass\n"
                    archivo.appendText(data)

                    return "User added $data"
                } catch (e: Exception) {
                    e.printStackTrace()
                    return "Error saving user"
                }
            }else{
                return "No se pudo acceder al almacenamiento"
            }

        }

        fun readUserPasswordFile(context : Context, file_name: String) {
            try {
                val directorio = context.filesDir
                val archivo = File(directorio, file_name)


                val usuarios = archivo.readText()
                Log.i("DAM1", "Usuarios: $usuarios")
            } catch (e: Exception) {
                e.printStackTrace()
                Log.i("DAM1", "Error al leer el archivo")
            }
        }


    }
}