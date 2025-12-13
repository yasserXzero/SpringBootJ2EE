(function () {
    const yearEl = document.getElementById("year");
    if (yearEl) yearEl.textContent = new Date().getFullYear();

    const toggleBtn = document.getElementById("togglePwd");
    const pwd = document.getElementById("password");

    if (toggleBtn && pwd) {
        toggleBtn.addEventListener("click", () => {
            const hidden = pwd.type === "password";
            pwd.type = hidden ? "text" : "password";
            toggleBtn.textContent = hidden ? "Masquer" : "Afficher";
            pwd.focus();
        });
    }

    // shake panel if error exists
    const errorBox = document.getElementById("errorBox");
    const panel = document.getElementById("loginPanel");
    if (errorBox && panel) {
        panel.classList.remove("shake");
        void panel.offsetWidth; // reflow
        panel.classList.add("shake");
    }

    // simple loading state
    const form = document.querySelector("form.form");
    const submitBtn = document.getElementById("submitBtn");
    if (form && submitBtn) {
        form.addEventListener("submit", () => {
            submitBtn.disabled = true;
            submitBtn.textContent = "Connexion...";
        });
    }
})();
