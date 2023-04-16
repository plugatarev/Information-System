import TableTemplate from "./TableTemplate";


function Product() {
    const fields = ["id", "categoryType", "manufacturedDepartment", "customer"];
    const type = {"workerId": "number", "brigadeId" : "number", "manufacturedDepartment" : "number", "customer" : "text"};
    return <TableTemplate url = "product" fields = {fields} type = {type}/>;
}

export default Product;