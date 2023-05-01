package app.gui.forms.filtering.impl;

import app.gui.controllers.FilterBoxController;
import app.gui.controllers.FxmlLoaderFactory;
import app.gui.controllers.interfaces.ChoiceItemSupplier;
import app.gui.custom.ChoiceItem;
import app.gui.forms.filtering.FilterBoxBuilder;
import app.model.Entity;
import app.services.Service;
import app.services.filters.Filter;
import app.services.pagination.Page;
import app.services.pagination.PageInfo;
import javafx.scene.Node;
import javafx.scene.Parent;
import lombok.SneakyThrows;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public abstract class AbstractFilterBoxBuilder<T extends Entity> implements FilterBoxBuilder<T> {

    @Override
    @SneakyThrows
    public Node buildFilterBox(Filter filter) {
        var fxmlLoader = FxmlLoaderFactory.createFilterBoxLoader();
        Parent rootNode = fxmlLoader.load();
        FilterBoxController<T> controller = fxmlLoader.getController();
        controller.init();
        fillFilterBox(controller, filter);
        return rootNode;
    }

    protected abstract void fillFilterBox(FilterBoxController<T> controller, Filter filter);

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
