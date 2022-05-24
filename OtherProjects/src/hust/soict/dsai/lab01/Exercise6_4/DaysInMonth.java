package hust.soict.dsai.lab01.Exercise6_4;
import java.util.Scanner;
import java.text.DateFormatSymbols;
import java.util.Calendar;

public class DaysInMonth {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        DateFormatSymbols dfs = new DateFormatSymbols();
        String[] shortMonths = dfs.getShortMonths();
        System.out.print("Enter the year: ");
        int year = sc.nextInt();
        int monthInt = 0;
        System.out.print("Enter the month: ");
        String monthName = sc.next();
        if (checkNum(monthName)){
            monthInt = Integer.parseInt(monthName); 
        }
        else {
            for (int i = 0; i < 12; i++){
                if ( monthName.substring(0,3).compareTo(shortMonths[i]) == 0){
                    monthInt = i;
                } 
            }
        }
        
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, monthInt);
        int days_of_month = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        System.out.println("There are " + days_of_month + " days in this month");
    
    }

    public static boolean checkNum(String str){
        try {
            int intValue = Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}
