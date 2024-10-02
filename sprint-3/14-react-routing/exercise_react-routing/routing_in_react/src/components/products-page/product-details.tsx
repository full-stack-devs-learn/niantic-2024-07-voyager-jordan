import { useState, useEffect } from "react";
import { useParams, useNavigate } from "react-router-dom";
import { Product } from "../../models/products"
import { useDispatch, useSelector } from "react-redux"
import { AppDispatch, RootState } from "../../store/store"
import { getProducts } from "../../store/features/products-slice"

export default function Product_Details()
{
    const { id } = useParams();
    const navigate = useNavigate();
    const dispatch = useDispatch<AppDispatch>()
    const { products, loading , error } = useSelector((state: RootState) => state.products )
    const [product, setProduct] = useState<Product>()

    useEffect(() => {

        if(isNaN(Number(id))){
            navigate("/404")
        }
        
    },[]);


    useEffect(() => {

        if(products.length == 0)
        {
            dispatch(getProducts())
        }
        let filteredData = products.find(product => product.productId == Number(id))
        setProduct(filteredData)

    }, [products])

    if (loading) return <p>Loading products...</p>;
    if (error) return <p>Error: {error}</p>;

    return (
        <>
            <h3>Product Details</h3>
            <article className="product-details-container">
                <section>
                    <img></img>
                </section>
                <section>
                    <p>Name: {product?.productName}</p>
                    <p>Price: ${product?.unitPrice.toFixed(2)}</p>
                    <p>Description: {product?.description}</p>
                </section>
            </article>
        </>
    )
}