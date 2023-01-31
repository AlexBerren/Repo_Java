package formularioLibro;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Formulario {

	private static Set<Libro> libros= new TreeSet<Libro>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		JFrame jframe= new JFrame("Formulario Libros");//siempre seguiremos este orden de creacion
		Container container=jframe.getContentPane();
		JPanel centroJPanel =  new JPanel();
		container.add(centroJPanel,BorderLayout.CENTER);
		JPanel surJPanel = new JPanel();
		container.add(surJPanel,BorderLayout.SOUTH);
		GridLayout centroGridLayout = new GridLayout(2,2);
		centroJPanel.setLayout(centroGridLayout);
		JLabel codigoJLabel = new JLabel("codgio: ");
		centroJPanel.add(codigoJLabel);
		codigoJLabel.setHorizontalAlignment(JLabel.RIGHT);
		JTextField codigoTF = new JTextField();
		centroJPanel.add(codigoTF);
		JLabel tituloJLabel = new JLabel("titulo: ");
		centroJPanel.add(tituloJLabel);
		tituloJLabel.setHorizontalAlignment(JLabel.RIGHT);
		JTextField tituloTF = new JTextField();
		centroJPanel.add(tituloTF);
		centroJPanel.setBorder(new EmptyBorder(40,10,40,100));
		
		JButton guardar = new JButton("Guardar");
		guardar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try{
				Integer.parseInt(codigoTF.getText());
				if(codigoTF.getText().length()!=4) {
					JOptionPane.showMessageDialog(centroJPanel, "ERROR DE Formato","ERROR",JOptionPane.ERROR_MESSAGE);

				}else {
					guardar(codigoTF.getText(), tituloTF.getText());
				}
				
				codigoTF.setText("");
				tituloTF.setText("");
			}catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(centroJPanel, "El campo debe ser numerico","ERROR",JOptionPane.ERROR_MESSAGE);

			}}
		});
		surJPanel.add(guardar);
		JButton salir = new JButton("Salir");
		salir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					salir();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(centroJPanel, "ERROR DE FICHERO","ERROR",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		surJPanel.add(salir);
		
		
		jframe.setVisible(true);
		jframe.pack();
		jframe.setSize(600,200);
	}
	
	public static void guardar(String codigo, String titulo) {
		libros.add(new Libro(codigo,titulo));
	}
	
	public static void salir() throws IOException {
		File file = new File("libros.dat");
		FileWriter fr = new FileWriter(file);
		BufferedWriter bf = new BufferedWriter(fr);
		
		for (Libro libro : libros) {
			bf.write(libro.getCodigo()+";"+libro.getTitulo()+";");
			bf.newLine();
		}
		bf.close();
	}

}
