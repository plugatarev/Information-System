import TableTemplate from "./TableTemplate";


function Employee() {
    const fields = ["id", "firstName", "secondName", "passport", "employeeType", "employmentDate", "dismissalDate"];
    const type = {"id": "number", "secondName" : "text", "passport" : "text", "employeeType" : "text", "employmentDate" : "date", "dismissalDate" : "date"};
    return <TableTemplate url = "employee" fields = {fields} type = {type}/>;
}

export default Employee;