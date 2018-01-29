function cargarEmpresa(){ 
	var token = localStorage.getItem("Token");
  $.ajax({
            method: "GET",
<<<<<<< HEAD
            url: "http://localhost:8080/api/empresas?token="+token,
=======
            url: "https://inversionesdds.herokuapp.com/api/empresas?token="+token,
>>>>>>> bfe855a6c45c28c7051fb3e0cc1c28d326b2d7ba
            contentType: "application/json;charset=UTF-8",
            dataType: "json",
            async: false
             })
          .done(function(data) {
            var tabla=$("#Empresas");
            var longitud= data.length;

            for (var i=0; i<longitud; i++) {
                var filaNueva = "<tr> <td>"+ data[i].nombre + "</td><td>"+ data[i].inicioActividad + "</td><td> <button type=\"button\" class=\"btn btn-info\" onclick=\"mostrarBalance("+data[i].id+")\" > Mostrar Balances </button></td>"
                filaNueva += "<td> <button type=\"button\" class=\"btn btn-warning\" onclick=\"mostrarEditarEmpresa("+data[i].id+")\" > Editar Empresa </button></td>"
                filaNueva+= "<td> <button type=\"button\" class=\"btn btn-danger\" onclick=\"eliminarEmpresa("+data[i].id+")\" > Eliminar empresa </button></td></tr>"
                tabla.append(filaNueva);
                //alert(data[i].nombre);
            }
          })
          .fail(function() {
<<<<<<< HEAD
            alert( "error al cargar empresas" );
=======
            alert( "error" );
>>>>>>> bfe855a6c45c28c7051fb3e0cc1c28d326b2d7ba
          })
          .always(function() {
            //alert( "complete" );
          });
}

function mostrarBalance(idEmpresa){
     localStorage.setItem("ID", idEmpresa);
     window.open('Balance.html','popup','width=1000,height=1200')
} 

function cargarBalances(){ 
  var token = localStorage.getItem("Token");
  var idEmpresa= localStorage.getItem("ID");
  $.ajax({
            method: "GET",
<<<<<<< HEAD
            url: "http://localhost:8080/api/empresas?token="+token,
=======
            url: "https://inversionesdds.herokuapp.com/api/empresas?token="+token,
>>>>>>> bfe855a6c45c28c7051fb3e0cc1c28d326b2d7ba
            contentType: "application/json;charset=UTF-8",
            dataType: "json",
            async: false
             })
          .done(function(data) {
            var tabla=$("#Balance");
            var longitud= data.length;

            for (var i=0; i<longitud; i++) {
                if (data[i].id == idEmpresa ){
                  var longitudb= data[i].balances.length;
                  for (var j=0; j<longitudb; j++) {
                      
                      var filaNueva = "<tr> <td>"+ data[i].balances[j].periodo + "</td><td>"+ data[i].balances[j].capitalPropio + "</td><td> "+ data[i].balances[j].deuda + "</td><td>"+ data[i].balances[j].ebitda+"</td><td>"+data[i].balances[j].fCashFlow+ "</td><td>"+data[i].balances[j].fds+ "</td><td>"+data[i].balances[j].ingNetoOpCont+ "</td><td>"+data[i].balances[j].ingNetoOpDiscont + "</td><td> <button type=\"button\" class=\"btn btn-info\" onclick=\"eliminarBalance("+data[i].balances[j].id+")\" > Eliminar </button></td>"+"<td> <button type=\"button\" class=\"btn btn-info\" onclick=\"mostrarEditar("+data[i].balances[j].id+")\" > Editar </button></td></tr>" 
                      //filaNueva += "<td><button type=\"button\" class=\"btn btn-danger\" onclick=\"eliminar("+data[i].id+")\"> Eliminar </button></td></tr>"   
                //alert(data[i].nombre);
                      tabla.append(filaNueva);
                  }

                }
            }
          })
          .fail(function() {
            alert( "error" );
          })
          .always(function() {
            //alert( "complete" );
          });
}

function aplicarIndicador(){
  var nombreAplicar=$("#empresaAplicar").val();
  var periodoAplicar=$("#periodoAplicar").val();
  var confirmacion;
  confirmacion= validarNombre(nombreAplicar);
  if (confirmacion==0){
    alert("La empresa ingresado no existe");
    location.reload();
  } else{
    localStorage.setItem("EAplicar", nombreAplicar);
    localStorage.setItem("PAplicar", periodoAplicar);

<<<<<<< HEAD
    window.open('AplicarIndicador.html','popup','width=600,height=450')
=======
    window.open('Aplicarindicador.html','popup','width=600,height=450')
>>>>>>> bfe855a6c45c28c7051fb3e0cc1c28d326b2d7ba
    location.reload();
    }
}

function validarNombre(n){
    var token = localStorage.getItem("Token");
    var nombre=n;
    var confirmado=0;
    var longitud;
    $.ajax({
            method: "GET",
<<<<<<< HEAD
            url: "http://localhost:8080/api/empresas?token="+token,
=======
            url: "https://inversionesdds.herokuapp.com/api/empresas?token="+token,
>>>>>>> bfe855a6c45c28c7051fb3e0cc1c28d326b2d7ba
            contentType: "application/json;charset=UTF-8",
            dataType: "json",
            async: false
             })
          .done(function(data) {
            var longitud= data.length;

            for (var i=0; i<longitud; i++) {
                if( data[i].nombre==nombre){
                  confirmado=1;
                }
            }
          })
          .fail(function() {
            alert( "error" );
          })
          .always(function() {
            //alert( "complete" );
          });

        return(confirmado);
}        

function aplicarIndicador2(){
  var token = localStorage.getItem("Token");
  var nombreA = localStorage.getItem("EAplicar");
  var periodoA = localStorage.getItem("PAplicar");
    $.ajax({
            method: "GET",
<<<<<<< HEAD
            url: "http://localhost:8080/api/indicadores/aplicar?empresa="+nombreA+"&periodo="+periodoA+"&token="+token,
=======
            url: "https://inversionesdds.herokuapp.com/api/indicadores/aplicar?empresa="+nombreA+"&periodo="+periodoA+"&token="+token,
>>>>>>> bfe855a6c45c28c7051fb3e0cc1c28d326b2d7ba
            contentType: "application/json;charset=UTF-8",
            async: false
        }).done(function(data) {
            $("#resultado").val(data);
        }).fail(function() {
            alert( "Hubo un error" );
        });
}


function eliminarBalance(id){
  var token = localStorage.getItem("Token");  
  $.ajax({
    method: "DELETE",
<<<<<<< HEAD
    url: "http://localhost:8080/api/balances?id="+id+"&token="+token,
=======
    url: "https://inversionesdds.herokuapp.com/api/balances?id="+id+"&token="+token,
>>>>>>> bfe855a6c45c28c7051fb3e0cc1c28d326b2d7ba
    contentType: "application/json;charset=UTF-8",
    dataType: "json",
    async: false
        })
    .done(function(data) {
      $("#Balance td").remove(); 
      //alert("Se elimino el indicador exitosamente");
      cargarBalances();
    })
    .fail(function() {
      alert( "Hubo un error" );
    });   
}

function crearBalance(){
  var idEmpresa= localStorage.getItem("ID");
  var token = localStorage.getItem("Token");
  var periodoNB = $("#periodoNB").val();
  var capitalNB = $("#capitalNB").val();
  var deudaNB = $("#deudaNB").val();
  var EBITDANB = $("#EBITDANB").val();
  var flowNB = $("#flowNB").val();
  var fdsNB = $("#fdsNB").val();
  var contNB = $("#contNB").val(); 
  var discontNB = $("#discontNB").val();
  if (periodoNB == "" || capitalNB == "" || deudaNB == ""|| EBITDANB == ""|| flowNB == ""|| fdsNB == ""|| contNB == ""|| discontNB == ""){
    alert("Completar los campos faltantes");
  }
 $.ajax({
      method:"POST",
<<<<<<< HEAD
      url: "http://localhost:8080/api/balances?capitalPropio="+capitalNB+"&deuda="+deudaNB+"&ebitda="+EBITDANB+"&fCashFlow="+flowNB+"&fds="+fdsNB+"&ingNetoOpCont="+contNB+"&ingNetoOpDiscont="+discontNB+"&periodo="+periodoNB+"&idEmpresa="+idEmpresa+"&token="+token,
=======
      url: "https://inversionesdds.herokuapp.com/api/balances?capitalPropio="+capitalNB+"&deuda="+deudaNB+"&ebitda="+EBITDANB+"&fCashFlow="+flowNB+"&fds="+fdsNB+"&ingNetoOpCont="+contNB+"&ingNetoOpDiscont="+discontNB+"&periodo="+periodoNB+"&idEmpresa="+idEmpresa+"&token="+token,
>>>>>>> bfe855a6c45c28c7051fb3e0cc1c28d326b2d7ba
      contentType: "application/json;charset=UTF-8",
      dataType: "json",
      async: false
      })
      .done(function(data) {
        $("#balance td").remove(); 
        cargarBalances();
      })
      .fail(function() {
      alert( "Hubo un error" );
      });


}

function mostrarEditar(id){
  localStorage.setItem("IDBALANCE", id);
  CrearTable(1)


}

function CrearTable(num){
   var numero=70;
  var idb = localStorage.getItem("IDBALANCE");
   var tabla=$("#Balance");
  $("#Balance tfoot th").remove();
    var filaNueva = "<tr><th><input type=\"text\" name=\"nombre[]\" class=\"nombre\" placeholder=\"periodo\" width=\"100%\" id=\"periodoNB\"></input></th>"
    filaNueva += "<th><input type=\"text\" name=\"nombre[]\" class=\"nombre\" placeholder=\"capitalPropio\" width=\"100%\" id=\"capitalNB\"></input></th>"
    filaNueva += "<th><input type=\"text\" name=\"nombre[]\" class=\"nombre\" placeholder=\"Deuda\" width=\"100%\" id=\"deudaNB\"></input></th>"
    filaNueva += "<th><input type=\"text\" name=\"nombre[]\" class=\"nombre\" placeholder=\"ebitda\" width=\"100%\" id=\"EBITDANB\"></input></th>"
    filaNueva += "<th><input type=\"text\" name=\"nombre[]\" class=\"nombre\" placeholder=\"fCash Flow\" width=\"100%\" id=\"flowNB\"></input></th>"
    filaNueva += "<th><input type=\"text\" name=\"nombre[]\" class=\"nombre\" placeholder=\"fds\" width=\"100%\" id=\"fdsNB\"></input></th>"
    filaNueva += "<th><input type=\"text\" name=\"nombre[]\" class=\"nombre\" placeholder=\"In OP CONT\" width=\"100%\" id=\"contNB\"></input></th>"
    filaNueva += "<th><input type=\"text\" name=\"nombre[]\" class=\"nombre\" placeholder=\"In OP DISCONT\" width=\"100%\" id=\"discontNB\"></input></th>"
  if (num==1){
   filaNueva+="<th> <button type=\"button\" class=\"btn btn-success\" onclick=\"editar("+idb+")\" > Editar Balance </button></th></tr>" 
  }
  else{
    filaNueva+= "<th><button type=\"button\" class=\"btn btn-info \" id=\"BotonMedio\" onclick=\" crearBalance()\"> Crear Balance</button></th></tr>"
  } 

  tabla.find("tfoot").append(filaNueva);
}

function editar(id){
    var idEmpresa= localStorage.getItem("ID");
    var token = localStorage.getItem("Token");
    var periodoNB = $("#periodoNB").val();
    var capitalNB = $("#capitalNB").val();
    var deudaNB = $("#deudaNB").val();
    var EBITDANB = $("#EBITDANB").val();
    var flowNB = $("#flowNB").val();
    var fdsNB = $("#fdsNB").val();
    var contNB = $("#contNB").val(); 
    var discontNB = $("#discontNB").val();
    var token = localStorage.getItem("Token"); 
    $.ajax({
      method: "PUT",
<<<<<<< HEAD
      url: "http://localhost:8080/api/balances?id="+id+"&capitalPropio="+capitalNB+"&deuda="+deudaNB+"&ebitda="+EBITDANB+"&fCashFlow="+flowNB+"&fds="+fdsNB+"&ingNetoOpCont="+contNB+"&ingNetoOpDiscont="+discontNB+"&periodo="+periodoNB+"&idEmpresa="+idEmpresa+"&token="+token,
=======
      url: "https://inversionesdds.herokuapp.com/api/balances?id="+id+"&capitalPropio="+capitalNB+"&deuda="+deudaNB+"&ebitda="+EBITDANB+"&fCashFlow="+flowNB+"&fds="+fdsNB+"&ingNetoOpCont="+contNB+"&ingNetoOpDiscont="+discontNB+"&periodo="+periodoNB+"&idEmpresa="+idEmpresa+"&token="+token,
>>>>>>> bfe855a6c45c28c7051fb3e0cc1c28d326b2d7ba
      contentType: "application/json;charset=UTF-8",
      dataType: "json",
      async: false
    })
    .done(function(data) {
      $("#Balance td").remove(); 
      cargarBalances();
      CrearTable(3);
    })
    .fail(function() {
      alert( "Hubo un error" );
    });
  }

function crearEmpresa(){
    var token = localStorage.getItem("Token");
    var nombre = $("#nuevaEmpresa").val();
    var anio = $("#nuevoAnio").val();
    $.ajax({
            method: "POST",
<<<<<<< HEAD
            url: "http://localhost:8080/api/empresas?nombre="+nombre+"&ano="+anio+"&token="+token,
=======
            url: "https://inversionesdds.herokuapp.com/api/empresas?nombre="+nombre+"&ano="+anio+"&token="+token,
>>>>>>> bfe855a6c45c28c7051fb3e0cc1c28d326b2d7ba
            contentType: "application/json;charset=UTF-8",
            dataType: "json",
            async: false
             })
          .done(function(data) {
            $("#Empresas td").remove();
            cargarEmpresa();
          })
          .fail(function() {
            alert( "error" );
          })
          .always(function() {
            //alert( "complete" );
          });
}

function eliminarEmpresa(id){
  var token = localStorage.getItem("Token");  
  $.ajax({
    method: "DELETE",
<<<<<<< HEAD
    url: "http://localhost:8080/api/empresas?id="+id+"&token="+token,
=======
    url: "https://inversionesdds.herokuapp.com/api/empresas?id="+id+"&token="+token,
>>>>>>> bfe855a6c45c28c7051fb3e0cc1c28d326b2d7ba
    contentType: "application/json;charset=UTF-8",
    dataType: "json",
    async: false
        })
    .done(function(data) {
      $("#Empresas td").remove(); 
      //alert("Se elimino el indicador exitosamente");
      cargarEmpresa();
    })
    .fail(function() {
      alert( "Hubo un error" );
    });   
}

function mostrarEditarEmpresa(id){
  var tabla=$("#Empresas");
  var id= id;
  var numero=70;
   var filaNueva = "<tr id=\""+numero+"\">"
  filaNueva+= "<td><input type\"text\" id=\"NNombre\" placeholder=\"Nuevo Nombre\"</td>"
  filaNueva+= "<td><input type\"text\" id=\"Nano\" placeholder=\"Nuevo Inicio de actividad\"</td>"
  filaNueva+= "<td><button type=\"button\" class=\"btn btn-success\" onclick=\"editarEmpresa("+id+")\" > Aceptar </button></td>"
  filaNueva+= "<td></td>"
  filaNueva+= "<td></td></tr>" 
  tabla.find("tfoot").append(filaNueva);
}

function editarEmpresa(id){
    var token = localStorage.getItem("Token"); 
    var NNombre = $("#NNombre").val();
    var Nano = $("#Nano").val();
    
    $.ajax({
      method: "PUT",
<<<<<<< HEAD
      url: "http://localhost:8080/api/empresas?id="+id+"&nuevonombre="+NNombre+"&nuevoano="+Nano+"&token="+token,
=======
      url: "https://inversionesdds.herokuapp.com/api/empresas?id="+id+"&nuevonombre="+NNombre+"&nuevoano="+Nano+"&token="+token,
>>>>>>> bfe855a6c45c28c7051fb3e0cc1c28d326b2d7ba
      contentType: "application/json;charset=UTF-8",
      dataType: "json",
      async: false
    })
    .done(function(data) {
      $("#Empresas td").remove(); 
      //alert("Se edito el indicador exitosamente");
       cargarEmpresa()
    })
    .fail(function() {
      alert( "Hubo un error" );
    });
  }

<<<<<<< HEAD
// -------------------------------------------------------------------------  
// A partir de aca empieza lo nuevo Facu.
// -------------------------------------------------------------------------
 
function json(file) {
	var files = file.files;
	var archivo = files[0];
	var reader = new FileReader();
		
	reader.onload = function(evento) {
		var data;
		data = JSON.parse(evento.target.result);
        eliminarBase();
		var	longitud = data.length;
		var id = 0;
		for (var i=0; i<longitud; i++) {
			nuevaEmpresa(data[i].nombre, data[i].inicioActividad, id);
			id += 1;
			var cantidadBalances = data[i].balances.length;
			var contador = localStorage.getItem("Contador");
			for (var j=0; j<cantidadBalances; j++){
				
				nuevoBalance(data[i].balances[j].capitalPropio, data[i].balances[j].periodo, data[i].balances[j].ebitda, data[i].balances[j].fds, data[i].balances[j].fCashFlow, data[i].balances[j].ingNetoOpCont, data[i].balances[j].ingNetoOpDiscont, data[i].balances[j].deuda, contador);
			}																															
		}
		$("#Empresas td").remove();
        cargarEmpresa();
	};
	reader.readAsText(archivo);
}	

function nuevaEmpresa(nombre, anio, id){
    var token = localStorage.getItem("Token");
    $.ajax({
            method: "POST",
            url: "http://localhost:8080/api/empresas?nombre="+nombre+"&ano="+anio+"&token="+token,
            contentType: "application/json;charset=UTF-8",
            dataType: "json",
            async: false
             })
          .done(function(data) {
				localStorage.setItem("Contador", data[id].id);
          })
          .fail(function() {

          })
          .always(function() {
            //alert( "complete" );
          });
}

function nuevoBalance(capital, periodo, ebitda,fds,flow,inCont,inDiscont,deuda,idEmpresa){
	var token = localStorage.getItem("Token");
	$.ajax({
		method:"GET",
		url: "http://localhost:8080/api/balances/agregar?capitalPropio="+capital+"&deuda="+deuda+"&ebitda="+ebitda+"&fCashFlow="+flow+"&fds="+fds+"&ingNetoOpCont="+inCont+"&ingNetoOpDiscont="+inDiscont+"&periodo="+periodo+"&idEmpresa="+idEmpresa+"&token="+token,
		contentType: "application/json;charset=UTF-8",
		dataType: "json",
		async: false
	})
	.done(function(data) {
		
	})
	.fail(function() {

	});
}

function eliminarBase(){
	var token = localStorage.getItem("Token");
	$.ajax({
		method:"GET",
		url: "http://localhost:8080/api/empresas/borrarTodo?token="+token,
		contentType: "application/json;charset=UTF-8",
		dataType: "text",
		async: false
	})
	.done(function(data) {
	alert(data);
	})
	.fail(function() {

	});
}
=======











>>>>>>> bfe855a6c45c28c7051fb3e0cc1c28d326b2d7ba
