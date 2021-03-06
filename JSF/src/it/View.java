package it.ablp;

import it.ablp.RecuperoDati;
import it.ablp.Strumento;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@ManagedBean(name = "dati")
@SessionScoped
public class View implements Serializable {

  // === Properties ============================================================

  private RecuperoDati ds;
  private List<Strumento> strumenti;
  private Strumento strumSelezionato;
  private String facolta;

  // === Methods ===============================================================

  public View() {
    this.strumenti = null;
    this.strumSelezionato = null;
  }

  @PostConstruct
  public void initialize() {
    try {
      this.ds = new RecuperoDati();
    } catch( ClassNotFoundException e ){
      this.ds = null;
    }
  }
  
  public List<Strumento> getStrumenti() {
  	if(this.ds != null) {
  		strumenti = ds.getStrumentiDatabase();
  	}
  	return strumenti;
  }
}
