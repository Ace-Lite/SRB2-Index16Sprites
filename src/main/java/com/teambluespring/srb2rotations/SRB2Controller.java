package com.teambluespring.srb2rotations;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.stage.FileChooser;

import static java.nio.file.Files.copy;

public class SRB2Controller {

    // Controller Variables

    private static String New_Path;
    private String[] SpriteStorage = new String[64];
    private File last_path;

    // Working Area

    @FXML
    private Button Sprite_4;
    @FXML
    private Button Sprite_B;
    @FXML
    private Button Sprite_3;
    @FXML
    private Button Sprite_A;
    @FXML
    private Button Sprite_2;
    @FXML
    private Button Sprite_9;
    @FXML
    private Button Sprite_1;
    @FXML
    private Button Sprite_G;
    @FXML
    private Button Sprite_8;
    @FXML
    private Button Sprite_F;
    @FXML
    private Button Sprite_7;
    @FXML
    private Button Sprite_E;
    @FXML
    private Button Sprite_6;
    @FXML
    private Button Sprite_D;
    @FXML
    private Button Sprite_5;
    @FXML
    private Button Sprite_C;

    // Side Area

    @FXML
    private TextField SpriteName;
    @FXML
    private CheckBox BoolLongSprites;
    @FXML
    private CheckBox BoolLeftToRight;
    @FXML
    private CheckBox BoolRightToLeft;

    // Functions

    private int getLayerPosition(Node node) {
        Parent parent = (Parent) node.getParent();
        if (parent != null) {
            return parent.getChildrenUnmodifiable().indexOf(node);
        }
        return -1;
    }

    @FXML
    protected void clickToGetImage(ActionEvent event) {

        Button source = (Button) event.getSource();

        FileChooser choice = new FileChooser();
        choice.setTitle("Open Rotation Frame");

        // Getting the good stuff
        File file = choice.showOpenDialog(SRB2Application.returnCurrentScene().getWindow());
        //if (last_path != null && last_path.exists())
        //{
        //   choice.setInitialDirectory(last_path);
        // }

        if (file != null) {
            try {
                Image img = new Image(file.toURI().toString());
                SpriteStorage[getLayerPosition(source)] = file.toPath().toString();
                last_path = file.getParentFile();

                // Settings
                source.setGraphic(new ImageView(img));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    protected void boolSetLeftToRight(ActionEvent event) {
        BoolRightToLeft.setSelected(false);
    }

    @FXML
    protected void boolSetRightToLeft(ActionEvent event) {
        BoolLeftToRight.setSelected(false);
    }

    @FXML
    protected void clearClick() {
        // Not exactly efficient, but everything here is so static...
        Sprite_4.setGraphic(null);
        Sprite_B.setGraphic(null);
        Sprite_3.setGraphic(null);
        Sprite_A.setGraphic(null);
        Sprite_2.setGraphic(null);
        Sprite_9.setGraphic(null);
        Sprite_1.setGraphic(null);
        Sprite_G.setGraphic(null);
        Sprite_8.setGraphic(null);
        Sprite_F.setGraphic(null);
        Sprite_7.setGraphic(null);
        Sprite_E.setGraphic(null);
        Sprite_6.setGraphic(null);
        Sprite_D.setGraphic(null);
        Sprite_5.setGraphic(null);
        Sprite_C.setGraphic(null);

        SpriteStorage = new String[SpriteStorage.length];
    }

    private void saveMacroShort(Button In, String Suffix) {
        try {
            Files.copy((Path)Paths.get(SpriteStorage[getLayerPosition(In)]),
                    (Path)Paths.get(New_Path+"\\"+SpriteName.getSelectedText()+Suffix+".png"),
                    StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void saveMacroLong(Button In, String Filename) {
        try {
            Files.copy((Path)Paths.get(SpriteStorage[getLayerPosition(In)]),
                    (Path)Paths.get(New_Path+"\\"+Filename+".png"),
                    StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void saveAsClick(ActionEvent event) {

        FileChooser choice = new FileChooser();
        choice.setTitle("Save Whole Rotation");
        //if (last_path != null && last_path.exists())
        //{
        //    choice.setInitialDirectory(last_path);
        //}

        choice.setInitialFileName("Export");
        // Getting the good stuff
        File file = choice.showSaveDialog(SRB2Application.returnCurrentScene().getWindow());

        New_Path = file.getParent();
        last_path = file.getParentFile();

        if (New_Path == null)
            return;

        if (BoolLongSprites.isSelected())
        {
            if (BoolLeftToRight.isSelected()) {
                saveMacroLong(Sprite_5, "0_5");
                saveMacroLong(Sprite_C, "0_12+0_13");
                saveMacroLong(Sprite_4, "0_4+0_6");
                saveMacroLong(Sprite_B, "0_11+0_14");
                saveMacroLong(Sprite_3, "0_3+0_7");
                saveMacroLong(Sprite_A, "0_10+0_15");
                saveMacroLong(Sprite_2, "0_2+0_8");
                saveMacroLong(Sprite_9, "0_9+0_16");
                saveMacroLong(Sprite_1, "0_1");
            } else if (BoolRightToLeft.isSelected()) {
                saveMacroLong(Sprite_5, "0_5");
                saveMacroLong(Sprite_D, "0_13+0_12");
                saveMacroLong(Sprite_6, "0_6+0_4");
                saveMacroLong(Sprite_E, "0_14+0_11");
                saveMacroLong(Sprite_7, "0_7+0_3");
                saveMacroLong(Sprite_F, "0_15+0_10");
                saveMacroLong(Sprite_8, "0_8+0_2");
                saveMacroLong(Sprite_G, "0_16+0_9");
                saveMacroLong(Sprite_1, "0_1");
            } else {
                saveMacroLong(Sprite_4, "0_4");
                saveMacroLong(Sprite_B, "0_11");
                saveMacroLong(Sprite_3, "0_3");
                saveMacroLong(Sprite_A, "0_10");
                saveMacroLong(Sprite_2, "0_2");
                saveMacroLong(Sprite_9, "0_9");
                saveMacroLong(Sprite_1, "0_1");
                saveMacroLong(Sprite_G, "0_16");
                saveMacroLong(Sprite_8, "0_8");
                saveMacroLong(Sprite_F, "0_15");
                saveMacroLong(Sprite_7, "0_7");
                saveMacroLong(Sprite_E, "0_14");
                saveMacroLong(Sprite_6, "0_6");
                saveMacroLong(Sprite_D, "0_13");
                saveMacroLong(Sprite_5, "0_5");
                saveMacroLong(Sprite_C, "0_12");
            }
        }
        else
        {
            if (BoolLeftToRight.isSelected()) {
                saveMacroShort(Sprite_5, "A5");
                saveMacroShort(Sprite_C, "ACAD");
                saveMacroShort(Sprite_4, "A4A6");
                saveMacroShort(Sprite_B, "ABAE");
                saveMacroShort(Sprite_3, "A3A7");
                saveMacroShort(Sprite_A, "AAAF");
                saveMacroShort(Sprite_2, "A2A8");
                saveMacroShort(Sprite_9, "A9AG");
                saveMacroShort(Sprite_1, "A1");
            } else if (BoolRightToLeft.isSelected()) {
                saveMacroShort(Sprite_5, "A5");
                saveMacroShort(Sprite_D, "ADAC");
                saveMacroShort(Sprite_6, "A6A4");
                saveMacroShort(Sprite_E, "AEAB");
                saveMacroShort(Sprite_7, "A7A3");
                saveMacroShort(Sprite_F, "AFAA");
                saveMacroShort(Sprite_8, "A8A2");
                saveMacroShort(Sprite_G, "AGA9");
                saveMacroShort(Sprite_1, "A1");
            } else {
                saveMacroShort(Sprite_4, "A4");
                saveMacroShort(Sprite_B, "AB");
                saveMacroShort(Sprite_3, "A3");
                saveMacroShort(Sprite_A, "AA");
                saveMacroShort(Sprite_2, "A2");
                saveMacroShort(Sprite_9, "A9");
                saveMacroShort(Sprite_1, "A1");
                saveMacroShort(Sprite_G, "A6");
                saveMacroShort(Sprite_8, "A8");
                saveMacroShort(Sprite_F, "AF");
                saveMacroShort(Sprite_7, "A7");
                saveMacroShort(Sprite_E, "AE");
                saveMacroShort(Sprite_6, "A6");
                saveMacroShort(Sprite_D, "AD");
                saveMacroShort(Sprite_5, "A5");
                saveMacroShort(Sprite_C, "AC");
            }
        }

    }
}