import { useState } from "react"
import Header from "./components/header/Header"
import CategoriesPage from "./components/categories/categories-page/CategoriesPage"
import ProductsPage from "./components/products/products-page/ProductsPage"

function App() {
  const [pageName, setPageName] = useState("categories")
  const [categoryId, setCategoryId] = useState(null)
  const [categoryName, setCategoryName] = useState("None Selected")

  const props = {
      pageName,
      setPageName,
      categoryId,
      setCategoryId,
      categoryName,
      setCategoryName
  }

  return (
    <>
      <Header {...props}></Header>
      { (pageName=="categories") && <CategoriesPage {...props}></CategoriesPage> }
      { (pageName=="products") && <ProductsPage {...props}></ProductsPage> }
    </>
  )
}

export default App
