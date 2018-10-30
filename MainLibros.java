import java.awt.Color;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class MainLibros extends JFrame{
	
	JMenuBar bar;
	JMenu item;
	JMenuItem alta;
	JMenuItem baja;
	JMenuItem consulta;
	JMenuItem listados;
	Biblioteca biblio;
	
	public MainLibros () throws ClassNotFoundException, SQLException
	{
		biblio = new Biblioteca();
		bar = new JMenuBar();
		item = new JMenu("Libros");
		alta = new JMenuItem("alta");
		alta.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				
				Libro l = new Libro();
                biblio.agregarLibro(l);
                biblio.listar();
			}
		});
		baja = new JMenuItem("baja");
		baja.addActionListener( new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				
				String isbn = JOptionPane.showInputDialog("Ingrese ISBN: ");
                biblio.eliminarLibro(isbn);
                biblio.listar();
			}
		});
		consulta = new JMenuItem("consulta");
		consulta.addActionListener( new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				 String isbn = JOptionPane.showInputDialog("Ingrese ISBN: ");
                 Libro l = biblio.consultarLibro(isbn);
                 if (l == null)
              	   JOptionPane.showMessageDialog(null,isbn + " libro inexistente");
                 else
             	   JOptionPane.showMessageDialog(null, "libro consultado: \n"+ l);                
				
			}
		});
		listados = new JMenuItem("listados");
		item.add(alta);
		item.add(baja);
		item.add(consulta);
		item.add(listados);
		bar.add(item);
		setJMenuBar(bar);
		setSize(400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
    public static void main(String[] args) throws ClassNotFoundException, SQLException
    {

    	  new MainLibros();

  }
}
