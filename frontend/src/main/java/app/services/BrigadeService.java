package app.services;

import app.model.Brigade;
import app.services.pagination.Page;
import app.services.pagination.PageInfo;

public interface BrigadeService extends Service<Brigade> {
    ServiceResponse<Page<Brigade>> getBrigadesByDepartmentRegions(Long id, PageInfo pageInfo);
}
