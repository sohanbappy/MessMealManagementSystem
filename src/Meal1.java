import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;



import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;


/**
 * @bappy
 */
public class Meal1 extends JFrame {

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
	public Meal1() {
		
		setVisible(true);
		setTitle("Meal Entry");
		setResizable(false);
		setBounds(100, 100, 583, 435);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Member");
		lblNewLabel.setForeground(Color.GREEN);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(40, 40, 86, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setForeground(Color.GREEN);
		lblQuantity.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblQuantity.setBounds(40, 108, 86, 31);
		contentPane.add(lblQuantity);
		
		Calendar cc=new GregorianCalendar();
		int hh=cc.get(Calendar.DATE);
		int mm=cc.get(Calendar.MONTH);
		int ss=cc.get(Calendar.YEAR);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setForeground(Color.GREEN);
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDate.setBounds(55, 179, 71, 39);
		contentPane.add(lblDate);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(179, 108, 129, 39);
		contentPane.add(textField_1);
		
		String[] names={"Niloy","Arif","Sohan","Jubayer","Shanto"};
		comboBox = new JComboBox(names);
		comboBox.setFont(new Font("Sylfaen", Font.BOLD, 15));
		comboBox.setBounds(179, 40, 129, 39);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setFont(new Font("Sylfaen", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                  
				dbConnection1 ob=new dbConnection1();
				SimpleDateFormat dFormat=new SimpleDateFormat("dd-MM-yy");
				String date1=dFormat.format(dateChooser.getDate());
				
				Connection conn = null; 
				conn=ob.getConnection();
				
				PreparedStatement preparedStatement = null;
				
				
				
				String query = "insert into Meal_tb(name,qnty,date) values (?,?,?)";
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
		btnNewButton.setBounds(197, 289, 190, 45);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setForeground(Color.CYAN);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			Main1 ob=new Main1();
			dispose();
			}
		});
		btnNewButton_1.setBounds(376, 59, 129, 39);
		contentPane.add(btnNewButton_1);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(179, 179, 129, 39);
		contentPane.add(dateChooser);
	}
}
