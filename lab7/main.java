import java.io.*;
import java.util.Arrays;


class Main {
    
    public static int convertStringToInt(String exp){
        return Integer.parseInt(exp);
    }

    public static String convertIntToHex(int val) {
        return Integer.toHexString(val);
    }
    
    public static void my_printf(String format_string, String param){
        for(int i=0;i<format_string.length();i++){
            if(format_string.charAt(i) == '#' && format_string.charAt(i+1) == 'j'){
                i++;
                int number = convertStringToInt(param);
                String hexValue = convertIntToHex(number);

            }else{
                System.out.print(format_string.charAt(i));
            }
        }
        System.out.println("");
    }
    public static void main(String[] args) throws IOException {
        //System.out.println("Hello, World!");
        BufferedReader bufferReader=new BufferedReader(new InputStreamReader(System.in));
        //Scanner sc=new Scanner(System.in);
        String format_string, param;
        while(bufferReader.ready()) {
            format_string=bufferReader.readLine();
            param=bufferReader.readLine();
            my_printf(format_string,param);
        }
    }
}