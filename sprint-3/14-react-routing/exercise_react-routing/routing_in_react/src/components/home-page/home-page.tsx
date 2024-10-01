import "./styles/home-page.css"
import { Link } from "react-router-dom"

export default function Home_Page()
{
    return (
        <>
            <p>Welcome</p>
            <main id="home-main">
                <Link to="/categories">
                    <div>
                        <span className="material-symbols-outlined">subject</span>
                        <p>Categories</p> 
                    </div>
                </Link>
                <Link to="/products">
                    <div>
                        <span className="material-symbols-outlined">list</span>
                        <p>Products</p>
                    </div>
                </Link>
            </main>
        </>
    )
}