

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javax.swing.JButton;





import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import com.toedter.calendar.JDateChooser;
import com.toedter.components.JLocaleChooser;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Font;


/**
 * @bappy
 */
public class updateMeal extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JDateChooser dateChooser;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public updateMeal() {
		
		setVisible(true);
		setTitle("Meal Update");
		setResizable(false);
		setBounds(100, 100, 552, 463);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setForeground(Color.GREEN);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(31, 63, 86, 42);
		contentPane.add(lblNewLabel);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblQuantity.setBounds(356, 40, 94, 24);
		contentPane.add(lblQuantity);
		
		Calendar cc=new GregorianCalendar();
		int hh=cc.get(Calendar.DATE);
		int mm=cc.get(Calendar.MONTH);
		int ss=cc.get(Calendar.YEAR);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setForeground(Color.GREEN);
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDate.setBounds(31, 139, 86, 42);
		contentPane.add(lblDate);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Sylfaen", Font.BOLD, 15));
		textField_1.setColumns(10);
		textField_1.setBounds(353, 94, 97, 30);
		contentPane.add(textField_1);
		
		String[] names={"Niloy","Arif","Sohan","Jubayer","Shanto"};
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                  
				dbConnection1 ob=new dbConnection1();
				
				SimpleDateFormat dFormat=new SimpleDateFormat("dd-MM-yy");
				String date1=dFormat.format(dateChooser.getDate());
				
				
				Connection conn = null; 
				conn=ob.getConnection();
				
				Statement statement = null;
				
				
				String bb=(String)comboBox.getSelectedItem();
				
				String query = "select qnty from Meal_tb where name='"+bb+"' AND date='"+date1+"' ";
		        try{
		        	String name,date;
		        	float qnty;
		        	
		            
		        	statement=conn.createStatement();
		        	
		        	  ResultSet rs = statement.executeQuery(query); //execute query
		        	  
		     		 while (rs.next()) {
		     			 
		     			 qnty=rs.getFloat("qnty");
		     		  
		        	 
		       //     JOptionPane.showMessageDialog(null, "Searched successfully and value is: "+qnty);
		            textField_1.setText(Float.toString(qnty));
		            
		            	statement.close(); 
		     		 	conn.close(); //close connection
		     		 }
			 }
				catch(Exception e){
				System.out.println(e.toString()); } 
			
			
			}
		});
		btnNewButton.setBounds(31, 294, 124, 42);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setForeground(Color.CYAN);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			Main1 ob=new Main1();
			dispose();
			}
		});
		btnNewButton_1.setBounds(186, 294, 101, 42);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Update");
		btnNewButton_2.setForeground(Color.RED);
		btnNewButton_2.setFont(new Font("Sylfaen", Font.BOLD, 15));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				
				SimpleDateFormat dFormat=new SimpleDateFormat("dd-MM-yy");
				String date1=dFormat.format(dateChooser.getDate());
		       
				dbConnection1 ob=new dbConnection1();
				
				
				Connection conn = null; 
				conn=ob.getConnection();
				
				PreparedStatement preparedStatement = null;
				
				
				
				String query = "update Meal_tb set qnty=? where name=? AND date=?";
		        try{
		        	String bb=(String)comboBox.getSelectedItem();
		        	
		        	preparedStatement= conn.prepareStatement(query);
		        	
		       
		            preparedStatement.setFloat(1,Float.parseFloat(textField_1.getText()));
		            preparedStatement.setString(2,bb);
		            preparedStatement.setString(3,date1);
		            
		     //    System.out.print(dateChooser.toString());
		            
		            preparedStatement.executeUpdate();
		            
		            JOptionPane.showMessageDialog(null, "Updated successfully");
	//	            System.out.println(dateChooser.getDate());
		            preparedStatement.close(); 
				    conn.close(); //close connection
			 }
				catch(Exception e){
				System.out.println(e.toString()); } 
			}
		});
		btnNewButton_2.setBounds(345, 279, 124, 57);
		contentPane.add(btnNewButton_2);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(132, 139, 130, 42);
		contentPane.add(dateChooser);
		
		comboBox = new JComboBox(names);
		comboBox.setFont(new Font("Sylfaen", Font.BOLD, 15));
		comboBox.setBounds(134, 63, 128, 42);
		contentPane.add(comboBox);
	}
}
