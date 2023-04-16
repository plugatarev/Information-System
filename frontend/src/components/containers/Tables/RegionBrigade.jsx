import TableTemplate from "./TableTemplate";


function RegionBrigade() {
    const fields = ["id", "region", "brigade"];
    const type = {"id" : "number", "region" : "number", "brigade" : "number"};
    return <TableTemplate url = "regionBrigade" fields = {fields} type = {type}/>;
}

export default RegionBrigade;