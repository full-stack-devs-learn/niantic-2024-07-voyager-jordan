import { useEffect } from "react";
import { useParams, useNavigate } from "react-router-dom";

useParams
export default function Product_Details()
{
    const { id } = useParams();
    const navigate = useNavigate();

    useEffect(() => {

        if(isNaN(Number(id))){
            navigate("/404")
        }
        
    },[]);

    return (
        <h3>Product Details</h3>
    )
}