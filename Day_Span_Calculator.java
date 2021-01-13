package Learning;

import java.util.Locale;
import java.util.Scanner;

public class Day_Span_Calculator {
    public static void main(String[] args) {
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        // making array to store days each month (because every month don't have same days)
        String[] months = {"JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE", "JULY", "AUGUST", "SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER"};
        // making array to store name of each month (to compare user input months)
        Scanner sc = new Scanner(System.in);
        // making object of Scanner class (will help in taking input from the user)

        // Taking input of Starting Month from User.
        System.out.println("Enter starting month (e.g. january)");
        // Printing input provoking statement.
        String fromMonth = "";
        // initializing fromMonth. (This will store the user input 1st month)
        int startingMonth = 16;
        // initializing startingMonth (its value will be used to check that whether input month is right or wrong
        // and also stores the index number of the matched month as explained below)
        do {
            fromMonth = sc.next();
            // taking input from the user (fromMonth now has the 1st month)
            fromMonth = fromMonth.toUpperCase(Locale.ROOT);
            // changing to uppercase letters to avoid case conflict.
            for (int i = 0; i <= 11; i++) {
                if (fromMonth.equalsIgnoreCase(months[i])) {
                    startingMonth = i;
                    break;
                }
            }
            // This for loop will match the user input month with the original months array that i made and if its get matched,
            // it will store that array's index number with which it matched in starting month (i done this because from now on
            // whenever i will have to compare the two months i will compare their matched index numbers.
            // moreover, this also facilitates me to tell the days in that month as my original days in each month array has the
            // same index number for that month : )
            if (startingMonth == 16) {
                System.out.println("Invalid Month Input. Enter Again");
            }
            // if the user input invalid month name this if block will show this statement.
        }while (startingMonth == 16);
        // this do-while loop will continue to ask the user to input the correct month unless he/she enters.

        // taking input for Starting date
        System.out.println("Enter starting Date of " + fromMonth + " (e.g. 7)");
        // input invoking Statement.
        int fromDate = 0;
        // initializing fromDate (This will store the 1st date).
        while (fromDate < 1 || fromDate > daysInMonth[startingMonth]) {
            fromDate = sc.nextInt();
            if (fromDate < 1 || fromDate > daysInMonth[startingMonth]) {
                System.out.println("Invalid Date entered. " + fromMonth + " has dates from 1 to " + daysInMonth[startingMonth] + ". Enter Again");
            }
        }
        // This while loop will check whether the input date is in the valid dates limit of each month.


        //Taking input of Ending Month
        System.out.println("Enter ending month (e.g. february)");
        // input provoking statement.
        String toMonth = "";
        // initializing toMonth (this will store the 2nd month).
        int endingMonth = 16;
        // initializing endingMonth (its value will be used to check that whether input month is right or wrong, does comes
        // after the first month or not and also stores the index number of the matched month as explained below)
        do {
            toMonth = sc.next();
            // taking input in toMonth (this will store the 2nd month)
            toMonth = toMonth.toUpperCase(Locale.ROOT);
            // changing to upper case to avoid case conflict.
            for (int i = 0; i <= 11; i++) {
                if (toMonth.equalsIgnoreCase(months[i])) {
                    endingMonth = i;
                    break;
                }
                else {
                    endingMonth = 16;
                }
            }
            // this for loop will match the 2nd month from original months array of mine and again store the index number.
            if (endingMonth < startingMonth) {
                System.out.println("Final month must come after " + fromMonth + " or at least the same month. Enter again");
                endingMonth = 15;
            }
            // now here is the checking stage. this if block will check whether the 2nd month comes before the first month or not.
            // if it comes before the 1st month it will say to input again the value of 2nd month that should come after the 1st month
            // or atleast equal to the 1st month.
            // here i used endingMonth's value 15 for early month conflict and value 16 for invalid month conflict (e.g. janasdg)
            if (endingMonth == 16) {
                System.out.println("Invalid Month Input. Enter Again");
            }
            // this if block will show msg if the month doesn't match any month in original months array of mine (invalid month conflict).
        }while (endingMonth == 16 || endingMonth == 15);
        // This do-while loop will continue to take the month input again and again until all conflicts are removed.

        //taking input of Ending Date
        System.out.println("Enter ending Date of " + toMonth + " (e.g. 10)");
        // input provoking statement.
        int toDate = 0;
        // initializing toDate (this will store the 2nd date).
        if (endingMonth == startingMonth) {
            while (toDate < 1 || toDate < fromDate || toDate > daysInMonth[endingMonth]) {
                toDate = sc.nextInt();
                if (toDate < 1 || toDate < fromDate || toDate > daysInMonth[endingMonth]) {
                    System.out.println("Invalid Input Date. " + toMonth + " has dates from 1 to " + daysInMonth[endingMonth] +
                            ".\nAnd it should come after the starting date of " + fromMonth + " which you have entered " + fromDate  + " (or atleast the same date.)");
                }
                // this if block is also necessary. it is because if the user input the right date at a new iteration because of while loop
                // this msg of invalid date should not appear. so if condition will check when to follow statements or not.
            }
        }
        // now here is also a new thing. this above if block will check if both the months are same say 1st month = january, 2nd month = january.
        // by comparing their index numbers : ) . it is necessary to check because if both months are same the 2nd date should come after the
        // first date of this month. (i.e. if both months are january and 1st date is 11 (january 11), the second date should be atleast 11 or
        // greater than 11 and also less then the months max date.)
        // the inner while loop will continue the input taking process until all the conflicts are removed.
        else {
            while (toDate < 1 || toDate > daysInMonth[endingMonth]) {
                toDate = sc.nextInt();
                if (toDate < 1 || toDate > daysInMonth[endingMonth]) {
                    System.out.println("Invalid Date entered. " + toMonth + " has dates from 1 to " + daysInMonth[endingMonth] + ". Enter Again");
                }
            }
        }
        // this else block is for all other cases when the 1st month is not equal to the 2nd month. the 2nd date can be any between the legal
        // dates which will be checked from datesInMonths array of mine for the required month with months index number.


        System.out.println("");
        // printing empty line.
        System.out.print("Total Days span from " + fromMonth + " " + fromDate + " to " + toMonth + " " + toDate + " ==>> ");
        // printing the statement.
        System.out.println("\"" + day_span(startingMonth,endingMonth, toDate, fromDate, daysInMonth) + "\" day(s)");
        // in this i called a static day_span method which i made in this class. check below to know what happens in that method.
        // here i passed all the arguments that are required to calculate days.

    }

    static int day_span (int startMonth, int endMonth, int tDate, int fDate, int[] dayinMonth) {
        int days = 0;
        // initializing a new variable "days". this will store totals day span
        if (startMonth == endMonth) {
            days = (tDate - fDate) +1;
        }
        // this above if block will check whether the 1st and 2nd Month are same or not, if same then to calculate date i simply
        // have to subtract 1st date from final date and adding 1 so that the total days are calculated including boundaries.
        else if (startMonth != endMonth) {
            // now this else if block needs explanation. it will be executed only if 1st and 2nd month are not same
            int a = startMonth;
            // a => a new variable whose value is equal to the starting month index.
            days = (dayinMonth[a] - fDate) + 1;
            // this line will calculate the remaining days of the 1st month and also add 1 for the start date (initial boundary included).
            a += 1;
            // incrementing a to move to the next month.
            while (a<endMonth) {
                days += dayinMonth[a];
                a++;
            }
            // this while loop will add the total days in months between the 1st and the last month i.e. if 1st month => january
            // 2nd month => December then it will add the total days of months between january and december (but will not calculate days
            // of december
            days += tDate;
            // finally this line will add the days of 2nd upto which we need to calculate the dayspan
        }

        return days;
        // returning the days calculated
    }
}

// Mam this program was made after the 2nd code of my submitted file
// here i added some more things
// code that will deal with earlier date conflict (i.e., day span from February 2 to January 1),
// Month’s upper- and lower-case conflict and days in a month conflict (i.e., 32).
// invalid name of month conflict, etc.
// but i have to sacrifice taking input of month and date simultaneously in one answer which i have in
// my first code which is 2nd code in the submitted file
