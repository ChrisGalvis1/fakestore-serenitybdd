# 🧪 Fakestore API Test Automation

Este proyecto contiene la automatización de pruebas para la API pública de [FakeStoreAPI](https://fakestoreapi.com), utilizando:

- ✅ Java 17
- ✅ Serenity BDD + Cucumber + Screenplay
- ✅ RestAssured
- ✅ Gradle

---

## 📁 Estructura del Proyecto

```
src
├── main
│   └── java/co.com.fakestore.api/
│       ├── models/             -> Clases de datos
│       ├── questions/          -> Validaciones y assertions
│       ├── tasks/              -> Tareas (interacciones con la API)
│       └── utils/              -> Constantes y factories
├── test
│   ├── java/co.com.fakestore.api/
│   │   ├── hook/               -> Ejecución global
│   │   ├── runners/            -> Runners de ejecución
│   │   └── stepsdefinitions/   -> Step Definitions (Cucumber)
│   └── resources/
│       ├── features/           -> Escenarios Cucumber (.feature)
│       ├── serenity.conf       -> Configuración Serenity
│       └── logback-test.xml
```

## ✅ Endpoints cubiertos

### 🔹 Products API

- `GET /products`
- `GET /products/{id}`
- `POST /products`
- `PUT /products/{id}`
- `DELETE /products/{id}`

### 🔹 Carts API

- `GET /carts`
- `GET /carts/{id}`
- `POST /carts`
- `PUT /carts/{id}`
- `DELETE /carts/{id}`

### 🔹 Users API

- `GET /users`
- `GET /users/{id}`
- `POST /users`
- `PUT /users/{id}`
- `DELETE /users/{id}`

### 🔹 Auth API

- `POST /auth/login`
- 🔁 Se incluye caso exitoso y fallido (credenciales incorrectas)

---

## 🚀 Ejecución del proyecto

### ▶️ Desde consola:

```bash
./gradlew clean test
```

### ▶️ Desde IntelliJ:
- Haz clic derecho sobre RunnerFakeStore.java
- Ejecuta como JUnit

### 📊 Reporte Serenity
Después de la ejecución, abre el reporte generado:
- bash
- Copiar
- Editar
- target/site/serenity/index.html
- Este reporte incluye: Resultados por Feature, Escenario y Paso, Cobertura, Evidencia de status por Step

### 👨‍💻 Autor
- Christian Galvis 
- Proyecto técnico de automatización REST APIs