package app.services.filters;

import app.model.Department;
import app.model.Laboratory;
import app.model.type.ProductStatusEnum;
import app.model.type.ProductTypeEnum;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class ProductFilter implements Filter {
    ProductTypeEnum productTypeEnum;
    ProductStatusEnum productStatusEnum;
    Date minAssembledDate;
    Date maxAssembledDate;

    Laboratory laboratory;
    Date minLaboratoryDate;
    Date maxLaboratoryDate;

    Department department;
}
