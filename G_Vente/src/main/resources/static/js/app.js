(function () {
    const year = document.getElementById("year");
    if (year) year.textContent = new Date().getFullYear();

    // Simple table search (used in produits.jsp)
    const search = document.getElementById("tableSearch");
    const table = document.getElementById("produitsTable");
    if (search && table) {
        search.addEventListener("input", () => {
            const q = search.value.trim().toLowerCase();
            const rows = table.querySelectorAll("tbody tr");
            rows.forEach(tr => {
                const text = tr.innerText.toLowerCase();
                tr.style.display = text.includes(q) ? "" : "none";
            });
        });
    }
})();
