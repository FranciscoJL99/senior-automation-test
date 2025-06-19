#author Francisco Leon
# language: es
@Web
Característica: Registro de usuarios

  Antecedentes:
    Dado que el usuario ingresar a la pagina de DemoBlaze

  @CP01
  Escenario: Registro de usuario exitoso
    Cuando hace click en la opcion de Sign Up
    Y ingresa un usuario y clave
    Y da click en sign up
    Entonces se presenta el mensaje de "Sign up successful."


