import "./Employees_Page.css"

export default function Employee_Details({employee})
{
    const fullName = `${employee.firstName} ${employee.lastName}`
    const imgSrc = `images/employees/${employee.employeeId}.webp`;

    return (
        <>
            <div className="profile-container">
                <div className="upper-section">
                    <div className="img-section">
                        <img src={imgSrc}></img>
                    </div>
                    <div className="details-section">
                        <h4>Full Name: {fullName}</h4>
                        <h4>Title: {employee.title}</h4>
                        <h4>Salary: ${employee.salary}</h4>
                    </div>
                </div>
                <div className="lower-section">
                    <h4>Notes:</h4>
                    <h6>{employee.notes}</h6>                    
                </div>
            </div>
        </>
    );
}
