#author Francisco Leon
# language: es
@Mobile
Característica: Swag Labs app

  @CP01
  Escenario: Apertura de la aplicación
    Dado que abrimos la APK de swag labs
    Entonces debe verse el titulo "Swag Labs" y el boton Login

  @CP02
  Esquema del escenario: : Login exitoso
    Dado que abrimos la APK de swag labs
    Cuando ingresamos usuario "<usuario>" y clave "<clave>"
    Y pulsamos el boton Login
    Entonces debe mostrarse la lista de productos
    Ejemplos:
      | usuario      | clave        |
        #Data: loginMobile.json|
      | problem_user | secret_sauce |

  @CP04
  Esquema del escenario: : Seleccion de producto
    Dado que abrimos la APK de swag labs
    Cuando ingresamos usuario "problem_user" y clave "secret_sauce"
    Y pulsamos el boton Login
    Y seleccionamos el producto "<producto>"
    Y pulsamos el boton agregar al carrito
    Entonces el carrito debe tener el producto "<producto>" agregado
    Ejemplos:
      | producto               |
      | Camisa Sauce Labs Bolt |

  @CP05
  Escenario: Remover un producto
    Dado que abrimos la APK de swag labs
    Cuando ingresamos usuario "problem_user" y clave "secret_sauce"
    Y pulsamos el boton Login
    Y seleccionamos el producto " Sauce Labs Bolt"
    Y pulsamos el boton agregar al carrito
    Y el carrito tiene el producto " Sauce Labs Bolt" agregado
    Y  pulsamos remove junto al producto " Sauce Labs Bolt"
    Entonces el carrito debe quedar vacio

  @CP06
  Escenario: Ir a about
    Dado que abrimos la APK de swag labs
    Cuando ingresamos usuario "problem_user" y clave "secret_sauce"
    Y pulsamos el boton Login
    Y abrimos el menu lateral
    Y pulsamos el boton about
    Entonces debe mostrarse la seccion de texto "Swag Labs"

  @CP06
  Escenario: Logout de la aplicacion
    Dado que abrimos la APK de swag labs
    Cuando ingresamos usuario "problem_user" y clave "secret_sauce"
    Y pulsamos el boton Login
    Y pulsamos el boton logout
    Entonces debe regresar a la pantalla de login



