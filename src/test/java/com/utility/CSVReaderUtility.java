package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.ui.pojo.User;

public class CSVReaderUtility {
	
	public static Iterator<User> readCSVFile(String fileName) {
		File csvfile= new File(System.getProperty("user.dir")+"/testdata/"+fileName);
		FileReader fileReader= null;
		CSVReader csvReader;
		String[]line;
		List<User> userList = null;
		 User userData;
		
		
		
		
		try { 
			   // decelartion- never try to do decleartion inside try block ,it should happen before the try block 
		 fileReader= new FileReader(csvfile);
		 csvReader=new CSVReader(fileReader);
		 csvReader.readNext();//reader the coloum name=row no 1>>skip the cloumn  
		 
		 
		 userList=new ArrayList<User>();
		 
		 
		 
		 while((line=csvReader.readNext())!=null) {
			 userData= new User(line[0],line[1]);
		     userList.add(userData);
		 }
		 
		 for(User user : userList) {
			 System.out.println(user);
		 }}
		 
		 catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		catch (CsvValidationException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			
		}
		return userList.iterator();
		}}
