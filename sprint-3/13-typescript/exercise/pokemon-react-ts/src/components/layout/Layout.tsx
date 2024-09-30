import React, { ReactNode } from "react"
import Header from "./Header"
import Footer from "./Footer"
import './styles/Layout.css'

export default function Layout({children}: {children: ReactNode})
{
    return(
        <> 
            <Header />
            {children}
            <Footer />
        </>
    )
}