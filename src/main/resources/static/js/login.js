function login(){ 
	user=$("#usuario").val()
	pass=$("#contrasena").val()
	if (user == "" || pass == ""){
		alert("Faltan datos");
	}
	else {
        $.ajax({
            method: "GET",
<<<<<<< HEAD
            url: "http://localhost:8080/api/iniciarsesion?nombre="+user+"&password="+pass,
=======
            url: "https://inversionesdds.herokuapp.com/api/iniciarsesion?nombre="+user+"&password="+pass,
>>>>>>> bfe855a6c45c28c7051fb3e0cc1c28d326b2d7ba
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

