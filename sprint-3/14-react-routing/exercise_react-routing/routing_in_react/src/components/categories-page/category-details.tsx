import { useEffect } from "react";
import { useNavigate, useParams } from "react-router-dom"

export default function Category_Details()
{
    const { id } = useParams();
    const navigate = useNavigate();

    useEffect(() => {

        if(isNaN(Number(id))){
            navigate("/404")
        }
        
    },[]);

    return (
        <>
            <h3>Category Details</h3>
        </>
    )
}