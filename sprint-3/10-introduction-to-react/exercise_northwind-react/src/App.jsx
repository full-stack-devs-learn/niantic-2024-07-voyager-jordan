//Hooks
import { useState } from "react";

//Components
import Navigation from "./components/Header/Navigation";

//Pages
import Employees_Page from "./components/employees_page/employees_page";


function App() {

  const [pageTitle, setPageTitle] = useState("Employees");

  return (
    <>
      <Navigation></Navigation>
      <Employees_Page pageTitle={pageTitle}></Employees_Page>
    </>
  )
}

export default App
