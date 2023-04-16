import TableTemplate from "./TableTemplate";


function Equipment() {
    const fields = ["id", "serialNumber"];
    const type = {"id": "number", "serialNumber": "text"};

    return <TableTemplate url = "serialNumber" fields = {fields} type = {type}/>;
}

export default Equipment;