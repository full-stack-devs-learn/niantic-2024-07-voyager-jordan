import { useState, useEffect } from "react"
import { Product } from "../../models/products"
import { useDispatch, useSelector } from "react-redux"
import { AppDispatch, RootState } from "../../store/store"
import { getProducts } from "../../store/features/products-slice"
import { Link } from "react-router-dom"
import Product_Card from "./product-card"

export default function Products_List({})
{
    const dispatch = useDispatch<AppDispatch>()
    const { products, loading , error } = useSelector((state: RootState) => state.products )

    useEffect(() => {
        if(products.length == 0)
        {
            dispatch(getProducts())
        }
    }, [dispatch])

    if (loading) return <p>Loading products...</p>;
    if (error) return <p>Error: {error}</p>;

    return (
        <ul className="list-container">
            {
                products.map((product: Product, index: number) => (

                    <Link to={`/products/${product.productId}`} key={index}>
                        <li className="list-item">
                                <Product_Card data={product}/>
                        </li>
                    </Link>
                ))
            }
        </ul>
    )
}