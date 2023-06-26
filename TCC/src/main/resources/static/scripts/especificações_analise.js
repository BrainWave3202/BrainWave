const button = document.querySelector("aceitar")
const modal = document.querySelector("dialog")
const buttonClose = document.querySelector ("dialog button")

aceitar.onclick = function (){
    modal.showModal()

}

buttonClose.onclick = function (){
    modal.close()
}



 
/*BOTAO NEGAR*/

const button2 = document.querySelector("#negar")
const modal2 = document.querySelector("#dialog2")
const buttonClose1 = document.querySelector ("#fechar")

negar.onclick = function (){
    modal2.showModal()

}

buttonClose1.onclick = function (){
    modal2.close()
}









