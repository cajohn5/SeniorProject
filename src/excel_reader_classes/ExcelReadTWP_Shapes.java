package excel_reader_classes; 

import java.util.ArrayList;

import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import product_classes.Shape;
import product_classes.ShapeHolder;



/**
 * Reads the (TWP) Shapes sheet, parses the necessary
 * information and creates <code>ShapeHolder</code> object 
 * of the <code>product_classes</code> package 
 * to be used in <code>MasterExcelReading</code>.
 * @author Kyle Harbour
 *
 */
@SuppressWarnings("deprecation")
public class ExcelReadTWP_Shapes
	{
		private ShapeHolder SHAPES_obj = new ShapeHolder();
		private int sheetIndex;
		private String sheetName = "(TWP) Shapes";
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
		 */
		private void parseProductName()
			{
				setSheetIndex(sheetName);
				sheet = FileOpenClose.wb.getSheetAt(getSheetIndex());
				ArrayList<String> temp = readOneRow(0);
				SHAPES_obj.setProductName(temp.get(0));
			}
		
		/**
		 * 
		 */
		private void parseClassName()
			{
				ArrayList<String> temp = readOneRow(1);
				SHAPES_obj.setClassName(temp.get(0));	
			}
		
		/**
		 * 
		 */
		private void parsePriceMultiplier()
			{
				float mult = readPriceMultiplier();
				ArrayList<Float> temp = new ArrayList<Float>();
				temp.add(mult);
				SHAPES_obj.setPriceMultiplier(temp.get(0));
				
				setRowIndex(5);
			}
		
		/**
		 * 
		 */
		private void parsedGrid()
			{
				//first row
				ArrayList<String> temp = readOneRow(getRowIndex());
				
				//label
				SHAPES_obj.setGridLabel(temp.get(0));
				
				//list
				ArrayList<String> temp2 = new ArrayList<String>();
				temp2 = readOptionsList(getRowIndex() + 1);
				SHAPES_obj.setGridList(temp2);
				
				//float matrix (2-D array)
				SHAPES_obj.setGridNum(readStringGroup(getRowIndex() + 1,1));
				//updateRowIndex(2);
			}
		
		/**
		 * 
		 */
		private void parsedVinylColor()
			{
				//first row
				ArrayList<String> temp = readOneRow(getRowIndex());
				
				//label
				SHAPES_obj.setVinylColorLabel(temp.get(0));
				
				//list
				ArrayList<String> temp2 = new ArrayList<String>();
				temp2 = readOptionsList(getRowIndex() + 1);
				SHAPES_obj.setVinylColorList(temp2);
				
				//float matrix (2-D array)
				SHAPES_obj.setVinylColorNum(readStringGroup(getRowIndex() + 1,1));
			}
		
		/**
		 * 
		 */
		private void parsedGlassStrength()
			{
				//first row
				ArrayList<String> temp = readOneRow(getRowIndex());
				
				//label
				SHAPES_obj.setGlassStrengthLabel(temp.get(0));;
				
				//list
				ArrayList<String> temp2 = new ArrayList<String>();
				temp2 = readOptionsList(getRowIndex() + 1);
				SHAPES_obj.setGlassStrengthList(temp2);
				
				//string matrix (2-D array)
				SHAPES_obj.setGlassStrengthNum(readStringGroup(getRowIndex() + 1,1));
				//updateRowIndex(1);
			}
		
		/**
		 * 
		 */
		private void parsedGlass()
			{
				//first row
				ArrayList<String> temp = readOneRow(getRowIndex());
				
				//label
				SHAPES_obj.setGlassLabel(temp.get(0));;
				
				//list
				ArrayList<String> temp2 = new ArrayList<String>();
				temp2 = readOptionsList(getRowIndex() + 1);
				SHAPES_obj.setGlassList(temp2);
				
				//string matrix (2-D array)
				SHAPES_obj.setGlassNum(readStringGroup(getRowIndex() + 1,1));
				//updateRowIndex(1);
			}
		
		/**
		 * 
		 */
		private void parsedGlassTint()
			{
				//first row
				ArrayList<String> temp = readOneRow(getRowIndex());
				
				//label
				SHAPES_obj.setGlassTintLabel(temp.get(0));;
				
				//list
				ArrayList<String> temp2 = new ArrayList<String>();
				temp2 = readOptionsList(getRowIndex() + 1);
				SHAPES_obj.setGlassTintList(temp2);
				
				//string matrix (2-D array)
				SHAPES_obj.setGlassTintNum(readStringGroup(getRowIndex() + 1,1));
			}
		
		/**
		 * 
		 */
		private void parsedExteriorPaint()
			{
				//first row
				ArrayList<String> temp = readOneRow(getRowIndex());
				
				//label
				SHAPES_obj.setExteriorPaint(temp.get(0));
				
				//list
				ArrayList<String> temp2 = new ArrayList<String>();
				temp2 = readOptionsList(getRowIndex() + 1);
				SHAPES_obj.setExteriorPaintList(temp2);
				
				//string matrix (2-D array)
				SHAPES_obj.setExteriorPaintNum(readStringGroup(getRowIndex() + 1,1));
			}
		
		private Shape createShape()
    		{
    			
    			ArrayList<String> shapeRow = readOneRow(getRowIndex());
    			String nameLabel = shapeRow.get(0).toString();
    			ArrayList<ArrayList <String>> sizeRows = readStringGroup(getRowIndex() + 1, 0);
    		
    			ArrayList<String> perRow = readOneRow(getRowIndex());
    			String perLabel = perRow.get(0).toString();
    			perRow.remove(0);
    			perRow.remove(0);
    			perRow.remove(perRow.size()-1);
    			ArrayList<String> list = perRow;
    			ArrayList<ArrayList <String>> shapeRows = readStringGroup(getRowIndex() + 1, 0);
    			
    			return new Shape(nameLabel, perLabel, sizeRows, list, shapeRows);
    		}
		
		/**
		 * 
		 * @return
		 */
		public ShapeHolder createObject()
    		{
    			parseProductName();
    			parseClassName();
    			parsePriceMultiplier();
    			
    			//read in shapes
    			SHAPES_obj.addShapeObjects(createShape());
    			SHAPES_obj.addShapeObjects(createShape());
    			SHAPES_obj.addShapeObjects(createShape());
    			SHAPES_obj.addShapeObjects(createShape());
    			SHAPES_obj.addShapeObjects(createShape());
    			SHAPES_obj.addShapeObjects(createShape());
    			SHAPES_obj.addShapeObjects(createShape());
    			SHAPES_obj.addShapeObjects(createShape());
    			SHAPES_obj.addShapeObjects(createShape());
    			SHAPES_obj.addShapeObjects(createShape());
    			SHAPES_obj.addShapeObjects(createShape());
    			SHAPES_obj.addShapeObjects(createShape());
    			SHAPES_obj.addShapeObjects(createShape());
    			SHAPES_obj.addShapeObjects(createShape());
    			SHAPES_obj.addShapeObjects(createShape());
    		
    			parsedGrid();
    			parsedVinylColor();
    			parsedGlassStrength();
    			parsedGlass();
    			parsedGlassTint();
    			parsedExteriorPaint();
    			
    			return SHAPES_obj;
    		}
		
		/**
		 * 
		 * @return
		 */
		public ArrayList<String> testObject()
			{
				return SHAPES_obj.getShapeObjects().get(14).getEnergyList();
				
			}
	}
