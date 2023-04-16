import TableTemplate from "./TableTemplate";


function Brigade() {
    const fields = ["id", "name", "brigadier"];
    const type = {"id": "number", "name": "text", "brigadier" : "number"};
    return <TableTemplate url = "brigade" fields = {fields} type = {type} />;
}

export default Brigade;