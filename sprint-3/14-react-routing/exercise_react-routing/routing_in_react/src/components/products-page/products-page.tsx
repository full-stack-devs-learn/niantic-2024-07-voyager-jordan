import "./styles/products-page.css"
import { Outlet, useSearchParams } from "react-router-dom";
import { useState, useEffect } from "react";

export default function Products_Page()
{

    return (
        <>
            <main className="products-main">
                <h1>Products Page</h1>
                <Outlet />
            </main>
        </>
    )
}