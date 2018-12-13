package gui_classes;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import excel_reader_classes.MasterExcelReading;
import product_classes.Holder;
import product_classes.Windows;
import javax.swing.SwingConstants;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


public class DW_Picture_Frame extends JFrame implements ActionListener{
//list of all components of the frame
	private JPanel contentPane;
	
	private JFormattedTextField widthText;
	private JFormattedTextField heightText;
	private double energyCost = 0;
	private double glassTypeCost = 0;
	private double glassStrengthCost = 0;
	private double spaceCost = 0;
	private double winTintCost = 0;
	private double frameColorCost = 0;
	private double foamCost = 0;
	private double wrapCost = 0;
	private double lamCost = 0;
	private double sash1Cost = 0;
	private double mullCost = 0;
	private double totalCost = 0;
	//private Holder holder = new Holder();
	private Float ui = (float) 0;
	private int index;
	private Windows obj;
	
	private float height;
	private float width;

	
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
	JLabel totalLabel = new JLabel("$0.00");

//creates the frame
	public DW_Picture_Frame(int index, Holder holder) {

		index = holder.getProductIndex(index);
		obj = ((Windows) holder.getDynaWeld().get(index));
//sets up the frame
		setTitle("Window");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setMinimumSize(new Dimension(1000,700));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		contentPane.add(makeWindowPanel());
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JPanel panel_6 = new JPanel();
		panel.add(panel_6);
		
		JLabel lblWindowTypeLabel = new JLabel(obj.getProductName());
		lblWindowTypeLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_6.add(lblWindowTypeLabel);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		JLabel label_1 = new JLabel("Price");
		panel_1.add(label_1);
		
		panel_1.add(totalLabel);
		
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{contentPane}));
		
		
		
		
	}
	private void calcTotalCost() {
		totalCost = energyCost +glassTypeCost +glassStrengthCost +spaceCost  +winTintCost +frameColorCost +foamCost  +wrapCost +lamCost +sash1Cost +mullCost;
		}
	private void calcUI() {
		if (heightText.getText().equals("") || heightText.getText().contains("-")) height = 0;
		else height = Float.valueOf(heightText.getText());
		if (widthText.getText().equals("") || widthText.getText().contains("-")) width = 0;
		else width = Float.valueOf(widthText.getText());
		ui = width+height;
		}

//This is the panel of the home tab
	protected JComponent makeWindowPanel() {
        JPanel panel = new JPanel();
        JPanel panel_2_1 = new JPanel();
        panel_2_1.setBounds(129, 28, 162, 30);
        panel.add(panel_2_1);
        JPanel panel_3 = new JPanel();
        panel_3.setBounds(296, 28, 165, 30);
        panel.add(panel_3);
        NumberFormat num = NumberFormat.getNumberInstance();
        widthText = new JFormattedTextField(num);
        widthText.setValue(new Float(obj.getSize().getWidth().get(0)));
        panel_2_1.add(widthText);
        widthText.setColumns(10);
        heightText = new JFormattedTextField(new Float(obj.getSize().getHeight().get(0)));
        heightText = new JFormattedTextField(num);
        heightText.setValue(new Float(obj.getSize().getWidth().get(0)));
        panel_3.add(heightText);
        heightText.setColumns(10);
        panel_3.add(heightText);
		calcUI();


        //panel.setLayout(new AbsoluteLayout(0,0));
        panel.setLayout(null);
        
        JPanel panel_6 = new JPanel();
        panel_6.setBorder(new TitledBorder(null, "Grid Options Per Sash", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_6.setBounds(10, 79, 467, 116);
        panel.add(panel_6);
        panel_6.setLayout(null);
        
        JPanel panel_4 = new JPanel();
        panel_4.setBounds(6, 16, 449, 89);
        panel_6.add(panel_4);
        panel_4.setLayout(null);
        
        JLabel lblGridOptionsSash = new JLabel("Sash 1");
        lblGridOptionsSash.setBounds(0, 0, 100, 20);
        panel_4.add(lblGridOptionsSash);
        lblGridOptionsSash.setFont(new Font("Dialog", Font.PLAIN, 14));
        
        JComboBox sash1Box1 = new JComboBox(new Vector(obj.getGridOptionsList()));
        sash1Box1.setSelectedIndex(0);
      
        sash1Box1.setBounds(100, 0, 120, 20);
        panel_4.add(sash1Box1);
        
        JComboBox sash1Box2 = new JComboBox(new Vector(obj.getGridOptions()));
        sash1Box2.setSelectedIndex(0);
        
        JLabel sash1Label = new JLabel("+$0.00");
        sash1Label.setBounds(360, 3, 77, 14);
        panel_4.add(sash1Label);
        
        JPanel panel_7 = new JPanel();
        panel_7.setBorder(new TitledBorder(null, "Custom Extras", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_7.setBounds(482, 70, 480, 301);
        panel.add(panel_7);
        panel_7.setLayout(null);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBounds(6, 16, 464, 119);
        panel_7.add(panel_2);
        panel_2.setLayout(null);
        
        JCheckBox chckbxPolyfoamWrap = new JCheckBox(obj.getCustomExtrasList().get(1));
        chckbxPolyfoamWrap.setFont(new Font("Dialog", Font.PLAIN, 14));
        chckbxPolyfoamWrap.setBounds(-2, 33, 395, 23);
        panel_2.add(chckbxPolyfoamWrap);
        
        JCheckBox chckbxFoamFilledMain = new JCheckBox(obj.getCustomExtrasList().get(0));
        chckbxFoamFilledMain.setFont(new Font("Dialog", Font.PLAIN, 14));
        chckbxFoamFilledMain.setBounds(-2, 7, 395, 23);
        panel_2.add(chckbxFoamFilledMain);
        
        JCheckBox chckbxLaminated = new JCheckBox(obj.getCustomExtrasList().get(2));
        chckbxLaminated.setFont(new Font("Dialog", Font.PLAIN, 14));
        chckbxLaminated.setBounds(-2, 56, 395, 23);
        panel_2.add(chckbxLaminated);
        
        JLabel wrapLabel = new JLabel("+$0.00");
        wrapLabel.setBounds(399, 33, 65, 14);
        panel_2.add(wrapLabel);
        
        JLabel foamLabel = new JLabel("+$0.00");
        foamLabel.setBounds(399, 7, 65, 14);
        panel_2.add(foamLabel);
        
        JLabel lamLabel = new JLabel("+$0.00");
        lamLabel.setBounds(399, 56, 65, 14);
        panel_2.add(lamLabel);
        
        JPanel panel_5 = new JPanel();
        panel_5.setBorder(new TitledBorder(null, "Window Options", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_5.setBounds(10, 198, 467, 360);
        panel.add(panel_5);
        panel_5.setLayout(null);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBounds(6, 16, 449, 225);
        panel_5.add(panel_1);
        panel_1.setLayout(null);
        
        JLabel energyOptionsLabel = new JLabel(obj.getEnergyOptionsLabel());
        energyOptionsLabel.setBounds(0, 0, 189, 20);
        panel_1.add(energyOptionsLabel);
        energyOptionsLabel.setFont(new Font("Dialog", Font.PLAIN, 14));
        
        JComboBox energyOptionList = new JComboBox(new Vector(obj.getEnergyOptionsList()));
        energyOptionList.setSelectedIndex(0);

        energyOptionList.setBounds(170, 0, 170, 20);
        panel_1.add(energyOptionList);
        
        JComboBox glassStrengthList = new JComboBox(new Vector(obj.getGlassStrengthList()));
        glassStrengthList.setSelectedIndex(0);
        glassStrengthList.setBounds(170, 64, 170, 20);
        panel_1.add(glassStrengthList);
        
        JComboBox spacerList = new JComboBox(new Vector(obj.getSpacerList()));
        spacerList.setSelectedIndex(0);
        spacerList.setBounds(170, 90, 170, 20);
        panel_1.add(spacerList);
        
        JLabel spacerLabel = new JLabel(obj.getSpacerLabel());
        spacerLabel.setBounds(0, 90, 189, 20);
        panel_1.add(spacerLabel);
        spacerLabel.setFont(new Font("Dialog", Font.PLAIN, 14));
        
        JLabel glassStrengthLabel = new JLabel(obj.getGlassStrengthLabel());
        glassStrengthLabel.setBounds(0, 64, 189, 20);
        panel_1.add(glassStrengthLabel);
        glassStrengthLabel.setFont(new Font("Dialog", Font.PLAIN, 14));
        
        JLabel spacerCostLabel = new JLabel("+$0.00");
        spacerCostLabel.setBounds(363, 90, 86, 14);
        panel_1.add(spacerCostLabel);
        
        JLabel glassStrengthCostLabel = new JLabel("+$0.00");
        glassStrengthCostLabel.setBounds(363, 64, 86, 14);
        panel_1.add(glassStrengthCostLabel);
        JComboBox glassList = new JComboBox(new Vector((obj.getGlassList())));
        glassList.setSelectedIndex(0);
        JComboBox glassTintList = new JComboBox(new Vector(obj.getGlassTintList()));
        glassTintList.setSelectedIndex(0);
        JComboBox frameColorList = new JComboBox(new Vector(obj.getFrameColorList()));
        frameColorList.setSelectedIndex(0);
        JComboBox mullList = new JComboBox(new Vector(obj.getMullList()));
        mullList.setSelectedIndex(0);
        JComboBox mullOptionBox = new JComboBox();
        JLabel glassLabel = new JLabel(obj.getGlassLabel());
        JLabel glassTintCostLabel = new JLabel("+$0.00");
        JLabel glassTintLabel = new JLabel(obj.getGlassTintLabel());
        JLabel frameColorLabel = new JLabel(obj.getFrameColorLabel());
        JLabel mullCostLabel = new JLabel("+$0.00");
        JLabel frameColorCostLabel = new JLabel("+$0.00");
        JLabel mullLabel = new JLabel(obj.getMullLabel());
        JLabel glassCostLabel = new JLabel("+$0.00");
        JLabel energyOptionCostLabel = new JLabel("+$0.00");

        mullOptionBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2"}));
        mullOptionBox.setSelectedIndex(0);

		energyCost=obj.getEnergyOptionsPrice(energyOptionList.getSelectedIndex(),ui);
		glassTypeCost=obj.getGlassPrice(glassList.getSelectedIndex(),ui);
		glassStrengthCost=obj.getGlassStrengthPrice(glassStrengthList.getSelectedIndex(),ui);
		spaceCost=obj.getSpacerPrice(spacerList.getSelectedIndex(),ui);
		winTintCost=obj.getGlassTintPrice(glassTintList.getSelectedIndex(),ui);
		frameColorCost=obj.getFrameColorPrice(frameColorList.getSelectedIndex(),ui);
//		foamCost=obj.getCustomExtrasPrice(0, ui);
//		wrapCost=obj.getCustomExtrasPrice(3, ui);
//		lamCost=obj.getCustomExtrasPrice(4, ui);
	    sash1Cost=obj.getGridOptionsPrice(sash1Box2.getSelectedIndex(), sash1Box1.getSelectedIndex(), ui);
		mullCost=obj.getMullPrice(mullList.getSelectedIndex(), Integer.parseInt(mullOptionBox.getSelectedItem().toString()));        
        energyOptionCostLabel.setText("+$"+String.format("%.2f", energyCost));
		glassCostLabel.setText("+$"+String.format("%.2f", glassTypeCost));
        spacerCostLabel.setText("+$"+String.format("%.2f", spaceCost));
		glassStrengthCostLabel.setText("+$"+String.format("%.2f", glassStrengthCost));
        frameColorCostLabel.setText("+$"+String.format("%.2f", frameColorCost));
		glassTintCostLabel.setText("+$"+String.format("%.2f", winTintCost));
        mullCostLabel.setText("+$"+String.format("%.2f", mullCost));
//        foamLabel.setText("+$"+String.format("%.2f", foamCost));       			
//        wrapLabel.setText("+$"+String.format("%.2f", wrapCost));       			
//        lamLabel.setText("+$"+String.format("%.2f", lamCost));       		
        sash1Label.setText("+$"+String.format("%.2f", sash1Cost));
        energyOptionCostLabel.setBounds(363, 0, 86, 14);
        panel_1.add(energyOptionCostLabel);
        glassCostLabel.setBounds(363, 31, 86, 14);
        panel_1.add(glassCostLabel);
        

        glassList.setBounds(170, 31, 170, 20);
        panel_1.add(glassList);
        

        
        glassLabel.setFont(new Font("Dialog", Font.PLAIN, 14));
        glassLabel.setBounds(0, 31, 189, 20);
        panel_1.add(glassLabel);
        
        glassTintCostLabel.setBounds(363, 152, 86, 14);
        panel_1.add(glassTintCostLabel);
        
        glassTintList.setBounds(170, 152, 170, 20);
        panel_1.add(glassTintList);
        
        glassTintLabel.setFont(new Font("Dialog", Font.PLAIN, 14));
        glassTintLabel.setBounds(0, 152, 189, 20);
        panel_1.add(glassTintLabel);
        
        frameColorLabel.setFont(new Font("Dialog", Font.PLAIN, 14));
        frameColorLabel.setBounds(0, 121, 189, 20);
        panel_1.add(frameColorLabel);
        
        frameColorList.setBounds(170, 121, 170, 20);
        panel_1.add(frameColorList);

        frameColorCostLabel.setBounds(363, 121, 86, 14);
        panel_1.add(frameColorCostLabel);
        
        mullLabel.setBounds(0, 183, 189, 20);
        panel_1.add(mullLabel);
        mullLabel.setFont(new Font("Dialog", Font.PLAIN, 14));
        
        mullCostLabel.setBounds(363, 180, 86, 14);
        panel_1.add(mullCostLabel);
        
        mullList.setBounds(170, 180, 118, 20);
        panel_1.add(mullList);        
        

        mullOptionBox.setBounds(295, 180, 43, 20);
        panel_1.add(mullOptionBox);
        JPanel panel_4_1 = new JPanel();
        panel_4_1.setBounds(10, 28, 107, 30);
        panel.add(panel_4_1);
        
        JLabel label_17 = new JLabel("Windows Size");
        panel_4_1.add(label_17);
        label_17.setFont(new Font("Tahoma", Font.PLAIN, 16));
        

        
        JLabel label_2 = new JLabel("Width");
        panel_2_1.add(label_2);
       
        

        
        JLabel label_3_1 = new JLabel("Height");
        panel_3.add(label_3_1);

        heightText.setColumns(10);
        
        JLabel lblMinMax = new JLabel(obj.getWidthLabel());
        lblMinMax.setHorizontalAlignment(SwingConstants.CENTER);
        lblMinMax.setFont(new Font("Dialog", Font.PLAIN, 12));
        lblMinMax.setBounds(129, 12, 162, 16);
        panel.add(lblMinMax);
        
        JLabel lblMinMax_1 = new JLabel(obj.getHeightLabel());
        lblMinMax_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblMinMax_1.setFont(new Font("Dialog", Font.PLAIN, 12));
        lblMinMax_1.setBounds(296, 12, 165, 16);
        panel.add(lblMinMax_1);
        
        JButton button = new JButton("Add");
        button.setFont(new Font("Dialog", Font.BOLD, 14));
        button.setBounds(868, 569, 83, 30);
        panel.add(button);
        energyOptionList.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		calcUI();
        		energyCost=obj.getEnergyOptionsPrice(energyOptionList.getSelectedIndex(),ui);
                energyOptionCostLabel.setText("+$"+String.format("%.2f", energyCost));
    			calcTotalCost();
        	}
        });
        glassList.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		calcUI();
        		glassTypeCost=obj.getGlassPrice(glassList.getSelectedIndex(),ui);
        		glassCostLabel.setText("+$"+String.format("%.2f", glassTypeCost));
    			calcTotalCost();
        	}
        });
        spacerList.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		calcUI();
        		spaceCost=obj.getSpacerPrice(spacerList.getSelectedIndex(),ui);
                spacerCostLabel.setText("+$"+String.format("%.2f", spaceCost));
    			calcTotalCost();
        	}
        });
        glassStrengthList.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		calcUI();
        		glassStrengthCost=obj.getGlassStrengthPrice(glassStrengthList.getSelectedIndex(),ui);
        		glassStrengthCostLabel.setText("+$"+String.format("%.2f", glassStrengthCost));
    			calcTotalCost();
        	}
        });
        
        button.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        	}
        });
        frameColorList.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		calcUI();
        		frameColorCost=obj.getFrameColorPrice(frameColorList.getSelectedIndex(),ui);
                frameColorCostLabel.setText("+$"+String.format("%.2f", frameColorCost));
    			calcTotalCost();
        	}
        });
        glassTintList.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		calcUI();
        		winTintCost=obj.getGlassTintPrice(glassTintList.getSelectedIndex(),ui);
        		glassTintCostLabel.setText("+$"+String.format("%.2f", winTintCost));
    			calcTotalCost();
        	}
        });
		mullList.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		calcUI();
        		mullCost=obj.getMullPrice(mullList.getSelectedIndex(), Integer.parseInt(mullOptionBox.getSelectedItem().toString()));
               mullCostLabel.setText("+$"+String.format("%.2f", mullCost));
    			calcTotalCost();
        	}
        });
        chckbxFoamFilledMain.addChangeListener(new ChangeListener() {
        	public void stateChanged(ChangeEvent arg0) {
        		if(chckbxFoamFilledMain.isSelected()){
        			foamCost=obj.getCustomExtrasPrice(0, ui);
                    foamLabel.setText("+$"+String.format("%.2f", foamCost));       			
        		}else{foamLabel.setText("+$0.00");foamCost=0;}
				calcTotalCost();
        	}
        });
        chckbxPolyfoamWrap.addChangeListener(new ChangeListener() {
        	public void stateChanged(ChangeEvent arg0) {
        		if(chckbxPolyfoamWrap.isSelected()){
        			wrapCost=obj.getCustomExtrasPrice(3, ui);
                    wrapLabel.setText("+$"+String.format("%.2f", wrapCost));       			
        		}else{wrapLabel.setText("+$0.00");wrapCost=0;}
				calcTotalCost();
        	}
        });
        chckbxLaminated.addChangeListener(new ChangeListener() {
        	public void stateChanged(ChangeEvent arg0) {
        		if(chckbxLaminated.isSelected()){
        			lamCost=obj.getCustomExtrasPrice(4, ui);
                    lamLabel.setText("+$"+String.format("%.2f", lamCost));       			
        		}else{lamLabel.setText("+$0.00");lamCost=0;}
				calcTotalCost();
        	}
        });
        mullOptionBox.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		calcUI();
        		mullCost=obj.getMullPrice(mullList.getSelectedIndex(), Integer.parseInt(mullOptionBox.getSelectedItem().toString()));
               mullCostLabel.setText("+$"+String.format("%.2f", mullCost));
    			calcTotalCost();
        	}
        });
        sash1Box2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        sash1Box2.setBounds(230, 0, 120, 20);
        panel_4.add(sash1Box2);
        
        sash1Box1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		//update next box
        		sash1Box2.setModel(new DefaultComboBoxModel(obj.getGridList2(sash1Box1.getSelectedIndex()).toArray(new String[obj.getGridList2(sash1Box1.getSelectedIndex()).size()])));
        		//update cost
        		calcUI();
        		sash1Cost=obj.getGridOptionsPrice(sash1Box2.getSelectedIndex(), sash1Box1.getSelectedIndex(), ui);
                sash1Label.setText("+$"+String.format("%.2f", sash1Cost));
    			calcTotalCost();
    			//update the next 2 boxes if same sash is checked

        	}
        });

//		addWindowListener(new WindowAdapter() {
//			@Override
//			public void windowOpened(WindowEvent arg0) {
//					energyCost=obj.getEnergyOptionsPrice(energyOptionList.getSelectedIndex(),ui);
//					glassTypeCost=obj.getGlassPrice(glassList.getSelectedIndex(),ui);
//					glassStrengthCost=obj.getGlassStrengthPrice(glassStrengthList.getSelectedIndex(),ui);
//					spaceCost=obj.getSpacerPrice(spacerList.getSelectedIndex(),ui);
//					winTintCost=obj.getGlassTintPrice(glassTintList.getSelectedIndex(),ui);
//					frameColorCost=obj.getFrameColorPrice(frameColorList.getSelectedIndex(),ui);
//					foamCost=obj.getCustomExtrasPrice(0, ui);
//					wrapCost=obj.getCustomExtrasPrice(3, ui);
//					lamCost=obj.getCustomExtrasPrice(4, ui);
//				    sash1Cost=obj.getGridOptionsPrice(comboBox_4.getSelectedIndex(), comboBox_3.getSelectedIndex(), ui);
//				    sash2Cost=obj.getGridOptionsPrice(comboBox_6.getSelectedIndex(), comboBox_5.getSelectedIndex(), ui);
//					mullCost=obj.getMullPrice(mullList.getSelectedIndex(), Integer.parseInt(mullOptionBox.getSelectedItem().toString()));
//	                spacerCostLabel.setText("+$"+String.format("%.2f", spaceCost));
//
//					
//					lamLabel.setText("+$"+String.format("%.2f", lamCost));       			   
//					mullCostLabel.setText("+$"+String.format("%.2f", mullCost));
//
//			}
//		});
        /*heightText.addKeyListener(new KeyAdapter() {

        	@Override
        	public void keyTyped(KeyEvent e) {
        		calcUI();
        		energyCost=obj.getEnergyOptionsPrice(energyOptionList.getSelectedIndex(),ui);
                energyOptionCostLabel.setText("+$"+String.format("%.2f", energyCost));
        		
        		
        		calcTotalCost();
        	}
        });*/
        widthText.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent de) {
            	calcUI();
				energyCost=obj.getEnergyOptionsPrice(energyOptionList.getSelectedIndex(),ui);
				glassTypeCost=obj.getGlassPrice(glassList.getSelectedIndex(),ui);
				glassStrengthCost=obj.getGlassStrengthPrice(glassStrengthList.getSelectedIndex(),ui);
				spaceCost=obj.getSpacerPrice(spacerList.getSelectedIndex(),ui);
				winTintCost=obj.getGlassTintPrice(glassTintList.getSelectedIndex(),ui);
				frameColorCost=obj.getFrameColorPrice(frameColorList.getSelectedIndex(),ui);
				foamCost=obj.getCustomExtrasPrice(0, ui);
				wrapCost=obj.getCustomExtrasPrice(3, ui);
				lamCost=obj.getCustomExtrasPrice(4, ui);
			    sash1Cost=obj.getGridOptionsPrice(sash1Box2.getSelectedIndex(), sash1Box1.getSelectedIndex(), ui);
				mullCost=obj.getMullPrice(mullList.getSelectedIndex(), Integer.parseInt(mullOptionBox.getSelectedItem().toString()));
                energyOptionCostLabel.setText("+$"+String.format("%.2f", energyCost));
        		glassCostLabel.setText("+$"+String.format("%.2f", glassTypeCost));
                spacerCostLabel.setText("+$"+String.format("%.2f", spaceCost));
        		glassStrengthCostLabel.setText("+$"+String.format("%.2f", glassStrengthCost));
                frameColorCostLabel.setText("+$"+String.format("%.2f", frameColorCost));
        		glassTintCostLabel.setText("+$"+String.format("%.2f", winTintCost));
                mullCostLabel.setText("+$"+String.format("%.2f", mullCost));
                foamLabel.setText("+$"+String.format("%.2f", foamCost));       			
                wrapLabel.setText("+$"+String.format("%.2f", wrapCost));       			
                lamLabel.setText("+$"+String.format("%.2f", lamCost));       		
                sash1Label.setText("+$"+String.format("%.2f", sash1Cost));
        		calcTotalCost();
            }

            @Override
            public void removeUpdate(DocumentEvent de) {
            	calcUI();
				energyCost=obj.getEnergyOptionsPrice(energyOptionList.getSelectedIndex(),ui);
				glassTypeCost=obj.getGlassPrice(glassList.getSelectedIndex(),ui);
				glassStrengthCost=obj.getGlassStrengthPrice(glassStrengthList.getSelectedIndex(),ui);
				spaceCost=obj.getSpacerPrice(spacerList.getSelectedIndex(),ui);
				winTintCost=obj.getGlassTintPrice(glassTintList.getSelectedIndex(),ui);
				frameColorCost=obj.getFrameColorPrice(frameColorList.getSelectedIndex(),ui);
				foamCost=obj.getCustomExtrasPrice(0, ui);
				wrapCost=obj.getCustomExtrasPrice(3, ui);
				lamCost=obj.getCustomExtrasPrice(4, ui);
			    sash1Cost=obj.getGridOptionsPrice(sash1Box2.getSelectedIndex(), sash1Box1.getSelectedIndex(), ui);
				mullCost=obj.getMullPrice(mullList.getSelectedIndex(), Integer.parseInt(mullOptionBox.getSelectedItem().toString()));
                energyOptionCostLabel.setText("+$"+String.format("%.2f", energyCost));
        		glassCostLabel.setText("+$"+String.format("%.2f", glassTypeCost));
                spacerCostLabel.setText("+$"+String.format("%.2f", spaceCost));
        		glassStrengthCostLabel.setText("+$"+String.format("%.2f", glassStrengthCost));
                frameColorCostLabel.setText("+$"+String.format("%.2f", frameColorCost));
        		glassTintCostLabel.setText("+$"+String.format("%.2f", winTintCost));
                mullCostLabel.setText("+$"+String.format("%.2f", mullCost));
                foamLabel.setText("+$"+String.format("%.2f", foamCost));       			
                wrapLabel.setText("+$"+String.format("%.2f", wrapCost));       			
                lamLabel.setText("+$"+String.format("%.2f", lamCost));       		
                sash1Label.setText("+$"+String.format("%.2f", sash1Cost));
        		calcTotalCost();
            }

            @Override
            public void changedUpdate(DocumentEvent de) {
            	calcUI();
				energyCost=obj.getEnergyOptionsPrice(energyOptionList.getSelectedIndex(),ui);
				glassTypeCost=obj.getGlassPrice(glassList.getSelectedIndex(),ui);
				glassStrengthCost=obj.getGlassStrengthPrice(glassStrengthList.getSelectedIndex(),ui);
				spaceCost=obj.getSpacerPrice(spacerList.getSelectedIndex(),ui);
				winTintCost=obj.getGlassTintPrice(glassTintList.getSelectedIndex(),ui);
				frameColorCost=obj.getFrameColorPrice(frameColorList.getSelectedIndex(),ui);
				foamCost=obj.getCustomExtrasPrice(0, ui);
				wrapCost=obj.getCustomExtrasPrice(3, ui);
				lamCost=obj.getCustomExtrasPrice(4, ui);
			    sash1Cost=obj.getGridOptionsPrice(sash1Box2.getSelectedIndex(), sash1Box1.getSelectedIndex(), ui);
				mullCost=obj.getMullPrice(mullList.getSelectedIndex(), Integer.parseInt(mullOptionBox.getSelectedItem().toString()));
                energyOptionCostLabel.setText("+$"+String.format("%.2f", energyCost));
        		glassCostLabel.setText("+$"+String.format("%.2f", glassTypeCost));
                spacerCostLabel.setText("+$"+String.format("%.2f", spaceCost));
        		glassStrengthCostLabel.setText("+$"+String.format("%.2f", glassStrengthCost));
                frameColorCostLabel.setText("+$"+String.format("%.2f", frameColorCost));
        		glassTintCostLabel.setText("+$"+String.format("%.2f", winTintCost));
                mullCostLabel.setText("+$"+String.format("%.2f", mullCost));
                foamLabel.setText("+$"+String.format("%.2f", foamCost));       			
                wrapLabel.setText("+$"+String.format("%.2f", wrapCost));       			
                lamLabel.setText("+$"+String.format("%.2f", lamCost));       		
                sash1Label.setText("+$"+String.format("%.2f", sash1Cost));
        		calcTotalCost();
            }
        });
        heightText.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent de) {
            	calcUI();
				energyCost=obj.getEnergyOptionsPrice(energyOptionList.getSelectedIndex(),ui);
				glassTypeCost=obj.getGlassPrice(glassList.getSelectedIndex(),ui);
				glassStrengthCost=obj.getGlassStrengthPrice(glassStrengthList.getSelectedIndex(),ui);
				spaceCost=obj.getSpacerPrice(spacerList.getSelectedIndex(),ui);
				winTintCost=obj.getGlassTintPrice(glassTintList.getSelectedIndex(),ui);
				frameColorCost=obj.getFrameColorPrice(frameColorList.getSelectedIndex(),ui);
				foamCost=obj.getCustomExtrasPrice(0, ui);
				wrapCost=obj.getCustomExtrasPrice(3, ui);
				lamCost=obj.getCustomExtrasPrice(4, ui);
			    sash1Cost=obj.getGridOptionsPrice(sash1Box2.getSelectedIndex(), sash1Box1.getSelectedIndex(), ui);
				mullCost=obj.getMullPrice(mullList.getSelectedIndex(), Integer.parseInt(mullOptionBox.getSelectedItem().toString()));
                energyOptionCostLabel.setText("+$"+String.format("%.2f", energyCost));
        		glassCostLabel.setText("+$"+String.format("%.2f", glassTypeCost));
                spacerCostLabel.setText("+$"+String.format("%.2f", spaceCost));
        		glassStrengthCostLabel.setText("+$"+String.format("%.2f", glassStrengthCost));
                frameColorCostLabel.setText("+$"+String.format("%.2f", frameColorCost));
        		glassTintCostLabel.setText("+$"+String.format("%.2f", winTintCost));
                mullCostLabel.setText("+$"+String.format("%.2f", mullCost));
                foamLabel.setText("+$"+String.format("%.2f", foamCost));       			
                wrapLabel.setText("+$"+String.format("%.2f", wrapCost));       			
                lamLabel.setText("+$"+String.format("%.2f", lamCost));       		
                sash1Label.setText("+$"+String.format("%.2f", sash1Cost));
        		calcTotalCost();
            }

            @Override
            public void removeUpdate(DocumentEvent de) {
            	calcUI();
				energyCost=obj.getEnergyOptionsPrice(energyOptionList.getSelectedIndex(),ui);
				glassTypeCost=obj.getGlassPrice(glassList.getSelectedIndex(),ui);
				glassStrengthCost=obj.getGlassStrengthPrice(glassStrengthList.getSelectedIndex(),ui);
				spaceCost=obj.getSpacerPrice(spacerList.getSelectedIndex(),ui);
				winTintCost=obj.getGlassTintPrice(glassTintList.getSelectedIndex(),ui);
				frameColorCost=obj.getFrameColorPrice(frameColorList.getSelectedIndex(),ui);
				foamCost=obj.getCustomExtrasPrice(0, ui);
				wrapCost=obj.getCustomExtrasPrice(3, ui);
				lamCost=obj.getCustomExtrasPrice(4, ui);
			    sash1Cost=obj.getGridOptionsPrice(sash1Box2.getSelectedIndex(), sash1Box1.getSelectedIndex(), ui);
				mullCost=obj.getMullPrice(mullList.getSelectedIndex(), Integer.parseInt(mullOptionBox.getSelectedItem().toString()));
                energyOptionCostLabel.setText("+$"+String.format("%.2f", energyCost));
        		glassCostLabel.setText("+$"+String.format("%.2f", glassTypeCost));
                spacerCostLabel.setText("+$"+String.format("%.2f", spaceCost));
        		glassStrengthCostLabel.setText("+$"+String.format("%.2f", glassStrengthCost));
                frameColorCostLabel.setText("+$"+String.format("%.2f", frameColorCost));
        		glassTintCostLabel.setText("+$"+String.format("%.2f", winTintCost));
                mullCostLabel.setText("+$"+String.format("%.2f", mullCost));
                foamLabel.setText("+$"+String.format("%.2f", foamCost));       			
                wrapLabel.setText("+$"+String.format("%.2f", wrapCost));       			
                lamLabel.setText("+$"+String.format("%.2f", lamCost));       		
                sash1Label.setText("+$"+String.format("%.2f", sash1Cost));
        		calcTotalCost();
            }

            @Override
            public void changedUpdate(DocumentEvent de) {
            	calcUI();
				energyCost=obj.getEnergyOptionsPrice(energyOptionList.getSelectedIndex(),ui);
				glassTypeCost=obj.getGlassPrice(glassList.getSelectedIndex(),ui);
				glassStrengthCost=obj.getGlassStrengthPrice(glassStrengthList.getSelectedIndex(),ui);
				spaceCost=obj.getSpacerPrice(spacerList.getSelectedIndex(),ui);
				winTintCost=obj.getGlassTintPrice(glassTintList.getSelectedIndex(),ui);
				frameColorCost=obj.getFrameColorPrice(frameColorList.getSelectedIndex(),ui);
				foamCost=obj.getCustomExtrasPrice(0, ui);
				wrapCost=obj.getCustomExtrasPrice(3, ui);
				lamCost=obj.getCustomExtrasPrice(4, ui);
			    sash1Cost=obj.getGridOptionsPrice(sash1Box2.getSelectedIndex(), sash1Box1.getSelectedIndex(), ui);
				mullCost=obj.getMullPrice(mullList.getSelectedIndex(), Integer.parseInt(mullOptionBox.getSelectedItem().toString()));
                energyOptionCostLabel.setText("+$"+String.format("%.2f", energyCost));
        		glassCostLabel.setText("+$"+String.format("%.2f", glassTypeCost));
                spacerCostLabel.setText("+$"+String.format("%.2f", spaceCost));
        		glassStrengthCostLabel.setText("+$"+String.format("%.2f", glassStrengthCost));
                frameColorCostLabel.setText("+$"+String.format("%.2f", frameColorCost));
        		glassTintCostLabel.setText("+$"+String.format("%.2f", winTintCost));
                mullCostLabel.setText("+$"+String.format("%.2f", mullCost));
                foamLabel.setText("+$"+String.format("%.2f", foamCost));       			
                wrapLabel.setText("+$"+String.format("%.2f", wrapCost));       			
                lamLabel.setText("+$"+String.format("%.2f", lamCost));       		
                sash1Label.setText("+$"+String.format("%.2f", sash1Cost));
        		calcTotalCost();
            }
        });
		calcTotalCost();
        return panel;
        
    }


	public void actionPerformed(ActionEvent e){
	}
	
}
