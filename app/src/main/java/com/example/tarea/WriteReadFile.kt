package com.example.tarea

import android.app.Application
import android.content.Context
import android.os.Environment
import android.util.Log
import androidx.compose.runtime.Composable
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStreamWriter

class WriteReadFile{
    companion object{
        public fun guardarTextoEnArchivo(context : Context, texto: String, nombreArchivo: String):String {
            val estadoAlmacenamiento = Environment.getExternalStorageState()
            val texto = "Saludos en 26/09/24"
            val nombreArchivo= "hola.txt"

            if (estadoAlmacenamiento == Environment.MEDIA_MOUNTED) {
                val directorio = context.filesDir
                val archivo = File(directorio, nombreArchivo)

                try {
                    val flujoSalida = FileOutputStream(archivo, true)
                    val writer = OutputStreamWriter(flujoSalida)
                    writer.append(texto)
                    writer.close()

                    return "Texto añadido en $directorio $nombreArchivo"
                } catch (e: Exception) {
                    e.printStackTrace()
                    return "Error al guardar el archivo"
                }
            } else {
                return "No se pudo acceder al almacenamiento externo"
            }
        }

        fun leerTexto(context : Context,nombreArchivo: String) {
            try {
                val directorio = context.filesDir
                val archivo = File(directorio, nombreArchivo)


                val texto = archivo.readText()
                Log.i("DAM1", "Texto leído: $texto")
            } catch (e: Exception) {
                e.printStackTrace()
                Log.i("DAM1", "Error al leer el archivo")
            }
        }
    }
}