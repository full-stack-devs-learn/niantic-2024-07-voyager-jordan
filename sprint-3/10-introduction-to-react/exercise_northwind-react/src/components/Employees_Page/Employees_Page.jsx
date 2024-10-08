import { useState } from "react"

import Header from "../Header/header"
import Employee_Details from "./employee_details"
import Employees_List from "./employees_list"

export default function Employees_Page({pageTitle})
{
    const [isViewingProfile, setIsViewingProfile] = useState(false)
    const [employeeObj, setEmployeeObj] = useState({})

    const employeeSelect = (person) => {
        setIsViewingProfile(true)
        setEmployeeObj(person)
    }

    const returnClick = () => {
        setIsViewingProfile(false)
    }

    return (
        <>
            { !isViewingProfile
                ? <Header pageTitle="All Employees"></Header>
                : <Header pageTitle={`Profile - ${employeeObj.firstName} ${employeeObj.lastName}`}></Header>
            }

            <main className="container mt-4 employees-container" id="employees-container">
                { !isViewingProfile
                    ? <Employees_List employeeSelect={employeeSelect}></Employees_List>
                    : <Employee_Details employee={employeeObj} returnClick={returnClick}></Employee_Details>
                }
            </main>     
        </>
        
    )
}