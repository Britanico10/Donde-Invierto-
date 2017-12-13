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


Iniciar sesión:

  -GET a /api/iniciarsesion (devuelve token de sesión)
  
      parámetros:
          -nombre
          -password
  
  
  
Empresas:

  -GET a /api/empresas (devuelve la lista de empresas)
  
        parámetros:
          -token (de sesión)
          
  -PUT a /api/empresas (edita empresa)
  
          parámetros:
          -token (de sesión)
          -nuevoano
          -nuevonombre
          -id

  -POST a /api/empresas (crea empresa)
  
          parámetros:
          -token (de sesión)
          -ano
          -nombre
  
  -DELETE a /api/empresas (borra empresa)
  
          parámetros:
          -token (de sesión)
          -id
          
  -GET a /api/empresas/borrarTodo (borra todas las empresas y balances)
  
        parámetros:
          -token (de sesión)

Indicadores:

  -GET a /api/indicadores (devuelve la lista de indicadores del usuario)
  
        parámetros:
          -token (de sesión)
  
  -DELETE a /api/indicadores (borra indicador y devuelve lista actualizada)
  
          parámetros:
          -id (del indicador)
          -token (de sesión)
          
  -POST a /api/indicadores (crea indicador y devuelve lista actualizada)
  
          parámetros:
          -nombre (del indicador)
          -formula (del indicador)
          -token (de sesión)
          
  -PUT a /api/indicadores (edita indicador y devuelve lista actualizada)
  
          parámetros:
          -nombre (del indicador)
          -formula (del indicador)
          -token (de sesión)
          
  -GET a /api/indicadores/aplicar (aplica indicadores)
  
        parámetros:
          -token (de sesión)
          -empresa
          -periodo
          
  -GET a /api/indicadores/precalculo (precalcula indicadores)
  
        parámetros:
          -token (de sesión)
          
Metodologías

  -GET a /api/metodologias (devuelve la lista de metodologias del usuario)
  
        parámetros:
          -token (de sesión)
          
  -GET a /api/metodologias/aplicar (aplica metodología y devuelve resultado)
  
        parámetros:
          -nombre (de metodologia)
          -token (de sesión)
          
  -DELETE a /api/metodologias (borra metodología y devuelve lista actualizada)
  
        parámetros:
          -nombre (de metodología)
          -token (de sesión)
          
  -POST a /api/metodologias (crea metodología y devuelve lista actualizada)
  
        parámetros:
          -nombre (de metodología)
          -condicionesFiltro
          -condicionesOrden
          -token (de sesión)
          
  -PUT a /api/metodologias (cambia nombre a metodología y devuelve lista actualizada)
  
        parámetros:
          -nombre (de metodología)
          -nuevoNombre
          -token (de sesión)



Condiciones de filtrado

  -GET a /api/condicionesFiltro (devuelve la lista de condicionesFiltro del usuario)
  
        parámetros:
          -token (de sesión)
          
  -DELETE a /api/condicionesFiltro (elimina condicion y devuelve la lista de condicionesFiltro del usuario)
  
        parámetros:
          -nombre (de condición)
          -token (de sesión)
          
  -POST a /api/condicionesFiltro (crea condicion y devuelve la lista de condicionesFiltro del usuario)
  
        parámetros:
          -nombre (de condición)
          -token (de sesión)
          -tipo
          -inicioIntervalo
          -finIntervalo
          -nombreIndicador
          -periodo
          -comparador
          
Condiciones de ordenamiento

  -GET a /api/condicionesOrden (devuelve la lista de condicionesOrden del usuario)
  
        parámetros:
          -token (de sesión)


  -DELETE a /api/condicionesOrden (elimina condicion y devuelve la lista de condicionesOrden del usuario)
  
        parámetros:
          -nombre (de condición)
          -token (de sesión)
          
  -POST a /api/condicionesOrden (crea condicion y devuelve la lista de condicionesFiltro del usuario)
  
        parámetros:
          -nombre (de condición)
          -token (de sesión)
          -tipo
          -inicioIntervalo
          -finIntervalo
          -nombreIndicador
          -periodo
          -importancia
          
Balances

  -GET a /api/balances (devuelve balances de la empresa)
  
        parámetros:
          -token (de sesión)
          -idEmpresa
          
  -DELETE a /api/balances (borra balance)
  
        parámetros:
          -token (de sesión)
          -id

  -POST a /api/balances (crea balance)
  
        parámetros:
          -token (de sesión)
          -idEmpresa
          -periodo
          -ingNetoOpCont
          -ingNetoOpDiscont
          -fds
          -fCashFlow
          -ebitda
          -deuda
          -capitalPropio

  -PUT a /api/balances (edita balance)
  
        parámetros:
          -token (de sesión)
          -id (del balance)
          -idEmpresa
          -periodo
          -ingNetoOpCont
          -ingNetoOpDiscont
          -fds
          -fCashFlow
          -ebitda
          -deuda
          -capitalPropio
          
Para el inicio de sesión de los usuarios se utilizó la libreria JWT, que genera un token para cada sesión, el cuál esta encriptado y permite seguridad a la hora de hacer peticiones al servidor web. En cada petición al servidor, se enviará el token, que será desencriptado en el mismo y permitirá a este saber que usuario es el que solicita el servicio.

El token es seguro, ya que es generado por un algoritmo utilizando una clave secreta conocida solo por el servidor.

Entrega 6: Despliegue en PaaS

Para desplegar la aplicación elegimos Heroku por ser gratuito y por su simpleza.
Heroku provee un repositorio donde hay que subir la aplicación, y luego por un comando se ejecuta el jar de la misma. La plataforma detecta que es una aplicación java y la ejecuta en una JVM.
A su vez, Heroku provee de una base de datos postgresql integrada, la cuál está levantada en un servidor Amazon.
La única desventaja que tiene utilizar este PaaS es que al ser gratuito, a la media hora de actividad, la página "duerme" y, ante el primer ingreso luego de ese suceso, tarda un poco más en cargar de lo común.
          
