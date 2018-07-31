import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;


/**
 * @bappy
 */
public class Mama1 extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JComboBox  comboBox;
	private JDateChooser dateChooser;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Mama1() {
		
		setVisible(true);
		setTitle("Shop(MAMA)");
		setResizable(false);
		setBounds(100, 100, 611, 426);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Calendar cc=new GregorianCalendar();
		int hh=cc.get(Calendar.DATE);
		int mm=cc.get(Calendar.MONTH);
		int ss=cc.get(Calendar.YEAR);
		
		JLabel lblNewLabel = new JLabel("Date");
		lblNewLabel.setForeground(Color.GREEN);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(39, 37, 88, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblDue = new JLabel("Due");
		lblDue.setForeground(Color.GREEN);
		lblDue.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDue.setBounds(39, 106, 88, 28);
		contentPane.add(lblDue);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(164, 106, 137, 28);
		contentPane.add(textField_1);
		
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
				
				
				
				String query = "insert into MAMA_tb(date,due,name) values (?,?,?)";
		        try{
		            
		        	preparedStatement= conn.prepareStatement(query);
		        	String aa=(String)comboBox.getSelectedItem();
		        	
		        	preparedStatement.setString(1,date1);
		        	preparedStatement.setFloat(2,Float.parseFloat(textField_1.getText()));
		            preparedStatement.setString(3,aa);
		           
		            
		            preparedStatement.executeUpdate();
		            
		            JOptionPane.showMessageDialog(null, "Inserted successfully");
		        preparedStatement.close(); 
				conn.close(); //close connection
			 }
				catch(Exception e){
				System.out.println(e.toString()); } 
			
			
			
			}
		});
		btnNewButton.setBounds(169, 287, 198, 53);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setForeground(Color.CYAN);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main1 ob=new Main1();
				dispose();
			}
		});
		btnNewButton_1.setBounds(437, 92, 89, 42);
		contentPane.add(btnNewButton_1);
		
		JLabel lblMember = new JLabel("Member");
		lblMember.setForeground(Color.GREEN);
		lblMember.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMember.setBounds(40, 179, 114, 37);
		contentPane.add(lblMember);
		
		String[] names={"Niloy","Arif","Sohan","Jubayer","Shanto"};
		comboBox = new JComboBox(names);
		comboBox.setFont(new Font("Sylfaen", Font.BOLD, 15));
		comboBox.setBounds(164, 179, 137, 37);
		contentPane.add(comboBox);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(164, 37, 137, 28);
		contentPane.add(dateChooser);
	}
}
