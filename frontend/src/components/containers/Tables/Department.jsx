import TableTemplate from "./TableTemplate";


function Department() {
    const fields = ["id", "name"];
    const type = {"id": "number", "name": "text"};
    return <TableTemplate url = "department" fields = {fields} type = {type} />;
}

export default Department;