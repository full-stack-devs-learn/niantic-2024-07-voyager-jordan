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
                    <h4>{data.productName}</h4>
                </header>
                <img className="list-item-img">
                </img>
                <section>
                    <p>$ {data.unitPrice.toFixed(2)}</p>
                    <p>{data.description}</p>
                </section>
            </article>
        </>
    )
}