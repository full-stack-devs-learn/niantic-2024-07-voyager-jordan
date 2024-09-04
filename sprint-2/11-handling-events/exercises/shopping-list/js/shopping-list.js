let service;
let list = []

let allItemsIncomplete = true;


function displayListTitle() {
    const title = document.getElementById("title")
    title.textContent = service.getListName();
}


function displayShoppingList() {
    const parent = document.getElementById("shopping-list")

    list.forEach(item => {
        addListItem(item, parent);
    })
}

function addListItem(item, parent)
{
    const div = document.createElement("div")
    div.classList.add("list-item");

    div.addEventListener("click", listItemCompleteStatus)
    div.addEventListener("dblclick", listItemIncompleteStatus)

    //Adds current list item status
    if(item.isComplete)
    {
        div.classList.add("complete")
    }

    addItemTitle(item, div);
    addQuantity(item, div)

    parent.appendChild(div)
}

function addItemTitle(item, parent)
{
    const div = document.createElement("div")
    div.textContent = item.title;

    parent.appendChild(div);
}

function addQuantity(item, parent)
{
    const div = document.createElement("div");
    div.classList.add("quantity-container");

    const span = document.createElement("span");
    span.textContent = "quantity"
    span.classList.add("super");

    const text = document.createTextNode(item.quantity)

    div.appendChild(span)
    div.appendChild(text)

    parent.appendChild(div);
}

//EVENT LISTENERS

//List-items
function listItemCompleteStatus(e){
    const currentTarget = e.currentTarget

    currentTarget.classList.add("complete")
    
    currentTarget.classList.contains("complete") ?
        currentTarget.style.textDecoration = "line-through" :
        currentTarget.style.textDecoration = "none";
      
}
function listItemIncompleteStatus(e){
    const currentTarget = e.currentTarget

    currentTarget.classList.remove("complete")
    
    currentTarget.classList.contains("complete") ?
        currentTarget.style.textDecoration = "line-through" :
        currentTarget.style.textDecoration = "none";
}

//Mark All Button
function markCompleteInterface(){
    const completeButton = document.getElementById("allCompleteButton")
        completeButton.addEventListener("click", markAllStatus)   
}

function markAllStatus() {
    const listItems = document.querySelectorAll(".list-item");
    const completeButton = document.getElementById("allCompleteButton")

    let currentStatus = completeButton.textContent.trim();

    if(currentStatus === "Mark All Completed"){
        listItems.forEach(item => {
            item.classList.add("complete");
            item.style.textDecoration = "line-through";
        })
        completeButton.textContent = "Mark All Incomplete"
    } else {
        listItems.forEach(item => {
            item.classList.remove("complete");
            item.style.textDecoration = "none";
        })
        completeButton.textContent = "Mark All Completed"
    }
}

//Add Item
function addListItemInit(){
    //Gets Buttons Parent
    let form = document.querySelector("form")
    form.id = "addItemForm"

    const formById = document.getElementById("addItemForm");
    formById.addEventListener('submit', addListItemFormHandler)
    
}
function addListItemFormHandler(e){
    e.preventDefault();
    let itemName = e.target.itemName.value;
    let quantity = e.target.quantity.value;


    const listItemObj = {
        id: list.length+1,
        title: itemName,
        quantity: quantity,
        isComplete: false
    }

    const parent = document.getElementById("shopping-list")
    addListItem(listItemObj, parent)

    //clear
    e.target.itemName.value = "";
    e.target.quantity.value = "";

}
// create the page load event here

document.addEventListener("DOMContentLoaded", () => {
    service = new ShoppingService();
    list = service.getShoppingList();

    displayListTitle();
    displayShoppingList();
    markCompleteInterface();
    addListItemInit();
});

