package excel_reader_classes;

import java.io.FileNotFoundException;

import product_classes.Holder;

/**
 * Creates instances of classes inside <code>excel_reader</code> package.
 * Places them into a method that takes a <code>Holder</code> object 
 * from the <code>product_classes</code> package.
 * Returns a <code>Holder</code> object in only used method.
 * Used in the <code>run</code> class of the <code>main</code> package.
 * @author Kyle Harbour
 *
 */
public class MasterExcelReading
	{
		//dynaweld products
		private ExcelReadDW_DH DW_DH = new ExcelReadDW_DH();
		private ExcelReadDW_Pic DW_Pic = new ExcelReadDW_Pic();
		private ExcelReadDW_2Glide DW_2Glide = new ExcelReadDW_2Glide();
		private ExcelReadDW_3Glide DW_3Glide = new ExcelReadDW_3Glide();
		private ExcelReadDW_Hop DW_Hop = new ExcelReadDW_Hop();
		private ExcelReadDW_PD DW_PD = new ExcelReadDW_PD();
		
		//twp products
		private ExcelReadTWP_DH TWP_DH = new ExcelReadTWP_DH();
		private ExcelReadTWP_Pic TWP_Pic = new ExcelReadTWP_Pic();
		private ExcelReadTWP_2Glide TWP_2Glide = new ExcelReadTWP_2Glide();
		private ExcelReadTWP_3Glide TWP_3Glide = new ExcelReadTWP_3Glide();
		private ExcelReadTWP_Shapes TWP_Shapes = new ExcelReadTWP_Shapes();
		private ExcelReadTWP_PD TWP_PD = new ExcelReadTWP_PD();
		private ExcelReadTWP_CustPD TWP_CustPD = new ExcelReadTWP_CustPD();

		
		//uw products
		private ExcelReadUW_DH UW_DH = new ExcelReadUW_DH();
		private ExcelReadUW_Pic UW_Pic = new ExcelReadUW_Pic();
		private ExcelReadUW_2Glide UW_2Glide = new ExcelReadUW_2Glide();
		private ExcelReadUW_3Glide UW_3Glide = new ExcelReadUW_3Glide();
		private ExcelReadUW_Awn UW_Awn = new ExcelReadUW_Awn();
		private ExcelReadUW_1Case UW_1Case = new ExcelReadUW_1Case();
		private ExcelReadUW_2Case UW_2Case = new ExcelReadUW_2Case();
		private ExcelReadUW_3Case UW_3Case = new ExcelReadUW_3Case();
		private ExcelReadUW_Garden UW_Garden = new ExcelReadUW_Garden();
		private ExcelReadUW_Shapes UW_Shapes = new ExcelReadUW_Shapes();
		private ExcelReadUW_PD UW_PD = new ExcelReadUW_PD();
		private ExcelReadUW_CustPD UW_CustPD = new ExcelReadUW_CustPD();
		private ExcelReadUW_TransPD UW_TransPD = new ExcelReadUW_TransPD();
		private ExcelReadUW_PDSidelite UW_PDSidelite = new ExcelReadUW_PDSidelite();
		
		//bays and bows
		private ExcelRead_BaysBows Bay_Bows = new ExcelRead_BaysBows();
		
		/**
		 * 
		 * @param temp
		 * @return
		 * @throws FileNotFoundException
		 */
		public Holder returnUpdatedHolder(Holder temp) throws FileNotFoundException
		{
			FileOpenClose.openFile();
			
			temp.addDynaWeld(DW_DH.createObject()); 
			temp.addDynaWeld(DW_Pic.createObject());
			temp.addDynaWeld(DW_2Glide.createObject()); 
			temp.addDynaWeld(DW_3Glide.createObject()); 
			temp.addDynaWeld(DW_Hop.createObject());
			temp.addDynaWeld(DW_PD.createObject());
			
			temp.addThermalWeldPlus(TWP_DH.createObject());
    		temp.addThermalWeldPlus(TWP_Pic.createObject()); 
    		temp.addThermalWeldPlus(TWP_2Glide.createObject()); 
    		temp.addThermalWeldPlus(TWP_3Glide.createObject()); 
			temp.addShapes(TWP_Shapes.createObject());   
			temp.addThermalWeldPlus(TWP_PD.createObject());
			temp.addThermalWeldPlus(TWP_CustPD.createObject());
    		
			temp.addUltraWeld(UW_DH.createObject());
    		temp.addUltraWeld(UW_Pic.createObject()); 
    		temp.addUltraWeld(UW_2Glide.createObject());
    		temp.addUltraWeld(UW_3Glide.createObject()); 
    		temp.addUltraWeld(UW_Awn.createObject());
    		temp.addUltraWeld(UW_1Case.createObject()); 
    		temp.addUltraWeld(UW_2Case.createObject()); 
    		temp.addUltraWeld(UW_3Case.createObject());
    		temp.addUltraWeld(UW_Garden.createObject());
    		temp.addShapes(UW_Shapes.createObject());
   		
			temp.addUltraWeld(UW_PD.createObject());
			temp.addUltraWeld(UW_CustPD.createObject());
			temp.addUltraWeld(UW_TransPD.createObject());
    		temp.addUltraWeld(UW_PDSidelite.createObject());
   		
    		temp.addBay_Bows(Bay_Bows.createObject());
			
    		FileOpenClose.closeFile();
    		
			return temp;
		}
		
		/**
		 * Tests a specific instance of a class. Not to be used unless testing.
		 */
		public void testObject()
		{
			System.out.println(Bay_Bows.testObject());
		}
	}
