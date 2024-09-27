import { useEffect, useState } from 'react';
import { useLocation } from 'react-router-dom';
import ProductsList from '../products-list/ProductsList'
import categoryService from '../../../services/category-service';
import '../styles/products-page.css'

export default function ProductsPage(props)
{   
    const location = useLocation();
    const queryParams = new URLSearchParams(location.search)
    const categoryId = queryParams.get('catId');

    const [categoryName, setCategoryName] = useState(null)

    useEffect(() => {
        const getCategoryName = async () => {
            const response = await categoryService.getCategoryById(categoryId)
            setCategoryName(response.categoryName)
        }
        if(categoryId)
        {
            getCategoryName();
        }
    },[categoryId])
    

    return (
        <>
        <header className="container mt-4">
            <h1>Products</h1>
        </header>
        <main className="container mt-4 products-container" id="products-container">
            <ProductsList categoryId={categoryId} categoryName={categoryName}></ProductsList>
        </main>
        </>
    )
}