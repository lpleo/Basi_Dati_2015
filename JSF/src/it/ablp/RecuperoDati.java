package it.ablp;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RecuperoDati implements Serializable {
//dati utente
	private String user = "userlab05";
	private String passwd = "cinqueOP";

//dati driver
	private String url = "jdbc:postgresql://dbserver.scienze.univr.it/dblab05";
	private String driver = "org.postgresql.Driver";

//query	
	private String queryStrum = "SELECT s.nome, d.nomed FROM strumento s FULL JOIN incarico d ON s.cod = d.cods;";
	
	/*==========================costruttori====================================*/
	public RecuperoDati() throws ClassNotFoundException {
    Class.forName( driver );
 	}
	
	/*==========================metodi====================================*/
	/*======BEAN=====*/
		//bean strumenti + collocazione
		private Strumento makeStrumBean( ResultSet rs ) throws SQLException {
		Strumento bean = new Strumento();
		bean.setNome( rs.getString( "nome" ) );
		//speremoben
		String stato = rs.getString( "nomed" );
		if(stato.length()==0) stato = "disponibile";
		
		bean.setInUso( stato );
		return bean;
	  	}
  	
  	/*=====FINE BEAN=====*/
  	
  	/*===RECUPERO DATI DA DATABASE===*/
	  	public List<Strumento> getCrediti() {
		// dichiarazione delle variabili
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Strumento> result = new ArrayList<Strumento>();

		try {
		  // tentativo di connessione al database
		  con = DriverManager.getConnection( url, user, passwd );
		  // connessione riuscita, ottengo l'oggetto per l'esecuzione dell'interrogazione.
		  stmt = con.createStatement();
		  // eseguo l'interrogazione desiderata
		  rs = stmt.executeQuery( queryStrum );
		  // memorizzo il risultato dell'interrogazione nel Vector
		  while( rs.next() ) {
		    result.add( makeStrumBean( rs ) );
		  }

		} catch( SQLException sqle ) { // catturo le eventuali eccezioni!
		  sqle.printStackTrace();

		} finally { // alla fine chiudo la connessione.
		  try {
		    con.close();
		  } catch( SQLException sqle1 ) {
		    sqle1.printStackTrace();
		  }
		}
		return result;
	  	}
	  /*===RECUPERO DATI DA DATABASE FINE===*/
}
