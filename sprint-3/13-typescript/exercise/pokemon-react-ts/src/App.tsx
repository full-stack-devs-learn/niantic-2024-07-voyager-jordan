import { useState } from 'react'
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom'

import './App.css'
import Layout from './components/layout/Layout'
import Pokemon_Page from './components/pokemon-page/pokemon-page'
import Types_Page from './components/types-page/types-page'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      <Router>
        <Layout>
          <Routes>
            <Route path='/' element={ <Types_Page /> }></Route>
            <Route path='/pokemon' element={ <Pokemon_Page /> }>  </Route>
          </Routes>
        </Layout>
      </Router>
    </>
  )
}

export default App
