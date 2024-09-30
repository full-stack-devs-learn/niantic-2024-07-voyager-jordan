import "bootswatch/dist/flatly/bootstrap.min.css"
import "./App.css"
import { useState } from 'react'
import { BrowserRouter as Router, Routes, Route, Navigate } from 'react-router-dom'
import Layout from './components/shared/layout'
//HOME
import Home_Page from './components/home-page/home-page'
//CATEGORIES
import Categories_Page from './components/categories-page/categories-page'
import Category_Add from "./components/categories-page/category-add"
import Category_Details from "./components/categories-page/category-details"
import Category_Edit from "./components/categories-page/category-edit"
//PRODUCTS
import Products_Page from './components/products-page/products-page'
import Product_Add from "./components/products-page/product-add"
import Product_Details from "./components/products-page/product-details"
import Product_Edit from "./components/products-page/product-edit"
import Not_Found from "./components/404-page/not-found"

function App() {

  return (
    <>
      <Router>
        <Layout>
        <Routes>
          <Route path="/" element={ <Home_Page />} />
          <Route path="/categories" element={<Categories_Page />}>
            <Route path="add" element={<Category_Add />}/>
            <Route path=":id/edit" element={<Category_Edit/>}/> 
            <Route path=":id" element={<Category_Details/>}/>
          </Route>
          <Route path="/products" element={<Products_Page />}>
            <Route path="add" element={<Product_Add />}/>
            <Route path=":id/edit" element={<Product_Edit/>}/> 
            <Route path=":id" element={<Product_Details/>}/>
          </Route>
          <Route path="/404" element={<Not_Found/>}/>
          <Route path="*" element={<Navigate to="/404" />}/>
        </Routes>
        </Layout>
      </Router>
    </>
  )
}

export default App
