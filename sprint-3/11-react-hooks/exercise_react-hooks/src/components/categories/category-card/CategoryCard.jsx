import categoryService from '../../../services/category-service'
import './CategoryCard.css'
import { Trash } from 'react-bootstrap-icons'

export default function CategoryCard({id, category, onCategorySelected, onCategoryDeleted})
{
    const imageUrl = `images/categories/${id}.webp`
    
    const categoryClicked = () => {
        onCategorySelected(category)       
    }

    async function deleteCategory(event)
    {
        event.stopPropagation();
        await categoryService.delete(id);
        onCategoryDeleted(id);
    }

    return(
        <div className="card category-card" onClick={categoryClicked}>
            <div id="category-header" className="card-header">{category}</div>
            <div id="category-body" className="card-body">
                <img id="category-image" src={imageUrl} />
            </div>
            <div className="card-footer">
                <Trash onClick={deleteCategory} color="red" />
            </div>
        </div>
    )
}