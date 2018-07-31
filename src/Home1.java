import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;



import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Font;


/**
 * @bappy
 */
public class Home1 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	Home1 ob=new Home1();
	}

	/**
	 * Create the frame.
	 */
	public Home1() {
		
		setVisible(true);
		setTitle("Meal Management");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 577, 439);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("UserName");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setForeground(Color.GREEN);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(24, 76, 99, 42);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		textField.setBounds(181, 83, 137, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("Sylfaen", Font.BOLD, 15));
		btnNewButton.setForeground(Color.RED);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(textField.getText().equals("root") && passwordField.getText().equals("1234"))
				{
				
			dispose();
			Main1 ob1=new Main1();
		
		}
				else{
					JOptionPane.showMessageDialog(null,"Username and Password doesn't match !!");
				}
			}
		});
		btnNewButton.setBounds(181, 273, 184, 46);
		contentPane.add(btnNewButton);
		
		JLabel lblPassword = new JLabel("PassWord");
		lblPassword.setForeground(Color.GREEN);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPassword.setBackground(Color.WHITE);
		lblPassword.setBounds(24, 164, 128, 38);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(181, 169, 137, 29);
		contentPane.add(passwordField);
		
		JButton btnNewButton_1 = new JButton("About");
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setFont(new Font("Sylfaen", Font.BOLD, 14));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			About ob=new About();
			dispose();
			}
		});
		btnNewButton_1.setBounds(414, 63, 99, 55);
		contentPane.add(btnNewButton_1);
	}
}
