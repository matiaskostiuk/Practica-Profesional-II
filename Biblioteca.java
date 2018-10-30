import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;


public class Biblioteca {
	
      private ArrayList<Libro> biblio;
      
	  public Biblioteca() throws ClassNotFoundException, SQLException
      {
	       Connection conexion;
  	       Statement sentencia;
  	       biblio = new ArrayList<Libro>();
    	   Class.forName("com.mysql.jdbc.Driver");
 		   conexion = DriverManager.getConnection ("jdbc:mysql://localhost/biblioteca","root","");
           sentencia = conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
  	       ResultSet datos = sentencia.executeQuery("select * from libros");
           while (datos.next())
  	       {
  	            Libro p = new Libro(datos);
  	            System.out.println(p);
  	       }
  
  	       datos.close();
           sentencia.close();
  	       conexion.close();
      }
      
      public ArrayList<Libro> getBiblio()
      {
    	  return biblio;
      }
      public void agregarLibro(Libro l)
      {
    	  biblio.add(l);
      }
      public void eliminarLibro(String isbn)
      {
    	  for (int i = 0; i < biblio.size(); i++)
    	  {
    		  if (biblio.get(i).getISBN().equals(isbn))
    		  {
    			  biblio.remove(i);
    			  break;
    		  }
    	  }
      }
      public boolean contiene (Libro l)
      {
    	  return biblio.contains(l);
      }
      public Libro consultarLibro(String isbn)
      {
    	  for (int i = 0; i < biblio.size(); i++)
    	  {
    		  if (biblio.get(i).getISBN().equals(isbn))
    			  return biblio.get(i);
    	  }
    	  return null;
      }
      public void listar()
      {   String lista = "";
          if (biblio.size() > 0)
          {
    	     for (int i = 0; i < biblio.size(); i++)
    		      lista = lista + biblio.get(i)+"\n";
    	     JOptionPane.showMessageDialog(null,lista);
          }else
        	 JOptionPane.showMessageDialog(null,"No Hay Mas Libros");
      }
    
}
