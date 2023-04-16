import TableTemplate from "./TableTemplate";


function DepartmentChief() {
    const fields = ["employeeId"];
    const type = {"employeeId": "number"};
    return <TableTemplate url = "departmentChief" fields = {fields} type = {type}/>;
}

export default DepartmentChief;