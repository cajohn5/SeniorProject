/*Author Mark DiFiglio
 * 4/4/2017
 * 
 * This class holds the main that creates a holder object which is then passed to the MasterExcelReader to load from the excel file.
 * After that the holder object is passed to the gui_classes which runs the rest of the program.
 */

package main;

import java.io.FileNotFoundException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

import excel_reader_classes.MasterExcelReading;
import gui_classes.Home_frame;
import gui_classes.style_type_frame;
import product_classes.Holder;
import product_classes.Windows;

public class run {
	private JPanel contentPane;
	private static Home_frame room_frame;
	
	private static List<Windows> windowList;
	
	public JButton doneButton;
	

	public static void main(String[] args) {
		
		//Initialize the object that holds all the products information
		Holder holder = new Holder();
		
		//call to master excel reader to load the excel file into the program
		MasterExcelReading mer = new MasterExcelReading();
		
		try {
			mer.returnUpdatedHolder(holder);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		System.out.println(holder.getProductList().size());
		//call gui_classes master file here and let gui_classes control the rest of the program.
		//gui_classes call
		
		

		/* home = new Home_frame("Home", windowList);
		home.setVisible(true);*/
		style_type_frame a = new style_type_frame("Style", windowList, holder);
		a.setVisible(true);
		
		//for testing/information
		
		//testing frameColorNum
	/*	ArrayList<ArrayList<Float>> frameNum = new ArrayList<ArrayList<Float>>();
		frameNum.add(new ArrayList<>(Arrays.asList(new Float(63), new Float(253))));
		frameNum.add(new ArrayList<>(Arrays.asList(new Float(73), new Float(281))));
						
		holder.addDynaWeld(new DW_Extra());
		
		((DW_Extra) holder.getDynaWeld().get(0)).setFrameColorNum(frameNum);
		((DW_Extra) holder.getDynaWeld().get(0)).setMaxUI(new ArrayList<Float>(Arrays.asList((float) 120)));
		System.out.println(((DW_Extra) holder.getDynaWeld().get(0)).getFrameColorPrice(0, 73));//works
		
		
		
		((DW_Extra) holder.getDynaWeld().get(0)).setProductName("DynaWeld Double Hung 3020");		
		((DW_Extra) holder.getDynaWeld().get(0)).setFrameColor(new ArrayList<>(Arrays.asList("White(W)")));
		((DW_Extra) holder.getDynaWeld().get(0)).setMaxUI(new ArrayList<>(Arrays.asList((float) 160)));
		((DW_Extra) holder.getDynaWeld().get(0)).setPriceMultiplier((float) 1.0);
		
	
		System.out.println(holder.getDynaWeld().size());
		System.out.println(((Products) holder.getDynaWeld().get(0)).getProductName());
		System.out.println(((Products) holder.getDynaWeld().get(0)).getClassName());
		if (((Products) holder.getDynaWeld().get(0)).getClassName().compareTo("Products") == 0){
			System.out.println(((DW_Extra) holder.getDynaWeld().get(0)).getPriceMultiplier());
		}
		
		
		new ArrayList<ArrayList<String>>(Arrays.asList(new ArrayList<>(Arrays.asList(""))));
		
		holder.addUltraWeld(new Windows());
		((Windows) holder.getUltraWeld().get(0)).setMiniBlindsLabel("hi");
		System.out.println(((Windows) holder.getUltraWeld().get(0)).getMiniBlindsLabel());*/
	}
}
