/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package componentes_zambranaivan;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

/**
 *
 * @author Ivan
 */
public class CustomControl extends HBox  implements Initializable {
    private ObjectProperty<EventHandler<ActionEvent>> OnAction = new SimpleObjectProperty<EventHandler<ActionEvent>>();
    
    @FXML 
    private TextField textField;
    @FXML 
    private Button control;
    public CustomControl() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("custom_control.fxml"));
        fxmlLoader.setRoot(this);
       fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public String getText() {
        return textProperty().get();
    }

    public void setText(String value) {
        textProperty().set(value);
    }

    public StringProperty textProperty() {
        return textField.textProperty();
    }

    public final ObjectProperty<EventHandler<ActionEvent>> onActionProperty() {
        return OnAction;
    }

    public final void setOnAction(EventHandler<ActionEvent> handler) {
        OnAction.set(handler);
    }

    public final EventHandler<ActionEvent> getOnAction() {
        return OnAction.get();
    }


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        control.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                onActionProperty().get().handle(event);
            }
        });
        
    }    
    
}