/**
 * 
 */
package com.foundation4u;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Scanner;

public class FileReadWriteTest {
	
	
	private final static String fileName = "test.properties";
	private final static String enCoding = "UTF-8";
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			FileReadWriteTest testFileReadWrite = new FileReadWriteTest();
			testFileReadWrite.process();
			System.out.println("-----------------file operation completed-----------------");
		}catch(Exception e){
			System.out.println("error occurred in writing and reading file: "+e);
		}catch(Throwable t){
			System.out.println("throwable error occurred: "+t);
		}
	}
	private void process() throws IOException {
		writeFile();
		readFile();
	}
	private void readFile() throws FileNotFoundException {
		System.out.println("-------------reading from file----------------");
		StringBuilder fileContent = new StringBuilder();
		String newLine = System.getProperty("line.separator");
		InputStream inputStream = new FileInputStream(fileName);
		Scanner scanner = new Scanner(inputStream, enCoding);
		try{
			while(scanner.hasNextLine()){
				fileContent.append(scanner.nextLine()+newLine);
			}
		}finally{
			if(scanner != null){
				scanner.close();
			}
		}
		System.out.println("file content is::::: "+newLine+fileContent);
	}
	private void writeFile() throws IOException {
		OutputStream outputStream = new FileOutputStream(fileName);
		Writer writer = new OutputStreamWriter(outputStream, enCoding);
		String newLine = System.getProperty("line.separator");
		try{
			System.out.println("-----------writing into file---------");
			writer.write("This is first line"+newLine);
			writer.write("This is second line"+newLine);
			writer.write("This is third line");
		}finally{
			if(writer != null){
				writer.close();
			}
		}
	}

}
