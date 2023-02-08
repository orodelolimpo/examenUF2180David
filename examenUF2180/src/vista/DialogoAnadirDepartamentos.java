package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import controlador.Controlador;
import modelo.Centro;
import modelo.Departamento;
import net.miginfocom.swing.MigLayout;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;

public class DialogoAnadirDepartamentos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtCentro;
	private JTextField txtPresupuesto;
	private final ButtonGroup BotonesDireccion = new ButtonGroup();
	private JTextField txtCodCentro;
	private AbstractButton txtCodDepartamento;
	private JRadioButton rdbPropiedad;
	private JRadioButton rdbtFunciones;
	private Object controlador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogoAnadirDepartamentos dialog = new DialogoAnadirDepartamentos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogoAnadirDepartamentos() {
		setTitle("Insertar Departamento");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[grow]", "[grow]"));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Detalles del centro", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			((TitledBorder)  panel.getBorder()).setTitleFont(new Font("Tahoma", Font.PLAIN, 14));
			contentPanel.add(panel, "cell 0 0,grow");
			panel.setLayout(new MigLayout("", "[][][grow][grow]", "[22.00][12.00][][8.00][][][][][]"));
			{
				JLabel lblNewLabel_3 = new JLabel("");
				lblNewLabel_3.setIcon(new ImageIcon(DialogoAnadirCentro.class.getResource("/images/editar32.png")));
				panel.add(lblNewLabel_3, "cell 0 0 1 7");
			}
			{
				JLabel lblNewLabel = new JLabel("C\u00F3digo:");
				panel.add(lblNewLabel, "cell 1 0,alignx trailing");
				lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			}
			{
				txtCodCentro = new JTextField();
				panel.add(txtCodCentro, "cell 2 0 2 1,growx");
				txtCodCentro.setFont(new Font("Tahoma", Font.PLAIN, 14));
				txtCodCentro.setColumns(10);
			}
			{
				JLabel lblNewLabel_4 = new JLabel("Centro:");
				lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
				panel.add(lblNewLabel_4, "cell 1 2,alignx trailing");
			}
			{
				txtCentro = new JTextField();
				panel.add(txtCentro, "cell 2 2 2 1,grow");
				txtCentro.setColumns(10);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Tipo Dirección:");
				lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
				panel.add(lblNewLabel_1, "cell 1 4,alignx trailing");
				lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			}
			{
				rdbPropiedad = new JRadioButton("Propiedad");
				BotonesDireccion.add(rdbPropiedad);
				rdbPropiedad.setSelected(true);
				rdbPropiedad.setFont(new Font("Tahoma", Font.PLAIN, 14));
				panel.add(rdbPropiedad, "cell 2 4");
			}
			{
				rdbtFunciones = new JRadioButton("En funciones");
				BotonesDireccion.add(rdbtFunciones);
				rdbtFunciones.setFont(new Font("Tahoma", Font.PLAIN, 14));
				panel.add(rdbtFunciones, "cell 3 4");
			}
			{
				JLabel lblNewLabel_2 = new JLabel("Presupuesto:");
				panel.add(lblNewLabel_2, "cell 1 6,alignx trailing");
				lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
			}
			{
				{
					txtPresupuesto = new JTextField();
					panel.add(txtPresupuesto, "cell 2 6,growx");
					txtPresupuesto.setColumns(10);
				}
				{
					JLabel lblNewLabel_5 = new JLabel("(en miles de €)");
					lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
					panel.add(lblNewLabel_5, "cell 3 6");
				}
				{
					JLabel lblNewLabel_1 = new JLabel("Nombre:");
					lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
					panel.add(lblNewLabel_1, "cell 1 8,alignx trailing");
				}
				{
					txtNombre = new JTextField();
					panel.add(txtNombre, "cell 2 8 2 1,growx");
					txtNombre.setColumns(10);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						recogerDatos();
					}
				});
				okButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}


	protected void recogerDatos() {
		int cod_departamento = Integer.parseInt(txtCodDepartamento.getText());
		int centro = Integer.parseInt(txtCentro.getText());
		//String direccion =rdbPropiedad;
		int presupuesto=Integer.parseInt(txtPresupuesto.getText());
		String nombre= txtNombre.getText();;
		
		Departamento departamento = new Departamento(cod_departamento, centro, nombre, presupuesto, nombre);
		
		controlador.insertaDepartamento(departamento);
		
	}


	public void setControlador(Controlador controlador) {
		this.controlador=controlador;
	}

}
