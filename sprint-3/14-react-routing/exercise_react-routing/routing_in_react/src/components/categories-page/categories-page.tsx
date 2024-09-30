import { Outlet} from "react-router-dom";

export default function Categories_Page()
{

    return (
        <>
        <h1>Categories Page</h1>
        <main className="container">
            <Outlet />
        </main>
        </>
    )
}