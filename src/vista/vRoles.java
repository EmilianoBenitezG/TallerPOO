package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import modelo.Roles;
import dao.daoRoles;

public class vRoles extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JTextField txtContraseña;
	private JTextField txtNivelAcceso;
	DefaultTableModel modelo = new DefaultTableModel();
	daoRoles dao = new daoRoles();
	ArrayList<Roles> lista;
	private JTable tblRoles;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vRoles frame = new vRoles();
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
	public vRoles() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 668, 404);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(117, 20, 86, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setBounds(61, 23, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Contrase\u00F1a");
		lblNewLabel_1.setBounds(232, 23, 56, 14);
		contentPane.add(lblNewLabel_1);
		
		txtContraseña = new JTextField();
		txtContraseña.setColumns(10);
		txtContraseña.setBounds(300, 20, 86, 20);
		contentPane.add(txtContraseña);
		
		JButton btnNewButton = new JButton("agregar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Roles roles = new Roles();
					roles.setUsuario(txtUsuario.getText());
					roles.setContraseña(txtContraseña.getText());
					roles.setNivelAcceso(txtNivelAcceso.getText());
					daoRoles daoroles = new daoRoles();
					if(daoroles.insertarRoles(roles)) {
						actualizarTabla();
						JOptionPane.showMessageDialog(null, "Se agrego correctamente");
					}else {
						JOptionPane.showMessageDialog(null, "Error al agregar rol");
					}
				}catch(Exception e2){
					JOptionPane.showMessageDialog(null, "Error");
				}
			}
		});
		btnNewButton.setBounds(425, 19, 89, 23);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(61, 97, 558, 257);
		contentPane.add(scrollPane);
		
		tblRoles = new JTable();
		tblRoles.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		scrollPane.setViewportView(tblRoles);
		modelo.addColumn("Usuario");
		modelo.addColumn("Contraseña");
		modelo.addColumn("Nivel de Acceso");
		actualizarTabla();
		txtNivelAcceso = new JTextField();
		txtNivelAcceso.setColumns(10);
		txtNivelAcceso.setBounds(242, 51, 86, 20);
		contentPane.add(txtNivelAcceso);
		setLocationRelativeTo(null);
		JLabel lblNewLabel_1_1 = new JLabel("Nivel de Acceso:\r\n");
		lblNewLabel_1_1.setBounds(149, 54, 95, 14);
		contentPane.add(lblNewLabel_1_1);
	}
	
	public void actualizarTabla() {
		//elimina los registros para volverlos a crear
		while (modelo.getRowCount() > 0) {
			modelo.removeRow(0);
		}
		
		lista=dao.ConsultaRoles();
		
		for (Roles u:lista) {
			Object roles[]= new Object[3];
			roles[0]=u.getUsuario();
			roles[1]=u.getContraseña();
			roles[2]=u.getNivelAcceso();
			modelo.addRow(roles);
		}
		tblRoles.setModel(modelo);
	}
}
