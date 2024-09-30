import "bootswatch/dist/flatly/bootstrap.min.css"
import "./App.css"
import { useState } from 'react'
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom'
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

function App() {

  return (
    <>
      <Router>
        <Layout>
        <Routes>
          <Route path="/" element={ <Home_Page />} />
          <Route path="/categories" element={<Categories_Page />}>
            <Route path="add" element={<Category_Add />}/>
            <Route path=":id" element={<Category_Details/>}/>
            <Route path=":id/edit" element={<Category_Edit/>}/> 
          </Route>
          <Route path="/products" element={<Products_Page />} />
        </Routes>
        </Layout>
      </Router>
    </>
  )
}

export default App
