package com.example.fxasync;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ListChangeListener;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

public class GridPaneController implements Initializable {
    @FXML private TextField pathId;
    @FXML private TextField endId;
    @FXML private ProgressBar barId;
    @FXML private ListView<String> listId;
    private Task task = null;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        JavaFXAsync.items.addListener(new ListChangeListener() {
            @Override
            public void onChanged(ListChangeListener.Change obj) {
                listId.setItems(obj.getList());
            }
        });
    }

    @FXML
    protected void btnFindClick(ActionEvent event) {
        String path=pathId.getText();
        String end =endId.getText();
        JavaFXAsync.items.clear();

        task = new FindTask(JavaFXAsync.items, path, end);
        barId.progressProperty().bind(task.progressProperty());

        Thread thread=new Thread(task);
        thread.setDaemon(true);
        thread.start();

    }

    @FXML
    protected void btnCancelClick(ActionEvent event) {
        System.out.println("Try to Cancel!");
        if (task!=null) task.cancel();
    }
}