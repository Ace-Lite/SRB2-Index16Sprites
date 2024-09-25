module com.teambluespring.srb2rotations {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.teambluespring.srb2rotations to javafx.fxml;
    exports com.teambluespring.srb2rotations;
}