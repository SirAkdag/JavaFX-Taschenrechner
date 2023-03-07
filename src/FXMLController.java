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

    @FXML
    private void operationKlick(ActionEvent event) {
        String value = ((Button) event.getSource()).getText();
        if (!operation.equals("")) {
            if (value.equals("=")) {
                berechnen();
                reset();
            }
        } else if (currentNumber != 0) {

            operation = value;
            firstNumber = currentNumber;
            currentNumber = 0;
            txt_result.setText(firstNumber + operation);

        }

    }


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


    @FXML
    private void nummerKlick(ActionEvent event) {
        String value = ((Button) event.getSource()).getText();
        if (operation.equals("")) {
            currentNumber = Integer.parseInt((currentNumber + value));
            txt_result.setText(String.valueOf(firstNumber + currentNumber));
        } else {
            currentNumber = Integer.parseInt(currentNumber + value);
            txt_result.setText(firstNumber + operation + currentNumber);

        }


    }

    @FXML
    private void reset(ActionEvent event) {
        String value = ((Button) event.getSource()).getText();
        if (value.equals("C")) {
            currentNumber = 0;
            firstNumber = 0;
            operation = "";
            result = 0;
            txt_result.setText("0");
        }
    }

    private void reset() {
        firstNumber = 0;
        currentNumber = 0;
        operation = "";
        result = 0;
    }


}
