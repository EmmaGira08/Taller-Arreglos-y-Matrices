# Taller Arreglos y matrices
## Integrantes

 - Samuel Rua
 - David Robinson
 - Emmanuel Giraldo
 ## Introducción
 En este proyecto nos encargamos de darle vida a las banderas y a la información del torneo en la consola de comandos usando Java. Por un lado, procesamos el archivo `Flags.csv` mediante `FileReader` y `BufferedReader` para cargar la matriz de datos e interpretar los números como colores ANSI con la clase `ConsoleColors`, ajustando los `case` de nuestras banderas asignadas (Suiza, Portugal, Egipto, Paraguay, Escocia, Haití y Argelia) para que se impriman correctamente. Además, el desarrollo se complementó con la creación de un programa integral que reúne la información de los 48 países del mundial, junto con otros dos programas independientes: uno dedicado a gestionar la tabla de posiciones y otro enfocado en mostrar el calendario de partidos.
 

![enter image description here](https://elordenmundial.com/wp-content/uploads/2016/01/banderas-mundo-historia.png)

## Programas 
**ConsoleColors.java:** En este programa encontrarás el estandar de los colores para las banderas, sirviendo como extensión al programa principal.

**MegaMundial.java:**
El código MegaMundial.java es un sistema interactivo de consola diseñado para gestionar y visualizar la información de 48 selecciones de fútbol. Su arquitectura se divide en cuatro módulos funcionales:

- Carga y Renderizado Visual: Utiliza FileReader y BufferedReader para extraer datos del archivo Flags.csv hacia una matriz de caracteres, dibujando las banderas de cada país en la consola mediante códigos de color ANSI.

- Fichas Técnicas: Integra estructuras de datos estáticas (arrays y sentencias switch) para almacenar y desplegar la capital, el historial de participaciones mundialistas y la nómina de los 11 jugadores titulares de cada selección.

- Gestión Deportiva: Implementa una tabla de posiciones bidimensional que el usuario puede modificar en tiempo real. Cuenta con validaciones lógicas estrictas para evitar inconsistencias, como ingresar estadísticas negativas o superar el límite de 3 partidos por equipo en la fase de grupos.

- Calendario de Encuentros: Proporciona un cronograma general estructurado por fases (desde grupos hasta la final) y una herramienta de búsqueda rápida para localizar el próximo partido programado de cualquier país.

- Archivo Banderas: Para la generación de las banderas apartir de matrices se creó un archivo "csv" en colaboración grupal con las banderas ya diseñadas para mayor fácilidad a la hora de crear el código  

## Colaboración global
En este trabajo se colaboró con toda la clase para crear un solo programa que contiene la visualización de las banderas de 48 países y su respectiva información como su capital, participaciones en mundiales y sus 11 titulares.
![enter image description here](https://www.elespectador.com/wp-content/uploads/elespectador/EO2VVEMU2RCHNGG45B56HL6ZHI.jpg)

## Recursos
**Link presentación:** https://canva.link/plshfpzbvb2kgzf
