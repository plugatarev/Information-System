import TableTemplate from "./TableTemplate";


function Test() {
    const fields = ["id", "equipment", "laboratoryEmployee", "description"];
    const type = {"id" : "number", "equipment" : "number", "laboratoryEmployee" : "number", "description" : "text"};
    return <TableTemplate url = "test" fields = {fields} type = {type}/>;
}

export default Test;