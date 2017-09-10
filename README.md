# Donde-Invierto-

Grupo: Benjamín Enriquez, Facundo Perri, Ignacio Pedulia, Martin Yoo



Sistema de metodologías.

Las metodologias son un conjunto de condiciones e indicadores, que se van a aplicar sobre las empresas y van a permitir al analista
ver en que empresas conviene invertir y en cuales no.

Implementamos el sistema de la siguiente manera:
Las metodologias contienen una lista de condiciones de filtrado y una lista de condiciones de orden.
-Las condiciones de filtrado van a tomar un indicador y va a filtrar las empresas que no cumplan con la condición impuesta
sobre el indicador
-Las condiciones de orden van a tomar la lista filtrada y la van a ordenar según la rentabilidad de la empresa. Como puede haber más de 
una condición de orden, el analista deberá indicar que importancia tiene esa condición para ponderar.

(La entrega pedía editor gráfico, pero como la entrega 5 es de interfaz gráfica, lo aplazamos para ese momento).



Persistencia.

Para persistir utilizamos la herramienta Hibernate ORM.

En la carpeta inversiones se encuentra la base de datos (llamada "db") que deberá ser cargada para que la aplicación funcione.

Los datos que se persisten en la base de datos son los indicadores y las empresas con sus respectivos balances. (Quedan por hacer
las metodologías y sus condiciones).

