package excel_reader_classes; 

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import product_classes.Bays_BowsHolder;
import product_classes.Bays_Bows;

/**
 * Reads the Bays & Bows sheet, parses the necessary
 * information and creates <code>Bays_Bows_Holder</code> object 
 * of the <code>product_classes</code> package 
 * to be used in <code>MasterExcelReading</code>.
 * @author Kyle Harbour
 *
 */
@SuppressWarnings("deprecation")
public class ExcelRead_BaysBows
	{
		private Bays_BowsHolder BAYSBOWS_obj = new Bays_BowsHolder();
		private int sheetIndex;
		private String sheetName = "Bays & Bows";
		private XSSFSheet sheet;
		private XSSFRow row;
		private int rowIndex;
		
		private  int getRowIndex ()
			{
				return rowIndex;
			}

		private void setRowIndex (int rowIndex)
			{
				this.rowIndex = rowIndex;
			}
		
		private  void updateRowIndex(int update)
    		{
    			rowIndex = getRowIndex() + update;
    		}

		/**
		 * 
		 * @param sheetName
		 */
		private  void setSheetIndex(String sheetName)
    		{
    			sheetIndex = FileOpenClose.wb.getSheetIndex(sheetName);
    		}
		
		/**
		 * 
		 * @return
		 */
		private  int getSheetIndex()
    		{
    			return sheetIndex;
    		}
		
		/**
		 * 
		 * @param startRow
		 * @return
		 */
		private ArrayList<String> readOneRow(int startRow)
			{
				ArrayList<String> obj = new ArrayList<String>();
				row = sheet.getRow(startRow);
				
				int lastColumn = row.getLastCellNum();
		
					for (int cn = 0; cn < lastColumn; cn++) 
						{
							Cell cell = row.getCell(cn, XSSFRow.RETURN_BLANK_AS_NULL);
							if (cell == null) 
								{
									break;
								} 
							else 
								{
									obj.add(cell.toString());
								}
					    }
				return obj;
			}
		
		/**
		 * 
		 * @param startRow
		 * @return
		 */
		private ArrayList<Float> readOneFloatRow(int startRow)
			{
				ArrayList<Float> obj = new ArrayList<Float>();
				row = sheet.getRow(startRow);
				
				int lastColumn = row.getLastCellNum();
		
					for (int cn = 1; cn < lastColumn; cn++) 
						{
							Cell cell = row.getCell(cn, XSSFRow.RETURN_BLANK_AS_NULL);
							
							if ( (cell == null) ) 
								{
									continue;
								} 
							else if (cell.toString().equals("N/A"))
								{
									obj.add((float) -1);
								}
							else 
								{
									obj.add(Float.parseFloat(cell.toString()));
								}
					    }
				return obj;
			}
		
		/**
		 * 
		 * @param startRow
		 * @param startCol
		 * @return
		 */
		private ArrayList<ArrayList<Float>> readFloatGroup(int startRow, int startCol)
			{
				row = sheet.getRow(startRow);
				ArrayList<ArrayList<Float>> obj = new ArrayList<ArrayList<Float>>();
				int numRows = 0;
				int tempRowIndex = 0;
				int controlRow = Integer.valueOf(startRow);
				
				while( (!(row == null)) && (row.getCell(0, Row.RETURN_BLANK_AS_NULL) != null) )
					{
						numRows++;
						startRow++;
						row = sheet.getRow(startRow);
					}
				
				 for(int i = tempRowIndex; i < numRows; i++)
					{
						obj.add(new ArrayList<Float>());
					}
				 
				
				
				
				while(tempRowIndex < numRows)
					{
						XSSFRow rows = sheet.getRow(controlRow); 
						
						if (rows == null) 
							{
					          break;
							}
		
						for (int cn = startCol; cn <= rows.getLastCellNum(); cn++) 
					    	   {
						          Cell cell = rows.getCell(cn, XSSFRow.RETURN_BLANK_AS_NULL);
						          
						          if(cell == null)
							          {
							        	  break;
							          }
						          else if (cell.toString().equals("N/A"))
						        	  {
						        		  float temp = 0;
						        		  obj.get(tempRowIndex).add(temp);
						        	  } 
						          else 
						        	  {
						        		  obj.get(tempRowIndex).add(Float.parseFloat(cell.toString()));
						        	  }
					      }
					       controlRow++;
					       tempRowIndex++; 
					       
				    }
				updateRowIndex(numRows + 1);
				return obj;
			}
		
		/**
		 * 
		 * @param startRow
		 * @param startCol
		 * @return
		 */
		private ArrayList<ArrayList<String>> readStringGroup(int startRow, int startCol)
			{
				row = sheet.getRow(startRow);
				ArrayList<ArrayList<String>> obj = new ArrayList<ArrayList<String>>();
				int numRows = 0;
				int tempRowIndex = 0;
				int controlRow = Integer.valueOf(startRow);
				
				while( (!(row == null)) && (row.getCell(0, Row.RETURN_BLANK_AS_NULL) != null) )
					{
						numRows++;
						row = sheet.getRow(startRow++);
					}
				
				for(int i = tempRowIndex + 1; i < numRows; i++)
					{
						obj.add(new ArrayList<String>());
					}
				
				while(tempRowIndex < numRows)
					{
						XSSFRow rows = sheet.getRow(controlRow);
					       
						if (rows == null) 
							{
					          break;
							}
		
					       for (int cn = startCol; cn <= rows.getLastCellNum(); cn++) 
					    	   {
						          Cell cell = rows.getCell(cn, XSSFRow.RETURN_BLANK_AS_NULL);
						          
						          if(cell == null)
							          {
							        	  break;
							          }
						          else
						        	  {
						        		  obj.get(tempRowIndex).add(cell.toString());
						        	  }
					       }
					       controlRow++;
					       tempRowIndex++;
				    }
				updateRowIndex(numRows + 1);
				return obj;
			}
		
		/**
		 * 
		 * @param startRow
		 * @param startCol
		 * @return
		 */
		private ArrayList<ArrayList<String>> readBayBowGroup(int startRow, int startCol)
			{
				row = sheet.getRow(startRow);
				ArrayList<ArrayList<String>> obj = new ArrayList<ArrayList<String>>();
				int numRows = 0;
				int tempRowIndex = 0;
				int controlRow = Integer.valueOf(startRow);
				
				while( (!(row == null)) && (row.getCell(0, Row.RETURN_BLANK_AS_NULL) != null) )
					{
						numRows++;
						row = sheet.getRow(startRow++);
					}
				
				for(int i = tempRowIndex + 1; i < numRows; i++)
					{
						obj.add(new ArrayList<String>());
					}
				
				while(tempRowIndex < numRows)
					{
						XSSFRow rows = sheet.getRow(controlRow);
					       
						if (rows == null) 
							{
					          break;
							}
		
					       for (int cn = startCol; cn <= rows.getLastCellNum(); cn++) 
					    	   {
						          Cell cell = rows.getCell(cn, XSSFRow.RETURN_BLANK_AS_NULL);
						          
						          if(cell == null)
							          {
							        	  break;
							          }
						          else
						        	  {
						        		  obj.get(tempRowIndex).add(cell.toString());
						        	  }
					       }
					       controlRow++;
					       tempRowIndex++;
				    }
				updateRowIndex(numRows);
				return obj;
			}
			
		/**
		 * 
		 * @param startRow
		 * @return
		 */
		private ArrayList<String> readOptionsList(int startRow)
			{
				ArrayList<String> obj = new ArrayList<String>();
				row = sheet.getRow(startRow);
				int numRows = 0;
				int tempRowIndex = 0;
				int controlRow = Integer.valueOf(startRow);

				while( (!(row == null)) && (!(row.getCell(0).toString().length() == 0)) )
					{
						numRows++;
						row = sheet.getRow(startRow++);
					}
				
				while(tempRowIndex < numRows)
					{
						XSSFRow rows = sheet.getRow(controlRow);
					       
						if (rows == null) 
							{
					          break;
							}
		
					       for (int cn = 0; cn < 1; cn++) 
					    	   {
						          Cell cell = rows.getCell(cn, XSSFRow.RETURN_BLANK_AS_NULL);
						          if (cell == null) 
						        	  {
						        		  break;
						        	  } 
						          else 
						        	  {
						        		  obj.add(cell.toString());
						        	  }
					       }
					       controlRow++;
					       tempRowIndex++;
				    }
				return obj;
			}
		
		/**
		 * 
		 * @return
		 */
		private float readPriceMultiplier()
			{
				FormulaEvaluator evaluator = FileOpenClose.wb.getCreationHelper().createFormulaEvaluator();
	
				// suppose your formula is in B4
				CellReference cellReference = new CellReference("B4");
				XSSFRow row = sheet.getRow(cellReference.getRow());
				Cell cell = row.getCell(cellReference.getCol()); 
	
				if (cell!=null) 
				{
				    switch (evaluator.evaluateInCell(cell).getCellType()) 
				    {
				        case Cell.CELL_TYPE_BOOLEAN:
				            cell.getBooleanCellValue();
				            break;
				        case Cell.CELL_TYPE_NUMERIC:
				          return  (float) cell.getNumericCellValue();
						case Cell.CELL_TYPE_STRING:
				            cell.getStringCellValue();
				            break;
				        case Cell.CELL_TYPE_BLANK:
				            break;
				        case Cell.CELL_TYPE_ERROR:
				            cell.getErrorCellValue();
				            break;
	
				        // CELL_TYPE_FORMULA will never occur
				        case Cell.CELL_TYPE_FORMULA:
				            break;
				    }
				}
				
				return 0;
			}
		
		/**
		 * 
		 * @return
		 */
		private ArrayList<String> readMergedRow()
    		{
    			Iterator<Row> rowIterator = sheet.iterator();
    			ArrayList<String> temp = new ArrayList<String>();
    			
    			
    			while (rowIterator.hasNext()) 
    				{
    		        XSSFRow row = (XSSFRow) rowIterator.next();

    		        //For each row, iterate through all the columns
    		        Iterator<Cell> cellIterator = row.cellIterator();

    		        outer:
    		        while (cellIterator.hasNext()) 
    		        	{
    		        		Cell cell = cellIterator.next();

        		            //will iterate over the Merged cells
        		            for (int i = 0; i < sheet.getNumMergedRegions(); i++) 
        		            	{
            		                CellRangeAddress region = sheet.getMergedRegion(i); //Region of merged cells
        
            		                int colIndex = region.getFirstColumn(); //number of columns merged
            		                int rowNum = region.getFirstRow();      //number of rows merged
            		                //check first cell of the region
            		                if (rowNum == cell.getRowIndex() && colIndex == cell.getColumnIndex()) 
            		                	{
                		                    temp.add(sheet.getRow(rowNum).getCell(colIndex).toString());
                		                    continue outer;
            		                	}
    		            }
        		            //the data in merge cells is always present on the first cell. All other cells(in merged region) are considered blank
        		            if ( (cell.getCellType() == Cell.CELL_TYPE_BLANK || cell == null) ) 
        		            	{
        		            		continue;
        		            	}
    		        }
    		    }
    			return temp;
    		}
		
		/**
		 * 
		 */
		private void parseProductName()
			{
				setSheetIndex(sheetName);
				sheet = FileOpenClose.wb.getSheetAt(getSheetIndex());
				ArrayList<String> temp = readOneRow(0);
				BAYSBOWS_obj.setProductName(temp.get(0));
			}
		
		/**
		 * 
		 */
		private void parseClassName()
			{
				ArrayList<String> temp = readOneRow(1);
				BAYSBOWS_obj.setClassName(temp.get(0));	
			}
		
		/**
		 * 
		 */
		private void parsePriceMultiplier()
			{
				float mult = readPriceMultiplier();
				ArrayList<Float> temp = new ArrayList<Float>();
				temp.add(mult);
				BAYSBOWS_obj.setPriceMultiplier(temp.get(0));
			}
		
		/**
		 * 
		 */
		private void parseSize()
			{
				ArrayList<Float> temp = readOneFloatRow(6);
				BAYSBOWS_obj.setSize(temp);
				
				setRowIndex(8);
			}
		
		/**
		 * 
		 */
		private void parsedGridOptions()
			{
				//first row
				ArrayList<String> temp = readOneRow(getRowIndex()-1); //subtract one...cause math
				
				//label
				BAYSBOWS_obj.setGridOptionsLabel(temp.get(0));
				
				//options row (merged)
				ArrayList<String> temp1 = new ArrayList<String>();
				temp1 = readMergedRow();
				temp1.remove(temp1.size() - 1);
				temp1.remove(temp1.size() - 1);
				temp1.remove(temp1.size() - 1);
				temp1.remove(temp1.size() - 1);
				temp1.remove(temp1.size() - 1);
				temp1.remove(temp1.size() - 1);
				temp1.remove(temp1.size() - 1);
				BAYSBOWS_obj.setGridOptions(temp1);
				
				//list
				ArrayList<String> temp2 = new ArrayList<String>();
				temp2 = readOptionsList(getRowIndex() + 1); //add one to skip type
				BAYSBOWS_obj.setGridOptionsList(temp2);
				
				//float matrix (2-D array)
				BAYSBOWS_obj.setGridOptionsNum(readFloatGroup(getRowIndex() + 1,1));
				updateRowIndex(1);
			}
		
		/**
		 * 
		 */
		private void parsedEnergyOptions()
			{
				//first row
				ArrayList<String> temp = readOneRow(getRowIndex());
				
				//label
				BAYSBOWS_obj.setEnergyOptionsLabel(temp.get(0));
				
				//list
				ArrayList<String> temp2 = new ArrayList<String>();
				temp2 = readOptionsList(getRowIndex() + 1);
				BAYSBOWS_obj.setEnergyOptionsList(temp2);
				
				//string matrix (2-D array)
				BAYSBOWS_obj.setEnergyOptionsNum(readStringGroup(getRowIndex() + 1,1));
			}
		
		/**
		 * 
		 */
		private void parsedGlassStrength()
			{
				//first row
				ArrayList<String> temp = readOneRow(getRowIndex());
				
				//label
				BAYSBOWS_obj.setGlassStrengthLabel(temp.get(0));;
				
				//list
				ArrayList<String> temp2 = new ArrayList<String>();
				temp2 = readOptionsList(getRowIndex() + 1);
				BAYSBOWS_obj.setGlassStrengthList(temp2);
				
				//string matrix (2-D array)
				BAYSBOWS_obj.setGlassStrengthNum(readStringGroup(getRowIndex() + 1,1));
			}
		
		/**
		 * 
		 */
		private void parsedScreen()
			{
				//first row
				ArrayList<String> temp = readOneRow(getRowIndex());
				
				//label
				BAYSBOWS_obj.setScreenLabel(temp.get(0));;
				
				//list
				ArrayList<String> temp2 = new ArrayList<String>();
				temp2 = readOptionsList(getRowIndex() + 1);
				BAYSBOWS_obj.setScreenList(temp2);
				
				//string matrix (2-D array)
				BAYSBOWS_obj.setScreenNum(readStringGroup(getRowIndex() + 1,1));
			}
		
		/**
		 * 
		 */
		private void parsedScreenMesh()
			{
				//first row
				ArrayList<String> temp = readOneRow(getRowIndex());
				
				//label
				BAYSBOWS_obj.setScreenMeshLabel(temp.get(0));;
				
				//list
				ArrayList<String> temp2 = new ArrayList<String>();
				temp2 = readOptionsList(getRowIndex() + 1);
				BAYSBOWS_obj.setScreenMeshList(temp2);
				
				//string matrix (2-D array)
				BAYSBOWS_obj.setScreenMeshNum(readStringGroup(getRowIndex() + 1,1));
			}
		
		/**
		 * 
		 */
		private void parsedSpacer()
			{
				//first row
				ArrayList<String> temp = readOneRow(getRowIndex());
				
				//label
				BAYSBOWS_obj.setSpacerLabel(temp.get(0));;
				
				//list
				ArrayList<String> temp2 = new ArrayList<String>();
				temp2 = readOptionsList(getRowIndex() + 1);
				BAYSBOWS_obj.setSpacerList(temp2);
				
				//string matrix (2-D array)
				BAYSBOWS_obj.setSpacerNum(readStringGroup(getRowIndex() + 1,1));
			}
		
		/**
		 * 
		 */
		private void parsedGlassTint()
			{
				//first row
				ArrayList<String> temp = readOneRow(getRowIndex());
				
				//label
				BAYSBOWS_obj.setGlassTintLabel(temp.get(0));;
				
				//list
				ArrayList<String> temp2 = new ArrayList<String>();
				temp2 = readOptionsList(getRowIndex() + 1);
				BAYSBOWS_obj.setGlassTintList(temp2);
				
				//string matrix (2-D array)
				BAYSBOWS_obj.setGlassTintNum(readStringGroup(getRowIndex() + 1,1));
			}
		
		/**
		 * 
		 */
		private void parsedExteriorPaint()
			{
				//first row
				ArrayList<String> temp = readOneRow(getRowIndex());
				
				//label
				BAYSBOWS_obj.setExteriorPaintLabel(temp.get(0));;
				
				//list
				ArrayList<String> temp2 = new ArrayList<String>();
				temp2 = readOptionsList(getRowIndex() + 1);
				BAYSBOWS_obj.setExteriorPaintList(temp2);
				
				//string matrix (2-D array)
				BAYSBOWS_obj.setExteriorPaintNum(readStringGroup(getRowIndex() + 1,1));
			}
		
		/**
		 * 
		 */
		private void parsedCustomExtras()
			{
				//first row
				ArrayList<String> temp = readOneRow(getRowIndex());
				
				//label
				BAYSBOWS_obj.setCustomExtrasLabel(temp.get(0));;
				
				//list
				ArrayList<String> temp2 = new ArrayList<String>();
				temp2 = readOptionsList(getRowIndex() + 1);
				BAYSBOWS_obj.setCustomExtrasList(temp2);
				
				//string matrix (2-D array)
				BAYSBOWS_obj.setCustomExtrasNum(readStringGroup(getRowIndex() + 1,1));
			}
		
		/**
		 * 
		 */
		private void parsedLockColor()
			{
				//first row
				ArrayList<String> temp = readOneRow(getRowIndex());
				
				//label
				BAYSBOWS_obj.setLockColorLabel(temp.get(0));;
				
				//list
				ArrayList<String> temp2 = new ArrayList<String>();
				temp2 = readOptionsList(getRowIndex() + 2);
				BAYSBOWS_obj.setLockColorList(temp2);
				
				//string matrix (2-D array)
				BAYSBOWS_obj.setLockColorNum(readStringGroup(getRowIndex() + 1,1));
				updateRowIndex(1);
			}
		
		/**
		 * 
		 */
		private void parsedAccessories()
			{
				//first row
				ArrayList<String> temp = readOneRow(getRowIndex());
				
				//label
				BAYSBOWS_obj.setAccessoriesLabel(temp.get(0));
				
				//list
				ArrayList<String> temp2 = new ArrayList<String>();
				temp2 = readOptionsList(getRowIndex() + 1);
				BAYSBOWS_obj.setAccessoriesList(temp2);
				
				//string matrix (2-D array)
				BAYSBOWS_obj.setAccessoriesNum(readStringGroup(getRowIndex() + 1,1));
			}
		
		/**
		 * 
		 */
		private void parsedPlastic()
			{
				//first row
				ArrayList<String> temp = readOneRow(getRowIndex());
				
				//label
				BAYSBOWS_obj.setPlasticLabel(temp.get(0));
				
				//list
				ArrayList<String> temp2 = new ArrayList<String>();
				temp2 = readOptionsList(getRowIndex() + 1);
				BAYSBOWS_obj.setPlasticList(temp2);
				
				//string matrix (2-D array)
				BAYSBOWS_obj.setPlasticNum(readStringGroup(getRowIndex() + 1,1));
			}
		
		/**
		 * 
		 */
		private void parsedSeats()
			{
				//first row
				ArrayList<String> temp = readOneRow(getRowIndex());
				
				//label
				BAYSBOWS_obj.setAvoniteLabel(temp.get(0));
				
				//list
				ArrayList<String> temp2 = new ArrayList<String>();
				temp2 = readOptionsList(getRowIndex() + 1);
				BAYSBOWS_obj.setAvoniteList(temp2);
				
				//string matrix (2-D array)
				BAYSBOWS_obj.setAvoniteNum(readStringGroup(getRowIndex() + 1,1));
			}
		
		/**
		 * 
		 */
		private void parsedPrePainted()
			{
				//first row
				ArrayList<String> temp = readOneRow(getRowIndex());
				
				//label
				BAYSBOWS_obj.setPrepaintLabel(temp.get(0));
				
				//list
				ArrayList<String> temp2 = new ArrayList<String>();
				temp2 = readOptionsList(getRowIndex() + 1);
				BAYSBOWS_obj.setPrepaintList(temp2);
				
				//string matrix (2-D array)
				BAYSBOWS_obj.setPrepaintNum(readStringGroup(getRowIndex() + 1,1));
			}
		
		/**
		 * 
		 */
		private void parsedCasing()
			{
				//first row
				ArrayList<String> temp = readOneRow(getRowIndex());
				
				//label
				BAYSBOWS_obj.setAdditionalLabel(temp.get(0));
				
				//list
				ArrayList<String> temp2 = new ArrayList<String>();
				temp2 = readOptionsList(getRowIndex() + 1);
				BAYSBOWS_obj.setAdditionalList(temp2);
				
				//string matrix (2-D array)
				BAYSBOWS_obj.setAdditionalNum(readStringGroup(getRowIndex() + 1,1));
			}
		
		/**
		 * 
		 */
		private void parsedVeneer()
			{
				//first row
				ArrayList<String> temp = readOneRow(getRowIndex());
				
				//label
				BAYSBOWS_obj.setFullSheetLabel(temp.get(0));
				
				//list
				ArrayList<String> temp2 = new ArrayList<String>();
				temp2 = readOptionsList(getRowIndex() + 1);
				BAYSBOWS_obj.setFullSheetList(temp2);
				
				//string matrix (2-D array)
				BAYSBOWS_obj.setFullSheetNum(readStringGroup(getRowIndex() + 1,1));
			}
		
		/**
		 * 
		 */
		private void parsedVeneer2()
			{
				//first row
				ArrayList<String> temp = readOneRow(getRowIndex());
				
				//label
				BAYSBOWS_obj.setPrecutLabel(temp.get(0));
				
				//list
				ArrayList<String> temp2 = new ArrayList<String>();
				temp2 = readOptionsList(getRowIndex() + 1);
				BAYSBOWS_obj.setPrecutList(temp2);
				
				//string matrix (2-D array)
				BAYSBOWS_obj.setPrecutNum(readStringGroup(getRowIndex() + 1,1));
			}
		
		/**
		 * 
		 */
		private void parsedRoof()
			{
				//first row
				ArrayList<String> temp = readOneRow(getRowIndex());
				
				//label
				BAYSBOWS_obj.setRoofLabel1(temp.get(0));
				
				//list
				ArrayList<String> temp2 = new ArrayList<String>();
				temp2 = readOptionsList(getRowIndex() + 1);
				BAYSBOWS_obj.setRoofList1(temp2);
				
				//string matrix (2-D array)
				BAYSBOWS_obj.setRoofNum1(readStringGroup(getRowIndex() + 1,1));
			}
		
		/**
		 * 
		 */
		private void parsedRoof2()
			{
				//first row
				ArrayList<String> temp = readOneRow(getRowIndex());
				
				//label
				BAYSBOWS_obj.setRoofLabel2(temp.get(0));
				
				//list
				ArrayList<String> temp2 = new ArrayList<String>();
				temp2 = readOptionsList(getRowIndex() + 1);
				BAYSBOWS_obj.setRoofList2(temp2);
				
				//string matrix (2-D array)
				BAYSBOWS_obj.setRoofNum2(readStringGroup(getRowIndex() + 1,1));
			}
		
		/**
		 * 
		 */
		private void parsedCopperFinishes()
			{
				//first row
				ArrayList<String> temp = readOneRow(getRowIndex());
				
				//label
				BAYSBOWS_obj.setCopperLabel(temp.get(0));
				
				//list
				ArrayList<String> temp2 = new ArrayList<String>();
				temp2 = readOptionsList(getRowIndex() + 1);
				BAYSBOWS_obj.setCopperList(temp2);
				
				//string matrix (2-D array)
				BAYSBOWS_obj.setCopperNum(readStringGroup(getRowIndex() + 1,1));
			}
		
		/**
		 * 
		 */
		private void parsedHalogenLights()
			{
				//first row
				ArrayList<String> temp = readOneRow(getRowIndex());
				
				//label
				BAYSBOWS_obj.setLightLabel(temp.get(0));
				
				//list
				ArrayList<String> temp2 = new ArrayList<String>();
				temp2 = readOptionsList(getRowIndex() + 1);
				BAYSBOWS_obj.setLightList(temp2);
				
				//string matrix (2-D array)
				BAYSBOWS_obj.setLightNum(readStringGroup(getRowIndex() + 1,1));
			}
		
		/**
		 * 
		 */
		private Bays_Bows createBayBow()
			{
				ArrayList<ArrayList<String>> temp = readBayBowGroup(getRowIndex(), 0);
				return new Bays_Bows(temp);
			}
		
		/**
		 * 
		 * @return
		 */
		public Bays_BowsHolder createObject()
    		{
    			parseProductName();
    			parseClassName();
    			parsePriceMultiplier();
    			parseSize();
    			
    			//read in shapes
    			BAYSBOWS_obj.addBays_bows(createBayBow());
    			BAYSBOWS_obj.addBays_bows(createBayBow());
    			BAYSBOWS_obj.addBays_bows(createBayBow());
    			BAYSBOWS_obj.addBays_bows(createBayBow());
    			BAYSBOWS_obj.addBays_bows(createBayBow());
    			BAYSBOWS_obj.addBays_bows(createBayBow());
    			BAYSBOWS_obj.addBays_bows(createBayBow());
    			BAYSBOWS_obj.addBays_bows(createBayBow());
    			BAYSBOWS_obj.addBays_bows(createBayBow());
    			BAYSBOWS_obj.addBays_bows(createBayBow());
    			BAYSBOWS_obj.addBays_bows(createBayBow());
    			BAYSBOWS_obj.addBays_bows(createBayBow());
    			BAYSBOWS_obj.addBays_bows(createBayBow());
    			BAYSBOWS_obj.addBays_bows(createBayBow());
    			BAYSBOWS_obj.addBays_bows(createBayBow());
    			BAYSBOWS_obj.addBays_bows(createBayBow());
    			BAYSBOWS_obj.addBays_bows(createBayBow());
    			BAYSBOWS_obj.addBays_bows(createBayBow());
    			BAYSBOWS_obj.addBays_bows(createBayBow());
    			
    			updateRowIndex(1);
    			
    			parsedGridOptions();
    			parsedEnergyOptions();
    			parsedGlassStrength();
    			parsedScreen();
    			parsedScreenMesh();
    			parsedSpacer();
    			parsedGlassTint();
    			parsedExteriorPaint();
    			parsedCustomExtras();
    			parsedLockColor();
    			parsedAccessories();
    			parsedPlastic();
    			parsedSeats();
    			parsedPrePainted();
    			parsedCasing();
    			parsedVeneer();
    			parsedVeneer2();
    			parsedRoof();
    			parsedRoof2();
    			parsedCopperFinishes();
    			parsedHalogenLights();
    			
    			return BAYSBOWS_obj;
    		}

		/**
		 * 
		 * @return
		 */
		public ArrayList<String> testObject()
			{
				return BAYSBOWS_obj.getRoofList1();
			}
	}