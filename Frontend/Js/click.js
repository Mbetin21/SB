document.querySelectorAll('.interests_button').forEach(button => {
    button.addEventListener('click', function() {
        this.classList.toggle('selected');
    });
});


document.getElementById("registerButton").addEventListener("click", function() {
    const nombre = document.getElementById("nombre").value;
    const email = document.getElementById("correo").value;
    const password = document.getElementById("password").value;

    fetch("http://127.0.0.1:5000/register", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({ nombre: nombre, email: email, password: password })
    })
    .then(response => response.json())
    .then(data => {
        if (data.success) {
            alert("Registro exitoso");
            window.location.href = "index_match.html";  
        } else {
            alert("Error: " + data.message);
        }
    })
    .catch(error => console.error("Error:", error));
});
