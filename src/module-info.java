module Frogger {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.media;
    requires javafx.graphics;
    requires java.desktop;
    requires javafx.base;
    requires javafx.swing;

    exports p4_group_8_repo.Controllers;
    exports p4_group_8_repo.Models;
    exports p4_group_8_repo.Views;
    exports p4_group_8_repo;

    opens p4_group_8_repo;
    opens p4_group_8_repo.Controllers;
    opens p4_group_8_repo.Models;
    opens p4_group_8_repo.Views;

}