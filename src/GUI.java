import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

@SuppressWarnings("unused")
public class GUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField_nombre;
	private JTextField textField_correo;
	private JTextField textField_pedido;

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
		setBounds(100, 100, 550, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Farmacias Conkal");
		lblNewLabel.setBounds(44, 23, 423, 31);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		contentPane.add(lblNewLabel);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(100, 81, 61, 14);
		lblNombre.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		contentPane.add(lblNombre);
		
		JLabel lblCorreo = new JLabel("Correo ");
		lblCorreo.setBounds(100, 141, 61, 14);
		lblCorreo.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		contentPane.add(lblCorreo);
		
		JLabel lblPedido = new JLabel("Pedido");
		lblPedido.setBounds(100, 204, 61, 14);
		lblPedido.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		contentPane.add(lblPedido);
		
		textField_nombre = new JTextField();
		textField_nombre.setBounds(100, 110, 313, 20);
		textField_nombre.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		contentPane.add(textField_nombre);
		textField_nombre.setColumns(10);
		
		textField_correo = new JTextField();
		textField_correo.setBounds(100, 166, 313, 20);
		textField_correo.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		textField_correo.setColumns(10);
		contentPane.add(textField_correo);
		
		textField_pedido = new JTextField();
		textField_pedido.setBounds(100, 227, 313, 20);
		textField_pedido.setFont(new Font("Tw Cen MT", Font.PLAIN, 15));
		textField_pedido.setColumns(10);
		contentPane.add(textField_pedido);
		
		JButton btnESCRIBIR = new JButton("Escribir");
		btnESCRIBIR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					BufferedWriter  out =new BufferedWriter(new FileWriter("PEDIDOS.txt"));
					String  textNom = textField_nombre.getText();
					String textCor = textField_correo.getText();
					String textPedido = textField_pedido.getText();
					
					String  cadena = ("Cliente:" + " " + textNom + " " + "  " + "Correo electrónico:" + "  " + textCor + " " + "Pedido:" + " " + textPedido );
				    
					
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
		btnESCRIBIR.setBounds(55, 273, 89, 23);
		contentPane.add(btnESCRIBIR);
		
		JButton btnLeer = new JButton("Leer");
		btnLeer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String texto= "";
				try {
					BufferedReader in = new BufferedReader(new FileReader("MEDICINAS.txt"));
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
		btnLeer.setBounds(227, 274, 89, 23);
		contentPane.add(btnLeer);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_nombre.setText("");
				textField_correo.setText("");
				textField_pedido.setText("");
			}
		});
		btnLimpiar.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		btnLimpiar.setBounds(227, 308, 89, 23);
		contentPane.add(btnLimpiar);
		
		JButton btnObjeto = new JButton("Objeto");
		btnObjeto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String textnom = textField_nombre.getText();
				String textcor = textField_correo.getText();
				String textped = textField_pedido.getText();

				
				Persona objpersona = new Persona(textnom,textcor,textped); 
				JOptionPane.showMessageDialog(btnObjeto, "Mi objeto tiene lo siguiente:"+ ""+ objpersona, null, JOptionPane.INFORMATION_MESSAGE);
				
				
			}
		});
		btnObjeto.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		btnObjeto.setBounds(378, 273, 89, 23);
		contentPane.add(btnObjeto);
		
		
	}
}
