package daily.releases.D23M08Y2020;

import org.testng.annotations.Test;

public class ChangesForHyperLocalShipment {

    // Ticket : https://app.clickup.com/t/177nhb

    // Title : Changes for hyperlocal shipment on Mokam for RedX

    /* Description : Parcel Creation Request
    In the request normal parcel details should come.
    Additionally new ShopId should be given
    Total lifting price need to be given additionally
    2. GET api to view order
    Product Name, SKU, Image, Unit Price, QTY, Total
    Sourcing associate details
    3. GET Api: SR details by order id
    4. Admin Panel to edit product
    	a. Cancel the quantity.
    5. Updating the seller price*/

    // PRD : https://docs.google.com/document/d/15VF5kDm2rmy_tP-Hm6R-t8ue8cK3qZH0cumm20NqC3Q/edit#

    // TestCases/Observations : https://docs.google.com/document/d/1wvhvkFh5Tr0KmnEtWVNxWAWSVSwYjQa8EDZyHzgCuwA/edit


    @Test
    public void unbranded_non_wms_order(){

    }


    @Test
    public void unbranded_wms_order(){

    }


    @Test
    public void edit_seller_price(){

    }


    @Test
    public void cancel_order(){

    }


}
