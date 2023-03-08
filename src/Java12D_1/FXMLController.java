package Java12D_1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class FXMLController {
    @FXML
    private TextField txt_result;
    @FXML
    private int currentNumber;
    @FXML
    private int firstNumber;
    @FXML
    private double result;
    @FXML
    private String operation = "";

    // hier wurde eine mathematische Operation gewählt
    @FXML
    private void operationKlick(ActionEvent event) {
        String value = ((Button) event.getSource()).getText();
        // Hier werden die Methoden Berechnen und Reset ausgeführt,
        // wenn die Operation = gewählt wird und vorher keine mathematische Operation gewählt wurde.
        if (!operation.equals("")) {
            if (value.equals("=")) {
                berechnen();
                reset(event);
            }
            //hier wenn nur eine Zahl eingegeben wird, ist der Vorgang "=" blockiert.
        } else if (currentNumber != 0) {
            if (!value.equals("=")) {
                //Hierbei wird, wenn eine Zahl eingegeben wird,
                // die gewählte mathematische Operation in der Variablen Operation gespeichert und
                //erste Zahl in der Variablen firstNumber gespeichert und die Variable currentNumber zurückgesetzt.
                operation = value;
                firstNumber = currentNumber;
                currentNumber = 0;
                txt_result.setText(firstNumber + operation);
            }
        }
    }

    //Hier wurden mit der Berechnen-Methode ausgewählte mathematische Operationen verwendet.
    @FXML
    private void berechnen() {
        if (operation.equals("+")) {
            result = firstNumber + currentNumber;
            txt_result.setText(firstNumber + operation + currentNumber + " = " + result);

        }
        if (operation.equals("-")) {
            result = firstNumber - currentNumber;
            txt_result.setText(firstNumber + operation + currentNumber + " = " + result);

        }
        if (operation.equals("*")) {
            result = firstNumber * currentNumber;
            txt_result.setText(firstNumber + operation + currentNumber + " = " + result);

        }
        if (operation.equals("/")) {
            if (currentNumber != 0) {
                result = (double) firstNumber / currentNumber;
                txt_result.setText(firstNumber + operation + currentNumber + " = " + result);
            } else
                txt_result.setText("Nicht definiert!");
        }
    }

    //Hier wird die Methode nummerKlick verwendet,
    // um die ausgewählten Zahlen zu den Variablen hinzuzufügen.
    @FXML
    private void nummerKlick(ActionEvent event) {
        String value = ((Button) event.getSource()).getText();
        if (operation.equals("")) {
            //hier wird die Methode Long.parseLong verwendet,
            // um Fehler bei Variablen vom Typ int zu vermeiden
            currentNumber = (int) Long.parseLong((currentNumber + value));
            txt_result.setText(String.valueOf(firstNumber + currentNumber));
        } else {
            currentNumber = (int) Long.parseLong(currentNumber + value);
            txt_result.setText(firstNumber + operation + currentNumber);

        }


    }
    //Hier wurde eine Methode erstellt, um die Variablen zurückzusetzen,
    // wenn die Taste C gedrückt wird oder jedes Mal, wenn die Taste "=" gedrückt wird.
    @FXML
    private void reset(ActionEvent event) {
        String value = ((Button)event.getSource()).getText();
        if (value.equals("C")){
            firstNumber = 0;
            currentNumber = 0;
            operation = "";
            result = 0;
            txt_result.setText("0");
        }
        firstNumber = 0;
        currentNumber = 0;
        operation = "";
        result = 0;

    }


}
