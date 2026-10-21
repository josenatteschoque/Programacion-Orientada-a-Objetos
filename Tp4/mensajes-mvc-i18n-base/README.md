# Proyecto base sin Limpiar

Práctica breve de POO para Eclipse, Maven y JavaFX.

## Requisitos

Eclipse con Java y m2e, JDK 21 y conexión para resolver las dependencias iniciales.
JavaFX 21.0.12 se declara en el POM. Scene Builder permite editar visualmente el FXML.

## Importar el proyecto armado

Descomprimir y usar File > Import > Maven > Existing Maven Projects en Eclipse.
Elegir la carpeta que contiene pom.xml. Seleccionar JDK 21 para el proyecto.
En Run As > Maven build, indicar Goals: clean javafx:run.
En JRE seleccionar JDK 21. No anteponer mvn en Goals.

Desde terminal, con Maven externo y JAVA_HOME configurado:

    mvn clean javafx:run

## Seleccionar presentación

En src/main/resources/application.properties, configurar app.ui=javafx o app.ui=cli.
Guardar y reiniciar. Ambos modos parten de mensajes.aplicacion.AplicacionMensajes.
El valor predeterminado es javafx. Un valor desconocido produce un error al iniciar.

Se puede usar mvn clean javafx:run en ambos modos: el objetivo prepara las
bibliotecas y ejecuta el main configurado; app.ui decide si se abre una ventana.
Para CLI también se puede usar Run As > Java Application desde Eclipse sobre
AplicacionMensajes con Maven Dependencies disponibles.

En modo CLI ingresar 1 o 2 para mostrar el mensaje, y 0 para salir. El menú se
repite; las entradas vacías, no numéricas o fuera de rango muestran un aviso.
El fin de entrada también termina la presentación.

## Idioma

Editar src/main/resources/application.properties, guardar y reiniciar.

Español de Argentina: app.language=es y app.country=AR.
Inglés de Estados Unidos: app.language=en y app.country=US.

## Prueba de la aplicación base

Pulsar Mostrar sin elegir. Luego elegir Bienvenida o Despedida y pulsar Mostrar.
Repetir en inglés. También deben cambiar título, etiquetas, botón y opciones.

## Organización

- mensajes.aplicacion: punto de entrada.
- mensajes.config: configuración de idioma y fábrica de presentaciones UILoader.
- mensajes.ui.api: contrato UIEngine para iniciar una presentación.
- mensajes.ui.impl.cli: presentación de consola Interfaz.
- mensajes.modelo: opciones válidas y selección actual, sin JavaFX.
- mensajes.ui.i18n: textos según Locale y ResourceBundle.
- mensajes.ui.impl.javafx: ventana y carga del FXML.
- mensajes.ui.impl.javafx.controller: interacción de esa ventana.

El ComboBox es no editable. Sus textos y la lista de tipos mantienen el mismo
orden. El controlador relaciona el índice elegido con el tipo del modelo;
no compara cadenas traducidas.

## Scene Builder

Abrir src/main/resources/ui/javafx/view/Mensajes.fxml.
Guardar allí, refrescar el proyecto con F5 y volver a ejecutar.
El FXML usa claves %message.show y similares. Para ver textos en Scene Builder,
usar Preview > Internationalization > Set Resource y elegir un archivo de
src/main/resources/ui/i18n. La selección de ese recurso
para el diseño no reemplaza application.properties para ejecutar la aplicación.

No se necesita module-info.java, User Library ni JAR agregados manualmente
para ejecutar mediante el plugin Maven de este proyecto.

## Flujo de arranque

AplicacionMensajes.main -> UILoader.createUIEngine -> CargaParametros.ui ->
JavaFXUserInterface.start o Interfaz.start.

JavaFXUserInterface inicia MainApp y su controlador FXML. Interfaz realiza la
interacción de consola. Ambas usan SeleccionMensaje y Messages. Sólo se inicia
una presentación por ejecución; cambiar la configuración exige reiniciar.

## Actividad pendiente

Esta versión no contiene el botón Limpiar, el manejador limpiar() ni las claves
message.clear de los archivos de idioma.

Agregar el botón con Scene Builder dentro del VBox, conectar su evento con un
nuevo método del controlador y agregar las claves de traducción en español e
inglés. El resultado debe vaciar el selector, borrar la selección del modelo y
recuperar el mensaje inicial. Consultar la guía de la práctica.
