import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;


/**
 * @bappy
 */
public class About extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public About() {
		
		setVisible(true);
		setTitle("About");
		setResizable(false);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sohan Bappy");
		lblNewLabel.setFont(new Font("Sylfaen", Font.BOLD, 15));
		lblNewLabel.setBounds(148, 32, 118, 33);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			Home1 ob=new Home1();
			dispose();
			}
		});
		btnNewButton.setBounds(108, 196, 203, 33);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("sohanbappy@gmail.com");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setBounds(139, 77, 172, 28);
		contentPane.add(lblNewLabel_1);
	}
}
