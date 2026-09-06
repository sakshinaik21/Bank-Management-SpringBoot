document.getElementById("loginForm").addEventListener("submit", async function(event) {

event.preventDefault();

const username = document.getElementById("username").value;
const password = document.getElementById("password").value;

const message = document.getElementById("message");

try {

    const response = await fetch(
        `/users/login?username=${encodeURIComponent(username)}&password=${encodeURIComponent(password)}`,
        {
            method: "POST"
        }
    );

    const data = await response.json();

    if (response.ok) {

        message.textContent = "Login successful!";
        message.className = "success";

        // Store logged-in user
        localStorage.setItem("loggedInUser", JSON.stringify(data));

        // Go to dashboard
        setTimeout(function() {
            window.location.href = "dashboard.html";
        }, 1000);

    } else {

        message.textContent =
            data.message || "Invalid username or password";

        message.className = "error";
    }

} catch (error) {

    console.error(error);

    message.textContent =
        "Unable to connect to server.";

    message.className = "error";
}


});
