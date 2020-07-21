package services.responseModels.commerceModels;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ShoppingCartResponseModel {


    /**
     * enable_primo_cart_popup : {"primo_amount":149,"wap_add_default":true,"wap_less_amount":true,"wap_signed":true}
     * adjustments : [{"income":0,"is_seller_coupon":false,"adjustment_type":6,"formatted_income":"Tk. 0","label":"Shipping Charges","value_amount":49,"value":"Tk. 49","value_currency":"INR"}]
     * payment_pending_orders : {"is_present":false,"orders_list":[]}
     * enable_remove_coupon : false
     * minimum_delivery_charge : 49
     * online_payment_banner_link : //images1.voonik.com/desktop/patch_with_wallets.png
     * current_payment_details : {"payment_method":{"account_id":0,"code":"cod","name":"cod","id":1,"display_name":"CASH ON DELIVERY"}}
     * check_duplicate_order : true
     * special_prepaid_method : false
     * shipped_addresses : [{"country":"INDIA","firstname":"testing","address2":"dhaka","city":"Adabor, Dhaka","alternative_phone":null,"address1":"Shopup street","lastname":"","zipcode":"7","is_saved":null,"user_id":122694,"phone":"8801877755590","company":"home","id":9122690,"state":"Andhra Pradesh","state_id":34,"landmark":"","country_id":1},{"country":"INDIA","firstname":"testing","address2":"dhaka","city":"Adabor, Dhaka","alternative_phone":null,"address1":"Shopup street","lastname":"","zipcode":"7","is_saved":null,"user_id":122694,"phone":"8801877755590","company":"home","id":9122689,"state":"Andhra Pradesh","state_id":34,"landmark":"","country_id":1},{"country":"INDIA","firstname":"testing","address2":"dhaka","city":"Adabor, Dhaka","alternative_phone":null,"address1":"Shopup street","lastname":"","zipcode":"7","is_saved":null,"user_id":122694,"phone":"8801877755590","company":"home","id":9122688,"state":"Andhra Pradesh","state_id":34,"landmark":"","country_id":1},{"country":"INDIA","firstname":"testing","address2":"dhaka","city":"Adabor, Dhaka","alternative_phone":null,"address1":"Shopup street","lastname":"","zipcode":"7","is_saved":null,"user_id":122694,"phone":"8801877755590","company":"home","id":9122687,"state":"Andhra Pradesh","state_id":34,"landmark":"","country_id":1},{"country":"Andhra Pradesh","firstname":"testing 1","address2":"dhaka","city":"Adabor, Dhaka","alternative_phone":null,"address1":"Shopup street 1","lastname":"","zipcode":"7","is_saved":null,"user_id":122694,"phone":"8801877755590","company":"home","id":9122686,"state":"Andhra Pradesh","state_id":34,"landmark":"","country_id":1},{"country":"Andhra Pradesh","firstname":"testing 2","address2":"dhaka","city":"Adabor, Dhaka","alternative_phone":null,"address1":"Shopup street","lastname":"","zipcode":"7","is_saved":null,"user_id":122694,"phone":"8801877755590","company":"home","id":9122683,"state":"Andhra Pradesh","state_id":34,"landmark":"","country_id":1},{"country":"Andhra Pradesh","firstname":"testing 3","address2":"dhaka","city":"Adabor, Dhaka","alternative_phone":null,"address1":"Shopup street 3","lastname":"","zipcode":"7","is_saved":null,"user_id":122694,"phone":"8801877755590","company":"home","id":9122682,"state":"Andhra Pradesh","state_id":34,"landmark":"","country_id":1},{"country":"Andhra Pradesh","firstname":"testing  4","address2":"dhaka","city":"Adabor, Dhaka","alternative_phone":null,"address1":"Shopup street","lastname":"","zipcode":"7","is_saved":null,"user_id":122694,"phone":"8801877755590","company":"home","id":9122677,"state":"Andhra Pradesh","state_id":34,"landmark":"","country_id":1},{"country":"Andhra Pradesh","firstname":"Testing 5","address2":"F colony","city":"Adamdighi, Bogra","alternative_phone":null,"address1":"Shop street","lastname":"","zipcode":"818","is_saved":null,"user_id":122694,"phone":"8801877755590","company":"NA","id":9122676,"state":"Andhra Pradesh","state_id":34,"landmark":"","country_id":1},{"country":"INDIA","firstname":"ashok","address2":"adhaka","city":"Adabor, Dhaka","alternative_phone":null,"address1":"shop street","lastname":"","zipcode":"7","is_saved":null,"user_id":122694,"phone":"8801877755590","company":"NA","id":9122675,"state":"Andhra Pradesh","state_id":34,"landmark":"","country_id":1},{"country":"INDIA","firstname":"Siva","address2":"N/A","city":"Balughat, Dhaka","alternative_phone":null,"address1":"Shopf street","lastname":"","zipcode":"41","is_saved":null,"user_id":122694,"phone":"8801877755590","company":"NA","id":9122674,"state":"Andhra Pradesh","state_id":34,"landmark":"","country_id":1},{"country":"INDIA","firstname":"ashok","address2":"shopup","city":"Adabor, Dhaka","alternative_phone":null,"address1":"shopup street","lastname":"","zipcode":"7","is_saved":null,"user_id":122694,"phone":"8801877755590","company":"NA","id":9122673,"state":"Andhra Pradesh","state_id":34,"landmark":"","country_id":1},{"country":"INDIA","firstname":"testing","address2":"dhaka","city":"Adabor, Dhaka","alternative_phone":null,"address1":"Shopup street","lastname":"","zipcode":"7","is_saved":null,"user_id":122694,"phone":"8801877755590","company":"home","id":9122670,"state":"Andhra Pradesh","state_id":34,"landmark":"","country_id":1},{"country":"INDIA","firstname":"Aravind Rajendran","address2":"Ghffddffhh","city":"Aftabnagar, Dhaka","alternative_phone":null,"address1":"Linked lin hjkj","lastname":"","zipcode":"94","is_saved":null,"user_id":122694,"phone":"8801877775555","company":"NA","id":9122669,"state":"Andhra Pradesh","state_id":34,"landmark":"","country_id":1},{"country":"INDIA","firstname":"testing","address2":"dhaka","city":"Adabor, Dhaka","alternative_phone":null,"address1":"Shopup street","lastname":"","zipcode":"7","is_saved":null,"user_id":122694,"phone":"8801877755590","company":"home","id":9122668,"state":"Andhra Pradesh","state_id":34,"landmark":"","country_id":1},{"country":"INDIA","firstname":"testing","address2":"dhaka","city":"Adabor, Dhaka","alternative_phone":null,"address1":"Shopup street","lastname":"","zipcode":"7","is_saved":null,"user_id":122694,"phone":"8801877755590","company":"home","id":9122667,"state":"Andhra Pradesh","state_id":34,"landmark":"","country_id":1},{"country":"INDIA","firstname":"testing","address2":"dhaka","city":"Adabor, Dhaka","alternative_phone":null,"address1":"Shopup street","lastname":"","zipcode":"7","is_saved":null,"user_id":122694,"phone":"8801877755590","company":"home","id":9122661,"state":"Andhra Pradesh","state_id":34,"landmark":"","country_id":1},{"country":"INDIA","firstname":"Siva","address2":"F colony","city":"Adabor, Dhaka","alternative_phone":null,"address1":"shop street","lastname":"","zipcode":"7","is_saved":null,"user_id":122694,"phone":"8801877755590","company":null,"id":9122660,"state":"Andhra Pradesh","state_id":34,"landmark":"","country_id":1},{"country":"INDIA","firstname":"testing","address2":"dhaka","city":"Adabor, Dhaka","alternative_phone":null,"address1":"Shopup street","lastname":"","zipcode":"7","is_saved":null,"user_id":122694,"phone":"8801877755590","company":"home","id":9122658,"state":"Andhra Pradesh","state_id":34,"landmark":"","country_id":1},{"country":"INDIA","firstname":"testing","address2":"dhaka","city":"Adabor, Dhaka","alternative_phone":null,"address1":"Shopup street","lastname":"","zipcode":"7","is_saved":null,"user_id":122694,"phone":"8801877755590","company":"home","id":9122657,"state":"Andhra Pradesh","state_id":34,"landmark":"","country_id":1},{"country":"INDIA","firstname":"testing","address2":"dhaka","city":"Adabor, Dhaka","alternative_phone":null,"address1":"Shopup street","lastname":"","zipcode":"7","is_saved":null,"user_id":122694,"phone":"8801877755590","company":"home","id":9122654,"state":"Andhra Pradesh","state_id":34,"landmark":"","country_id":1},{"country":"INDIA","firstname":"testing","address2":"dhaka","city":"Adabor, Dhaka","alternative_phone":null,"address1":"Shopup street","lastname":"","zipcode":"7","is_saved":null,"user_id":122694,"phone":"8801877755590","company":"home","id":9122651,"state":"Andhra Pradesh","state_id":34,"landmark":"","country_id":1},{"country":"INDIA","firstname":"testing","address2":"dhaka","city":"Adabor, Dhaka","alternative_phone":null,"address1":"Shopup street","lastname":"","zipcode":"7","is_saved":null,"user_id":122694,"phone":"8801877755590","company":"home","id":9122650,"state":"Andhra Pradesh","state_id":34,"landmark":"","country_id":1},{"country":"INDIA","firstname":"testing","address2":"dhaka","city":"Adabor, Dhaka","alternative_phone":null,"address1":"Shopup street","lastname":"","zipcode":"7","is_saved":null,"user_id":122694,"phone":"8801877755590","company":"home","id":9122649,"state":"Andhra Pradesh","state_id":34,"landmark":"","country_id":1},{"country":"INDIA","firstname":"testing","address2":"dhaka","city":"Adabor, Dhaka","alternative_phone":null,"address1":"Shopup street","lastname":"","zipcode":"7","is_saved":null,"user_id":122694,"phone":"8801877755590","company":"home","id":9122646,"state":"Andhra Pradesh","state_id":34,"landmark":"","country_id":1},{"country":"INDIA","firstname":"testing","address2":"dhaka","city":"Adabor, Dhaka","alternative_phone":null,"address1":"Shopup street","lastname":"","zipcode":"7","is_saved":null,"user_id":122694,"phone":"8801877755590","company":"home","id":9122628,"state":"Andhra Pradesh","state_id":34,"landmark":"","country_id":1},{"country":"INDIA","firstname":"testing","address2":"dhaka","city":"Adabor, Dhaka","alternative_phone":null,"address1":"Shopup street","lastname":"","zipcode":"7","is_saved":null,"user_id":122694,"phone":"8801877755590","company":"home","id":9122625,"state":"Andhra Pradesh","state_id":34,"landmark":"","country_id":1},{"country":"INDIA","firstname":"testing","address2":"dhaka","city":"Adabor, Dhaka","alternative_phone":null,"address1":"Shopup street","lastname":"","zipcode":"7","is_saved":null,"user_id":122694,"phone":"8801877755590","company":"home","id":9122622,"state":"Andhra Pradesh","state_id":34,"landmark":"","country_id":1},{"country":"INDIA","firstname":"testing","address2":"dhaka","city":"Adabor, Dhaka","alternative_phone":null,"address1":"Shopup street","lastname":"","zipcode":"7","is_saved":null,"user_id":122694,"phone":"8801877755590","company":"home","id":9122621,"state":"Andhra Pradesh","state_id":34,"landmark":"","country_id":1},{"country":"INDIA","firstname":"testing","address2":"dhaka","city":"Adabor, Dhaka","alternative_phone":null,"address1":"Shopup street","lastname":"","zipcode":"7","is_saved":null,"user_id":122694,"phone":"8801877755590","company":"home","id":9122620,"state":"Andhra Pradesh","state_id":34,"landmark":"","country_id":1},{"country":"INDIA","firstname":"testing","address2":"shopup","city":"Adabor, Dhaka","alternative_phone":null,"address1":"shopup street","lastname":"","zipcode":"7","is_saved":null,"user_id":122694,"phone":"8801877755590","company":"home","id":9122619,"state":"Andhra Pradesh","state_id":34,"landmark":"","country_id":1},{"country":"INDIA","firstname":"testing","address2":"dhaka","city":"Adabor, Dhaka","alternative_phone":null,"address1":"Shopup street","lastname":"","zipcode":"7","is_saved":null,"user_id":122694,"phone":"8801877755590","company":"home","id":9122618,"state":"Andhra Pradesh","state_id":34,"landmark":"","country_id":1},{"country":"INDIA","firstname":"testing","address2":"dhaka","city":"Adabor, Dhaka","alternative_phone":null,"address1":"Shopup street","lastname":"","zipcode":"7","is_saved":null,"user_id":122694,"phone":"8801877755590","company":"home","id":9122617,"state":"Andhra Pradesh","state_id":34,"landmark":"","country_id":1},{"country":"INDIA","firstname":"testing","address2":"dhaka","city":"Adabor, Dhaka","alternative_phone":null,"address1":"Shopup street","lastname":"","zipcode":"7","is_saved":null,"user_id":122694,"phone":"8801877755590","company":"home","id":9122616,"state":"Andhra Pradesh","state_id":34,"landmark":"","country_id":1},{"country":"INDIA","firstname":"testing","address2":"dhaka","city":"Adabor, Dhaka","alternative_phone":null,"address1":"Shopup street","lastname":"","zipcode":"7","is_saved":null,"user_id":122694,"phone":"8801877755590","company":"home","id":9122615,"state":"Andhra Pradesh","state_id":34,"landmark":"","country_id":1},{"country":"INDIA","firstname":"testing","address2":"dhaka","city":"Adabor, Dhaka","alternative_phone":null,"address1":"Shopup street","lastname":"","zipcode":"7","is_saved":null,"user_id":122694,"phone":"8801877755590","company":"home","id":9122614,"state":"Andhra Pradesh","state_id":34,"landmark":"","country_id":1},{"country":"INDIA","firstname":"testing","address2":"dhaka","city":"Adabor, Dhaka","alternative_phone":null,"address1":"Shopup street","lastname":"","zipcode":"7","is_saved":null,"user_id":122694,"phone":"8801877755590","company":"home","id":9122613,"state":"Andhra Pradesh","state_id":34,"landmark":"","country_id":1},{"country":"INDIA","firstname":"testing","address2":"dhaka","city":"Adabor, Dhaka","alternative_phone":null,"address1":"Shopup street","lastname":"","zipcode":"7","is_saved":null,"user_id":122694,"phone":"8801877755590","company":"home","id":9122612,"state":"Andhra Pradesh","state_id":34,"landmark":"","country_id":1},{"country":"INDIA","firstname":"testing","address2":"dhaka","city":"Adabor, Dhaka","alternative_phone":null,"address1":"Shopup street","lastname":"","zipcode":"7","is_saved":null,"user_id":122694,"phone":"8801877755590","company":"home","id":9122611,"state":"Andhra Pradesh","state_id":34,"landmark":"","country_id":1},{"country":"Andhra Pradesh","firstname":"testing","address2":"shopup","city":"Adabor, Dhaka","alternative_phone":null,"address1":"Shopup street","lastname":"","zipcode":"7","is_saved":null,"user_id":122694,"phone":"8801877755590","company":"home","id":9122610,"state":"Andhra Pradesh","state_id":34,"landmark":"","country_id":1},{"country":"INDIA","firstname":"ashok","address2":"N/A","city":"Adabor, Dhaka","alternative_phone":null,"address1":"shopup at dhaka","lastname":"","zipcode":"7","is_saved":null,"user_id":122694,"phone":"8801877755590","company":"NA","id":9043057,"state":"Andhra Pradesh","state_id":34,"landmark":"","country_id":1},{"country":"INDIA","firstname":"Vijay","address2":"Nnsnsnsnsnsns","city":"Adabor, Dhaka","alternative_phone":null,"address1":"Bbsnsns annznz NJs","lastname":"","zipcode":"7","is_saved":null,"user_id":122694,"phone":"8801877755590","company":"NA","id":9043002,"state":"Andhra Pradesh","state_id":34,"landmark":"","country_id":1},{"country":"Andhra Pradesh","firstname":"Vijay","address2":"N/A","city":"Adamdighi, Bogra","alternative_phone":null,"address1":"Bsbbsb dbbbdbnd d nsndndndnnd ndndndndndn xndnnxjx","lastname":"","zipcode":"818","is_saved":null,"user_id":122694,"phone":"8801877755590","company":"NA","id":9042990,"state":"Andhra Pradesh","state_id":34,"landmark":"","country_id":1},{"country":"INDIA","firstname":"vijay","address2":"N/A","city":"Adabor, Dhaka","alternative_phone":null,"address1":"asdasd asdasdasd asdasdasdasd","lastname":"","zipcode":"7","is_saved":null,"user_id":122694,"phone":"8801877755590","company":"NA","id":9042987,"state":"Andhra Pradesh","state_id":34,"landmark":"","country_id":1},{"country":"INDIA","firstname":"vijay","address2":"N/A","city":"Adabor, Dhaka","alternative_phone":null,"address1":"assdasd asdasdas d asdasdasdasdasd asdas sadasdasd asdasddas","lastname":"","zipcode":"7","is_saved":null,"user_id":122694,"phone":"8801877755590","company":"NA","id":9042986,"state":"Andhra Pradesh","state_id":34,"landmark":"","country_id":1},{"country":"INDIA","firstname":"vijay","address2":"N/A","city":"Adabor, Dhaka","alternative_phone":null,"address1":"assdasd asdasdas d asdasdasdasdasd asdas sadasdasd asdasddas","lastname":"","zipcode":"7","is_saved":null,"user_id":122694,"phone":"8801877755590","company":"NA","id":9042985,"state":"Andhra Pradesh","state_id":34,"landmark":"","country_id":1},{"country":"INDIA","firstname":"test","address2":"dhasdasdad","city":"Adabor, Dhaka","alternative_phone":null,"address1":"some random address","lastname":"","zipcode":"7","is_saved":null,"user_id":122694,"phone":"8801877755590","company":"home","id":9042982,"state":"Andhra Pradesh","state_id":34,"landmark":"al","country_id":1}]
     * total_currency : INR
     * disable_cart_timer :
     * payment_methods : [{"payment_method":{"account_id":0,"code":null,"name":"payu_redirect","rank":100,"id":7,"vaccount_id":1,"display_name":null,"is_default":false}},{"payment_method":{"account_id":0,"code":"ptr","name":"payu_redirect","rank":60,"id":71,"vaccount_id":1,"display_name":"PREPAID TO RESELLER","is_default":false}},{"payment_method":{"account_id":0,"code":"paypal","name":"payu_redirect","rank":50,"id":61,"vaccount_id":1,"display_name":"PAYPAL","is_default":false}},{"payment_method":{"account_id":0,"code":"wallet","name":"payu_redirect","rank":40,"id":51,"vaccount_id":1,"display_name":"WALLETS","is_default":false}},{"payment_method":{"account_id":0,"code":"nb","name":"payu_redirect","rank":40,"id":41,"vaccount_id":1,"display_name":"NET BANKING","is_default":false}},{"payment_method":{"account_id":0,"code":"cc","name":"payu_redirect","rank":30,"id":31,"vaccount_id":1,"display_name":"CREDIT CARD","is_default":false}},{"payment_method":{"account_id":0,"code":"dc","name":"payu_redirect","rank":20,"id":21,"vaccount_id":1,"display_name":"DEBIT / ATM CARD","is_default":false}},{"payment_method":{"account_id":0,"code":"cod","name":"cod","rank":10,"id":1,"vaccount_id":1,"display_name":"CASH ON DELIVERY","is_default":true}},{"payment_method":{"account_id":0,"code":null,"name":"simpl","rank":1,"id":14,"vaccount_id":1,"display_name":null,"is_default":false}},{"payment_method":{"account_id":0,"code":null,"name":"simpl","rank":1,"id":17,"vaccount_id":1,"display_name":null,"is_default":false}},{"payment_method":{"account_id":0,"code":null,"name":"cod","rank":1,"id":16,"vaccount_id":1,"display_name":null,"is_default":false}},{"payment_method":{"account_id":0,"code":null,"name":"payu_redirect","rank":1,"id":15,"vaccount_id":1,"display_name":null,"is_default":false}},{"payment_method":{"account_id":0,"code":null,"name":"cod","rank":1,"id":13,"vaccount_id":1,"display_name":null,"is_default":false}},{"payment_method":{"account_id":0,"code":null,"name":"payu_redirect","rank":1,"id":12,"vaccount_id":1,"display_name":null,"is_default":false}},{"payment_method":{"account_id":0,"code":null,"name":"payu_redirect","rank":1,"id":11,"vaccount_id":1,"display_name":null,"is_default":false}},{"payment_method":{"account_id":0,"code":null,"name":"cod","rank":1,"id":10,"vaccount_id":1,"display_name":null,"is_default":false}},{"payment_method":{"account_id":0,"code":null,"name":"payu_redirect","rank":1,"id":9,"vaccount_id":1,"display_name":null,"is_default":false}},{"payment_method":{"account_id":0,"code":null,"name":"cod","rank":1,"id":8,"vaccount_id":1,"display_name":null,"is_default":false}},{"payment_method":{"account_id":0,"code":null,"name":"email_invoice","rank":1,"id":6,"vaccount_id":1,"display_name":null,"is_default":false}}]
     * user_email_valid : true
     * total_amount_after_discount : 8710.0
     * cod_adjustments : []
     * ship_address : {"address":{"country":"INDIA","firstname":"ashok","address2":"N/A","city":"Adabor, Dhaka","alternative_phone":null,"address1":"shopup at dhaka","lastname":"","zipcode":"7","is_saved":null,"user_id":122694,"phone":"8801877755590","company":"NA","id":9043057,"state":"Andhra Pradesh","state_id":34,"landmark":"","country_id":1}}
     * enable_online_payment_banner : false
     * payment_method : cod
     * single_step_checkout : false
     * special_instructions : {"preferred_days":"","preferred_slots":"","text":""}
     * prepaid_message_config : {"prepaid_retry_message":"Your payment for this order has failed. Please try making the payment again. Note: If you think that you have already made a successful payment, you can wait for 30 minutes till we check and confirm your payment. You can check the status of your order and payment in 'My Orders' page.","retry_message_for_close_popup":"Seems like your payment is pending/failed. You can retry paying by below options or alternatively you can go to My Orders page and complete the payment in next 24 hours to avoid the cancellation. Note: If you think that you have already made a successful payment, you can wait for 30 minutes till we check and confirm your payment. You can check the status of your order and payment in 'My Orders' page.","prepaid_order_message":"Please wait while we redirect you for making payment..."}
     * final_save : -847
     * show_pdp_link_in_address_page : false
     * grand_total_amount : 8759
     * total_str : Tk. 8,710
     * prepaid_order_message : Please wait while we redirect you for making payment...
     * show_saved_cards : false
     * coupon_display_messages : []
     * prepaid_preference_message :
     * total_amount : 8710
     * maximum_delivery_charge : 150
     * non_cod_adjustments : [{"adjustment_type":6,"label":"Shipping Charges","value_amount":49,"value_currency":"INR"}]
     * coupon_applied : []
     * primo_cart_images : {"wap_unsigned":"//images11.voonik.com/primo_assets/primo_web_signed_1.jpg","web_signed":"//images11.voonik.com/primo_assets/primo_web_signed_1.jpg","web_unsigned":"//images11.voonik.com/primo_assets/primo_web_signed_1.jpg","wap_signed":"//images11.voonik.com/primo_assets/primo_web_signed_1.jpg"}
     * formatted_total_save : Tk. 355
     * enable_prepaid_retry : true
     * order_number : R0162378311
     * payment_types : [{"account_id":0,"code":"cod","name":"cod","id":1,"display_name":"CASH ON DELIVERY","payment_options":[{"offer_message":null,"wallet_id":null,"code":"COD","image_url":null,"id":1,"direct_debit":null,"display_name":"CASH ON DELIVERY"}]}]
     * formatted_final_save : Tk. -847
     * total : Tk. 8,710
     * order_address : {"address":{}}
     * grand_total : Tk. 8,759
     * cart_offer_message :
     * coupon_code_applied : false
     * disable_cart_purchase : false
     * shipping_adjustments : []
     * is_gamified_order? : false
     * cart_items : [{"formatted_price":"Tk. 787","seller":"7MEC","min_order_qty":1,"line_item_id":297865,"discount":0,"prepaid_availability":true,"seller_slug":"7MEC","delivery_time":"COD is not available.","title":"Casual T-shirt for Men - MEC003 - 7MEC","liked":false,"category_id":1117,"variant_options":[{"count_on_hand":2,"option_value_name":"M","size":25,"corrected_count_on_hand":2,"name":"M","id":94134},{"count_on_hand":2,"option_value_name":"L","size":25,"corrected_count_on_hand":2,"name":"L","id":94135},{"count_on_hand":2,"option_value_name":"XL","size":25,"corrected_count_on_hand":2,"name":"XL","id":94136},{"count_on_hand":1,"option_value_name":"XXL","size":25,"corrected_count_on_hand":1,"name":"XXL","id":94137},{"count_on_hand":2,"option_value_name":"XXXL","size":25,"corrected_count_on_hand":2,"name":"XXXL","id":94138}],"max_item_quantity":50,"price":"787.0","product_id":72580,"sold_out":false,"variant":94134,"formatted_income":"Tk. 72","mrp_price_line":"Tk. 780 x 1 = Tk. 780","cod_availability":false,"formatted_per_item_total":"Tk. 787","per_item_total":787,"sku":"339473","delivery_time_message":{"message":"COD is not available.","type":0},"prepaid_message":"Dispatched in - working days.","activity_object":{"activity_object":{"id":"P72580"}},"image":"https://shopimages.vstores.io/49527/Polo-T-shirt-for-Men---MEC003---7MEC-small.jpeg?1580468596","quantity":1,"max_selling_price":1093,"original_amo":780,"variant_price":715,"final_discount":0,"formatted_variant_price":"Tk. 715","price_line":"Tk. 787 x 1 = Tk. 787","product_name":"Casual T-shirt for Men - MEC003 - 7MEC","sale_price":"787.0","product_stamp":null,"zipcode":"7","formatted_seller_price":"Tk. 0","formatted_sale_price":"Tk. 787","size":"M","line_item_adjustments":[],"master_product_id":72580,"messages":[],"min_selling_price":787,"category":"Men t-shirt","permalink":"casual-t-shirt-for-men-mec003-7mec-1f2e8e82","cod_message":"COD is not available."},{"formatted_price":"Tk. 787","seller":"7MEC","min_order_qty":1,"line_item_id":297862,"discount":2,"prepaid_availability":true,"seller_slug":"7MEC","delivery_time":"COD is not available.","title":"Casual T-shirt for Men - MEC012 - 7MEC","liked":false,"category_id":1117,"variant_options":[{"count_on_hand":1,"option_value_name":"M-option","size":25,"corrected_count_on_hand":1,"name":"M-option","id":102854},{"count_on_hand":2,"option_value_name":"L-option","size":25,"corrected_count_on_hand":2,"name":"L-option","id":102879},{"count_on_hand":1,"option_value_name":"XL-option","size":25,"corrected_count_on_hand":1,"name":"XL-option","id":102885},{"count_on_hand":2,"option_value_name":"XXL-option","size":25,"corrected_count_on_hand":2,"name":"XXL-option","id":102890},{"count_on_hand":2,"option_value_name":"XXXL-option","size":25,"corrected_count_on_hand":2,"name":"XXXL-option","id":102895}],"max_item_quantity":50,"price":"787.0","product_id":79793,"sold_out":false,"variant":102879,"formatted_income":"Tk. 72","mrp_price_line":"Tk. 800 x 1 = Tk. 800","cod_availability":false,"formatted_per_item_total":"Tk. 787","per_item_total":787,"sku":"343984","delivery_time_message":{"message":"COD is not available.","type":0},"prepaid_message":"Dispatched in - working days.","activity_object":{"activity_object":{"id":"P79793"}},"image":"https://shopimages.vstores.io/81897/1580542180270-polo-t-shirt-for-men---mec012---7mec-small.jpeg?1580897425","quantity":1,"max_selling_price":1093,"original_amo":800,"variant_price":715,"final_discount":2,"formatted_variant_price":"Tk. 715","price_line":"Tk. 787 x 1 = Tk. 787","product_name":"Casual T-shirt for Men - MEC012 - 7MEC","sale_price":"787.0","product_stamp":null,"zipcode":"7","formatted_seller_price":"Tk. 0","formatted_sale_price":"Tk. 787","size":"L-option","line_item_adjustments":[],"master_product_id":79793,"messages":[],"min_selling_price":787,"category":"Men t-shirt","permalink":"casual-t-shirt-for-men-mec012-7mec-25c68795","cod_message":"COD is not available."},{"formatted_price":"Tk. 787","seller":"7MEC","min_order_qty":1,"line_item_id":297816,"discount":0,"prepaid_availability":true,"seller_slug":"7MEC","delivery_time":"COD is not available.","title":"Casual T-shirt for Men - MEC003 - 7MEC","liked":false,"category_id":1117,"variant_options":[{"count_on_hand":2,"option_value_name":"M","size":25,"corrected_count_on_hand":2,"name":"M","id":94134},{"count_on_hand":2,"option_value_name":"L","size":25,"corrected_count_on_hand":2,"name":"L","id":94135},{"count_on_hand":2,"option_value_name":"XL","size":25,"corrected_count_on_hand":2,"name":"XL","id":94136},{"count_on_hand":1,"option_value_name":"XXL","size":25,"corrected_count_on_hand":1,"name":"XXL","id":94137},{"count_on_hand":2,"option_value_name":"XXXL","size":25,"corrected_count_on_hand":2,"name":"XXXL","id":94138}],"max_item_quantity":50,"price":"787.0","product_id":72580,"sold_out":false,"variant":94136,"formatted_income":"Tk. 72","mrp_price_line":"Tk. 780 x 1 = Tk. 780","cod_availability":false,"formatted_per_item_total":"Tk. 787","per_item_total":787,"sku":"339475","delivery_time_message":{"message":"COD is not available.","type":0},"prepaid_message":"Dispatched in - working days.","activity_object":{"activity_object":{"id":"P72580"}},"image":"https://shopimages.vstores.io/49527/Polo-T-shirt-for-Men---MEC003---7MEC-small.jpeg?1580468596","quantity":1,"max_selling_price":1093,"original_amo":780,"variant_price":715,"final_discount":0,"formatted_variant_price":"Tk. 715","price_line":"Tk. 787 x 1 = Tk. 787","product_name":"Casual T-shirt for Men - MEC003 - 7MEC","sale_price":"787.0","product_stamp":null,"zipcode":"7","formatted_seller_price":"Tk. 0","formatted_sale_price":"Tk. 787","size":"XL","line_item_adjustments":[],"master_product_id":72580,"messages":[],"min_selling_price":787,"category":"Men t-shirt","permalink":"casual-t-shirt-for-men-mec003-7mec-1f2e8e82","cod_message":"COD is not available."},{"formatted_price":"Tk. 423","seller":"UPF","min_order_qty":1,"line_item_id":297861,"discount":0,"prepaid_availability":true,"seller_slug":"upf","delivery_time":"Delivery in 4-6 working days.","title":"Casual Shirt For Men Olive - UPF","liked":false,"category_id":1118,"variant_options":[{"count_on_hand":19,"option_value_name":"M","size":25,"corrected_count_on_hand":3,"name":"M","id":93380},{"count_on_hand":14,"option_value_name":"L","size":25,"corrected_count_on_hand":3,"name":"L","id":93381},{"count_on_hand":29,"option_value_name":"XL","size":25,"corrected_count_on_hand":3,"name":"XL","id":93382}],"max_item_quantity":50,"price":"423.0","product_id":71943,"sold_out":false,"variant":93380,"formatted_income":"Tk. 68","mrp_price_line":"Tk. 384 x 1 = Tk. 384","cod_availability":true,"formatted_per_item_total":"Tk. 423","per_item_total":423,"sku":"264086","delivery_time_message":{"message":"Delivery in 4-6 working days.","type":2},"prepaid_message":"Delivery in 4-6 working days.","activity_object":{"activity_object":{"id":"P71943"}},"image":"https://shopimages.vstores.io/75917/1569929603861-32-small.jpg?1580465725","quantity":1,"max_selling_price":667,"original_amo":384,"variant_price":355,"final_discount":0,"formatted_variant_price":"Tk. 355","price_line":"Tk. 423 x 1 = Tk. 423","product_name":"Casual Shirt For Men Olive - UPF","sale_price":"423.0","product_stamp":null,"zipcode":"7","formatted_seller_price":"Tk. 0","formatted_sale_price":"Tk. 423","size":"M","line_item_adjustments":[],"master_product_id":71943,"messages":[],"min_selling_price":423,"category":"Men shirt","permalink":"casual-shirt-for-men-olive-upf-9fad7110","cod_message":"Delivery in 4-6 working days."},{"formatted_price":"Tk. 340","seller":"UPF","min_order_qty":1,"line_item_id":297860,"discount":1,"prepaid_availability":true,"seller_slug":"upf","delivery_time":"Delivery in 4-6 working days.","title":"Navy Blue Sleeve Casual Shirt for Men - UPF","liked":false,"category_id":1118,"variant_options":[{"count_on_hand":27,"option_value_name":"M","size":25,"corrected_count_on_hand":3,"name":"M","id":82512},{"count_on_hand":22,"option_value_name":"L","size":25,"corrected_count_on_hand":3,"name":"L","id":82513},{"count_on_hand":30,"option_value_name":"XL","size":25,"corrected_count_on_hand":3,"name":"XL","id":82514}],"max_item_quantity":50,"price":"340.0","product_id":65251,"sold_out":false,"variant":82512,"formatted_income":"Tk. 50","mrp_price_line":"Tk. 345 x 1 = Tk. 345","cod_availability":true,"formatted_per_item_total":"Tk. 340","per_item_total":340,"sku":"264038","delivery_time_message":{"message":"Delivery in 4-6 working days.","type":2},"prepaid_message":"Delivery in 4-6 working days.","activity_object":{"activity_object":{"id":"P65251"}},"image":"https://shopimages.vstores.io/15256/1569927970391-19-small.jpg?1580192775","quantity":1,"max_selling_price":530,"original_amo":345,"variant_price":290,"final_discount":1,"formatted_variant_price":"Tk. 290","price_line":"Tk. 340 x 1 = Tk. 340","product_name":"Navy Blue Sleeve Casual Shirt for Men - UPF","sale_price":"340.0","product_stamp":null,"zipcode":"7","formatted_seller_price":"Tk. 0","formatted_sale_price":"Tk. 340","size":"M","line_item_adjustments":[],"master_product_id":65251,"messages":[],"min_selling_price":340,"category":"Men shirt","permalink":"navy-blue-sleeve-casual-shirt-for-men-upf-290decb7","cod_message":"Delivery in 4-6 working days."},{"formatted_price":"Tk. 2,408","seller":"RKT","min_order_qty":1,"line_item_id":297819,"discount":11,"prepaid_availability":true,"seller_slug":"rkt","delivery_time":"Delivery in 4-6 working days.","title":"Indian Julahaa Katan Saree - 12 - RKT","liked":false,"category_id":48,"variant_options":[{"count_on_hand":1,"option_value_name":"option","size":25,"corrected_count_on_hand":1,"name":"option","id":29584}],"max_item_quantity":50,"price":"2408.0","product_id":24709,"sold_out":false,"variant":29584,"formatted_income":"Tk. 158","mrp_price_line":"Tk. 2,720 x 1 = Tk. 2,720","cod_availability":true,"formatted_per_item_total":"Tk. 2,408","per_item_total":2408,"sku":"308465","delivery_time_message":{"message":"Delivery in 4-6 working days.","type":2},"prepaid_message":"Delivery in 4-6 working days.","activity_object":{"activity_object":{"id":"P24709"}},"image":"https://shopimages.vstores.io/90742/1577091355687-whatsappimage2019-12-15at00.00.271-small.jpeg?1580126997","quantity":1,"max_selling_price":2992,"original_amo":2720,"variant_price":2250,"final_discount":11,"formatted_variant_price":"Tk. 2,250","price_line":"Tk. 2,408 x 1 = Tk. 2,408","product_name":"Indian Julahaa Katan Saree - 12 - RKT","sale_price":"2408.0","product_stamp":null,"zipcode":"7","formatted_seller_price":"Tk. 0","formatted_sale_price":"Tk. 2,408","size":"option","line_item_adjustments":[],"master_product_id":24709,"messages":[{"message":"Last chance only 1 left!","type":1}],"min_selling_price":2408,"category":"Saree","permalink":"indian-julahaa-katan-saree-12-rkt-a2eeac01","cod_message":"Delivery in 4-6 working days."},{"formatted_price":"Tk. 825","seller":"SGM","min_order_qty":1,"line_item_id":297818,"discount":8,"prepaid_availability":true,"seller_slug":"sgm","delivery_time":"Delivery in 4-6 working days.","title":"Indian Chundri Silk Saree - 102 - SGM","liked":false,"category_id":48,"variant_options":[{"count_on_hand":5,"option_value_name":"option","size":25,"corrected_count_on_hand":3,"name":"option","id":55190}],"max_item_quantity":50,"price":"825.0","product_id":46543,"sold_out":false,"variant":55190,"formatted_income":"Tk. 75","mrp_price_line":"Tk. 900 x 1 = Tk. 900","cod_availability":true,"formatted_per_item_total":"Tk. 825","per_item_total":825,"sku":"286699","delivery_time_message":{"message":"Delivery in 4-6 working days.","type":2},"prepaid_message":"Delivery in 4-6 working days.","activity_object":{"activity_object":{"id":"P46543"}},"image":"https://shopimages.vstores.io/34564/1573991787793-102-small.jpg?1580160568","quantity":1,"max_selling_price":1147,"original_amo":900,"variant_price":750,"final_discount":8,"formatted_variant_price":"Tk. 750","price_line":"Tk. 825 x 1 = Tk. 825","product_name":"Indian Chundri Silk Saree - 102 - SGM","sale_price":"825.0","product_stamp":null,"zipcode":"7","formatted_seller_price":"Tk. 0","formatted_sale_price":"Tk. 825","size":"option","line_item_adjustments":[],"master_product_id":46543,"messages":[],"min_selling_price":825,"category":"Saree","permalink":"indian-chundri-silk-saree-102-sgm-18d1bc4e","cod_message":"Delivery in 4-6 working days."},{"formatted_price":"Tk. 351","seller":"DVS","min_order_qty":1,"line_item_id":297817,"discount":0,"prepaid_availability":true,"seller_slug":"dvs","delivery_time":"Delivery in 4-6 working days.","title":"Men's Premium Full Sleeve - DS2012 - DVS","liked":false,"category_id":1118,"variant_options":[{"count_on_hand":7,"option_value_name":"15 or M","size":25,"corrected_count_on_hand":3,"name":"15 or M","id":88533},{"count_on_hand":7,"option_value_name":"15.5 or L","size":25,"corrected_count_on_hand":3,"name":"15.5 or L","id":88534},{"count_on_hand":13,"option_value_name":"16 or XL","size":25,"corrected_count_on_hand":3,"name":"16 or XL","id":88536}],"max_item_quantity":50,"price":"351.0","product_id":68576,"sold_out":false,"variant":88533,"formatted_income":"Tk. 153","mrp_price_line":"Tk. 360 x 3 = Tk. 1,080","cod_availability":true,"formatted_per_item_total":"Tk. 1,053","per_item_total":1053,"sku":"268387","delivery_time_message":{"message":"Delivery in 4-6 working days.","type":2},"prepaid_message":"Delivery in 4-6 working days.","activity_object":{"activity_object":{"id":"P68576"}},"image":"https://shopimages.vstores.io/67586/1573394963295-19-small.jpg?1580195558","quantity":3,"max_selling_price":549,"original_amo":360,"variant_price":300,"final_discount":0,"formatted_variant_price":"Tk. 300","price_line":"Tk. 351 x 3 = Tk. 1,053","product_name":"Men\\'s Premium Full Sleeve - DS2012 - DVS","sale_price":"1053.0","product_stamp":null,"zipcode":"7","formatted_seller_price":"Tk. 0","formatted_sale_price":"Tk. 1,053","size":"15 or M","line_item_adjustments":[],"master_product_id":68576,"messages":[],"min_selling_price":351,"category":"Men shirt","permalink":"men-s-premium-full-sleeve-ds2012-dvs-4e2825ff","cod_message":"Delivery in 4-6 working days."},{"formatted_price":"Tk. 300","seller":"WHA","min_order_qty":1,"line_item_id":297807,"discount":25,"prepaid_availability":true,"seller_slug":"wha","delivery_time":"Delivery in 4-6 working days.","title":"Fashionable Full Sleeve Check Shirt - WHA-CHECK 19 - WHA","liked":false,"category_id":1118,"variant_options":[{"count_on_hand":1,"option_value_name":"S","size":25,"corrected_count_on_hand":1,"name":"S","id":83723}],"max_item_quantity":50,"price":"300.0","product_id":65947,"sold_out":false,"variant":83723,"formatted_income":"Tk. 49","mrp_price_line":"Tk. 399 x 1 = Tk. 399","cod_availability":true,"formatted_per_item_total":"Tk. 300","per_item_total":300,"sku":"264914","delivery_time_message":{"message":"Delivery in 4-6 working days.","type":2},"prepaid_message":"Delivery in 4-6 working days.","activity_object":{"activity_object":{"id":"P65947"}},"image":"https://shopimages.vstores.io/74956/1570083577069-wha-check019-small.jpg?1580193382","quantity":1,"max_selling_price":459,"original_amo":399,"variant_price":251,"final_discount":25,"formatted_variant_price":"Tk. 251","price_line":"Tk. 300 x 1 = Tk. 300","product_name":"Fashionable Full Sleeve Check Shirt - WHA-CHECK 19 - WHA","sale_price":"300.0","product_stamp":null,"zipcode":"7","formatted_seller_price":"Tk. 0","formatted_sale_price":"Tk. 300","size":"S","line_item_adjustments":[],"master_product_id":65947,"messages":[{"message":"Last chance only 1 left!","type":1}],"min_selling_price":294,"category":"Men shirt","permalink":"fashionable-full-sleeve-check-shirt-wha-check-19-wha-7acb9322","cod_message":"Delivery in 4-6 working days."},{"formatted_price":"Tk. 500","seller":"TMW","min_order_qty":1,"line_item_id":297727,"discount":0,"prepaid_availability":true,"seller_slug":"tmw","delivery_time":"Delivery in 4-6 working days.","title":"Full Sleeve Casual Shirt for Men 02 - Ash - TMW","liked":false,"category_id":1118,"variant_options":[{"count_on_hand":6,"option_value_name":"M","size":25,"corrected_count_on_hand":3,"name":"M","id":29245},{"count_on_hand":8,"option_value_name":"L","size":25,"corrected_count_on_hand":3,"name":"L","id":29247},{"count_on_hand":7,"option_value_name":"XL","size":25,"corrected_count_on_hand":3,"name":"XL","id":29248}],"max_item_quantity":50,"price":"500.0","product_id":24424,"sold_out":false,"variant":29245,"formatted_income":"Tk. 210","mrp_price_line":"Tk. 395 x 2 = Tk. 790","cod_availability":true,"formatted_per_item_total":"Tk. 1,000","per_item_total":1000,"sku":"305933","delivery_time_message":{"message":"Delivery in 4-6 working days.","type":2},"prepaid_message":"Delivery in 4-6 working days.","activity_object":{"activity_object":{"id":"P24424"}},"image":"https://shopimages.vstores.io/42442/1576574650899-whatsappimage2019-12-14at5.26.18pm1-small.jpeg?1580126772","quantity":2,"max_selling_price":742,"original_amo":395,"variant_price":395,"final_discount":0,"formatted_variant_price":"Tk. 395","price_line":"Tk. 500 x 2 = Tk. 1,000","product_name":"Full Sleeve Casual Shirt for Men 02 - Ash - TMW","sale_price":"1000.0","product_stamp":null,"zipcode":"7","formatted_seller_price":"Tk. 0","formatted_sale_price":"Tk. 1,000","size":"M","line_item_adjustments":[],"master_product_id":24424,"messages":[],"min_selling_price":471,"category":"Men shirt","permalink":"full-sleeve-casual-shirt-for-men-02-ash-tmw-fa8be538","cod_message":"Delivery in 4-6 working days."}]
     * enable_mandatory_sign_in : {"web":true,"wap":true}
     * country_list : [{"code":"IN","flag":"https://images1.voonik.com/assets/flags/india.svg","currency_unicode":"Tk. ","updated_at":"2018-01-22T15:30:20.000+05:30","extra_data":"","name":"INDIA","created_at":null,"currency":"Tk.","id":1,"conversion_rate":1,"currency_code":"BDT","status":"active"},{"code":"LK","flag":"https://images1.voonik.com/assets/flags/sri-lanka.svg","currency_unicode":"Rs ","updated_at":"2018-06-01T15:33:51.000+05:30","extra_data":"","name":"SRILANKA","created_at":"2017-12-27T14:56:03.000+05:30","currency":"","id":4,"conversion_rate":0.85,"currency_code":"INR","status":"active"}]
     * total_save : 355
     * vcash_data : {"available_vcash":0,"show_vcash_form":true,"vcash_already_applied_in_order":0,"approved_vcash":0}
     * prepaid_retry_message : Your payment for this order has failed. Please try making the payment again. Note: If you think that you have already made a successful payment, you can wait for 30 minutes till we check and confirm your payment. You can check the status of your order and payment in 'My Orders' page.
     * retry_message_for_close_popup : Seems like your payment is pending/failed. You can retry paying by below options or alternatively you can go to My Orders page and complete the payment in next 24 hours to avoid the cancellation. Note: If you think that you have already made a successful payment, you can wait for 30 minutes till we check and confirm your payment. You can check the status of your order and payment in 'My Orders' page.
     * grand_total_currency : INR
     * order_data : {"error_message":3,"adjustments":[{"amount":49,"is_seller_coupon":false,"is_vcash":false,"label":"Shipping Charges"}],"new_user_check_for_nps":false,"order_number":"R0162378311","count":10,"cart_items_total":"8710.0","pickup_address":null,"prepaid_availability":true,"remaining_vcash":0,"item_total":8710,"vcash_data":{"available_vcash":0,"show_vcash_form":true,"vcash_already_applied_in_order":0,"approved_vcash":0},"total":8759,"total_income":979,"coupon_applied_message":"The coupon code is applied","subtotal":8710,"last_completed_order":null,"messages":[],"lastmile_addresses":[],"cod_availability":true,"formatted_total_income":"Tk. 979","payment_method":"cod","code_applied":false,"li_by_sellers":{"DVS":{"adjustments":[],"subtotal":1053,"item_total":1053,"items":[{"formatted_price":"Tk. 351","seller":"DVS","min_order_qty":1,"line_item_id":297817,"discount":0,"prepaid_availability":true,"seller_slug":"dvs","delivery_time":"Delivery in 4-6 working days.","title":"Men's Premium Full Sleeve - DS2012 - DVS","liked":false,"category_id":1118,"variant_options":[{"count_on_hand":7,"option_value_name":"15 or M","size":25,"corrected_count_on_hand":3,"name":"15 or M","id":88533},{"count_on_hand":7,"option_value_name":"15.5 or L","size":25,"corrected_count_on_hand":3,"name":"15.5 or L","id":88534},{"count_on_hand":13,"option_value_name":"16 or XL","size":25,"corrected_count_on_hand":3,"name":"16 or XL","id":88536}],"max_item_quantity":50,"price":"351.0","product_id":68576,"sold_out":false,"variant":88533,"formatted_income":"Tk. 153","mrp_price_line":"Tk. 360 x 3 = Tk. 1,080","cod_availability":true,"formatted_per_item_total":"Tk. 1,053","per_item_total":1053,"sku":"268387","delivery_time_message":{"message":"Delivery in 4-6 working days.","type":2},"prepaid_message":"Delivery in 4-6 working days.","activity_object":{"activity_object":{"id":"P68576"}},"image":"https://shopimages.vstores.io/67586/1573394963295-19-small.jpg?1580195558","quantity":3,"max_selling_price":549,"original_amo":360,"variant_price":300,"final_discount":0,"formatted_variant_price":"Tk. 300","price_line":"Tk. 351 x 3 = Tk. 1,053","product_name":"Men\\'s Premium Full Sleeve - DS2012 - DVS","sale_price":"1053.0","product_stamp":null,"zipcode":"7","formatted_seller_price":"Tk. 0","formatted_sale_price":"Tk. 1,053","size":"15 or M","line_item_adjustments":[],"master_product_id":68576,"messages":[],"min_selling_price":351,"category":"Men shirt","permalink":"men-s-premium-full-sleeve-ds2012-dvs-4e2825ff","cod_message":"Delivery in 4-6 working days."}]},"WHA":{"adjustments":[],"subtotal":300,"item_total":300,"items":[{"formatted_price":"Tk. 300","seller":"WHA","min_order_qty":1,"line_item_id":297807,"discount":25,"prepaid_availability":true,"seller_slug":"wha","delivery_time":"Delivery in 4-6 working days.","title":"Fashionable Full Sleeve Check Shirt - WHA-CHECK 19 - WHA","liked":false,"category_id":1118,"variant_options":[{"count_on_hand":1,"option_value_name":"S","size":25,"corrected_count_on_hand":1,"name":"S","id":83723}],"max_item_quantity":50,"price":"300.0","product_id":65947,"sold_out":false,"variant":83723,"formatted_income":"Tk. 49","mrp_price_line":"Tk. 399 x 1 = Tk. 399","cod_availability":true,"formatted_per_item_total":"Tk. 300","per_item_total":300,"sku":"264914","delivery_time_message":{"message":"Delivery in 4-6 working days.","type":2},"prepaid_message":"Delivery in 4-6 working days.","activity_object":{"activity_object":{"id":"P65947"}},"image":"https://shopimages.vstores.io/74956/1570083577069-wha-check019-small.jpg?1580193382","quantity":1,"max_selling_price":459,"original_amo":399,"variant_price":251,"final_discount":25,"formatted_variant_price":"Tk. 251","price_line":"Tk. 300 x 1 = Tk. 300","product_name":"Fashionable Full Sleeve Check Shirt - WHA-CHECK 19 - WHA","sale_price":"300.0","product_stamp":null,"zipcode":"7","formatted_seller_price":"Tk. 0","formatted_sale_price":"Tk. 300","size":"S","line_item_adjustments":[],"master_product_id":65947,"messages":[{"message":"Last chance only 1 left!","type":1}],"min_selling_price":294,"category":"Men shirt","permalink":"fashionable-full-sleeve-check-shirt-wha-check-19-wha-7acb9322","cod_message":"Delivery in 4-6 working days."}]},"SGM":{"adjustments":[],"subtotal":825,"item_total":825,"items":[{"formatted_price":"Tk. 825","seller":"SGM","min_order_qty":1,"line_item_id":297818,"discount":8,"prepaid_availability":true,"seller_slug":"sgm","delivery_time":"Delivery in 4-6 working days.","title":"Indian Chundri Silk Saree - 102 - SGM","liked":false,"category_id":48,"variant_options":[{"count_on_hand":5,"option_value_name":"option","size":25,"corrected_count_on_hand":3,"name":"option","id":55190}],"max_item_quantity":50,"price":"825.0","product_id":46543,"sold_out":false,"variant":55190,"formatted_income":"Tk. 75","mrp_price_line":"Tk. 900 x 1 = Tk. 900","cod_availability":true,"formatted_per_item_total":"Tk. 825","per_item_total":825,"sku":"286699","delivery_time_message":{"message":"Delivery in 4-6 working days.","type":2},"prepaid_message":"Delivery in 4-6 working days.","activity_object":{"activity_object":{"id":"P46543"}},"image":"https://shopimages.vstores.io/34564/1573991787793-102-small.jpg?1580160568","quantity":1,"max_selling_price":1147,"original_amo":900,"variant_price":750,"final_discount":8,"formatted_variant_price":"Tk. 750","price_line":"Tk. 825 x 1 = Tk. 825","product_name":"Indian Chundri Silk Saree - 102 - SGM","sale_price":"825.0","product_stamp":null,"zipcode":"7","formatted_seller_price":"Tk. 0","formatted_sale_price":"Tk. 825","size":"option","line_item_adjustments":[],"master_product_id":46543,"messages":[],"min_selling_price":825,"category":"Saree","permalink":"indian-chundri-silk-saree-102-sgm-18d1bc4e","cod_message":"Delivery in 4-6 working days."}]},"RKT":{"adjustments":[],"subtotal":2408,"item_total":2408,"items":[{"formatted_price":"Tk. 2,408","seller":"RKT","min_order_qty":1,"line_item_id":297819,"discount":11,"prepaid_availability":true,"seller_slug":"rkt","delivery_time":"Delivery in 4-6 working days.","title":"Indian Julahaa Katan Saree - 12 - RKT","liked":false,"category_id":48,"variant_options":[{"count_on_hand":1,"option_value_name":"option","size":25,"corrected_count_on_hand":1,"name":"option","id":29584}],"max_item_quantity":50,"price":"2408.0","product_id":24709,"sold_out":false,"variant":29584,"formatted_income":"Tk. 158","mrp_price_line":"Tk. 2,720 x 1 = Tk. 2,720","cod_availability":true,"formatted_per_item_total":"Tk. 2,408","per_item_total":2408,"sku":"308465","delivery_time_message":{"message":"Delivery in 4-6 working days.","type":2},"prepaid_message":"Delivery in 4-6 working days.","activity_object":{"activity_object":{"id":"P24709"}},"image":"https://shopimages.vstores.io/90742/1577091355687-whatsappimage2019-12-15at00.00.271-small.jpeg?1580126997","quantity":1,"max_selling_price":2992,"original_amo":2720,"variant_price":2250,"final_discount":11,"formatted_variant_price":"Tk. 2,250","price_line":"Tk. 2,408 x 1 = Tk. 2,408","product_name":"Indian Julahaa Katan Saree - 12 - RKT","sale_price":"2408.0","product_stamp":null,"zipcode":"7","formatted_seller_price":"Tk. 0","formatted_sale_price":"Tk. 2,408","size":"option","line_item_adjustments":[],"master_product_id":24709,"messages":[{"message":"Last chance only 1 left!","type":1}],"min_selling_price":2408,"category":"Saree","permalink":"indian-julahaa-katan-saree-12-rkt-a2eeac01","cod_message":"Delivery in 4-6 working days."}]},"UPF":{"adjustments":[],"subtotal":763,"item_total":763,"items":[{"formatted_price":"Tk. 423","seller":"UPF","min_order_qty":1,"line_item_id":297861,"discount":0,"prepaid_availability":true,"seller_slug":"upf","delivery_time":"Delivery in 4-6 working days.","title":"Casual Shirt For Men Olive - UPF","liked":false,"category_id":1118,"variant_options":[{"count_on_hand":19,"option_value_name":"M","size":25,"corrected_count_on_hand":3,"name":"M","id":93380},{"count_on_hand":14,"option_value_name":"L","size":25,"corrected_count_on_hand":3,"name":"L","id":93381},{"count_on_hand":29,"option_value_name":"XL","size":25,"corrected_count_on_hand":3,"name":"XL","id":93382}],"max_item_quantity":50,"price":"423.0","product_id":71943,"sold_out":false,"variant":93380,"formatted_income":"Tk. 68","mrp_price_line":"Tk. 384 x 1 = Tk. 384","cod_availability":true,"formatted_per_item_total":"Tk. 423","per_item_total":423,"sku":"264086","delivery_time_message":{"message":"Delivery in 4-6 working days.","type":2},"prepaid_message":"Delivery in 4-6 working days.","activity_object":{"activity_object":{"id":"P71943"}},"image":"https://shopimages.vstores.io/75917/1569929603861-32-small.jpg?1580465725","quantity":1,"max_selling_price":667,"original_amo":384,"variant_price":355,"final_discount":0,"formatted_variant_price":"Tk. 355","price_line":"Tk. 423 x 1 = Tk. 423","product_name":"Casual Shirt For Men Olive - UPF","sale_price":"423.0","product_stamp":null,"zipcode":"7","formatted_seller_price":"Tk. 0","formatted_sale_price":"Tk. 423","size":"M","line_item_adjustments":[],"master_product_id":71943,"messages":[],"min_selling_price":423,"category":"Men shirt","permalink":"casual-shirt-for-men-olive-upf-9fad7110","cod_message":"Delivery in 4-6 working days."},{"formatted_price":"Tk. 340","seller":"UPF","min_order_qty":1,"line_item_id":297860,"discount":1,"prepaid_availability":true,"seller_slug":"upf","delivery_time":"Delivery in 4-6 working days.","title":"Navy Blue Sleeve Casual Shirt for Men - UPF","liked":false,"category_id":1118,"variant_options":[{"count_on_hand":27,"option_value_name":"M","size":25,"corrected_count_on_hand":3,"name":"M","id":82512},{"count_on_hand":22,"option_value_name":"L","size":25,"corrected_count_on_hand":3,"name":"L","id":82513},{"count_on_hand":30,"option_value_name":"XL","size":25,"corrected_count_on_hand":3,"name":"XL","id":82514}],"max_item_quantity":50,"price":"340.0","product_id":65251,"sold_out":false,"variant":82512,"formatted_income":"Tk. 50","mrp_price_line":"Tk. 345 x 1 = Tk. 345","cod_availability":true,"formatted_per_item_total":"Tk. 340","per_item_total":340,"sku":"264038","delivery_time_message":{"message":"Delivery in 4-6 working days.","type":2},"prepaid_message":"Delivery in 4-6 working days.","activity_object":{"activity_object":{"id":"P65251"}},"image":"https://shopimages.vstores.io/15256/1569927970391-19-small.jpg?1580192775","quantity":1,"max_selling_price":530,"original_amo":345,"variant_price":290,"final_discount":1,"formatted_variant_price":"Tk. 290","price_line":"Tk. 340 x 1 = Tk. 340","product_name":"Navy Blue Sleeve Casual Shirt for Men - UPF","sale_price":"340.0","product_stamp":null,"zipcode":"7","formatted_seller_price":"Tk. 0","formatted_sale_price":"Tk. 340","size":"M","line_item_adjustments":[],"master_product_id":65251,"messages":[],"min_selling_price":340,"category":"Men shirt","permalink":"navy-blue-sleeve-casual-shirt-for-men-upf-290decb7","cod_message":"Delivery in 4-6 working days."}]},"7MEC":{"adjustments":[],"subtotal":2361,"item_total":2361,"items":[{"formatted_price":"Tk. 787","seller":"7MEC","min_order_qty":1,"line_item_id":297865,"discount":0,"prepaid_availability":true,"seller_slug":"7MEC","delivery_time":"COD is not available.","title":"Casual T-shirt for Men - MEC003 - 7MEC","liked":false,"category_id":1117,"variant_options":[{"count_on_hand":2,"option_value_name":"M","size":25,"corrected_count_on_hand":2,"name":"M","id":94134},{"count_on_hand":2,"option_value_name":"L","size":25,"corrected_count_on_hand":2,"name":"L","id":94135},{"count_on_hand":2,"option_value_name":"XL","size":25,"corrected_count_on_hand":2,"name":"XL","id":94136},{"count_on_hand":1,"option_value_name":"XXL","size":25,"corrected_count_on_hand":1,"name":"XXL","id":94137},{"count_on_hand":2,"option_value_name":"XXXL","size":25,"corrected_count_on_hand":2,"name":"XXXL","id":94138}],"max_item_quantity":50,"price":"787.0","product_id":72580,"sold_out":false,"variant":94134,"formatted_income":"Tk. 72","mrp_price_line":"Tk. 780 x 1 = Tk. 780","cod_availability":false,"formatted_per_item_total":"Tk. 787","per_item_total":787,"sku":"339473","delivery_time_message":{"message":"COD is not available.","type":0},"prepaid_message":"Dispatched in - working days.","activity_object":{"activity_object":{"id":"P72580"}},"image":"https://shopimages.vstores.io/49527/Polo-T-shirt-for-Men---MEC003---7MEC-small.jpeg?1580468596","quantity":1,"max_selling_price":1093,"original_amo":780,"variant_price":715,"final_discount":0,"formatted_variant_price":"Tk. 715","price_line":"Tk. 787 x 1 = Tk. 787","product_name":"Casual T-shirt for Men - MEC003 - 7MEC","sale_price":"787.0","product_stamp":null,"zipcode":"7","formatted_seller_price":"Tk. 0","formatted_sale_price":"Tk. 787","size":"M","line_item_adjustments":[],"master_product_id":72580,"messages":[],"min_selling_price":787,"category":"Men t-shirt","permalink":"casual-t-shirt-for-men-mec003-7mec-1f2e8e82","cod_message":"COD is not available."},{"formatted_price":"Tk. 787","seller":"7MEC","min_order_qty":1,"line_item_id":297862,"discount":2,"prepaid_availability":true,"seller_slug":"7MEC","delivery_time":"COD is not available.","title":"Casual T-shirt for Men - MEC012 - 7MEC","liked":false,"category_id":1117,"variant_options":[{"count_on_hand":1,"option_value_name":"M-option","size":25,"corrected_count_on_hand":1,"name":"M-option","id":102854},{"count_on_hand":2,"option_value_name":"L-option","size":25,"corrected_count_on_hand":2,"name":"L-option","id":102879},{"count_on_hand":1,"option_value_name":"XL-option","size":25,"corrected_count_on_hand":1,"name":"XL-option","id":102885},{"count_on_hand":2,"option_value_name":"XXL-option","size":25,"corrected_count_on_hand":2,"name":"XXL-option","id":102890},{"count_on_hand":2,"option_value_name":"XXXL-option","size":25,"corrected_count_on_hand":2,"name":"XXXL-option","id":102895}],"max_item_quantity":50,"price":"787.0","product_id":79793,"sold_out":false,"variant":102879,"formatted_income":"Tk. 72","mrp_price_line":"Tk. 800 x 1 = Tk. 800","cod_availability":false,"formatted_per_item_total":"Tk. 787","per_item_total":787,"sku":"343984","delivery_time_message":{"message":"COD is not available.","type":0},"prepaid_message":"Dispatched in - working days.","activity_object":{"activity_object":{"id":"P79793"}},"image":"https://shopimages.vstores.io/81897/1580542180270-polo-t-shirt-for-men---mec012---7mec-small.jpeg?1580897425","quantity":1,"max_selling_price":1093,"original_amo":800,"variant_price":715,"final_discount":2,"formatted_variant_price":"Tk. 715","price_line":"Tk. 787 x 1 = Tk. 787","product_name":"Casual T-shirt for Men - MEC012 - 7MEC","sale_price":"787.0","product_stamp":null,"zipcode":"7","formatted_seller_price":"Tk. 0","formatted_sale_price":"Tk. 787","size":"L-option","line_item_adjustments":[],"master_product_id":79793,"messages":[],"min_selling_price":787,"category":"Men t-shirt","permalink":"casual-t-shirt-for-men-mec012-7mec-25c68795","cod_message":"COD is not available."},{"formatted_price":"Tk. 787","seller":"7MEC","min_order_qty":1,"line_item_id":297816,"discount":0,"prepaid_availability":true,"seller_slug":"7MEC","delivery_time":"COD is not available.","title":"Casual T-shirt for Men - MEC003 - 7MEC","liked":false,"category_id":1117,"variant_options":[{"count_on_hand":2,"option_value_name":"M","size":25,"corrected_count_on_hand":2,"name":"M","id":94134},{"count_on_hand":2,"option_value_name":"L","size":25,"corrected_count_on_hand":2,"name":"L","id":94135},{"count_on_hand":2,"option_value_name":"XL","size":25,"corrected_count_on_hand":2,"name":"XL","id":94136},{"count_on_hand":1,"option_value_name":"XXL","size":25,"corrected_count_on_hand":1,"name":"XXL","id":94137},{"count_on_hand":2,"option_value_name":"XXXL","size":25,"corrected_count_on_hand":2,"name":"XXXL","id":94138}],"max_item_quantity":50,"price":"787.0","product_id":72580,"sold_out":false,"variant":94136,"formatted_income":"Tk. 72","mrp_price_line":"Tk. 780 x 1 = Tk. 780","cod_availability":false,"formatted_per_item_total":"Tk. 787","per_item_total":787,"sku":"339475","delivery_time_message":{"message":"COD is not available.","type":0},"prepaid_message":"Dispatched in - working days.","activity_object":{"activity_object":{"id":"P72580"}},"image":"https://shopimages.vstores.io/49527/Polo-T-shirt-for-Men---MEC003---7MEC-small.jpeg?1580468596","quantity":1,"max_selling_price":1093,"original_amo":780,"variant_price":715,"final_discount":0,"formatted_variant_price":"Tk. 715","price_line":"Tk. 787 x 1 = Tk. 787","product_name":"Casual T-shirt for Men - MEC003 - 7MEC","sale_price":"787.0","product_stamp":null,"zipcode":"7","formatted_seller_price":"Tk. 0","formatted_sale_price":"Tk. 787","size":"XL","line_item_adjustments":[],"master_product_id":72580,"messages":[],"min_selling_price":787,"category":"Men t-shirt","permalink":"casual-t-shirt-for-men-mec003-7mec-1f2e8e82","cod_message":"COD is not available."}]},"TMW":{"adjustments":[],"subtotal":1000,"item_total":1000,"items":[{"formatted_price":"Tk. 500","seller":"TMW","min_order_qty":1,"line_item_id":297727,"discount":0,"prepaid_availability":true,"seller_slug":"tmw","delivery_time":"Delivery in 4-6 working days.","title":"Full Sleeve Casual Shirt for Men 02 - Ash - TMW","liked":false,"category_id":1118,"variant_options":[{"count_on_hand":6,"option_value_name":"M","size":25,"corrected_count_on_hand":3,"name":"M","id":29245},{"count_on_hand":8,"option_value_name":"L","size":25,"corrected_count_on_hand":3,"name":"L","id":29247},{"count_on_hand":7,"option_value_name":"XL","size":25,"corrected_count_on_hand":3,"name":"XL","id":29248}],"max_item_quantity":50,"price":"500.0","product_id":24424,"sold_out":false,"variant":29245,"formatted_income":"Tk. 210","mrp_price_line":"Tk. 395 x 2 = Tk. 790","cod_availability":true,"formatted_per_item_total":"Tk. 1,000","per_item_total":1000,"sku":"305933","delivery_time_message":{"message":"Delivery in 4-6 working days.","type":2},"prepaid_message":"Delivery in 4-6 working days.","activity_object":{"activity_object":{"id":"P24424"}},"image":"https://shopimages.vstores.io/42442/1576574650899-whatsappimage2019-12-14at5.26.18pm1-small.jpeg?1580126772","quantity":2,"max_selling_price":742,"original_amo":395,"variant_price":395,"final_discount":0,"formatted_variant_price":"Tk. 395","price_line":"Tk. 500 x 2 = Tk. 1,000","product_name":"Full Sleeve Casual Shirt for Men 02 - Ash - TMW","sale_price":"1000.0","product_stamp":null,"zipcode":"7","formatted_seller_price":"Tk. 0","formatted_sale_price":"Tk. 1,000","size":"M","line_item_adjustments":[],"master_product_id":24424,"messages":[],"min_selling_price":471,"category":"Men shirt","permalink":"full-sleeve-casual-shirt-for-men-02-ash-tmw-fa8be538","cod_message":"Delivery in 4-6 working days."}]}}}
     * signed_in_user : true
     * serviceable_line_items : []
     * juspay_merchant_id : voonikapp
     */

    private EnablePrimoCartPopupBean enable_primo_cart_popup;
    private PaymentPendingOrdersBean payment_pending_orders;
    private boolean enable_remove_coupon;
    private int minimum_delivery_charge;
    private String online_payment_banner_link;
    private CurrentPaymentDetailsBean current_payment_details;
    private boolean check_duplicate_order;
    private boolean special_prepaid_method;
    private String total_currency;
    private String disable_cart_timer;
    private boolean user_email_valid;
    private String total_amount_after_discount;
    private ShipAddressBean ship_address;
    private boolean enable_online_payment_banner;
    private String payment_method;
    private boolean single_step_checkout;
    private SpecialInstructionsBean special_instructions;
    private PrepaidMessageConfigBean prepaid_message_config;
    private int final_save;
    private boolean show_pdp_link_in_address_page;
    private int grand_total_amount;
    private String total_str;
    private String prepaid_order_message;
    private boolean show_saved_cards;
    private String prepaid_preference_message;
    private int total_amount;
    private int maximum_delivery_charge;
    private PrimoCartImagesBean primo_cart_images;
    private String formatted_total_save;
    private boolean enable_prepaid_retry;
    private String order_number;
    private String formatted_final_save;
    private String total;
    private OrderAddressBean order_address;
    private String grand_total;
    private String cart_offer_message;
    private boolean coupon_code_applied;
    private boolean disable_cart_purchase;
    @SerializedName("is_gamified_order?")
    private boolean _$Is_gamified_order63; // FIXME check this code
    private EnableMandatorySignInBean enable_mandatory_sign_in;
    private int total_save;
    private VcashDataBean vcash_data;
    private String prepaid_retry_message;
    private String retry_message_for_close_popup;
    private String grand_total_currency;
    private OrderDataBean order_data;
    private boolean signed_in_user;
    private String juspay_merchant_id;
    private List<AdjustmentsBeanX> adjustments;
    private List<ShippedAddressesBean> shipped_addresses;
    private List<PaymentMethodsBean> payment_methods;
    private List<?> cod_adjustments;
    private List<?> coupon_display_messages;
    private List<NonCodAdjustmentsBean> non_cod_adjustments;
    private List<?> coupon_applied;
    private List<PaymentTypesBean> payment_types;
    private List<?> shipping_adjustments;
    private List<CartItemsBean> cart_items;
    private List<CountryListBean> country_list;
    private List<?> serviceable_line_items;

    public EnablePrimoCartPopupBean getEnable_primo_cart_popup() {
        return enable_primo_cart_popup;
    }

    public void setEnable_primo_cart_popup(EnablePrimoCartPopupBean enable_primo_cart_popup) {
        this.enable_primo_cart_popup = enable_primo_cart_popup;
    }

    public PaymentPendingOrdersBean getPayment_pending_orders() {
        return payment_pending_orders;
    }

    public void setPayment_pending_orders(PaymentPendingOrdersBean payment_pending_orders) {
        this.payment_pending_orders = payment_pending_orders;
    }

    public boolean isEnable_remove_coupon() {
        return enable_remove_coupon;
    }

    public void setEnable_remove_coupon(boolean enable_remove_coupon) {
        this.enable_remove_coupon = enable_remove_coupon;
    }

    public int getMinimum_delivery_charge() {
        return minimum_delivery_charge;
    }

    public void setMinimum_delivery_charge(int minimum_delivery_charge) {
        this.minimum_delivery_charge = minimum_delivery_charge;
    }

    public String getOnline_payment_banner_link() {
        return online_payment_banner_link;
    }

    public void setOnline_payment_banner_link(String online_payment_banner_link) {
        this.online_payment_banner_link = online_payment_banner_link;
    }

    public CurrentPaymentDetailsBean getCurrent_payment_details() {
        return current_payment_details;
    }

    public void setCurrent_payment_details(CurrentPaymentDetailsBean current_payment_details) {
        this.current_payment_details = current_payment_details;
    }

    public boolean isCheck_duplicate_order() {
        return check_duplicate_order;
    }

    public void setCheck_duplicate_order(boolean check_duplicate_order) {
        this.check_duplicate_order = check_duplicate_order;
    }

    public boolean isSpecial_prepaid_method() {
        return special_prepaid_method;
    }

    public void setSpecial_prepaid_method(boolean special_prepaid_method) {
        this.special_prepaid_method = special_prepaid_method;
    }

    public String getTotal_currency() {
        return total_currency;
    }

    public void setTotal_currency(String total_currency) {
        this.total_currency = total_currency;
    }

    public String getDisable_cart_timer() {
        return disable_cart_timer;
    }

    public void setDisable_cart_timer(String disable_cart_timer) {
        this.disable_cart_timer = disable_cart_timer;
    }

    public boolean isUser_email_valid() {
        return user_email_valid;
    }

    public void setUser_email_valid(boolean user_email_valid) {
        this.user_email_valid = user_email_valid;
    }

    public String getTotal_amount_after_discount() {
        return total_amount_after_discount;
    }

    public void setTotal_amount_after_discount(String total_amount_after_discount) {
        this.total_amount_after_discount = total_amount_after_discount;
    }

    public ShipAddressBean getShip_address() {
        return ship_address;
    }

    public void setShip_address(ShipAddressBean ship_address) {
        this.ship_address = ship_address;
    }

    public boolean isEnable_online_payment_banner() {
        return enable_online_payment_banner;
    }

    public void setEnable_online_payment_banner(boolean enable_online_payment_banner) {
        this.enable_online_payment_banner = enable_online_payment_banner;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }

    public boolean isSingle_step_checkout() {
        return single_step_checkout;
    }

    public void setSingle_step_checkout(boolean single_step_checkout) {
        this.single_step_checkout = single_step_checkout;
    }

    public SpecialInstructionsBean getSpecial_instructions() {
        return special_instructions;
    }

    public void setSpecial_instructions(SpecialInstructionsBean special_instructions) {
        this.special_instructions = special_instructions;
    }

    public PrepaidMessageConfigBean getPrepaid_message_config() {
        return prepaid_message_config;
    }

    public void setPrepaid_message_config(PrepaidMessageConfigBean prepaid_message_config) {
        this.prepaid_message_config = prepaid_message_config;
    }

    public int getFinal_save() {
        return final_save;
    }

    public void setFinal_save(int final_save) {
        this.final_save = final_save;
    }

    public boolean isShow_pdp_link_in_address_page() {
        return show_pdp_link_in_address_page;
    }

    public void setShow_pdp_link_in_address_page(boolean show_pdp_link_in_address_page) {
        this.show_pdp_link_in_address_page = show_pdp_link_in_address_page;
    }

    public int getGrand_total_amount() {
        return grand_total_amount;
    }

    public void setGrand_total_amount(int grand_total_amount) {
        this.grand_total_amount = grand_total_amount;
    }

    public String getTotal_str() {
        return total_str;
    }

    public void setTotal_str(String total_str) {
        this.total_str = total_str;
    }

    public String getPrepaid_order_message() {
        return prepaid_order_message;
    }

    public void setPrepaid_order_message(String prepaid_order_message) {
        this.prepaid_order_message = prepaid_order_message;
    }

    public boolean isShow_saved_cards() {
        return show_saved_cards;
    }

    public void setShow_saved_cards(boolean show_saved_cards) {
        this.show_saved_cards = show_saved_cards;
    }

    public String getPrepaid_preference_message() {
        return prepaid_preference_message;
    }

    public void setPrepaid_preference_message(String prepaid_preference_message) {
        this.prepaid_preference_message = prepaid_preference_message;
    }

    public int getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(int total_amount) {
        this.total_amount = total_amount;
    }

    public int getMaximum_delivery_charge() {
        return maximum_delivery_charge;
    }

    public void setMaximum_delivery_charge(int maximum_delivery_charge) {
        this.maximum_delivery_charge = maximum_delivery_charge;
    }

    public PrimoCartImagesBean getPrimo_cart_images() {
        return primo_cart_images;
    }

    public void setPrimo_cart_images(PrimoCartImagesBean primo_cart_images) {
        this.primo_cart_images = primo_cart_images;
    }

    public String getFormatted_total_save() {
        return formatted_total_save;
    }

    public void setFormatted_total_save(String formatted_total_save) {
        this.formatted_total_save = formatted_total_save;
    }

    public boolean isEnable_prepaid_retry() {
        return enable_prepaid_retry;
    }

    public void setEnable_prepaid_retry(boolean enable_prepaid_retry) {
        this.enable_prepaid_retry = enable_prepaid_retry;
    }

    public String getOrder_number() {
        return order_number;
    }

    public void setOrder_number(String order_number) {
        this.order_number = order_number;
    }

    public String getFormatted_final_save() {
        return formatted_final_save;
    }

    public void setFormatted_final_save(String formatted_final_save) {
        this.formatted_final_save = formatted_final_save;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public OrderAddressBean getOrder_address() {
        return order_address;
    }

    public void setOrder_address(OrderAddressBean order_address) {
        this.order_address = order_address;
    }

    public String getGrand_total() {
        return grand_total;
    }

    public void setGrand_total(String grand_total) {
        this.grand_total = grand_total;
    }

    public String getCart_offer_message() {
        return cart_offer_message;
    }

    public void setCart_offer_message(String cart_offer_message) {
        this.cart_offer_message = cart_offer_message;
    }

    public boolean isCoupon_code_applied() {
        return coupon_code_applied;
    }

    public void setCoupon_code_applied(boolean coupon_code_applied) {
        this.coupon_code_applied = coupon_code_applied;
    }

    public boolean isDisable_cart_purchase() {
        return disable_cart_purchase;
    }

    public void setDisable_cart_purchase(boolean disable_cart_purchase) {
        this.disable_cart_purchase = disable_cart_purchase;
    }

    public boolean is_$Is_gamified_order63() {
        return _$Is_gamified_order63;
    }

    public void set_$Is_gamified_order63(boolean _$Is_gamified_order63) {
        this._$Is_gamified_order63 = _$Is_gamified_order63;
    }

    public EnableMandatorySignInBean getEnable_mandatory_sign_in() {
        return enable_mandatory_sign_in;
    }

    public void setEnable_mandatory_sign_in(EnableMandatorySignInBean enable_mandatory_sign_in) {
        this.enable_mandatory_sign_in = enable_mandatory_sign_in;
    }

    public int getTotal_save() {
        return total_save;
    }

    public void setTotal_save(int total_save) {
        this.total_save = total_save;
    }

    public VcashDataBean getVcash_data() {
        return vcash_data;
    }

    public void setVcash_data(VcashDataBean vcash_data) {
        this.vcash_data = vcash_data;
    }

    public String getPrepaid_retry_message() {
        return prepaid_retry_message;
    }

    public void setPrepaid_retry_message(String prepaid_retry_message) {
        this.prepaid_retry_message = prepaid_retry_message;
    }

    public String getRetry_message_for_close_popup() {
        return retry_message_for_close_popup;
    }

    public void setRetry_message_for_close_popup(String retry_message_for_close_popup) {
        this.retry_message_for_close_popup = retry_message_for_close_popup;
    }

    public String getGrand_total_currency() {
        return grand_total_currency;
    }

    public void setGrand_total_currency(String grand_total_currency) {
        this.grand_total_currency = grand_total_currency;
    }

    public OrderDataBean getOrder_data() {
        return order_data;
    }

    public void setOrder_data(OrderDataBean order_data) {
        this.order_data = order_data;
    }

    public boolean isSigned_in_user() {
        return signed_in_user;
    }

    public void setSigned_in_user(boolean signed_in_user) {
        this.signed_in_user = signed_in_user;
    }

    public String getJuspay_merchant_id() {
        return juspay_merchant_id;
    }

    public void setJuspay_merchant_id(String juspay_merchant_id) {
        this.juspay_merchant_id = juspay_merchant_id;
    }

    public List<AdjustmentsBeanX> getAdjustments() {
        return adjustments;
    }

    public void setAdjustments(List<AdjustmentsBeanX> adjustments) {
        this.adjustments = adjustments;
    }

    public List<ShippedAddressesBean> getShipped_addresses() {
        return shipped_addresses;
    }

    public void setShipped_addresses(List<ShippedAddressesBean> shipped_addresses) {
        this.shipped_addresses = shipped_addresses;
    }

    public List<PaymentMethodsBean> getPayment_methods() {
        return payment_methods;
    }

    public void setPayment_methods(List<PaymentMethodsBean> payment_methods) {
        this.payment_methods = payment_methods;
    }

    public List<?> getCod_adjustments() {
        return cod_adjustments;
    }

    public void setCod_adjustments(List<?> cod_adjustments) {
        this.cod_adjustments = cod_adjustments;
    }

    public List<?> getCoupon_display_messages() {
        return coupon_display_messages;
    }

    public void setCoupon_display_messages(List<?> coupon_display_messages) {
        this.coupon_display_messages = coupon_display_messages;
    }

    public List<NonCodAdjustmentsBean> getNon_cod_adjustments() {
        return non_cod_adjustments;
    }

    public void setNon_cod_adjustments(List<NonCodAdjustmentsBean> non_cod_adjustments) {
        this.non_cod_adjustments = non_cod_adjustments;
    }

    public List<?> getCoupon_applied() {
        return coupon_applied;
    }

    public void setCoupon_applied(List<?> coupon_applied) {
        this.coupon_applied = coupon_applied;
    }

    public List<PaymentTypesBean> getPayment_types() {
        return payment_types;
    }

    public void setPayment_types(List<PaymentTypesBean> payment_types) {
        this.payment_types = payment_types;
    }

    public List<?> getShipping_adjustments() {
        return shipping_adjustments;
    }

    public void setShipping_adjustments(List<?> shipping_adjustments) {
        this.shipping_adjustments = shipping_adjustments;
    }

    public List<CartItemsBean> getCart_items() {
        return cart_items;
    }

    public void setCart_items(List<CartItemsBean> cart_items) {
        this.cart_items = cart_items;
    }

    public List<CountryListBean> getCountry_list() {
        return country_list;
    }

    public void setCountry_list(List<CountryListBean> country_list) {
        this.country_list = country_list;
    }

    public List<?> getServiceable_line_items() {
        return serviceable_line_items;
    }

    public void setServiceable_line_items(List<?> serviceable_line_items) {
        this.serviceable_line_items = serviceable_line_items;
    }

    public static class EnablePrimoCartPopupBean {
        /**
         * primo_amount : 149
         * wap_add_default : true
         * wap_less_amount : true
         * wap_signed : true
         */

        private int primo_amount;
        private boolean wap_add_default;
        private boolean wap_less_amount;
        private boolean wap_signed;

        public int getPrimo_amount() {
            return primo_amount;
        }

        public void setPrimo_amount(int primo_amount) {
            this.primo_amount = primo_amount;
        }

        public boolean isWap_add_default() {
            return wap_add_default;
        }

        public void setWap_add_default(boolean wap_add_default) {
            this.wap_add_default = wap_add_default;
        }

        public boolean isWap_less_amount() {
            return wap_less_amount;
        }

        public void setWap_less_amount(boolean wap_less_amount) {
            this.wap_less_amount = wap_less_amount;
        }

        public boolean isWap_signed() {
            return wap_signed;
        }

        public void setWap_signed(boolean wap_signed) {
            this.wap_signed = wap_signed;
        }
    }

    public static class PaymentPendingOrdersBean {
        /**
         * is_present : false
         * orders_list : []
         */

        private boolean is_present;
        private List<?> orders_list;

        public boolean isIs_present() {
            return is_present;
        }

        public void setIs_present(boolean is_present) {
            this.is_present = is_present;
        }

        public List<?> getOrders_list() {
            return orders_list;
        }

        public void setOrders_list(List<?> orders_list) {
            this.orders_list = orders_list;
        }
    }

    public static class CurrentPaymentDetailsBean {
        /**
         * payment_method : {"account_id":0,"code":"cod","name":"cod","id":1,"display_name":"CASH ON DELIVERY"}
         */

        private PaymentMethodBean payment_method;

        public PaymentMethodBean getPayment_method() {
            return payment_method;
        }

        public void setPayment_method(PaymentMethodBean payment_method) {
            this.payment_method = payment_method;
        }

        public static class PaymentMethodBean {
            /**
             * account_id : 0
             * code : cod
             * name : cod
             * id : 1
             * display_name : CASH ON DELIVERY
             */

            private int account_id;
            private String code;
            private String name;
            private int id;
            private String display_name;

            public int getAccount_id() {
                return account_id;
            }

            public void setAccount_id(int account_id) {
                this.account_id = account_id;
            }

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getDisplay_name() {
                return display_name;
            }

            public void setDisplay_name(String display_name) {
                this.display_name = display_name;
            }
        }
    }

    public static class ShipAddressBean {
        /**
         * address : {"country":"INDIA","firstname":"ashok","address2":"N/A","city":"Adabor, Dhaka","alternative_phone":null,"address1":"shopup at dhaka","lastname":"","zipcode":"7","is_saved":null,"user_id":122694,"phone":"8801877755590","company":"NA","id":9043057,"state":"Andhra Pradesh","state_id":34,"landmark":"","country_id":1}
         */

        private AddressBean address;

        public AddressBean getAddress() {
            return address;
        }

        public void setAddress(AddressBean address) {
            this.address = address;
        }

        public static class AddressBean {
            /**
             * country : INDIA
             * firstname : ashok
             * address2 : N/A
             * city : Adabor, Dhaka
             * alternative_phone : null
             * address1 : shopup at dhaka
             * lastname :
             * zipcode : 7
             * is_saved : null
             * user_id : 122694
             * phone : 8801877755590
             * company : NA
             * id : 9043057
             * state : Andhra Pradesh
             * state_id : 34
             * landmark :
             * country_id : 1
             */

            private String country;
            private String firstname;
            private String address2;
            private String city;
            private Object alternative_phone;
            private String address1;
            private String lastname;
            private String zipcode;
            private Object is_saved;
            private int user_id;
            private String phone;
            private String company;
            private int id;
            private String state;
            private int state_id;
            private String landmark;
            private int country_id;

            public String getCountry() {
                return country;
            }

            public void setCountry(String country) {
                this.country = country;
            }

            public String getFirstname() {
                return firstname;
            }

            public void setFirstname(String firstname) {
                this.firstname = firstname;
            }

            public String getAddress2() {
                return address2;
            }

            public void setAddress2(String address2) {
                this.address2 = address2;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public Object getAlternative_phone() {
                return alternative_phone;
            }

            public void setAlternative_phone(Object alternative_phone) {
                this.alternative_phone = alternative_phone;
            }

            public String getAddress1() {
                return address1;
            }

            public void setAddress1(String address1) {
                this.address1 = address1;
            }

            public String getLastname() {
                return lastname;
            }

            public void setLastname(String lastname) {
                this.lastname = lastname;
            }

            public String getZipcode() {
                return zipcode;
            }

            public void setZipcode(String zipcode) {
                this.zipcode = zipcode;
            }

            public Object getIs_saved() {
                return is_saved;
            }

            public void setIs_saved(Object is_saved) {
                this.is_saved = is_saved;
            }

            public int getUser_id() {
                return user_id;
            }

            public void setUser_id(int user_id) {
                this.user_id = user_id;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public String getCompany() {
                return company;
            }

            public void setCompany(String company) {
                this.company = company;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getState() {
                return state;
            }

            public void setState(String state) {
                this.state = state;
            }

            public int getState_id() {
                return state_id;
            }

            public void setState_id(int state_id) {
                this.state_id = state_id;
            }

            public String getLandmark() {
                return landmark;
            }

            public void setLandmark(String landmark) {
                this.landmark = landmark;
            }

            public int getCountry_id() {
                return country_id;
            }

            public void setCountry_id(int country_id) {
                this.country_id = country_id;
            }
        }
    }

    public static class SpecialInstructionsBean {
        /**
         * preferred_days :
         * preferred_slots :
         * text :
         */

        private String preferred_days;
        private String preferred_slots;
        private String text;

        public String getPreferred_days() {
            return preferred_days;
        }

        public void setPreferred_days(String preferred_days) {
            this.preferred_days = preferred_days;
        }

        public String getPreferred_slots() {
            return preferred_slots;
        }

        public void setPreferred_slots(String preferred_slots) {
            this.preferred_slots = preferred_slots;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }

    public static class PrepaidMessageConfigBean {
        /**
         * prepaid_retry_message : Your payment for this order has failed. Please try making the payment again. Note: If you think that you have already made a successful payment, you can wait for 30 minutes till we check and confirm your payment. You can check the status of your order and payment in 'My Orders' page.
         * retry_message_for_close_popup : Seems like your payment is pending/failed. You can retry paying by below options or alternatively you can go to My Orders page and complete the payment in next 24 hours to avoid the cancellation. Note: If you think that you have already made a successful payment, you can wait for 30 minutes till we check and confirm your payment. You can check the status of your order and payment in 'My Orders' page.
         * prepaid_order_message : Please wait while we redirect you for making payment...
         */

        private String prepaid_retry_message;
        private String retry_message_for_close_popup;
        private String prepaid_order_message;

        public String getPrepaid_retry_message() {
            return prepaid_retry_message;
        }

        public void setPrepaid_retry_message(String prepaid_retry_message) {
            this.prepaid_retry_message = prepaid_retry_message;
        }

        public String getRetry_message_for_close_popup() {
            return retry_message_for_close_popup;
        }

        public void setRetry_message_for_close_popup(String retry_message_for_close_popup) {
            this.retry_message_for_close_popup = retry_message_for_close_popup;
        }

        public String getPrepaid_order_message() {
            return prepaid_order_message;
        }

        public void setPrepaid_order_message(String prepaid_order_message) {
            this.prepaid_order_message = prepaid_order_message;
        }
    }

    public static class PrimoCartImagesBean {
        /**
         * wap_unsigned : //images11.voonik.com/primo_assets/primo_web_signed_1.jpg
         * web_signed : //images11.voonik.com/primo_assets/primo_web_signed_1.jpg
         * web_unsigned : //images11.voonik.com/primo_assets/primo_web_signed_1.jpg
         * wap_signed : //images11.voonik.com/primo_assets/primo_web_signed_1.jpg
         */

        private String wap_unsigned;
        private String web_signed;
        private String web_unsigned;
        private String wap_signed;

        public String getWap_unsigned() {
            return wap_unsigned;
        }

        public void setWap_unsigned(String wap_unsigned) {
            this.wap_unsigned = wap_unsigned;
        }

        public String getWeb_signed() {
            return web_signed;
        }

        public void setWeb_signed(String web_signed) {
            this.web_signed = web_signed;
        }

        public String getWeb_unsigned() {
            return web_unsigned;
        }

        public void setWeb_unsigned(String web_unsigned) {
            this.web_unsigned = web_unsigned;
        }

        public String getWap_signed() {
            return wap_signed;
        }

        public void setWap_signed(String wap_signed) {
            this.wap_signed = wap_signed;
        }
    }

    public static class OrderAddressBean {
        /**
         * address : {address1: "48,Shop street"
         * address2: "F colony"
         * alternative_phone: "8801877766620"
         * city: "Agailjhara, Barisal"
         * company: "N/A"
         * country_id: 1
         * created_at: "2020-07-20T20:28:19.000+06:00"
         * firstname: "Hari"
         * id: 78733
         * landmark: "Near bharath stores"
         * lastname: " "
         * phone: "8801877766610"
         * state_id: 34
         * state_name: "Andhra Pradesh"
         * updated_at: "2020-07-20T20:28:19.000+06:00"
         * user_address_id: 9122762
         * vaccount_id: 1
         * zipcode: "928"}
         */

        private AddressBeanX address;

        public AddressBeanX getAddress() {
            return address;
        }

        public void setAddress(AddressBeanX address) {
            this.address = address;
        }

        public static class AddressBeanX {

            private String firstname;
            private String address1;
            private String landmark;
            private String city;
            private String phone;

            public String getFirstname() {
                return firstname;
            }

            public void setFirstname(String firstname) {
                this.firstname = firstname;
            }

            public String getAddress1() {
                return address1;
            }

            public void setAddress1(String address1) {
                this.address1 = address1;
            }

            public String getLandmark() {
                return landmark;
            }

            public void setLandmark(String landmark) {
                this.landmark = landmark;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }
        }
    }

    public static class EnableMandatorySignInBean {
        /**
         * web : true
         * wap : true
         */

        private boolean web;
        private boolean wap;

        public boolean isWeb() {
            return web;
        }

        public void setWeb(boolean web) {
            this.web = web;
        }

        public boolean isWap() {
            return wap;
        }

        public void setWap(boolean wap) {
            this.wap = wap;
        }
    }

    public static class VcashDataBean {
        /**
         * available_vcash : 0
         * show_vcash_form : true
         * vcash_already_applied_in_order : 0
         * approved_vcash : 0
         */

        private int available_vcash;
        private boolean show_vcash_form;
        private int vcash_already_applied_in_order;
        private int approved_vcash;

        public int getAvailable_vcash() {
            return available_vcash;
        }

        public void setAvailable_vcash(int available_vcash) {
            this.available_vcash = available_vcash;
        }

        public boolean isShow_vcash_form() {
            return show_vcash_form;
        }

        public void setShow_vcash_form(boolean show_vcash_form) {
            this.show_vcash_form = show_vcash_form;
        }

        public int getVcash_already_applied_in_order() {
            return vcash_already_applied_in_order;
        }

        public void setVcash_already_applied_in_order(int vcash_already_applied_in_order) {
            this.vcash_already_applied_in_order = vcash_already_applied_in_order;
        }

        public int getApproved_vcash() {
            return approved_vcash;
        }

        public void setApproved_vcash(int approved_vcash) {
            this.approved_vcash = approved_vcash;
        }
    }

    public static class OrderDataBean {
        /**
         * error_message : 3
         * adjustments : [{"amount":49,"is_seller_coupon":false,"is_vcash":false,"label":"Shipping Charges"}]
         * new_user_check_for_nps : false
         * order_number : R0162378311
         * count : 10
         * cart_items_total : 8710.0
         * pickup_address : null
         * prepaid_availability : true
         * remaining_vcash : 0
         * item_total : 8710
         * vcash_data : {"available_vcash":0,"show_vcash_form":true,"vcash_already_applied_in_order":0,"approved_vcash":0}
         * total : 8759
         * total_income : 979
         * coupon_applied_message : The coupon code is applied
         * subtotal : 8710
         * last_completed_order : null
         * messages : []
         * lastmile_addresses : []
         * cod_availability : true
         * formatted_total_income : Tk. 979
         * payment_method : cod
         * code_applied : false
         * li_by_sellers : {"DVS":{"adjustments":[],"subtotal":1053,"item_total":1053,"items":[{"formatted_price":"Tk. 351","seller":"DVS","min_order_qty":1,"line_item_id":297817,"discount":0,"prepaid_availability":true,"seller_slug":"dvs","delivery_time":"Delivery in 4-6 working days.","title":"Men's Premium Full Sleeve - DS2012 - DVS","liked":false,"category_id":1118,"variant_options":[{"count_on_hand":7,"option_value_name":"15 or M","size":25,"corrected_count_on_hand":3,"name":"15 or M","id":88533},{"count_on_hand":7,"option_value_name":"15.5 or L","size":25,"corrected_count_on_hand":3,"name":"15.5 or L","id":88534},{"count_on_hand":13,"option_value_name":"16 or XL","size":25,"corrected_count_on_hand":3,"name":"16 or XL","id":88536}],"max_item_quantity":50,"price":"351.0","product_id":68576,"sold_out":false,"variant":88533,"formatted_income":"Tk. 153","mrp_price_line":"Tk. 360 x 3 = Tk. 1,080","cod_availability":true,"formatted_per_item_total":"Tk. 1,053","per_item_total":1053,"sku":"268387","delivery_time_message":{"message":"Delivery in 4-6 working days.","type":2},"prepaid_message":"Delivery in 4-6 working days.","activity_object":{"activity_object":{"id":"P68576"}},"image":"https://shopimages.vstores.io/67586/1573394963295-19-small.jpg?1580195558","quantity":3,"max_selling_price":549,"original_amo":360,"variant_price":300,"final_discount":0,"formatted_variant_price":"Tk. 300","price_line":"Tk. 351 x 3 = Tk. 1,053","product_name":"Men\\'s Premium Full Sleeve - DS2012 - DVS","sale_price":"1053.0","product_stamp":null,"zipcode":"7","formatted_seller_price":"Tk. 0","formatted_sale_price":"Tk. 1,053","size":"15 or M","line_item_adjustments":[],"master_product_id":68576,"messages":[],"min_selling_price":351,"category":"Men shirt","permalink":"men-s-premium-full-sleeve-ds2012-dvs-4e2825ff","cod_message":"Delivery in 4-6 working days."}]},"WHA":{"adjustments":[],"subtotal":300,"item_total":300,"items":[{"formatted_price":"Tk. 300","seller":"WHA","min_order_qty":1,"line_item_id":297807,"discount":25,"prepaid_availability":true,"seller_slug":"wha","delivery_time":"Delivery in 4-6 working days.","title":"Fashionable Full Sleeve Check Shirt - WHA-CHECK 19 - WHA","liked":false,"category_id":1118,"variant_options":[{"count_on_hand":1,"option_value_name":"S","size":25,"corrected_count_on_hand":1,"name":"S","id":83723}],"max_item_quantity":50,"price":"300.0","product_id":65947,"sold_out":false,"variant":83723,"formatted_income":"Tk. 49","mrp_price_line":"Tk. 399 x 1 = Tk. 399","cod_availability":true,"formatted_per_item_total":"Tk. 300","per_item_total":300,"sku":"264914","delivery_time_message":{"message":"Delivery in 4-6 working days.","type":2},"prepaid_message":"Delivery in 4-6 working days.","activity_object":{"activity_object":{"id":"P65947"}},"image":"https://shopimages.vstores.io/74956/1570083577069-wha-check019-small.jpg?1580193382","quantity":1,"max_selling_price":459,"original_amo":399,"variant_price":251,"final_discount":25,"formatted_variant_price":"Tk. 251","price_line":"Tk. 300 x 1 = Tk. 300","product_name":"Fashionable Full Sleeve Check Shirt - WHA-CHECK 19 - WHA","sale_price":"300.0","product_stamp":null,"zipcode":"7","formatted_seller_price":"Tk. 0","formatted_sale_price":"Tk. 300","size":"S","line_item_adjustments":[],"master_product_id":65947,"messages":[{"message":"Last chance only 1 left!","type":1}],"min_selling_price":294,"category":"Men shirt","permalink":"fashionable-full-sleeve-check-shirt-wha-check-19-wha-7acb9322","cod_message":"Delivery in 4-6 working days."}]},"SGM":{"adjustments":[],"subtotal":825,"item_total":825,"items":[{"formatted_price":"Tk. 825","seller":"SGM","min_order_qty":1,"line_item_id":297818,"discount":8,"prepaid_availability":true,"seller_slug":"sgm","delivery_time":"Delivery in 4-6 working days.","title":"Indian Chundri Silk Saree - 102 - SGM","liked":false,"category_id":48,"variant_options":[{"count_on_hand":5,"option_value_name":"option","size":25,"corrected_count_on_hand":3,"name":"option","id":55190}],"max_item_quantity":50,"price":"825.0","product_id":46543,"sold_out":false,"variant":55190,"formatted_income":"Tk. 75","mrp_price_line":"Tk. 900 x 1 = Tk. 900","cod_availability":true,"formatted_per_item_total":"Tk. 825","per_item_total":825,"sku":"286699","delivery_time_message":{"message":"Delivery in 4-6 working days.","type":2},"prepaid_message":"Delivery in 4-6 working days.","activity_object":{"activity_object":{"id":"P46543"}},"image":"https://shopimages.vstores.io/34564/1573991787793-102-small.jpg?1580160568","quantity":1,"max_selling_price":1147,"original_amo":900,"variant_price":750,"final_discount":8,"formatted_variant_price":"Tk. 750","price_line":"Tk. 825 x 1 = Tk. 825","product_name":"Indian Chundri Silk Saree - 102 - SGM","sale_price":"825.0","product_stamp":null,"zipcode":"7","formatted_seller_price":"Tk. 0","formatted_sale_price":"Tk. 825","size":"option","line_item_adjustments":[],"master_product_id":46543,"messages":[],"min_selling_price":825,"category":"Saree","permalink":"indian-chundri-silk-saree-102-sgm-18d1bc4e","cod_message":"Delivery in 4-6 working days."}]},"RKT":{"adjustments":[],"subtotal":2408,"item_total":2408,"items":[{"formatted_price":"Tk. 2,408","seller":"RKT","min_order_qty":1,"line_item_id":297819,"discount":11,"prepaid_availability":true,"seller_slug":"rkt","delivery_time":"Delivery in 4-6 working days.","title":"Indian Julahaa Katan Saree - 12 - RKT","liked":false,"category_id":48,"variant_options":[{"count_on_hand":1,"option_value_name":"option","size":25,"corrected_count_on_hand":1,"name":"option","id":29584}],"max_item_quantity":50,"price":"2408.0","product_id":24709,"sold_out":false,"variant":29584,"formatted_income":"Tk. 158","mrp_price_line":"Tk. 2,720 x 1 = Tk. 2,720","cod_availability":true,"formatted_per_item_total":"Tk. 2,408","per_item_total":2408,"sku":"308465","delivery_time_message":{"message":"Delivery in 4-6 working days.","type":2},"prepaid_message":"Delivery in 4-6 working days.","activity_object":{"activity_object":{"id":"P24709"}},"image":"https://shopimages.vstores.io/90742/1577091355687-whatsappimage2019-12-15at00.00.271-small.jpeg?1580126997","quantity":1,"max_selling_price":2992,"original_amo":2720,"variant_price":2250,"final_discount":11,"formatted_variant_price":"Tk. 2,250","price_line":"Tk. 2,408 x 1 = Tk. 2,408","product_name":"Indian Julahaa Katan Saree - 12 - RKT","sale_price":"2408.0","product_stamp":null,"zipcode":"7","formatted_seller_price":"Tk. 0","formatted_sale_price":"Tk. 2,408","size":"option","line_item_adjustments":[],"master_product_id":24709,"messages":[{"message":"Last chance only 1 left!","type":1}],"min_selling_price":2408,"category":"Saree","permalink":"indian-julahaa-katan-saree-12-rkt-a2eeac01","cod_message":"Delivery in 4-6 working days."}]},"UPF":{"adjustments":[],"subtotal":763,"item_total":763,"items":[{"formatted_price":"Tk. 423","seller":"UPF","min_order_qty":1,"line_item_id":297861,"discount":0,"prepaid_availability":true,"seller_slug":"upf","delivery_time":"Delivery in 4-6 working days.","title":"Casual Shirt For Men Olive - UPF","liked":false,"category_id":1118,"variant_options":[{"count_on_hand":19,"option_value_name":"M","size":25,"corrected_count_on_hand":3,"name":"M","id":93380},{"count_on_hand":14,"option_value_name":"L","size":25,"corrected_count_on_hand":3,"name":"L","id":93381},{"count_on_hand":29,"option_value_name":"XL","size":25,"corrected_count_on_hand":3,"name":"XL","id":93382}],"max_item_quantity":50,"price":"423.0","product_id":71943,"sold_out":false,"variant":93380,"formatted_income":"Tk. 68","mrp_price_line":"Tk. 384 x 1 = Tk. 384","cod_availability":true,"formatted_per_item_total":"Tk. 423","per_item_total":423,"sku":"264086","delivery_time_message":{"message":"Delivery in 4-6 working days.","type":2},"prepaid_message":"Delivery in 4-6 working days.","activity_object":{"activity_object":{"id":"P71943"}},"image":"https://shopimages.vstores.io/75917/1569929603861-32-small.jpg?1580465725","quantity":1,"max_selling_price":667,"original_amo":384,"variant_price":355,"final_discount":0,"formatted_variant_price":"Tk. 355","price_line":"Tk. 423 x 1 = Tk. 423","product_name":"Casual Shirt For Men Olive - UPF","sale_price":"423.0","product_stamp":null,"zipcode":"7","formatted_seller_price":"Tk. 0","formatted_sale_price":"Tk. 423","size":"M","line_item_adjustments":[],"master_product_id":71943,"messages":[],"min_selling_price":423,"category":"Men shirt","permalink":"casual-shirt-for-men-olive-upf-9fad7110","cod_message":"Delivery in 4-6 working days."},{"formatted_price":"Tk. 340","seller":"UPF","min_order_qty":1,"line_item_id":297860,"discount":1,"prepaid_availability":true,"seller_slug":"upf","delivery_time":"Delivery in 4-6 working days.","title":"Navy Blue Sleeve Casual Shirt for Men - UPF","liked":false,"category_id":1118,"variant_options":[{"count_on_hand":27,"option_value_name":"M","size":25,"corrected_count_on_hand":3,"name":"M","id":82512},{"count_on_hand":22,"option_value_name":"L","size":25,"corrected_count_on_hand":3,"name":"L","id":82513},{"count_on_hand":30,"option_value_name":"XL","size":25,"corrected_count_on_hand":3,"name":"XL","id":82514}],"max_item_quantity":50,"price":"340.0","product_id":65251,"sold_out":false,"variant":82512,"formatted_income":"Tk. 50","mrp_price_line":"Tk. 345 x 1 = Tk. 345","cod_availability":true,"formatted_per_item_total":"Tk. 340","per_item_total":340,"sku":"264038","delivery_time_message":{"message":"Delivery in 4-6 working days.","type":2},"prepaid_message":"Delivery in 4-6 working days.","activity_object":{"activity_object":{"id":"P65251"}},"image":"https://shopimages.vstores.io/15256/1569927970391-19-small.jpg?1580192775","quantity":1,"max_selling_price":530,"original_amo":345,"variant_price":290,"final_discount":1,"formatted_variant_price":"Tk. 290","price_line":"Tk. 340 x 1 = Tk. 340","product_name":"Navy Blue Sleeve Casual Shirt for Men - UPF","sale_price":"340.0","product_stamp":null,"zipcode":"7","formatted_seller_price":"Tk. 0","formatted_sale_price":"Tk. 340","size":"M","line_item_adjustments":[],"master_product_id":65251,"messages":[],"min_selling_price":340,"category":"Men shirt","permalink":"navy-blue-sleeve-casual-shirt-for-men-upf-290decb7","cod_message":"Delivery in 4-6 working days."}]},"7MEC":{"adjustments":[],"subtotal":2361,"item_total":2361,"items":[{"formatted_price":"Tk. 787","seller":"7MEC","min_order_qty":1,"line_item_id":297865,"discount":0,"prepaid_availability":true,"seller_slug":"7MEC","delivery_time":"COD is not available.","title":"Casual T-shirt for Men - MEC003 - 7MEC","liked":false,"category_id":1117,"variant_options":[{"count_on_hand":2,"option_value_name":"M","size":25,"corrected_count_on_hand":2,"name":"M","id":94134},{"count_on_hand":2,"option_value_name":"L","size":25,"corrected_count_on_hand":2,"name":"L","id":94135},{"count_on_hand":2,"option_value_name":"XL","size":25,"corrected_count_on_hand":2,"name":"XL","id":94136},{"count_on_hand":1,"option_value_name":"XXL","size":25,"corrected_count_on_hand":1,"name":"XXL","id":94137},{"count_on_hand":2,"option_value_name":"XXXL","size":25,"corrected_count_on_hand":2,"name":"XXXL","id":94138}],"max_item_quantity":50,"price":"787.0","product_id":72580,"sold_out":false,"variant":94134,"formatted_income":"Tk. 72","mrp_price_line":"Tk. 780 x 1 = Tk. 780","cod_availability":false,"formatted_per_item_total":"Tk. 787","per_item_total":787,"sku":"339473","delivery_time_message":{"message":"COD is not available.","type":0},"prepaid_message":"Dispatched in - working days.","activity_object":{"activity_object":{"id":"P72580"}},"image":"https://shopimages.vstores.io/49527/Polo-T-shirt-for-Men---MEC003---7MEC-small.jpeg?1580468596","quantity":1,"max_selling_price":1093,"original_amo":780,"variant_price":715,"final_discount":0,"formatted_variant_price":"Tk. 715","price_line":"Tk. 787 x 1 = Tk. 787","product_name":"Casual T-shirt for Men - MEC003 - 7MEC","sale_price":"787.0","product_stamp":null,"zipcode":"7","formatted_seller_price":"Tk. 0","formatted_sale_price":"Tk. 787","size":"M","line_item_adjustments":[],"master_product_id":72580,"messages":[],"min_selling_price":787,"category":"Men t-shirt","permalink":"casual-t-shirt-for-men-mec003-7mec-1f2e8e82","cod_message":"COD is not available."},{"formatted_price":"Tk. 787","seller":"7MEC","min_order_qty":1,"line_item_id":297862,"discount":2,"prepaid_availability":true,"seller_slug":"7MEC","delivery_time":"COD is not available.","title":"Casual T-shirt for Men - MEC012 - 7MEC","liked":false,"category_id":1117,"variant_options":[{"count_on_hand":1,"option_value_name":"M-option","size":25,"corrected_count_on_hand":1,"name":"M-option","id":102854},{"count_on_hand":2,"option_value_name":"L-option","size":25,"corrected_count_on_hand":2,"name":"L-option","id":102879},{"count_on_hand":1,"option_value_name":"XL-option","size":25,"corrected_count_on_hand":1,"name":"XL-option","id":102885},{"count_on_hand":2,"option_value_name":"XXL-option","size":25,"corrected_count_on_hand":2,"name":"XXL-option","id":102890},{"count_on_hand":2,"option_value_name":"XXXL-option","size":25,"corrected_count_on_hand":2,"name":"XXXL-option","id":102895}],"max_item_quantity":50,"price":"787.0","product_id":79793,"sold_out":false,"variant":102879,"formatted_income":"Tk. 72","mrp_price_line":"Tk. 800 x 1 = Tk. 800","cod_availability":false,"formatted_per_item_total":"Tk. 787","per_item_total":787,"sku":"343984","delivery_time_message":{"message":"COD is not available.","type":0},"prepaid_message":"Dispatched in - working days.","activity_object":{"activity_object":{"id":"P79793"}},"image":"https://shopimages.vstores.io/81897/1580542180270-polo-t-shirt-for-men---mec012---7mec-small.jpeg?1580897425","quantity":1,"max_selling_price":1093,"original_amo":800,"variant_price":715,"final_discount":2,"formatted_variant_price":"Tk. 715","price_line":"Tk. 787 x 1 = Tk. 787","product_name":"Casual T-shirt for Men - MEC012 - 7MEC","sale_price":"787.0","product_stamp":null,"zipcode":"7","formatted_seller_price":"Tk. 0","formatted_sale_price":"Tk. 787","size":"L-option","line_item_adjustments":[],"master_product_id":79793,"messages":[],"min_selling_price":787,"category":"Men t-shirt","permalink":"casual-t-shirt-for-men-mec012-7mec-25c68795","cod_message":"COD is not available."},{"formatted_price":"Tk. 787","seller":"7MEC","min_order_qty":1,"line_item_id":297816,"discount":0,"prepaid_availability":true,"seller_slug":"7MEC","delivery_time":"COD is not available.","title":"Casual T-shirt for Men - MEC003 - 7MEC","liked":false,"category_id":1117,"variant_options":[{"count_on_hand":2,"option_value_name":"M","size":25,"corrected_count_on_hand":2,"name":"M","id":94134},{"count_on_hand":2,"option_value_name":"L","size":25,"corrected_count_on_hand":2,"name":"L","id":94135},{"count_on_hand":2,"option_value_name":"XL","size":25,"corrected_count_on_hand":2,"name":"XL","id":94136},{"count_on_hand":1,"option_value_name":"XXL","size":25,"corrected_count_on_hand":1,"name":"XXL","id":94137},{"count_on_hand":2,"option_value_name":"XXXL","size":25,"corrected_count_on_hand":2,"name":"XXXL","id":94138}],"max_item_quantity":50,"price":"787.0","product_id":72580,"sold_out":false,"variant":94136,"formatted_income":"Tk. 72","mrp_price_line":"Tk. 780 x 1 = Tk. 780","cod_availability":false,"formatted_per_item_total":"Tk. 787","per_item_total":787,"sku":"339475","delivery_time_message":{"message":"COD is not available.","type":0},"prepaid_message":"Dispatched in - working days.","activity_object":{"activity_object":{"id":"P72580"}},"image":"https://shopimages.vstores.io/49527/Polo-T-shirt-for-Men---MEC003---7MEC-small.jpeg?1580468596","quantity":1,"max_selling_price":1093,"original_amo":780,"variant_price":715,"final_discount":0,"formatted_variant_price":"Tk. 715","price_line":"Tk. 787 x 1 = Tk. 787","product_name":"Casual T-shirt for Men - MEC003 - 7MEC","sale_price":"787.0","product_stamp":null,"zipcode":"7","formatted_seller_price":"Tk. 0","formatted_sale_price":"Tk. 787","size":"XL","line_item_adjustments":[],"master_product_id":72580,"messages":[],"min_selling_price":787,"category":"Men t-shirt","permalink":"casual-t-shirt-for-men-mec003-7mec-1f2e8e82","cod_message":"COD is not available."}]},"TMW":{"adjustments":[],"subtotal":1000,"item_total":1000,"items":[{"formatted_price":"Tk. 500","seller":"TMW","min_order_qty":1,"line_item_id":297727,"discount":0,"prepaid_availability":true,"seller_slug":"tmw","delivery_time":"Delivery in 4-6 working days.","title":"Full Sleeve Casual Shirt for Men 02 - Ash - TMW","liked":false,"category_id":1118,"variant_options":[{"count_on_hand":6,"option_value_name":"M","size":25,"corrected_count_on_hand":3,"name":"M","id":29245},{"count_on_hand":8,"option_value_name":"L","size":25,"corrected_count_on_hand":3,"name":"L","id":29247},{"count_on_hand":7,"option_value_name":"XL","size":25,"corrected_count_on_hand":3,"name":"XL","id":29248}],"max_item_quantity":50,"price":"500.0","product_id":24424,"sold_out":false,"variant":29245,"formatted_income":"Tk. 210","mrp_price_line":"Tk. 395 x 2 = Tk. 790","cod_availability":true,"formatted_per_item_total":"Tk. 1,000","per_item_total":1000,"sku":"305933","delivery_time_message":{"message":"Delivery in 4-6 working days.","type":2},"prepaid_message":"Delivery in 4-6 working days.","activity_object":{"activity_object":{"id":"P24424"}},"image":"https://shopimages.vstores.io/42442/1576574650899-whatsappimage2019-12-14at5.26.18pm1-small.jpeg?1580126772","quantity":2,"max_selling_price":742,"original_amo":395,"variant_price":395,"final_discount":0,"formatted_variant_price":"Tk. 395","price_line":"Tk. 500 x 2 = Tk. 1,000","product_name":"Full Sleeve Casual Shirt for Men 02 - Ash - TMW","sale_price":"1000.0","product_stamp":null,"zipcode":"7","formatted_seller_price":"Tk. 0","formatted_sale_price":"Tk. 1,000","size":"M","line_item_adjustments":[],"master_product_id":24424,"messages":[],"min_selling_price":471,"category":"Men shirt","permalink":"full-sleeve-casual-shirt-for-men-02-ash-tmw-fa8be538","cod_message":"Delivery in 4-6 working days."}]}}
         */

        private int error_message;
        private boolean new_user_check_for_nps;
        private String order_number;
        private int count;
        private String cart_items_total;
        private Object pickup_address;
        private boolean prepaid_availability;
        private int remaining_vcash;
        private int item_total;
        private VcashDataBeanX vcash_data;
        private int total;
        private int total_income;
        private String coupon_applied_message;
        private int subtotal;
        private Object last_completed_order;
        private boolean cod_availability;
        private String formatted_total_income;
        private String payment_method;
        private boolean code_applied;
        private LiBySellersBean li_by_sellers;
        private List<AdjustmentsBean> adjustments;
        private List<?> messages;
        private List<?> lastmile_addresses;

        public int getError_message() {
            return error_message;
        }

        public void setError_message(int error_message) {
            this.error_message = error_message;
        }

        public boolean isNew_user_check_for_nps() {
            return new_user_check_for_nps;
        }

        public void setNew_user_check_for_nps(boolean new_user_check_for_nps) {
            this.new_user_check_for_nps = new_user_check_for_nps;
        }

        public String getOrder_number() {
            return order_number;
        }

        public void setOrder_number(String order_number) {
            this.order_number = order_number;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public String getCart_items_total() {
            return cart_items_total;
        }

        public void setCart_items_total(String cart_items_total) {
            this.cart_items_total = cart_items_total;
        }

        public Object getPickup_address() {
            return pickup_address;
        }

        public void setPickup_address(Object pickup_address) {
            this.pickup_address = pickup_address;
        }

        public boolean isPrepaid_availability() {
            return prepaid_availability;
        }

        public void setPrepaid_availability(boolean prepaid_availability) {
            this.prepaid_availability = prepaid_availability;
        }

        public int getRemaining_vcash() {
            return remaining_vcash;
        }

        public void setRemaining_vcash(int remaining_vcash) {
            this.remaining_vcash = remaining_vcash;
        }

        public int getItem_total() {
            return item_total;
        }

        public void setItem_total(int item_total) {
            this.item_total = item_total;
        }

        public VcashDataBeanX getVcash_data() {
            return vcash_data;
        }

        public void setVcash_data(VcashDataBeanX vcash_data) {
            this.vcash_data = vcash_data;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getTotal_income() {
            return total_income;
        }

        public void setTotal_income(int total_income) {
            this.total_income = total_income;
        }

        public String getCoupon_applied_message() {
            return coupon_applied_message;
        }

        public void setCoupon_applied_message(String coupon_applied_message) {
            this.coupon_applied_message = coupon_applied_message;
        }

        public int getSubtotal() {
            return subtotal;
        }

        public void setSubtotal(int subtotal) {
            this.subtotal = subtotal;
        }

        public Object getLast_completed_order() {
            return last_completed_order;
        }

        public void setLast_completed_order(Object last_completed_order) {
            this.last_completed_order = last_completed_order;
        }

        public boolean isCod_availability() {
            return cod_availability;
        }

        public void setCod_availability(boolean cod_availability) {
            this.cod_availability = cod_availability;
        }

        public String getFormatted_total_income() {
            return formatted_total_income;
        }

        public void setFormatted_total_income(String formatted_total_income) {
            this.formatted_total_income = formatted_total_income;
        }

        public String getPayment_method() {
            return payment_method;
        }

        public void setPayment_method(String payment_method) {
            this.payment_method = payment_method;
        }

        public boolean isCode_applied() {
            return code_applied;
        }

        public void setCode_applied(boolean code_applied) {
            this.code_applied = code_applied;
        }

        public LiBySellersBean getLi_by_sellers() {
            return li_by_sellers;
        }

        public void setLi_by_sellers(LiBySellersBean li_by_sellers) {
            this.li_by_sellers = li_by_sellers;
        }

        public List<AdjustmentsBean> getAdjustments() {
            return adjustments;
        }

        public void setAdjustments(List<AdjustmentsBean> adjustments) {
            this.adjustments = adjustments;
        }

        public List<?> getMessages() {
            return messages;
        }

        public void setMessages(List<?> messages) {
            this.messages = messages;
        }

        public List<?> getLastmile_addresses() {
            return lastmile_addresses;
        }

        public void setLastmile_addresses(List<?> lastmile_addresses) {
            this.lastmile_addresses = lastmile_addresses;
        }

        public static class VcashDataBeanX {
            /**
             * available_vcash : 0
             * show_vcash_form : true
             * vcash_already_applied_in_order : 0
             * approved_vcash : 0
             */

            private int available_vcash;
            private boolean show_vcash_form;
            private int vcash_already_applied_in_order;
            private int approved_vcash;

            public int getAvailable_vcash() {
                return available_vcash;
            }

            public void setAvailable_vcash(int available_vcash) {
                this.available_vcash = available_vcash;
            }

            public boolean isShow_vcash_form() {
                return show_vcash_form;
            }

            public void setShow_vcash_form(boolean show_vcash_form) {
                this.show_vcash_form = show_vcash_form;
            }

            public int getVcash_already_applied_in_order() {
                return vcash_already_applied_in_order;
            }

            public void setVcash_already_applied_in_order(int vcash_already_applied_in_order) {
                this.vcash_already_applied_in_order = vcash_already_applied_in_order;
            }

            public int getApproved_vcash() {
                return approved_vcash;
            }

            public void setApproved_vcash(int approved_vcash) {
                this.approved_vcash = approved_vcash;
            }
        }

        public static class LiBySellersBean {
            /**
             * DVS : {"adjustments":[],"subtotal":1053,"item_total":1053,"items":[{"formatted_price":"Tk. 351","seller":"DVS","min_order_qty":1,"line_item_id":297817,"discount":0,"prepaid_availability":true,"seller_slug":"dvs","delivery_time":"Delivery in 4-6 working days.","title":"Men's Premium Full Sleeve - DS2012 - DVS","liked":false,"category_id":1118,"variant_options":[{"count_on_hand":7,"option_value_name":"15 or M","size":25,"corrected_count_on_hand":3,"name":"15 or M","id":88533},{"count_on_hand":7,"option_value_name":"15.5 or L","size":25,"corrected_count_on_hand":3,"name":"15.5 or L","id":88534},{"count_on_hand":13,"option_value_name":"16 or XL","size":25,"corrected_count_on_hand":3,"name":"16 or XL","id":88536}],"max_item_quantity":50,"price":"351.0","product_id":68576,"sold_out":false,"variant":88533,"formatted_income":"Tk. 153","mrp_price_line":"Tk. 360 x 3 = Tk. 1,080","cod_availability":true,"formatted_per_item_total":"Tk. 1,053","per_item_total":1053,"sku":"268387","delivery_time_message":{"message":"Delivery in 4-6 working days.","type":2},"prepaid_message":"Delivery in 4-6 working days.","activity_object":{"activity_object":{"id":"P68576"}},"image":"https://shopimages.vstores.io/67586/1573394963295-19-small.jpg?1580195558","quantity":3,"max_selling_price":549,"original_amo":360,"variant_price":300,"final_discount":0,"formatted_variant_price":"Tk. 300","price_line":"Tk. 351 x 3 = Tk. 1,053","product_name":"Men\\'s Premium Full Sleeve - DS2012 - DVS","sale_price":"1053.0","product_stamp":null,"zipcode":"7","formatted_seller_price":"Tk. 0","formatted_sale_price":"Tk. 1,053","size":"15 or M","line_item_adjustments":[],"master_product_id":68576,"messages":[],"min_selling_price":351,"category":"Men shirt","permalink":"men-s-premium-full-sleeve-ds2012-dvs-4e2825ff","cod_message":"Delivery in 4-6 working days."}]}
             * WHA : {"adjustments":[],"subtotal":300,"item_total":300,"items":[{"formatted_price":"Tk. 300","seller":"WHA","min_order_qty":1,"line_item_id":297807,"discount":25,"prepaid_availability":true,"seller_slug":"wha","delivery_time":"Delivery in 4-6 working days.","title":"Fashionable Full Sleeve Check Shirt - WHA-CHECK 19 - WHA","liked":false,"category_id":1118,"variant_options":[{"count_on_hand":1,"option_value_name":"S","size":25,"corrected_count_on_hand":1,"name":"S","id":83723}],"max_item_quantity":50,"price":"300.0","product_id":65947,"sold_out":false,"variant":83723,"formatted_income":"Tk. 49","mrp_price_line":"Tk. 399 x 1 = Tk. 399","cod_availability":true,"formatted_per_item_total":"Tk. 300","per_item_total":300,"sku":"264914","delivery_time_message":{"message":"Delivery in 4-6 working days.","type":2},"prepaid_message":"Delivery in 4-6 working days.","activity_object":{"activity_object":{"id":"P65947"}},"image":"https://shopimages.vstores.io/74956/1570083577069-wha-check019-small.jpg?1580193382","quantity":1,"max_selling_price":459,"original_amo":399,"variant_price":251,"final_discount":25,"formatted_variant_price":"Tk. 251","price_line":"Tk. 300 x 1 = Tk. 300","product_name":"Fashionable Full Sleeve Check Shirt - WHA-CHECK 19 - WHA","sale_price":"300.0","product_stamp":null,"zipcode":"7","formatted_seller_price":"Tk. 0","formatted_sale_price":"Tk. 300","size":"S","line_item_adjustments":[],"master_product_id":65947,"messages":[{"message":"Last chance only 1 left!","type":1}],"min_selling_price":294,"category":"Men shirt","permalink":"fashionable-full-sleeve-check-shirt-wha-check-19-wha-7acb9322","cod_message":"Delivery in 4-6 working days."}]}
             * SGM : {"adjustments":[],"subtotal":825,"item_total":825,"items":[{"formatted_price":"Tk. 825","seller":"SGM","min_order_qty":1,"line_item_id":297818,"discount":8,"prepaid_availability":true,"seller_slug":"sgm","delivery_time":"Delivery in 4-6 working days.","title":"Indian Chundri Silk Saree - 102 - SGM","liked":false,"category_id":48,"variant_options":[{"count_on_hand":5,"option_value_name":"option","size":25,"corrected_count_on_hand":3,"name":"option","id":55190}],"max_item_quantity":50,"price":"825.0","product_id":46543,"sold_out":false,"variant":55190,"formatted_income":"Tk. 75","mrp_price_line":"Tk. 900 x 1 = Tk. 900","cod_availability":true,"formatted_per_item_total":"Tk. 825","per_item_total":825,"sku":"286699","delivery_time_message":{"message":"Delivery in 4-6 working days.","type":2},"prepaid_message":"Delivery in 4-6 working days.","activity_object":{"activity_object":{"id":"P46543"}},"image":"https://shopimages.vstores.io/34564/1573991787793-102-small.jpg?1580160568","quantity":1,"max_selling_price":1147,"original_amo":900,"variant_price":750,"final_discount":8,"formatted_variant_price":"Tk. 750","price_line":"Tk. 825 x 1 = Tk. 825","product_name":"Indian Chundri Silk Saree - 102 - SGM","sale_price":"825.0","product_stamp":null,"zipcode":"7","formatted_seller_price":"Tk. 0","formatted_sale_price":"Tk. 825","size":"option","line_item_adjustments":[],"master_product_id":46543,"messages":[],"min_selling_price":825,"category":"Saree","permalink":"indian-chundri-silk-saree-102-sgm-18d1bc4e","cod_message":"Delivery in 4-6 working days."}]}
             * RKT : {"adjustments":[],"subtotal":2408,"item_total":2408,"items":[{"formatted_price":"Tk. 2,408","seller":"RKT","min_order_qty":1,"line_item_id":297819,"discount":11,"prepaid_availability":true,"seller_slug":"rkt","delivery_time":"Delivery in 4-6 working days.","title":"Indian Julahaa Katan Saree - 12 - RKT","liked":false,"category_id":48,"variant_options":[{"count_on_hand":1,"option_value_name":"option","size":25,"corrected_count_on_hand":1,"name":"option","id":29584}],"max_item_quantity":50,"price":"2408.0","product_id":24709,"sold_out":false,"variant":29584,"formatted_income":"Tk. 158","mrp_price_line":"Tk. 2,720 x 1 = Tk. 2,720","cod_availability":true,"formatted_per_item_total":"Tk. 2,408","per_item_total":2408,"sku":"308465","delivery_time_message":{"message":"Delivery in 4-6 working days.","type":2},"prepaid_message":"Delivery in 4-6 working days.","activity_object":{"activity_object":{"id":"P24709"}},"image":"https://shopimages.vstores.io/90742/1577091355687-whatsappimage2019-12-15at00.00.271-small.jpeg?1580126997","quantity":1,"max_selling_price":2992,"original_amo":2720,"variant_price":2250,"final_discount":11,"formatted_variant_price":"Tk. 2,250","price_line":"Tk. 2,408 x 1 = Tk. 2,408","product_name":"Indian Julahaa Katan Saree - 12 - RKT","sale_price":"2408.0","product_stamp":null,"zipcode":"7","formatted_seller_price":"Tk. 0","formatted_sale_price":"Tk. 2,408","size":"option","line_item_adjustments":[],"master_product_id":24709,"messages":[{"message":"Last chance only 1 left!","type":1}],"min_selling_price":2408,"category":"Saree","permalink":"indian-julahaa-katan-saree-12-rkt-a2eeac01","cod_message":"Delivery in 4-6 working days."}]}
             * UPF : {"adjustments":[],"subtotal":763,"item_total":763,"items":[{"formatted_price":"Tk. 423","seller":"UPF","min_order_qty":1,"line_item_id":297861,"discount":0,"prepaid_availability":true,"seller_slug":"upf","delivery_time":"Delivery in 4-6 working days.","title":"Casual Shirt For Men Olive - UPF","liked":false,"category_id":1118,"variant_options":[{"count_on_hand":19,"option_value_name":"M","size":25,"corrected_count_on_hand":3,"name":"M","id":93380},{"count_on_hand":14,"option_value_name":"L","size":25,"corrected_count_on_hand":3,"name":"L","id":93381},{"count_on_hand":29,"option_value_name":"XL","size":25,"corrected_count_on_hand":3,"name":"XL","id":93382}],"max_item_quantity":50,"price":"423.0","product_id":71943,"sold_out":false,"variant":93380,"formatted_income":"Tk. 68","mrp_price_line":"Tk. 384 x 1 = Tk. 384","cod_availability":true,"formatted_per_item_total":"Tk. 423","per_item_total":423,"sku":"264086","delivery_time_message":{"message":"Delivery in 4-6 working days.","type":2},"prepaid_message":"Delivery in 4-6 working days.","activity_object":{"activity_object":{"id":"P71943"}},"image":"https://shopimages.vstores.io/75917/1569929603861-32-small.jpg?1580465725","quantity":1,"max_selling_price":667,"original_amo":384,"variant_price":355,"final_discount":0,"formatted_variant_price":"Tk. 355","price_line":"Tk. 423 x 1 = Tk. 423","product_name":"Casual Shirt For Men Olive - UPF","sale_price":"423.0","product_stamp":null,"zipcode":"7","formatted_seller_price":"Tk. 0","formatted_sale_price":"Tk. 423","size":"M","line_item_adjustments":[],"master_product_id":71943,"messages":[],"min_selling_price":423,"category":"Men shirt","permalink":"casual-shirt-for-men-olive-upf-9fad7110","cod_message":"Delivery in 4-6 working days."},{"formatted_price":"Tk. 340","seller":"UPF","min_order_qty":1,"line_item_id":297860,"discount":1,"prepaid_availability":true,"seller_slug":"upf","delivery_time":"Delivery in 4-6 working days.","title":"Navy Blue Sleeve Casual Shirt for Men - UPF","liked":false,"category_id":1118,"variant_options":[{"count_on_hand":27,"option_value_name":"M","size":25,"corrected_count_on_hand":3,"name":"M","id":82512},{"count_on_hand":22,"option_value_name":"L","size":25,"corrected_count_on_hand":3,"name":"L","id":82513},{"count_on_hand":30,"option_value_name":"XL","size":25,"corrected_count_on_hand":3,"name":"XL","id":82514}],"max_item_quantity":50,"price":"340.0","product_id":65251,"sold_out":false,"variant":82512,"formatted_income":"Tk. 50","mrp_price_line":"Tk. 345 x 1 = Tk. 345","cod_availability":true,"formatted_per_item_total":"Tk. 340","per_item_total":340,"sku":"264038","delivery_time_message":{"message":"Delivery in 4-6 working days.","type":2},"prepaid_message":"Delivery in 4-6 working days.","activity_object":{"activity_object":{"id":"P65251"}},"image":"https://shopimages.vstores.io/15256/1569927970391-19-small.jpg?1580192775","quantity":1,"max_selling_price":530,"original_amo":345,"variant_price":290,"final_discount":1,"formatted_variant_price":"Tk. 290","price_line":"Tk. 340 x 1 = Tk. 340","product_name":"Navy Blue Sleeve Casual Shirt for Men - UPF","sale_price":"340.0","product_stamp":null,"zipcode":"7","formatted_seller_price":"Tk. 0","formatted_sale_price":"Tk. 340","size":"M","line_item_adjustments":[],"master_product_id":65251,"messages":[],"min_selling_price":340,"category":"Men shirt","permalink":"navy-blue-sleeve-casual-shirt-for-men-upf-290decb7","cod_message":"Delivery in 4-6 working days."}]}
             * 7MEC : {"adjustments":[],"subtotal":2361,"item_total":2361,"items":[{"formatted_price":"Tk. 787","seller":"7MEC","min_order_qty":1,"line_item_id":297865,"discount":0,"prepaid_availability":true,"seller_slug":"7MEC","delivery_time":"COD is not available.","title":"Casual T-shirt for Men - MEC003 - 7MEC","liked":false,"category_id":1117,"variant_options":[{"count_on_hand":2,"option_value_name":"M","size":25,"corrected_count_on_hand":2,"name":"M","id":94134},{"count_on_hand":2,"option_value_name":"L","size":25,"corrected_count_on_hand":2,"name":"L","id":94135},{"count_on_hand":2,"option_value_name":"XL","size":25,"corrected_count_on_hand":2,"name":"XL","id":94136},{"count_on_hand":1,"option_value_name":"XXL","size":25,"corrected_count_on_hand":1,"name":"XXL","id":94137},{"count_on_hand":2,"option_value_name":"XXXL","size":25,"corrected_count_on_hand":2,"name":"XXXL","id":94138}],"max_item_quantity":50,"price":"787.0","product_id":72580,"sold_out":false,"variant":94134,"formatted_income":"Tk. 72","mrp_price_line":"Tk. 780 x 1 = Tk. 780","cod_availability":false,"formatted_per_item_total":"Tk. 787","per_item_total":787,"sku":"339473","delivery_time_message":{"message":"COD is not available.","type":0},"prepaid_message":"Dispatched in - working days.","activity_object":{"activity_object":{"id":"P72580"}},"image":"https://shopimages.vstores.io/49527/Polo-T-shirt-for-Men---MEC003---7MEC-small.jpeg?1580468596","quantity":1,"max_selling_price":1093,"original_amo":780,"variant_price":715,"final_discount":0,"formatted_variant_price":"Tk. 715","price_line":"Tk. 787 x 1 = Tk. 787","product_name":"Casual T-shirt for Men - MEC003 - 7MEC","sale_price":"787.0","product_stamp":null,"zipcode":"7","formatted_seller_price":"Tk. 0","formatted_sale_price":"Tk. 787","size":"M","line_item_adjustments":[],"master_product_id":72580,"messages":[],"min_selling_price":787,"category":"Men t-shirt","permalink":"casual-t-shirt-for-men-mec003-7mec-1f2e8e82","cod_message":"COD is not available."},{"formatted_price":"Tk. 787","seller":"7MEC","min_order_qty":1,"line_item_id":297862,"discount":2,"prepaid_availability":true,"seller_slug":"7MEC","delivery_time":"COD is not available.","title":"Casual T-shirt for Men - MEC012 - 7MEC","liked":false,"category_id":1117,"variant_options":[{"count_on_hand":1,"option_value_name":"M-option","size":25,"corrected_count_on_hand":1,"name":"M-option","id":102854},{"count_on_hand":2,"option_value_name":"L-option","size":25,"corrected_count_on_hand":2,"name":"L-option","id":102879},{"count_on_hand":1,"option_value_name":"XL-option","size":25,"corrected_count_on_hand":1,"name":"XL-option","id":102885},{"count_on_hand":2,"option_value_name":"XXL-option","size":25,"corrected_count_on_hand":2,"name":"XXL-option","id":102890},{"count_on_hand":2,"option_value_name":"XXXL-option","size":25,"corrected_count_on_hand":2,"name":"XXXL-option","id":102895}],"max_item_quantity":50,"price":"787.0","product_id":79793,"sold_out":false,"variant":102879,"formatted_income":"Tk. 72","mrp_price_line":"Tk. 800 x 1 = Tk. 800","cod_availability":false,"formatted_per_item_total":"Tk. 787","per_item_total":787,"sku":"343984","delivery_time_message":{"message":"COD is not available.","type":0},"prepaid_message":"Dispatched in - working days.","activity_object":{"activity_object":{"id":"P79793"}},"image":"https://shopimages.vstores.io/81897/1580542180270-polo-t-shirt-for-men---mec012---7mec-small.jpeg?1580897425","quantity":1,"max_selling_price":1093,"original_amo":800,"variant_price":715,"final_discount":2,"formatted_variant_price":"Tk. 715","price_line":"Tk. 787 x 1 = Tk. 787","product_name":"Casual T-shirt for Men - MEC012 - 7MEC","sale_price":"787.0","product_stamp":null,"zipcode":"7","formatted_seller_price":"Tk. 0","formatted_sale_price":"Tk. 787","size":"L-option","line_item_adjustments":[],"master_product_id":79793,"messages":[],"min_selling_price":787,"category":"Men t-shirt","permalink":"casual-t-shirt-for-men-mec012-7mec-25c68795","cod_message":"COD is not available."},{"formatted_price":"Tk. 787","seller":"7MEC","min_order_qty":1,"line_item_id":297816,"discount":0,"prepaid_availability":true,"seller_slug":"7MEC","delivery_time":"COD is not available.","title":"Casual T-shirt for Men - MEC003 - 7MEC","liked":false,"category_id":1117,"variant_options":[{"count_on_hand":2,"option_value_name":"M","size":25,"corrected_count_on_hand":2,"name":"M","id":94134},{"count_on_hand":2,"option_value_name":"L","size":25,"corrected_count_on_hand":2,"name":"L","id":94135},{"count_on_hand":2,"option_value_name":"XL","size":25,"corrected_count_on_hand":2,"name":"XL","id":94136},{"count_on_hand":1,"option_value_name":"XXL","size":25,"corrected_count_on_hand":1,"name":"XXL","id":94137},{"count_on_hand":2,"option_value_name":"XXXL","size":25,"corrected_count_on_hand":2,"name":"XXXL","id":94138}],"max_item_quantity":50,"price":"787.0","product_id":72580,"sold_out":false,"variant":94136,"formatted_income":"Tk. 72","mrp_price_line":"Tk. 780 x 1 = Tk. 780","cod_availability":false,"formatted_per_item_total":"Tk. 787","per_item_total":787,"sku":"339475","delivery_time_message":{"message":"COD is not available.","type":0},"prepaid_message":"Dispatched in - working days.","activity_object":{"activity_object":{"id":"P72580"}},"image":"https://shopimages.vstores.io/49527/Polo-T-shirt-for-Men---MEC003---7MEC-small.jpeg?1580468596","quantity":1,"max_selling_price":1093,"original_amo":780,"variant_price":715,"final_discount":0,"formatted_variant_price":"Tk. 715","price_line":"Tk. 787 x 1 = Tk. 787","product_name":"Casual T-shirt for Men - MEC003 - 7MEC","sale_price":"787.0","product_stamp":null,"zipcode":"7","formatted_seller_price":"Tk. 0","formatted_sale_price":"Tk. 787","size":"XL","line_item_adjustments":[],"master_product_id":72580,"messages":[],"min_selling_price":787,"category":"Men t-shirt","permalink":"casual-t-shirt-for-men-mec003-7mec-1f2e8e82","cod_message":"COD is not available."}]}
             * TMW : {"adjustments":[],"subtotal":1000,"item_total":1000,"items":[{"formatted_price":"Tk. 500","seller":"TMW","min_order_qty":1,"line_item_id":297727,"discount":0,"prepaid_availability":true,"seller_slug":"tmw","delivery_time":"Delivery in 4-6 working days.","title":"Full Sleeve Casual Shirt for Men 02 - Ash - TMW","liked":false,"category_id":1118,"variant_options":[{"count_on_hand":6,"option_value_name":"M","size":25,"corrected_count_on_hand":3,"name":"M","id":29245},{"count_on_hand":8,"option_value_name":"L","size":25,"corrected_count_on_hand":3,"name":"L","id":29247},{"count_on_hand":7,"option_value_name":"XL","size":25,"corrected_count_on_hand":3,"name":"XL","id":29248}],"max_item_quantity":50,"price":"500.0","product_id":24424,"sold_out":false,"variant":29245,"formatted_income":"Tk. 210","mrp_price_line":"Tk. 395 x 2 = Tk. 790","cod_availability":true,"formatted_per_item_total":"Tk. 1,000","per_item_total":1000,"sku":"305933","delivery_time_message":{"message":"Delivery in 4-6 working days.","type":2},"prepaid_message":"Delivery in 4-6 working days.","activity_object":{"activity_object":{"id":"P24424"}},"image":"https://shopimages.vstores.io/42442/1576574650899-whatsappimage2019-12-14at5.26.18pm1-small.jpeg?1580126772","quantity":2,"max_selling_price":742,"original_amo":395,"variant_price":395,"final_discount":0,"formatted_variant_price":"Tk. 395","price_line":"Tk. 500 x 2 = Tk. 1,000","product_name":"Full Sleeve Casual Shirt for Men 02 - Ash - TMW","sale_price":"1000.0","product_stamp":null,"zipcode":"7","formatted_seller_price":"Tk. 0","formatted_sale_price":"Tk. 1,000","size":"M","line_item_adjustments":[],"master_product_id":24424,"messages":[],"min_selling_price":471,"category":"Men shirt","permalink":"full-sleeve-casual-shirt-for-men-02-ash-tmw-fa8be538","cod_message":"Delivery in 4-6 working days."}]}
             */

            private DVSBean DVS;
            private WHABean WHA;
            private SGMBean SGM;
            private RKTBean RKT;
            private UPFBean UPF;
            @SerializedName("7MEC")
            private _$7MECBean _$7MEC;
            private TMWBean TMW;

            public DVSBean getDVS() {
                return DVS;
            }

            public void setDVS(DVSBean DVS) {
                this.DVS = DVS;
            }

            public WHABean getWHA() {
                return WHA;
            }

            public void setWHA(WHABean WHA) {
                this.WHA = WHA;
            }

            public SGMBean getSGM() {
                return SGM;
            }

            public void setSGM(SGMBean SGM) {
                this.SGM = SGM;
            }

            public RKTBean getRKT() {
                return RKT;
            }

            public void setRKT(RKTBean RKT) {
                this.RKT = RKT;
            }

            public UPFBean getUPF() {
                return UPF;
            }

            public void setUPF(UPFBean UPF) {
                this.UPF = UPF;
            }

            public _$7MECBean get_$7MEC() {
                return _$7MEC;
            }

            public void set_$7MEC(_$7MECBean _$7MEC) {
                this._$7MEC = _$7MEC;
            }

            public TMWBean getTMW() {
                return TMW;
            }

            public void setTMW(TMWBean TMW) {
                this.TMW = TMW;
            }

            public static class DVSBean {
                /**
                 * adjustments : []
                 * subtotal : 1053
                 * item_total : 1053
                 * items : [{"formatted_price":"Tk. 351","seller":"DVS","min_order_qty":1,"line_item_id":297817,"discount":0,"prepaid_availability":true,"seller_slug":"dvs","delivery_time":"Delivery in 4-6 working days.","title":"Men's Premium Full Sleeve - DS2012 - DVS","liked":false,"category_id":1118,"variant_options":[{"count_on_hand":7,"option_value_name":"15 or M","size":25,"corrected_count_on_hand":3,"name":"15 or M","id":88533},{"count_on_hand":7,"option_value_name":"15.5 or L","size":25,"corrected_count_on_hand":3,"name":"15.5 or L","id":88534},{"count_on_hand":13,"option_value_name":"16 or XL","size":25,"corrected_count_on_hand":3,"name":"16 or XL","id":88536}],"max_item_quantity":50,"price":"351.0","product_id":68576,"sold_out":false,"variant":88533,"formatted_income":"Tk. 153","mrp_price_line":"Tk. 360 x 3 = Tk. 1,080","cod_availability":true,"formatted_per_item_total":"Tk. 1,053","per_item_total":1053,"sku":"268387","delivery_time_message":{"message":"Delivery in 4-6 working days.","type":2},"prepaid_message":"Delivery in 4-6 working days.","activity_object":{"activity_object":{"id":"P68576"}},"image":"https://shopimages.vstores.io/67586/1573394963295-19-small.jpg?1580195558","quantity":3,"max_selling_price":549,"original_amo":360,"variant_price":300,"final_discount":0,"formatted_variant_price":"Tk. 300","price_line":"Tk. 351 x 3 = Tk. 1,053","product_name":"Men\\'s Premium Full Sleeve - DS2012 - DVS","sale_price":"1053.0","product_stamp":null,"zipcode":"7","formatted_seller_price":"Tk. 0","formatted_sale_price":"Tk. 1,053","size":"15 or M","line_item_adjustments":[],"master_product_id":68576,"messages":[],"min_selling_price":351,"category":"Men shirt","permalink":"men-s-premium-full-sleeve-ds2012-dvs-4e2825ff","cod_message":"Delivery in 4-6 working days."}]
                 */

                private int subtotal;
                private int item_total;
                private List<?> adjustments;
                private List<ItemsBean> items;

                public int getSubtotal() {
                    return subtotal;
                }

                public void setSubtotal(int subtotal) {
                    this.subtotal = subtotal;
                }

                public int getItem_total() {
                    return item_total;
                }

                public void setItem_total(int item_total) {
                    this.item_total = item_total;
                }

                public List<?> getAdjustments() {
                    return adjustments;
                }

                public void setAdjustments(List<?> adjustments) {
                    this.adjustments = adjustments;
                }

                public List<ItemsBean> getItems() {
                    return items;
                }

                public void setItems(List<ItemsBean> items) {
                    this.items = items;
                }

                public static class ItemsBean {
                    /**
                     * formatted_price : Tk. 351
                     * seller : DVS
                     * min_order_qty : 1
                     * line_item_id : 297817
                     * discount : 0
                     * prepaid_availability : true
                     * seller_slug : dvs
                     * delivery_time : Delivery in 4-6 working days.
                     * title : Men's Premium Full Sleeve - DS2012 - DVS
                     * liked : false
                     * category_id : 1118
                     * variant_options : [{"count_on_hand":7,"option_value_name":"15 or M","size":25,"corrected_count_on_hand":3,"name":"15 or M","id":88533},{"count_on_hand":7,"option_value_name":"15.5 or L","size":25,"corrected_count_on_hand":3,"name":"15.5 or L","id":88534},{"count_on_hand":13,"option_value_name":"16 or XL","size":25,"corrected_count_on_hand":3,"name":"16 or XL","id":88536}]
                     * max_item_quantity : 50
                     * price : 351.0
                     * product_id : 68576
                     * sold_out : false
                     * variant : 88533
                     * formatted_income : Tk. 153
                     * mrp_price_line : Tk. 360 x 3 = Tk. 1,080
                     * cod_availability : true
                     * formatted_per_item_total : Tk. 1,053
                     * per_item_total : 1053
                     * sku : 268387
                     * delivery_time_message : {"message":"Delivery in 4-6 working days.","type":2}
                     * prepaid_message : Delivery in 4-6 working days.
                     * activity_object : {"activity_object":{"id":"P68576"}}
                     * image : https://shopimages.vstores.io/67586/1573394963295-19-small.jpg?1580195558
                     * quantity : 3
                     * max_selling_price : 549
                     * original_amo : 360
                     * variant_price : 300
                     * final_discount : 0
                     * formatted_variant_price : Tk. 300
                     * price_line : Tk. 351 x 3 = Tk. 1,053
                     * product_name : Men\'s Premium Full Sleeve - DS2012 - DVS
                     * sale_price : 1053.0
                     * product_stamp : null
                     * zipcode : 7
                     * formatted_seller_price : Tk. 0
                     * formatted_sale_price : Tk. 1,053
                     * size : 15 or M
                     * line_item_adjustments : []
                     * master_product_id : 68576
                     * messages : []
                     * min_selling_price : 351
                     * category : Men shirt
                     * permalink : men-s-premium-full-sleeve-ds2012-dvs-4e2825ff
                     * cod_message : Delivery in 4-6 working days.
                     */

                    private String formatted_price;
                    private String seller;
                    private int min_order_qty;
                    private int line_item_id;
                    private int discount;
                    private boolean prepaid_availability;
                    private String seller_slug;
                    private String delivery_time;
                    private String title;
                    private boolean liked;
                    private int category_id;
                    private int max_item_quantity;
                    private String price;
                    private int product_id;
                    private boolean sold_out;
                    private int variant;
                    private String formatted_income;
                    private String mrp_price_line;
                    private boolean cod_availability;
                    private String formatted_per_item_total;
                    private int per_item_total;
                    private String sku;
                    private DeliveryTimeMessageBean delivery_time_message;
                    private String prepaid_message;
                    private ActivityObjectBeanX activity_object;
                    private String image;
                    private int quantity;
                    private int max_selling_price;
                    private int original_amo;
                    private int variant_price;
                    private int final_discount;
                    private String formatted_variant_price;
                    private String price_line;
                    private String product_name;
                    private String sale_price;
                    private Object product_stamp;
                    private String zipcode;
                    private String formatted_seller_price;
                    private String formatted_sale_price;
                    private String size;
                    private int master_product_id;
                    private int min_selling_price;
                    private String category;
                    private String permalink;
                    private String cod_message;
                    private List<VariantOptionsBean> variant_options;
                    private List<?> line_item_adjustments;
                    private List<?> messages;

                    public String getFormatted_price() {
                        return formatted_price;
                    }

                    public void setFormatted_price(String formatted_price) {
                        this.formatted_price = formatted_price;
                    }

                    public String getSeller() {
                        return seller;
                    }

                    public void setSeller(String seller) {
                        this.seller = seller;
                    }

                    public int getMin_order_qty() {
                        return min_order_qty;
                    }

                    public void setMin_order_qty(int min_order_qty) {
                        this.min_order_qty = min_order_qty;
                    }

                    public int getLine_item_id() {
                        return line_item_id;
                    }

                    public void setLine_item_id(int line_item_id) {
                        this.line_item_id = line_item_id;
                    }

                    public int getDiscount() {
                        return discount;
                    }

                    public void setDiscount(int discount) {
                        this.discount = discount;
                    }

                    public boolean isPrepaid_availability() {
                        return prepaid_availability;
                    }

                    public void setPrepaid_availability(boolean prepaid_availability) {
                        this.prepaid_availability = prepaid_availability;
                    }

                    public String getSeller_slug() {
                        return seller_slug;
                    }

                    public void setSeller_slug(String seller_slug) {
                        this.seller_slug = seller_slug;
                    }

                    public String getDelivery_time() {
                        return delivery_time;
                    }

                    public void setDelivery_time(String delivery_time) {
                        this.delivery_time = delivery_time;
                    }

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public boolean isLiked() {
                        return liked;
                    }

                    public void setLiked(boolean liked) {
                        this.liked = liked;
                    }

                    public int getCategory_id() {
                        return category_id;
                    }

                    public void setCategory_id(int category_id) {
                        this.category_id = category_id;
                    }

                    public int getMax_item_quantity() {
                        return max_item_quantity;
                    }

                    public void setMax_item_quantity(int max_item_quantity) {
                        this.max_item_quantity = max_item_quantity;
                    }

                    public String getPrice() {
                        return price;
                    }

                    public void setPrice(String price) {
                        this.price = price;
                    }

                    public int getProduct_id() {
                        return product_id;
                    }

                    public void setProduct_id(int product_id) {
                        this.product_id = product_id;
                    }

                    public boolean isSold_out() {
                        return sold_out;
                    }

                    public void setSold_out(boolean sold_out) {
                        this.sold_out = sold_out;
                    }

                    public int getVariant() {
                        return variant;
                    }

                    public void setVariant(int variant) {
                        this.variant = variant;
                    }

                    public String getFormatted_income() {
                        return formatted_income;
                    }

                    public void setFormatted_income(String formatted_income) {
                        this.formatted_income = formatted_income;
                    }

                    public String getMrp_price_line() {
                        return mrp_price_line;
                    }

                    public void setMrp_price_line(String mrp_price_line) {
                        this.mrp_price_line = mrp_price_line;
                    }

                    public boolean isCod_availability() {
                        return cod_availability;
                    }

                    public void setCod_availability(boolean cod_availability) {
                        this.cod_availability = cod_availability;
                    }

                    public String getFormatted_per_item_total() {
                        return formatted_per_item_total;
                    }

                    public void setFormatted_per_item_total(String formatted_per_item_total) {
                        this.formatted_per_item_total = formatted_per_item_total;
                    }

                    public int getPer_item_total() {
                        return per_item_total;
                    }

                    public void setPer_item_total(int per_item_total) {
                        this.per_item_total = per_item_total;
                    }

                    public String getSku() {
                        return sku;
                    }

                    public void setSku(String sku) {
                        this.sku = sku;
                    }

                    public DeliveryTimeMessageBean getDelivery_time_message() {
                        return delivery_time_message;
                    }

                    public void setDelivery_time_message(DeliveryTimeMessageBean delivery_time_message) {
                        this.delivery_time_message = delivery_time_message;
                    }

                    public String getPrepaid_message() {
                        return prepaid_message;
                    }

                    public void setPrepaid_message(String prepaid_message) {
                        this.prepaid_message = prepaid_message;
                    }

                    public ActivityObjectBeanX getActivity_object() {
                        return activity_object;
                    }

                    public void setActivity_object(ActivityObjectBeanX activity_object) {
                        this.activity_object = activity_object;
                    }

                    public String getImage() {
                        return image;
                    }

                    public void setImage(String image) {
                        this.image = image;
                    }

                    public int getQuantity() {
                        return quantity;
                    }

                    public void setQuantity(int quantity) {
                        this.quantity = quantity;
                    }

                    public int getMax_selling_price() {
                        return max_selling_price;
                    }

                    public void setMax_selling_price(int max_selling_price) {
                        this.max_selling_price = max_selling_price;
                    }

                    public int getOriginal_amo() {
                        return original_amo;
                    }

                    public void setOriginal_amo(int original_amo) {
                        this.original_amo = original_amo;
                    }

                    public int getVariant_price() {
                        return variant_price;
                    }

                    public void setVariant_price(int variant_price) {
                        this.variant_price = variant_price;
                    }

                    public int getFinal_discount() {
                        return final_discount;
                    }

                    public void setFinal_discount(int final_discount) {
                        this.final_discount = final_discount;
                    }

                    public String getFormatted_variant_price() {
                        return formatted_variant_price;
                    }

                    public void setFormatted_variant_price(String formatted_variant_price) {
                        this.formatted_variant_price = formatted_variant_price;
                    }

                    public String getPrice_line() {
                        return price_line;
                    }

                    public void setPrice_line(String price_line) {
                        this.price_line = price_line;
                    }

                    public String getProduct_name() {
                        return product_name;
                    }

                    public void setProduct_name(String product_name) {
                        this.product_name = product_name;
                    }

                    public String getSale_price() {
                        return sale_price;
                    }

                    public void setSale_price(String sale_price) {
                        this.sale_price = sale_price;
                    }

                    public Object getProduct_stamp() {
                        return product_stamp;
                    }

                    public void setProduct_stamp(Object product_stamp) {
                        this.product_stamp = product_stamp;
                    }

                    public String getZipcode() {
                        return zipcode;
                    }

                    public void setZipcode(String zipcode) {
                        this.zipcode = zipcode;
                    }

                    public String getFormatted_seller_price() {
                        return formatted_seller_price;
                    }

                    public void setFormatted_seller_price(String formatted_seller_price) {
                        this.formatted_seller_price = formatted_seller_price;
                    }

                    public String getFormatted_sale_price() {
                        return formatted_sale_price;
                    }

                    public void setFormatted_sale_price(String formatted_sale_price) {
                        this.formatted_sale_price = formatted_sale_price;
                    }

                    public String getSize() {
                        return size;
                    }

                    public void setSize(String size) {
                        this.size = size;
                    }

                    public int getMaster_product_id() {
                        return master_product_id;
                    }

                    public void setMaster_product_id(int master_product_id) {
                        this.master_product_id = master_product_id;
                    }

                    public int getMin_selling_price() {
                        return min_selling_price;
                    }

                    public void setMin_selling_price(int min_selling_price) {
                        this.min_selling_price = min_selling_price;
                    }

                    public String getCategory() {
                        return category;
                    }

                    public void setCategory(String category) {
                        this.category = category;
                    }

                    public String getPermalink() {
                        return permalink;
                    }

                    public void setPermalink(String permalink) {
                        this.permalink = permalink;
                    }

                    public String getCod_message() {
                        return cod_message;
                    }

                    public void setCod_message(String cod_message) {
                        this.cod_message = cod_message;
                    }

                    public List<VariantOptionsBean> getVariant_options() {
                        return variant_options;
                    }

                    public void setVariant_options(List<VariantOptionsBean> variant_options) {
                        this.variant_options = variant_options;
                    }

                    public List<?> getLine_item_adjustments() {
                        return line_item_adjustments;
                    }

                    public void setLine_item_adjustments(List<?> line_item_adjustments) {
                        this.line_item_adjustments = line_item_adjustments;
                    }

                    public List<?> getMessages() {
                        return messages;
                    }

                    public void setMessages(List<?> messages) {
                        this.messages = messages;
                    }

                    public static class DeliveryTimeMessageBean {
                        /**
                         * message : Delivery in 4-6 working days.
                         * type : 2
                         */

                        private String message;
                        private int type;

                        public String getMessage() {
                            return message;
                        }

                        public void setMessage(String message) {
                            this.message = message;
                        }

                        public int getType() {
                            return type;
                        }

                        public void setType(int type) {
                            this.type = type;
                        }
                    }

                    public static class ActivityObjectBeanX {
                        /**
                         * activity_object : {"id":"P68576"}
                         */

                        private ActivityObjectBean activity_object;

                        public ActivityObjectBean getActivity_object() {
                            return activity_object;
                        }

                        public void setActivity_object(ActivityObjectBean activity_object) {
                            this.activity_object = activity_object;
                        }

                        public static class ActivityObjectBean {
                            /**
                             * id : P68576
                             */

                            private String id;

                            public String getId() {
                                return id;
                            }

                            public void setId(String id) {
                                this.id = id;
                            }
                        }
                    }

                    public static class VariantOptionsBean {
                        /**
                         * count_on_hand : 7
                         * option_value_name : 15 or M
                         * size : 25
                         * corrected_count_on_hand : 3
                         * name : 15 or M
                         * id : 88533
                         */

                        private int count_on_hand;
                        private String option_value_name;
                        private int size;
                        private int corrected_count_on_hand;
                        private String name;
                        private int id;

                        public int getCount_on_hand() {
                            return count_on_hand;
                        }

                        public void setCount_on_hand(int count_on_hand) {
                            this.count_on_hand = count_on_hand;
                        }

                        public String getOption_value_name() {
                            return option_value_name;
                        }

                        public void setOption_value_name(String option_value_name) {
                            this.option_value_name = option_value_name;
                        }

                        public int getSize() {
                            return size;
                        }

                        public void setSize(int size) {
                            this.size = size;
                        }

                        public int getCorrected_count_on_hand() {
                            return corrected_count_on_hand;
                        }

                        public void setCorrected_count_on_hand(int corrected_count_on_hand) {
                            this.corrected_count_on_hand = corrected_count_on_hand;
                        }

                        public String getName() {
                            return name;
                        }

                        public void setName(String name) {
                            this.name = name;
                        }

                        public int getId() {
                            return id;
                        }

                        public void setId(int id) {
                            this.id = id;
                        }
                    }
                }
            }

            public static class WHABean {
                /**
                 * adjustments : []
                 * subtotal : 300
                 * item_total : 300
                 * items : [{"formatted_price":"Tk. 300","seller":"WHA","min_order_qty":1,"line_item_id":297807,"discount":25,"prepaid_availability":true,"seller_slug":"wha","delivery_time":"Delivery in 4-6 working days.","title":"Fashionable Full Sleeve Check Shirt - WHA-CHECK 19 - WHA","liked":false,"category_id":1118,"variant_options":[{"count_on_hand":1,"option_value_name":"S","size":25,"corrected_count_on_hand":1,"name":"S","id":83723}],"max_item_quantity":50,"price":"300.0","product_id":65947,"sold_out":false,"variant":83723,"formatted_income":"Tk. 49","mrp_price_line":"Tk. 399 x 1 = Tk. 399","cod_availability":true,"formatted_per_item_total":"Tk. 300","per_item_total":300,"sku":"264914","delivery_time_message":{"message":"Delivery in 4-6 working days.","type":2},"prepaid_message":"Delivery in 4-6 working days.","activity_object":{"activity_object":{"id":"P65947"}},"image":"https://shopimages.vstores.io/74956/1570083577069-wha-check019-small.jpg?1580193382","quantity":1,"max_selling_price":459,"original_amo":399,"variant_price":251,"final_discount":25,"formatted_variant_price":"Tk. 251","price_line":"Tk. 300 x 1 = Tk. 300","product_name":"Fashionable Full Sleeve Check Shirt - WHA-CHECK 19 - WHA","sale_price":"300.0","product_stamp":null,"zipcode":"7","formatted_seller_price":"Tk. 0","formatted_sale_price":"Tk. 300","size":"S","line_item_adjustments":[],"master_product_id":65947,"messages":[{"message":"Last chance only 1 left!","type":1}],"min_selling_price":294,"category":"Men shirt","permalink":"fashionable-full-sleeve-check-shirt-wha-check-19-wha-7acb9322","cod_message":"Delivery in 4-6 working days."}]
                 */

                private int subtotal;
                private int item_total;
                private List<?> adjustments;
                private List<ItemsBeanX> items;

                public int getSubtotal() {
                    return subtotal;
                }

                public void setSubtotal(int subtotal) {
                    this.subtotal = subtotal;
                }

                public int getItem_total() {
                    return item_total;
                }

                public void setItem_total(int item_total) {
                    this.item_total = item_total;
                }

                public List<?> getAdjustments() {
                    return adjustments;
                }

                public void setAdjustments(List<?> adjustments) {
                    this.adjustments = adjustments;
                }

                public List<ItemsBeanX> getItems() {
                    return items;
                }

                public void setItems(List<ItemsBeanX> items) {
                    this.items = items;
                }

                public static class ItemsBeanX {
                    /**
                     * formatted_price : Tk. 300
                     * seller : WHA
                     * min_order_qty : 1
                     * line_item_id : 297807
                     * discount : 25
                     * prepaid_availability : true
                     * seller_slug : wha
                     * delivery_time : Delivery in 4-6 working days.
                     * title : Fashionable Full Sleeve Check Shirt - WHA-CHECK 19 - WHA
                     * liked : false
                     * category_id : 1118
                     * variant_options : [{"count_on_hand":1,"option_value_name":"S","size":25,"corrected_count_on_hand":1,"name":"S","id":83723}]
                     * max_item_quantity : 50
                     * price : 300.0
                     * product_id : 65947
                     * sold_out : false
                     * variant : 83723
                     * formatted_income : Tk. 49
                     * mrp_price_line : Tk. 399 x 1 = Tk. 399
                     * cod_availability : true
                     * formatted_per_item_total : Tk. 300
                     * per_item_total : 300
                     * sku : 264914
                     * delivery_time_message : {"message":"Delivery in 4-6 working days.","type":2}
                     * prepaid_message : Delivery in 4-6 working days.
                     * activity_object : {"activity_object":{"id":"P65947"}}
                     * image : https://shopimages.vstores.io/74956/1570083577069-wha-check019-small.jpg?1580193382
                     * quantity : 1
                     * max_selling_price : 459
                     * original_amo : 399
                     * variant_price : 251
                     * final_discount : 25
                     * formatted_variant_price : Tk. 251
                     * price_line : Tk. 300 x 1 = Tk. 300
                     * product_name : Fashionable Full Sleeve Check Shirt - WHA-CHECK 19 - WHA
                     * sale_price : 300.0
                     * product_stamp : null
                     * zipcode : 7
                     * formatted_seller_price : Tk. 0
                     * formatted_sale_price : Tk. 300
                     * size : S
                     * line_item_adjustments : []
                     * master_product_id : 65947
                     * messages : [{"message":"Last chance only 1 left!","type":1}]
                     * min_selling_price : 294
                     * category : Men shirt
                     * permalink : fashionable-full-sleeve-check-shirt-wha-check-19-wha-7acb9322
                     * cod_message : Delivery in 4-6 working days.
                     */

                    private String formatted_price;
                    private String seller;
                    private int min_order_qty;
                    private int line_item_id;
                    private int discount;
                    private boolean prepaid_availability;
                    private String seller_slug;
                    private String delivery_time;
                    private String title;
                    private boolean liked;
                    private int category_id;
                    private int max_item_quantity;
                    private String price;
                    private int product_id;
                    private boolean sold_out;
                    private int variant;
                    private String formatted_income;
                    private String mrp_price_line;
                    private boolean cod_availability;
                    private String formatted_per_item_total;
                    private int per_item_total;
                    private String sku;
                    private DeliveryTimeMessageBeanX delivery_time_message;
                    private String prepaid_message;
                    private ActivityObjectBeanXXX activity_object;
                    private String image;
                    private int quantity;
                    private int max_selling_price;
                    private int original_amo;
                    private int variant_price;
                    private int final_discount;
                    private String formatted_variant_price;
                    private String price_line;
                    private String product_name;
                    private String sale_price;
                    private Object product_stamp;
                    private String zipcode;
                    private String formatted_seller_price;
                    private String formatted_sale_price;
                    private String size;
                    private int master_product_id;
                    private int min_selling_price;
                    private String category;
                    private String permalink;
                    private String cod_message;
                    private List<VariantOptionsBeanX> variant_options;
                    private List<?> line_item_adjustments;
                    private List<MessagesBean> messages;

                    public String getFormatted_price() {
                        return formatted_price;
                    }

                    public void setFormatted_price(String formatted_price) {
                        this.formatted_price = formatted_price;
                    }

                    public String getSeller() {
                        return seller;
                    }

                    public void setSeller(String seller) {
                        this.seller = seller;
                    }

                    public int getMin_order_qty() {
                        return min_order_qty;
                    }

                    public void setMin_order_qty(int min_order_qty) {
                        this.min_order_qty = min_order_qty;
                    }

                    public int getLine_item_id() {
                        return line_item_id;
                    }

                    public void setLine_item_id(int line_item_id) {
                        this.line_item_id = line_item_id;
                    }

                    public int getDiscount() {
                        return discount;
                    }

                    public void setDiscount(int discount) {
                        this.discount = discount;
                    }

                    public boolean isPrepaid_availability() {
                        return prepaid_availability;
                    }

                    public void setPrepaid_availability(boolean prepaid_availability) {
                        this.prepaid_availability = prepaid_availability;
                    }

                    public String getSeller_slug() {
                        return seller_slug;
                    }

                    public void setSeller_slug(String seller_slug) {
                        this.seller_slug = seller_slug;
                    }

                    public String getDelivery_time() {
                        return delivery_time;
                    }

                    public void setDelivery_time(String delivery_time) {
                        this.delivery_time = delivery_time;
                    }

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public boolean isLiked() {
                        return liked;
                    }

                    public void setLiked(boolean liked) {
                        this.liked = liked;
                    }

                    public int getCategory_id() {
                        return category_id;
                    }

                    public void setCategory_id(int category_id) {
                        this.category_id = category_id;
                    }

                    public int getMax_item_quantity() {
                        return max_item_quantity;
                    }

                    public void setMax_item_quantity(int max_item_quantity) {
                        this.max_item_quantity = max_item_quantity;
                    }

                    public String getPrice() {
                        return price;
                    }

                    public void setPrice(String price) {
                        this.price = price;
                    }

                    public int getProduct_id() {
                        return product_id;
                    }

                    public void setProduct_id(int product_id) {
                        this.product_id = product_id;
                    }

                    public boolean isSold_out() {
                        return sold_out;
                    }

                    public void setSold_out(boolean sold_out) {
                        this.sold_out = sold_out;
                    }

                    public int getVariant() {
                        return variant;
                    }

                    public void setVariant(int variant) {
                        this.variant = variant;
                    }

                    public String getFormatted_income() {
                        return formatted_income;
                    }

                    public void setFormatted_income(String formatted_income) {
                        this.formatted_income = formatted_income;
                    }

                    public String getMrp_price_line() {
                        return mrp_price_line;
                    }

                    public void setMrp_price_line(String mrp_price_line) {
                        this.mrp_price_line = mrp_price_line;
                    }

                    public boolean isCod_availability() {
                        return cod_availability;
                    }

                    public void setCod_availability(boolean cod_availability) {
                        this.cod_availability = cod_availability;
                    }

                    public String getFormatted_per_item_total() {
                        return formatted_per_item_total;
                    }

                    public void setFormatted_per_item_total(String formatted_per_item_total) {
                        this.formatted_per_item_total = formatted_per_item_total;
                    }

                    public int getPer_item_total() {
                        return per_item_total;
                    }

                    public void setPer_item_total(int per_item_total) {
                        this.per_item_total = per_item_total;
                    }

                    public String getSku() {
                        return sku;
                    }

                    public void setSku(String sku) {
                        this.sku = sku;
                    }

                    public DeliveryTimeMessageBeanX getDelivery_time_message() {
                        return delivery_time_message;
                    }

                    public void setDelivery_time_message(DeliveryTimeMessageBeanX delivery_time_message) {
                        this.delivery_time_message = delivery_time_message;
                    }

                    public String getPrepaid_message() {
                        return prepaid_message;
                    }

                    public void setPrepaid_message(String prepaid_message) {
                        this.prepaid_message = prepaid_message;
                    }

                    public ActivityObjectBeanXXX getActivity_object() {
                        return activity_object;
                    }

                    public void setActivity_object(ActivityObjectBeanXXX activity_object) {
                        this.activity_object = activity_object;
                    }

                    public String getImage() {
                        return image;
                    }

                    public void setImage(String image) {
                        this.image = image;
                    }

                    public int getQuantity() {
                        return quantity;
                    }

                    public void setQuantity(int quantity) {
                        this.quantity = quantity;
                    }

                    public int getMax_selling_price() {
                        return max_selling_price;
                    }

                    public void setMax_selling_price(int max_selling_price) {
                        this.max_selling_price = max_selling_price;
                    }

                    public int getOriginal_amo() {
                        return original_amo;
                    }

                    public void setOriginal_amo(int original_amo) {
                        this.original_amo = original_amo;
                    }

                    public int getVariant_price() {
                        return variant_price;
                    }

                    public void setVariant_price(int variant_price) {
                        this.variant_price = variant_price;
                    }

                    public int getFinal_discount() {
                        return final_discount;
                    }

                    public void setFinal_discount(int final_discount) {
                        this.final_discount = final_discount;
                    }

                    public String getFormatted_variant_price() {
                        return formatted_variant_price;
                    }

                    public void setFormatted_variant_price(String formatted_variant_price) {
                        this.formatted_variant_price = formatted_variant_price;
                    }

                    public String getPrice_line() {
                        return price_line;
                    }

                    public void setPrice_line(String price_line) {
                        this.price_line = price_line;
                    }

                    public String getProduct_name() {
                        return product_name;
                    }

                    public void setProduct_name(String product_name) {
                        this.product_name = product_name;
                    }

                    public String getSale_price() {
                        return sale_price;
                    }

                    public void setSale_price(String sale_price) {
                        this.sale_price = sale_price;
                    }

                    public Object getProduct_stamp() {
                        return product_stamp;
                    }

                    public void setProduct_stamp(Object product_stamp) {
                        this.product_stamp = product_stamp;
                    }

                    public String getZipcode() {
                        return zipcode;
                    }

                    public void setZipcode(String zipcode) {
                        this.zipcode = zipcode;
                    }

                    public String getFormatted_seller_price() {
                        return formatted_seller_price;
                    }

                    public void setFormatted_seller_price(String formatted_seller_price) {
                        this.formatted_seller_price = formatted_seller_price;
                    }

                    public String getFormatted_sale_price() {
                        return formatted_sale_price;
                    }

                    public void setFormatted_sale_price(String formatted_sale_price) {
                        this.formatted_sale_price = formatted_sale_price;
                    }

                    public String getSize() {
                        return size;
                    }

                    public void setSize(String size) {
                        this.size = size;
                    }

                    public int getMaster_product_id() {
                        return master_product_id;
                    }

                    public void setMaster_product_id(int master_product_id) {
                        this.master_product_id = master_product_id;
                    }

                    public int getMin_selling_price() {
                        return min_selling_price;
                    }

                    public void setMin_selling_price(int min_selling_price) {
                        this.min_selling_price = min_selling_price;
                    }

                    public String getCategory() {
                        return category;
                    }

                    public void setCategory(String category) {
                        this.category = category;
                    }

                    public String getPermalink() {
                        return permalink;
                    }

                    public void setPermalink(String permalink) {
                        this.permalink = permalink;
                    }

                    public String getCod_message() {
                        return cod_message;
                    }

                    public void setCod_message(String cod_message) {
                        this.cod_message = cod_message;
                    }

                    public List<VariantOptionsBeanX> getVariant_options() {
                        return variant_options;
                    }

                    public void setVariant_options(List<VariantOptionsBeanX> variant_options) {
                        this.variant_options = variant_options;
                    }

                    public List<?> getLine_item_adjustments() {
                        return line_item_adjustments;
                    }

                    public void setLine_item_adjustments(List<?> line_item_adjustments) {
                        this.line_item_adjustments = line_item_adjustments;
                    }

                    public List<MessagesBean> getMessages() {
                        return messages;
                    }

                    public void setMessages(List<MessagesBean> messages) {
                        this.messages = messages;
                    }

                    public static class DeliveryTimeMessageBeanX {
                        /**
                         * message : Delivery in 4-6 working days.
                         * type : 2
                         */

                        private String message;
                        private int type;

                        public String getMessage() {
                            return message;
                        }

                        public void setMessage(String message) {
                            this.message = message;
                        }

                        public int getType() {
                            return type;
                        }

                        public void setType(int type) {
                            this.type = type;
                        }
                    }

                    public static class ActivityObjectBeanXXX {
                        /**
                         * activity_object : {"id":"P65947"}
                         */

                        private ActivityObjectBeanXX activity_object;

                        public ActivityObjectBeanXX getActivity_object() {
                            return activity_object;
                        }

                        public void setActivity_object(ActivityObjectBeanXX activity_object) {
                            this.activity_object = activity_object;
                        }

                        public static class ActivityObjectBeanXX {
                            /**
                             * id : P65947
                             */

                            private String id;

                            public String getId() {
                                return id;
                            }

                            public void setId(String id) {
                                this.id = id;
                            }
                        }
                    }

                    public static class VariantOptionsBeanX {
                        /**
                         * count_on_hand : 1
                         * option_value_name : S
                         * size : 25
                         * corrected_count_on_hand : 1
                         * name : S
                         * id : 83723
                         */

                        private int count_on_hand;
                        private String option_value_name;
                        private int size;
                        private int corrected_count_on_hand;
                        private String name;
                        private int id;

                        public int getCount_on_hand() {
                            return count_on_hand;
                        }

                        public void setCount_on_hand(int count_on_hand) {
                            this.count_on_hand = count_on_hand;
                        }

                        public String getOption_value_name() {
                            return option_value_name;
                        }

                        public void setOption_value_name(String option_value_name) {
                            this.option_value_name = option_value_name;
                        }

                        public int getSize() {
                            return size;
                        }

                        public void setSize(int size) {
                            this.size = size;
                        }

                        public int getCorrected_count_on_hand() {
                            return corrected_count_on_hand;
                        }

                        public void setCorrected_count_on_hand(int corrected_count_on_hand) {
                            this.corrected_count_on_hand = corrected_count_on_hand;
                        }

                        public String getName() {
                            return name;
                        }

                        public void setName(String name) {
                            this.name = name;
                        }

                        public int getId() {
                            return id;
                        }

                        public void setId(int id) {
                            this.id = id;
                        }
                    }

                    public static class MessagesBean {
                        /**
                         * message : Last chance only 1 left!
                         * type : 1
                         */

                        private String message;
                        private int type;

                        public String getMessage() {
                            return message;
                        }

                        public void setMessage(String message) {
                            this.message = message;
                        }

                        public int getType() {
                            return type;
                        }

                        public void setType(int type) {
                            this.type = type;
                        }
                    }
                }
            }

            public static class SGMBean {
                /**
                 * adjustments : []
                 * subtotal : 825
                 * item_total : 825
                 * items : [{"formatted_price":"Tk. 825","seller":"SGM","min_order_qty":1,"line_item_id":297818,"discount":8,"prepaid_availability":true,"seller_slug":"sgm","delivery_time":"Delivery in 4-6 working days.","title":"Indian Chundri Silk Saree - 102 - SGM","liked":false,"category_id":48,"variant_options":[{"count_on_hand":5,"option_value_name":"option","size":25,"corrected_count_on_hand":3,"name":"option","id":55190}],"max_item_quantity":50,"price":"825.0","product_id":46543,"sold_out":false,"variant":55190,"formatted_income":"Tk. 75","mrp_price_line":"Tk. 900 x 1 = Tk. 900","cod_availability":true,"formatted_per_item_total":"Tk. 825","per_item_total":825,"sku":"286699","delivery_time_message":{"message":"Delivery in 4-6 working days.","type":2},"prepaid_message":"Delivery in 4-6 working days.","activity_object":{"activity_object":{"id":"P46543"}},"image":"https://shopimages.vstores.io/34564/1573991787793-102-small.jpg?1580160568","quantity":1,"max_selling_price":1147,"original_amo":900,"variant_price":750,"final_discount":8,"formatted_variant_price":"Tk. 750","price_line":"Tk. 825 x 1 = Tk. 825","product_name":"Indian Chundri Silk Saree - 102 - SGM","sale_price":"825.0","product_stamp":null,"zipcode":"7","formatted_seller_price":"Tk. 0","formatted_sale_price":"Tk. 825","size":"option","line_item_adjustments":[],"master_product_id":46543,"messages":[],"min_selling_price":825,"category":"Saree","permalink":"indian-chundri-silk-saree-102-sgm-18d1bc4e","cod_message":"Delivery in 4-6 working days."}]
                 */

                private int subtotal;
                private int item_total;
                private List<?> adjustments;
                private List<ItemsBeanXX> items;

                public int getSubtotal() {
                    return subtotal;
                }

                public void setSubtotal(int subtotal) {
                    this.subtotal = subtotal;
                }

                public int getItem_total() {
                    return item_total;
                }

                public void setItem_total(int item_total) {
                    this.item_total = item_total;
                }

                public List<?> getAdjustments() {
                    return adjustments;
                }

                public void setAdjustments(List<?> adjustments) {
                    this.adjustments = adjustments;
                }

                public List<ItemsBeanXX> getItems() {
                    return items;
                }

                public void setItems(List<ItemsBeanXX> items) {
                    this.items = items;
                }

                public static class ItemsBeanXX {
                    /**
                     * formatted_price : Tk. 825
                     * seller : SGM
                     * min_order_qty : 1
                     * line_item_id : 297818
                     * discount : 8
                     * prepaid_availability : true
                     * seller_slug : sgm
                     * delivery_time : Delivery in 4-6 working days.
                     * title : Indian Chundri Silk Saree - 102 - SGM
                     * liked : false
                     * category_id : 48
                     * variant_options : [{"count_on_hand":5,"option_value_name":"option","size":25,"corrected_count_on_hand":3,"name":"option","id":55190}]
                     * max_item_quantity : 50
                     * price : 825.0
                     * product_id : 46543
                     * sold_out : false
                     * variant : 55190
                     * formatted_income : Tk. 75
                     * mrp_price_line : Tk. 900 x 1 = Tk. 900
                     * cod_availability : true
                     * formatted_per_item_total : Tk. 825
                     * per_item_total : 825
                     * sku : 286699
                     * delivery_time_message : {"message":"Delivery in 4-6 working days.","type":2}
                     * prepaid_message : Delivery in 4-6 working days.
                     * activity_object : {"activity_object":{"id":"P46543"}}
                     * image : https://shopimages.vstores.io/34564/1573991787793-102-small.jpg?1580160568
                     * quantity : 1
                     * max_selling_price : 1147
                     * original_amo : 900
                     * variant_price : 750
                     * final_discount : 8
                     * formatted_variant_price : Tk. 750
                     * price_line : Tk. 825 x 1 = Tk. 825
                     * product_name : Indian Chundri Silk Saree - 102 - SGM
                     * sale_price : 825.0
                     * product_stamp : null
                     * zipcode : 7
                     * formatted_seller_price : Tk. 0
                     * formatted_sale_price : Tk. 825
                     * size : option
                     * line_item_adjustments : []
                     * master_product_id : 46543
                     * messages : []
                     * min_selling_price : 825
                     * category : Saree
                     * permalink : indian-chundri-silk-saree-102-sgm-18d1bc4e
                     * cod_message : Delivery in 4-6 working days.
                     */

                    private String formatted_price;
                    private String seller;
                    private int min_order_qty;
                    private int line_item_id;
                    private int discount;
                    private boolean prepaid_availability;
                    private String seller_slug;
                    private String delivery_time;
                    private String title;
                    private boolean liked;
                    private int category_id;
                    private int max_item_quantity;
                    private String price;
                    private int product_id;
                    private boolean sold_out;
                    private int variant;
                    private String formatted_income;
                    private String mrp_price_line;
                    private boolean cod_availability;
                    private String formatted_per_item_total;
                    private int per_item_total;
                    private String sku;
                    private DeliveryTimeMessageBeanXX delivery_time_message;
                    private String prepaid_message;
                    private ActivityObjectBeanXXXXX activity_object;
                    private String image;
                    private int quantity;
                    private int max_selling_price;
                    private int original_amo;
                    private int variant_price;
                    private int final_discount;
                    private String formatted_variant_price;
                    private String price_line;
                    private String product_name;
                    private String sale_price;
                    private Object product_stamp;
                    private String zipcode;
                    private String formatted_seller_price;
                    private String formatted_sale_price;
                    private String size;
                    private int master_product_id;
                    private int min_selling_price;
                    private String category;
                    private String permalink;
                    private String cod_message;
                    private List<VariantOptionsBeanXX> variant_options;
                    private List<?> line_item_adjustments;
                    private List<?> messages;

                    public String getFormatted_price() {
                        return formatted_price;
                    }

                    public void setFormatted_price(String formatted_price) {
                        this.formatted_price = formatted_price;
                    }

                    public String getSeller() {
                        return seller;
                    }

                    public void setSeller(String seller) {
                        this.seller = seller;
                    }

                    public int getMin_order_qty() {
                        return min_order_qty;
                    }

                    public void setMin_order_qty(int min_order_qty) {
                        this.min_order_qty = min_order_qty;
                    }

                    public int getLine_item_id() {
                        return line_item_id;
                    }

                    public void setLine_item_id(int line_item_id) {
                        this.line_item_id = line_item_id;
                    }

                    public int getDiscount() {
                        return discount;
                    }

                    public void setDiscount(int discount) {
                        this.discount = discount;
                    }

                    public boolean isPrepaid_availability() {
                        return prepaid_availability;
                    }

                    public void setPrepaid_availability(boolean prepaid_availability) {
                        this.prepaid_availability = prepaid_availability;
                    }

                    public String getSeller_slug() {
                        return seller_slug;
                    }

                    public void setSeller_slug(String seller_slug) {
                        this.seller_slug = seller_slug;
                    }

                    public String getDelivery_time() {
                        return delivery_time;
                    }

                    public void setDelivery_time(String delivery_time) {
                        this.delivery_time = delivery_time;
                    }

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public boolean isLiked() {
                        return liked;
                    }

                    public void setLiked(boolean liked) {
                        this.liked = liked;
                    }

                    public int getCategory_id() {
                        return category_id;
                    }

                    public void setCategory_id(int category_id) {
                        this.category_id = category_id;
                    }

                    public int getMax_item_quantity() {
                        return max_item_quantity;
                    }

                    public void setMax_item_quantity(int max_item_quantity) {
                        this.max_item_quantity = max_item_quantity;
                    }

                    public String getPrice() {
                        return price;
                    }

                    public void setPrice(String price) {
                        this.price = price;
                    }

                    public int getProduct_id() {
                        return product_id;
                    }

                    public void setProduct_id(int product_id) {
                        this.product_id = product_id;
                    }

                    public boolean isSold_out() {
                        return sold_out;
                    }

                    public void setSold_out(boolean sold_out) {
                        this.sold_out = sold_out;
                    }

                    public int getVariant() {
                        return variant;
                    }

                    public void setVariant(int variant) {
                        this.variant = variant;
                    }

                    public String getFormatted_income() {
                        return formatted_income;
                    }

                    public void setFormatted_income(String formatted_income) {
                        this.formatted_income = formatted_income;
                    }

                    public String getMrp_price_line() {
                        return mrp_price_line;
                    }

                    public void setMrp_price_line(String mrp_price_line) {
                        this.mrp_price_line = mrp_price_line;
                    }

                    public boolean isCod_availability() {
                        return cod_availability;
                    }

                    public void setCod_availability(boolean cod_availability) {
                        this.cod_availability = cod_availability;
                    }

                    public String getFormatted_per_item_total() {
                        return formatted_per_item_total;
                    }

                    public void setFormatted_per_item_total(String formatted_per_item_total) {
                        this.formatted_per_item_total = formatted_per_item_total;
                    }

                    public int getPer_item_total() {
                        return per_item_total;
                    }

                    public void setPer_item_total(int per_item_total) {
                        this.per_item_total = per_item_total;
                    }

                    public String getSku() {
                        return sku;
                    }

                    public void setSku(String sku) {
                        this.sku = sku;
                    }

                    public DeliveryTimeMessageBeanXX getDelivery_time_message() {
                        return delivery_time_message;
                    }

                    public void setDelivery_time_message(DeliveryTimeMessageBeanXX delivery_time_message) {
                        this.delivery_time_message = delivery_time_message;
                    }

                    public String getPrepaid_message() {
                        return prepaid_message;
                    }

                    public void setPrepaid_message(String prepaid_message) {
                        this.prepaid_message = prepaid_message;
                    }

                    public ActivityObjectBeanXXXXX getActivity_object() {
                        return activity_object;
                    }

                    public void setActivity_object(ActivityObjectBeanXXXXX activity_object) {
                        this.activity_object = activity_object;
                    }

                    public String getImage() {
                        return image;
                    }

                    public void setImage(String image) {
                        this.image = image;
                    }

                    public int getQuantity() {
                        return quantity;
                    }

                    public void setQuantity(int quantity) {
                        this.quantity = quantity;
                    }

                    public int getMax_selling_price() {
                        return max_selling_price;
                    }

                    public void setMax_selling_price(int max_selling_price) {
                        this.max_selling_price = max_selling_price;
                    }

                    public int getOriginal_amo() {
                        return original_amo;
                    }

                    public void setOriginal_amo(int original_amo) {
                        this.original_amo = original_amo;
                    }

                    public int getVariant_price() {
                        return variant_price;
                    }

                    public void setVariant_price(int variant_price) {
                        this.variant_price = variant_price;
                    }

                    public int getFinal_discount() {
                        return final_discount;
                    }

                    public void setFinal_discount(int final_discount) {
                        this.final_discount = final_discount;
                    }

                    public String getFormatted_variant_price() {
                        return formatted_variant_price;
                    }

                    public void setFormatted_variant_price(String formatted_variant_price) {
                        this.formatted_variant_price = formatted_variant_price;
                    }

                    public String getPrice_line() {
                        return price_line;
                    }

                    public void setPrice_line(String price_line) {
                        this.price_line = price_line;
                    }

                    public String getProduct_name() {
                        return product_name;
                    }

                    public void setProduct_name(String product_name) {
                        this.product_name = product_name;
                    }

                    public String getSale_price() {
                        return sale_price;
                    }

                    public void setSale_price(String sale_price) {
                        this.sale_price = sale_price;
                    }

                    public Object getProduct_stamp() {
                        return product_stamp;
                    }

                    public void setProduct_stamp(Object product_stamp) {
                        this.product_stamp = product_stamp;
                    }

                    public String getZipcode() {
                        return zipcode;
                    }

                    public void setZipcode(String zipcode) {
                        this.zipcode = zipcode;
                    }

                    public String getFormatted_seller_price() {
                        return formatted_seller_price;
                    }

                    public void setFormatted_seller_price(String formatted_seller_price) {
                        this.formatted_seller_price = formatted_seller_price;
                    }

                    public String getFormatted_sale_price() {
                        return formatted_sale_price;
                    }

                    public void setFormatted_sale_price(String formatted_sale_price) {
                        this.formatted_sale_price = formatted_sale_price;
                    }

                    public String getSize() {
                        return size;
                    }

                    public void setSize(String size) {
                        this.size = size;
                    }

                    public int getMaster_product_id() {
                        return master_product_id;
                    }

                    public void setMaster_product_id(int master_product_id) {
                        this.master_product_id = master_product_id;
                    }

                    public int getMin_selling_price() {
                        return min_selling_price;
                    }

                    public void setMin_selling_price(int min_selling_price) {
                        this.min_selling_price = min_selling_price;
                    }

                    public String getCategory() {
                        return category;
                    }

                    public void setCategory(String category) {
                        this.category = category;
                    }

                    public String getPermalink() {
                        return permalink;
                    }

                    public void setPermalink(String permalink) {
                        this.permalink = permalink;
                    }

                    public String getCod_message() {
                        return cod_message;
                    }

                    public void setCod_message(String cod_message) {
                        this.cod_message = cod_message;
                    }

                    public List<VariantOptionsBeanXX> getVariant_options() {
                        return variant_options;
                    }

                    public void setVariant_options(List<VariantOptionsBeanXX> variant_options) {
                        this.variant_options = variant_options;
                    }

                    public List<?> getLine_item_adjustments() {
                        return line_item_adjustments;
                    }

                    public void setLine_item_adjustments(List<?> line_item_adjustments) {
                        this.line_item_adjustments = line_item_adjustments;
                    }

                    public List<?> getMessages() {
                        return messages;
                    }

                    public void setMessages(List<?> messages) {
                        this.messages = messages;
                    }

                    public static class DeliveryTimeMessageBeanXX {
                        /**
                         * message : Delivery in 4-6 working days.
                         * type : 2
                         */

                        private String message;
                        private int type;

                        public String getMessage() {
                            return message;
                        }

                        public void setMessage(String message) {
                            this.message = message;
                        }

                        public int getType() {
                            return type;
                        }

                        public void setType(int type) {
                            this.type = type;
                        }
                    }

                    public static class ActivityObjectBeanXXXXX {
                        /**
                         * activity_object : {"id":"P46543"}
                         */

                        private ActivityObjectBeanXXXX activity_object;

                        public ActivityObjectBeanXXXX getActivity_object() {
                            return activity_object;
                        }

                        public void setActivity_object(ActivityObjectBeanXXXX activity_object) {
                            this.activity_object = activity_object;
                        }

                        public static class ActivityObjectBeanXXXX {
                            /**
                             * id : P46543
                             */

                            private String id;

                            public String getId() {
                                return id;
                            }

                            public void setId(String id) {
                                this.id = id;
                            }
                        }
                    }

                    public static class VariantOptionsBeanXX {
                        /**
                         * count_on_hand : 5
                         * option_value_name : option
                         * size : 25
                         * corrected_count_on_hand : 3
                         * name : option
                         * id : 55190
                         */

                        private int count_on_hand;
                        private String option_value_name;
                        private int size;
                        private int corrected_count_on_hand;
                        private String name;
                        private int id;

                        public int getCount_on_hand() {
                            return count_on_hand;
                        }

                        public void setCount_on_hand(int count_on_hand) {
                            this.count_on_hand = count_on_hand;
                        }

                        public String getOption_value_name() {
                            return option_value_name;
                        }

                        public void setOption_value_name(String option_value_name) {
                            this.option_value_name = option_value_name;
                        }

                        public int getSize() {
                            return size;
                        }

                        public void setSize(int size) {
                            this.size = size;
                        }

                        public int getCorrected_count_on_hand() {
                            return corrected_count_on_hand;
                        }

                        public void setCorrected_count_on_hand(int corrected_count_on_hand) {
                            this.corrected_count_on_hand = corrected_count_on_hand;
                        }

                        public String getName() {
                            return name;
                        }

                        public void setName(String name) {
                            this.name = name;
                        }

                        public int getId() {
                            return id;
                        }

                        public void setId(int id) {
                            this.id = id;
                        }
                    }
                }
            }

            public static class RKTBean {
                /**
                 * adjustments : []
                 * subtotal : 2408
                 * item_total : 2408
                 * items : [{"formatted_price":"Tk. 2,408","seller":"RKT","min_order_qty":1,"line_item_id":297819,"discount":11,"prepaid_availability":true,"seller_slug":"rkt","delivery_time":"Delivery in 4-6 working days.","title":"Indian Julahaa Katan Saree - 12 - RKT","liked":false,"category_id":48,"variant_options":[{"count_on_hand":1,"option_value_name":"option","size":25,"corrected_count_on_hand":1,"name":"option","id":29584}],"max_item_quantity":50,"price":"2408.0","product_id":24709,"sold_out":false,"variant":29584,"formatted_income":"Tk. 158","mrp_price_line":"Tk. 2,720 x 1 = Tk. 2,720","cod_availability":true,"formatted_per_item_total":"Tk. 2,408","per_item_total":2408,"sku":"308465","delivery_time_message":{"message":"Delivery in 4-6 working days.","type":2},"prepaid_message":"Delivery in 4-6 working days.","activity_object":{"activity_object":{"id":"P24709"}},"image":"https://shopimages.vstores.io/90742/1577091355687-whatsappimage2019-12-15at00.00.271-small.jpeg?1580126997","quantity":1,"max_selling_price":2992,"original_amo":2720,"variant_price":2250,"final_discount":11,"formatted_variant_price":"Tk. 2,250","price_line":"Tk. 2,408 x 1 = Tk. 2,408","product_name":"Indian Julahaa Katan Saree - 12 - RKT","sale_price":"2408.0","product_stamp":null,"zipcode":"7","formatted_seller_price":"Tk. 0","formatted_sale_price":"Tk. 2,408","size":"option","line_item_adjustments":[],"master_product_id":24709,"messages":[{"message":"Last chance only 1 left!","type":1}],"min_selling_price":2408,"category":"Saree","permalink":"indian-julahaa-katan-saree-12-rkt-a2eeac01","cod_message":"Delivery in 4-6 working days."}]
                 */

                private int subtotal;
                private int item_total;
                private List<?> adjustments;
                private List<ItemsBeanXXX> items;

                public int getSubtotal() {
                    return subtotal;
                }

                public void setSubtotal(int subtotal) {
                    this.subtotal = subtotal;
                }

                public int getItem_total() {
                    return item_total;
                }

                public void setItem_total(int item_total) {
                    this.item_total = item_total;
                }

                public List<?> getAdjustments() {
                    return adjustments;
                }

                public void setAdjustments(List<?> adjustments) {
                    this.adjustments = adjustments;
                }

                public List<ItemsBeanXXX> getItems() {
                    return items;
                }

                public void setItems(List<ItemsBeanXXX> items) {
                    this.items = items;
                }

                public static class ItemsBeanXXX {
                    /**
                     * formatted_price : Tk. 2,408
                     * seller : RKT
                     * min_order_qty : 1
                     * line_item_id : 297819
                     * discount : 11
                     * prepaid_availability : true
                     * seller_slug : rkt
                     * delivery_time : Delivery in 4-6 working days.
                     * title : Indian Julahaa Katan Saree - 12 - RKT
                     * liked : false
                     * category_id : 48
                     * variant_options : [{"count_on_hand":1,"option_value_name":"option","size":25,"corrected_count_on_hand":1,"name":"option","id":29584}]
                     * max_item_quantity : 50
                     * price : 2408.0
                     * product_id : 24709
                     * sold_out : false
                     * variant : 29584
                     * formatted_income : Tk. 158
                     * mrp_price_line : Tk. 2,720 x 1 = Tk. 2,720
                     * cod_availability : true
                     * formatted_per_item_total : Tk. 2,408
                     * per_item_total : 2408
                     * sku : 308465
                     * delivery_time_message : {"message":"Delivery in 4-6 working days.","type":2}
                     * prepaid_message : Delivery in 4-6 working days.
                     * activity_object : {"activity_object":{"id":"P24709"}}
                     * image : https://shopimages.vstores.io/90742/1577091355687-whatsappimage2019-12-15at00.00.271-small.jpeg?1580126997
                     * quantity : 1
                     * max_selling_price : 2992
                     * original_amo : 2720
                     * variant_price : 2250
                     * final_discount : 11
                     * formatted_variant_price : Tk. 2,250
                     * price_line : Tk. 2,408 x 1 = Tk. 2,408
                     * product_name : Indian Julahaa Katan Saree - 12 - RKT
                     * sale_price : 2408.0
                     * product_stamp : null
                     * zipcode : 7
                     * formatted_seller_price : Tk. 0
                     * formatted_sale_price : Tk. 2,408
                     * size : option
                     * line_item_adjustments : []
                     * master_product_id : 24709
                     * messages : [{"message":"Last chance only 1 left!","type":1}]
                     * min_selling_price : 2408
                     * category : Saree
                     * permalink : indian-julahaa-katan-saree-12-rkt-a2eeac01
                     * cod_message : Delivery in 4-6 working days.
                     */

                    private String formatted_price;
                    private String seller;
                    private int min_order_qty;
                    private int line_item_id;
                    private int discount;
                    private boolean prepaid_availability;
                    private String seller_slug;
                    private String delivery_time;
                    private String title;
                    private boolean liked;
                    private int category_id;
                    private int max_item_quantity;
                    private String price;
                    private int product_id;
                    private boolean sold_out;
                    private int variant;
                    private String formatted_income;
                    private String mrp_price_line;
                    private boolean cod_availability;
                    private String formatted_per_item_total;
                    private int per_item_total;
                    private String sku;
                    private DeliveryTimeMessageBeanXXX delivery_time_message;
                    private String prepaid_message;
                    private ActivityObjectBeanXXXXXXX activity_object;
                    private String image;
                    private int quantity;
                    private int max_selling_price;
                    private int original_amo;
                    private int variant_price;
                    private int final_discount;
                    private String formatted_variant_price;
                    private String price_line;
                    private String product_name;
                    private String sale_price;
                    private Object product_stamp;
                    private String zipcode;
                    private String formatted_seller_price;
                    private String formatted_sale_price;
                    private String size;
                    private int master_product_id;
                    private int min_selling_price;
                    private String category;
                    private String permalink;
                    private String cod_message;
                    private List<VariantOptionsBeanXXX> variant_options;
                    private List<?> line_item_adjustments;
                    private List<MessagesBeanX> messages;

                    public String getFormatted_price() {
                        return formatted_price;
                    }

                    public void setFormatted_price(String formatted_price) {
                        this.formatted_price = formatted_price;
                    }

                    public String getSeller() {
                        return seller;
                    }

                    public void setSeller(String seller) {
                        this.seller = seller;
                    }

                    public int getMin_order_qty() {
                        return min_order_qty;
                    }

                    public void setMin_order_qty(int min_order_qty) {
                        this.min_order_qty = min_order_qty;
                    }

                    public int getLine_item_id() {
                        return line_item_id;
                    }

                    public void setLine_item_id(int line_item_id) {
                        this.line_item_id = line_item_id;
                    }

                    public int getDiscount() {
                        return discount;
                    }

                    public void setDiscount(int discount) {
                        this.discount = discount;
                    }

                    public boolean isPrepaid_availability() {
                        return prepaid_availability;
                    }

                    public void setPrepaid_availability(boolean prepaid_availability) {
                        this.prepaid_availability = prepaid_availability;
                    }

                    public String getSeller_slug() {
                        return seller_slug;
                    }

                    public void setSeller_slug(String seller_slug) {
                        this.seller_slug = seller_slug;
                    }

                    public String getDelivery_time() {
                        return delivery_time;
                    }

                    public void setDelivery_time(String delivery_time) {
                        this.delivery_time = delivery_time;
                    }

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public boolean isLiked() {
                        return liked;
                    }

                    public void setLiked(boolean liked) {
                        this.liked = liked;
                    }

                    public int getCategory_id() {
                        return category_id;
                    }

                    public void setCategory_id(int category_id) {
                        this.category_id = category_id;
                    }

                    public int getMax_item_quantity() {
                        return max_item_quantity;
                    }

                    public void setMax_item_quantity(int max_item_quantity) {
                        this.max_item_quantity = max_item_quantity;
                    }

                    public String getPrice() {
                        return price;
                    }

                    public void setPrice(String price) {
                        this.price = price;
                    }

                    public int getProduct_id() {
                        return product_id;
                    }

                    public void setProduct_id(int product_id) {
                        this.product_id = product_id;
                    }

                    public boolean isSold_out() {
                        return sold_out;
                    }

                    public void setSold_out(boolean sold_out) {
                        this.sold_out = sold_out;
                    }

                    public int getVariant() {
                        return variant;
                    }

                    public void setVariant(int variant) {
                        this.variant = variant;
                    }

                    public String getFormatted_income() {
                        return formatted_income;
                    }

                    public void setFormatted_income(String formatted_income) {
                        this.formatted_income = formatted_income;
                    }

                    public String getMrp_price_line() {
                        return mrp_price_line;
                    }

                    public void setMrp_price_line(String mrp_price_line) {
                        this.mrp_price_line = mrp_price_line;
                    }

                    public boolean isCod_availability() {
                        return cod_availability;
                    }

                    public void setCod_availability(boolean cod_availability) {
                        this.cod_availability = cod_availability;
                    }

                    public String getFormatted_per_item_total() {
                        return formatted_per_item_total;
                    }

                    public void setFormatted_per_item_total(String formatted_per_item_total) {
                        this.formatted_per_item_total = formatted_per_item_total;
                    }

                    public int getPer_item_total() {
                        return per_item_total;
                    }

                    public void setPer_item_total(int per_item_total) {
                        this.per_item_total = per_item_total;
                    }

                    public String getSku() {
                        return sku;
                    }

                    public void setSku(String sku) {
                        this.sku = sku;
                    }

                    public DeliveryTimeMessageBeanXXX getDelivery_time_message() {
                        return delivery_time_message;
                    }

                    public void setDelivery_time_message(DeliveryTimeMessageBeanXXX delivery_time_message) {
                        this.delivery_time_message = delivery_time_message;
                    }

                    public String getPrepaid_message() {
                        return prepaid_message;
                    }

                    public void setPrepaid_message(String prepaid_message) {
                        this.prepaid_message = prepaid_message;
                    }

                    public ActivityObjectBeanXXXXXXX getActivity_object() {
                        return activity_object;
                    }

                    public void setActivity_object(ActivityObjectBeanXXXXXXX activity_object) {
                        this.activity_object = activity_object;
                    }

                    public String getImage() {
                        return image;
                    }

                    public void setImage(String image) {
                        this.image = image;
                    }

                    public int getQuantity() {
                        return quantity;
                    }

                    public void setQuantity(int quantity) {
                        this.quantity = quantity;
                    }

                    public int getMax_selling_price() {
                        return max_selling_price;
                    }

                    public void setMax_selling_price(int max_selling_price) {
                        this.max_selling_price = max_selling_price;
                    }

                    public int getOriginal_amo() {
                        return original_amo;
                    }

                    public void setOriginal_amo(int original_amo) {
                        this.original_amo = original_amo;
                    }

                    public int getVariant_price() {
                        return variant_price;
                    }

                    public void setVariant_price(int variant_price) {
                        this.variant_price = variant_price;
                    }

                    public int getFinal_discount() {
                        return final_discount;
                    }

                    public void setFinal_discount(int final_discount) {
                        this.final_discount = final_discount;
                    }

                    public String getFormatted_variant_price() {
                        return formatted_variant_price;
                    }

                    public void setFormatted_variant_price(String formatted_variant_price) {
                        this.formatted_variant_price = formatted_variant_price;
                    }

                    public String getPrice_line() {
                        return price_line;
                    }

                    public void setPrice_line(String price_line) {
                        this.price_line = price_line;
                    }

                    public String getProduct_name() {
                        return product_name;
                    }

                    public void setProduct_name(String product_name) {
                        this.product_name = product_name;
                    }

                    public String getSale_price() {
                        return sale_price;
                    }

                    public void setSale_price(String sale_price) {
                        this.sale_price = sale_price;
                    }

                    public Object getProduct_stamp() {
                        return product_stamp;
                    }

                    public void setProduct_stamp(Object product_stamp) {
                        this.product_stamp = product_stamp;
                    }

                    public String getZipcode() {
                        return zipcode;
                    }

                    public void setZipcode(String zipcode) {
                        this.zipcode = zipcode;
                    }

                    public String getFormatted_seller_price() {
                        return formatted_seller_price;
                    }

                    public void setFormatted_seller_price(String formatted_seller_price) {
                        this.formatted_seller_price = formatted_seller_price;
                    }

                    public String getFormatted_sale_price() {
                        return formatted_sale_price;
                    }

                    public void setFormatted_sale_price(String formatted_sale_price) {
                        this.formatted_sale_price = formatted_sale_price;
                    }

                    public String getSize() {
                        return size;
                    }

                    public void setSize(String size) {
                        this.size = size;
                    }

                    public int getMaster_product_id() {
                        return master_product_id;
                    }

                    public void setMaster_product_id(int master_product_id) {
                        this.master_product_id = master_product_id;
                    }

                    public int getMin_selling_price() {
                        return min_selling_price;
                    }

                    public void setMin_selling_price(int min_selling_price) {
                        this.min_selling_price = min_selling_price;
                    }

                    public String getCategory() {
                        return category;
                    }

                    public void setCategory(String category) {
                        this.category = category;
                    }

                    public String getPermalink() {
                        return permalink;
                    }

                    public void setPermalink(String permalink) {
                        this.permalink = permalink;
                    }

                    public String getCod_message() {
                        return cod_message;
                    }

                    public void setCod_message(String cod_message) {
                        this.cod_message = cod_message;
                    }

                    public List<VariantOptionsBeanXXX> getVariant_options() {
                        return variant_options;
                    }

                    public void setVariant_options(List<VariantOptionsBeanXXX> variant_options) {
                        this.variant_options = variant_options;
                    }

                    public List<?> getLine_item_adjustments() {
                        return line_item_adjustments;
                    }

                    public void setLine_item_adjustments(List<?> line_item_adjustments) {
                        this.line_item_adjustments = line_item_adjustments;
                    }

                    public List<MessagesBeanX> getMessages() {
                        return messages;
                    }

                    public void setMessages(List<MessagesBeanX> messages) {
                        this.messages = messages;
                    }

                    public static class DeliveryTimeMessageBeanXXX {
                        /**
                         * message : Delivery in 4-6 working days.
                         * type : 2
                         */

                        private String message;
                        private int type;

                        public String getMessage() {
                            return message;
                        }

                        public void setMessage(String message) {
                            this.message = message;
                        }

                        public int getType() {
                            return type;
                        }

                        public void setType(int type) {
                            this.type = type;
                        }
                    }

                    public static class ActivityObjectBeanXXXXXXX {
                        /**
                         * activity_object : {"id":"P24709"}
                         */

                        private ActivityObjectBeanXXXXXX activity_object;

                        public ActivityObjectBeanXXXXXX getActivity_object() {
                            return activity_object;
                        }

                        public void setActivity_object(ActivityObjectBeanXXXXXX activity_object) {
                            this.activity_object = activity_object;
                        }

                        public static class ActivityObjectBeanXXXXXX {
                            /**
                             * id : P24709
                             */

                            private String id;

                            public String getId() {
                                return id;
                            }

                            public void setId(String id) {
                                this.id = id;
                            }
                        }
                    }

                    public static class VariantOptionsBeanXXX {
                        /**
                         * count_on_hand : 1
                         * option_value_name : option
                         * size : 25
                         * corrected_count_on_hand : 1
                         * name : option
                         * id : 29584
                         */

                        private int count_on_hand;
                        private String option_value_name;
                        private int size;
                        private int corrected_count_on_hand;
                        private String name;
                        private int id;

                        public int getCount_on_hand() {
                            return count_on_hand;
                        }

                        public void setCount_on_hand(int count_on_hand) {
                            this.count_on_hand = count_on_hand;
                        }

                        public String getOption_value_name() {
                            return option_value_name;
                        }

                        public void setOption_value_name(String option_value_name) {
                            this.option_value_name = option_value_name;
                        }

                        public int getSize() {
                            return size;
                        }

                        public void setSize(int size) {
                            this.size = size;
                        }

                        public int getCorrected_count_on_hand() {
                            return corrected_count_on_hand;
                        }

                        public void setCorrected_count_on_hand(int corrected_count_on_hand) {
                            this.corrected_count_on_hand = corrected_count_on_hand;
                        }

                        public String getName() {
                            return name;
                        }

                        public void setName(String name) {
                            this.name = name;
                        }

                        public int getId() {
                            return id;
                        }

                        public void setId(int id) {
                            this.id = id;
                        }
                    }

                    public static class MessagesBeanX {
                        /**
                         * message : Last chance only 1 left!
                         * type : 1
                         */

                        private String message;
                        private int type;

                        public String getMessage() {
                            return message;
                        }

                        public void setMessage(String message) {
                            this.message = message;
                        }

                        public int getType() {
                            return type;
                        }

                        public void setType(int type) {
                            this.type = type;
                        }
                    }
                }
            }

            public static class UPFBean {
                /**
                 * adjustments : []
                 * subtotal : 763
                 * item_total : 763
                 * items : [{"formatted_price":"Tk. 423","seller":"UPF","min_order_qty":1,"line_item_id":297861,"discount":0,"prepaid_availability":true,"seller_slug":"upf","delivery_time":"Delivery in 4-6 working days.","title":"Casual Shirt For Men Olive - UPF","liked":false,"category_id":1118,"variant_options":[{"count_on_hand":19,"option_value_name":"M","size":25,"corrected_count_on_hand":3,"name":"M","id":93380},{"count_on_hand":14,"option_value_name":"L","size":25,"corrected_count_on_hand":3,"name":"L","id":93381},{"count_on_hand":29,"option_value_name":"XL","size":25,"corrected_count_on_hand":3,"name":"XL","id":93382}],"max_item_quantity":50,"price":"423.0","product_id":71943,"sold_out":false,"variant":93380,"formatted_income":"Tk. 68","mrp_price_line":"Tk. 384 x 1 = Tk. 384","cod_availability":true,"formatted_per_item_total":"Tk. 423","per_item_total":423,"sku":"264086","delivery_time_message":{"message":"Delivery in 4-6 working days.","type":2},"prepaid_message":"Delivery in 4-6 working days.","activity_object":{"activity_object":{"id":"P71943"}},"image":"https://shopimages.vstores.io/75917/1569929603861-32-small.jpg?1580465725","quantity":1,"max_selling_price":667,"original_amo":384,"variant_price":355,"final_discount":0,"formatted_variant_price":"Tk. 355","price_line":"Tk. 423 x 1 = Tk. 423","product_name":"Casual Shirt For Men Olive - UPF","sale_price":"423.0","product_stamp":null,"zipcode":"7","formatted_seller_price":"Tk. 0","formatted_sale_price":"Tk. 423","size":"M","line_item_adjustments":[],"master_product_id":71943,"messages":[],"min_selling_price":423,"category":"Men shirt","permalink":"casual-shirt-for-men-olive-upf-9fad7110","cod_message":"Delivery in 4-6 working days."},{"formatted_price":"Tk. 340","seller":"UPF","min_order_qty":1,"line_item_id":297860,"discount":1,"prepaid_availability":true,"seller_slug":"upf","delivery_time":"Delivery in 4-6 working days.","title":"Navy Blue Sleeve Casual Shirt for Men - UPF","liked":false,"category_id":1118,"variant_options":[{"count_on_hand":27,"option_value_name":"M","size":25,"corrected_count_on_hand":3,"name":"M","id":82512},{"count_on_hand":22,"option_value_name":"L","size":25,"corrected_count_on_hand":3,"name":"L","id":82513},{"count_on_hand":30,"option_value_name":"XL","size":25,"corrected_count_on_hand":3,"name":"XL","id":82514}],"max_item_quantity":50,"price":"340.0","product_id":65251,"sold_out":false,"variant":82512,"formatted_income":"Tk. 50","mrp_price_line":"Tk. 345 x 1 = Tk. 345","cod_availability":true,"formatted_per_item_total":"Tk. 340","per_item_total":340,"sku":"264038","delivery_time_message":{"message":"Delivery in 4-6 working days.","type":2},"prepaid_message":"Delivery in 4-6 working days.","activity_object":{"activity_object":{"id":"P65251"}},"image":"https://shopimages.vstores.io/15256/1569927970391-19-small.jpg?1580192775","quantity":1,"max_selling_price":530,"original_amo":345,"variant_price":290,"final_discount":1,"formatted_variant_price":"Tk. 290","price_line":"Tk. 340 x 1 = Tk. 340","product_name":"Navy Blue Sleeve Casual Shirt for Men - UPF","sale_price":"340.0","product_stamp":null,"zipcode":"7","formatted_seller_price":"Tk. 0","formatted_sale_price":"Tk. 340","size":"M","line_item_adjustments":[],"master_product_id":65251,"messages":[],"min_selling_price":340,"category":"Men shirt","permalink":"navy-blue-sleeve-casual-shirt-for-men-upf-290decb7","cod_message":"Delivery in 4-6 working days."}]
                 */

                private int subtotal;
                private int item_total;
                private List<?> adjustments;
                private List<ItemsBeanXXXX> items;

                public int getSubtotal() {
                    return subtotal;
                }

                public void setSubtotal(int subtotal) {
                    this.subtotal = subtotal;
                }

                public int getItem_total() {
                    return item_total;
                }

                public void setItem_total(int item_total) {
                    this.item_total = item_total;
                }

                public List<?> getAdjustments() {
                    return adjustments;
                }

                public void setAdjustments(List<?> adjustments) {
                    this.adjustments = adjustments;
                }

                public List<ItemsBeanXXXX> getItems() {
                    return items;
                }

                public void setItems(List<ItemsBeanXXXX> items) {
                    this.items = items;
                }

                public static class ItemsBeanXXXX {
                    /**
                     * formatted_price : Tk. 423
                     * seller : UPF
                     * min_order_qty : 1
                     * line_item_id : 297861
                     * discount : 0
                     * prepaid_availability : true
                     * seller_slug : upf
                     * delivery_time : Delivery in 4-6 working days.
                     * title : Casual Shirt For Men Olive - UPF
                     * liked : false
                     * category_id : 1118
                     * variant_options : [{"count_on_hand":19,"option_value_name":"M","size":25,"corrected_count_on_hand":3,"name":"M","id":93380},{"count_on_hand":14,"option_value_name":"L","size":25,"corrected_count_on_hand":3,"name":"L","id":93381},{"count_on_hand":29,"option_value_name":"XL","size":25,"corrected_count_on_hand":3,"name":"XL","id":93382}]
                     * max_item_quantity : 50
                     * price : 423.0
                     * product_id : 71943
                     * sold_out : false
                     * variant : 93380
                     * formatted_income : Tk. 68
                     * mrp_price_line : Tk. 384 x 1 = Tk. 384
                     * cod_availability : true
                     * formatted_per_item_total : Tk. 423
                     * per_item_total : 423
                     * sku : 264086
                     * delivery_time_message : {"message":"Delivery in 4-6 working days.","type":2}
                     * prepaid_message : Delivery in 4-6 working days.
                     * activity_object : {"activity_object":{"id":"P71943"}}
                     * image : https://shopimages.vstores.io/75917/1569929603861-32-small.jpg?1580465725
                     * quantity : 1
                     * max_selling_price : 667
                     * original_amo : 384
                     * variant_price : 355
                     * final_discount : 0
                     * formatted_variant_price : Tk. 355
                     * price_line : Tk. 423 x 1 = Tk. 423
                     * product_name : Casual Shirt For Men Olive - UPF
                     * sale_price : 423.0
                     * product_stamp : null
                     * zipcode : 7
                     * formatted_seller_price : Tk. 0
                     * formatted_sale_price : Tk. 423
                     * size : M
                     * line_item_adjustments : []
                     * master_product_id : 71943
                     * messages : []
                     * min_selling_price : 423
                     * category : Men shirt
                     * permalink : casual-shirt-for-men-olive-upf-9fad7110
                     * cod_message : Delivery in 4-6 working days.
                     */

                    private String formatted_price;
                    private String seller;
                    private int min_order_qty;
                    private int line_item_id;
                    private int discount;
                    private boolean prepaid_availability;
                    private String seller_slug;
                    private String delivery_time;
                    private String title;
                    private boolean liked;
                    private int category_id;
                    private int max_item_quantity;
                    private String price;
                    private int product_id;
                    private boolean sold_out;
                    private int variant;
                    private String formatted_income;
                    private String mrp_price_line;
                    private boolean cod_availability;
                    private String formatted_per_item_total;
                    private int per_item_total;
                    private String sku;
                    private DeliveryTimeMessageBeanXXXX delivery_time_message;
                    private String prepaid_message;
                    private ActivityObjectBeanXXXXXXXXX activity_object;
                    private String image;
                    private int quantity;
                    private int max_selling_price;
                    private int original_amo;
                    private int variant_price;
                    private int final_discount;
                    private String formatted_variant_price;
                    private String price_line;
                    private String product_name;
                    private String sale_price;
                    private Object product_stamp;
                    private String zipcode;
                    private String formatted_seller_price;
                    private String formatted_sale_price;
                    private String size;
                    private int master_product_id;
                    private int min_selling_price;
                    private String category;
                    private String permalink;
                    private String cod_message;
                    private List<VariantOptionsBeanXXXX> variant_options;
                    private List<?> line_item_adjustments;
                    private List<?> messages;

                    public String getFormatted_price() {
                        return formatted_price;
                    }

                    public void setFormatted_price(String formatted_price) {
                        this.formatted_price = formatted_price;
                    }

                    public String getSeller() {
                        return seller;
                    }

                    public void setSeller(String seller) {
                        this.seller = seller;
                    }

                    public int getMin_order_qty() {
                        return min_order_qty;
                    }

                    public void setMin_order_qty(int min_order_qty) {
                        this.min_order_qty = min_order_qty;
                    }

                    public int getLine_item_id() {
                        return line_item_id;
                    }

                    public void setLine_item_id(int line_item_id) {
                        this.line_item_id = line_item_id;
                    }

                    public int getDiscount() {
                        return discount;
                    }

                    public void setDiscount(int discount) {
                        this.discount = discount;
                    }

                    public boolean isPrepaid_availability() {
                        return prepaid_availability;
                    }

                    public void setPrepaid_availability(boolean prepaid_availability) {
                        this.prepaid_availability = prepaid_availability;
                    }

                    public String getSeller_slug() {
                        return seller_slug;
                    }

                    public void setSeller_slug(String seller_slug) {
                        this.seller_slug = seller_slug;
                    }

                    public String getDelivery_time() {
                        return delivery_time;
                    }

                    public void setDelivery_time(String delivery_time) {
                        this.delivery_time = delivery_time;
                    }

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public boolean isLiked() {
                        return liked;
                    }

                    public void setLiked(boolean liked) {
                        this.liked = liked;
                    }

                    public int getCategory_id() {
                        return category_id;
                    }

                    public void setCategory_id(int category_id) {
                        this.category_id = category_id;
                    }

                    public int getMax_item_quantity() {
                        return max_item_quantity;
                    }

                    public void setMax_item_quantity(int max_item_quantity) {
                        this.max_item_quantity = max_item_quantity;
                    }

                    public String getPrice() {
                        return price;
                    }

                    public void setPrice(String price) {
                        this.price = price;
                    }

                    public int getProduct_id() {
                        return product_id;
                    }

                    public void setProduct_id(int product_id) {
                        this.product_id = product_id;
                    }

                    public boolean isSold_out() {
                        return sold_out;
                    }

                    public void setSold_out(boolean sold_out) {
                        this.sold_out = sold_out;
                    }

                    public int getVariant() {
                        return variant;
                    }

                    public void setVariant(int variant) {
                        this.variant = variant;
                    }

                    public String getFormatted_income() {
                        return formatted_income;
                    }

                    public void setFormatted_income(String formatted_income) {
                        this.formatted_income = formatted_income;
                    }

                    public String getMrp_price_line() {
                        return mrp_price_line;
                    }

                    public void setMrp_price_line(String mrp_price_line) {
                        this.mrp_price_line = mrp_price_line;
                    }

                    public boolean isCod_availability() {
                        return cod_availability;
                    }

                    public void setCod_availability(boolean cod_availability) {
                        this.cod_availability = cod_availability;
                    }

                    public String getFormatted_per_item_total() {
                        return formatted_per_item_total;
                    }

                    public void setFormatted_per_item_total(String formatted_per_item_total) {
                        this.formatted_per_item_total = formatted_per_item_total;
                    }

                    public int getPer_item_total() {
                        return per_item_total;
                    }

                    public void setPer_item_total(int per_item_total) {
                        this.per_item_total = per_item_total;
                    }

                    public String getSku() {
                        return sku;
                    }

                    public void setSku(String sku) {
                        this.sku = sku;
                    }

                    public DeliveryTimeMessageBeanXXXX getDelivery_time_message() {
                        return delivery_time_message;
                    }

                    public void setDelivery_time_message(DeliveryTimeMessageBeanXXXX delivery_time_message) {
                        this.delivery_time_message = delivery_time_message;
                    }

                    public String getPrepaid_message() {
                        return prepaid_message;
                    }

                    public void setPrepaid_message(String prepaid_message) {
                        this.prepaid_message = prepaid_message;
                    }

                    public ActivityObjectBeanXXXXXXXXX getActivity_object() {
                        return activity_object;
                    }

                    public void setActivity_object(ActivityObjectBeanXXXXXXXXX activity_object) {
                        this.activity_object = activity_object;
                    }

                    public String getImage() {
                        return image;
                    }

                    public void setImage(String image) {
                        this.image = image;
                    }

                    public int getQuantity() {
                        return quantity;
                    }

                    public void setQuantity(int quantity) {
                        this.quantity = quantity;
                    }

                    public int getMax_selling_price() {
                        return max_selling_price;
                    }

                    public void setMax_selling_price(int max_selling_price) {
                        this.max_selling_price = max_selling_price;
                    }

                    public int getOriginal_amo() {
                        return original_amo;
                    }

                    public void setOriginal_amo(int original_amo) {
                        this.original_amo = original_amo;
                    }

                    public int getVariant_price() {
                        return variant_price;
                    }

                    public void setVariant_price(int variant_price) {
                        this.variant_price = variant_price;
                    }

                    public int getFinal_discount() {
                        return final_discount;
                    }

                    public void setFinal_discount(int final_discount) {
                        this.final_discount = final_discount;
                    }

                    public String getFormatted_variant_price() {
                        return formatted_variant_price;
                    }

                    public void setFormatted_variant_price(String formatted_variant_price) {
                        this.formatted_variant_price = formatted_variant_price;
                    }

                    public String getPrice_line() {
                        return price_line;
                    }

                    public void setPrice_line(String price_line) {
                        this.price_line = price_line;
                    }

                    public String getProduct_name() {
                        return product_name;
                    }

                    public void setProduct_name(String product_name) {
                        this.product_name = product_name;
                    }

                    public String getSale_price() {
                        return sale_price;
                    }

                    public void setSale_price(String sale_price) {
                        this.sale_price = sale_price;
                    }

                    public Object getProduct_stamp() {
                        return product_stamp;
                    }

                    public void setProduct_stamp(Object product_stamp) {
                        this.product_stamp = product_stamp;
                    }

                    public String getZipcode() {
                        return zipcode;
                    }

                    public void setZipcode(String zipcode) {
                        this.zipcode = zipcode;
                    }

                    public String getFormatted_seller_price() {
                        return formatted_seller_price;
                    }

                    public void setFormatted_seller_price(String formatted_seller_price) {
                        this.formatted_seller_price = formatted_seller_price;
                    }

                    public String getFormatted_sale_price() {
                        return formatted_sale_price;
                    }

                    public void setFormatted_sale_price(String formatted_sale_price) {
                        this.formatted_sale_price = formatted_sale_price;
                    }

                    public String getSize() {
                        return size;
                    }

                    public void setSize(String size) {
                        this.size = size;
                    }

                    public int getMaster_product_id() {
                        return master_product_id;
                    }

                    public void setMaster_product_id(int master_product_id) {
                        this.master_product_id = master_product_id;
                    }

                    public int getMin_selling_price() {
                        return min_selling_price;
                    }

                    public void setMin_selling_price(int min_selling_price) {
                        this.min_selling_price = min_selling_price;
                    }

                    public String getCategory() {
                        return category;
                    }

                    public void setCategory(String category) {
                        this.category = category;
                    }

                    public String getPermalink() {
                        return permalink;
                    }

                    public void setPermalink(String permalink) {
                        this.permalink = permalink;
                    }

                    public String getCod_message() {
                        return cod_message;
                    }

                    public void setCod_message(String cod_message) {
                        this.cod_message = cod_message;
                    }

                    public List<VariantOptionsBeanXXXX> getVariant_options() {
                        return variant_options;
                    }

                    public void setVariant_options(List<VariantOptionsBeanXXXX> variant_options) {
                        this.variant_options = variant_options;
                    }

                    public List<?> getLine_item_adjustments() {
                        return line_item_adjustments;
                    }

                    public void setLine_item_adjustments(List<?> line_item_adjustments) {
                        this.line_item_adjustments = line_item_adjustments;
                    }

                    public List<?> getMessages() {
                        return messages;
                    }

                    public void setMessages(List<?> messages) {
                        this.messages = messages;
                    }

                    public static class DeliveryTimeMessageBeanXXXX {
                        /**
                         * message : Delivery in 4-6 working days.
                         * type : 2
                         */

                        private String message;
                        private int type;

                        public String getMessage() {
                            return message;
                        }

                        public void setMessage(String message) {
                            this.message = message;
                        }

                        public int getType() {
                            return type;
                        }

                        public void setType(int type) {
                            this.type = type;
                        }
                    }

                    public static class ActivityObjectBeanXXXXXXXXX {
                        /**
                         * activity_object : {"id":"P71943"}
                         */

                        private ActivityObjectBeanXXXXXXXX activity_object;

                        public ActivityObjectBeanXXXXXXXX getActivity_object() {
                            return activity_object;
                        }

                        public void setActivity_object(ActivityObjectBeanXXXXXXXX activity_object) {
                            this.activity_object = activity_object;
                        }

                        public static class ActivityObjectBeanXXXXXXXX {
                            /**
                             * id : P71943
                             */

                            private String id;

                            public String getId() {
                                return id;
                            }

                            public void setId(String id) {
                                this.id = id;
                            }
                        }
                    }

                    public static class VariantOptionsBeanXXXX {
                        /**
                         * count_on_hand : 19
                         * option_value_name : M
                         * size : 25
                         * corrected_count_on_hand : 3
                         * name : M
                         * id : 93380
                         */

                        private int count_on_hand;
                        private String option_value_name;
                        private int size;
                        private int corrected_count_on_hand;
                        private String name;
                        private int id;

                        public int getCount_on_hand() {
                            return count_on_hand;
                        }

                        public void setCount_on_hand(int count_on_hand) {
                            this.count_on_hand = count_on_hand;
                        }

                        public String getOption_value_name() {
                            return option_value_name;
                        }

                        public void setOption_value_name(String option_value_name) {
                            this.option_value_name = option_value_name;
                        }

                        public int getSize() {
                            return size;
                        }

                        public void setSize(int size) {
                            this.size = size;
                        }

                        public int getCorrected_count_on_hand() {
                            return corrected_count_on_hand;
                        }

                        public void setCorrected_count_on_hand(int corrected_count_on_hand) {
                            this.corrected_count_on_hand = corrected_count_on_hand;
                        }

                        public String getName() {
                            return name;
                        }

                        public void setName(String name) {
                            this.name = name;
                        }

                        public int getId() {
                            return id;
                        }

                        public void setId(int id) {
                            this.id = id;
                        }
                    }
                }
            }

            public static class _$7MECBean {
                /**
                 * adjustments : []
                 * subtotal : 2361
                 * item_total : 2361
                 * items : [{"formatted_price":"Tk. 787","seller":"7MEC","min_order_qty":1,"line_item_id":297865,"discount":0,"prepaid_availability":true,"seller_slug":"7MEC","delivery_time":"COD is not available.","title":"Casual T-shirt for Men - MEC003 - 7MEC","liked":false,"category_id":1117,"variant_options":[{"count_on_hand":2,"option_value_name":"M","size":25,"corrected_count_on_hand":2,"name":"M","id":94134},{"count_on_hand":2,"option_value_name":"L","size":25,"corrected_count_on_hand":2,"name":"L","id":94135},{"count_on_hand":2,"option_value_name":"XL","size":25,"corrected_count_on_hand":2,"name":"XL","id":94136},{"count_on_hand":1,"option_value_name":"XXL","size":25,"corrected_count_on_hand":1,"name":"XXL","id":94137},{"count_on_hand":2,"option_value_name":"XXXL","size":25,"corrected_count_on_hand":2,"name":"XXXL","id":94138}],"max_item_quantity":50,"price":"787.0","product_id":72580,"sold_out":false,"variant":94134,"formatted_income":"Tk. 72","mrp_price_line":"Tk. 780 x 1 = Tk. 780","cod_availability":false,"formatted_per_item_total":"Tk. 787","per_item_total":787,"sku":"339473","delivery_time_message":{"message":"COD is not available.","type":0},"prepaid_message":"Dispatched in - working days.","activity_object":{"activity_object":{"id":"P72580"}},"image":"https://shopimages.vstores.io/49527/Polo-T-shirt-for-Men---MEC003---7MEC-small.jpeg?1580468596","quantity":1,"max_selling_price":1093,"original_amo":780,"variant_price":715,"final_discount":0,"formatted_variant_price":"Tk. 715","price_line":"Tk. 787 x 1 = Tk. 787","product_name":"Casual T-shirt for Men - MEC003 - 7MEC","sale_price":"787.0","product_stamp":null,"zipcode":"7","formatted_seller_price":"Tk. 0","formatted_sale_price":"Tk. 787","size":"M","line_item_adjustments":[],"master_product_id":72580,"messages":[],"min_selling_price":787,"category":"Men t-shirt","permalink":"casual-t-shirt-for-men-mec003-7mec-1f2e8e82","cod_message":"COD is not available."},{"formatted_price":"Tk. 787","seller":"7MEC","min_order_qty":1,"line_item_id":297862,"discount":2,"prepaid_availability":true,"seller_slug":"7MEC","delivery_time":"COD is not available.","title":"Casual T-shirt for Men - MEC012 - 7MEC","liked":false,"category_id":1117,"variant_options":[{"count_on_hand":1,"option_value_name":"M-option","size":25,"corrected_count_on_hand":1,"name":"M-option","id":102854},{"count_on_hand":2,"option_value_name":"L-option","size":25,"corrected_count_on_hand":2,"name":"L-option","id":102879},{"count_on_hand":1,"option_value_name":"XL-option","size":25,"corrected_count_on_hand":1,"name":"XL-option","id":102885},{"count_on_hand":2,"option_value_name":"XXL-option","size":25,"corrected_count_on_hand":2,"name":"XXL-option","id":102890},{"count_on_hand":2,"option_value_name":"XXXL-option","size":25,"corrected_count_on_hand":2,"name":"XXXL-option","id":102895}],"max_item_quantity":50,"price":"787.0","product_id":79793,"sold_out":false,"variant":102879,"formatted_income":"Tk. 72","mrp_price_line":"Tk. 800 x 1 = Tk. 800","cod_availability":false,"formatted_per_item_total":"Tk. 787","per_item_total":787,"sku":"343984","delivery_time_message":{"message":"COD is not available.","type":0},"prepaid_message":"Dispatched in - working days.","activity_object":{"activity_object":{"id":"P79793"}},"image":"https://shopimages.vstores.io/81897/1580542180270-polo-t-shirt-for-men---mec012---7mec-small.jpeg?1580897425","quantity":1,"max_selling_price":1093,"original_amo":800,"variant_price":715,"final_discount":2,"formatted_variant_price":"Tk. 715","price_line":"Tk. 787 x 1 = Tk. 787","product_name":"Casual T-shirt for Men - MEC012 - 7MEC","sale_price":"787.0","product_stamp":null,"zipcode":"7","formatted_seller_price":"Tk. 0","formatted_sale_price":"Tk. 787","size":"L-option","line_item_adjustments":[],"master_product_id":79793,"messages":[],"min_selling_price":787,"category":"Men t-shirt","permalink":"casual-t-shirt-for-men-mec012-7mec-25c68795","cod_message":"COD is not available."},{"formatted_price":"Tk. 787","seller":"7MEC","min_order_qty":1,"line_item_id":297816,"discount":0,"prepaid_availability":true,"seller_slug":"7MEC","delivery_time":"COD is not available.","title":"Casual T-shirt for Men - MEC003 - 7MEC","liked":false,"category_id":1117,"variant_options":[{"count_on_hand":2,"option_value_name":"M","size":25,"corrected_count_on_hand":2,"name":"M","id":94134},{"count_on_hand":2,"option_value_name":"L","size":25,"corrected_count_on_hand":2,"name":"L","id":94135},{"count_on_hand":2,"option_value_name":"XL","size":25,"corrected_count_on_hand":2,"name":"XL","id":94136},{"count_on_hand":1,"option_value_name":"XXL","size":25,"corrected_count_on_hand":1,"name":"XXL","id":94137},{"count_on_hand":2,"option_value_name":"XXXL","size":25,"corrected_count_on_hand":2,"name":"XXXL","id":94138}],"max_item_quantity":50,"price":"787.0","product_id":72580,"sold_out":false,"variant":94136,"formatted_income":"Tk. 72","mrp_price_line":"Tk. 780 x 1 = Tk. 780","cod_availability":false,"formatted_per_item_total":"Tk. 787","per_item_total":787,"sku":"339475","delivery_time_message":{"message":"COD is not available.","type":0},"prepaid_message":"Dispatched in - working days.","activity_object":{"activity_object":{"id":"P72580"}},"image":"https://shopimages.vstores.io/49527/Polo-T-shirt-for-Men---MEC003---7MEC-small.jpeg?1580468596","quantity":1,"max_selling_price":1093,"original_amo":780,"variant_price":715,"final_discount":0,"formatted_variant_price":"Tk. 715","price_line":"Tk. 787 x 1 = Tk. 787","product_name":"Casual T-shirt for Men - MEC003 - 7MEC","sale_price":"787.0","product_stamp":null,"zipcode":"7","formatted_seller_price":"Tk. 0","formatted_sale_price":"Tk. 787","size":"XL","line_item_adjustments":[],"master_product_id":72580,"messages":[],"min_selling_price":787,"category":"Men t-shirt","permalink":"casual-t-shirt-for-men-mec003-7mec-1f2e8e82","cod_message":"COD is not available."}]
                 */

                private int subtotal;
                private int item_total;
                private List<?> adjustments;
                private List<ItemsBeanXXXXX> items;

                public int getSubtotal() {
                    return subtotal;
                }

                public void setSubtotal(int subtotal) {
                    this.subtotal = subtotal;
                }

                public int getItem_total() {
                    return item_total;
                }

                public void setItem_total(int item_total) {
                    this.item_total = item_total;
                }

                public List<?> getAdjustments() {
                    return adjustments;
                }

                public void setAdjustments(List<?> adjustments) {
                    this.adjustments = adjustments;
                }

                public List<ItemsBeanXXXXX> getItems() {
                    return items;
                }

                public void setItems(List<ItemsBeanXXXXX> items) {
                    this.items = items;
                }

                public static class ItemsBeanXXXXX {
                    /**
                     * formatted_price : Tk. 787
                     * seller : 7MEC
                     * min_order_qty : 1
                     * line_item_id : 297865
                     * discount : 0
                     * prepaid_availability : true
                     * seller_slug : 7MEC
                     * delivery_time : COD is not available.
                     * title : Casual T-shirt for Men - MEC003 - 7MEC
                     * liked : false
                     * category_id : 1117
                     * variant_options : [{"count_on_hand":2,"option_value_name":"M","size":25,"corrected_count_on_hand":2,"name":"M","id":94134},{"count_on_hand":2,"option_value_name":"L","size":25,"corrected_count_on_hand":2,"name":"L","id":94135},{"count_on_hand":2,"option_value_name":"XL","size":25,"corrected_count_on_hand":2,"name":"XL","id":94136},{"count_on_hand":1,"option_value_name":"XXL","size":25,"corrected_count_on_hand":1,"name":"XXL","id":94137},{"count_on_hand":2,"option_value_name":"XXXL","size":25,"corrected_count_on_hand":2,"name":"XXXL","id":94138}]
                     * max_item_quantity : 50
                     * price : 787.0
                     * product_id : 72580
                     * sold_out : false
                     * variant : 94134
                     * formatted_income : Tk. 72
                     * mrp_price_line : Tk. 780 x 1 = Tk. 780
                     * cod_availability : false
                     * formatted_per_item_total : Tk. 787
                     * per_item_total : 787
                     * sku : 339473
                     * delivery_time_message : {"message":"COD is not available.","type":0}
                     * prepaid_message : Dispatched in - working days.
                     * activity_object : {"activity_object":{"id":"P72580"}}
                     * image : https://shopimages.vstores.io/49527/Polo-T-shirt-for-Men---MEC003---7MEC-small.jpeg?1580468596
                     * quantity : 1
                     * max_selling_price : 1093
                     * original_amo : 780
                     * variant_price : 715
                     * final_discount : 0
                     * formatted_variant_price : Tk. 715
                     * price_line : Tk. 787 x 1 = Tk. 787
                     * product_name : Casual T-shirt for Men - MEC003 - 7MEC
                     * sale_price : 787.0
                     * product_stamp : null
                     * zipcode : 7
                     * formatted_seller_price : Tk. 0
                     * formatted_sale_price : Tk. 787
                     * size : M
                     * line_item_adjustments : []
                     * master_product_id : 72580
                     * messages : []
                     * min_selling_price : 787
                     * category : Men t-shirt
                     * permalink : casual-t-shirt-for-men-mec003-7mec-1f2e8e82
                     * cod_message : COD is not available.
                     */

                    private String formatted_price;
                    private String seller;
                    private int min_order_qty;
                    private int line_item_id;
                    private int discount;
                    private boolean prepaid_availability;
                    private String seller_slug;
                    private String delivery_time;
                    private String title;
                    private boolean liked;
                    private int category_id;
                    private int max_item_quantity;
                    private String price;
                    private int product_id;
                    private boolean sold_out;
                    private int variant;
                    private String formatted_income;
                    private String mrp_price_line;
                    private boolean cod_availability;
                    private String formatted_per_item_total;
                    private int per_item_total;
                    private String sku;
                    private DeliveryTimeMessageBeanXXXXX delivery_time_message;
                    private String prepaid_message;
                    private ActivityObjectBeanXXXXXXXXXXX activity_object;
                    private String image;
                    private int quantity;
                    private int max_selling_price;
                    private int original_amo;
                    private int variant_price;
                    private int final_discount;
                    private String formatted_variant_price;
                    private String price_line;
                    private String product_name;
                    private String sale_price;
                    private Object product_stamp;
                    private String zipcode;
                    private String formatted_seller_price;
                    private String formatted_sale_price;
                    private String size;
                    private int master_product_id;
                    private int min_selling_price;
                    private String category;
                    private String permalink;
                    private String cod_message;
                    private List<VariantOptionsBeanXXXXX> variant_options;
                    private List<?> line_item_adjustments;
                    private List<?> messages;

                    public String getFormatted_price() {
                        return formatted_price;
                    }

                    public void setFormatted_price(String formatted_price) {
                        this.formatted_price = formatted_price;
                    }

                    public String getSeller() {
                        return seller;
                    }

                    public void setSeller(String seller) {
                        this.seller = seller;
                    }

                    public int getMin_order_qty() {
                        return min_order_qty;
                    }

                    public void setMin_order_qty(int min_order_qty) {
                        this.min_order_qty = min_order_qty;
                    }

                    public int getLine_item_id() {
                        return line_item_id;
                    }

                    public void setLine_item_id(int line_item_id) {
                        this.line_item_id = line_item_id;
                    }

                    public int getDiscount() {
                        return discount;
                    }

                    public void setDiscount(int discount) {
                        this.discount = discount;
                    }

                    public boolean isPrepaid_availability() {
                        return prepaid_availability;
                    }

                    public void setPrepaid_availability(boolean prepaid_availability) {
                        this.prepaid_availability = prepaid_availability;
                    }

                    public String getSeller_slug() {
                        return seller_slug;
                    }

                    public void setSeller_slug(String seller_slug) {
                        this.seller_slug = seller_slug;
                    }

                    public String getDelivery_time() {
                        return delivery_time;
                    }

                    public void setDelivery_time(String delivery_time) {
                        this.delivery_time = delivery_time;
                    }

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public boolean isLiked() {
                        return liked;
                    }

                    public void setLiked(boolean liked) {
                        this.liked = liked;
                    }

                    public int getCategory_id() {
                        return category_id;
                    }

                    public void setCategory_id(int category_id) {
                        this.category_id = category_id;
                    }

                    public int getMax_item_quantity() {
                        return max_item_quantity;
                    }

                    public void setMax_item_quantity(int max_item_quantity) {
                        this.max_item_quantity = max_item_quantity;
                    }

                    public String getPrice() {
                        return price;
                    }

                    public void setPrice(String price) {
                        this.price = price;
                    }

                    public int getProduct_id() {
                        return product_id;
                    }

                    public void setProduct_id(int product_id) {
                        this.product_id = product_id;
                    }

                    public boolean isSold_out() {
                        return sold_out;
                    }

                    public void setSold_out(boolean sold_out) {
                        this.sold_out = sold_out;
                    }

                    public int getVariant() {
                        return variant;
                    }

                    public void setVariant(int variant) {
                        this.variant = variant;
                    }

                    public String getFormatted_income() {
                        return formatted_income;
                    }

                    public void setFormatted_income(String formatted_income) {
                        this.formatted_income = formatted_income;
                    }

                    public String getMrp_price_line() {
                        return mrp_price_line;
                    }

                    public void setMrp_price_line(String mrp_price_line) {
                        this.mrp_price_line = mrp_price_line;
                    }

                    public boolean isCod_availability() {
                        return cod_availability;
                    }

                    public void setCod_availability(boolean cod_availability) {
                        this.cod_availability = cod_availability;
                    }

                    public String getFormatted_per_item_total() {
                        return formatted_per_item_total;
                    }

                    public void setFormatted_per_item_total(String formatted_per_item_total) {
                        this.formatted_per_item_total = formatted_per_item_total;
                    }

                    public int getPer_item_total() {
                        return per_item_total;
                    }

                    public void setPer_item_total(int per_item_total) {
                        this.per_item_total = per_item_total;
                    }

                    public String getSku() {
                        return sku;
                    }

                    public void setSku(String sku) {
                        this.sku = sku;
                    }

                    public DeliveryTimeMessageBeanXXXXX getDelivery_time_message() {
                        return delivery_time_message;
                    }

                    public void setDelivery_time_message(DeliveryTimeMessageBeanXXXXX delivery_time_message) {
                        this.delivery_time_message = delivery_time_message;
                    }

                    public String getPrepaid_message() {
                        return prepaid_message;
                    }

                    public void setPrepaid_message(String prepaid_message) {
                        this.prepaid_message = prepaid_message;
                    }

                    public ActivityObjectBeanXXXXXXXXXXX getActivity_object() {
                        return activity_object;
                    }

                    public void setActivity_object(ActivityObjectBeanXXXXXXXXXXX activity_object) {
                        this.activity_object = activity_object;
                    }

                    public String getImage() {
                        return image;
                    }

                    public void setImage(String image) {
                        this.image = image;
                    }

                    public int getQuantity() {
                        return quantity;
                    }

                    public void setQuantity(int quantity) {
                        this.quantity = quantity;
                    }

                    public int getMax_selling_price() {
                        return max_selling_price;
                    }

                    public void setMax_selling_price(int max_selling_price) {
                        this.max_selling_price = max_selling_price;
                    }

                    public int getOriginal_amo() {
                        return original_amo;
                    }

                    public void setOriginal_amo(int original_amo) {
                        this.original_amo = original_amo;
                    }

                    public int getVariant_price() {
                        return variant_price;
                    }

                    public void setVariant_price(int variant_price) {
                        this.variant_price = variant_price;
                    }

                    public int getFinal_discount() {
                        return final_discount;
                    }

                    public void setFinal_discount(int final_discount) {
                        this.final_discount = final_discount;
                    }

                    public String getFormatted_variant_price() {
                        return formatted_variant_price;
                    }

                    public void setFormatted_variant_price(String formatted_variant_price) {
                        this.formatted_variant_price = formatted_variant_price;
                    }

                    public String getPrice_line() {
                        return price_line;
                    }

                    public void setPrice_line(String price_line) {
                        this.price_line = price_line;
                    }

                    public String getProduct_name() {
                        return product_name;
                    }

                    public void setProduct_name(String product_name) {
                        this.product_name = product_name;
                    }

                    public String getSale_price() {
                        return sale_price;
                    }

                    public void setSale_price(String sale_price) {
                        this.sale_price = sale_price;
                    }

                    public Object getProduct_stamp() {
                        return product_stamp;
                    }

                    public void setProduct_stamp(Object product_stamp) {
                        this.product_stamp = product_stamp;
                    }

                    public String getZipcode() {
                        return zipcode;
                    }

                    public void setZipcode(String zipcode) {
                        this.zipcode = zipcode;
                    }

                    public String getFormatted_seller_price() {
                        return formatted_seller_price;
                    }

                    public void setFormatted_seller_price(String formatted_seller_price) {
                        this.formatted_seller_price = formatted_seller_price;
                    }

                    public String getFormatted_sale_price() {
                        return formatted_sale_price;
                    }

                    public void setFormatted_sale_price(String formatted_sale_price) {
                        this.formatted_sale_price = formatted_sale_price;
                    }

                    public String getSize() {
                        return size;
                    }

                    public void setSize(String size) {
                        this.size = size;
                    }

                    public int getMaster_product_id() {
                        return master_product_id;
                    }

                    public void setMaster_product_id(int master_product_id) {
                        this.master_product_id = master_product_id;
                    }

                    public int getMin_selling_price() {
                        return min_selling_price;
                    }

                    public void setMin_selling_price(int min_selling_price) {
                        this.min_selling_price = min_selling_price;
                    }

                    public String getCategory() {
                        return category;
                    }

                    public void setCategory(String category) {
                        this.category = category;
                    }

                    public String getPermalink() {
                        return permalink;
                    }

                    public void setPermalink(String permalink) {
                        this.permalink = permalink;
                    }

                    public String getCod_message() {
                        return cod_message;
                    }

                    public void setCod_message(String cod_message) {
                        this.cod_message = cod_message;
                    }

                    public List<VariantOptionsBeanXXXXX> getVariant_options() {
                        return variant_options;
                    }

                    public void setVariant_options(List<VariantOptionsBeanXXXXX> variant_options) {
                        this.variant_options = variant_options;
                    }

                    public List<?> getLine_item_adjustments() {
                        return line_item_adjustments;
                    }

                    public void setLine_item_adjustments(List<?> line_item_adjustments) {
                        this.line_item_adjustments = line_item_adjustments;
                    }

                    public List<?> getMessages() {
                        return messages;
                    }

                    public void setMessages(List<?> messages) {
                        this.messages = messages;
                    }

                    public static class DeliveryTimeMessageBeanXXXXX {
                        /**
                         * message : COD is not available.
                         * type : 0
                         */

                        private String message;
                        private int type;

                        public String getMessage() {
                            return message;
                        }

                        public void setMessage(String message) {
                            this.message = message;
                        }

                        public int getType() {
                            return type;
                        }

                        public void setType(int type) {
                            this.type = type;
                        }
                    }

                    public static class ActivityObjectBeanXXXXXXXXXXX {
                        /**
                         * activity_object : {"id":"P72580"}
                         */

                        private ActivityObjectBeanXXXXXXXXXX activity_object;

                        public ActivityObjectBeanXXXXXXXXXX getActivity_object() {
                            return activity_object;
                        }

                        public void setActivity_object(ActivityObjectBeanXXXXXXXXXX activity_object) {
                            this.activity_object = activity_object;
                        }

                        public static class ActivityObjectBeanXXXXXXXXXX {
                            /**
                             * id : P72580
                             */

                            private String id;

                            public String getId() {
                                return id;
                            }

                            public void setId(String id) {
                                this.id = id;
                            }
                        }
                    }

                    public static class VariantOptionsBeanXXXXX {
                        /**
                         * count_on_hand : 2
                         * option_value_name : M
                         * size : 25
                         * corrected_count_on_hand : 2
                         * name : M
                         * id : 94134
                         */

                        private int count_on_hand;
                        private String option_value_name;
                        private int size;
                        private int corrected_count_on_hand;
                        private String name;
                        private int id;

                        public int getCount_on_hand() {
                            return count_on_hand;
                        }

                        public void setCount_on_hand(int count_on_hand) {
                            this.count_on_hand = count_on_hand;
                        }

                        public String getOption_value_name() {
                            return option_value_name;
                        }

                        public void setOption_value_name(String option_value_name) {
                            this.option_value_name = option_value_name;
                        }

                        public int getSize() {
                            return size;
                        }

                        public void setSize(int size) {
                            this.size = size;
                        }

                        public int getCorrected_count_on_hand() {
                            return corrected_count_on_hand;
                        }

                        public void setCorrected_count_on_hand(int corrected_count_on_hand) {
                            this.corrected_count_on_hand = corrected_count_on_hand;
                        }

                        public String getName() {
                            return name;
                        }

                        public void setName(String name) {
                            this.name = name;
                        }

                        public int getId() {
                            return id;
                        }

                        public void setId(int id) {
                            this.id = id;
                        }
                    }
                }
            }

            public static class TMWBean {
                /**
                 * adjustments : []
                 * subtotal : 1000
                 * item_total : 1000
                 * items : [{"formatted_price":"Tk. 500","seller":"TMW","min_order_qty":1,"line_item_id":297727,"discount":0,"prepaid_availability":true,"seller_slug":"tmw","delivery_time":"Delivery in 4-6 working days.","title":"Full Sleeve Casual Shirt for Men 02 - Ash - TMW","liked":false,"category_id":1118,"variant_options":[{"count_on_hand":6,"option_value_name":"M","size":25,"corrected_count_on_hand":3,"name":"M","id":29245},{"count_on_hand":8,"option_value_name":"L","size":25,"corrected_count_on_hand":3,"name":"L","id":29247},{"count_on_hand":7,"option_value_name":"XL","size":25,"corrected_count_on_hand":3,"name":"XL","id":29248}],"max_item_quantity":50,"price":"500.0","product_id":24424,"sold_out":false,"variant":29245,"formatted_income":"Tk. 210","mrp_price_line":"Tk. 395 x 2 = Tk. 790","cod_availability":true,"formatted_per_item_total":"Tk. 1,000","per_item_total":1000,"sku":"305933","delivery_time_message":{"message":"Delivery in 4-6 working days.","type":2},"prepaid_message":"Delivery in 4-6 working days.","activity_object":{"activity_object":{"id":"P24424"}},"image":"https://shopimages.vstores.io/42442/1576574650899-whatsappimage2019-12-14at5.26.18pm1-small.jpeg?1580126772","quantity":2,"max_selling_price":742,"original_amo":395,"variant_price":395,"final_discount":0,"formatted_variant_price":"Tk. 395","price_line":"Tk. 500 x 2 = Tk. 1,000","product_name":"Full Sleeve Casual Shirt for Men 02 - Ash - TMW","sale_price":"1000.0","product_stamp":null,"zipcode":"7","formatted_seller_price":"Tk. 0","formatted_sale_price":"Tk. 1,000","size":"M","line_item_adjustments":[],"master_product_id":24424,"messages":[],"min_selling_price":471,"category":"Men shirt","permalink":"full-sleeve-casual-shirt-for-men-02-ash-tmw-fa8be538","cod_message":"Delivery in 4-6 working days."}]
                 */

                private int subtotal;
                private int item_total;
                private List<?> adjustments;
                private List<ItemsBeanXXXXXX> items;

                public int getSubtotal() {
                    return subtotal;
                }

                public void setSubtotal(int subtotal) {
                    this.subtotal = subtotal;
                }

                public int getItem_total() {
                    return item_total;
                }

                public void setItem_total(int item_total) {
                    this.item_total = item_total;
                }

                public List<?> getAdjustments() {
                    return adjustments;
                }

                public void setAdjustments(List<?> adjustments) {
                    this.adjustments = adjustments;
                }

                public List<ItemsBeanXXXXXX> getItems() {
                    return items;
                }

                public void setItems(List<ItemsBeanXXXXXX> items) {
                    this.items = items;
                }

                public static class ItemsBeanXXXXXX {
                    /**
                     * formatted_price : Tk. 500
                     * seller : TMW
                     * min_order_qty : 1
                     * line_item_id : 297727
                     * discount : 0
                     * prepaid_availability : true
                     * seller_slug : tmw
                     * delivery_time : Delivery in 4-6 working days.
                     * title : Full Sleeve Casual Shirt for Men 02 - Ash - TMW
                     * liked : false
                     * category_id : 1118
                     * variant_options : [{"count_on_hand":6,"option_value_name":"M","size":25,"corrected_count_on_hand":3,"name":"M","id":29245},{"count_on_hand":8,"option_value_name":"L","size":25,"corrected_count_on_hand":3,"name":"L","id":29247},{"count_on_hand":7,"option_value_name":"XL","size":25,"corrected_count_on_hand":3,"name":"XL","id":29248}]
                     * max_item_quantity : 50
                     * price : 500.0
                     * product_id : 24424
                     * sold_out : false
                     * variant : 29245
                     * formatted_income : Tk. 210
                     * mrp_price_line : Tk. 395 x 2 = Tk. 790
                     * cod_availability : true
                     * formatted_per_item_total : Tk. 1,000
                     * per_item_total : 1000
                     * sku : 305933
                     * delivery_time_message : {"message":"Delivery in 4-6 working days.","type":2}
                     * prepaid_message : Delivery in 4-6 working days.
                     * activity_object : {"activity_object":{"id":"P24424"}}
                     * image : https://shopimages.vstores.io/42442/1576574650899-whatsappimage2019-12-14at5.26.18pm1-small.jpeg?1580126772
                     * quantity : 2
                     * max_selling_price : 742
                     * original_amo : 395
                     * variant_price : 395
                     * final_discount : 0
                     * formatted_variant_price : Tk. 395
                     * price_line : Tk. 500 x 2 = Tk. 1,000
                     * product_name : Full Sleeve Casual Shirt for Men 02 - Ash - TMW
                     * sale_price : 1000.0
                     * product_stamp : null
                     * zipcode : 7
                     * formatted_seller_price : Tk. 0
                     * formatted_sale_price : Tk. 1,000
                     * size : M
                     * line_item_adjustments : []
                     * master_product_id : 24424
                     * messages : []
                     * min_selling_price : 471
                     * category : Men shirt
                     * permalink : full-sleeve-casual-shirt-for-men-02-ash-tmw-fa8be538
                     * cod_message : Delivery in 4-6 working days.
                     */

                    private String formatted_price;
                    private String seller;
                    private int min_order_qty;
                    private int line_item_id;
                    private int discount;
                    private boolean prepaid_availability;
                    private String seller_slug;
                    private String delivery_time;
                    private String title;
                    private boolean liked;
                    private int category_id;
                    private int max_item_quantity;
                    private String price;
                    private int product_id;
                    private boolean sold_out;
                    private int variant;
                    private String formatted_income;
                    private String mrp_price_line;
                    private boolean cod_availability;
                    private String formatted_per_item_total;
                    private int per_item_total;
                    private String sku;
                    private DeliveryTimeMessageBeanXXXXXX delivery_time_message;
                    private String prepaid_message;
                    private ActivityObjectBeanXXXXXXXXXXXXX activity_object;
                    private String image;
                    private int quantity;
                    private int max_selling_price;
                    private int original_amo;
                    private int variant_price;
                    private int final_discount;
                    private String formatted_variant_price;
                    private String price_line;
                    private String product_name;
                    private String sale_price;
                    private Object product_stamp;
                    private String zipcode;
                    private String formatted_seller_price;
                    private String formatted_sale_price;
                    private String size;
                    private int master_product_id;
                    private int min_selling_price;
                    private String category;
                    private String permalink;
                    private String cod_message;
                    private List<VariantOptionsBeanXXXXXX> variant_options;
                    private List<?> line_item_adjustments;
                    private List<?> messages;

                    public String getFormatted_price() {
                        return formatted_price;
                    }

                    public void setFormatted_price(String formatted_price) {
                        this.formatted_price = formatted_price;
                    }

                    public String getSeller() {
                        return seller;
                    }

                    public void setSeller(String seller) {
                        this.seller = seller;
                    }

                    public int getMin_order_qty() {
                        return min_order_qty;
                    }

                    public void setMin_order_qty(int min_order_qty) {
                        this.min_order_qty = min_order_qty;
                    }

                    public int getLine_item_id() {
                        return line_item_id;
                    }

                    public void setLine_item_id(int line_item_id) {
                        this.line_item_id = line_item_id;
                    }

                    public int getDiscount() {
                        return discount;
                    }

                    public void setDiscount(int discount) {
                        this.discount = discount;
                    }

                    public boolean isPrepaid_availability() {
                        return prepaid_availability;
                    }

                    public void setPrepaid_availability(boolean prepaid_availability) {
                        this.prepaid_availability = prepaid_availability;
                    }

                    public String getSeller_slug() {
                        return seller_slug;
                    }

                    public void setSeller_slug(String seller_slug) {
                        this.seller_slug = seller_slug;
                    }

                    public String getDelivery_time() {
                        return delivery_time;
                    }

                    public void setDelivery_time(String delivery_time) {
                        this.delivery_time = delivery_time;
                    }

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public boolean isLiked() {
                        return liked;
                    }

                    public void setLiked(boolean liked) {
                        this.liked = liked;
                    }

                    public int getCategory_id() {
                        return category_id;
                    }

                    public void setCategory_id(int category_id) {
                        this.category_id = category_id;
                    }

                    public int getMax_item_quantity() {
                        return max_item_quantity;
                    }

                    public void setMax_item_quantity(int max_item_quantity) {
                        this.max_item_quantity = max_item_quantity;
                    }

                    public String getPrice() {
                        return price;
                    }

                    public void setPrice(String price) {
                        this.price = price;
                    }

                    public int getProduct_id() {
                        return product_id;
                    }

                    public void setProduct_id(int product_id) {
                        this.product_id = product_id;
                    }

                    public boolean isSold_out() {
                        return sold_out;
                    }

                    public void setSold_out(boolean sold_out) {
                        this.sold_out = sold_out;
                    }

                    public int getVariant() {
                        return variant;
                    }

                    public void setVariant(int variant) {
                        this.variant = variant;
                    }

                    public String getFormatted_income() {
                        return formatted_income;
                    }

                    public void setFormatted_income(String formatted_income) {
                        this.formatted_income = formatted_income;
                    }

                    public String getMrp_price_line() {
                        return mrp_price_line;
                    }

                    public void setMrp_price_line(String mrp_price_line) {
                        this.mrp_price_line = mrp_price_line;
                    }

                    public boolean isCod_availability() {
                        return cod_availability;
                    }

                    public void setCod_availability(boolean cod_availability) {
                        this.cod_availability = cod_availability;
                    }

                    public String getFormatted_per_item_total() {
                        return formatted_per_item_total;
                    }

                    public void setFormatted_per_item_total(String formatted_per_item_total) {
                        this.formatted_per_item_total = formatted_per_item_total;
                    }

                    public int getPer_item_total() {
                        return per_item_total;
                    }

                    public void setPer_item_total(int per_item_total) {
                        this.per_item_total = per_item_total;
                    }

                    public String getSku() {
                        return sku;
                    }

                    public void setSku(String sku) {
                        this.sku = sku;
                    }

                    public DeliveryTimeMessageBeanXXXXXX getDelivery_time_message() {
                        return delivery_time_message;
                    }

                    public void setDelivery_time_message(DeliveryTimeMessageBeanXXXXXX delivery_time_message) {
                        this.delivery_time_message = delivery_time_message;
                    }

                    public String getPrepaid_message() {
                        return prepaid_message;
                    }

                    public void setPrepaid_message(String prepaid_message) {
                        this.prepaid_message = prepaid_message;
                    }

                    public ActivityObjectBeanXXXXXXXXXXXXX getActivity_object() {
                        return activity_object;
                    }

                    public void setActivity_object(ActivityObjectBeanXXXXXXXXXXXXX activity_object) {
                        this.activity_object = activity_object;
                    }

                    public String getImage() {
                        return image;
                    }

                    public void setImage(String image) {
                        this.image = image;
                    }

                    public int getQuantity() {
                        return quantity;
                    }

                    public void setQuantity(int quantity) {
                        this.quantity = quantity;
                    }

                    public int getMax_selling_price() {
                        return max_selling_price;
                    }

                    public void setMax_selling_price(int max_selling_price) {
                        this.max_selling_price = max_selling_price;
                    }

                    public int getOriginal_amo() {
                        return original_amo;
                    }

                    public void setOriginal_amo(int original_amo) {
                        this.original_amo = original_amo;
                    }

                    public int getVariant_price() {
                        return variant_price;
                    }

                    public void setVariant_price(int variant_price) {
                        this.variant_price = variant_price;
                    }

                    public int getFinal_discount() {
                        return final_discount;
                    }

                    public void setFinal_discount(int final_discount) {
                        this.final_discount = final_discount;
                    }

                    public String getFormatted_variant_price() {
                        return formatted_variant_price;
                    }

                    public void setFormatted_variant_price(String formatted_variant_price) {
                        this.formatted_variant_price = formatted_variant_price;
                    }

                    public String getPrice_line() {
                        return price_line;
                    }

                    public void setPrice_line(String price_line) {
                        this.price_line = price_line;
                    }

                    public String getProduct_name() {
                        return product_name;
                    }

                    public void setProduct_name(String product_name) {
                        this.product_name = product_name;
                    }

                    public String getSale_price() {
                        return sale_price;
                    }

                    public void setSale_price(String sale_price) {
                        this.sale_price = sale_price;
                    }

                    public Object getProduct_stamp() {
                        return product_stamp;
                    }

                    public void setProduct_stamp(Object product_stamp) {
                        this.product_stamp = product_stamp;
                    }

                    public String getZipcode() {
                        return zipcode;
                    }

                    public void setZipcode(String zipcode) {
                        this.zipcode = zipcode;
                    }

                    public String getFormatted_seller_price() {
                        return formatted_seller_price;
                    }

                    public void setFormatted_seller_price(String formatted_seller_price) {
                        this.formatted_seller_price = formatted_seller_price;
                    }

                    public String getFormatted_sale_price() {
                        return formatted_sale_price;
                    }

                    public void setFormatted_sale_price(String formatted_sale_price) {
                        this.formatted_sale_price = formatted_sale_price;
                    }

                    public String getSize() {
                        return size;
                    }

                    public void setSize(String size) {
                        this.size = size;
                    }

                    public int getMaster_product_id() {
                        return master_product_id;
                    }

                    public void setMaster_product_id(int master_product_id) {
                        this.master_product_id = master_product_id;
                    }

                    public int getMin_selling_price() {
                        return min_selling_price;
                    }

                    public void setMin_selling_price(int min_selling_price) {
                        this.min_selling_price = min_selling_price;
                    }

                    public String getCategory() {
                        return category;
                    }

                    public void setCategory(String category) {
                        this.category = category;
                    }

                    public String getPermalink() {
                        return permalink;
                    }

                    public void setPermalink(String permalink) {
                        this.permalink = permalink;
                    }

                    public String getCod_message() {
                        return cod_message;
                    }

                    public void setCod_message(String cod_message) {
                        this.cod_message = cod_message;
                    }

                    public List<VariantOptionsBeanXXXXXX> getVariant_options() {
                        return variant_options;
                    }

                    public void setVariant_options(List<VariantOptionsBeanXXXXXX> variant_options) {
                        this.variant_options = variant_options;
                    }

                    public List<?> getLine_item_adjustments() {
                        return line_item_adjustments;
                    }

                    public void setLine_item_adjustments(List<?> line_item_adjustments) {
                        this.line_item_adjustments = line_item_adjustments;
                    }

                    public List<?> getMessages() {
                        return messages;
                    }

                    public void setMessages(List<?> messages) {
                        this.messages = messages;
                    }

                    public static class DeliveryTimeMessageBeanXXXXXX {
                        /**
                         * message : Delivery in 4-6 working days.
                         * type : 2
                         */

                        private String message;
                        private int type;

                        public String getMessage() {
                            return message;
                        }

                        public void setMessage(String message) {
                            this.message = message;
                        }

                        public int getType() {
                            return type;
                        }

                        public void setType(int type) {
                            this.type = type;
                        }
                    }

                    public static class ActivityObjectBeanXXXXXXXXXXXXX {
                        /**
                         * activity_object : {"id":"P24424"}
                         */

                        private ActivityObjectBeanXXXXXXXXXXXX activity_object;

                        public ActivityObjectBeanXXXXXXXXXXXX getActivity_object() {
                            return activity_object;
                        }

                        public void setActivity_object(ActivityObjectBeanXXXXXXXXXXXX activity_object) {
                            this.activity_object = activity_object;
                        }

                        public static class ActivityObjectBeanXXXXXXXXXXXX {
                            /**
                             * id : P24424
                             */

                            private String id;

                            public String getId() {
                                return id;
                            }

                            public void setId(String id) {
                                this.id = id;
                            }
                        }
                    }

                    public static class VariantOptionsBeanXXXXXX {
                        /**
                         * count_on_hand : 6
                         * option_value_name : M
                         * size : 25
                         * corrected_count_on_hand : 3
                         * name : M
                         * id : 29245
                         */

                        private int count_on_hand;
                        private String option_value_name;
                        private int size;
                        private int corrected_count_on_hand;
                        private String name;
                        private int id;

                        public int getCount_on_hand() {
                            return count_on_hand;
                        }

                        public void setCount_on_hand(int count_on_hand) {
                            this.count_on_hand = count_on_hand;
                        }

                        public String getOption_value_name() {
                            return option_value_name;
                        }

                        public void setOption_value_name(String option_value_name) {
                            this.option_value_name = option_value_name;
                        }

                        public int getSize() {
                            return size;
                        }

                        public void setSize(int size) {
                            this.size = size;
                        }

                        public int getCorrected_count_on_hand() {
                            return corrected_count_on_hand;
                        }

                        public void setCorrected_count_on_hand(int corrected_count_on_hand) {
                            this.corrected_count_on_hand = corrected_count_on_hand;
                        }

                        public String getName() {
                            return name;
                        }

                        public void setName(String name) {
                            this.name = name;
                        }

                        public int getId() {
                            return id;
                        }

                        public void setId(int id) {
                            this.id = id;
                        }
                    }
                }
            }
        }

        public static class AdjustmentsBean {
            /**
             * amount : 49
             * is_seller_coupon : false
             * is_vcash : false
             * label : Shipping Charges
             */

            private int amount;
            private boolean is_seller_coupon;
            private boolean is_vcash;
            private String label;

            public int getAmount() {
                return amount;
            }

            public void setAmount(int amount) {
                this.amount = amount;
            }

            public boolean isIs_seller_coupon() {
                return is_seller_coupon;
            }

            public void setIs_seller_coupon(boolean is_seller_coupon) {
                this.is_seller_coupon = is_seller_coupon;
            }

            public boolean isIs_vcash() {
                return is_vcash;
            }

            public void setIs_vcash(boolean is_vcash) {
                this.is_vcash = is_vcash;
            }

            public String getLabel() {
                return label;
            }

            public void setLabel(String label) {
                this.label = label;
            }
        }
    }

    public static class AdjustmentsBeanX {
        /**
         * income : 0
         * is_seller_coupon : false
         * adjustment_type : 6
         * formatted_income : Tk. 0
         * label : Shipping Charges
         * value_amount : 49
         * value : Tk. 49
         * value_currency : INR
         */

        private int income;
        private boolean is_seller_coupon;
        private int adjustment_type;
        private String formatted_income;
        private String label;
        private int value_amount;
        private String value;
        private String value_currency;

        public int getIncome() {
            return income;
        }

        public void setIncome(int income) {
            this.income = income;
        }

        public boolean isIs_seller_coupon() {
            return is_seller_coupon;
        }

        public void setIs_seller_coupon(boolean is_seller_coupon) {
            this.is_seller_coupon = is_seller_coupon;
        }

        public int getAdjustment_type() {
            return adjustment_type;
        }

        public void setAdjustment_type(int adjustment_type) {
            this.adjustment_type = adjustment_type;
        }

        public String getFormatted_income() {
            return formatted_income;
        }

        public void setFormatted_income(String formatted_income) {
            this.formatted_income = formatted_income;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public int getValue_amount() {
            return value_amount;
        }

        public void setValue_amount(int value_amount) {
            this.value_amount = value_amount;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getValue_currency() {
            return value_currency;
        }

        public void setValue_currency(String value_currency) {
            this.value_currency = value_currency;
        }
    }

    public static class ShippedAddressesBean {
        /**
         * country : INDIA
         * firstname : testing
         * address2 : dhaka
         * city : Adabor, Dhaka
         * alternative_phone : null
         * address1 : Shopup street
         * lastname :
         * zipcode : 7
         * is_saved : null
         * user_id : 122694
         * phone : 8801877755590
         * company : home
         * id : 9122690
         * state : Andhra Pradesh
         * state_id : 34
         * landmark :
         * country_id : 1
         */

        private String country;
        private String firstname;
        private String address2;
        private String city;
        private Object alternative_phone;
        private String address1;
        private String lastname;
        private String zipcode;
        private Object is_saved;
        private int user_id;
        private String phone;
        private String company;
        private int id;
        private String state;
        private int state_id;
        private String landmark;
        private int country_id;

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getFirstname() {
            return firstname;
        }

        public void setFirstname(String firstname) {
            this.firstname = firstname;
        }

        public String getAddress2() {
            return address2;
        }

        public void setAddress2(String address2) {
            this.address2 = address2;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public Object getAlternative_phone() {
            return alternative_phone;
        }

        public void setAlternative_phone(Object alternative_phone) {
            this.alternative_phone = alternative_phone;
        }

        public String getAddress1() {
            return address1;
        }

        public void setAddress1(String address1) {
            this.address1 = address1;
        }

        public String getLastname() {
            return lastname;
        }

        public void setLastname(String lastname) {
            this.lastname = lastname;
        }

        public String getZipcode() {
            return zipcode;
        }

        public void setZipcode(String zipcode) {
            this.zipcode = zipcode;
        }

        public Object getIs_saved() {
            return is_saved;
        }

        public void setIs_saved(Object is_saved) {
            this.is_saved = is_saved;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public int getState_id() {
            return state_id;
        }

        public void setState_id(int state_id) {
            this.state_id = state_id;
        }

        public String getLandmark() {
            return landmark;
        }

        public void setLandmark(String landmark) {
            this.landmark = landmark;
        }

        public int getCountry_id() {
            return country_id;
        }

        public void setCountry_id(int country_id) {
            this.country_id = country_id;
        }
    }

    public static class PaymentMethodsBean {
        /**
         * payment_method : {"account_id":0,"code":null,"name":"payu_redirect","rank":100,"id":7,"vaccount_id":1,"display_name":null,"is_default":false}
         */

        private PaymentMethodBeanX payment_method;

        public PaymentMethodBeanX getPayment_method() {
            return payment_method;
        }

        public void setPayment_method(PaymentMethodBeanX payment_method) {
            this.payment_method = payment_method;
        }

        public static class PaymentMethodBeanX {
            /**
             * account_id : 0
             * code : null
             * name : payu_redirect
             * rank : 100
             * id : 7
             * vaccount_id : 1
             * display_name : null
             * is_default : false
             */

            private int account_id;
            private Object code;
            private String name;
            private int rank;
            private int id;
            private int vaccount_id;
            private Object display_name;
            private boolean is_default;

            public int getAccount_id() {
                return account_id;
            }

            public void setAccount_id(int account_id) {
                this.account_id = account_id;
            }

            public Object getCode() {
                return code;
            }

            public void setCode(Object code) {
                this.code = code;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getRank() {
                return rank;
            }

            public void setRank(int rank) {
                this.rank = rank;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getVaccount_id() {
                return vaccount_id;
            }

            public void setVaccount_id(int vaccount_id) {
                this.vaccount_id = vaccount_id;
            }

            public Object getDisplay_name() {
                return display_name;
            }

            public void setDisplay_name(Object display_name) {
                this.display_name = display_name;
            }

            public boolean isIs_default() {
                return is_default;
            }

            public void setIs_default(boolean is_default) {
                this.is_default = is_default;
            }
        }
    }

    public static class NonCodAdjustmentsBean {
        /**
         * adjustment_type : 6
         * label : Shipping Charges
         * value_amount : 49
         * value_currency : INR
         */

        private int adjustment_type;
        private String label;
        private int value_amount;
        private String value_currency;

        public int getAdjustment_type() {
            return adjustment_type;
        }

        public void setAdjustment_type(int adjustment_type) {
            this.adjustment_type = adjustment_type;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public int getValue_amount() {
            return value_amount;
        }

        public void setValue_amount(int value_amount) {
            this.value_amount = value_amount;
        }

        public String getValue_currency() {
            return value_currency;
        }

        public void setValue_currency(String value_currency) {
            this.value_currency = value_currency;
        }
    }

    public static class PaymentTypesBean {
        /**
         * account_id : 0
         * code : cod
         * name : cod
         * id : 1
         * display_name : CASH ON DELIVERY
         * payment_options : [{"offer_message":null,"wallet_id":null,"code":"COD","image_url":null,"id":1,"direct_debit":null,"display_name":"CASH ON DELIVERY"}]
         */

        private int account_id;
        private String code;
        private String name;
        private int id;
        private String display_name;
        private List<PaymentOptionsBean> payment_options;

        public int getAccount_id() {
            return account_id;
        }

        public void setAccount_id(int account_id) {
            this.account_id = account_id;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getDisplay_name() {
            return display_name;
        }

        public void setDisplay_name(String display_name) {
            this.display_name = display_name;
        }

        public List<PaymentOptionsBean> getPayment_options() {
            return payment_options;
        }

        public void setPayment_options(List<PaymentOptionsBean> payment_options) {
            this.payment_options = payment_options;
        }

        public static class PaymentOptionsBean {
            /**
             * offer_message : null
             * wallet_id : null
             * code : COD
             * image_url : null
             * id : 1
             * direct_debit : null
             * display_name : CASH ON DELIVERY
             */

            private Object offer_message;
            private Object wallet_id;
            private String code;
            private Object image_url;
            private int id;
            private Object direct_debit;
            private String display_name;

            public Object getOffer_message() {
                return offer_message;
            }

            public void setOffer_message(Object offer_message) {
                this.offer_message = offer_message;
            }

            public Object getWallet_id() {
                return wallet_id;
            }

            public void setWallet_id(Object wallet_id) {
                this.wallet_id = wallet_id;
            }

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public Object getImage_url() {
                return image_url;
            }

            public void setImage_url(Object image_url) {
                this.image_url = image_url;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public Object getDirect_debit() {
                return direct_debit;
            }

            public void setDirect_debit(Object direct_debit) {
                this.direct_debit = direct_debit;
            }

            public String getDisplay_name() {
                return display_name;
            }

            public void setDisplay_name(String display_name) {
                this.display_name = display_name;
            }
        }
    }

    public static class CartItemsBean {
        /**
         * formatted_price : Tk. 787
         * seller : 7MEC
         * min_order_qty : 1
         * line_item_id : 297865
         * discount : 0
         * prepaid_availability : true
         * seller_slug : 7MEC
         * delivery_time : COD is not available.
         * title : Casual T-shirt for Men - MEC003 - 7MEC
         * liked : false
         * category_id : 1117
         * variant_options : [{"count_on_hand":2,"option_value_name":"M","size":25,"corrected_count_on_hand":2,"name":"M","id":94134},{"count_on_hand":2,"option_value_name":"L","size":25,"corrected_count_on_hand":2,"name":"L","id":94135},{"count_on_hand":2,"option_value_name":"XL","size":25,"corrected_count_on_hand":2,"name":"XL","id":94136},{"count_on_hand":1,"option_value_name":"XXL","size":25,"corrected_count_on_hand":1,"name":"XXL","id":94137},{"count_on_hand":2,"option_value_name":"XXXL","size":25,"corrected_count_on_hand":2,"name":"XXXL","id":94138}]
         * max_item_quantity : 50
         * price : 787.0
         * product_id : 72580
         * sold_out : false
         * variant : 94134
         * formatted_income : Tk. 72
         * mrp_price_line : Tk. 780 x 1 = Tk. 780
         * cod_availability : false
         * formatted_per_item_total : Tk. 787
         * per_item_total : 787
         * sku : 339473
         * delivery_time_message : {"message":"COD is not available.","type":0}
         * prepaid_message : Dispatched in - working days.
         * activity_object : {"activity_object":{"id":"P72580"}}
         * image : https://shopimages.vstores.io/49527/Polo-T-shirt-for-Men---MEC003---7MEC-small.jpeg?1580468596
         * quantity : 1
         * max_selling_price : 1093
         * original_amo : 780
         * variant_price : 715
         * final_discount : 0
         * formatted_variant_price : Tk. 715
         * price_line : Tk. 787 x 1 = Tk. 787
         * product_name : Casual T-shirt for Men - MEC003 - 7MEC
         * sale_price : 787.0
         * product_stamp : null
         * zipcode : 7
         * formatted_seller_price : Tk. 0
         * formatted_sale_price : Tk. 787
         * size : M
         * line_item_adjustments : []
         * master_product_id : 72580
         * messages : []
         * min_selling_price : 787
         * category : Men t-shirt
         * permalink : casual-t-shirt-for-men-mec003-7mec-1f2e8e82
         * cod_message : COD is not available.
         */

        private String formatted_price;
        private String seller;
        private int min_order_qty;
        private int line_item_id;
        private int discount;
        private boolean prepaid_availability;
        private String seller_slug;
        private String delivery_time;
        private String title;
        private boolean liked;
        private int category_id;
        private int max_item_quantity;
        private String price;
        private int product_id;
        private boolean sold_out;
        private int variant;
        private String formatted_income;
        private String mrp_price_line;
        private boolean cod_availability;
        private String formatted_per_item_total;
        private int per_item_total;
        private String sku;
        private DeliveryTimeMessageBeanXXXXXXX delivery_time_message;
        private String prepaid_message;
        private ActivityObjectBeanXXXXXXXXXXXXXXX activity_object;
        private String image;
        private int quantity;
        private int max_selling_price;
        private int original_amo;
        private int variant_price;
        private int final_discount;
        private String formatted_variant_price;
        private String price_line;
        private String product_name;
        private String sale_price;
        private Object product_stamp;
        private String zipcode;
        private String formatted_seller_price;
        private String formatted_sale_price;
        private String size;
        private int master_product_id;
        private int min_selling_price;
        private String category;
        private String permalink;
        private String cod_message;
        private List<VariantOptionsBeanXXXXXXX> variant_options;
        private List<?> line_item_adjustments;
        private List<?> messages;

        public String getFormatted_price() {
            return formatted_price;
        }

        public void setFormatted_price(String formatted_price) {
            this.formatted_price = formatted_price;
        }

        public String getSeller() {
            return seller;
        }

        public void setSeller(String seller) {
            this.seller = seller;
        }

        public int getMin_order_qty() {
            return min_order_qty;
        }

        public void setMin_order_qty(int min_order_qty) {
            this.min_order_qty = min_order_qty;
        }

        public int getLine_item_id() {
            return line_item_id;
        }

        public void setLine_item_id(int line_item_id) {
            this.line_item_id = line_item_id;
        }

        public int getDiscount() {
            return discount;
        }

        public void setDiscount(int discount) {
            this.discount = discount;
        }

        public boolean isPrepaid_availability() {
            return prepaid_availability;
        }

        public void setPrepaid_availability(boolean prepaid_availability) {
            this.prepaid_availability = prepaid_availability;
        }

        public String getSeller_slug() {
            return seller_slug;
        }

        public void setSeller_slug(String seller_slug) {
            this.seller_slug = seller_slug;
        }

        public String getDelivery_time() {
            return delivery_time;
        }

        public void setDelivery_time(String delivery_time) {
            this.delivery_time = delivery_time;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public boolean isLiked() {
            return liked;
        }

        public void setLiked(boolean liked) {
            this.liked = liked;
        }

        public int getCategory_id() {
            return category_id;
        }

        public void setCategory_id(int category_id) {
            this.category_id = category_id;
        }

        public int getMax_item_quantity() {
            return max_item_quantity;
        }

        public void setMax_item_quantity(int max_item_quantity) {
            this.max_item_quantity = max_item_quantity;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public int getProduct_id() {
            return product_id;
        }

        public void setProduct_id(int product_id) {
            this.product_id = product_id;
        }

        public boolean isSold_out() {
            return sold_out;
        }

        public void setSold_out(boolean sold_out) {
            this.sold_out = sold_out;
        }

        public int getVariant() {
            return variant;
        }

        public void setVariant(int variant) {
            this.variant = variant;
        }

        public String getFormatted_income() {
            return formatted_income;
        }

        public void setFormatted_income(String formatted_income) {
            this.formatted_income = formatted_income;
        }

        public String getMrp_price_line() {
            return mrp_price_line;
        }

        public void setMrp_price_line(String mrp_price_line) {
            this.mrp_price_line = mrp_price_line;
        }

        public boolean isCod_availability() {
            return cod_availability;
        }

        public void setCod_availability(boolean cod_availability) {
            this.cod_availability = cod_availability;
        }

        public String getFormatted_per_item_total() {
            return formatted_per_item_total;
        }

        public void setFormatted_per_item_total(String formatted_per_item_total) {
            this.formatted_per_item_total = formatted_per_item_total;
        }

        public int getPer_item_total() {
            return per_item_total;
        }

        public void setPer_item_total(int per_item_total) {
            this.per_item_total = per_item_total;
        }

        public String getSku() {
            return sku;
        }

        public void setSku(String sku) {
            this.sku = sku;
        }

        public DeliveryTimeMessageBeanXXXXXXX getDelivery_time_message() {
            return delivery_time_message;
        }

        public void setDelivery_time_message(DeliveryTimeMessageBeanXXXXXXX delivery_time_message) {
            this.delivery_time_message = delivery_time_message;
        }

        public String getPrepaid_message() {
            return prepaid_message;
        }

        public void setPrepaid_message(String prepaid_message) {
            this.prepaid_message = prepaid_message;
        }

        public ActivityObjectBeanXXXXXXXXXXXXXXX getActivity_object() {
            return activity_object;
        }

        public void setActivity_object(ActivityObjectBeanXXXXXXXXXXXXXXX activity_object) {
            this.activity_object = activity_object;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public int getMax_selling_price() {
            return max_selling_price;
        }

        public void setMax_selling_price(int max_selling_price) {
            this.max_selling_price = max_selling_price;
        }

        public int getOriginal_amo() {
            return original_amo;
        }

        public void setOriginal_amo(int original_amo) {
            this.original_amo = original_amo;
        }

        public int getVariant_price() {
            return variant_price;
        }

        public void setVariant_price(int variant_price) {
            this.variant_price = variant_price;
        }

        public int getFinal_discount() {
            return final_discount;
        }

        public void setFinal_discount(int final_discount) {
            this.final_discount = final_discount;
        }

        public String getFormatted_variant_price() {
            return formatted_variant_price;
        }

        public void setFormatted_variant_price(String formatted_variant_price) {
            this.formatted_variant_price = formatted_variant_price;
        }

        public String getPrice_line() {
            return price_line;
        }

        public void setPrice_line(String price_line) {
            this.price_line = price_line;
        }

        public String getProduct_name() {
            return product_name;
        }

        public void setProduct_name(String product_name) {
            this.product_name = product_name;
        }

        public String getSale_price() {
            return sale_price;
        }

        public void setSale_price(String sale_price) {
            this.sale_price = sale_price;
        }

        public Object getProduct_stamp() {
            return product_stamp;
        }

        public void setProduct_stamp(Object product_stamp) {
            this.product_stamp = product_stamp;
        }

        public String getZipcode() {
            return zipcode;
        }

        public void setZipcode(String zipcode) {
            this.zipcode = zipcode;
        }

        public String getFormatted_seller_price() {
            return formatted_seller_price;
        }

        public void setFormatted_seller_price(String formatted_seller_price) {
            this.formatted_seller_price = formatted_seller_price;
        }

        public String getFormatted_sale_price() {
            return formatted_sale_price;
        }

        public void setFormatted_sale_price(String formatted_sale_price) {
            this.formatted_sale_price = formatted_sale_price;
        }

        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
        }

        public int getMaster_product_id() {
            return master_product_id;
        }

        public void setMaster_product_id(int master_product_id) {
            this.master_product_id = master_product_id;
        }

        public int getMin_selling_price() {
            return min_selling_price;
        }

        public void setMin_selling_price(int min_selling_price) {
            this.min_selling_price = min_selling_price;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getPermalink() {
            return permalink;
        }

        public void setPermalink(String permalink) {
            this.permalink = permalink;
        }

        public String getCod_message() {
            return cod_message;
        }

        public void setCod_message(String cod_message) {
            this.cod_message = cod_message;
        }

        public List<VariantOptionsBeanXXXXXXX> getVariant_options() {
            return variant_options;
        }

        public void setVariant_options(List<VariantOptionsBeanXXXXXXX> variant_options) {
            this.variant_options = variant_options;
        }

        public List<?> getLine_item_adjustments() {
            return line_item_adjustments;
        }

        public void setLine_item_adjustments(List<?> line_item_adjustments) {
            this.line_item_adjustments = line_item_adjustments;
        }

        public List<?> getMessages() {
            return messages;
        }

        public void setMessages(List<?> messages) {
            this.messages = messages;
        }

        public static class DeliveryTimeMessageBeanXXXXXXX {
            /**
             * message : COD is not available.
             * type : 0
             */

            private String message;
            private int type;

            public String getMessage() {
                return message;
            }

            public void setMessage(String message) {
                this.message = message;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }
        }

        public static class ActivityObjectBeanXXXXXXXXXXXXXXX {
            /**
             * activity_object : {"id":"P72580"}
             */

            private ActivityObjectBeanXXXXXXXXXXXXXX activity_object;

            public ActivityObjectBeanXXXXXXXXXXXXXX getActivity_object() {
                return activity_object;
            }

            public void setActivity_object(ActivityObjectBeanXXXXXXXXXXXXXX activity_object) {
                this.activity_object = activity_object;
            }

            public static class ActivityObjectBeanXXXXXXXXXXXXXX {
                /**
                 * id : P72580
                 */

                private String id;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }
            }
        }

        public static class VariantOptionsBeanXXXXXXX {
            /**
             * count_on_hand : 2
             * option_value_name : M
             * size : 25
             * corrected_count_on_hand : 2
             * name : M
             * id : 94134
             */

            private int count_on_hand;
            private String option_value_name;
            private int size;
            private int corrected_count_on_hand;
            private String name;
            private int id;

            public int getCount_on_hand() {
                return count_on_hand;
            }

            public void setCount_on_hand(int count_on_hand) {
                this.count_on_hand = count_on_hand;
            }

            public String getOption_value_name() {
                return option_value_name;
            }

            public void setOption_value_name(String option_value_name) {
                this.option_value_name = option_value_name;
            }

            public int getSize() {
                return size;
            }

            public void setSize(int size) {
                this.size = size;
            }

            public int getCorrected_count_on_hand() {
                return corrected_count_on_hand;
            }

            public void setCorrected_count_on_hand(int corrected_count_on_hand) {
                this.corrected_count_on_hand = corrected_count_on_hand;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }
        }
    }

    public static class CountryListBean {
        /**
         * code : IN
         * flag : https://images1.voonik.com/assets/flags/india.svg
         * currency_unicode : Tk.
         * updated_at : 2018-01-22T15:30:20.000+05:30
         * extra_data :
         * name : INDIA
         * created_at : null
         * currency : Tk.
         * id : 1
         * conversion_rate : 1.0
         * currency_code : BDT
         * status : active
         */

        private String code;
        private String flag;
        private String currency_unicode;
        private String updated_at;
        private String extra_data;
        private String name;
        private Object created_at;
        private String currency;
        private int id;
        private double conversion_rate;
        private String currency_code;
        private String status;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getFlag() {
            return flag;
        }

        public void setFlag(String flag) {
            this.flag = flag;
        }

        public String getCurrency_unicode() {
            return currency_unicode;
        }

        public void setCurrency_unicode(String currency_unicode) {
            this.currency_unicode = currency_unicode;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }

        public String getExtra_data() {
            return extra_data;
        }

        public void setExtra_data(String extra_data) {
            this.extra_data = extra_data;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Object getCreated_at() {
            return created_at;
        }

        public void setCreated_at(Object created_at) {
            this.created_at = created_at;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public double getConversion_rate() {
            return conversion_rate;
        }

        public void setConversion_rate(double conversion_rate) {
            this.conversion_rate = conversion_rate;
        }

        public String getCurrency_code() {
            return currency_code;
        }

        public void setCurrency_code(String currency_code) {
            this.currency_code = currency_code;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
}

