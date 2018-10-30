import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;


public class Libro implements Comparable<Libro>{
      private String titulo;
      private String autor;
      private String ISBN;
      private int copias;
      private void llenarDatos( String libro)
      {
    	    String datos [] = libro.split(",");
    	    titulo = datos[0];
    	    autor = datos[1];
    	    ISBN = datos[2];
    	    copias = Integer.parseInt(datos[3]);
      }
      public Libro (String libro)
      {
    	  llenarDatos(libro);
      }
      
	public Libro() {
		String libro = JOptionPane.showInputDialog("ingresar libro: ");
		llenarDatos(libro);
	}

	public Libro(ResultSet datos) throws SQLException {
		titulo = datos.getString(1);
		autor = datos.getString(2);
		ISBN = datos.getString(3);
		copias = datos.getInt(4);
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public int getCopias() {
		return copias;
	}
	public void setCopias(int copias) {
		this.copias = copias;
	}
	
	public String toString() {
		return "[" + titulo + ", " + autor + ", "
				+ ISBN + ", " + copias + "]";
	}

	public int compareTo(Libro l) {
		return this.ISBN.compareTo(l.getISBN());
	}
	
	
    public boolean equals (Object l)
    {
    	boolean iguales = false;
    	Libro aux;
    	if (l instanceof Libro)
    	{
    		aux = (Libro)l;
    		if (this.ISBN.equals(aux.getISBN()))
    			iguales = true;
    	}
    	return iguales;
    }
}
