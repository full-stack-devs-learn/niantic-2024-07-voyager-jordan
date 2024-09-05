
function renderTable(products, parent) {

    console.log(products)
    // Create table head
    let tableHtml = `
        <thead>
            <tr>
                <th>Id</th>
                <th>Product</th>
                <th>Price</th>
            </tr>
        </thead>
        <tbody>
    `;

    // Create table rows using products data
    products.forEach(product => {
        tableHtml += `
            <tr>
                <td>${product.productId}</td>
                <td>${product.productName}</td>
                <td>${product.unitPrice}</td>
            </tr>
        `;
    });

    tableHtml += '</tbody>';

    // Inject HTML into the table container
    parent.innerHTML = tableHtml;
}

function fetchData(e){
    const tableContainer = document.getElementById('table-container');

    const selectedCategoryId = e.target.value;
    //Fetches data from API
    if (selectedCategoryId) {
        fetch(`/api/products/${selectedCategoryId}`)
            .then(response => response.json())
            .then(data => {
                renderTable(data, tableContainer);
            })
            .catch(error => console.error('Error fetching products:', error));
    } else {
        tableContainer.innerHTML = ''; // Clear table if no category is selected
    }
}

//On Page Load
document.addEventListener('DOMContentLoaded', function () {
    
    const categorySelect = document.getElementById('category');
    categorySelect.addEventListener('change', fetchData)
});