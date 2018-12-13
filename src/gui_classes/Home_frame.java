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

import product_classes.Windows;

//import org.eclipse.wb.swing.FocusTraversalOnArray;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class Home_frame extends JFrame implements ActionListener{
//list of all components of the frame
	private JPanel contentPane;
	private static Home_frame room_frame;
	
	private List<Windows> windowList;
    public JPanel roomSpacerPanel = new JPanel(false);
	public JButton doneButton;
	public String currentLabel;
	
//creates the room_frame gets title from the room is meant for
	public Home_frame(String title, List<Windows> windowList) {
//sets up the frame
		this.windowList = windowList;
		setTitle("Home");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		contentPane.add(makeScrollPanel(), BorderLayout.CENTER);
		contentPane.add(makeDonePanel(), BorderLayout.SOUTH);
		
		JPanel totalsPane = new JPanel();
		contentPane.add(totalsPane, BorderLayout.EAST);
		
		JLabel totalCostStaticLabel = new JLabel("Total Cost: ");
		totalsPane.add(totalCostStaticLabel);
		
		JLabel totalCostLabel = new JLabel("$xxxx.xx");
		totalsPane.add(totalCostLabel);
		
		//setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{contentPane}));
		
		
		
		
	}
	
//create scroll pane	
	protected JComponent makeScrollPanel() {
		JPanel roomHolderPane = new JPanel();
	    roomHolderPane.add(makeWindowPanel());
	       
    	JScrollPane roomScrollPane = new JScrollPane(roomHolderPane);
    	roomScrollPane.setAlignmentY(Component.TOP_ALIGNMENT);
	   	roomScrollPane.setAlignmentX(Component.LEFT_ALIGNMENT);
	   	roomScrollPane.setPreferredSize(new Dimension(580, 580));
	      	  	
	    return roomScrollPane;
	}
	
//This is the panel of the home tab
	protected JComponent makeWindowPanel() {

    	roomSpacerPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
      	roomSpacerPanel.setPreferredSize(new Dimension(580,1000));
      	
      	JPanel roomModPane = new JPanel();
      	roomModPane.addPropertyChangeListener(new PropertyChangeListener() {
      		public void propertyChange(PropertyChangeEvent arg0) {
      			roomModPane.setVisible(false);
      		}
      	});
      	roomSpacerPanel.add(roomModPane);
      	
      	JLabel roomLabel = new JLabel("Room Label:");
      	roomModPane.add(roomLabel);
      	
      	JButton addButton = new JButton("Add");
      	roomModPane.add(addButton);
      	
      	JButton editButton = new JButton("Edit");
      	roomModPane.add(editButton);
      	
      	JButton deleteButton = new JButton("Delete");
      	roomModPane.add(deleteButton);
      	
		return roomSpacerPanel;       
    }
	
	protected JComponent makeDonePanel(){
		JPanel buttonHolder = new JPanel();
		
		doneButton = new JButton("Done");
		doneButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		doneButton.addActionListener(this);
		
		JPanel deletePane = new JPanel();
		buttonHolder.add(deletePane);
		
		JButton deleteButton = new JButton("Delete");
		deletePane.add(deleteButton);
		
		JPanel createPane = new JPanel();
		buttonHolder.add(createPane);
		
		JButton createButton = new JButton("Create");
		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				label_frame lf = new label_frame("Creation Wizard", windowList);
				lf.setVisible(true);
			}
		});
		createButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		createPane.add(createButton);
		
		JPanel savePane = new JPanel();
		buttonHolder.add(savePane);
		
		JButton saveButton = new JButton("Save");
		savePane.add(saveButton);
		buttonHolder.add(doneButton);
		buttonHolder.setPreferredSize(new Dimension(580, 80));
		return buttonHolder;
	}
	
//button action for doneButton
	public void actionPerformed(ActionEvent e){
		System.exit(0);
	 }
	
}
