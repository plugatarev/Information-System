package app.services;

import app.model.Master;
import app.services.pagination.Page;
import app.services.pagination.PageInfo;

public interface MasterService extends Service<Master>{
    ServiceResponse<Page<Master>> getDepartmentRegionMasters(Long id, PageInfo pageInfo);

    ServiceResponse<Page<Master>> getDepartmentMasters(Long id, PageInfo pageInfo);
}
