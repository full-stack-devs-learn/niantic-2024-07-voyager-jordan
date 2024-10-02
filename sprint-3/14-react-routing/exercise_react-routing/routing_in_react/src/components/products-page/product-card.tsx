import { Product } from "../../models/products"

interface cardData
{
    data: Product
}

export default function Product_Card({data}: cardData)
{
    return (
        <>
            <article>
                <header>
                    <p id="product-card-name">{data.productName}</p>
                </header>
                <img className="list-item-img">
                </img>
                <section className="card-section">
                    <p>$ {data.unitPrice.toFixed(2)}</p>
                </section>
            </article>
        </>
    )
}