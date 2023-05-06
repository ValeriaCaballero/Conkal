import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.ImageIcon;


//Balam Batun Maria del Carmen
//Barrera Vazquez Esteban
//Caballero Góngora Valeria Isabel 

@SuppressWarnings("unused")
public class GUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField_nombre;
	private JTextField textField_correo;
	
	Medicinas seleccionado; 
	
    DefaultComboBoxModel combomedicinas = new DefaultComboBoxModel();
	
	public Medicinas arreglomedicinas[]= {
			new Medicinas ("Elige tu pedido ",0),
			new Medicinas ("Paracetamol", 30),		
			new Medicinas ("Ibuprofeno", 45),
			new Medicinas ("Aspirina", 40),
			new Medicinas ("Ramipril", 55),
			new Medicinas ("Omeprazol", 120),
			new Medicinas ("Salbutamol", 60),
			new Medicinas ("Loratadina", 30),
			new Medicinas ("Levotiroxina", 60),
	}; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 414);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(205, 254, 249));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Farmacias Conkal");
		lblNewLabel.setBounds(44, 23, 423, 31);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		contentPane.add(lblNewLabel);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(100, 65, 61, 14);
		lblNombre.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		contentPane.add(lblNombre);
		
		JLabel lblCorreo = new JLabel("Correo ");
		lblCorreo.setBounds(100, 125, 61, 14);
		lblCorreo.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		contentPane.add(lblCorreo);
		
		JLabel lblPedido = new JLabel("Pedido");
		lblPedido.setBounds(100, 188, 61, 14);
		lblPedido.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		contentPane.add(lblPedido);
		
		textField_nombre = new JTextField();
		textField_nombre.setForeground(new Color(0, 0, 0));
		textField_nombre.setBackground(new Color(223, 223, 223));
		textField_nombre.setBounds(100, 94, 313, 20);
		textField_nombre.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		contentPane.add(textField_nombre);
		textField_nombre.setColumns(10);
		
		textField_correo = new JTextField();
		textField_correo.setBackground(new Color(223, 223, 223));
		textField_correo.setBounds(100, 150, 313, 20);
		textField_correo.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		textField_correo.setColumns(10);
		contentPane.add(textField_correo);
		
		JLabel lblPrecioPorPieza = new JLabel("Precio por pieza");
		lblPrecioPorPieza.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		lblPrecioPorPieza.setBounds(100, 213, 110, 14);
		contentPane.add(lblPrecioPorPieza);
		
		JLabel lblprecio = new JLabel("...");
		lblprecio.setHorizontalAlignment(SwingConstants.CENTER);
		lblprecio.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		lblprecio.setBounds(255, 213, 61, 14);
		contentPane.add(lblprecio);
		
		JLabel lblTOTAL = new JLabel("...");
		lblTOTAL.setHorizontalAlignment(SwingConstants.CENTER);
		lblTOTAL.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		lblTOTAL.setBounds(192, 265, 83, 14);
		contentPane.add(lblTOTAL);
		
		JLabel lblPrecioTotal = new JLabel("Precio Total");
		lblPrecioTotal.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		lblPrecioTotal.setBounds(100, 265, 110, 14);
		contentPane.add(lblPrecioTotal);
		
		JLabel lblColocaElNmero = new JLabel("Coloca el número de piezas a comprar");
		lblColocaElNmero.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		lblColocaElNmero.setBounds(100, 238, 248, 14);
		contentPane.add(lblColocaElNmero);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				seleccionado=(Medicinas)comboBox.getSelectedItem();
				
				lblprecio.setText(String.valueOf(seleccionado.getPrecio()));
			}
		});
		comboBox.setBounds(157, 185, 191, 17);
		contentPane.add(comboBox);
		
		for(int i=0; i<arreglomedicinas.length; i++)
			combomedicinas.addElement(arreglomedicinas[i]);
		comboBox.setModel(combomedicinas);
		
		JButton btnESCRIBIR = new JButton("Agregar Pedido");
		btnESCRIBIR.setBackground(new Color(128, 128, 255));
		btnESCRIBIR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					BufferedWriter  out =new BufferedWriter(new FileWriter("PEDIDOS.txt"));
					String textTotal= lblTOTAL.getText();
					String textNom = textField_nombre.getText();
					String textCor = textField_correo.getText();
					String textPedido =comboBox.getSelectedItem().toString();
					String cadena = ("Cliente:" + " " + textNom + " " + "  " + "Correo electrónico:" + "  " 
					+ textCor + " " + "Pedido:" + " " + textPedido+ " El total de la compra es: "+ textTotal );
				
				
				out.newLine();
				out.write(cadena); 
				out.close();
				} catch (IOException o) {
					System.out.println(o.getMessage());
					o.printStackTrace();

				}
			}	
		});
		btnESCRIBIR.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		btnESCRIBIR.setBounds(64, 307, 132, 23);
		contentPane.add(btnESCRIBIR);
		
		JButton btnLeer = new JButton("Leer ");
		btnLeer.setBackground(new Color(128, 128, 255));
		btnLeer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String texto= "";
				try {
					BufferedReader in = new BufferedReader(new FileReader("PEDIDOS.txt"));
					String linea = in.readLine();
					
					while(linea!=null)
					{
					texto =texto + linea+ '\n';
					linea = in.readLine();
					}
					JOptionPane.showMessageDialog(btnLeer, texto);
				
					in.close();
				}catch(IOException exception) {
					System.out.println(exception.getMessage());
				}
			}
		
		});
		btnLeer.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		btnLeer.setBounds(237, 307, 89, 23);
		contentPane.add(btnLeer);
		
		JButton btnLimpiar = new JButton("Ingresar nuevo");
		btnLimpiar.setBackground(new Color(128, 128, 255));
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_nombre.setText("");
				textField_correo.setText("");
				
				lblprecio.setText(null); 
				lblTOTAL.setText(null); 
			}
		});
		btnLimpiar.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		btnLimpiar.setBounds(214, 341, 132, 23);
		contentPane.add(btnLimpiar);
		
		JButton btnObjeto = new JButton("Objeto");
		btnObjeto.setBackground(new Color(128, 128, 255));
		btnObjeto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String textNom = textField_nombre.getText();
				String textCor = textField_correo.getText();
				String textPedido =comboBox.getSelectedItem().toString();
				
				Persona objpersona = new Persona(textNom,textCor,textPedido); 
				JOptionPane.showMessageDialog(contentPane, "Mi objeto tiene lo siguiente:"+ ""+ objpersona, null, JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnObjeto.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		btnObjeto.setBounds(378, 307, 89, 23);
		contentPane.add(btnObjeto);
		
		JButton btnComprar = new JButton("Elegir");
		btnComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num = Integer.parseInt(JOptionPane.showInputDialog(contentPane, "¿Cuál es la cantidad quiere comprar?"));
				int total = seleccionado.getPrecio() * num; 
				
				lblTOTAL.setText(String.valueOf(total));
				
			}
		});
		btnComprar.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		btnComprar.setBackground(new Color(128, 128, 255));
		btnComprar.setBounds(354, 232, 77, 23);
		contentPane.add(btnComprar);
		
		JLabel imagen = new JLabel("");
		imagen.setIcon(new ImageIcon("Media/Zanahoria2.png"));
		imagen.setBounds(443, 23, 83, 92);
		contentPane.add(imagen);
		
		}
	}//ULTIMO

