import './Header.css'
import { Link, NavLink } from "react-router-dom"

export default function Header(props)
{
    const {setCategoryId} = props

    function pageHandler(){
        setCategoryId(null)
    }

    return(
        <div id="navigation">
            <img src="images/logo.png" alt="Northwind Logo" />
            <h1>Northwind Traders</h1>
            <Link to="/" className="link" onClick={pageHandler}>Categories</Link>
            <Link to="/products" className="link" onClick={pageHandler}>Products</Link>
        </div>
    )
}
