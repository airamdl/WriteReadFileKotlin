package com.example.tarea

import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.text.Layout
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable


import java.io.File //https://developer.android.com/reference/java/io/File.html
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.OutputStreamWriter
import java.lang.reflect.Modifier
import java.time.LocalDateTime

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SaveTextToFile("hola.txt")
        }




    }


//    fun guardarTextoEnArchivo(texto: String, nombreArchivo: String) {
//        val estadoAlmacenamiento = Environment.getExternalStorageState()
//        val texto = "Saludos en 26/09/24"
//        val nombreArchivo= "hola.txt"
//
//        if (estadoAlmacenamiento == Environment.MEDIA_MOUNTED) {
//            val directorio = getFilesDir()
//            val archivo = File(directorio, nombreArchivo)
//
//            try {
//                val flujoSalida = FileOutputStream(archivo, true)
//                val writer = OutputStreamWriter(flujoSalida)
//                writer.append(texto)
//                writer.close()
//
//                Log.i("DAM1" ,"Texto añadido en $directorio $nombreArchivo")
//            } catch (e: Exception) {
//                e.printStackTrace()
//                Log.i("DAM1" , "Error al guardar el archivo")
//            }
//        } else {
//            Log.i("DAM1" , "No se pudo acceder al almacenamiento externo")
//        }
//    }


    fun leerTexto(nombreArchivo: String) {
        try {
            val directorio = getFilesDir()
            val archivo = File(directorio, nombreArchivo)


            val texto = archivo.readText()
            Log.i("DAM1", "Texto leído: $texto")
        } catch (e: Exception) {
            e.printStackTrace()
            Log.i("DAM1", "Error al leer el archivo")
        }
    }

    @Composable
    fun SaveTextToFile(nombreArchivo: String) {
        val datetime = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            LocalDateTime.now().toString()
        } else {
            TODO("VERSION.SDK_INT < O")
        }

        Column(
            //modifier = Modifier.fillMaxSize(),
            //horizontalAlignment = Layout.Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = { guardarTextoEnArchivo(datetime, nombreArchivo) }
            ) {
                Text("Guardar archivo")
            }
            Button(
                onClick = {leerTexto(nombreArchivo)}
            ) {
                Text("Leer Archivo")
            }
        }
    }

}
