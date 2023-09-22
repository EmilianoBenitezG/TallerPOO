package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Window.Type;

public class vLogin extends JFrame {

	private JPanel contentPane;
	private final JLabel lblTitulo = new JLabel("Sistema de Triaje");
	private JTextField txtUsuario;
	private JTextField txtContraseña;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vLogin frame = new vLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public vLogin() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 865, 561);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblTitulo.setFont(new Font("Source Sans Pro SemiBold", Font.PLAIN, 40));
		lblTitulo.setBounds(268, 125, 314, 51);
		contentPane.add(lblTitulo);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Source Sans Pro SemiBold", Font.BOLD | Font.ITALIC, 22));
		lblUsuario.setBounds(309, 199, 98, 39);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:\r\n");
		lblContrasea.setFont(new Font("Source Sans Pro SemiBold", Font.BOLD | Font.ITALIC, 22));
		lblContrasea.setBounds(272, 249, 122, 39);
		contentPane.add(lblContrasea);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(407, 209, 130, 23);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtContraseña = new JTextField();
		txtContraseña.setColumns(10);
		txtContraseña.setBounds(407, 259, 130, 23);
		contentPane.add(txtContraseña);
		
		JButton btnIngresar = new JButton("INGRESAR");
		btnIngresar.setFont(new Font("Source Sans Pro SemiBold", Font.BOLD, 15));
		btnIngresar.setBounds(370, 314, 122, 31);
		contentPane.add(btnIngresar);
		setLocationRelativeTo(null);
	}
}
