import { useState } from 'react'
import CategoryAdd from '../category-add/CategoryAdd'
import CategoryCardContainer from '../category-card-container/CategoryCardContainer'
import './CategoriesPage.css'

export default function CategoriesPage(props)
{
    const [action, setAction] = useState("list");

    return (
        <div className='container'>
            <header className="mt-4">
                <h1>Categories</h1>
            </header>
            <button className="btn btn-danger" onClick={()=> setAction("add")}>Add</button>

                {action === "list" && <CategoryCardContainer {...props}></CategoryCardContainer>}
                {action === "add" && <CategoryAdd onCancel={()=>setAction("list")}
                                            onCategoryAdded={()=>setAction("list")}
                                    ></CategoryAdd>}
            
        </div>
    )
}