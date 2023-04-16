import TableTemplate from "./TableTemplate";


function WorkerBrigade() {
    const fields = ["workerId", "brigadeId"];
    const type = {"workerId": "number", "brigadeId" : "number"};
    return <TableTemplate url = "workerBrigade" fields = {fields} type = {type}/>;
}

export default WorkerBrigade;