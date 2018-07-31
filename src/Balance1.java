import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;


/**
 * @bappy
 */
public class Balance1 extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JComboBox comboBox;
	private JDateChooser dateChooser;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Balance1() {
		
		setVisible(true);
		setTitle("Personal Balance");
		setResizable(false);
		setBounds(100, 100, 559, 425);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Member");
		lblNewLabel.setForeground(Color.GREEN);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(42, 35, 97, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblDeposit = new JLabel("Deposit");
		lblDeposit.setForeground(Color.GREEN);
		lblDeposit.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDeposit.setBounds(42, 84, 105, 31);
		contentPane.add(lblDeposit);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(157, 84, 144, 31);
		contentPane.add(textField_1);
		
		 String[] names={"Niloy","Arif","Sohan","Jubayer","Shanto"};
		 
		comboBox = new JComboBox(names);
		comboBox.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		comboBox.setBounds(157, 37, 144, 26);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.setFont(new Font("Sylfaen", Font.BOLD, 15));
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setBounds(177, 269, 180, 40);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dbConnection1 ob=new dbConnection1();
				SimpleDateFormat dFormat=new SimpleDateFormat("dd-MM-yy");
				String date1=dFormat.format(dateChooser.getDate());
				
				Connection conn = null; 
				conn=ob.getConnection();
				
				PreparedStatement preparedStatement = null;
				
				
				
				String query = "insert into Balance_tb(name,deposit,date) values (?,?,?)";
		        try{
		            
		        	preparedStatement= conn.prepareStatement(query);
		        	String aa=(String)comboBox.getSelectedItem();
		        	
		            preparedStatement.setString(1,aa);
		            preparedStatement.setFloat(2,Float.parseFloat(textField_1.getText()));
		            preparedStatement.setString(3,date1);
		           
		            
		            preparedStatement.executeUpdate();
		            
		            JOptionPane.showMessageDialog(null, "Inserted successfully");
		        preparedStatement.close(); 
				conn.close(); //close connection
			 }
				catch(Exception e){
				System.out.println(e.toString()); } 
			
			
			
			}
		});
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setForeground(Color.CYAN);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			Main1 ob=new Main1();
			dispose();
			}
		});
		btnNewButton_1.setBounds(403, 79, 89, 40);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Date");
		lblNewLabel_1.setForeground(Color.GREEN);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(42, 140, 74, 31);
		contentPane.add(lblNewLabel_1);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(157, 140, 144, 31);
		contentPane.add(dateChooser);
	}
}
