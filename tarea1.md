# TAREA 1

## 1. Conceptos Fundamentales

### 1.1. ¿Qué es un servicio REST?
Un servicio REST (Representational State Transfer) es un estilo de arquitectura para diseñar servicios web que interactúan con sistemas distribuidos.
### 1.2. ¿Cuáles son los principios del diseño RESTful?
A continuación se detallan los principales principios del diseño RESTful:

###  a. Identificación de Recursos mediante URIs

 - En REST, los recursos se identifican utilizando URIs (Uniform Resource Identifiers). Cada recurso, como un usuario o un artículo, debe tener su propia URI única. Por ejemplo, en una API de usuarios, /users/123 podría representar al usuario con ID 123.

### b. Uso de Métodos HTTP
Los servicios RESTful utilizan los métodos HTTP para realizar operaciones sobre los recursos:

 - **GET:** Recupera la representación de un recurso.
 - **POST:** Crea un nuevo recurso.
 - **PUT:** Actualiza un recurso existente o lo crea si no existe.
 - **PATCH:** Actualiza parcialmente un recurso.
 - **DELETE:** Elimina un recurso.

### c. Representaciones de Recursos
Un recurso puede tener múltiples representaciones (por ejemplo, JSON, XML, HTML). El cliente puede especificar el formato de respuesta preferido mediante el encabezado Accept. El servidor también puede indicar la representación actual en la respuesta mediante el encabezado Content-Type.

### d. Sin Estado (Stateless)
Las interacciones entre el cliente y el servidor son sin estado. Esto significa que cada solicitud del cliente al servidor debe contener toda la información necesaria para procesarla, sin depender de un estado almacenado en el servidor. Esto facilita la escalabilidad y simplifica la administración.

### e. Uso de Hipermedios (HATEOAS)
RESTful sigue el principio de HATEOAS (Hypermedia as the Engine of Application State), donde las respuestas contienen enlaces (hipermedios) que guían al cliente sobre las posibles acciones siguientes. Por ejemplo, una respuesta que devuelve un usuario puede incluir enlaces para editar o eliminar ese usuario.

### f. Caché
Las respuestas de un servicio RESTful deben ser cacheables siempre que sea posible. Esto mejora la eficiencia y reduce la carga en el servidor. El uso de encabezados HTTP como Cache-Control y Expires ayuda a gestionar la caché.

### g. Diseño en Capas
Un sistema RESTful puede estar organizado en capas, donde los componentes no pueden interactuar directamente con capas más allá de la inmediata. Esto permite que la arquitectura se escale, proporciona redundancia y mejora la seguridad.

### h. Interfaz Uniforme
Una característica clave de REST es tener una interfaz uniforme, lo que significa que el mismo conjunto de operaciones se aplica de manera consistente en todo el sistema. Esto hace que las APIs RESTful sean más fáciles de usar y predecibles.

  

### 1.3. ¿Qué es HTTP y cuáles son los métodos HTTP más comunes?
HTTP (Hypertext Transfer Protocol) es un protocolo de comunicación que permite la transferencia de datos en la web. Es la base del intercambio de información en Internet y define cómo se envían y reciben mensajes entre un cliente (como un navegador web) y un servidor.

Los métodos HTTP especifican la acción que se desea realizar en un recurso identificado por una URL. Los métodos más comunes son:

### GET:
 - **Función:** Recupera datos de un servidor sin modificar el estado del recurso. Es seguro y puede ser cacheado.
 - **Uso común:** Obtener información de una página web, recuperar un listado de datos.
 - **Ejemplo:** GET /users/123 podría devolver la información del usuario con ID 123.
###  POST:
 - **Función:** Envía datos al servidor para crear un nuevo recurso. Los datos se suelen enviar en el cuerpo de la solicitud.
 - **Uso común:** Crear un nuevo registro en una base de datos, enviar un formulario.
 - **Ejemplo:** POST /users crea un nuevo usuario con los datos proporcionados.
### PUT:
 - **Función:** Actualiza un recurso existente o lo crea si no existe. Es idempotente, lo que significa que hacer la misma solicitud varias veces no cambia el resultado.
 - **Uso común:** Actualizar todos los detalles de un recurso existente.
 - **Ejemplo:** PUT /users/123 actualizaría el usuario con ID 123 o lo crearía si no existe.
### PATCH:
 - **Función:** Modifica parcialmente un recurso existente. Similar a PUT, pero solo aplica cambios parciales.
 - **Uso común:** Actualizar uno o más campos específicos de un recurso sin modificar el resto.
 - **Ejemplo:** PATCH /users/123 podría actualizar solo el nombre del usuario con ID 123.
### DELETE:
 - **Función:** Elimina un recurso identificado por la URL.
 - **Uso común:** Eliminar un registro de una base de datos.
 - **Ejemplo:** DELETE /users/123 eliminaría al usuario con ID 123.
### HEAD:
 - **Función:** Similar a GET, pero solo recupera los encabezados de la respuesta sin el cuerpo. Se usa para verificar lo que se enviaría en una solicitud GET.
 - **Uso común:** Verificar la existencia de un recurso o su tamaño antes de descargarlo.
### OPTIONS:
 - **Función:** Devuelve los métodos HTTP soportados por el servidor en el recurso especificado. Es útil para la negociación de características.
 -  **Uso común:** Determinar qué operaciones están permitidas en un recurso específico.

### 1.4 ¿Qué es un recurso en el contexto de un servicio REST?
En el contexto de un servicio REST, un recurso es cualquier entidad o dato que puede ser identificado y gestionado a través de una URI (Uniform Resource Identifier). Los recursos son los elementos centrales sobre los cuales se realizan las operaciones en una API RESTful, como la creación, lectura, actualización y eliminación (CRUD).

### 1.5 ¿Qué es un endpoint?
Un endpoint es una URL específica que un cliente utiliza para interactuar con un recurso en un servidor. Los endpoints son las rutas o direcciones que permiten a un cliente acceder a las funcionalidades y datos proporcionados por la API.

## 2. Estructura de un Servicio REST

### 2.1. ¿Qué es un URI y cómo se define?
Un URI (Uniform Resource Identifier) es un identificador estándar utilizado para nombrar y localizar recursos en una red, como Internet. Los URIs son fundamentales para la web, ya que permiten a los clientes (navegadores web, aplicaciones, etc.) identificar y acceder a recursos como páginas web, imágenes, videos, servicios, entre otros.

### 2.2. ¿Qué es una API RESTful?
Una API RESTful (Representational State Transfer) es una interfaz de programación de aplicaciones que sigue los principios del estilo arquitectónico REST para permitir la comunicación entre sistemas a través de HTTP.

### 2.3. ¿Qué son los códigos de estado HTTP y cómo se usan en REST?
Los códigos de estado HTTP son números que el servidor envía en la respuesta a una solicitud HTTP para indicar el resultado de la solicitud. En una API RESTful, estos códigos se utilizan para comunicar el éxito o fracaso de las operaciones realizadas sobre los recursos.
### 2.4. Agregar una tabla con los códigos HTTP de respuesta más comunes, y su significado.
| Código | Significado                            |
|--------|----------------------------------------|
| 200    | OK                                     |
| 201    | Created                                |
| 204    | No Content                              |
| 301    | Moved Permanently                       |
| 302    | Found (Temporarily Moved)               |
| 304    | Not Modified                            |
| 400    | Bad Request                             |
| 401    | Unauthorized                            |
| 403    | Forbidden                               |
| 404    | Not Found                               |
| 500    | Internal Server Error                   |
| 502    | Bad Gateway                             |
| 503    | Service Unavailable                     |
| 504    | Gateway Timeout                         |

### 2.5. ¿Qué es JSON y por qué se usa comúnmente en APIs REST?
JSON (JavaScript Object Notation) es un formato ligero para el intercambio de datos, basado en texto y fácil de leer tanto para humanos como para máquinas

Uso de JSON en APIs REST:

 -  **Intercambio de Datos:** JSON es el formato de intercambio de datos más común en APIs REST debido a su simplicidad y su naturaleza legible. Los clientes y servidores envían y reciben datos en formato JSON, lo que facilita la comunicación entre ellos.
 - **Facilidad de Integración:** Muchas bibliotecas y frameworks en varios lenguajes de programación proporcionan soporte nativo para JSON, lo que simplifica la integración y el manejo de datos en aplicaciones.
 - **Consistencia:** Utilizar JSON proporciona una forma estandarizada de representar datos, lo que ayuda a mantener la consistencia en la comunicación entre diferentes partes del sistema.