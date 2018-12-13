package gui_classes;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.eclipse.wb.swing.FocusTraversalOnArray;


import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JTabbedPane;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import product_classes.Windows;

public class frame extends JFrame implements ActionListener{
//list of all components of the frame
	private static frame frame;
	private JPanel contentPane;
	
	private JTextField txtName;
	
	private JButton addRoomButton;
	
	Home_frame room;
	private static final String filePath = "Polaris Price Book with Bay Bow 5 12 2014 Revised.xlsx";
	private static List<Windows> windowList;
	
//runs the program

//creates the frame
	public frame() {		
		//excel.getWindowListFromExcel("hi");
		setTitle("Polaris Windows/Door Calculator");
//sets up the frame
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		contentPane.setLayout(new BorderLayout(0, 0));
		
		contentPane.add(makeScrollPanel(), BorderLayout.CENTER);
		contentPane.add(makeTotalPricePanel(), BorderLayout.SOUTH);
		setContentPane(contentPane);

		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{contentPane}));		
	}
	
//create scroll pane	
	protected JComponent makeScrollPanel() {
        JPanel panel = new JPanel();
        panel.add(makeAddRoomPanel());
        
      	JScrollPane scrollPane = new JScrollPane(panel);
      	scrollPane.setAlignmentY(Component.TOP_ALIGNMENT);
      	scrollPane.setAlignmentX(Component.LEFT_ALIGNMENT);
      	scrollPane.setPreferredSize(new Dimension(700, 580));
      	  	
      	return scrollPane;
	}
	
//create room panel inside the scroll panel	????should be in different class
	protected JComponent makeAddRoomPanel() {
		JPanel panel = new JPanel();
		
		addRoomButton = new JButton("Add Room");
    	addRoomButton.addActionListener(this);
    	panel.setLayout(new FlowLayout(FlowLayout.LEADING));
      	panel.add(addRoomButton);
     		
     	txtName = new JTextField();
      	txtName.setText("Room Name");
      	txtName.addMouseListener(new MouseAdapter(){
      		public void mouseClicked(MouseEvent e){
      			if(txtName.getText().equals("Room Name")) txtName.setText("");
      		}
      	});
      	txtName.setColumns(20);
      	panel.add(txtName);
		return panel;
	}
	
//button action for addRoomButton
	public void actionPerformed(ActionEvent e){
  		if(e.getSource() == addRoomButton){
  			//room_frame room = new room_frame(txtName.getText());
  			room = new Home_frame(txtName.getText(), windowList);
  			room.doneButton.addActionListener(this);//this allows an event of the doneButton to trigger
  			room.setVisible(true);
  			
  			frame.setEnabled(false);
  			frame.repaint();			
  		} 
  		if (e.getSource() == room.doneButton){
  			frame.setEnabled(true);
  			frame.repaint();
  		}  
  		if (e.getSource() == txtName){
  			txtName.setText("");
  			repaint();
  			revalidate();
  		}
  	}
	
	protected JComponent makeTotalPricePanel(){
		JPanel panel = new JPanel();
		JLabel price = new JLabel("Total Price: $0");
		panel.add(price);
		panel.setPreferredSize(new Dimension(580,50));
		return panel;
	}
	
}