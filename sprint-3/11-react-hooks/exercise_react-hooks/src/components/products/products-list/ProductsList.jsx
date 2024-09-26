import {useState, useEffect } from 'react'
import productService from '../../../services/product-service';
import { Trash } from 'react-bootstrap-icons'
import './ProductsList.css'

export default function ProductsList({categoryId, categoryName})
{
    const [products, setProducts] = useState([])

    useEffect(() => {
        if(categoryId === null){
            productService.getAllProducts().then(data => {
                console.log(data);
                setProducts(data)
            })
        } 
        else
        {
            productService.getProductsByCategoryId(categoryId).then(data => {
                console.log(data);
                setProducts(data)
            })
        }
    }, [])

    return (
        <>
            {(categoryId == null) 
            ? <h3>Viewing All Products</h3>
            : <h3> Products for category: {categoryName} </h3>
            }
            <div className="container mt-4 products-list" id="products-list">
            {
                products.map((product) => (
                    <div className="card product-card" key={product.id}>
                        <div id="product-header" className="card-header">{product.name}</div>
                            <div id="product-body" className="card-body">
                            <img id="product-image"/>
                        </div>
                        <div className="card-footer">
                            <Trash id="product-trash-btn"></Trash>
                        </div>
                    </div>
                ))
            }
            </div>
        </>
    )
}