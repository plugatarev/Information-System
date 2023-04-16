import TableTemplate from "./TableTemplate";


function DepartmentRegion() {
    const fields = ["id", "name", "department", "collectingBrigade", "chief"];
    const type = {"id" : "number", "name" : "text", "department" : "number", "collectingBrigade" : "number", "chief" : "number"};
    const relatedTables = ["Department", "Brigade", "DepartmentRegionChief"];
    const fieldsUrl = {"departmentId": "department", "brigadeId" : "brigade", "departmentRegionChiefId" : "departmentRegionChief"};
    return <TableTemplate url = "departmentRegion" fields = {fields} type = {type} relatedTables = {relatedTables} fieldsUrl = {fieldsUrl} />;
}

export default DepartmentRegion;