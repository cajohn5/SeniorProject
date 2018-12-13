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

import product_classes.Size;
import product_classes.Windows;

/**
 * Reads the (UW) Patio Door Sidelite sheet, parses the necessary
 * information and creates <code>Windows</code> object 
 * of the <code>product_classes</code> package 
 * to be used in <code>MasterExcelReading</code>.
 * @author Kyle Harbour
 *
 */
@SuppressWarnings("deprecation")
public class ExcelReadUW_PDSidelite
	{
		private Windows WINDOW_obj = new Windows();
		private int sheetIndex;
		private String sheetName = "(UW) Patio Door Sidelite";
		private XSSFSheet sheet;
		private XSSFRow row;
		private int rowIndex;
		
		private int getRowIndex ()
			{
				return rowIndex;
			}

		private void setRowIndex (int rowIndex)
			{
				this.rowIndex = rowIndex;
			}
		
		private void updateRowIndex(int update)
    		{
    			rowIndex = getRowIndex() + update;
    		}

		/**
		 * 
		 * @param sheetName
		 */
		private void setSheetIndex(String sheetName)
    		{
    			sheetIndex = FileOpenClose.wb.getSheetIndex(sheetName);
    		}
		
		/**
		 * 
		 * @return
		 */
		private int getSheetIndex()
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
						
						if( (row.getCell(1, Row.RETURN_BLANK_AS_NULL) == null) )
							{
								break;
							}
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
		 * @return
		 */
		private ArrayList<String> readOptionsList(int startRow)
			{
				ArrayList<String> obj = new ArrayList<String>();
				row = sheet.getRow(startRow);
				int numRows = 0;
				int tempRowIndex = 0;
				int controlRow = Integer.valueOf(startRow);

				while( (!(row == null)) && (row.getCell(0, Row.RETURN_BLANK_AS_NULL) != null) )
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
				WINDOW_obj.setProductName(temp.get(0));
			}
		
		/**
		 * 
		 */
		private void parseClassName()
			{
				ArrayList<String> temp = readOneRow(1);
				WINDOW_obj.setClassName(temp.get(0));	
			}
		
		/**
		 * 
		 */
		private void parsePriceMultiplier()
			{
				float mult = readPriceMultiplier();
				ArrayList<Float> temp = new ArrayList<Float>();
				temp.add(mult);
				WINDOW_obj.setPriceMultiplier(temp.get(0));
			}
		
		/**
		 * 
		 */
		private void parseMaxUI()
			{
				ArrayList<String> temp = readOneRow(5);
				float max = Float.parseFloat(temp.get(1).toString());
				ArrayList<Float> temp1 = new ArrayList<Float>();
				temp1.add(max);
				WINDOW_obj.setMaxUI(temp1);
			}
		
		/**
		 * 
		 */
		private void parseSize()
			{
				Size size = new Size();
				
				size.setWidth(readOneFloatRow(8));
				size.setHeight(readOneFloatRow(9));
				size.setWidth2(readOneFloatRow(10));
				size.setHeight2(readOneFloatRow(11));
				size.setOneSide(readOneFloatRow(12));
				
				WINDOW_obj.setSize(size);
				
				setRowIndex(14);
			}
		
		/**
		 * 
		 */
		private void parsedFrameColors()
			{
				//first row
				ArrayList<String> temp = readOneRow(getRowIndex());
				
				//options label
				WINDOW_obj.setFrameColorLabel(temp.get(0));
				
				//options row
				temp.remove(0);
				WINDOW_obj.setFrameColorList(temp);
				
				//float matrix (2-D array)
				WINDOW_obj.setFrameColorNum(readStringGroup(getRowIndex() + 1,0));
			}
		
		/**
		 * 
		 */
		private void parsedWoodgrains()
			{
				//first row
				ArrayList<String> temp = readOneRow(getRowIndex());
				
				//options label
				WINDOW_obj.setWoodgrainsLabel(temp.get(0));
				
				//options row
				ArrayList<String> temp1 = new ArrayList<String>();
				for(int r = 1; r < temp.size(); r++)
					{
						temp1.add(temp.get(r));
					}
				WINDOW_obj.setWoodgrainsList(temp1);
				
				updateRowIndex(2);
			}
		
		/**
		 * 
		 */
		private void parsedGridOptions()
			{
				//first row
				ArrayList<String> temp = readOneRow(getRowIndex());
				
				//label
				WINDOW_obj.setGridOptionsLabel(temp.get(0));
				
				//options row
				ArrayList<String> temp1 = readMergedRow();
				temp1.remove(temp1.size()-1);
				temp1.remove(temp1.size()-1);
				temp1.remove(temp1.size()-1);
				WINDOW_obj.setGridOptions(temp1);
				
				//list
				ArrayList<String> temp2 = new ArrayList<String>();
				temp2 = readOptionsList(getRowIndex() + 2);
				WINDOW_obj.setGridOptionsList(temp2);
				
				//float matrix (2-D array)
				WINDOW_obj.setGridOptionsNum(readFloatGroup(getRowIndex() + 1,1));
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
				WINDOW_obj.setEnergyOptionsLabel(temp.get(0));
				
				//list
				ArrayList<String> temp2 = new ArrayList<String>();
				temp2 = readOptionsList(getRowIndex() + 2);
				WINDOW_obj.setEnergyOptionsList(temp2);
				
				//string matrix (2-D array)
				WINDOW_obj.setEnergyOptionsNum(readStringGroup(getRowIndex() + 1,1));
			}
		
		/**
		 * 
		 */
		private void parsedGlass()
			{
				//first row
				ArrayList<String> temp = readOneRow(getRowIndex());
				
				//label
				WINDOW_obj.setGlassLabel(temp.get(0));;
				
				//list
				ArrayList<String> temp2 = new ArrayList<String>();
				temp2 = readOptionsList(getRowIndex() + 2);
				WINDOW_obj.setGlassList(temp2);
				
				//string matrix (2-D array)
				WINDOW_obj.setGlassNum(readStringGroup(getRowIndex() + 1,1));
			}
		
		/**
		 * 
		 */
		private void parsedScreenMesh()
			{
				//first row
				ArrayList<String> temp = readOneRow(getRowIndex());
				
				//label
				WINDOW_obj.setScreenMeshLabel(temp.get(0));;
				
				//list
				ArrayList<String> temp2 = new ArrayList<String>();
				temp2 = readOptionsList(getRowIndex() + 1);
				WINDOW_obj.setScreenMeshList(temp2);
				
				//string matrix (2-D array)
				WINDOW_obj.setScreenMeshNum(readStringGroup(getRowIndex() + 1,1));
			}
		
		/**
		 * 
		 */
		private void parsedSpacer()
			{
				//first row
				ArrayList<String> temp = readOneRow(getRowIndex());
				
				//label
				WINDOW_obj.setSpacerLabel(temp.get(0));;
				
				//list
				ArrayList<String> temp2 = new ArrayList<String>();
				temp2 = readOptionsList(getRowIndex() + 1);
				WINDOW_obj.setSpacerList(temp2);
				
				//string matrix (2-D array)
				WINDOW_obj.setSpacerNum(readStringGroup(getRowIndex() + 1,1));
			}
		
		/**
		 * 
		 */
		private void parsedGlassTint()
			{
				//first row
				ArrayList<String> temp = readOneRow(getRowIndex());
				
				//label
				WINDOW_obj.setGlassTintLabel(temp.get(0));
				
				//list
				ArrayList<String> temp2 = new ArrayList<String>();
				temp2 = readOptionsList(getRowIndex() + 2);
				WINDOW_obj.setGlassTintList(temp2);
				
				//string matrix (2-D array)
				WINDOW_obj.setGlassTintNum(readStringGroup(getRowIndex() + 1,1));
			}
		
		/**
		 * 
		 */
		private void parsedExteriorPaint()
			{
				//first row
				ArrayList<String> temp = readOneRow(getRowIndex());
				
				//label
				WINDOW_obj.setExteriorPaintLabel(temp.get(0));;
				
				//list
				ArrayList<String> temp2 = new ArrayList<String>();
				temp2 = readOptionsList(getRowIndex() + 1);
				WINDOW_obj.setExteriorPaintList(temp2);
				
				//string matrix (2-D array)
				WINDOW_obj.setExteriorPaintNum(readStringGroup(getRowIndex() + 1,1));
			}
		
		/**
		 * 
		 */
		private void parsedCustomExtras()
			{
				//first row
				ArrayList<String> temp = readOneRow(getRowIndex());
				
				//label
				WINDOW_obj.setCustomExtrasLabel(temp.get(0));;
				
				//list
				ArrayList<String> temp2 = new ArrayList<String>();
				temp2 = readOptionsList(getRowIndex() + 1);
				WINDOW_obj.setCustomExtrasList(temp2);
				
				//string matrix (2-D array)
				WINDOW_obj.setCustomExtrasNum(readStringGroup(getRowIndex() + 1,1));
			}
		
		/**
		 * 
		 */
		private void parsedTiltMiniBlinds()
			{
				//first row
				ArrayList<String> temp = readOneRow(getRowIndex());
				
				//label
				WINDOW_obj.setMiniblindsLabel(temp.get(0));;
				
				//list
				temp.remove(0);
				temp.remove(temp.size()-1);
				WINDOW_obj.setMiniblindsList(temp);
				
				//string matrix (2-D array)
				WINDOW_obj.setMiniblindsNum(readStringGroup(getRowIndex() + 1,0));
			}
		
		/**
		 * 
		 * @return
		 */
		public Windows createObject()
		{
			parseProductName();
			parseClassName();
			parsePriceMultiplier();
			parseMaxUI();
			parseSize();
			parsedFrameColors();
			parsedWoodgrains();
			parsedGridOptions();
			parsedEnergyOptions();
			parsedGlass();
			parsedScreenMesh();
			parsedSpacer();
			parsedGlassTint();
			parsedExteriorPaint();
			parsedCustomExtras();
			parsedTiltMiniBlinds();
			
			return WINDOW_obj;
		}
		
		/**
		 * 
		 * @return
		 */
		public ArrayList<String> testObject()
			{
				return WINDOW_obj.getCustomExtrasList();
			}
	}
