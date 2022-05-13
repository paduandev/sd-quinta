function buscarDados() {
    let url = 'http://localhost:8080/user';

    fetch(url)
    .then(res => res.json())
    .then(data => exibir(data))

}

function exibir(data) {
    console.log(data);
    let cxtexto = document.getElementById("nome");
    cxtexto.value = data[0].nome;
    document.getElementById("email").value = data[0].email;
}

function inserirDados() {
    let url = 'http://localhost:8080/user';

    let nome = document.getElementById("nome").value;
    let email = document.getElementById("email").value;

    msg = {
        nome,
        email
    }

    let postMsg = {
        method: 'POST',
        body: JSON.stringify(msg),
        headers: {
            'Content-type':'application/json'
        }
    }

    fetch(url, postMsg)
    .then(res => res.json())
    .then(data => console.log('Dados inseridos:', data))

}