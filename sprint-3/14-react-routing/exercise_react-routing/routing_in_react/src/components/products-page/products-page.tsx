import { Outlet } from "react-router-dom";

export default function Products_Page()
{
    return (
        <>
            <main>
                <h1>Products Page</h1>
                <Outlet />
            </main>
        </>
    )
}