package contactManager;

/**
 * @author Sam Malcolm
 * @since 11 Dec 2015 | 13:35:37
 * Description: reading or writing (Adding and deleting) to the file
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileIO {

	public static void main(String[] args){
		int addId = 0;
		String addName = "";
		String addNotes = "";
		writeFileAdd(addId, addName, addNotes);
	}
	public static void readFile() {

		try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\CompUser\\Documents\\ContactManager\\contactinput.txt")))
		{

			String CurrentLine;
			List<Contact> contactsList = new ArrayList<Contact>();
			while ((CurrentLine = br.readLine()) != null) {
				String[] myLine = CurrentLine.split(",");
				if (myLine.length==3){
					Contact c1 = new AddContactimpl();
					c1.setId(Integer.parseInt(myLine[0]));
					c1.setName(myLine[1]);
					c1.setNotes(myLine[2]);
					contactsList.add(c1);
				}
			}
			for (Contact c : contactsList){
				AddContactimpl cont = (AddContactimpl)c;
				cont.printContacts();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} 

	}
	public static void writeFileAdd(int addId, String addName, String addNotes){
		
		try {
			String orig = "";
			BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\CompUser\\Documents\\ContactManager\\contactinput.txt"));
			String CurrentLine;
			while ((CurrentLine = br.readLine()) != null) {
				orig += CurrentLine + "\r\n";
			}
			
			String content = "This is the content to write into file";
			
			
			FileWriter fw = new FileWriter(("C:\\Users\\CompUser\\Documents\\ContactManager\\contactinput.txt"));
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(orig + content);
			bw.close();
			
			System.out.println("Done");
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void writeFileDelete(){
		//Delete unwanted contacts from the file
	}
}
