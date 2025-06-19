package com.consubanco.qa.exceptions;

public class Exceptions extends AssertionError{
    public static String MSJ_SIGN_UP = "El registro no fue realizado correctamente. Por favor, verifica los datos ingresados.";
    public static String MSJ_LOGIN = "El login no se realizado correctamente. Por favor, verifica los datos ingresados.";
    public static String SCR_HOME = "La pantalla de inicio no se ha cargado correctamente.";
    public static String MSJ_PRODUCTO_NO_EXIST = "No se visualiza el producto agregado en el carrito.";

    public Exceptions(String message, Throwable cause) {
        super(message, cause);
    }
}
