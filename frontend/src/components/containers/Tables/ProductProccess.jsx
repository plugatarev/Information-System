import TableTemplate from "./TableTemplate";


function ProductProcess() {
    const fields = ["id", "product", "descriptionWork", "departmentRegion", "status", "releaseDate"];
    const type = {"id" : "number", "product" : "text", "descriptionWork" : "text", "departmentRegion" : "number", "status" : "text", "releaseDate" : "date"};
    return <TableTemplate url = "productProcess" fields = {fields} type = {type}/>;
}

export default ProductProcess;