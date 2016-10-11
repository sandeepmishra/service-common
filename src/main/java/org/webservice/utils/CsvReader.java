package org.webservice.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.webservice.userbean.UserBean;

public class CsvReader {
 
	public  <T> List<T> csvToList(String fileName){
		List<T> list = null;
		String line="";
		FileInputStream inputStream=null;
		try {
			list = new ArrayList<T>();
			ClassLoader classLoader = this.getClass().getClassLoader(); 
			File configFile=new File(classLoader.getResource(fileName).getFile()); 
			inputStream = new FileInputStream(configFile);
			BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
			while((line=br.readLine()) != null){
				List<String> varList= Arrays.asList(line.split(","));
				if(!("LAST_NAME").equalsIgnoreCase(varList.get(0))){
					UserBean bean = new UserBean();
					bean.setFirstName(varList.get(1));
					bean.setLastName(varList.get(0));
					bean.setUserName(varList.get(2));
					bean.setPasswrod(varList.get(3));
					bean.setUserEmail(varList.get(4));
					list.add((T) bean);
				}
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	
}
