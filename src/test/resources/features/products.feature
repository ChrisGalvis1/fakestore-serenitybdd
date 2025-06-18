@RegresionFakeStore
@RegresionApiProducts
Feature: API de Productos de la API fakestore

  @ConsultarProducts
  Scenario: Obtener todos los productos exitosamente
    Given que el QA desea consultar el API de productos
    When realiza la solicitud al endpoint de productos
    Then debería ver la respuesta con código exitoso

  @CrearProduct
  Scenario Outline: Crear producto exitosamente
    Given que el QA desea consultar el API de productos
    When realiza la creacion del producto con los datos
      | id   | title   | price   | description   | category   | image   |
      | <id> | <title> | <price> | <description> | <category> | <image> |
    Then debería ver la respuesta con código exitoso al crear el producto

    Examples:
      | id       | title                 | price | description                             | category    | image              |
      | 36823100 | Prueba tecnica Kashio | 5800  | Prueba de Java/SerenityBDD y Screenplay | Automation  | https://demoqa.com |
      | 36823100 | Prueba tecnica Kashio | 6970  | Prueba de Java/SerenityBDD y Screenplay | Automation2 | https://demoqa.com |

  @ConsultarProduct
  Scenario Outline: Consultar un producto por ID
    Given que el QA desea consultar el API de productos
    When consulta el producto por medio del id "<id>"
    Then debería ver la respuesta con codigo exitoso al consultar el producto

    Examples:
      | id |
      | 4  |
      | 7  |

  @ActualizarProduct
  Scenario Outline: Actualizar un producto por ID
    Given que el QA desea consultar el API de productos
    When actualiza el producto por medio del id
      | idProducto   | id   | title   | price   | description   | category   | image   |
      | <idProducto> | <id> | <title> | <price> | <description> | <category> | <image> |
    Then debería ver el código de respuesta exitosa al actualizar el producto

    Examples:
      | idProducto | id       | title                 | price | description                             | category    | image              |
      | 5          | 36823100 | Prueba tecnica Kashio | 5800  | Prueba de Java/SerenityBDD y Screenplay | Automation  | https://demoqa.com |
      | 8          | 36823100 | Prueba tecnica Kashio | 6970  | Prueba de Java/SerenityBDD y Screenplay | Automation2 | https://demoqa.com |

  @EliminarProduct
  Scenario Outline: Eliminar un producto por ID
    Given que el QA desea consultar el API de productos
    When eliminar el producto por medio del id "<id>"
    Then debería ver el código de respuesta exitosa al eliminar el producto

    Examples:
      | id |
      | 4  |
      | 7  |