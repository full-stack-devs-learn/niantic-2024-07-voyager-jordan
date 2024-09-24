import { employees } from "../../data"

export default function Employees_List({employeeSelect})
{
    
  return (
    <>
        {employees.map((person) => {

            const imgSrc = `images/employees/${person.employeeId}.webp`;
            const fullName = `${person.firstName} ${person.lastName}`

            const clickHandler = () => {
                employeeSelect(person)
            }

            return (
                <div className="employee-row" key={person.employeeId} onClick={clickHandler}>
                    <img id="employee-image" src={imgSrc}></img>
                    <div className="employee-name">
                        <h1>{fullName}</h1>
                        <h6>{person.title}</h6>
                    </div>
                </div>
            )
                
        })}
    </>
  );
}
