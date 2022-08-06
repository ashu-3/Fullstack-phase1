import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


class AddFiles {
	
	void addFile() throws IOException {
		
		System.out.println("Enter File Name");
		Scanner sc = new Scanner(System.in);
		
		String fileName = sc.next();
		
		try {
			File file = new File("E://"+fileName);
			
			if(file.createNewFile()) {
				System.out.println("FIle created successfully");
			}
			
			else {
				System.out.println("File already exists");
			}
			
			sc.close();
		}
		catch(Exception e) {
			System.out.println("Path not found Exception");
		}
	}
}

class DeleteFiles {
	void deleteFile() throws IOException {
		
		
		System.out.println("Enter File Name to delete");
		Scanner sc = new Scanner(System.in);
		
		String fileName = sc.next();
		
		File file = new File("D://"+fileName);
		
		if(file.delete()) {
			System.out.println("FIle deleted successfully");
		}
		
		else {
			System.out.println("File Not found");
		}
		
		sc.close();
	}
}

class FileOptions {
	

}

class SortFiles {
	
	ArrayList<String> sortFile() throws IOException {
		ArrayList<String> list = new ArrayList<String>();
		
		try {
			File folder = new File("D://");
			
			
			File[] listOfFiles = folder.listFiles();
			if(listOfFiles!=null) {
				System.out.println("---------");
				System.out.println("Sorted files and folder");
				System.out.println("---------");
				for (int i = 0; i < listOfFiles.length; i++) {
					
					//sorting file
					if (listOfFiles[i].isFile()) {
						list.add(listOfFiles[i].getName());
					}
				    //sorting folder
				    else if (listOfFiles[i].isDirectory()) {
					   list.add(listOfFiles[i].getName());
				    }			  
				}
				System.out.println(list);	
			}
			
			else {
				System.out.println("---------");
				System.out.println("File not found to sort");
			}
		}
		catch(Exception e) {
			System.out.println("Path not found Exception");
		}
		return list;
	}
}

class SearchFiles extends SortFiles{
	void searchFile() throws IOException {
		
		ArrayList<String> list = new ArrayList<String>();
		Boolean flag =false;
		System.out.println("Enter File Name to search");
		Scanner sc = new Scanner(System.in);
		
		String fileName = sc.next();
		
		list = super.sortFile();
		//System.out.println(list);
		for (String ele : list){
	         if (ele.contains(fileName)){
	        	   System.out.println("");
	               System.out.println("FIle " + fileName + " Found");
	               flag=true;
	               break;
	         }
	         
	    }
		
		if(flag==false) {
			System.out.println("File not found in search");
		}
		sc.close();
	}
}



public class FIlesOperation {
	
	public static void main(String args[]) throws IOException {
		Scanner sc= new Scanner(System.in);
		Scanner scr= new Scanner(System.in);
		
		System.out.println("Developer: Ashwath");
		System.out.println("---------------");
		System.out.println("Welecome to DigiLocker");
		System.out.println("---------------");
		System.out.println("Please Enter below options");
		System.out.println("---------------");
		System.out.println("1.Sort");
		System.out.println("2.Oprations");
		System.out.println("3.Quit");
		
		
		AddFiles add = new AddFiles();
		DeleteFiles del = new DeleteFiles();
		SearchFiles ser = new SearchFiles();
		SortFiles sor = new SortFiles();
		
		
		int num = sc.nextInt();
//		while(num!=3) {
		if(num==1) {
			sor.sortFile();
			//break;
		}
		else if(num==2) {
			System.out.println("---------------");
			System.out.println("please Enter Your option for File Opearions");
			System.out.println("1.Add files");
			System.out.println("2.Delete Files");
			System.out.println("3.Search a file by Name");
			System.out.println("4:Go back to Main menu");
			
			int opt = scr.nextInt();
			if(opt==1) {
				add.addFile();
				//break;
			}
			
			else if(opt==2) {
     			del.deleteFile();
			}
			
			else if(opt==3) {
				ser.searchFile();
			}
			
			else if(opt==4){
				
			}
			
			else {
				System.out.println("Please Enter valid input");
			}
			
			scr.close();
		}
		else if(num==3) {
			System.out.println("You are exited..");
			sc.close();
		}
		
		else {
			System.out.println("Please Enter Valid Input");
		}
	}
}
