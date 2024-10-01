import { useEffect } from "react";
import { useParams, useNavigate } from "react-router-dom";

export default function Category_Edit()
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
            <h3>Editing Category</h3>
        </>
    )
}