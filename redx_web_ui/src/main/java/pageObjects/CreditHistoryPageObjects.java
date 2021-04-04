package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import utils.*;

import java.text.*;
import java.util.*;

public class CreditHistoryPageObjects extends RedXWebBaseClass {
    private WebDriver driver;
    private MyActions myActions;

    private Random random;

    public CreditHistoryPageObjects(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements((driver), this);
        myActions = new MyActions();
        random = new Random();
    }

    /*----------Elements----------*/

    private WebElement dateRangeInput;
    private WebElement nextMonthButton;
    private WebElement nextYearButton;
    private WebElement currentMonthValue;
    private WebElement currentYearValue;
    private WebElement previousMonthButton;
    private WebElement previousYearButton;
    private WebElement dateButton;

    private WebElement searchButton;

    private WebElement transactionIdValue;
    private WebElement transactionDateValue;
    private WebElement amountTypeValue;
    private WebElement amountPaidOutValue;

    /*----------Actions----------*/

    public void clickDateRangeInput()
    {
        dateRangeInput = xpathSetter("//span[@class='ant-calendar-picker ant-calendar-picker-large']//i");
        myActions.action_click(dateRangeInput);
    }

    public long selectDate(int date, String month, int year)
    {
        previousYearButton = xpathSetter("//a[@class='ant-calendar-prev-year-btn']");
        previousMonthButton = xpathSetter("//a[@class='ant-calendar-prev-month-btn']");
        nextMonthButton = xpathSetter("//a[@class='ant-calendar-next-month-btn']");
        nextYearButton = xpathSetter("//a[@class='ant-calendar-next-year-btn']");

        List<String> monthList = Arrays.asList("Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec");
        int index = monthList.indexOf(month);

        while(true)
        {
            currentYearValue = xpathPresenceSetter("//a[@class='ant-calendar-year-select']");
            if(Integer.parseInt(currentYearValue.getText())==year)
                break;
            else {
                if(Integer.parseInt(currentYearValue.getText())>year)
                    myActions.action_click(previousYearButton);
                else
                    myActions.action_click(nextYearButton);
            }
        }

        while(true)
        {
            currentMonthValue = xpathSetter("//a[@class='ant-calendar-month-select']");
            if(currentMonthValue.getText().equalsIgnoreCase(month))
                break;
            else {
                if(index>5)
                    myActions.action_click(nextMonthButton);
                else
                    myActions.action_click(previousMonthButton);
            }
        }

        dateButton = xpathSetter("//td[@class='ant-calendar-cell']/div[text()='" + date + "']");
        myActions.action_click(dateButton);
        long number = convertDateToNumber(date,index,year);
        return number;
    }

    public long selectEndDateRange(int date, String month, int year)
    {
        previousYearButton = xpathSetter("//a[@class='ant-calendar-prev-year-btn']");
        previousMonthButton = xpathSetter("//a[@class='ant-calendar-prev-month-btn']");
        nextMonthButton = xpathSetter("//a[@class='ant-calendar-next-month-btn']");
        nextYearButton = xpathSetter("//a[@class='ant-calendar-next-year-btn']");

        List<String> monthList = Arrays.asList("Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec");
        int index = monthList.indexOf(month);

        while(true)
        {
            currentMonthValue = xpathSetter("//a[@class='ant-calendar-month-select']");
            if(currentMonthValue.getText().equalsIgnoreCase(month))
                break;
            else {
                if(index>5)
                    myActions.action_click(nextMonthButton);
                else
                    myActions.action_click(previousMonthButton);
            }
        }

        while(true)
        {
            currentYearValue = xpathPresenceSetter("//a[@class='ant-calendar-year-select']");
            if(Integer.parseInt(currentYearValue.getText())==year)
                break;
            else {
                if(Integer.parseInt(currentYearValue.getText())>year)
                    myActions.action_click(previousYearButton);
                else
                    myActions.action_click(nextYearButton);
            }
        }

        dateButton = xpathSetter("//td[@class='ant-calendar-cell ant-calendar-in-range-cell']/div[text()='" + date + "']");
        myActions.action_click(dateButton);
        long number = convertDateToNumber(date,index,year);
        return number;
    }

    public void clickSearchButton()
    {
        searchButton = xpathSetter("//button[contains(@class,'submit')]");
        myActions.action_click(searchButton);
    }

    public String getTransactionIdValue(int index)
    {
        transactionIdValue = xpathSetter("//tbody/tr[" + index + "]/td[1]");
        return myActions.action_getText(transactionIdValue);
    }

    public String getTransactionDateValue(int index)
    {
        transactionDateValue = xpathSetter("//tbody/tr[" + index + "]/td[2]");
        return myActions.action_getText(transactionDateValue);
    }

    public String getAmountTypeValue(int index)
    {
        amountTypeValue = xpathSetter("//tbody/tr[" + index + "]/td[3]");
        return myActions.action_getText(amountTypeValue).toLowerCase();
    }

    public String getAmountPaidOutValue(int index)
    {
        amountPaidOutValue = xpathSetter("//tbody/tr[" + index + "]/td[4]/span");
        String amount = myActions.action_getText(amountPaidOutValue);
        if (getAmountTypeValue(index).equalsIgnoreCase("debit"))
            return amount.substring(2);
        else return amount;
    }

    /*----------Functions----------*/

    public long convertDateToNumber(int date, int month, int year)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        String dateFormat = date + "-" + (month+1) + "-" + year +" 23:59:59";
        Date d = null;
        try {
            d = sdf.parse(dateFormat);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long number = d.getTime();
        System.out.println("Date : " + new Date(number));
        return number;
    }

    public long chooseStartDate(int date, String month, int year)
    {
        clickDateRangeInput();
        return selectDate(date,month,year);
    }

    public long chooseEndDate(int date, String month, int year)
    {
        return selectEndDateRange(date,month,year);
    }

}
