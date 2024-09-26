import { useState, useEffect } from 'react'
import ProductsList from '../products-list/ProductsList'
import './ProductsPage.css'

export default function ProductsPage(props)
{   
    const { categoryId, categoryName } = props;

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