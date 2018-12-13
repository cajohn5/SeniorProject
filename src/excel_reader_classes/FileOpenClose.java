package excel_reader_classes;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FileOpenClose
	{
		static XSSFWorkbook wb = null;
		
		/**
		 * 
		 */
		static void openFile()
			{
				String fileName = "Polaris Products.xlsx";
				
				try
					{
						BufferedInputStream f = new BufferedInputStream(new FileInputStream(fileName));
						wb = new XSSFWorkbook(new BufferedInputStream(f));
						
					} 
				catch (IOException e)
					{
						e.printStackTrace();
					} 
			}
		
		/**
		 * 
		 */
		static void closeFile()
			{
				try
					{
						wb.close();
					} 
				catch (IOException e)
					{
						e.printStackTrace();
					}
			}
	}
