import { useState } from "react"

import Header from "../Header/header"
import Employee_Details from "./employee_details"
import Employees_List from "./employees_list"

export default function Employees_Page({pageTitle})
{
    const [currentEmployee, setCurrentEmployee] = useState(null)
    const [onProfile, setOnProfile] = useState(false)
    const [employeeObj, setEmployeeObj] = useState({})

    const employeeSelect = (person) => {
        console.log(person)
        setOnProfile(true)
        setCurrentEmployee(`${person.firstName} ${person.LastName}`)
        setEmployeeObj(person)
    }

    return (
        <>
            { currentEmployee == null 
                    ?   <Header pageTitle="All Employees"></Header>
                    :   <Header pageTitle="Profile"></Header>
            }

            <main className="container mt-4 employees-container" id="employees-container">
                { !onProfile 
                    ? <Employees_List employeeSelect={employeeSelect}></Employees_List>
                    : <Employee_Details employee={employeeObj}></Employee_Details>
                }
                
            </main>     
        </>
        
    )
}