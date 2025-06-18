@RegresionFakeStore
@RegresionApiUsers
Feature: API de Usuarios de la API fakestore

  @ConsultarUsers
  Scenario: Obtener todos los users exitosamente
    Given que el QA desea consultar el API de users
    When realiza la solicitud al endpoint de users
    Then debería ver la respuesta con código exitoso de users

  @CrearUser
  Scenario Outline: Crear user exitosamente
    Given que el QA desea consultar el API de users
    When realiza la creacion del user con los datos
      | id   | username   | email   | password   |
      | <id> | <username> | <email> | <password> |
    Then debería ver la respuesta con código exitoso al crear el user

    Examples:
      | id       | username       | email                   | password |
      | 85745619 | christian951   | pruebaqa123@yopmail.com | qa123    |
      | 85745620 | maria_test     | maria_test@qa.com       | qa456    |

  @ConsultarUser
  Scenario Outline: Consultar un user por ID
    Given que el QA desea consultar el API de users
    When consulta el user por medio del id "<id>"
    Then debería ver la respuesta con código exitoso al consultar el user

    Examples:
      | id |
      | 1  |
      | 2  |

  @ActualizarUser
  Scenario Outline: Actualizar un usuario por ID
    Given que el QA desea consultar el API de users
    When actualiza el user por medio del id
      | idUsuario   | id   | username   | email   | password   |
      | <idUsuario> | <id> | <username> | <email> | <password> |
    Then debería ver el código de respuesta exitosa al actualizar el user

    Examples:
      | idUsuario | id       | username       | email                   | password |
      | 3         | 85745619 | christian951   | updated@yopmail.com     | updated1 |
      | 4         | 85745620 | maria_updated  | maria_updated@qa.com    | updated2 |

  @EliminarUser
  Scenario Outline: Eliminar un usuario por ID
    Given que el QA desea consultar el API de users
    When elimina el user por medio del id "<id>"
    Then debería ver el código de respuesta exitosa al eliminar el user

    Examples:
      | id |
      | 4  |
      | 7  |