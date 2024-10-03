import axios, { AxiosResponse } from 'axios'
import { Category } from '../models/category'

class Categories_Service
{
    baseUrl = `${import.meta.env.VITE_API_BASE_URL}/categories`

    //todo: need queries for min, max, category id, name
    async getAllCategories()
    {
        const response = await axios.get(this.baseUrl)

        const result: Category[] = response.data.map((res: any) => ({
            categoryId: res.categoryId
            , categoryName: res.categoryName
            , description: res.description
        }))
        console.log(result)
        return result
    }
    //POST
    async addCategory(category: Category): Promise<Category>
    {
        const response = await axios.post<Category>(this.baseUrl, category)
        return response.data
    }

    //UPDATE
    async updateCategory(category: Category): Promise<AxiosResponse>
    {
        const url = `${this.baseUrl}/${category.categoryId}`
        const response = await axios.put<void>(url, category)
        return response
    }

    //DELETE
    async deleteCategory(categoryId: number): Promise<AxiosResponse>
    {
        const url: string = `${this.baseUrl}/${categoryId}`
        const response: AxiosResponse  = await axios.delete<void>(url)
        return response
    }

}

const categoriesService = new Categories_Service();
export { categoriesService }