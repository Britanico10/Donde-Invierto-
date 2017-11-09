function login(){ 
	user=$("#usuario").val()
	pass=$("#contrasena").val()
	if (user == "" || pass == ""){
		alert("Faltan datos");
	}
	else {
        $.ajax({
            method: "GET",
            url: "http://localhost:8080/api/iniciarsesion?nombre="+user+"&password="+pass,
            contentType: "application/json;charset=UTF-8",
            dataType: "json",
            async: false
             })
          .done(function(data) {
            alert( "success" );
            alert(data.token);
          })
          .fail(function() {
            alert( "error" );
          })
          .always(function() {
            alert( "complete" );
          });
	}
}

