function validarFormulario() {
  var nombre = document.getElementById("exampleInputEmail1").value;
  var apellidos = document.getElementById("apellidos").value;
  var dni = document.getElementById("dni").value;
  var telefono = document.getElementById("telefono").value;

  if (nombre.trim() === "" || apellidos.trim() === "" || dni.trim() === "" || telefono.trim() === "") {
    alert("Por favor, complete todos los campos.");
    return false;
  }

  if (!validarDNI(dni)) {
    alert("El DNI introducido no es válido. Debe tener una letra en mayúscula seguida de 8 números.");
    return false;
  }

  if (!validarTelefono(telefono)) {
    alert("El teléfono introducido no es válido.");
    return false;
  }

  return true;
}

function validarDNI(dni) {
  var regex = /^[0-9]{8}[A-Z]$/;
  return regex.test(dni);
}

function validarTelefono(telefono) {
  var regex = /^[0-9]{9}$/;
  return regex.test(telefono);
}