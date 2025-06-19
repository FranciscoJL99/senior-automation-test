package com.consubanco.qa.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.findby.By;

public class DemoBlaze {
    public static final Target BTN_SIGN_UP = Target.the("Boton de sign up").located(By.id("signin2"));
    public static final Target BTN_LOGIN = Target.the("Botón de Login").located(By.id("login2"));
    public static final Target TXT_USERNAME = Target.the("Campo texto de usuario").located(By.id("sign-username"));
    public static final Target TXT_PASSWORD = Target.the("Campo texto de contraseña").located(By.id("sign-password"));
    public static final Target BTN_REGISTRO = Target.the("Boton de Registro").located(By.xpath("//button[@onclick='register()']"));
    public static final Target TXT_LOGIN_USERNAME = Target.the("Campo de texto de Username").located(By.id("loginusername"));
    public static final Target TXT_LOGIN_PASSWORD = Target.the("Campo de texto de Password").located(By.id("loginpassword"));
    public static final Target BTN_LOGIN_USERNAME = Target.the("Boton de Login con usuario y clave").located(By.xpath("//button[@onclick='logIn()']"));
    public static final Target TXT_NAME_USERNAME = Target.the("Mensaje de bienvenido con usuario").located(By.id("nameofuser"));
    public static final Target TXT_PRODUCT= Target.the("Nombre producto").located(By.xpath("//h2[@class='name']"));
    public static final Target BTN_ADD_CART = Target.the("Boton de agregar al cart").locatedBy("//a[@class='btn btn-success btn-lg']");
    public static final Target BTN_CART = Target.the("Boton de cart").locatedBy("//a[@id='cartur']");
    public static final Target TXT_PRODUCT_CART = Target.the("Producto en carrito").locatedBy("//td[contains(text(),'{0}')]");
    public static final Target BTN_DELETE_PRODUCT = Target.the("Boton de eliminar producto").locatedBy("//td[contains(text(),'{0}')]//following-sibling::td//a");
    public static final Target BTN_LOGOUT = Target.the("Boton de logout").located(By.id("logout2"));

    public static Target BTN_CATEGORY() {
        int indice = 1 + (int)(Math.random() * 2);
        return Target.the("Menu de categorias aleatorio")
                .locatedBy("//a[@id='itemc'][" + indice + "]");
    }

    public static Target PRODUCT() {
        int indice = 1 + (int)(Math.random() * 7);
        return Target.the("Producto en categoría aleatorio")
                .locatedBy("//div[@class='col-lg-4 col-md-6 mb-4'][" + indice + "]");
    }
}
