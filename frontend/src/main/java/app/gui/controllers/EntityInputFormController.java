package app.gui.controllers;

import app.gui.controllers.interfaces.ChoiceItemSupplier;
import app.gui.controllers.interfaces.ErrorAction;
import app.gui.controllers.interfaces.SuccessAction;
import app.gui.custom.ChoiceItem;
import app.services.ServiceResponse;
import app.utils.LocalDateFormatter;
import app.utils.RequestExecutor;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;
import lombok.SneakyThrows;

import java.text.ParseException;
import java.time.Instant;
import java.util.*;
import java.util.function.UnaryOperator;

public class EntityInputFormController<T> {

    public interface SubmitAction<E> {
        ServiceResponse<E> submit(E entity) throws Exception;
    }

    public interface EntityFieldSetter<X> {
        void setField(X value);
    }

    private SubmitAction<T> submitAction;
    private SuccessAction onSuccessAction;
    private ErrorAction onErrorAction;
    private RequestExecutor requestExecutor;

    private final List<TextField> textFields = new ArrayList<>();
    private final List<TextField> integerFields = new ArrayList<>();
    private final List<TextField> dateTimeFields = new ArrayList<>();
    private final List<CheckBox> checkBoxes = new ArrayList<>();
    private final Map<ComboBox, ChoiceItem> choiceBoxes = new LinkedHashMap<>();

    @FXML
    private VBox contentBox;

    @FXML
    private GridPane grid;

    private T entity;

    public void init(
            T entity,
            SubmitAction<T> submitAction,
            SuccessAction onSuccessAction,
            ErrorAction onErrorAction,
            RequestExecutor requestExecutor
    ) {
        this.entity = entity;
        this.submitAction = submitAction;
        this.requestExecutor = requestExecutor;
        this.onSuccessAction = onSuccessAction;
        this.onErrorAction = onErrorAction;
    }

    public void addTextField(
            String name,
            String initFieldValue,
            EntityFieldSetter<String> fieldSetter
    ) {
        TextField textField = new TextField();
        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            fieldSetter.setField(newValue.trim());
        });

        initFieldValue = Objects.requireNonNullElse(initFieldValue, "");
        fieldSetter.setField(initFieldValue);
        textField.setText(initFieldValue);

        addField(name, textField);
        textFields.add(textField);
    }

    public void addCheckBox(
            String name,
            Boolean initFieldValue,
            EntityFieldSetter<Boolean> fieldSetter
    ) {
        CheckBox checkBox = new CheckBox();
        checkBox.selectedProperty().addListener((observable, oldValue, newValue) -> {
            fieldSetter.setField(newValue);
        });

        initFieldValue = Objects.requireNonNullElse(initFieldValue, false);
        fieldSetter.setField(initFieldValue);
        checkBox.setSelected(initFieldValue);

        addField(name, checkBox);
        checkBoxes.add(checkBox);
    }

    public void addIntegerField(
            String name,
            Integer initFieldValue,
            EntityFieldSetter<Integer> fieldSetter
    ) {

        UnaryOperator<TextFormatter.Change> integerFilter = change -> {
            String newText = change.getControlNewText();
            if (newText.matches("0|([1-9][0-9]{0,8})?")) {
                return change;
            }
            return null;
        };

        TextField integerField = new TextField();
        integerField.setTextFormatter(
                new TextFormatter<>(
                        new IntegerStringConverter(), initFieldValue, integerFilter
                )
        );

        integerField.textProperty().addListener((observable, oldValue, newValue) -> {
            fieldSetter.setField(newValue.isEmpty() ? null : Integer.valueOf(newValue));
        });

        addField(name, integerField);
        integerFields.add(integerField);
    }

    public void addDateField(
            String name,
            Date initFieldValue,
            EntityFieldSetter<Date> fieldSetter
    ) {
        addDateTimePicker(
                name,
                initFieldValue,
                fieldSetter,
                true
        );
    }

    public void addDateTimeField(
            String name,
            Date initFieldValue,
            EntityFieldSetter<Date> fieldSetter
    ) {
        addDateTimePicker(
                name,
                initFieldValue,
                fieldSetter,
                false
        );
    }

    private void addDateTimePicker(
            String name,
            Date initFieldValue,
            EntityFieldSetter<Date> fieldSetter,
            final boolean isDateOnly
    ) {
        TextField dateTimeField = new TextField();
        Date currentDate = initFieldValue == null ? Date.from(Instant.now()) : initFieldValue;
        fieldSetter.setField(currentDate);

        String currentDateText = isDateOnly ?
                LocalDateFormatter.getFormattedDate(currentDate) :
                LocalDateFormatter.getFormattedDateTime(currentDate);
        dateTimeField.setText(currentDateText);

        dateTimeField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                try {
                    String dateText = dateTimeField.getText().trim();
                    dateTimeField.setText(dateText);
                    Date date = isDateOnly ?
                            LocalDateFormatter.parseDate(dateText)
                            : LocalDateFormatter.parseDateTime(dateText);
                    fieldSetter.setField(date);
                } catch (ParseException e) {
                    dateTimeField.setText("");
                    fieldSetter.setField(null);
                }
            }
        });

        addField(name, dateTimeField);
        dateTimeFields.add(dateTimeField);
    }

    @SneakyThrows
    public <X> void addChoiceBox(
            String name,
            X initFieldValue,
            EntityFieldSetter<X> fieldSetter,
            ChoiceItemSupplier<X> itemSupplier

    ) {
        ChoiceItem<X> defaultItem = new ChoiceItem<>(null, "Не указано");
        var items = itemSupplier.getItems();
        items.add(defaultItem);

        ChoiceItem<X> selectedItem = items.stream()
                .filter(item -> item.getValue() != null &&
                        item.getValue().equals(initFieldValue))
                .findAny()
                .orElse(defaultItem);

        ComboBox<ChoiceItem<X>> choiceBox = new ComboBox<>();
        choiceBox.setValue(selectedItem);
        choiceBox.getItems().addAll(items);
        choiceBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            fieldSetter.setField(newValue.getValue());
        });

        choiceBoxes.put(choiceBox, defaultItem);
        addField(name, choiceBox);
    }

    private void addField(String name, Control field) {
        field.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        Label label = new Label(String.format("%s:", name));
        label.setTextAlignment(TextAlignment.CENTER);
        label.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        GridPane.setHalignment(field, HPos.CENTER);
        GridPane.setValignment(field, VPos.CENTER);
        GridPane.setHalignment(label, HPos.CENTER);
        GridPane.setValignment(label, VPos.CENTER);

        int rowsNumber = grid.getRowCount();
        grid.add(label, 0, rowsNumber, 2, 1);
        grid.add(field, 2, rowsNumber, 3, 1);
    }

    private boolean validateFields() {
        for (var textField: textFields) {
            var text = textField.getText().trim();
            if (text.isEmpty()) {
                textField.setText("");
                textField.requestFocus();
                return false;
            }
        }

        for (var integerField: integerFields) {
            var value = integerField.getText();
            if (value == null || value.isEmpty()) {
                integerField.requestFocus();
                return false;
            }
        }

        for (var dateTimeField: dateTimeFields) {
            var dateText = dateTimeField.getText().trim();
            if (dateText.isEmpty()) {
                dateTimeField.requestFocus();
                return false;
            }
        }

        for (var rawChoiceBox: choiceBoxes.keySet()) {
            ComboBox<ChoiceItem<?>> choiceBox = rawChoiceBox;
            ChoiceItem<?> choiceItem = choiceBox.valueProperty().getValue();
            if (choiceItem.getValue() == null) {
                choiceBox.requestFocus();
                return false;
            }
        }

        return true;
    }

    @FXML
    private void clearFields() {
        for (var textField: textFields) {
            textField.setText("");
        }

        for (var integerField: integerFields) {
            integerField.setText("");
        }

        for (var dateTimeField: dateTimeFields) {
            dateTimeField.setText("");
        }

        for (var rawChoiceBox: choiceBoxes.keySet()) {
            ComboBox<ChoiceItem<?>> choiceBox = rawChoiceBox;
            ChoiceItem<?> defaultItem = choiceBoxes.get(rawChoiceBox);
            choiceBox.setValue(defaultItem);
        }

        for (var checkBox: checkBoxes) {
            checkBox.setSelected(false);
        }
    }

    @FXML
    private void submit(ActionEvent event) {
        boolean fieldsAreValid = validateFields();
        if (!fieldsAreValid) {
            return;
        }

        disableComponent();
        requestExecutor
                .makeRequest(() -> submitAction.submit(entity))
                .setOnSuccessAction(createdEntity -> {
                    Platform.runLater(() -> {
                        Node sourceNode = (Node) event.getSource();
                        Stage stage = (Stage) sourceNode.getScene().getWindow();
                        stage.close();
                    });
                    if (onSuccessAction != null) {
                        onSuccessAction.run();
                    }
                })
                .setOnFailureAction(errorMessage -> {
                    if (onErrorAction != null) {
                        onErrorAction.run(errorMessage);
                    }
                })
                .setFinalAction(this::enableComponent)
                .submit();
    }

    public void enableComponent() {
        contentBox.setDisable(false);
    }

    public void disableComponent() {
        contentBox.setDisable(true);
    }

}
