package com.foundation4u;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class PropertiesFileReadWriteTest {

	private Properties properties;
	
	public static void main(String[] args) {
		try {
			PropertiesFileReadWriteTest propertiesFileReadWriteTest = new PropertiesFileReadWriteTest();
			propertiesFileReadWriteTest.process();
		} catch (Exception e) {
			System.out
					.println("----------error occurred in properties file operation-------");
		}

	}

	private void process() throws IOException {
		System.out.println("---------properties file loading-----------");
		loadPropertiesFile();
		System.out.println("---------reading properties file-----------");
		readPropertiesFile();
		System.out.println("---------writing into properties file-----------");
		writePropertiesFile();
		System.out.println("---------updating properties file-----------");
		updatePropertiesFile();
		System.out.println("---------reading properties file again-----------");
		readPropertiesFile();
	}

	// make sure that properties file is in the project root folder
	private void loadPropertiesFile() throws IOException {
		properties = new Properties();
		//properties.load(this.getClass().getClassLoader().getResourceAsStream("test.properties"));
		InputStream inputStream = new FileInputStream("test.properties");
		properties.load(inputStream);
		
	}

	private void updatePropertiesFile() throws IOException {
		try{
			String firstRowValue = properties.getProperty("firstrow");
			String[] firstRowValues = firstRowValue.split(",");
			properties.setProperty("firstrow", "firstrowvalue1,"+firstRowValues[1]);
			
			String thirdRowValue = properties.getProperty("thirdrow");
			String[] thirdRowValues = thirdRowValue.split(",");
			properties.setProperty("thirdrow",thirdRowValues[0]+",thirdrowvalue6");
			
			OutputStream outputStream = new FileOutputStream("test.properties");
			properties.store(outputStream, "updated the value in properties file");
			System.out.println("updated the value in properties file");
		}catch(IOException e){
			System.out.println("error occurrred while updating the properties file"+e);
			throw new IOException(e);
		}
	}

	private void writePropertiesFile() throws IOException {
		properties.setProperty("thirdrow", "value5,value6");
		properties.setProperty("fourthrow", "value7,value8");
		OutputStream outputStream = new FileOutputStream("test.properties");
		properties.store(outputStream, "added new rows in properties file");
		System.out.println("new rows added in properties file");
	}

	private void readPropertiesFile() {
		System.out.println("first row: "+properties.getProperty("firstrow"));
		System.out.println("second row: "+properties.getProperty("secondrow"));
		System.out.println("third row: "+properties.getProperty("thirdrow"));
		System.out.println("fourth row: "+properties.getProperty("fourthrow"));
	}

}
