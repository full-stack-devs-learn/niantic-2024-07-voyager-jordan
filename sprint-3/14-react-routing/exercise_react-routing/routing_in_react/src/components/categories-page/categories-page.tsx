import { useState, useEffect } from "react";
import { Outlet } from "react-router-dom";
import { useDispatch, useSelector } from "react-redux"
import { AppDispatch, RootState } from "../../store/store"
import { getCategory } from "../../store/features/categories-slice";

export default function Categories_Page()
{
    const dispatch = useDispatch<AppDispatch>()
    const { categories, loading, error} = useSelector((state: RootState) => state.categories )

    useEffect(() => {
        if(categories.length == 0)
        {
            dispatch(getCategory())
        }
    }, [dispatch])

    if (loading) return <p>Loading products...</p>;
    if (error) return <p>Error: {error}</p>;
    return (
        <>
        <main className="container">
            <h1>Categories Page</h1>
            <Outlet />
        </main>
        </>
    )
}