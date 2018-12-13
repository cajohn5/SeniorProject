package gui_classes;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import product_classes.Windows;

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

public class modify_frame extends JFrame implements ActionListener{
//list of all components of the frame
	private JPanel contentPane;
	private static modify_frame room_frame;
	
	private List<Windows> windowList;
	
	private JTextField textField;
	
//creates the room_frame gets title from the room is meant for
	public modify_frame(String title, List<Windows> windowList) {
//sets up the frame
		this.windowList = windowList;
		setTitle("Edit");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		contentPane.add(makeScrollPanel(), BorderLayout.CENTER);
		contentPane.add(makeDonePanel(), BorderLayout.SOUTH);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.EAST);
		
		JLabel lblTotalCost = new JLabel("Total Cost: ");
		panel_1.add(lblTotalCost);
		
		JLabel lblxxxxxx = new JLabel("$xxxx.xx");
		panel_1.add(lblxxxxxx);
		
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{contentPane}));
		
		
		
		
	}
	
//create scroll pane	
	protected JComponent makeScrollPanel() {
		JPanel panel = new JPanel();
	    panel.add(makeWindowPanel());
	       
    	JScrollPane scrollPane = new JScrollPane(panel);
    	scrollPane.setAlignmentY(Component.TOP_ALIGNMENT);
	   	scrollPane.setAlignmentX(Component.LEFT_ALIGNMENT);
	   	scrollPane.setPreferredSize(new Dimension(580, 580));
	      	  	
	    return scrollPane;
	}
	
//This is the panel of the home tab
	protected JComponent makeWindowPanel() {
        JPanel panel = new JPanel(false);
    	panel.setLayout(new FlowLayout(FlowLayout.LEADING));
      	panel.setPreferredSize(new Dimension(580,1000));
      	
      	JPanel panel_1 = new JPanel();
      	panel.add(panel_1);
      	
      	JLabel lblRoomLabel = new JLabel("Product Label");
      	panel_1.add(lblRoomLabel);
      	
      	JLabel lblOfProduct = new JLabel("x");
      	panel_1.add(lblOfProduct);
      	
      	textField = new JTextField();
      	panel_1.add(textField);
      	textField.setColumns(10);
      	
      	JButton btnEdit = new JButton("Edit");
      	panel_1.add(btnEdit);
      	
      	JButton btnDelete = new JButton("Delete");
      	panel_1.add(btnDelete);
      	
		return panel;       
    }
	
	protected JComponent makeDonePanel(){
		JPanel panel = new JPanel();
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		JButton btnOk = new JButton("OK");
		panel_1.add(btnOk);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		
		JButton btnCancel = new JButton("Cancel");
		panel_2.add(btnCancel);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		
		JButton btnApply = new JButton("Apply");
		panel_3.add(btnApply);
		panel.setPreferredSize(new Dimension(580, 80));
		return panel;
	}
	
//button action for addRoomButton
	public void actionPerformed(ActionEvent e){
	 }
	
}
