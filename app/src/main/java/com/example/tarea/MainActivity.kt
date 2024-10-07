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
import androidx.compose.ui.platform.LocalContext


import java.io.File //https://developer.android.com/reference/java/io/File.html
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.OutputStreamWriter
import java.lang.reflect.Modifier
import java.time.LocalDateTime
import com.example.tarea.ui.theme.TareaTheme
import com.example.tarea.WriteReadFile.*



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SaveTextToFile("hola.txt")
            SaveUserPassFile("user.txt","pepe","1234")
        }


    }


    @Composable
    fun SaveTextToFile(nombreArchivo: String) {
        val datetime = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            LocalDateTime.now().toString()
        } else {
            TODO("VERSION.SDK_INT < O")
        }
        val myContext = LocalContext.current

        Column(
            //modifier = Modifier.fillMaxSize(),
            //horizontalAlignment = Layout.Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = { WriteReadFile.guardarTextoEnArchivo(myContext, datetime, nombreArchivo) }
            ) {
                Text("Guardar archivo")
            }
            Button(
                onClick = {WriteReadFile.leerTexto(myContext,nombreArchivo)}
            ) {
                Text("Leer Archivo")
            }

        }
    }
    @Composable
    fun SaveUserPassFile(nombreArchivo: String, user : String, pass: String) {
        val myContext = LocalContext.current
        Column(
            //modifier = Modifier.fillMaxSize(),
            //horizontalAlignment = Layout.Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = { WriteReadUserPass.saveUserPassFile(myContext, nombreArchivo, user, pass, ) }
            ) {
                Text("Guardar usuario")
            }
            Button(
                onClick = {WriteReadUserPass.readUserPasswordFile(myContext, nombreArchivo)}
            ) {
                Text("Leer Usuarios")
            }

        }



    }

}
