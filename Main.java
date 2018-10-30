import javax.swing.JOptionPane;


public class Main {
	public static Libro ingresarLibro()
    {
  	  String l = JOptionPane.showInputDialog("ingrese libro: ");
  	  return new Libro(l);	  
    }
    public static void main(String[] args) {
    	
    	/*Comparable <Libro> l = new Libro("tom sawyer,mark twain,1111,2");
    	Comparable <Libro> m = new Libro("keraban, julio verne,2222,3");*/
    	Libro l = new Libro("tom sawyer,mark twain,1111,2");
    	Libro m = new Libro("keraban, julio verne,2222,3");
    	if (l.compareTo(l) == 0)
    		System.out.println("son iguales");
    	else
    		System.out.println("no son iguales");
    		
	    /* Biblioteca b = new Biblioteca();
	     Libro l = null;
	     String op = null;
	     do {
	          op = JOptionPane.showInputDialog("Biblioteca Sandokan \n1-Ingresar Libro\n" +
	          		"2-Consultar Libro\n3-Eliminar Libro\n4-Listar libros\n5-fin\n\n" +
	          		"ingrese opcion? ");
	          
	          switch (op.charAt(0))
	          {
	             case '1': l = ingresarLibro();
	                       b.agregarLibro(l);
	                       break;
	             case '2': String isbn = JOptionPane.showInputDialog("Ingrese ISBN: ");
	                       l = b.consultarLibro(isbn);
	                       if (l == null)
	                    	   JOptionPane.showMessageDialog(null,isbn + "libro inexistente");
	                       else
	                    	   JOptionPane.showMessageDialog(null, "libro consultado: \n"+ l);
	                       break;
	             case '3': isbn = JOptionPane.showInputDialog("Ingrese ISBN: ");
                           b.eliminarLibro(isbn);
                           break;
	             case '4': b.listar();
	                       break;
	             case '5': JOptionPane.showMessageDialog(null, "Chau");
	          }
	   }while (op.charAt(0) <= '4' && op.charAt(0) >= '1');*/
    }
}
