var met = new Array();
var co = new Array();
var nombre;

function cargarMetodologias(){ 
	var token = localStorage.getItem("Token");
		$.ajax({
			method: "GET",
			url: "http://localhost:8080/api/metodologias?token="+token,
			contentType: "application/json;charset=UTF-8",
			dataType: "json",
			async: false
      })
			.done(function(data) {
				var tabla=$("#Metodologias");
				var longitud = data.length; 
				for (i=0;i<longitud;i++){
          met[i]= data[i].nombre
          var filaNueva = "<tr>"
					filaNueva += "<td>"+data[i].nombre+"</td>"
          filaNueva += "<td><button type=\"button\" class=\"btn btn-info\" onclick=\"aplicarMetodologia("+i+")\" > Aplicar </button></td>"
          //filaNueva += "<td><button type=\"button\" class=\"btn btn-info\" onclick=\"mostrarFiltro("+data[i].id+")\" > Mostrar </button></td>"
					//filaNueva += "<td><button type=\"button\" class=\"btn btn-info\" onclick=\"mostrarOrden("+data[i].id+")\"> Mostrar </button></td></tr>"
					tabla.append(filaNueva);
				}
			})
			.fail(function() {
			alert( "Hubo un error" );
			});
}

function aplicarMetodologia(pos){
  nombre = met[pos];
  localStorage.setItem("NOMBREAPLICAR", nombre);
  window.open('AplicarMetodologia.html','popup','width=1000,height=1200')

  /*
  $.ajax({
    method: "GET",
    url: "http://localhost:8080/api/metodologias/aplicar?nombre="+nombre+"&token="+token,
    contentType: "application/json;charset=UTF-8",
    dataType: "json",
    async: false
    })
    .done(function(data) {
      alert(data);
    })
    .fail(function() {
      alert( "Hubo un error" );
    });
    */ 
}

function aplicar(){
  var token = localStorage.getItem("Token");
  var nombreB= localStorage.getItem("NOMBREAPLICAR");
 // nombreB = nombreB.replace(/ /g,"");
  $.ajax({
    method: "GET",
    url: "http://localhost:8080/api/metodologias/aplicar?nombre="+nombreB+"&token="+token,
    contentType: "application/json;charset=UTF-8",
    async: false
    })
    .done(function(data) {
      $("#resultado").val(data);
    })
    .fail(function() {
      alert( "Hubo un error" );
    });
 
}

function cargarCondicionesOrden() { 
    var token = localStorage.getItem("Token");
    $.ajax({
      method: "GET",
      url: "http://localhost:8080/api/condicionesorden?token="+token,
      contentType: "application/json;charset=UTF-8",
      dataType: "json",
      async: false
      })
      .done(function(data) {
        var tabla=$("#CondOrden");
        var longitud = data.length; 
        for (i=0;i<longitud;i++){
          co[i]= data[i].nombreCondicion
          var filaNueva = "<tr>"
          filaNueva += "<td>"+data[i].nombreCondicion+"</td>"
          filaNueva += "<td>"+data[i].tipo+"</td>"
          filaNueva += "<td><button type=\"button\" class=\"btn btn-info\" onclick=\"detalleCondicion("+data[i].id+")\" > Ver Detalle </button></td>"
          filaNueva += "<td><button type=\"button\" class=\"btn btn-danger\" onclick=\"eliminarCondicionOrden("+i+")\" > Eliminar </button></td></tr>"

          tabla.append(filaNueva);
        }
      })
      .fail(function() {
      alert( "Hubo un error" );
      });
}

function eliminarCondicionOrden(id) { 
    var token = localStorage.getItem("Token");
    var nombre =  co[id];
    $.ajax({
      method: "DELETE",
      url: "http://localhost:8080/api/condicionesorden?nombre="+nombre+"&token="+token,
      contentType: "application/json;charset=UTF-8",
      dataType: "json",
      async: false
      })
      .done(function(data) {
        $("#CondOrden td").remove(); 
        var tabla=$("#CondOrden");
        var longitud = data.length; 
        for (i=0;i<longitud;i++){
          co[i] = data[i].nombreCondicion;
          var filaNueva = "<tr>"
          filaNueva += "<td>"+data[i].nombreCondicion+"</td>"
          filaNueva += "<td>"+data[i].tipo+"</td>"
          filaNueva += "<td><button type=\"button\" class=\"btn btn-info\" onclick=\"detalleCondicion("+data[i].id+")\" > Ver Detalle </button></td>"
          filaNueva += "<td><button type=\"button\" class=\"btn btn-danger\" onclick=\"eliminarCondicionOrden("+i+")\" > Eliminar </button></td></tr>"

          tabla.append(filaNueva);
        }
      })
      .fail(function() {
      alert( "Hubo un error" );
      });
}

function agregarCondicionOrden() { 
    var token = localStorage.getItem("Token");
    var nombre = $("#nombre").val();
    var tipo = $("#tipo").val();
    var iI = $("#iActividad").val();
    var fI = $("#fActividad").val();
    var periodo = $("#periodo").val();
    var importancia = $("#importancia").val();
    var nombreIndicador = $("#nIndicador").val();
    $.ajax({
      method:"POST",
      url: "http://localhost:8080/api/condicionesorden?tipo="+tipo+"&nombre="+nombre+"&inicioIntervalo="+iI+"&finIntervalo="+fI+"&nombreIndicador="+nombreIndicador+"&periodo="+periodo+"&importancia="+importancia+"&token="+token,
      contentType: "application/json;charset=UTF-8",
      dataType: "json",
      async: false
      })
      .done(function(data) {
        $("#CondOrden td").remove(); 
        var tabla=$("#CondOrden");
        var longitud = data.length; 
        for (i=0;i<longitud;i++){
          co[i] = data[i].nombre;
          var filaNueva = "<tr>"
          filaNueva += "<td>"+data[i].nombreCondicion+"</td>"
          filaNueva += "<td>"+data[i].tipo+"</td>"
          filaNueva += "<td><button type=\"button\" class=\"btn btn-info\" onclick=\"detalleCondicion("+data[i].id+")\" > Ver Detalle </button></td>"
          filaNueva += "<td><button type=\"button\" class=\"btn btn-danger\" onclick=\"eliminarCondicionOrden("+i+")\" > Eliminar </button></td></tr>"

          tabla.append(filaNueva);
        }
      })
      .fail(function() {
      alert( "Hubo un error" );
      });
}
/*function mostrarFiltro(id){
     localStorage.setItem("IDM", id);
     window.open('Filtro.html','popup','width=1000,height=1200')
} 
function mostrarOrden(id){
     localStorage.setItem("IDM", id);
     window.open('Orden.html','popup','width=1000,height=1200')
} 


function cargarfiltro(){ 
  var token = localStorage.getItem("Token");
  var idm= localStorage.getItem("IDM");
  $.ajax({
            method: "GET",
            url: "http://localhost:8080/api/metodologias?token="+token,
            contentType: "application/json;charset=UTF-8",
            dataType: "json",
            async: false
             })
          .done(function(data) {
            var tabla=$("#metodologias");
            var longitud= data.length;

            for (var i=0; i<longitud; i++) {
                if (data[i].id == idm ){
                  var longitudb= data[i].condicionesFiltro.length;
                  for (var j=0; j<longitudb; j++) {
                      var filaNueva = "<tr> <td>"+ data[i].balances[j].periodo + "</td><td>"+ data[i].balances[j].capitalPropio + "</td><td> "+ data[i].balances[j].deuda + "</td><td>"+ data[i].balances[j].ebitda+"</td><td>"+data[i].balances[j].fCashFlow+ "</td><td>"+data[i].balances[j].fds+ "</td><td>"+data[i].balances[j].ingNetoOpCont+ "</td><td>"+data[i].balances[j].ingNetoOpDiscont+ "</td></tr>" 
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

*/
