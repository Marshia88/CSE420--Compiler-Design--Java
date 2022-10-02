import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class CSE420Lab01
{
    static String[] keywords={"int","float","double","if","else","while","break","char","case","enum", "for","continue","long",
            "static","void","switch","const","return","short","signed","unsigned","do","goto","boolean","catch","final","finally","implements","new","try","throw","throws"};
    static String[] mathOperators={"+","-","*","/","%","++","--","=","+=","-=","*=","/="};
    static String[] logicalOperators={">=","<=",">","<","==","!="};
    static String[] others={",",";","(",")","{","}"};
    static Set <String>keyword= new HashSet <String>();
    static Set <String>mathOp= new HashSet <String>();
    static Set <String>logicalOp= new HashSet <String>();
    static Set <Double>numericals= new HashSet <Double>();
    static Set <String>other= new HashSet <String>();
//    static Set <String>identifiers= new HashSet <String>();
//    static ArrayList<String> storeAll= new ArrayList<String>();
    static Set <String>storeAll= new HashSet <String>();
    public static void main(String[]args)
    {
        try
        {
            File txt = new File("D:\\Marshia\\CSE420\\Lab_Files\\Lab1\\inputfile.txt");
            Scanner sc = new Scanner(txt);
            while (sc.hasNextLine()) {
                String abc = sc.nextLine();
                String[] st = abc.split(" ");
                for (int i = 0; i < st.length; i++) {
                    storeAll.add(st[i]);
                    checkKeyword(st[i]);
                    checkMathOperator(st[i]);
                    checkLogicalOperators(st[i]);
                    checkOthers(st[i]);
                    checkNumerical(st[i]);
                }
            }
            System.out.print("Keywords: ");
            for(String xyz:keyword) {
                System.out.print(xyz+" ");
            }
            System.out.println();
            System.out.print("Identifiers: ");
            for(String xyz:storeAll) {
                System.out.print(xyz+" ");
            }
            System.out.println();
            System.out.print("Math Operators: ");
            for(String xyz:mathOp) {
                System.out.print(xyz+ " ");
            }
            System.out.println();
            System.out.print("Logical Operators: ");
            for(String xyz:logicalOp) {
                System.out.print(xyz+" ");
            }
            System.out.println();
            System.out.print("Numericals: ");
            for(Double xyz:numericals) {
                System.out.print(xyz+" ");
            }
            System.out.println();
            System.out.print("Others: ");
            for(String xyz:others) {
                System.out.print(xyz+ " ");
            }
        }
        catch (FileNotFoundException e)
        {
        }
    }
    static void checkKeyword(String x){
        for(int i=0; i<keywords.length; i++) {
            if (keywords[i].equals(x)) {
                keyword.add(x);
                storeAll.remove(x);
//                System.out.println(x);
            }
        }

    }
    static void checkMathOperator(String x){
        for(int i=0; i<mathOperators.length; i++) {
            if (mathOperators[i].equals(x)) {
                mathOp.add(x);
                storeAll.remove(x);
            }
        }
    }
    static void checkLogicalOperators(String x){
        for(int i=0; i<logicalOperators.length; i++) {
            if (logicalOperators[i].equals(x)) {
                logicalOp.add(x);
                storeAll.remove(x);
            }
        }
    }
    static void checkOthers(String x){
        for(int i=0; i<others.length; i++) {
            if (others[i].equals(x)) {
                other.add(x);
                storeAll.remove(x);
            }
        }
    }
    static void checkNumerical(String x){
        try
        {
            double z=Double.parseDouble(x);
//            int s=Integer.parseInt(x);
            numericals.add(z);
//            numericals.add(s);
            storeAll.remove(x);
        }
        catch(NumberFormatException e)
        {
        }
    }
}
