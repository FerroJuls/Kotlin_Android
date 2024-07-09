package com.example.biblioteca.config

class config {
    /*
    se crea una url static para consultar sin instanciar
    el metodo companion object sirve para almacenar las variablesn static
     */
    companion object{
        val urlBase = "http://10.192.80.110:8080/api/v1/";
        val urllibro = urlBase + "libro/"
    }
}