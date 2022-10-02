import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class CSE420Lab03 {
    static String[] patterns;
    static int pattern_no;
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the number of patterns");
        pattern_no=sc.nextInt();
        patterns= new String[pattern_no];
        for(int i=0; i< pattern_no; i++)
        {
            System.out.println("Enter the pattern");
            String pat= sc.next();
            patterns[i]=pat;
//            System.out.println(patterns[i]);
        }
        System.out.println("Enter the number of examples to be matched");
        int ex_no=sc.nextInt();
        for(int i=0; i<ex_no; i++)
        {
            System.out.println("Enter the example");
            String example= sc.next();
            if(!match(example)){
                System.out.println("No, "+ 0);
            };
        }
    }
    public static boolean match(String example)
    {
        for(int j=0; j<pattern_no; j++)
        {
            Pattern p = Pattern.compile(patterns[j]);
            Matcher m = p.matcher(example);
            if (m.matches()) {
                System.out.println("Yes, " + (j + 1));
                return true;
            }
        }
        return false;
    }
}
