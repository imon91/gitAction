package practice;

public class Verify
{
    public String minimumAmount (String  minimumamount)

    {
        String amount = "Tk.350";
        minimumamount = amount.replaceAll("[^0-5000]","");
        System.out.println(minimumamount);
        return minimumamount;
    }
}
