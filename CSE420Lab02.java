import java.util.Scanner;
public class CSE420Lab02 {
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");
        int times = sc.nextInt();
        for (int i = 0; i <times; i++) {
            System.out.println("Enter a string");
            String abc = sc.next();
            int end_email = 5;
            int end_web = 6;
            boolean check=checkEmail(abc, end_email, count);
//            System.out.println(check);
            if(check==false) {
                boolean sec_check=checkWeb(abc, end_web, count);
                if(sec_check==false){
                    System.out.println("Invalid");
                }
//                System.out.println(sec_check);
            }
        }
    }
        public static boolean checkEmail(String given_string, int end, int cnt){
            int state=0;
            int lex = 0;
            boolean flag=false;
            while (lex < given_string.length()) {
                int str = (int)given_string.charAt(lex);
                switch (state) {
                    case 0:
                        if (str >= 97 && str <= 122) {
                            state = 1;
                            lex++;
                        }
                        else{
                            return false;
                        }
                        break;
                    case 1:
                        if ((str >= 97 && str <= 122) || (str >= (int)0 && str <= (int)9)) {
                            state = 1;
                            lex++;
                        } else if (str == (int) '@') {
                            state = 2;
                            lex++;
                        }
                        else{
                            return false;
                        }
                        break;
                    case 2:
                        if ((str >= 97 && str <= 122) || (str >= (int)0 && str <= (int)9)) {
                            state = 3;
                            lex++;
                        }
                        else{
                            return flag;
                        }
                        break;
                    case 3:
                        if ((str >= 97 && str <= 122) || (str >= (int)0 && str <= (int)9)) {
                            state = 3;
                            lex++;
                        } else if (str == (int) '.') {
                            state = 4;
                            lex++;
                        }
                        else{
                            return flag;
                        }
                        break;
                    case 4:
                        if ((str >= 97 && str <= 122) || (str >= (int)0 && str <= (int)9)) {
                            state = 5;
                            lex++;
                        }
                        else{
                            return flag;
                        }
                        break;
                    case 5:
                        if ((str >= 97 && str <= 122) || (str >= (int)0 && str <= (int)9)) {
                            state = 5;
                            lex++;
                        }
                        else{
                            return flag;
                        }
                        break;
                }
            }
            if (state==end) {
                cnt++;
                count=cnt;
                flag=true;
                System.out.println("Email, "+count);
            }
            return flag;
    }
    public static boolean checkWeb(String given_string, int end,int cnt)
    {
//        System.out.println("abc");
        boolean flag=false;
        int state=0;
        int lex = 0;
        while (lex < given_string.length()) {
            int str = (int) given_string.charAt(lex);
            switch (state) {
                case 0:
                    if (str == (int) 'w') {
                        state = 1;
                        lex++;
//                        System.out.println(state);
                    }
                    else{
                        return false;
                    }
                    break;
                case 1:
                    if (str == (int) 'w') {
                        state = 2;
                        lex++;
                    }
                    else{
                        return false;
                    }
                    break;
                case 2:
                    if (str == (int) 'w') {
                        state = 3;
                        lex++;
                    }
                    else{
                        return false;
                    }
                    break;
                case 3:
                    if (str == (int) '.') {
                        state = 4;
                        lex++;
                    }
                    else{
                        return false;
                    }
                    break;
                case 4:
                    if (str >= 97 && str <= 122) {
                        state = 5;
                        lex++;
                    }
                    else{
                        return false;
                    }
                    break;
                case 5:
                    if((str >= 97 && str <= 122) || (str >= (int)0 && str <= (int)9)){
                        state = 5;
                        lex++;

                    }
                    else if (str == (int) '.') {
                        state = 6;
                        lex++;
                    }
                    else{
                        return false;
                    }
                    break;
                case 6:
                    if ((str >= 97 && str <= 122) || (str >= (int)0 && str <= (int)9)) {
                        state = 6;
                        lex++;
                    }
                    else{
                        return false;
                    }
                    break;
            }
        }
        if (state==end) {
            cnt++;
            count=cnt;
            flag=true;
            System.out.println("Web, "+count);
        }
        return flag;
    }
}
