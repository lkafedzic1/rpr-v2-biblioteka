package ba.unsa.etf.rpr;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class BibliotekaController {
    public TextField fldAutor;
    public ChoiceBox<Knjiga> choiceKnjige;
    public TextField fldNaslov;
    public TextField fldIsbn;

    private BibliotekaModel model;

    public BibliotekaController(BibliotekaModel model) {
        this.model = model;
    }

    @FXML
    public void initialize() {
        choiceKnjige.setItems(model.getKnjige());
        model.trenutnaKnjigaProperty().addListener(
            (obs,oldKnjiga,newKnjiga) -> {
                if (oldKnjiga != null) {
                    fldAutor.textProperty().unbindBidirectional(oldKnjiga.autorProperty());
                    fldNaslov.textProperty().unbindBidirectional(oldKnjiga.naslovProperty());
                    fldIsbn.textProperty().unbindBidirectional(oldKnjiga.isbnProperty());
                }
                if (newKnjiga == null) {
                    fldAutor.setText("");
                    fldNaslov.setText("");
                    fldIsbn.setText("");
                }
                else {
                    fldAutor.textProperty().bindBidirectional(newKnjiga.autorProperty());
                    fldNaslov.textProperty().bindBidirectional(newKnjiga.naslovProperty());
                    fldIsbn.textProperty().bindBidirectional(newKnjiga.isbnProperty());
                }
            }
        );
    }


    public void promjenaKnjige(ActionEvent actionEvent) {
        model.setTrenutnaKnjiga(choiceKnjige.getValue());
    }

    public void actionIspisi(ActionEvent actionEvent) {
        for(Knjiga k : model.getKnjige())
            System.out.println(k);
    }
}
