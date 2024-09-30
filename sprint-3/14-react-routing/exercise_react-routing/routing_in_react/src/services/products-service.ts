import axios from 'axios'

class Products_Service
{
    baseUrl = "http://localhost:8080/products"

    //todo: need queries for min, max, category id, name

    async getAllProducts()
    {
        const response = await axios.get(this.baseUrl)
        return response.data;
    }

    async getProductsByCategoryId(categoryId:number)
    {
        const response = await axios.get(this.baseUrl + `/${categoryId}`)
        return response.data;
    }

    async getProductsByPriceRange(min:number, max:number)
    {
        const response = await axios.get(this.baseUrl + `?minPrice=${min}&maxPrice=${max}`)
        return response.data;
    }   

}

const productsService = new Products_Service();
export {productsService}