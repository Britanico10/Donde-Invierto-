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


Entrega 5: Servicios web

Se usa Spring Boot para levantar el servidor y exponer los servicios web. Estos son los siguientes:

Iniciar sesión

  -GET a localhost:8080\api\iniciarsesion (devuelve token de sesión)
      parámetros:
          -nombre
          -password
  
Empresas:

  -GET a localhost:8080\api\empresas (devuelve la lista de empresas)
        parámetros:
          -token (de sesión)
  
Indicadores:

  -GET a localhost:8080\api\indicadores (devuelve la lista de indicadores del usuario)
        parámetros:
          -token (de sesión)
  
  -DELETE a localhost:8080\api\indicadores (borra indicador y devuelve lista actualizada)
          parámetros:
          -id (del indicador)
          -token (de sesión)
          
  -POST a localhost:8080\api\indicadores (crea indicador y devuelve lista actualizada)
          parámetros:
          -nombre (del indicador)
          -formula (del indicador)
          -token (de sesión)
          
  -PUT a localhost:8080\api\indicadores (edita indicador y devuelve lista actualizada)
          parámetros:
          -nombre (del indicador)
          -formula (del indicador)
          -token (de sesión)
          
Metodologías

  -GET a localhost:8080\api\metodologias (devuelve la lista de metodologias del usuario)
        parámetros:
          -token (de sesión)
          
  -GET a localhost:8080\api\metodologias\aplicar (aplica metodología y devuelve resultado)
        parámetros:
          -nombre (de metodologia)
          -token (de sesión)
          
  -DELETE a localhost:8080\api\metodologias (borra metodología y devuelve lista actualizada)
        parámetros:
          -nombre (de metodología)
          -token (de sesión)
          
  -POST a localhost:8080\api\metodologias (crea metodología y devuelve lista actualizada)
        parámetros:
          -nombre (de metodología)
          -condicionesFiltro
          -condicionesOrden
          -token (de sesión)
          
  -PUT a localhost:8080\api\metodologias (cambia nombre a metodología y devuelve lista actualizada)
        parámetros:
          -nombre (de metodología)
          -nuevoNombre
          -token (de sesión)

Condiciones de filtrado

  -GET a localhost:8080\api\condicionesFiltro (devuelve la lista de condicionesFiltro del usuario)
        parámetros:
          -token (de sesión)
          
  -DELETE a localhost:8080\api\condicionesFiltro (elimina condicion y devuelve la lista de condicionesFiltro del usuario)
        parámetros:
          -nombre (de condición)
          -token (de sesión)
          
Condiciones de ordenamiento

  -GET a localhost:8080\api\condicionesOrden (devuelve la lista de condicionesOrden del usuario)
        parámetros:
          -token (de sesión)


  -DELETE a localhost:8080\api\condicionesOrden (elimina condicion y devuelve la lista de condicionesOrden del usuario)
        parámetros:
          -nombre (de condición)
          -token (de sesión)
          
