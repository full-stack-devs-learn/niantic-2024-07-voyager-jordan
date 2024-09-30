import { Outlet} from "react-router-dom";

export default function Categories_Page()
{

    return (
        <>
        <main className="container">
            <h1>Categories Page</h1>
            <Outlet />
        </main>
        </>
    )
}