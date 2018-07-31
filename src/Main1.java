import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;


/**
 * @bappy
 */
public class Main1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Main1() {
		
		setVisible(true);
		setTitle("Options");
		setResizable(false);
		setBounds(100, 100, 628, 495);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnMore = new JMenu("More");
		menuBar.add(mnMore);
		
		JMenuItem mntmUpdateMeal = new JMenuItem("Update Meal");
		mntmUpdateMeal.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				updateMeal ob=new updateMeal();
			}
		});
		mnMore.add(mntmUpdateMeal);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Meal");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			Meal1 ob=new Meal1();
			dispose();
			}
		});
		btnNewButton.setBounds(52, 37, 162, 64);
		contentPane.add(btnNewButton);
		
		JButton btnBazar = new JButton("Bazar");
		btnBazar.setForeground(Color.BLACK);
		btnBazar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBazar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			Bazar1 ob=new Bazar1();
			dispose();
			}
		});
		btnBazar.setBounds(406, 37, 162, 64);
		contentPane.add(btnBazar);
		
		JButton btnBalacesheet = new JButton("Balance");
		btnBalacesheet.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBalacesheet.setForeground(Color.BLACK);
		btnBalacesheet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			Balance1 ob=new Balance1();
			dispose();
			}
		});
		btnBalacesheet.setBounds(52, 155, 162, 64);
		contentPane.add(btnBalacesheet);
		
		JButton btnShop = new JButton("MAMA");
		btnShop.setForeground(Color.BLACK);
		btnShop.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnShop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			Mama1 ob=new Mama1();
			dispose();
			}
		});
		btnShop.setBounds(406, 155, 162, 64);
		contentPane.add(btnShop);
		
		JButton btnReport = new JButton("Report");
		btnReport.setForeground(Color.RED);
		btnReport.setFont(new Font("Sylfaen", Font.BOLD, 15));
		btnReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			Report2 ob=new Report2();
			dispose();
			}
		});
		btnReport.setBounds(52, 277, 162, 79);
		contentPane.add(btnReport);
		
		JButton btnBack = new JButton("Log Out");
		btnBack.setForeground(Color.RED);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Home1 ob=new Home1();
			JOptionPane.showMessageDialog(null,"Successfully Log out !!");
			}
		});
		btnBack.setBounds(257, 11, 88, 30);
		contentPane.add(btnBack);
		
		JButton btnNewButton_1 = new JButton("Update meal");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			updateMeal ob=new updateMeal();
			dispose();
			
			}
		});
		btnNewButton_1.setFont(new Font("Sylfaen", Font.BOLD, 15));
		btnNewButton_1.setForeground(Color.RED);
		btnNewButton_1.setBounds(411, 277, 157, 72);
		contentPane.add(btnNewButton_1);
	}
}
