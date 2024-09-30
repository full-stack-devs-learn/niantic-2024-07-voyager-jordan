import "./styles/layout.css"
import Footer from "./footer";
import Header from "./header";

interface ChildrenProps {
    children: React.ReactNode
}

export default function Layout({children}: ChildrenProps){
    return (
        <>
            <Header/>
            {children}
            <Footer/>
        </>
    )
}