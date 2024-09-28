import { useState, useEffect } from "react"
import { Link } from 'react-router-dom'
import typesService from '../../services/types-service'
import { Type } from '../../models/type'
import 'bootstrap/dist/css/bootstrap.min.css';
import './styles/types.css'

export default function Types_List() {
    const [types, setTypes] = useState<Type[]>([])

    useEffect(() => {

        const getTypes = async () => {
            const data = await typesService.getAllTypes();
            setTypes(data.sort((a, b) => a.name.localeCompare(b.name)))
        }

        getTypes();
    }, [])

    return (
        <>
            <div className="row p-5">
                {
                    types.map((type: Type, index: number) => (
                        <div className="col-3 mb-4" key={index}>
                            <Link to={`/pokemon?type=${type.name}`}>
                                <div className="card">
                                    <div className="card-body p-3">
                                        <p className="card-text">{type.name}</p>
                                    </div>
                                </div>
                            </Link>
                        </div>
                    ))
                }
            </div>
        </>
    )
}