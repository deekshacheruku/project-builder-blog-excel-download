package service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import model.Blog;

public class ExcelFileStorage {
	
	
	private static String[] columns = {"Blog Title", "Blog Content", "Posted On"}; 
	
	static List<Blog> list=new ArrayList<Blog>();
	
	public void insertBlog(Blog blog) throws IOException {
		list.add(blog);
		createExcel(blog);
	
	}
//	public List<Blog> getAllBlogs() {
//		//System.out.println("Getting list");
//		return readExcel();
//	}
//	
	private void createExcel(Blog blog) throws IOException {
		System.out.println("Creating an excel");
	      
        Workbook workbook = new XSSFWorkbook(); 
      
        CreationHelper createHelper = workbook.getCreationHelper();

        Sheet sheet = workbook.createSheet("Blog");

        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.RED.getIndex());
 
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);

        Row headerRow = sheet.createRow(0);

        for(int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerCellStyle);
        }

       CellStyle dateCellStyle = workbook.createCellStyle();
  
        dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-mm-yyyy"));

       // int rowNum = sheet.getLastRowNum();
        int rowNum=0;
        for(Blog blogpost: list) {
        	
            Row row = sheet.createRow(++rowNum);
            row.createCell(0).setCellValue(blog.getBlogTitle());
            row.createCell(1).setCellValue(blog.getBlogDescription());
            row.createCell(2).setCellValue(blog.getDate().toString());
  /*          
            Cell dateofpost = row.createCell(2);
            dateofpost.setCellValue(blog.getBlog_date());
           // dateofpost.setCellValue(blog.getBlog_date());
            dateofpost.setCellStyle(dateCellStyle);

*/
        }

        for(int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }

        FileOutputStream fileOut = new FileOutputStream("C://Users//user//Downloads//blog.xlsx");
        
        workbook.write(fileOut);
        
        fileOut.close();

        workbook.close();
		
    }
	
	
//	  public List<Blog> readExcel() {
//	  
//	  System.out.println("Reading from excel file");
//	  System.out.println("Opening the file"); String excelFilePath ="C://Users//vinot//Downloads//blog.xlsx";
//	  
//	  try { 
//		  FileInputStream inputStream = new FileInputStream(excelFilePath);
//	  
//	  Workbook workbook = new XSSFWorkbook(inputStream); 
//	  Sheet firstSheet =  workbook.getSheetAt(0); 
//	  Iterator<Row> rowIterator = firstSheet.iterator();
//	  int count = 0; 
//	  String blog_title=""; 
//	  String blog_content="";
//	  rowIterator.next(); // skip the header row
//	  
//	  while (rowIterator.hasNext()) { //System.out.println("Entering into row");
//	  Row nextRow = rowIterator.next(); 
//	  Iterator<Cell> cellIterator = nextRow.cellIterator();
//	  
//	  while (cellIterator.hasNext()) {
//		  Cell nextCell = cellIterator.next();
//		  int columnIndex = nextCell.getColumnIndex();
//		  switch (columnIndex) { 
//		  case 0:
//			  blog_title = nextCell.getStringCellValue(); 
//			  System.out.println(blog_title);
//			   break; 
//			   case 1: blog_content = nextCell.getStringCellValue();
//			    System.out.println(blog_content); 
//			    break; 
//			    } 
//		  } 
//	  } 
//	  list.add(new Blog(blog_title,blog_content,LocalDate.now()));
//	  workbook.close(); 
//	  } 
//	  catch (IOException ex1)
//	  {
//	  System.out.println("Error reading file"); 
//	  ex1.printStackTrace(); }
//	  return list; 
//	  }
//	 
}

