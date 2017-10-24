function login(){ 
	user=$("#usuario").val()
	pass=$("#contrasena").val()
	if (user == "" || pass == ""){
		alert("Faltan datos");
	}
	else {
        //var dataString = $("#datosFormulario").serialize();
		$.ajax({
                url: "http://localhost:8080/api/iniciarsesion",
                method: "GET",
                async: true,
                contentType: "text/json; charset=utf-8",
                processData: false,
                //dataType: "jsonp",
                //data: dataString       
                data:"nombre="+user+"&password="+pass,
            }).fail(function( jqXHR, textStatus, errorThrown ) {
                console.log("aca");
                alert(jqXHR.status);
            }).success(function() {
                console.log("Ponzio");
            });
	}
}

