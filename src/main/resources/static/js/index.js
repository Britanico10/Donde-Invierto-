function cargarEmpresa(){ 
	var token = localStorage.getItem("Token");
  $.ajax({
            method: "GET",
            url: "http://inversionesdds.herokuapp.com/api/empresas?token="+token,
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
            alert( "error" );
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
            url: "http://inversionesdds.herokuapp.com/api/empresas?token="+token,
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

    window.open('Aplicarindicador.html','popup','width=600,height=450')
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
            url: "http://inversionesdds.herokuapp.com/api/empresas?token="+token,
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
            url: "http://inversionesdds.herokuapp.com/api/indicadores/aplicar?empresa="+nombreA+"&periodo="+periodoA+"&token="+token,
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
    url: "http://inversionesdds.herokuapp.com/api/balances?id="+id+"&token="+token,
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
      url: "http://inversionesdds.herokuapp.com/api/balances?capitalPropio="+capitalNB+"&deuda="+deudaNB+"&ebitda="+EBITDANB+"&fCashFlow="+flowNB+"&fds="+fdsNB+"&ingNetoOpCont="+contNB+"&ingNetoOpDiscont="+discontNB+"&periodo="+periodoNB+"&idEmpresa="+idEmpresa+"&token="+token,
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
      url: "http://inversionesdds.herokuapp.com/api/balances?id="+id+"&capitalPropio="+capitalNB+"&deuda="+deudaNB+"&ebitda="+EBITDANB+"&fCashFlow="+flowNB+"&fds="+fdsNB+"&ingNetoOpCont="+contNB+"&ingNetoOpDiscont="+discontNB+"&periodo="+periodoNB+"&idEmpresa="+idEmpresa+"&token="+token,
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
            url: "http://inversionesdds.herokuapp.com/api/empresas?nombre="+nombre+"&ano="+anio+"&token="+token,
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
    url: "http://inversionesdds.herokuapp.com/api/empresas?id="+id+"&token="+token,
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
      url: "http://inversionesdds.herokuapp.com/api/empresas?id="+id+"&nuevonombre="+NNombre+"&nuevoano="+Nano+"&token="+token,
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












