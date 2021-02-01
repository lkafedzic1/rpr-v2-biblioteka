package ba.unsa.etf.rpr;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class BibliotekaModel{
    private ObservableList<Knjiga> knjige = FXCollections.observableArrayList();
    private SimpleObjectProperty<Knjiga> trenutnaKnjiga = new SimpleObjectProperty<>();

    public void napuni() {
        knjige.add(new Knjiga("SheeRaSeven","I bring nothing to the table","1"));
        knjige.add(new Knjiga("Jordan Peterson","12 rules for life","1.0"));
        knjige.add(new Knjiga("Meša Selimović","Tvrđava","3"));
        trenutnaKnjiga.set(null);
    }

    public ObservableList<Knjiga> getKnjige() {
        return knjige;
    }

    public void setKnjige(ObservableList<Knjiga> knjige) {
        this.knjige = knjige;
    }

    public Knjiga getTrenutnaKnjiga() {
        return trenutnaKnjiga.get();
    }

    public SimpleObjectProperty<Knjiga> trenutnaKnjigaProperty() {
        return trenutnaKnjiga;
    }

    public void setTrenutnaKnjiga(Knjiga trenutnaKnjiga) {
        this.trenutnaKnjiga.set(trenutnaKnjiga);
    }
}
