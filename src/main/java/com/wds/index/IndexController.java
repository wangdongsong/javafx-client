package com.wds.index;

import com.wds.Application;
import com.wds.main.UserInfo;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.util.Callback;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class IndexController implements Initializable {
    private static final Logger LOGGER = LogManager.getLogger(IndexController.class);

    private Desktop desktop = Desktop.getDesktop();

    private ObservableList<UserObj> list = FXCollections.observableArrayList();


    @FXML
    private TableView<UserObj> dataTable;

    @FXML
    private BorderPane pane;

    @FXML
    private HBox dataTablePage;

    @FXML
    private TextField filePathField;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Pagination pager = new Pagination(5, 0);

        pager.setPageFactory((integer) -> {
            LOGGER.info(integer + 1);
            return new Label("curPage=" + (integer + 1));
        });
        pane.setBottom(pager);
    }



    @FXML
    private void ctsClick(){
        LOGGER.info("ctsClick");
        dataTable.setItems(getData("page1"));
    }

    @FXML
    private void wtSelect() {
        dataTable.setItems(getData("wtSelect"));
    }

    @FXML
    private void cjSelect() {
        dataTable.setItems(getData("cjSelect"));
    }

    @FXML
    private void fileSelect() {
        final FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(Application.getStage());
//        if (file != null) {
//            openFile(file);
//        }
        filePathField.setText(file.getPath());
        LOGGER.info(file.getPath());
    }

    @FXML
    private void fileUpload() {
        LOGGER.info("File upload");
    }


    private ObservableList<UserObj> getData(String page) {
        for (int i = 0; i < 10; i++){
            UserObj obj = new UserObj("first-" + i + "-" + page,"last-" + i + "-", "value-" + i + "-");
            list.add(obj);
        }
        return list;
    }

    private void openFile(File file) {
        try {
            desktop.open(file);
        } catch (IOException ex) {
            LOGGER.error(ex.getMessage(), ex);
        }
    }




}
