
# Multiplicador de Matrices con RMI

## Descripción del Proyecto

Este proyecto es una aplicación Java que permite la multiplicación de matrices de manera secuencial, concurrente y paralela utilizando JavaFX para la interfaz gráfica y RMI (Remote Method Invocation) para el paralelismo. La aplicación está diseñada para mostrar la interacción y el control de la aplicación, el número de hilos, el estado de los hilos, y el tiempo real de procesamiento.

Desarrollado por: **Brenda Navarro**

## Funcionalidad

### Modos de Operación

1. **Multiplicación Secuencial**: Realiza la multiplicación de matrices en un solo hilo.
2. **Multiplicación Concurrente**: Divide la multiplicación de matrices en múltiples hilos dentro de la misma máquina.
3. **Multiplicación Paralela**: Utiliza RMI para distribuir la carga de la multiplicación de matrices entre múltiples máquinas.

### Características

- **Interfaz Gráfica Intuitiva**: La aplicación cuenta con una interfaz gráfica desarrollada con JavaFX que permite ingresar los tamaños de las matrices, el número de hilos y visualizar los resultados.
- **Animaciones y Efectos**: Los componentes de la interfaz tienen animaciones para mejorar la experiencia del usuario.
- **Resultados en Tiempo Real**: Muestra el tiempo de procesamiento para cada tipo de multiplicación (secuencial, concurrente y paralelo).
- **Compatibilidad con RMI**: Permite la ejecución de la multiplicación de matrices en múltiples máquinas utilizando RMI para distribuir la carga.

## Estructura del Proyecto

```
src
|-- componentes
|   |-- CircularBorderFX.java
|   |-- HiloUIFX.java
|   |-- RGBChromaButtonUIFX.java
|   |-- UIMainFX.java
|-- logica
|   |-- Concurrente.java
|   |-- Estado.java
|   |-- MaquinaEstados.java
|   |-- Secuencial.java
|-- rmi
|   |-- MatrixMultiplication.java
|   |-- MatrixMultiplicationImpl.java
|   |-- RMIServer.java
|   |-- RMIClient.java
|-- resources
|   |-- styles.css
```

### Descripción de los Archivos

- **componentes**: Contiene las clases relacionadas con la interfaz gráfica.
  - `CircularBorderFX.java`: Implementa un borde circular para los componentes UI.
  - `HiloUIFX.java`: Clase principal que maneja la interfaz de usuario y la lógica de multiplicación de matrices.
  - `RGBChromaButtonUIFX.java`: Implementa botones con efectos de color.
  - `UIMainFX.java`: Punto de entrada principal de la aplicación JavaFX.

- **logica**: Contiene las clases que implementan la lógica de multiplicación de matrices.
  - `Concurrente.java`: Implementa la lógica de multiplicación concurrente.
  - `Estado.java`: Define los posibles estados de la aplicación.
  - `MaquinaEstados.java`: Maneja la máquina de estados de la aplicación.
  - `Secuencial.java`: Implementa la lógica de multiplicación secuencial.

- **rmi**: Contiene las clases relacionadas con RMI.
  - `MatrixMultiplication.java`: Interfaz remota para la multiplicación de matrices.
  - `MatrixMultiplicationImpl.java`: Implementación de la interfaz remota.
  - `RMIServer.java`: Configura y ejecuta el servidor RMI.
  - `RMIClient.java`: Cliente que se conecta al servidor RMI y realiza la multiplicación de matrices.

- **resources**: Contiene archivos de recursos como hojas de estilo.
  - `styles.css`: Hoja de estilo para la interfaz JavaFX.

## Configuración del Entorno

### Requisitos

- Java Development Kit (JDK) 17 o superior
- Configuración de RMI
- Dos máquinas (físicas o virtuales) para ejecutar el servidor y el cliente RMI

### Instrucciones de Instalación

1. **Clonar el Repositorio**

   ```bash
   git clone https://github.com/tu-usuario/multiplicador-matrices-rmi.git
   cd multiplicador-matrices-rmi
   ```

2. **Compilar el Proyecto**

   Utiliza tu IDE favorito (IntelliJ IDEA, Eclipse) para compilar el proyecto.

3. **Configurar y Ejecutar el Servidor RMI**

   - Abre `RMIServer.java` y ejecuta la clase.
   - Asegúrate de que el servidor RMI esté corriendo y accesible en la red.

4. **Configurar y Ejecutar el Cliente RMI**

   - Abre `RMIClient.java` y ajusta la URL del servidor RMI.
   - Ejecuta la clase `RMIClient.java` en otra máquina.

5. **Ejecutar la Aplicación JavaFX**

   - Abre `UIMainFX.java` y ejecuta la clase para iniciar la aplicación gráfica.

## Uso de la Aplicación

1. **Ingresar Parámetros**: Ingresa las filas, columnas y cantidad de hilos en la interfaz.
2. **Seleccionar Modo de Multiplicación**: Selecciona "Iniciar" para comenzar la multiplicación secuencial, concurrente o paralela.
3. **Ver Resultados**: Observa los resultados y el tiempo de procesamiento en la interfaz.

## Contribuciones

Este proyecto fue desarrollado por **Brenda Navarro & DTBCODE**. Las contribuciones y sugerencias son bienvenidas.

## Licencia

Este proyecto está bajo la Licencia MIT. Consulta el archivo `LICENSE` para más detalles.
