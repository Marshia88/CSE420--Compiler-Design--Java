import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class CSE420Lab04 {
    static String  pattern= "(public|protected|private)(\\s(static))* +[\\w\\<\\>\\[\\],\\s]+\\s+(\\w+) *\\([^\\)]*\\) *(\\{?|[^;])";
    public static void main(String[] args) {
        try{
            File txt = new File("D:\\Marshia\\CSE420\\Lab_Files\\Lab4\\InputLab4.txt");
            Scanner sc = new Scanner(txt);
            System.out.println("Methods:");
            while (sc.hasNextLine()) {
                String abc = sc.nextLine();
                if(!abc.contains("main")) {
//                System.out.println(abc);
                    match(abc);
                }
            }
        }
        catch (FileNotFoundException e)
        {
        }
    }
    public static boolean match(String example)
    {
        String toUse=example;
            Pattern p = Pattern.compile(pattern);
            Matcher m = p.matcher(example);
            if (m.matches()) {
//                System.out.println("Yes, ");
                String[] st = toUse.split(Pattern.quote("("));
                String[] keepitems;
                keepitems=(st[0].split(" "));
                System.out.print(keepitems[keepitems.length-1]+" "+"("+st[1]+", return type: "+keepitems[keepitems.length-2]);
                System.out.println();
                return true;
            }
        return false;
    }
}
