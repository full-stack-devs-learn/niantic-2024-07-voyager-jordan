import { useState, useEffect } from 'react';
import { Link } from "react-router-dom"
import CategoryCard from '../category-card/CategoryCard'
import './CategoryCardContainer.css'
import categoryService from '../../../services/category-service';
import ProductsList from '../../products/products-list/ProductsList';

export default function CategoryCardContainer(props)
{
    const {categoryId, setCategoryId, categoryName, setCategoryName}  = props
    const [categories, setCategories] = useState([]);

    useEffect(() => {

        categoryService.getAllCategories().then(data => {
            setCategories(data);   
        })

    }, [])
   

    const categorySelected = (name) =>
    {
        const categoryId = categories.filter(cat => cat.categoryName === name)[0].categoryId;
        setCategoryId(categoryId);
        setCategoryName(name)
    }

    const categoryDeleted = (categoryId) => {
        const newList = categories.filter(category => category.categoryId !== categoryId);
        setCategories(newList)
    }

    return(
        <>
        <main className="container mt-4 categories-container" id="categories-container">
        {
            categories.map((category) => (
                
                <Link to={`/products?catId=${category.categoryId}`} key={category.categoryId}> 
                    <CategoryCard key={category.categoryId} 
                        category={category.categoryName} 
                        id={category.categoryId}
                        onCategorySelected={categorySelected}
                        onCategoryDeleted={categoryDeleted}
                        ></CategoryCard>
                </Link>
            
            ))
        }
        </main>
        </>
    )
}