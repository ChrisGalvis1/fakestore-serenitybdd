@RegresionFakeStore
@RegresionAuth
Feature: API de Autenticación en FakeStore API

  @LoginExitoso
  Scenario: Autenticación exitosa con credenciales válidas
    Given que el QA desea autenticarse en la API
    When realiza la autenticacion con las credenciales
      | username | password |
      | johnd    | m38rmF$  |
    Then debería ver el código de respuesta exitoso al autenticar

  @LoginFallido
  Scenario: Autenticación fallida con credenciales inválidas
    Given que el QA desea autenticarse en la API
    When realiza la autenticacion con las credenciales
      | username  | password        |
      | usuarioQA | claveIncorrecta |
    Then debería ver el código de error al autenticar