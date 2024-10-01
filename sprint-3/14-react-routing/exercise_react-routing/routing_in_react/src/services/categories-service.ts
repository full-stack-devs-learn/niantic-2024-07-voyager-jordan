import axios from 'axios'

class Categories_Service
{
    baseUrl = `${import.meta.env.VITE_API_BASE_URL}/categories`

    //todo: need queries for min, max, category id, name

}

const categoriesService = new Categories_Service();
export {categoriesService}