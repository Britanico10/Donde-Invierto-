function login(){ 
	user=$("#usuario").val()
	pass=$("#contrasena").val()
	if (user == "" || pass == ""){
		alert("Faltan datos");
	}
	else {
        $.ajax({
            method: "GET",
            url: "https://inversionesdds.herokuapp.com/api/iniciarsesion?nombre="+user+"&password="+pass,
            contentType: "application/json;charset=UTF-8",
            dataType: "json",
            async: false
             })
          .done(function(data) {
            var token= data.token;
            localStorage.setItem("Token", token);
            window.location.href= "Home.html"
          })
          .fail(function() {
            alert( "error" );
          })
          .always(function() {
            //alert( "complete" );
          });
	}
}

