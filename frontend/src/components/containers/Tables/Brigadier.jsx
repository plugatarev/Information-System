import TableTemplate from "./TableTemplate";


function Brigadier() {
    const fields = ["employeeId"];
    const type = {"employeeId": "number"};
    return <TableTemplate url = "brigadier" fields = {fields} type = {type}/>;
}

export default Brigadier;