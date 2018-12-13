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
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class label_frame extends JFrame implements ActionListener{
//list of all components of the frame
	private JPanel contentPane;
	private static label_frame room_frame;
	
	private List<Windows> windowList;
	
	public JButton backButton;
	
	private JPanel panel_1;
	private JLabel lblCurrentRoom;
	private JLabel lblRoomName;
	private JPanel panel_2;
	private JPanel panel_4;
	private JButton nextButton;
	private JButton cancelButton;
	private JTextField textField;
    public JPanel roomSpacerPanel = new JPanel(false);
//creates the room_frame gets title from the room is meant for
	public label_frame(String title, List<Windows> windowList) {
//sets up the frame
		this.windowList = windowList;
		setTitle("Creation Wizard");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 250, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(makeDonePanel(), BorderLayout.SOUTH);
		
		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		panel_2 = new JPanel();
		panel_1.add(panel_2);
		
		lblCurrentRoom = new JLabel("Current Room");
		panel_2.add(lblCurrentRoom);
		lblCurrentRoom.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		panel_4 = new JPanel();
		panel_1.add(panel_4);
		
		lblRoomName = new JLabel("Room Name: ");
		panel_4.add(lblRoomName);
		
		textField = new JTextField();
		panel_4.add(textField);
		textField.setColumns(10);
		
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{contentPane}));
		
		
		
		
	}
	

	
	protected JComponent makeDonePanel(){
		JPanel panel = new JPanel();
		
		backButton = new JButton("Back");
		backButton.addActionListener(this);
		panel.add(backButton);
		panel.setPreferredSize(new Dimension(580, 30));
		
		nextButton = new JButton("Next");
		/*nextButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (textField.getText().isEmpty())
				{blankRoomNameError_Frame brne = new blankRoomNameError_Frame("Error");
				brne.setVisible(true);
				}else{
					nextButton.addActionListener(new ActionListener() {
					private JLabel room;
					public void actionPerformed(ActionEvent arg0) {
						String roomLabel = textField.getText();
						room = new JLabel("");
						room.setText(roomLabel);
						style_type_frame stf = new style_type_frame("Creation Wizard", windowList, holder); 
						stf.setVisible(true);
				      	JPanel roomModPane = new JPanel();
				      	
				      	roomSpacerPanel.add(roomModPane);
				      	
				      	roomModPane.add(room);
				      	
				      	JButton addButton = new JButton("Add");
				      	roomModPane.add(addButton);
				      	
				      	JButton editButton = new JButton("Edit");
				      	roomModPane.add(editButton);
				      	
				      	JButton deleteButton = new JButton("Delete");
				      	roomModPane.add(deleteButton);
						roomModPane.setVisible(true);
					}
				});
					
				}
			}
		});*/

		
		
		panel.add(nextButton);
		
		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel.add(cancelButton);
		return panel;
	}
	
//button action for addRoomButton
	public void actionPerformed(ActionEvent e){
	dispose();
	}
	
}
