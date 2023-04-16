import TableTemplate from "./TableTemplate";


function LaboratoryEmployee() {
    const fields = ["employeeId", "laboratory"];
    const type = {"employeeId": "number", "laboratory": "number"};

    return <TableTemplate url = "laboratoryEmployee" fields = {fields} type = {type}/>;
}

export default LaboratoryEmployee;