package ui.utils;

import javafx.scene.Node;
import javafx.scene.control.*;

public class Validation {

    /**
     * Those constants are used for setting style
     */
    private static final String BORDER_RED = "-fx-border-color: red";

    /**
     * Method checks data in ui components and sets style;
     * @param textField - components which will be checked;
     * @return - if data is correct then return true, else return false;
     */
    public static boolean checkData(TextField... textField){
        int result = 0;

        for (TextField field : textField) {
            if (field.getText().trim().length() <= 0){
                setStyle(field, BORDER_RED);
                field.requestFocus();
                field.textProperty().addListener(e -> setStyle(field, null));
            }
        }

        return result == textField.length;
    }

    /**
     * Method checks data in ui components and sets style;
     * @param comboBox - components which will be checked;
     * @return - if data is correct then return true, else return false;
     */
    public static boolean checkData(ComboBox... comboBox){
        int result = 0;

        for (ComboBox box : comboBox) {
            if (box.getSelectionModel().getSelectedItem() == null){
                setStyle(box, BORDER_RED);
                box.requestFocus();
                box.itemsProperty().addListener(e -> setStyle(box, null));
            }
        }

        return result == comboBox.length;
    }

    /**
     * Method checks data in ui components and sets style;
     * @param datePickers - components which will be checked;
     * @return - if data is correct then return true, else return false;
     */
    public static boolean checkData(DatePicker... datePickers){
        int result = 0;

        for (DatePicker datePicker : datePickers) {
            if (datePicker.getValue() == null){
                setStyle(datePicker, BORDER_RED);
                datePicker.requestFocus();
                datePicker.valueProperty().addListener(e -> setStyle(datePicker, null));
            }
        }
        return result == datePickers.length;
    }

    /**
     * Method sets style in component node;
     * @param node - components which will be set style;
     * @param style - style which will be used;
     */
    private static void setStyle(Node node, String style){
        node.setStyle(style);
    }
}
