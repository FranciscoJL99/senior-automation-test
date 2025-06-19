#author Francisco Leon
# language: es
@Web
Característica: Login de usuarios

  Antecedentes:
    Dado que el usuario ingresar a la pagina de DemoBlaze

  @CP02
  Esquema del escenario: Login de usuario exitoso
    Cuando hace click en la opcion de Log In
    Y ingresa el usuario "<usuario>" y la clave "<clave>"
    Y da click en Log In
    Entonces se presenta el nombre del "<usuario>" en la esquina superior derecha

    Ejemplos:
      | usuario | clave |
        #Data: login.json|
|fleon1|pruebas1213|


  @CP07
  Esquema del escenario: Logout de usuario exitoso
    Cuando hace click en la opcion de Log In
    Y ingresa el usuario "<usuario>" y la clave "<clave>"
    Y da click en Log In
    Entonces se presenta el nombre del "<usuario>" en la esquina superior derecha
    Y hace click en la opcion de Logout
    Entonces regresa a la pagina de inicio

    Ejemplos:
      | usuario | clave |
        #Data: login.json|
|fleon1|pruebas1213|
