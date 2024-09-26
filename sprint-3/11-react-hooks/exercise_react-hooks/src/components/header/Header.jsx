import './Header.css'

export default function Header(props)
{
    const { setPageName, setCategoryId, setCategoryName } = props

    function pageHandler(name){
        setCategoryId(null)
        setPageName(name)
    }

    return(
        <div id="navigation">
            <img src="images/logo.png" alt="Northwind Logo" />
            <h1>Northwind Traders</h1>
            <div className="link" onClick={()=>pageHandler("categories")}>Categories</div>
            <div className="link" onClick={()=>pageHandler("products")}>Products</div>
        </div>
    )
}
