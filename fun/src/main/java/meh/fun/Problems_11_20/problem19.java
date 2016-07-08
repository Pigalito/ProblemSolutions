/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meh.fun.Problems_11_20;

/**
 *
 * @author n439081
 */
public class problem19 {

  /**
   * You are given the following information, but you may prefer to do some research for yourself.

1 Jan 1900 was a Monday.
Thirty days has September,
April, June and November.
All the rest have thirty-one,
Saving February alone,
Which has twenty-eight, rain or shine.
And on leap years, twenty-nine.
A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
   */
  
  static int[] spareMonthDays = new int[12];
  
  public static void main(String[] args) {
    int currentDay = 0; // 1st Jan 1900 was a Monday
    int sundayCounter = 0;
    
    spareMonthDays[0] = 31%7;  // January
    spareMonthDays[1] = 28%7;  // February
    spareMonthDays[2] = 31%7;  // March
    spareMonthDays[3] = 30%7;  // April
    spareMonthDays[4] = 31%7;  // May
    spareMonthDays[5] = 30%7;  // June
    spareMonthDays[6] = 31%7;  // July
    spareMonthDays[7] = 31%7;  // August
    spareMonthDays[8] = 30%7;  // September
    spareMonthDays[9] = 31%7;  // October
    spareMonthDays[10] = 30%7; // November
    spareMonthDays[11] = 31%7; // December
    
    // Turn current day to the first day of 1901
    // Ignore leap year check as 1900 is not a leap year
    for(int spareDays : spareMonthDays){
      currentDay = (currentDay + spareDays)%7;
    }
    
    if(currentDay==6)sundayCounter++; // If 1st Jan 1901 is a sunday
    
    for(int year = 1901; year <= 2000; year++){
      if(isLeapYear(year)){
        spareMonthDays[1] = 29%7;
      } else {
        spareMonthDays[1] = 28%7;
      }
      for(int spareDays : spareMonthDays){
        currentDay = (currentDay + spareDays)%7;
        if(currentDay==6)sundayCounter++;
      }
    }
    
    System.out.println(sundayCounter);
    
  }
  
  private static boolean isLeapYear(int year){
    return year%4==0          // year divisible by 4
            && (year%100!=0   // year not divisible by 100
            || year%400==0);  // unless divisible by 400
  }
  
}
