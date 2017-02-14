import java.util.*;
import java.util.regex.Pattern;
import java.io.*;
import java.util.regex.*;
class DirSearch{
	public static void main(String arg[])throws IOException{
		DirSearch obj=new DirSearch();
		obj.doSearch(System.getProperty("user.dir")+ "/files/");//address of currrent directory is passed	
	}
	public void doSearch(String path) throws IOException{
		File dir=new File(path);
		File[] listfile=dir.listFiles();
		if(listfile!=null && listfile.length>0){
			for(File list:listfile){
				if(list.isDirectory()){
					try{
					doSearch(list.getAbsolutePath()); //recurse
					}catch(IOException e){
						e.printStackTrace();
					}
				}else{
					this.printPhNum(list.getAbsolutePath());
				}
			}
		}	
	}
	 public void printPhNum(String path) {
   File f = new File(path);
  try{ Scanner scanner = new Scanner(f);
  while(scanner.hasNextLine()){
   String words=scanner.findInLine(Pattern.compile("(?<!\\w)(\\+91(-?))?[7-9]{1}[0-9]{9}(?!\\w)"));
   if(words==null){
   scanner.nextLine();
   }else{
	if(words.charAt(0)=='+' && words.charAt(3)!='-'){
	   System.out.println("\n**Found**: "+words.substring(3,13));
	}else if(words.charAt(3)=='-'){
	 	 System.out.println("\n**Found**: "+words.substring(4,14));
	}else{
	   	System.out.println("\n**Found**: "+words);
	}
   	}
	}
   scanner.close();
   }catch(FileNotFoundException e ){e.printStackTrace(); }
   }
}
