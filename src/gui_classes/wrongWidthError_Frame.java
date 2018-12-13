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

public class wrongWidthError_Frame extends JFrame implements ActionListener{
//list of all components of the frame
	private JPanel contentPane;
	private static wrongWidthError_Frame room_frame;
	
	private List<Windows> windowList;
	
	public JButton backButton;
	
	private JPanel panel_1;
	private JLabel lblErrorBlankRoom;
	
//creates the room_frame gets title from the room is meant for
	public wrongWidthError_Frame(String title) {
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
		panel_1.setLayout(null);
		
		lblErrorBlankRoom = new JLabel("ERROR:");
		lblErrorBlankRoom.setBounds(0, 39, 221, 25);
		lblErrorBlankRoom.setHorizontalAlignment(SwingConstants.CENTER);
		lblErrorBlankRoom.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(lblErrorBlankRoom);
		
		JLabel lblBlankRoomName = new JLabel("Invalid Width");
		lblBlankRoomName.setHorizontalAlignment(SwingConstants.CENTER);
		lblBlankRoomName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBlankRoomName.setBounds(0, 64, 221, 25);
		panel_1.add(lblBlankRoomName);
		
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{contentPane}));
		
		
		
		
	}
	

	
	protected JComponent makeDonePanel(){
		JPanel panel = new JPanel();
		
		backButton = new JButton("OK");
		backButton.addActionListener(this);
		panel.add(backButton);
		panel.setPreferredSize(new Dimension(580, 30));
		return panel;
	}
	
//button action for addRoomButton
	public void actionPerformed(ActionEvent e){
		dispose();
	 }
}
