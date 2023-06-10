document.addEventListener("DOMContentLoaded", function () {
  const loginForm = document.querySelector("form");
  loginForm.addEventListener("submit", function (event) {
    event.preventDefault();

    // Obtener los valores de usuario y contraseña
    const usernameInput = document.getElementById("username");
    const passwordInput = document.getElementById("password");
    const username = usernameInput.value;
    const password = passwordInput.value;

    // Validar los campos del formulario
    if (username.trim() === "") {
      alert("Por favor, ingresa el nombre de usuario");
      return;
    }

    if (password.trim() === "") {
      alert("Por favor, ingresa la contraseña");
      return;
    }

    // Enviar el formulario manualmente
    loginForm.submit();
  });
});
