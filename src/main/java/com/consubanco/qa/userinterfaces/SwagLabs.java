package com.consubanco.qa.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.findby.By;

public class SwagLabs {
    public static final Target TXT_SWAG_LABS = Target.the("Titulo Aplicacion swa labs").located(By.xpath("//android.widget.ScrollView[@content-desc='test-Login']//android.widget.ImageView[1]"));
    public static final Target TXT_USERNAME = Target.the("Campo usuario").located(By.xpath("//android.widget.EditText[@content-desc='test-Usuario']"));
    public static final Target TXT_PASSWORD= Target.the("Campo password").located(By.xpath("//android.widget.EditText[@content-desc='test-Contraseña']"));
    public static final Target BTN_LOGIN = Target.the("Boton de LOGIN").located(By.xpath("//android.view.ViewGroup[@content-desc='test-LOGIN']"));

    public static final Target PRODUCT = Target.the("Lista de productos").located(By.xpath("//android.widget.TextView[@text='PRODUCTOS']"));
    public static final Target BTN_ADD_TO_CART = Target.the("Boton de agergar carrito").located(By.xpath("(//android.view.ViewGroup[@content-desc='test-AÑADIR A CARRITO'])[1]"));
    public static final Target BTN_CART = Target.the("Boton de carrito").located(By.xpath("//android.view.ViewGroup[@content-desc='test-Carrito']/android.view.ViewGroup/android.widget.ImageView"));

    public static final Target BTN_REMOVER = Target.the("Boton de demover").located(By.xpath("//android.view.ViewGroup[@content-desc='test-REMOVER']"));
    public static final Target BTN_SEGUIR_COMPRANDO = Target.the("Boton de seguir comprando").located(By.xpath("//android.widget.TextView[@text='CONTINUAR COMPRANDO']"));
    public static final Target BTN_MENU = Target.the("Boton de menu").located(By.xpath("//android.view.ViewGroup[@content-desc='test-Menu']/android.view.ViewGroup/android.widget.ImageView"));
    public static final Target BTN_LOGOUT = Target.the("Boton de cerrar sesion").located(By.xpath("//android.view.ViewGroup[@content-desc='test-CERRAR SESION']"));
    public static final Target BTN_ABOUT = Target.the("Boton de nosotros").located(By.xpath("//android.view.ViewGroup[@content-desc='test-NOSOTROS']"));
    public static final Target PRODUCT_CART = Target.the("Boton de nosotros").located(By.xpath("(//android.widget.TextView[@text='1'])[2]"));

    public static Target SLT_PRODUCT(String nombreProducto) {
        return Target.the("Lista de productos")
                .located(By.xpath("//android.widget.TextView[@text='" + nombreProducto + "']"));
    }
}
