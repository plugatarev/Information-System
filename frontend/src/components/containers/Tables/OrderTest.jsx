import TableTemplate from "./TableTemplate";


function OrderTest() {
    const fields = ["id", "laboratoryOrder", "test", "testDate"];
    const type = {"id" : "number", "laboratoryOrder" : "number", "test" : "number", "testDate" : "date"};
    return <TableTemplate url = "orderTest" fields = {fields} type = {type}/>;
}

export default OrderTest;