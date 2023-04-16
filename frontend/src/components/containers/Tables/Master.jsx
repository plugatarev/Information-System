import TableTemplate from "./TableTemplate";


function Master() {
    const fields = ["employeeId"];
    const type = {"employeeId": "number"};
    return <TableTemplate url = "master" fields = {fields} type = {type}/>;
}

export default Master;