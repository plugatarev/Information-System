import TableTemplate from "./TableTemplate";


function Laboratory() {
    const fields = ["id", "name"];
    const type = {"id": "number", "name": "text"};

    return <TableTemplate url = "laboratory" fields = {fields} type = {type}/>;
}

export default Laboratory;