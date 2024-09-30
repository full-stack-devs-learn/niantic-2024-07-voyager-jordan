import { Outlet, useSearchParams } from "react-router-dom";
import axios from 'axios'
import { useState, useEffect } from "react";
import { productsService } from "../../services/products-service";

export default function Products_Page()
{
    const [searchParams, setSearchParams] = useSearchParams()
    const [productData, setProductData] = useState<[]>([])

    const min = searchParams.get("minPrice") || Math.min()
    const max = searchParams.get("maxPrice") || Math.max()
    const productName = searchParams.get("name") || ""
    const catId = searchParams.get("catId") || ""

    useEffect(() =>{ 

        const fetchProducts = async () => {
            const data = await productsService.getAllProducts()
        }

        fetchProducts()
    }, [searchParams])
    return (
        <>
            <main>
                <h1>Products Page</h1>
                <Outlet />
            </main>
        </>
    )
}