module com.arabie {
    requires javafx.controls;
    requires jakarta.xml.bind;
    opens com.arabie;
    opens com.arabie.models;
    exports com.arabie;
}