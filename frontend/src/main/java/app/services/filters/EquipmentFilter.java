package app.services.filters;

import app.model.Laboratory;
import app.model.Product;
import app.model.type.ProductTypeEnum;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class EquipmentFilter implements Filter {
    Product product;
    ProductTypeEnum productType;
    Laboratory laboratory;
    Date minDateTest;
    Date maxDateTest;
}
