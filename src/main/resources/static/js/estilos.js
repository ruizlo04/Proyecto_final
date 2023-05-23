function validateForm() {
	var nombre = document.getElementById("exampleInputEmail1").value;
	var apellidos = document.getElementById("apellidos").value;
	var email = document.getElementById("email").value;
	var dni = document.getElementById("exampleInputPassword1").value;
	var telefono = document.getElementById("exampleInputPassword1").value;

	if (nombre === "" || apellidos === "" || email === "" || dni === "" || telefono === "") {
		alert("Todos los campos son obligatorios");
		return false;
	}

	return true;
}