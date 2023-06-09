document.addEventListener('DOMContentLoaded', function() {
    // Obtener referencia al elemento del calendario
    var calendarBody = document.querySelector('#calendar tbody');

    // Crear un objeto Date para la fecha actual
    var today = new Date();

    // Obtener todas las celdas del calendario
    var cells = calendarBody.querySelectorAll('td');

    // Recorrer todas las celdas y deshabilitar las fechas pasadas
    for (var i = 0; i < cells.length; i++) {
        var cell = cells[i];
        var date = new Date(year, month, cell.textContent);

        if (date < today) {
            cell.classList.add('disabled');
        } else {
            cell.addEventListener('click', function(event) {
                // Quitar la clase "selected" de la celda previamente seleccionada
                var selectedCell = calendarBody.querySelector('.selected');
                if (selectedCell) {
                    selectedCell.classList.remove('selected');
                }

                // Agregar la clase "selected" a la celda seleccionada
                event.target.classList.add('selected');
            });
        }
    }
});
