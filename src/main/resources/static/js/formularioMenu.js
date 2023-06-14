function validarFormulario() {
    var nombre = document.getElementById("exampleInputEmail1").value;
    var descripcion = document.getElementById("descripcion").value;
    var precio = document.getElementById("precio").value;

    if (nombre === "" || descripcion === "" || precio === "") {
        alert("Por favor, complete todos los campos.");
        return false;
    }

    if (parseFloat(precio) < 1) {
        alert("El precio debe ser mayor o igual a 1.");
        return false;
    }

    return true;
}