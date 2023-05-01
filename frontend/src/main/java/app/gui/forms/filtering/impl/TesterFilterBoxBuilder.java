package app.gui.forms.filtering.impl;

import app.gui.controllers.FilterBoxController;
import app.gui.controllers.interfaces.ChoiceItemSupplier;
import app.gui.custom.ChoiceItem;
import app.model.Laboratory;
import app.model.Product;
import app.model.Tester;
import app.model.type.ProductTypeEnum;
import app.services.filters.Filter;
import app.services.filters.TesterFilter;
import app.utils.ServiceFactory;

public class TesterFilterBoxBuilder extends AbstractFilterBoxBuilder<Tester> {
    @Override
    protected void fillFilterBox(FilterBoxController<Tester> controller, Filter filter) {
        TesterFilter equipmentFilter = (TesterFilter) filter;
        ChoiceItemSupplier<Product> productIdSupplier = makeChoiceItemSupplierFromEntities(
                ServiceFactory.getProductService(),
                c -> new ChoiceItem<>(c.clone(), c.getId() + " " + c.getCategoryType().getName() + " " + c.getCustomer()),
                "Не удалось загрузить список изделий"
        );

        ChoiceItemSupplier<Laboratory> laboratoryIdSupplier = makeChoiceItemSupplierFromEntities(
                ServiceFactory.getLaboratoryService(),
                c -> new ChoiceItem<>(c.clone(), c.getLaboratoryName()),
                "Не удалось загрузить список лабораторий"
        );

        controller.setNumberOfRows(3);
        controller.setNumberOfCols(10);

        int row = 0;
        controller.addLabel("Конкретное изделие:", 0, row, 2);
        controller.addChoiceBox(equipmentFilter::setProduct, productIdSupplier, 2, row, 5);

        row++;
        controller.addLabel("Тип изделия:", 0, row, 2);
        controller.addChoiceBox(equipmentFilter::setProductType, ProductTypeEnum::getChoiceItems, 2, row, 5);

        row++;
        controller.addLabel("Лаборатория:", 0, row, 2);
        controller.addChoiceBox(equipmentFilter::setLaboratory, laboratoryIdSupplier, 2, row, 5);

        row++;
        controller.addLabel("Дата тестирования в лаборатории:", 0, row, 2);
        controller.addLabel("от", 2, row, 1);
        controller.addDateField(equipmentFilter::setMinDateTest, 3, row, 3);
        controller.addLabel("до", 6, row, 1);
        controller.addDateField(equipmentFilter::setMaxDateTest, 7, row, 3);
    }
}
