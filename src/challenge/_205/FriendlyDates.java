package challenge._205;


import java.util.Calendar;

public class FriendlyDates {
	public static void main(String[] args) {
		
		String inputDate = "2015-07-01 2015-07-04";
//		String inputDate = "2015-12-01 2016-02-03";
//		String inputDate = "2015-12-01 2017-02-03";
//		String inputDate = "2016-03-01 2016-05-05";
//		String inputDate = "2017-01-01 2017-01-01";
//		String inputDate = "2022-09-05 2023-09-04";
//		String inputDate = "2015-04-01 2020-09-10";
//		String inputDate = "2015-04-01 2016-05-10";
//		String inputDate = "2015-12-11 2016-12-11";

		final int currentYear = Calendar.getInstance().get(Calendar.YEAR);

		String prettyPrint = "";
		final int dayArray[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};
		final String ordinalArray[] = {"1st","2nd","3rd","4th","5th","6th","7th","8th","9th","10th","11th","12th","13th","14th","15th","16th","17th","18th","19th","20th","21st","22th","23rd","24th","25th","26th","27th","28th","29th","30th","31st"};
		final int monthArray[] = {1,2,3,4,5,6,7,8,9,10,11,12};
		final String monthNameArray[] = {"January","February","March","April","May","June","July","August","September","October","November","December"};

		final int year1 = Integer.parseInt(inputDate.substring(0, 4));
		final int month1 = Integer.parseInt(inputDate.substring(5, 7));
		final int day1 = Integer.parseInt(inputDate.substring(8,10));

		final int year2 = Integer.parseInt(inputDate.substring(11, 15));
		final int month2 = Integer.parseInt(inputDate.substring(16, 18));
		final int day2 = Integer.parseInt(inputDate.substring(19,21));

		String prettyDate1[] = new String[5];
		String prettyDate2[] = new String[5];

		//populate prettyDate[0] with Month Name
		for(int i = 0; i <= 11; i += 1) {
			if(month1 == monthArray[i]) {
				prettyDate1[0] = monthNameArray[i];
			}
			if(month2 == monthArray[i]) {
				prettyDate2[0] = monthNameArray[i];
			}
		}

		//populate prettyDate[1] with ordinal value
		for(int i = 0; i <= 30; i += 1) {
			if(day1 == dayArray[i]) {
				prettyDate1[1] = ordinalArray[i];		
			}
			if(day2 == dayArray[i]) {
				prettyDate2[1] = ordinalArray[i];				
			}
		}

		prettyDate1[2] = ",";
		prettyDate2[2] = ",";
		prettyDate1[3] = Integer.toString(year1);
		prettyDate2[3] = Integer.toString(year2);

		//year1 is equal to the current year
		if(year1 == currentYear) {
			//year1 and year2 are both the current year and the months are the same, leave the years out, leave the second month out
			if(year2 == currentYear && month2 == month1) {
				prettyDate1[4] = prettyDate1[0] + " " + prettyDate1[1];
				prettyDate2[4] = prettyDate2[1];
				prettyPrint = prettyDate1[4] + " - " + prettyDate2[4];
			}
			//less than a year apart, leave the year out
			if(year2 == (year1+1) && month2 <= month1 && day2 > day1) {
				prettyDate1[4] = prettyDate1[0] + " " + prettyDate1[1];
				prettyDate2[4] = prettyDate2[0] + " " + prettyDate2[1];
				prettyPrint = prettyDate1[4] + " - " + prettyDate2[4];
			}
			//the two dates are exactly one year apart, also specify the year in both
			if(year2 == (year1 + 1) && month2 == month1 && day2 == day1) {
				prettyDate1[4] = prettyDate1[0] + " " + prettyDate1[1] + prettyDate1[2] + " " + prettyDate1[3];
				prettyDate2[4] = prettyDate2[0] + " " + prettyDate2[1] + prettyDate2[2] + " " + prettyDate2[3];
				prettyPrint = prettyDate1[4] + " - " + prettyDate2[4];
			}
			//the ending year isn't the same as the starting year and the dates are at least a year apart, then specify the year in both
			if(((year2 - year1) == 1 && month2 >= month1 && day2 > day1 || (year2 - year1) > 1)) {
				prettyDate1[4] = prettyDate1[0] + " " + prettyDate1[1] + prettyDate1[2] + " " + prettyDate1[3];
				prettyDate2[4] = prettyDate2[0] + " " + prettyDate2[1] + prettyDate2[2] + " " + prettyDate2[3];
				prettyPrint = prettyDate1[4] + " - " + prettyDate2[4];
			}
		}
		//year1 is not equal to the current year
		if(year1 != currentYear) {
			//the 2 dates are exactly the same
			if(year2 == year1 && month2 == month1 && day2 == day1) {
				prettyPrint = prettyDate1[0] + " " + prettyDate1[1] + prettyDate1[2] + " " + prettyDate1[3];
			}//the years are the same, leave out year1
			 else if(year2 == year1) {
				prettyDate1[4] = prettyDate1[0] + " " + prettyDate1[1];
				prettyDate2[4] = prettyDate2[0] + " " + prettyDate2[1] + prettyDate2[2] + " " + prettyDate2[3];
				prettyPrint = prettyDate1[4] + " - " + prettyDate2[4];
			//default output, specify year in both
			}else {
				prettyDate1[4] = prettyDate1[0] + " " + prettyDate1[1] + prettyDate1[2] + " " + prettyDate1[3];
				prettyDate2[4] = prettyDate2[0] + " " + prettyDate2[1] + prettyDate2[2] + " " + prettyDate2[3];
				prettyPrint = prettyDate1[4] + " - " + prettyDate2[4];
			}
		}			
		System.out.println(prettyPrint);
	}
}



