document.addEventListener("DOMContentLoaded", () => {

    const bankList = document.getElementById("bankList");
    const search = document.getElementById("bankSearch");

    let banks = [];

    // ==============================
    // GET ALL BANKS
    // ==============================

    async function loadBanks() {

        try {

            const response = await fetch("/banks");

            if (!response.ok) {
                throw new Error("Failed to load banks");
            }

            banks = await response.json();

            displayBanks(banks);

        } catch (error) {

            console.error(error);

            bankList.innerHTML = `
                <div class="error-message">
                    Unable to load banks.
                    <br>
                    Make sure Spring Boot is running.
                </div>
            `;
        }
    }


    // ==============================
    // DISPLAY BANKS
    // ==============================

    function displayBanks(bankData) {

        if (bankData.length === 0) {

            bankList.innerHTML = `
                <div class="empty-message">
                    No banks found.
                </div>
            `;

            return;
        }


        bankList.innerHTML = "";


        bankData.forEach(bank => {

            const card = document.createElement("div");

            card.className = "bank-card";


            card.innerHTML = `

                <div class="bank-logo">
                    🏦
                </div>

                <h2>
                    ${bank.bankName}
                </h2>

                <p>
                    <strong>IFSC:</strong>
                    ${bank.ifsc}
                </p>

                <p>
                    <strong>Branch:</strong>
                    ${bank.branchName}
                </p>

                <p>
                    <strong>Contact:</strong>
                    ${bank.contact}
                </p>

                <p>
                    <strong>City:</strong>
                    ${bank.address?.city || "N/A"}
                </p>

                <a href="bank-details.html?id=${bank.bankId}">
                    View Details →
                </a>

            `;


            bankList.appendChild(card);

        });

    }


    // ==============================
    // SEARCH BANKS
    // ==============================

    search?.addEventListener("input", () => {

        const value = search.value.toLowerCase().trim();


        const filteredBanks = banks.filter(bank => {

            return (

                bank.bankName?.toLowerCase().includes(value) ||

                bank.ifsc?.toLowerCase().includes(value) ||

                bank.branchName?.toLowerCase().includes(value) ||

                bank.address?.city?.toLowerCase().includes(value)

            );

        });


        displayBanks(filteredBanks);

    });


    // ==============================
    // LOAD DATA
    // ==============================

    loadBanks();

});