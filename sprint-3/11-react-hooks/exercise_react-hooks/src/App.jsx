import { useState } from "react"
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom'
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
    <Router>
      <Header {...props}></Header>
      <Routes>
        <Route path="/" element={ <CategoriesPage {...props}></CategoriesPage> }exact> </Route>
        <Route path="/products" element={ <ProductsPage {...props}></ProductsPage>}></Route>
      </Routes>
    </Router>
    </>
  )
}

export default App
