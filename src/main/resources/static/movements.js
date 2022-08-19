function get_mavements() {
    let search = document.getElementById("search").value;
    const url = 'movement/' + search;


    fetch(url)
        .then((resp) => resp.json())
        .then(function (data) {
            let tbody = document.getElementById("tbody");

            document.querySelectorAll(".empty").forEach(el => el.remove());

            document.getElementById("balance").innerHTML = data.totalizer;
            data.movements.forEach(create_tr);

            function create_tr(item) {
                let tr = document.getElementById("first-tr").cloneNode(true);
                tr.removeAttribute("id");

                let type = tr.querySelector("#type")
                type.innerHTML = item.type.description;
                type.removeAttribute("id");

                let date = tr.querySelector("#date")
                date.innerHTML = item.date;
                date.removeAttribute("id");

                let value = tr.querySelector("#value")
                value.innerHTML = item.value;
                value.removeAttribute("id");

                let cpf = tr.querySelector("#cpf")
                cpf.innerHTML = item.cpf;
                cpf.removeAttribute("id");

                let card = tr.querySelector("#card")
                card.innerHTML = item.card;
                card.removeAttribute("id");

                let hour = tr.querySelector("#hour")
                hour.innerHTML = item.hour;
                hour.removeAttribute("id");

                let store = tr.querySelector("#store")
                store.innerHTML = item.store;
                store.removeAttribute("id");

                let owner = tr.querySelector("#owner")
                owner.innerHTML = item.owner;
                owner.removeAttribute("id");

                tr.style.display = "flex"
                tr.classList.add("empty");
                tbody.appendChild(tr)
            }
        })
        .catch(function (error) {
            console.log(error);
        });
}

get_mavements();

document.getElementById("btn-search").addEventListener("click", get_mavements);