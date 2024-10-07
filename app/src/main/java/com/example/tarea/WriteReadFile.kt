package com.example.tarea

import android.os.Environment
import android.util.Log
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStreamWriter

class WriteReadFile(){
    public fun guardarTextoEnArchivo(texto: String, nombreArchivo: String):String {
        val estadoAlmacenamiento = Environment.getExternalStorageState()
        val texto = "Saludos en 26/09/24"
        val nombreArchivo= "hola.txt"

        if (estadoAlmacenamiento == Environment.MEDIA_MOUNTED) {
            val directorio = getFilesDir()
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
}