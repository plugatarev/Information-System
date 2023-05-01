package app.gui.forms.filtering.impl;

import app.gui.controllers.FilterBoxController;
import app.gui.controllers.interfaces.ChoiceItemSupplier;
import app.gui.custom.ChoiceItem;
import app.model.Department;
import app.model.Laboratory;
import app.model.Product;
import app.model.type.ProductStatusEnum;
import app.model.type.ProductTypeEnum;
import app.services.filters.Filter;
import app.services.filters.ProductFilter;
import app.utils.ServiceFactory;

public class ProductFilterBoxBuilder extends AbstractFilterBoxBuilder<Product> {
    @Override
    protected void fillFilterBox(FilterBoxController<Product> controller, Filter filter) {
        ProductFilter productFilter = (ProductFilter) filter;
        ChoiceItemSupplier<Department> departmentIdSupplier = makeChoiceItemSupplierFromEntities(
                ServiceFactory.getDepartmentService(),
                c -> new ChoiceItem<>(c.clone(),  c.getDepartmentName()),
                "Не удалось загрузить список цехов"
        );

        ChoiceItemSupplier<Laboratory> laboratoryIdSupplier = makeChoiceItemSupplierFromEntities(
                ServiceFactory.getLaboratoryService(),
                c -> new ChoiceItem<>(c.clone(),  c.getLaboratoryName()),
                "Не удалось загрузить список лабораторий"
        );

        controller.setNumberOfRows(3);
        controller.setNumberOfCols(10);

        int row = 0;
        controller.addLabel("Тип изделия:", 0, row, 2);
        controller.addChoiceBox(productFilter::setProductTypeEnum, ProductTypeEnum::getChoiceItems, 2, row, 5);

        row++;
        controller.addLabel("Стутус изделия:", 0, row, 2);
        controller.addChoiceBox(productFilter::setProductStatusEnum, ProductStatusEnum::getChoiceItems, 2, row, 5);

        row++;
        controller.addLabel("Цех:", 0, row, 2);
        controller.addChoiceBox(productFilter::setDepartment, departmentIdSupplier, 2, row, 5);

        row++;
        controller.addLabel("Дата сборки:", 0, row, 2);
        controller.addLabel("от", 2, row, 1);
        controller.addDateField(productFilter::setMinAssembledDate, 3, row, 3);
        controller.addLabel("до", 6, row, 1);
        controller.addDateField(productFilter::setMaxAssembledDate, 7, row, 3);

        row++;
        controller.addLabel("Лаборатория:", 0, row, 2);
        controller.addChoiceBox(productFilter::setLaboratory, laboratoryIdSupplier, 2, row, 5);

        row++;
        controller.addLabel("Дата прохождения тестирования в лаборатории:", 0, row, 2);
        controller.addLabel("от", 2, row, 1);
        controller.addDateField(productFilter::setMinLaboratoryDate, 3, row, 3);
        controller.addLabel("до", 6, row, 1);
        controller.addDateField(productFilter::setMaxLaboratoryDate, 7, row, 3);
    }
}
