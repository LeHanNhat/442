package Lab3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NextDateTest {

	 NextDate nextDate = new NextDate();

    

	 @Test
	    public void testValidNextDay() {
	        nextDate.setYearmonthdate(2023, 31, 1);
	        String result = nextDate.next_date();
	        assertEquals("Next Date is :1-2-2023", result);
	    }

	    @Test
	    public void testValidNextDayInMonthWith30Days() {
	        nextDate.setYearmonthdate(2023, 30, 4);
	        String result = nextDate.next_date();
	        assertEquals("Next Date is :1-5-2023", result);
	    }

	    @Test
	    public void testValidNextDayInLeapYearFebruary() {
	        nextDate.setYearmonthdate(2024, 29, 2);
	        String result = nextDate.next_date();
	        assertEquals("Next Date is :1-3-2024", result);
	    }

	    @Test
	    public void testValidNextDayInNonLeapYearFebruary() {
	        nextDate.setYearmonthdate(2023, 28, 2);
	        String result = nextDate.next_date();
	        assertEquals("Next Date is :1-3-2023", result);
	    }

	    @Test
	    public void testEndOfYear() {
	        nextDate.setYearmonthdate(2024, 31, 12);
	        String result = nextDate.next_date();
	        assertEquals("Next Date is :1-1-2025", result);
	    }

	    // Invalid Day Tests
	    @Test
	    public void testInvalidDayGreaterThan31() {
	        nextDate.setYearmonthdate(2023, 32, 1);
	        String result = nextDate.next_date();
	        assertEquals("Value of day, not in the range 1...31", result);
	    }

	    @Test
	    public void testInvalidDayGreaterThan30InApril() {
	        nextDate.setYearmonthdate(2023, 31, 4);
	        String result = nextDate.next_date();
	        assertEquals("value of day, not in the range day<=30", result);
	    }

	    @Test
	    public void testInvalidDayGreaterThan30InJune() {
	        nextDate.setYearmonthdate(2023, 31, 6);
	        String result = nextDate.next_date();
	        assertEquals("value of day, not in the range day<=30", result);
	    }

	    @Test
	    public void testInvalidDayGreaterThan30InSeptember() {
	        nextDate.setYearmonthdate(2023, 31, 9);
	        String result = nextDate.next_date();
	        assertEquals("value of day, not in the range day<=30", result);
	    }

	    @Test
	    public void testInvalidDayGreaterThan30InNovember() {
	        nextDate.setYearmonthdate(2023, 31, 11);
	        String result = nextDate.next_date();
	        assertEquals("value of day, not in the range day<=30", result);
	    }

	    // Day > 31 in any month
	    @Test
	    public void testInvalidDayGreaterThan31InAnyMonth() {
	        nextDate.setYearmonthdate(2023, 32, 1);
	        String result = nextDate.next_date();
	        assertEquals("Value of day, not in the range 1...31", result);
	    }

	    // Invalid Month Greater Than 12
	    @Test
	    public void testInvalidMonthGreaterThan12() {
	        nextDate.setYearmonthdate(2023, 15, 13);
	        String result = nextDate.next_date();
	        assertEquals("value of month, not in the range 1....12", result);
	    }

	    // Invalid Leap Year Date
	    @Test
	    public void testInvalidLeapYearDate() {
	        nextDate.setYearmonthdate(2024, 30, 2);
	        String result = nextDate.next_date();
	        assertEquals("invalid date input for leap year", result);
	    }

	    // Invalid Non-Leap Year Date
	    @Test
	    public void testInvalidNonLeapYearDate() {
	        nextDate.setYearmonthdate(2023, 29, 2);
	        String result = nextDate.next_date();
	        assertEquals("invalid date input for not a leap year", result);
	    }

	    // Year Out of Range Tests
	    @Test
	    public void testYearOutOfRangeLower() {
	        nextDate.setYearmonthdate(1799, 31, 12);
	        String result = nextDate.next_date();
	        assertEquals("value of year, not in the range 1800.......2025", result);
	    }

	    @Test
	    public void testYearOutOfRangeUpper() {
	        nextDate.setYearmonthdate(2025, 31, 12);
	        String result = nextDate.next_date();
	        assertEquals("the next day is out of boundary value of year", result);
	    }

	    // Invalid Day Negative
	    @Test
	    public void testInvalidDayNegative() {
	        nextDate.setYearmonthdate(2023, -1, 1);
	        String result = nextDate.next_date();
	        assertEquals("Value of day, not in the range 1...31", result);
	    }
	    @Test
	    public void testLeapYearDivisibleBy4ButNot100() {
	        // Year 2024 is divisible by 4 but not by 100
	        int result = nextDate.isleap(2024);
	        assertEquals(1, result);  // Expected to be a leap year
	    }

	    @Test
	    public void testNotLeapYearDivisibleBy100ButNot400() {
	        // Year 1900 is divisible by 100 but not by 400
	        int result = nextDate.isleap(1900);
	        assertEquals(0, result);  // Expected to be NOT a leap year
	    }

	    @Test
	    public void testLeapYearDivisibleBy400() {
	        // Year 2000 is divisible by 400
	        int result = nextDate.isleap(2000);
	        assertEquals(1, result);  // Expected to be a leap year
	    }

	    @Test
	    public void testNotLeapYearNotDivisibleBy4() {
	        // Year 2023 is not divisible by 4
	        int result = nextDate.isleap(2023);
	        assertEquals(0, result);  // Expected to be NOT a leap year
	    }
	    @Test
	    public void testInvalidMonthLessThan1() {
	       
	        nextDate.setYearmonthdate(2023, 31, 0);
	        String result = nextDate.next_date();
	        assertEquals("value of month, not in the range 1....12", result);
	    }
	    @Test
	    public void testYearLessThanOrEqual1800() {
	        
	        nextDate.setYearmonthdate(1800, 31, 12);
	        String result = nextDate.next_date();
	        assertEquals("value of year, not in the range 1800.......2025", result);
	    }

	    @Test
	    public void testYearGreaterThan2025() {
	        
	        nextDate.setYearmonthdate(2026, 31, 12);
	        String result = nextDate.next_date();
	        assertEquals("value of year, not in the range 1800.......2025", result);
	    }

	    @Test
	    public void testValidYearWithinRange() {
	       
	        nextDate.setYearmonthdate(2023, 31, 12);
	        String result = nextDate.next_date();
	        assertEquals("Next Date is :1-1-2024", result);  
	    }
	    @Test
	    public void testNonLeapYearDate() {
	        nextDate.setYearmonthdate(2023, 29, 2);
	        String result = nextDate.next_date();
	        assertEquals("invalid date input for not a leap year", result);
	    }
}
