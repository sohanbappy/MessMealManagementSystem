
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;








/**
 * @bappy
 */
public class Report2 extends JFrame {

	private JPanel contentPane;
	private JTextField textField,textField_1,textField_2,textField_3,textField_4,textField_5,textField_6;
	
	
	
	

	private Float total;
	
	 String nMeal;
	 double deposit,pmeal;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	
	
	
	public void report1(String sql){
		try{
			Connection con= null; 
			Statement statement = null;

		//	String query1 = "select SUM(qnty) from Meal_tb";
			dbConnection1 ob=new dbConnection1();
			ResultSet rs1;
			con=ob.getConnection();
			statement=con.createStatement();
					
					//execute query	
			  rs1=statement.executeQuery(sql);
			  while (rs1.next()) {
				 total = rs1.getFloat(1);
		     //    sum1 =sum1+ qnty;
			 }
	
		//	 System.out.println("Record selected successfully.");
				
				
				
			 statement.close();
			con.close(); //close connection
			
			
			
		}
			
			catch(Exception e)
			{JOptionPane.showMessageDialog(null,e);}
	}
	public void report2(String sql2){
		try {
			
			Connection con= null; 
			Statement statement = null;

		//	String query1 = "select SUM(qnty) from Meal_tb";
			dbConnection1 ob=new dbConnection1();
			ResultSet rs0;
			
			con=ob.getConnection();
			statement=con.createStatement();
					
					//execute query	
			  rs0=statement.executeQuery(sql2);
			  
			  while (rs0.next()) {
				 nMeal =Float.toString(rs0.getFloat(1));
		     
			 }
		//		 System.out.println("Record selected successfully.");
				 statement.close();
				 con.close(); //close connection
			 
			}	
			 catch (Exception e2) {
				// TODO: handle exception
			
			 }	
	}
	
	public Report2() {
		
	//	display();
		String query1 = "select SUM(qnty) from Meal_tb";
		report1(query1);
		double qnty=total;
	//	System.out.println("Total Meal: "+qnty);
		
		String query2= "select SUM(amount) from Bazar_tb";
		report1(query2);
		double amount=total;
	//	System.out.println("Total Cost(only Bazar): "+amount);
		
		
		String query3= "select SUM(deposit) from Balance_tb";
		report1(query3);
		deposit=total;
	//	System.out.println("Total Deposit: "+deposit);
		
		String query4= "select SUM(due) from MAMA_tb";
		report1(query4);
		double due=total;
	//	System.out.println("Mamar Due: "+due);
		
		
		double bazar=(amount+due);

		double hand=(deposit-bazar);
	//	System.out.println("Balance In Hand: "+hand);
	//	System.out.println("Above All Cost: "+bazar);
		pmeal=(bazar/qnty);
	//	System.out.println("Per Meal Cost: "+Math.round(pmeal));
		
		setVisible(true);
		setTitle("Report");
		setBounds(100, 100, 624, 493);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Total");
		lblNewLabel.setForeground(Color.GREEN);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 26, 75, 47);
		contentPane.add(lblNewLabel);
		
		JLabel lblCost = new JLabel("Cost");
		lblCost.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCost.setForeground(Color.GREEN);
		lblCost.setBounds(10, 101, 75, 43);
		contentPane.add(lblCost);
		
		JLabel lblInHand = new JLabel("In Hand");
		lblInHand.setForeground(Color.GREEN);
		lblInHand.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblInHand.setBounds(22, 189, 75, 43);
		contentPane.add(lblInHand);
		
		JLabel lblMeal = new JLabel("Meals");
		lblMeal.setForeground(Color.GREEN);
		lblMeal.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMeal.setBounds(29, 274, 68, 22);
		contentPane.add(lblMeal);
		
		JLabel lblPerMeal = new JLabel("Per meal");
		lblPerMeal.setForeground(Color.GREEN);
		lblPerMeal.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPerMeal.setBounds(29, 339, 75, 42);
		contentPane.add(lblPerMeal);
		
		textField = new JTextField();
		textField.setBounds(125, 26, 94, 47);
		textField.setText(Double.toString(deposit));
		textField.setEditable(false);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(125, 101, 94, 43);
		textField_1.setText(Double.toString(bazar));
		textField_1.setEditable(false);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(125, 189, 94, 42);
		textField_2.setText(Double.toString(hand));
		textField_2.setEditable(false);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(125, 269, 94, 43);
		textField_3.setText(Double.toString(qnty));
		textField_3.setEditable(false);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(125, 339, 94, 42);
		textField_4.setText(Double.toString(Math.round(pmeal)));
		textField_4.setEditable(false);
		contentPane.add(textField_4);
		
		JLabel lblNewLabel_1 = new JLabel("Member");
		lblNewLabel_1.setForeground(Color.GREEN);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(416, 26, 103, 32);
		contentPane.add(lblNewLabel_1);
		
		String[] names={"Niloy","Arif","Sohan","Jubayer","Shanto"};
		final JComboBox comboBox = new JComboBox(names);
		comboBox.setFont(new Font("Sylfaen", Font.BOLD, 15));
		comboBox.setBounds(370, 76, 180, 40);
		comboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String name=(String)comboBox.getSelectedItem();
				
				
				if(name.equalsIgnoreCase("Sohan")){
					
					String query1="select SUM(qnty) from Meal_tb where name='Sohan'";
					report2(query1);
					String meal=nMeal;
					
		//			System.out.println("Total Meals of Sohan: "+meal);
					textField_6.setText(meal);
					
					String query2="select SUM(deposit) from Balance_tb where name='Sohan'";
					report2(query2);
					
					String deposit1=nMeal;
		//			System.out.println("Total Deposit of Sohan: "+deposit1);
					double calc1=Double.parseDouble(meal);
					double calc2=Double.parseDouble(deposit1);
					
					Double balance1=Math.rint((calc2-(calc1*pmeal)));
					
		//			System.out.println("Balance of Sohan: "+balance1);
					textField_5.setText(Double.toString(balance1));
				}
				else if(name.equalsIgnoreCase("Arif")){
					
					String query1="select SUM(qnty) from Meal_tb where name='Arif'";
					report2(query1);
					String meal=nMeal;
					
		//			System.out.println("Total Meals of Arif: "+meal);
					textField_6.setText(meal);
					
					String query2="select SUM(deposit) from Balance_tb where name='Arif'";
					report2(query2);
					
					String deposit1=nMeal;
		//			System.out.println("Total Deposit of Arif: "+deposit1);
					double calc1=Double.parseDouble(meal);
					double calc2=Double.parseDouble(deposit1);
					
					Double balance1=Math.rint((calc2-(calc1*pmeal)));
					
		//			System.out.println("Balance of Arif: "+balance1);
					textField_5.setText(Double.toString(balance1));
				}
				else if(name.equalsIgnoreCase("Niloy")){
					
					String query1="select SUM(qnty) from Meal_tb where name='Niloy'";
					report2(query1);
					String meal=nMeal;
					
		//		    System.out.println("Total Meals of Niloy: "+meal);
					textField_6.setText(meal);
					
					String query2="select SUM(deposit) from Balance_tb where name='Niloy'";
					report2(query2);
					
					String deposit1=nMeal;
		//			System.out.println("Total Deposit of Niloy: "+deposit1);
					double calc1=Double.parseDouble(meal);
					double calc2=Double.parseDouble(deposit1);
					
					Double balance1=Math.rint((calc2-(calc1*pmeal)));
					
		//			System.out.println("Balance of Niloy: "+balance1);
					textField_5.setText(Double.toString(balance1));
				}
				
				else if(name.equalsIgnoreCase("Jubayer")){
					
					String query1="select SUM(qnty) from Meal_tb where name='Jubayer'";
					report2(query1);
					String meal=nMeal;
					
			//		System.out.println("Total Meals of Jubayer: "+meal);
					textField_6.setText(meal);
					
					String query2="select SUM(deposit) from Balance_tb where name='Jubayer'";
					report2(query2);
					
					String deposit1=nMeal;
			//		System.out.println("Total Deposit of Jubayer: "+deposit1);
					double calc1=Double.parseDouble(meal);
					double calc2=Double.parseDouble(deposit1);
					
					Double balance1=Math.rint((calc2-(calc1*pmeal)));
					
			//		System.out.println("Balance of Jubayer: "+balance1);
					textField_5.setText(Double.toString(balance1));
				}
				else if(name.equalsIgnoreCase("Shanto")){
					
					String query1="select SUM(qnty) from Meal_tb where name='Shanto'";
					report2(query1);
					String meal=nMeal;
					
			//		System.out.println("Total Meals of Shanto: "+meal);
					textField_6.setText(meal);
					
					String query2="select SUM(deposit) from Balance_tb where name='Shanto'";
					report2(query2);
					
					String deposit1=nMeal;
			//		System.out.println("Total Deposit of Shanto: "+deposit1);
					double calc1=Double.parseDouble(meal);
					double calc2=Double.parseDouble(deposit1);
					
					Double balance1=(double)Math.round((calc2-(calc1*pmeal)));
					
				//	System.out.println("Balance of Shanto: "+balance1);
					textField_5.setText(Double.toString(balance1));
				}

				
			}
		});
		contentPane.add(comboBox);
		
		textField_5 = new JTextField();
		textField_5.setBounds(370, 142, 86, 42);
		textField_5.setEditable(false);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(370, 200, 86, 42);
		textField_6.setEditable(false);
		contentPane.add(textField_6);
		
		JLabel lblNewLabel_2 = new JLabel("Balance");
		lblNewLabel_2.setForeground(Color.GREEN);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(493, 138, 94, 36);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblMeals = new JLabel("Meals");
		lblMeals.setForeground(Color.GREEN);
		lblMeals.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMeals.setBounds(493, 200, 86, 42);
		contentPane.add(lblMeals);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			Main1 ob=new Main1();
			dispose();
			}
		});
		btnNewButton.setBounds(381, 341, 128, 37);
		contentPane.add(btnNewButton);
	}

}
