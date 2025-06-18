@RegresionFakeStore
@RegresionApiCarts
Feature: API de Carritos de la API fakestore

  @ConsultarCarts
  Scenario: Obtener todos los Carts exitosamente
    Given que el QA desea consultar el API de carts
    When realiza la solicitud al endpoint de carts
    Then debería ver la respuesta con código exitoso de carts

  @CrearCart
  Scenario Outline: Crear un cart exitosamente
    Given que el QA desea consultar el API de carts
    When realiza la creacion del carts con los datos
      | id   | userId   | productId | title   | price   | description   | category   | image   |
      | <id> | <userId> | <productId> | <title> | <price> | <description> | <category> | <image> |
    Then debería ver la respuesta con código exitoso al crear el carts

    Examples:
      | id      | userId | productId | title            | price | description | category | image              |
      | 123456  | 5      | 999999    | Arroz Automation | 5800  | QA Test     | Test     | https://demoqa.com |
      | 654321  | 8      | 111111    | Pan Automation   | 6970  | QA Test 2   | QA       | https://demoqa.com |

  @ConsultarCart
  Scenario Outline: Consultar un cart por ID
    Given que el QA desea consultar el API de carts
    When consulta el cart por medio del id "<id>"
    Then debería ver la respuesta con código exitoso al consultar el cart

    Examples:
      | id |
      | 1  |
      | 3  |

  @ActualizarCart
  Scenario Outline: Actualizar un cart por ID
    Given que el QA desea consultar el API de carts
    When actualiza el cart por medio del id
      | idCarrito   | id   | userId   | productId | title   | price   | description   | category   | image   |
      | <idCarrito> | <id> | <userId> | <productId> | <title> | <price> | <description> | <category> | <image> |
    Then debería ver el código de respuesta exitosa al actualizar el cart

    Examples:
      | idCarrito | id      | userId | productId | title            | price | description     | category | image              |
      | 5         | 123456  | 8      | 999999    | Arroz Automation | 5800  | QA Test Update  | Test     | https://demoqa.com |
      | 3         | 654321  | 4      | 111111    | Pan Automation   | 6970  | QA Test Update2 | QA       | https://demoqa.com |

  @EliminarCart
  Scenario Outline: Eliminar un cart por ID
    Given que el QA desea consultar el API de carts
    When elimina el cart por medio del id "<id>"
    Then debería ver el código de respuesta exitosa al eliminar el cart

    Examples:
      | id |
      | 1  |
      | 5  |