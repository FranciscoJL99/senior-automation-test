#author Francisco Leon
# language: es
@Web
Característica: Modulo de Productos

  Antecedentes:
    Dado que el usuario ingresar a la pagina de DemoBlaze
    Cuando hace click en la opcion de Log In
    Y ingresa el usuario "fleon1" y la clave "pruebas1213"
    Y da click en Log In
    Y selecciono una categoría de productos aleatoria desde el menú

  @CP03
  Escenario: Selección de producto
    Cuando selecciono un producto aleatorio de la lista de productos
    Entonces el carrito muestra un mensaje de "Product added" al agregar el producto

  @CP04
  Escenario: Verificar producto en carrito
    Cuando selecciono un producto aleatorio de la lista de productos
    Y el carrito muestra un mensaje de "Product added" al agregar el producto
    Y al acceder a la sección Cart desde el menú
    Entonces el carrito de compras se actualiza con el producto seleccionado

  @CP05
  Escenario: Eliminar producto del carrito
    Cuando selecciono un producto aleatorio de la lista de productos
    Y el carrito muestra un mensaje de "Product added" al agregar el producto
    Y al acceder a la sección Cart desde el menú
    Y el carrito de compras se actualiza con el producto seleccionado
    Y elimino el producto del carrito
    Entonces el carrito de compras se actualiza y no muestra el producto eliminado

