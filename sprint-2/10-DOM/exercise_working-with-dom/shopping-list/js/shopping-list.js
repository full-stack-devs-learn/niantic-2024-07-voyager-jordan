// add pageTitle
const pageTitle = "Shopping List";

// add groceries
const groceriesData = new ShoppingService().getShoppingList();

/**
 * This function will get a reference to the title and set its text to the value
 * of the pageTitle variable that was set above.
 */

function displayListTitle(parentDiv) {

    const title = document.getElementById("title");
    title.textContent = `${pageTitle}`

    parentDiv.appendChild(title)

}

/**
 * This function will loop over the array of groceries that was set above and add them to the DOM.
 */
function displayGroceries(parentDiv) {

    //list-container
    let listContainer = document.createElement("div");
    listContainer.classList = "list-container"
    listContainer.id = "list-container"
    parentDiv.appendChild(listContainer)
    
    //shopping-list
    const shoppingList = document.getElementById("shopping-list");

    listContainer = document.getElementById('list-container')
    listContainer.appendChild(shoppingList)


    const ulContainer = document.getElementById("groceries")
    groceriesData.forEach(grocery => {
    
        const listItem = document.createElement("div");
        listItem.classList = `list-item`
        listItem.id = `listitem:${grocery.id}`

        listItem.addEventListener('click', toggleStatus)
        shoppingList.append(listItem)

        //title - string
        createListTitle(grocery.title, listItem)
        //quantity - int
        createListQuantity(grocery.quantity, listItem)
        //isComplete - bool
        editListStatus(grocery.isComplete, listItem)


    });

    //button
    const button = document.getElementById("btn:1");

    listContainer.appendChild(button)
}

function createListTitle(value, parentDiv){
    //Create listTitleDiv
    const listTitleDiv = document.createElement("div");
    listTitleDiv.textContent = `${value}`

    //Appened Title -> Parent
    parentDiv.appendChild(listTitleDiv)

}

function createListQuantity(value, parentDiv){
    //Create quantityContainer
    const listQtyContainer = document.createElement("div");
    listQtyContainer.classList = "quantity_container";

    //The value to append after the span
    const textNode = document.createTextNode(value);

    //Create Span
    const qtySpan = document.createElement("span");
    qtySpan.classList = "super";
    qtySpan.textContent = "quantity"


    //Append qtySpan, textNode -> Container
    listQtyContainer.appendChild(qtySpan)
    listQtyContainer.appendChild(document.createTextNode(value))


    //Appended Container -> Parent
    parentDiv.appendChild(listQtyContainer)
}

function editListStatus(value, parentDiv){

    //Checks the status and changes accordingly
    let currentStatus = value ? `list-item complete` : `list-item`;

    //Reassigns Status
    parentDiv.classList = `${currentStatus}`;

}


/**
 * This function will be called when the button is clicked. You will need to get a reference
 * to every list item and add the class completed to each one
 */
function markCompleted() {

    //Created Array by spreading the HTMLCollection
    const allListItems = [...document.getElementsByClassName("list-item")];
    
    //iterated over the array and changed the class
    allListItems.forEach(li => {
        li.classList = `list-item complete`;
    })

}

function toggleStatus(e){
    const currentItem = document.getElementById(e.target.id);
    const currentStatus = [...e.target.classList];

    console.log(currentStatus)
    let newStatus = currentStatus.length % 2 ? `list-item complete` : `list-item`
    
    console.log(newStatus)
    currentItem.classList = `${newStatus}`;
}

document.addEventListener("DOMContentLoaded", () => {

    const mainContainer = document.createElement("div");
    mainContainer.classList = 'container';
    document.body.appendChild(mainContainer)

    displayListTitle(mainContainer);
    displayGroceries(mainContainer);
})


