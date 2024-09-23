let categoryService;
let productService;
let addFormScreen;
let addForm;

document.addEventListener("DOMContentLoaded", function() {
    categoryService = new CategoryService();
    productService = new ProductsService();

    addFormScreen = document.getElementById("add-form-screen");
    addForm = document.getElementById("add-form");

    document.getElementById("add-button").addEventListener("click", showForm);
    document.getElementById("cancel-button").addEventListener("click", cancelAdd);
    document.getElementById("save-button").addEventListener("click", addCategory);

    loadCategories();
    loadProducts();
})

async function loadProducts()
{
    // load all products
    let products = await productService.getAllProducts();
    const parent = document.querySelector("#products-container")
    const title = parent.querySelector("#products-header");
    title.textContent = "Products - All"
    displayProducts(products)
}

async function loadCategories()
{
    // load all categories
    const parent = document.querySelector("#sidebar-list-categories")
    let categories = await categoryService.getAllCategories();

    const li = document.createElement("li")
    const button = document.createElement("button")

    button.classList = "btn btn-warning"
    button.id = "addCategoryButton"
    button.textContent = "All"
    button.type = "button"
    button.addEventListener("click", loadProducts)

    li.appendChild(button)
    parent.appendChild(li)


    categories.forEach(category => {

        const li = document.createElement("li")
        const button = document.createElement("button")

        button.classList = "btn btn-warning"
        button.textContent = category.categoryName
        button.type = "button"
        button.value = category.categoryId
        button.addEventListener("click", getProductsByCategoryId)
        li.appendChild(button)
        parent.appendChild(li)
    });

}

async function getProductsByCategoryId(e)
{
    const categoryId = e.target.value;
    let productService = new ProductsService();
    let products = await productService.getProductsByCategoryId(categoryId);

    const headerParent = document.querySelector("#products-container")
    const title = headerParent.querySelector("#products-header");
    title.textContent = `Products - ${e.target.textContent}`

    displayProducts(products)
}

function displayProducts(productsData)
{

    const parent = document.querySelector(".products-card-container")
    parent.innerHTML = '';

    productsData.forEach(product => {
        const template = document.getElementById('products-template').content.cloneNode(true);
        template.getElementById('product-header').innerText = product.productName;
        const cardFooter = template.querySelector(".card-footer");
        const unitPrice = cardFooter.querySelector("#product-price")

        unitPrice.textContent = `$${product.unitPrice.toFixed(2)}`;
        unitPrice.style.textDecoration = "none";
   
        cardFooter.appendChild(unitPrice)
        parent.appendChild(template)
    });
}

function showForm()
{
    addFormScreen.classList.remove("d-none");
}

function cancelAdd(event)
{
    event.preventDefault();
    addFormScreen.classList.add("d-none");
}

function addCategory(event)
{
    event.preventDefault();
    event.stopPropagation()

    addForm.classList.add("was-validated");

    if(addForm.checkValidity()){

        addFormScreen.classList.add("d-none");
        addForm.classList.remove("was-validated");
    }
}