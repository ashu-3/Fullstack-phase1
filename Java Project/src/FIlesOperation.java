import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

//code to add files
class AddFiles {
	
	void addFile() throws IOException {
		
		System.out.println("Enter File Name to add");
		
		String fileName = FIlesOperation.sc.next();
		
		try {
			File file = new File("D://"+fileName);
			
			if(file.createNewFile()) {
				System.out.println("FIle created successfully");
			}
			
			else {
				System.out.println("File already exists");
			}
			
		}
		catch(Exception e) {
			System.out.println("Path not found Exception");
		}
	}
}


//delete files
class DeleteFiles {
	void deleteFile() throws IOException {
		
		
		System.out.println("Enter File Name to delete");
		
		String fileName = FIlesOperation.sc.next();
		
		File file = new File("D://"+fileName);
		
		if(file.delete()) {
			System.out.println("FIle deleted successfully");
		}
		
		else {
			System.out.println("File Not found");
		}
		
	}
}

//sorting files
class SortFiles {
	
	ArrayList<String> sortFile() throws IOException {
		ArrayList<String> list = new ArrayList<String>();
		
		System.out.println("sorted files");
		
		
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
				    /*sorting folder
				    else if (listOfFiles[i].isDirectory()) {
					   list.add(listOfFiles[i].getName());
				    }*/			  
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

//using inheritance for search
class SearchFiles extends SortFiles{
	void searchFile() throws IOException {
		
		ArrayList<String> list = new ArrayList<String>();
		Boolean flag =false;
		System.out.println("Enter File Name to search");
		
		String fileName = FIlesOperation.sc.next();
		
		list = super.sortFile();
		//System.out.println(list);
		for (String ele : list){
	         if (ele.equals(fileName)){
	        	   System.out.println(" ");
	               System.out.println("FIle " + fileName + " Found");
	               flag=true;
	               break;
	         }
	         
	    }
		
		if(flag==false) {
			System.out.println("File not found in search");
		}
	}
}



public class FIlesOperation {
	
	//reusable to scanner
	public static Scanner sc= new Scanner(System.in);
	
	public static void main(String args[]) throws IOException {
		
		Boolean mainFlag =true;
		Boolean subFlag =true;

		AddFiles add = new AddFiles();
		DeleteFiles del = new DeleteFiles();
		SearchFiles ser = new SearchFiles();
		SortFiles sor = new SortFiles();
		
		
		OUTER:
		while(mainFlag) {
			System.out.println("Developer: Ashwath");
			System.out.println("---------------");
			System.out.println("Welecome to DigiLocker");
			System.out.println("---------------");
			System.out.println("Please Enter below options");
			System.out.println("---------------");
			System.out.println("1.Sort");
			System.out.println("2.Oprations");
			System.out.println("3.Quit");
		
	
			int choice =sc.nextInt();
			
			switch(choice) {
			
			case 1: sor.sortFile();
					break;
					
			case 2: 
					while(subFlag) {
						System.out.println("---------------");
						System.out.println("please Enter Your option for File Opearions");
						System.out.println("1.Add files");
						System.out.println("2.Delete Files");
						System.out.println("3.Search a file by Name");
						System.out.println("4:Go back to Main menu");
						
						int subChoice = sc.nextInt();
						
						switch(subChoice) {
							case 1:	add.addFile();
									break;
							
							case 2: del.deleteFile();
									break;
									
							case 3: ser.searchFile();
									break;
							
							case 4: System.out.println("you are Backing to Main Menu");
									continue OUTER;
							
							default: System.out.println("Enter valid choice");
						}
					}
					
					
				
			case 3: System.out.println("You are exited from the application");
					mainFlag =false;
					break;
			
			default: System.out.println("Please enter valid choice");
			
			}
		}
	}
}
