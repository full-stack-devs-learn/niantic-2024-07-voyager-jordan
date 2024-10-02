import axios, { AxiosResponse } from 'axios'
import { Product } from '../models/products';

class Products_Service
{
    baseUrl = `${import.meta.env.VITE_API_BASE_URL}/products`

    //todo: need queries for min, max, category id, name

    //GET
    async getAllProducts(): Promise<Product[]>
    {
        const response = await axios.get(this.baseUrl)

        const results: Product[] = response.data.map((res: any) => ({
            productId: res.id
            , productName: res.name
            , unitPrice: res.unitPrice
            , description: res.quantityPerUnit
            , categoryId: res.categoryId

        }));

        return results;
    }

    async getProductsByCategoryId(categoryId:number)
    {
        const response = await axios.get(this.baseUrl + `/${categoryId}`)
        return response.data;
    }

    // async getProductsByPriceRange(min:number, max:number)
    // {
    //     const response = await axios.get(this.baseUrl + `?minPrice=${min}&maxPrice=${max}`)
    //     return response.data;
    // }

    //POST
    async addProducts(product: Product): Promise<Product>
    {
        const response = await axios.post<Product>(this.baseUrl, product)
        return response.data
    }

    //UPDATE
    async updateProducts(product: Product): Promise<AxiosResponse>
    {
        const url = `${this.baseUrl}/${product.productId}`
        const response = await axios.put<void>(url, product)
        return response
    }

    //DELETE
    async deleteProducts(productId: number): Promise<AxiosResponse>
    {
        const url: string = `${this.baseUrl}/${productId}`
        const response: AxiosResponse  = await axios.delete<void>(url)
        return response
    }

}

const productsService = new Products_Service();
export {productsService}