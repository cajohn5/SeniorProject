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

import excel_reader_classes.MasterExcelReading;
import product_classes.Holder;
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
import java.io.FileNotFoundException;

public class style_type_frame extends JFrame implements ActionListener{
//list of all components of the frame
	private JPanel contentPane;
	private static style_type_frame room_frame;
	
	private List<Windows> windowList;
	
	public JButton backButton;
	
	private JPanel panel_1;
	private JLabel lblWindowsOptions;
	private JPanel panel_2;
	private JComboBox typeBox;
	private JPanel panel_5;
	private JButton nextButton;
	private JButton cancelButton;
	private JComboBox styleBox;
	//private Holder holder = new Holder();;
	/*private MasterExcelReading mer = new MasterExcelReading();
	{
	
	try
		{
			mer.returnUpdatedHolder(holder);
		}
	catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
//creates the room_frame gets title from the room is meant for
	public style_type_frame(String title, List<Windows> windowList, Holder holder) {
//sets up the frame
		this.windowList = windowList;
		setTitle("Creation Wizard");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 400, 200);
		typeBox = new JComboBox();
		typeBox.setModel(new DefaultComboBoxModel(new String[] {"DynaWeld", "ThermalWeldPlus", "UltraWeld"}));
		styleBox = new JComboBox();
		styleBox.setModel(new DefaultComboBoxModel(new String[] {"Double Hung", "Picture", "Hopper", "Awning", "2-LiteGlider", "3-LiteGlider", "Single Casement", "Double Casement", "Triple Casement"}));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(makeDonePanel(holder), BorderLayout.SOUTH);
		
		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		panel_2 = new JPanel();
		panel_1.add(panel_2);
		
		lblWindowsOptions = new JLabel("Door and Window Options");
		panel_2.add(lblWindowsOptions);
		lblWindowsOptions.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		panel_5 = new JPanel();
		panel_1.add(panel_5);
		
		styleBox = new JComboBox();
		styleBox.setModel(new DefaultComboBoxModel(holder.getProductList().toArray(new String[holder.getProductList().size()])));
		panel_5.add(styleBox);
		
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{contentPane}));
		
		
		
		
	}
	

	protected JComponent makeDonePanel(Holder holder){
		JPanel panel = new JPanel();
		
		backButton = new JButton("Back");
		backButton.addActionListener(this);
		panel.add(backButton);
		panel.setPreferredSize(new Dimension(580, 30));
		
		nextButton = new JButton("Next");
		panel.add(nextButton);
		nextButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				switch(styleBox.getSelectedItem().toString().trim()){
				case "DynaWeld Double Hung Series 3020":
				DW_DoubleHung_Frame dhdwf = new DW_DoubleHung_Frame(styleBox.getSelectedIndex(), holder);
				dhdwf.setVisible(true);
				break;
				case "ThermalWeld Plus Double Hung Series 7020":
				TWP_DoubleHung_Frame dhtwf = new TWP_DoubleHung_Frame(styleBox.getSelectedIndex(), holder);
				dhtwf.setVisible(true);
				break;
				case "UltraWeld Double Hung Series 8420":
				UW_DoubleHung_Frame dhuwf = new UW_DoubleHung_Frame(styleBox.getSelectedIndex(), holder);
				dhuwf.setVisible(true);
				break;
				case "DynaWeld Picture Window Series 3000":
				DW_Picture_Frame ptf = new DW_Picture_Frame(styleBox.getSelectedIndex(), holder);
				ptf.setVisible(true);
				break;
				case "ThermalWeld Plus Picture Window Series 7000":
				TWP_Picture_Frame pdwf = new TWP_Picture_Frame(styleBox.getSelectedIndex(), holder);
				pdwf.setVisible(true);
				break;
				case "UltraWeld Picture Window Series 8400":
				UW_Picture_Frame puwf = new UW_Picture_Frame(styleBox.getSelectedIndex(), holder);
				puwf.setVisible(true);
				break;
				case "DynaWeld Hopper Window Series 3070":
				DW_Hopper_Frame hdwf = new DW_Hopper_Frame(styleBox.getSelectedIndex(), holder);
				hdwf.setVisible(true);
				break;
				case "UltraWeld Awning Window Series 8460":
				UW_Awning_Frame auwf = new UW_Awning_Frame(styleBox.getSelectedIndex());
				auwf.setVisible(true);
				break;
				case "DynaWeld 2-LiteGlider Series 3030":
				DW_Glider2_Frame g2dwf = new DW_Glider2_Frame(styleBox.getSelectedIndex(), holder);
				g2dwf.setVisible(true);
				break;
				case "ThermalWeld Plus 2-LiteGlider Series 7430":
				TWP_Glider2_Frame g2twf = new TWP_Glider2_Frame(styleBox.getSelectedIndex(), holder);
				g2twf.setVisible(true);
				break;
				case "UltraWeld 2-LiteGlider Series 8430":
				UW_Glider2_Frame g2uwf = new UW_Glider2_Frame(styleBox.getSelectedIndex(), holder);
				g2uwf.setVisible(true);
				break;
				case "DynaWeld Vinyl Patio Door Series 3080":
				DW_PatioDoor_Frame dpdf = new DW_PatioDoor_Frame(styleBox.getSelectedIndex(), holder);
				dpdf.setVisible(true);
				break;
				case "ThermalWeld Plus Vinyl Patio Door Series 7480":
				TWP_PatioDoor_Frame twppdf = new TWP_PatioDoor_Frame(styleBox.getSelectedIndex(), holder);
				twppdf.setVisible(true);
				break;
				case "ThermalWeld Plus Vinyl Custom Patio Door Series 7480":
				TWP_PatioDoor_Frame twpcpdf = new TWP_PatioDoor_Frame(styleBox.getSelectedIndex(), holder);
				twpcpdf.setVisible(true);
				break;
				case "UltraWeld Vinyl Patio Door Series 8480":
				TWP_PatioDoor_Frame uwpdf = new TWP_PatioDoor_Frame(styleBox.getSelectedIndex(), holder);
				uwpdf.setVisible(true);
				break;
				case "UltraWeld Vinyl Custom Patio Door Series 8480":
				TWP_PatioDoor_Frame uwcpdf = new TWP_PatioDoor_Frame(styleBox.getSelectedIndex(), holder);
				uwcpdf.setVisible(true);
				break;
				case "DynaWeld 3-LiteGlider Series 3040":
				DW_Glider3_Frame g3dwf = new DW_Glider3_Frame(styleBox.getSelectedIndex(), holder);
				g3dwf.setVisible(true);
				break;
				case "ThermalWeld Plus 3-LiteGlider Series 7440":
				TWP_Glider3_Frame g3twf = new TWP_Glider3_Frame(styleBox.getSelectedIndex(), holder);
				g3twf.setVisible(true);
				break;
				case "UltraWeld 3-LiteGlider Series 8440":
				UW_Glider3_Frame g3uwf = new UW_Glider3_Frame(styleBox.getSelectedIndex(), holder);
				g3uwf.setVisible(true);
				break;
				case "UltraWeld Vinyl Single Casement Series 8450":
				UW_Casement1_Frame c1uwf = new UW_Casement1_Frame(styleBox.getSelectedIndex());
				c1uwf.setVisible(true);
				break;
				case "UltraWeld Vinyl Double Casement Series 8450":
				UW_Casement2_Frame c2uwf = new UW_Casement2_Frame(styleBox.getSelectedIndex(), holder);
				c2uwf.setVisible(true);
				break;
				case "UltraWeld Vinyl Triple Casement Series 8450":
				UW_Casement3_Frame c3uwf = new UW_Casement3_Frame(styleBox.getSelectedIndex(), holder);
				c3uwf.setVisible(true);
				break;
				case "ThermalWeld Plus Shapes Series 7400":
				TWP_Shapes_Frame twps = new TWP_Shapes_Frame();
				twps.setVisible(true);
				break;
				case "UltraWeld Garden Window":
				UW_Garden_Frame uwg = new UW_Garden_Frame(styleBox.getSelectedIndex(), holder);
				uwg.setVisible(true);
				break;
				case "UltraWeld Shapes Series 8400":
				UW_Shapes_Frame uws = new UW_Shapes_Frame();
				uws.setVisible(true);
				break;
				default:
					InvalidSelectionError_Frame errorFrame = new InvalidSelectionError_Frame("ERROR");
					errorFrame.setVisible(true);
					
				}
			}
		});

		
		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		cancelButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
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
