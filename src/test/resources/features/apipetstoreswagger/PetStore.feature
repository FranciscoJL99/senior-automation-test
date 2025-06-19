#author Francisco Leon
# language: es
@Api
Característica: :Gestión de Mascotas

  Escenario: Post de una mascota
    Cuando agrego una nueva mascota con nombre "Pug_Luna"
    Entonces la mascota debe ser registrada correctamente en la API
      | Status |
      | 200    |


  Escenario: Get mascota agregada
    Cuando agrego una nueva mascota con nombre "Pug_Luna"
    Cuando consulto la información de la mascota
    Entonces se devuelve la mascota correctamente
      | Status |
      | 200    |

  Escenario:  Put de mascota
    Cuando agrego una nueva mascota con nombre "Pug_Luna"
    Y actualizo el nombre de la mascota a "PugCarlino_Luna"
    Entonces la mascota debe ser consultada correctamente en la API
      | Status |
      | 200    |


  Escenario: Verificar nombre de mascota modificado
    Cuando agrego una nueva mascota con nombre "Pug_Luna"
    Y actualizo el nombre de la mascota a "PugCarlino_Luna"
    Y consulto la información de la mascota
    Entonces debo ver el nombre "PugCarlino_Luna" actualizado correctamente

  Escenario: Eliminar mascota
    Cuando agrego una nueva mascota con nombre "Pug_Luna"
    Y elimino la mascota
    Entonces la mascota debe ser consultada correctamente en la API
      | Status |
      | 200    |
