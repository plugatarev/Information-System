import TableTemplate from "./TableTemplate";


function LaboratoryOrder() {
    const fields = ["id", "product", "laboratory"];
    const type = {"id" : "number", "product" : "number", "laboratory" : "number"};
    return <TableTemplate url = "laboratoryOrder" fields = {fields} type = {type}/>;
}

export default LaboratoryOrder;