import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import java.time.YearMonth;
import java.util.Calendar;
import java.util.Date;

public class numDaysOfMonth {
	public static void main(String[] args) throws ParseException {
		int[] monthNames = new int[12];
		for (int i = 1; i <=12 ; i++) {
			monthNames[i - 1] = i;
		}
		String[] shortMonths = new DateFormatSymbols().getShortMonths();
		
		boolean run = true;
		while (run) {
			String month = JOptionPane.showInputDialog(null,"Please type a month: ", "Type month", JOptionPane.INFORMATION_MESSAGE);
			int year = Integer.parseInt(JOptionPane.showInputDialog(null,"Please type a year: ", "Type year", JOptionPane.INFORMATION_MESSAGE));
			if (isNum(month)) {
				int m = Integer.parseInt(month);
				if (1 <= m && m <= 12) {
					int numDays = getNum(year, m);
					JOptionPane.showMessageDialog(null,"This month has " + numDays +" days", "Num of days", JOptionPane.INFORMATION_MESSAGE);
					run = false;
				}
				else {
					JOptionPane.showMessageDialog(null,"You have entered wrong value", "Wrong value", JOptionPane.INFORMATION_MESSAGE);
				}
			}
			else if (check(month.substring(0,3), shortMonths)) {
				String monthName = month.substring(0,3);
				Date date = new SimpleDateFormat("MMM").parse(monthName);
				Calendar cal = Calendar.getInstance();
				cal.setTime(date);
				int m = cal.get(Calendar.MONTH) + 1;
				int number = getNum(year, m);
				JOptionPane.showMessageDialog(null,"This month has " + number +" days", "Num of days", JOptionPane.INFORMATION_MESSAGE);
				run = false;
			}
			else {
				JOptionPane.showMessageDialog(null,"You have entered wrong value", "Wrong value", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	
	public static boolean isNum(String strNum) {
	    if (strNum == null) {
	        return false;
	    }
	    try {
	        int d = Integer.parseInt(strNum);
	    } 
	    catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
	
    public static int getNum(int year,int month)
    {
        YearMonth yearMonthObject = YearMonth.of(year, month);
        int daysInMonth = yearMonthObject.lengthOfMonth();
        return daysInMonth;
    }
    
    public static boolean check(String monthName, String[] shortmonths) {
    	for (int i = 0; i < 12; i++) {
    		if (monthName.compareTo(shortmonths[i]) == 0) {
    			return true;
    		}
    	}
    	return false;
    }

}
