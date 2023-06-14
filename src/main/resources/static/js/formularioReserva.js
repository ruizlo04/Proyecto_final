function validarFormulario() {
  // Obtener los valores de los campos del formulario
  var fecha = document.getElementById("form3Example4cd").value;
  var lugar = document.getElementById("lugar").value;
  var numPersonas = document.getElementById("numPersonas").value;

  // Obtener la fecha actual
  var fechaActual = new Date().toISOString().split("T")[0];

  // Validar que la fecha no sea menor a la fecha actual
  if (fecha < fechaActual) {
    alert("La fecha debe ser igual o mayor a la fecha actual.");
    return false;
  }

  // Validar que el lugar no contenga números
  if (/\d/.test(lugar)) {
    alert("El lugar no debe contener números.");
    return false;
  }

  // Validar que el número de personas esté entre 1 y 1000
  if (numPersonas < 1 || numPersonas > 1000) {
    alert("El número de personas debe estar entre 1 y 1000.");
    return false;
  }

  // Si todos los campos son válidos, enviar el formulario
  return true;
}