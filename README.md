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

**Banderas.java:** visualización de banderas en la consola a partir del archivo de referencia `Flags.csv`, cargando dinámicamente los datos mediante `BufferedReader` y `FileReader` dentro de una matriz bidimensional de $480 x 15$. 

**TablaPosiciones.java:** Este programa en Java administra la tabla de posiciones de un mundial mediante una matriz de 48 filas por 10 columnas, permitiendo consultar la información de los equipos de forma paginada en la consola, actualizar sus datos manualmente y calcular de manera automática la diferencia de goles y los puntos totales de cada selección.

**CalendarioMundial.java:** Este programa en Java utiliza arreglos y matrices para estructurar el calendario de la fase de grupos del mundial con los 48 equipos divididos en 12 grupos, permitiendo al usuario, mediante lecturas estandarizadas con `ConsoleInput.java`, consultar todos los partidos programados por grupo o ingresar el número de un enfrentamiento específico para visualizar la fecha, hora e integrantes de dicho encuentro.

## Colaboración global
En este trabajo se colaboró con toda la clase para crear un solo programa que contiene la visualización de las banderas de 48 países y su respectiva información como su capital, participaciones en mundiales y sus 11 titulares.
![enter image description here](https://www.elespectador.com/wp-content/uploads/elespectador/EO2VVEMU2RCHNGG45B56HL6ZHI.jpg)

## Recursos
**Link presentación:** https://canva.link/plshfpzbvb2kgzf
