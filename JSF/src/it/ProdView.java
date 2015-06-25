package it;

import it.ablp.RecuperoDati;
import it.ablp.Strumento;
import it.ablp.StrSel;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@ManagedBean(name = "dati")
@SessionScoped
public class ProdView implements Serializable {

  // === Properties ============================================================

  private RecuperoDati ds;
  private List<Strumento> strumenti;
  private StrSel strumSelezionato;

  // === Methods ===============================================================

  public ProdView() {
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
  
  public String dettaglio(java.lang.String elementi) {
    if( this.ds != null ){
      strumSelezionato = ds.getStrumSel( elementi );
    }
    return "dettaglio";
  }
  
  public StrSel getDetStrum() {
  	return strumSelezionato;
  }
}
