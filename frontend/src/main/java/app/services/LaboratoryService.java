package app.services;

import app.model.Laboratory;
import app.services.pagination.Page;
import app.services.pagination.PageInfo;

public interface LaboratoryService extends Service<Laboratory> {
    ServiceResponse<Page<Laboratory>> getLaboratoriesByProductId(Long id, PageInfo pageInfo);
}
