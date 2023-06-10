document.addEventListener("DOMContentLoaded", function () {
  const reservaForm = document.getElementById("reservaForm");
  reservaForm.addEventListener("submit", function (event) {
    event.preventDefault();

    // Validar los campos del formulario
    const nombreUsuario = document.getElementById("form3Example1c").value;
    const fecha = document.getElementById("form3Example4cd").value;
    const tipoEvento = document.getElementById("tipoEvento").value;
    const menu = document.getElementById("menu").value;
    const lugar = document.getElementById("lugar").value;
    const numPersonas = document.getElementById("numPersonas").value;

    if (nombreUsuario === "") {
      alert("Por favor, ingresa el nombre de usuario");
      return;
    }

    if (fecha === "") {
      alert("Por favor, ingresa la fecha");
      return;
    }
    
    // Validar si la fecha seleccionada es pasada
    const fechaSeleccionada = new Date(fecha);
    const fechaActual = new Date();
    if (fechaSeleccionada < fechaActual) {
      alert("No se puede seleccionar una fecha pasada");
      return;
    }

    if (tipoEvento === "") {
      alert("Por favor, selecciona el tipo de evento");
      return;
    }

    if (menu === "") {
      alert("Por favor, selecciona un menú");
      return;
    }

    if (lugar === "") {
      alert("Por favor, ingresa el lugar del evento");
      return;
    }

    if (numPersonas === "") {
      alert("Por favor, ingresa el número de personas");
      return;
    }

    // Si todos los campos son válidos, puedes enviar el formulario
    reservaForm.submit();
  });
});
