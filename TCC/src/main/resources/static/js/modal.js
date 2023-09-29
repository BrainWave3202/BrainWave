// Função para exibir o modal com a mensagem de erro
function showErrorModal(message) {
    var modal = document.getElementById("myModal");
    var errorMessage = document.getElementById("errorMessage");
    errorMessage.innerText = message;
    modal.style.display = "block";
}

// Função para fechar o modal
function closeModal() {
    var modal = document.getElementById("myModal");
    modal.style.display = "none";
}

// Evento para fechar o modal quando o usuário clicar no botão "x"
var closeButton = document.getElementsByClassName("close")[0];
closeButton.addEventListener("click", closeModal);
