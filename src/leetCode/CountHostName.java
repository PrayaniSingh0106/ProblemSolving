package leetCode;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class CountHostName {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		hostNameCount();
	}

	public static void hostNameCount() {
		String filename = "/Users/prayanisingh/Downloads/hostname.txt";
		// FileReader filereader = new FileReader(file);
		
		try {

		File file1 = new File(filename);
			LinkedHashMap<String, Integer> hostnm = new LinkedHashMap<String, Integer>();
			int val = 0;
			Scanner sc = new Scanner(new FileInputStream(file1));
			FileWriter fw = new FileWriter("/Users/prayanisingh/Downloads/hostnameop.txt");

			System.out.println(sc.toString() + " sc.hasNextLine() " + sc.hasNextLine());

			String line;

			while (sc.hasNextLine()) {
				line = sc.nextLine();

				if (line != null) {
					if (line.trim().length() == 0) {
						continue; // Skip blank lines
					}

					 int i = line.indexOf('-');
	                    String word = line.substring(0, i);
	                    
				
					if (hostnm.containsKey(word)) {
						val = (int) hostnm.get(word);
						hostnm.put(word, val + 1);
						val = 0;
					} else
						hostnm.put(word, val + 1);

					// System.out.println(str);

				}

			}
			sc.close();

			Set set = hostnm.entrySet();
			Iterator itr = set.iterator();

			while (itr.hasNext()) {
				Map.Entry me = (Map.Entry) itr.next();

				Object key = (String) me.getKey();
				int value = (int) me.getValue();

				StringBuilder sb = new StringBuilder();

				sb.append(String.valueOf(key));
				sb.append(" ");
				sb.append(String.valueOf(value));
				sb.append(System.lineSeparator());

				fw.write(sb.toString());

			}
			fw.close();

		}

		catch (Exception e) {
			e.printStackTrace();
		}
	
	}
}