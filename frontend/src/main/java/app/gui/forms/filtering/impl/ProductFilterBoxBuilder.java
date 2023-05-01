package app.gui.forms.filtering.impl;

import app.gui.controllers.FilterBoxController;
import app.gui.controllers.interfaces.ChoiceItemSupplier;
import app.gui.custom.ChoiceItem;
import app.model.Department;
import app.model.DepartmentRegion;
import app.model.Entity;
import app.model.Product;
import app.model.type.ProductStatusEnum;
import app.model.type.ProductTypeEnum;
import app.services.Service;
import app.services.filters.Filter;
import app.services.filters.ProductFilter;
import app.services.pagination.Page;
import app.services.pagination.PageInfo;
import app.utils.ServiceFactory;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ProductFilterBoxBuilder extends AbstractFilterBoxBuilder<Product> {
    @Override
    protected void fillFilterBox(FilterBoxController<Product> controller, Filter filter) {
        ProductFilter productFilter = (ProductFilter) filter;
        ChoiceItemSupplier<DepartmentRegion> departmentRegionIdSupplier = makeChoiceItemSupplierFromEntities(
                ServiceFactory.getDepartmentRegionService(),
                c -> new ChoiceItem<>(c.clone(),  c.getRegionName()),
                "Не удалось загрузить список участков"
        );

        ChoiceItemSupplier<Department> departmentIdSupplier = makeChoiceItemSupplierFromEntities(
                ServiceFactory.getDepartmentService(),
                c -> new ChoiceItem<>(c.clone(),  c.getDepartmentName()),
                "Не удалось загрузить список цехов"
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
    }

    protected <X extends Entity, Y> ChoiceItemSupplier<Y> makeChoiceItemSupplierFromEntities(
            Service<X> entityService,
            Function<X, ChoiceItem<Y>> entityToChoiceItemMapper,
            String errorMessage
    ) {
        return makeChoiceItemSupplierFromEntities(
                entityService,
                x -> true,
                entityToChoiceItemMapper,
                errorMessage
        );
    }

    protected <X extends Entity, Y> ChoiceItemSupplier<Y> makeChoiceItemSupplierFromEntities(
            Service<X> entityService,
            Predicate<X> entityFilterPredicate,
            Function<X, ChoiceItem<Y>> entityToChoiceItemMapper,
            String errorMessage
    ) {
        return () -> {

            try {
                Page<X> page = entityService.getAll(PageInfo.getUnlimitedPageInfo()).getBody();
                Objects.requireNonNull(page, errorMessage);

                return page.getElementList().stream()
                           .filter(entityFilterPredicate)
                           .map(entityToChoiceItemMapper)
                           .collect(Collectors.toList());
            } catch (Exception e) {
                throw new RuntimeException(errorMessage, e);
            }

        };
    }
}
