package services.responseModels.wmsModels;

import java.io.Serializable;
import java.util.List;

public class AllPickListModel {

    /**
     * pick_lists_data : [{"id":8207,"warehouse_id":100,"pick_list_type":16,"pickup_agent_id":null,"status":"created","vaccount_id":1,"created_at":"2020-06-29T12:46:24.000+06:00","updated_at":"2020-06-29T12:46:24.000+06:00","status_code":"CREATED","reason_code":"PHOTOSHOOT","total_quantity":2,"pick_list_items":[{"id":99466,"pick_list_id":8207,"warehouse_bin_id":3238,"variant_id":7766,"quantity":2,"picked_quantity":0,"status":"open_items","parent_id":null,"vaccount_id":1,"created_at":"2020-06-29T12:46:25.000+06:00","updated_at":"2020-06-29T12:46:25.000+06:00","warehouse_bin":{"id":3238,"warehouse_id":100,"zone_type":10,"bin_type":20,"floor_id":2,"row_id":1,"column_id":1,"rack_id":1,"bin_id":31,"bin_code":"W100F2R1C1RA1B31","capacity":10,"packages_assignable":0,"active":true,"vaccount_id":1,"created_at":"2020-02-10T17:49:04.000+06:00","updated_at":"2020-06-24T15:39:30.000+06:00"},"variant":{"id":7766,"seller_id":29,"category_id":1892,"sku_code":"139743","notes":"Gray Men's  Full Sleeve T-Shirt - DFW1332","price":"250.0","mrp":"300.0","reorder_point":20,"active":true,"vaccount_id":1,"created_at":"2020-05-04T12:51:46.000+06:00","updated_at":"2020-05-04T12:51:46.000+06:00"}}]},{"id":8206,"warehouse_id":100,"pick_list_type":16,"pickup_agent_id":null,"status":"created","vaccount_id":1,"created_at":"2020-06-29T12:29:33.000+06:00","updated_at":"2020-06-29T12:29:33.000+06:00","status_code":"CREATED","reason_code":"PHOTOSHOOT","total_quantity":2,"pick_list_items":[{"id":99465,"pick_list_id":8206,"warehouse_bin_id":3304,"variant_id":7766,"quantity":2,"picked_quantity":0,"status":"open_items","parent_id":null,"vaccount_id":1,"created_at":"2020-06-29T12:29:33.000+06:00","updated_at":"2020-06-29T12:29:33.000+06:00","warehouse_bin":{"id":3304,"warehouse_id":100,"zone_type":10,"bin_type":20,"floor_id":2,"row_id":1,"column_id":1,"rack_id":4,"bin_id":11,"bin_code":"W100F2R1C1RA4B11","capacity":10,"packages_assignable":0,"active":true,"vaccount_id":1,"created_at":"2020-02-10T17:49:20.000+06:00","updated_at":"2020-06-24T15:39:41.000+06:00"},"variant":{"id":7766,"seller_id":29,"category_id":1892,"sku_code":"139743","notes":"Gray Men's  Full Sleeve T-Shirt - DFW1332","price":"250.0","mrp":"300.0","reorder_point":20,"active":true,"vaccount_id":1,"created_at":"2020-05-04T12:51:46.000+06:00","updated_at":"2020-05-04T12:51:46.000+06:00"}}]},{"id":8205,"warehouse_id":100,"pick_list_type":16,"pickup_agent_id":null,"status":"created","vaccount_id":1,"created_at":"2020-06-29T12:22:16.000+06:00","updated_at":"2020-06-29T12:22:16.000+06:00","status_code":"CREATED","reason_code":"PHOTOSHOOT","total_quantity":0,"pick_list_items":[]},{"id":8204,"warehouse_id":100,"pick_list_type":16,"pickup_agent_id":null,"status":"created","vaccount_id":1,"created_at":"2020-06-29T12:16:43.000+06:00","updated_at":"2020-06-29T12:16:43.000+06:00","status_code":"CREATED","reason_code":"PHOTOSHOOT","total_quantity":0,"pick_list_items":[]},{"id":8203,"warehouse_id":100,"pick_list_type":16,"pickup_agent_id":null,"status":"created","vaccount_id":1,"created_at":"2020-06-29T12:04:32.000+06:00","updated_at":"2020-06-29T12:04:32.000+06:00","status_code":"CREATED","reason_code":"PHOTOSHOOT","total_quantity":2,"pick_list_items":[{"id":99464,"pick_list_id":8203,"warehouse_bin_id":3293,"variant_id":7767,"quantity":2,"picked_quantity":0,"status":"open_items","parent_id":null,"vaccount_id":1,"created_at":"2020-06-29T12:04:33.000+06:00","updated_at":"2020-06-29T12:04:33.000+06:00","warehouse_bin":{"id":3293,"warehouse_id":100,"zone_type":10,"bin_type":20,"floor_id":2,"row_id":1,"column_id":1,"rack_id":3,"bin_id":52,"bin_code":"W100F2R1C1RA3B52","capacity":10,"packages_assignable":0,"active":true,"vaccount_id":1,"created_at":"2020-02-10T17:49:17.000+06:00","updated_at":"2020-06-09T17:24:50.000+06:00"},"variant":{"id":7767,"seller_id":29,"category_id":1892,"sku_code":"139744","notes":"Maroon Men's Full Sleeve T-Shirt - DFW1334 - 5LJ1 2813 1A00","price":"250.0","mrp":"300.0","reorder_point":20,"active":true,"vaccount_id":1,"created_at":"2020-05-04T12:51:56.000+06:00","updated_at":"2020-05-04T12:51:56.000+06:00"}}]},{"id":8202,"warehouse_id":100,"pick_list_type":16,"pickup_agent_id":null,"status":"created","vaccount_id":1,"created_at":"2020-06-29T11:18:49.000+06:00","updated_at":"2020-06-29T11:18:49.000+06:00","status_code":"CREATED","reason_code":"PHOTOSHOOT","total_quantity":2,"pick_list_items":[{"id":99463,"pick_list_id":8202,"warehouse_bin_id":3293,"variant_id":7767,"quantity":2,"picked_quantity":0,"status":"open_items","parent_id":null,"vaccount_id":1,"created_at":"2020-06-29T11:18:49.000+06:00","updated_at":"2020-06-29T11:18:49.000+06:00","warehouse_bin":{"id":3293,"warehouse_id":100,"zone_type":10,"bin_type":20,"floor_id":2,"row_id":1,"column_id":1,"rack_id":3,"bin_id":52,"bin_code":"W100F2R1C1RA3B52","capacity":10,"packages_assignable":0,"active":true,"vaccount_id":1,"created_at":"2020-02-10T17:49:17.000+06:00","updated_at":"2020-06-09T17:24:50.000+06:00"},"variant":{"id":7767,"seller_id":29,"category_id":1892,"sku_code":"139744","notes":"Maroon Men's Full Sleeve T-Shirt - DFW1334 - 5LJ1 2813 1A00","price":"250.0","mrp":"300.0","reorder_point":20,"active":true,"vaccount_id":1,"created_at":"2020-05-04T12:51:56.000+06:00","updated_at":"2020-05-04T12:51:56.000+06:00"}}]},{"id":8201,"warehouse_id":100,"pick_list_type":16,"pickup_agent_id":null,"status":"created","vaccount_id":1,"created_at":"2020-06-29T11:14:58.000+06:00","updated_at":"2020-06-29T11:14:58.000+06:00","status_code":"CREATED","reason_code":"PHOTOSHOOT","total_quantity":2,"pick_list_items":[{"id":99462,"pick_list_id":8201,"warehouse_bin_id":3293,"variant_id":7767,"quantity":2,"picked_quantity":0,"status":"open_items","parent_id":null,"vaccount_id":1,"created_at":"2020-06-29T11:14:59.000+06:00","updated_at":"2020-06-29T11:14:59.000+06:00","warehouse_bin":{"id":3293,"warehouse_id":100,"zone_type":10,"bin_type":20,"floor_id":2,"row_id":1,"column_id":1,"rack_id":3,"bin_id":52,"bin_code":"W100F2R1C1RA3B52","capacity":10,"packages_assignable":0,"active":true,"vaccount_id":1,"created_at":"2020-02-10T17:49:17.000+06:00","updated_at":"2020-06-09T17:24:50.000+06:00"},"variant":{"id":7767,"seller_id":29,"category_id":1892,"sku_code":"139744","notes":"Maroon Men's Full Sleeve T-Shirt - DFW1334 - 5LJ1 2813 1A00","price":"250.0","mrp":"300.0","reorder_point":20,"active":true,"vaccount_id":1,"created_at":"2020-05-04T12:51:56.000+06:00","updated_at":"2020-05-04T12:51:56.000+06:00"}}]},{"id":8200,"warehouse_id":100,"pick_list_type":16,"pickup_agent_id":null,"status":"created","vaccount_id":1,"created_at":"2020-06-29T10:57:47.000+06:00","updated_at":"2020-06-29T10:57:47.000+06:00","status_code":"CREATED","reason_code":"PHOTOSHOOT","total_quantity":2,"pick_list_items":[{"id":99461,"pick_list_id":8200,"warehouse_bin_id":3293,"variant_id":7767,"quantity":2,"picked_quantity":0,"status":"open_items","parent_id":null,"vaccount_id":1,"created_at":"2020-06-29T10:57:47.000+06:00","updated_at":"2020-06-29T10:57:47.000+06:00","warehouse_bin":{"id":3293,"warehouse_id":100,"zone_type":10,"bin_type":20,"floor_id":2,"row_id":1,"column_id":1,"rack_id":3,"bin_id":52,"bin_code":"W100F2R1C1RA3B52","capacity":10,"packages_assignable":0,"active":true,"vaccount_id":1,"created_at":"2020-02-10T17:49:17.000+06:00","updated_at":"2020-06-09T17:24:50.000+06:00"},"variant":{"id":7767,"seller_id":29,"category_id":1892,"sku_code":"139744","notes":"Maroon Men's Full Sleeve T-Shirt - DFW1334 - 5LJ1 2813 1A00","price":"250.0","mrp":"300.0","reorder_point":20,"active":true,"vaccount_id":1,"created_at":"2020-05-04T12:51:56.000+06:00","updated_at":"2020-05-04T12:51:56.000+06:00"}}]},{"id":8199,"warehouse_id":100,"pick_list_type":16,"pickup_agent_id":null,"status":"created","vaccount_id":1,"created_at":"2020-06-29T10:55:12.000+06:00","updated_at":"2020-06-29T10:55:12.000+06:00","status_code":"CREATED","reason_code":"PHOTOSHOOT","total_quantity":2,"pick_list_items":[{"id":99460,"pick_list_id":8199,"warehouse_bin_id":3293,"variant_id":7767,"quantity":2,"picked_quantity":0,"status":"open_items","parent_id":null,"vaccount_id":1,"created_at":"2020-06-29T10:55:13.000+06:00","updated_at":"2020-06-29T10:55:13.000+06:00","warehouse_bin":{"id":3293,"warehouse_id":100,"zone_type":10,"bin_type":20,"floor_id":2,"row_id":1,"column_id":1,"rack_id":3,"bin_id":52,"bin_code":"W100F2R1C1RA3B52","capacity":10,"packages_assignable":0,"active":true,"vaccount_id":1,"created_at":"2020-02-10T17:49:17.000+06:00","updated_at":"2020-06-09T17:24:50.000+06:00"},"variant":{"id":7767,"seller_id":29,"category_id":1892,"sku_code":"139744","notes":"Maroon Men's Full Sleeve T-Shirt - DFW1334 - 5LJ1 2813 1A00","price":"250.0","mrp":"300.0","reorder_point":20,"active":true,"vaccount_id":1,"created_at":"2020-05-04T12:51:56.000+06:00","updated_at":"2020-05-04T12:51:56.000+06:00"}}]},{"id":8198,"warehouse_id":100,"pick_list_type":16,"pickup_agent_id":null,"status":"created","vaccount_id":1,"created_at":"2020-06-29T10:49:54.000+06:00","updated_at":"2020-06-29T10:49:54.000+06:00","status_code":"CREATED","reason_code":"PHOTOSHOOT","total_quantity":2,"pick_list_items":[{"id":99459,"pick_list_id":8198,"warehouse_bin_id":3322,"variant_id":7767,"quantity":2,"picked_quantity":0,"status":"open_items","parent_id":null,"vaccount_id":1,"created_at":"2020-06-29T10:49:54.000+06:00","updated_at":"2020-06-29T10:49:54.000+06:00","warehouse_bin":{"id":3322,"warehouse_id":100,"zone_type":10,"bin_type":20,"floor_id":2,"row_id":1,"column_id":1,"rack_id":4,"bin_id":71,"bin_code":"W100F2R1C1RA4B71","capacity":10,"packages_assignable":6,"active":true,"vaccount_id":1,"created_at":"2020-02-10T17:49:24.000+06:00","updated_at":"2020-06-22T09:43:55.000+06:00"},"variant":{"id":7767,"seller_id":29,"category_id":1892,"sku_code":"139744","notes":"Maroon Men's Full Sleeve T-Shirt - DFW1334 - 5LJ1 2813 1A00","price":"250.0","mrp":"300.0","reorder_point":20,"active":true,"vaccount_id":1,"created_at":"2020-05-04T12:51:56.000+06:00","updated_at":"2020-05-04T12:51:56.000+06:00"}}]},{"id":8197,"warehouse_id":100,"pick_list_type":20,"pickup_agent_id":null,"status":"closed","vaccount_id":1,"created_at":"2020-06-28T19:57:48.000+06:00","updated_at":"2020-06-28T19:58:12.000+06:00","status_code":"CLOSED","reason_code":"UNICORN","total_quantity":6,"pick_list_items":[{"id":99455,"pick_list_id":8197,"warehouse_bin_id":3287,"variant_id":8077,"quantity":1,"picked_quantity":1,"status":"picked","parent_id":null,"vaccount_id":1,"created_at":"2020-06-28T19:57:48.000+06:00","updated_at":"2020-06-28T19:58:12.000+06:00","warehouse_bin":{"id":3287,"warehouse_id":100,"zone_type":10,"bin_type":20,"floor_id":2,"row_id":1,"column_id":1,"rack_id":3,"bin_id":32,"bin_code":"W100F2R1C1RA3B32","capacity":10,"packages_assignable":0,"active":true,"vaccount_id":1,"created_at":"2020-02-10T17:49:16.000+06:00","updated_at":"2020-06-29T20:55:01.000+06:00"},"variant":{"id":8077,"seller_id":29,"category_id":1892,"sku_code":"293553","notes":"Stylish Gents Jacket for Winter - Navy Blue - DFW","price":"390.0","mrp":"468.0","reorder_point":20,"active":true,"vaccount_id":1,"created_at":"2020-05-04T12:56:41.000+06:00","updated_at":"2020-05-04T12:56:41.000+06:00"}},{"id":99456,"pick_list_id":8197,"warehouse_bin_id":3306,"variant_id":8078,"quantity":2,"picked_quantity":2,"status":"picked","parent_id":null,"vaccount_id":1,"created_at":"2020-06-28T19:57:49.000+06:00","updated_at":"2020-06-28T19:58:11.000+06:00","warehouse_bin":{"id":3306,"warehouse_id":100,"zone_type":10,"bin_type":20,"floor_id":2,"row_id":1,"column_id":1,"rack_id":4,"bin_id":13,"bin_code":"W100F2R1C1RA4B13","capacity":10,"packages_assignable":0,"active":true,"vaccount_id":1,"created_at":"2020-02-10T17:49:20.000+06:00","updated_at":"2020-06-30T19:05:46.000+06:00"},"variant":{"id":8078,"seller_id":29,"category_id":1892,"sku_code":"293554","notes":"Stylish Gents Jacket for Winter - Navy Blue - DFW","price":"390.0","mrp":"468.0","reorder_point":20,"active":true,"vaccount_id":1,"created_at":"2020-05-04T12:56:41.000+06:00","updated_at":"2020-05-04T12:56:41.000+06:00"}},{"id":99458,"pick_list_id":8197,"warehouse_bin_id":3306,"variant_id":8079,"quantity":1,"picked_quantity":1,"status":"picked","parent_id":null,"vaccount_id":1,"created_at":"2020-06-28T19:57:49.000+06:00","updated_at":"2020-06-28T19:58:12.000+06:00","warehouse_bin":{"id":3306,"warehouse_id":100,"zone_type":10,"bin_type":20,"floor_id":2,"row_id":1,"column_id":1,"rack_id":4,"bin_id":13,"bin_code":"W100F2R1C1RA4B13","capacity":10,"packages_assignable":0,"active":true,"vaccount_id":1,"created_at":"2020-02-10T17:49:20.000+06:00","updated_at":"2020-06-30T19:05:46.000+06:00"},"variant":{"id":8079,"seller_id":29,"category_id":1892,"sku_code":"293555","notes":"Stylish Gents Jacket for Winter - Navy Blue - DFW","price":"390.0","mrp":"468.0","reorder_point":20,"active":true,"vaccount_id":1,"created_at":"2020-05-04T12:56:42.000+06:00","updated_at":"2020-05-04T12:56:42.000+06:00"}},{"id":99454,"pick_list_id":8197,"warehouse_bin_id":3311,"variant_id":8077,"quantity":1,"picked_quantity":1,"status":"picked","parent_id":null,"vaccount_id":1,"created_at":"2020-06-28T19:57:48.000+06:00","updated_at":"2020-06-28T19:58:12.000+06:00","warehouse_bin":{"id":3311,"warehouse_id":100,"zone_type":10,"bin_type":20,"floor_id":2,"row_id":1,"column_id":1,"rack_id":4,"bin_id":32,"bin_code":"W100F2R1C1RA4B32","capacity":10,"packages_assignable":0,"active":true,"vaccount_id":1,"created_at":"2020-02-10T17:49:22.000+06:00","updated_at":"2020-06-29T21:11:07.000+06:00"},"variant":{"id":8077,"seller_id":29,"category_id":1892,"sku_code":"293553","notes":"Stylish Gents Jacket for Winter - Navy Blue - DFW","price":"390.0","mrp":"468.0","reorder_point":20,"active":true,"vaccount_id":1,"created_at":"2020-05-04T12:56:41.000+06:00","updated_at":"2020-05-04T12:56:41.000+06:00"}},{"id":99457,"pick_list_id":8197,"warehouse_bin_id":3321,"variant_id":8079,"quantity":1,"picked_quantity":1,"status":"picked","parent_id":null,"vaccount_id":1,"created_at":"2020-06-28T19:57:49.000+06:00","updated_at":"2020-06-28T19:58:12.000+06:00","warehouse_bin":{"id":3321,"warehouse_id":100,"zone_type":10,"bin_type":20,"floor_id":2,"row_id":1,"column_id":1,"rack_id":4,"bin_id":63,"bin_code":"W100F2R1C1RA4B63","capacity":10,"packages_assignable":2,"active":true,"vaccount_id":1,"created_at":"2020-02-10T17:49:24.000+06:00","updated_at":"2020-06-30T19:05:46.000+06:00"},"variant":{"id":8079,"seller_id":29,"category_id":1892,"sku_code":"293555","notes":"Stylish Gents Jacket for Winter - Navy Blue - DFW","price":"390.0","mrp":"468.0","reorder_point":20,"active":true,"vaccount_id":1,"created_at":"2020-05-04T12:56:42.000+06:00","updated_at":"2020-05-04T12:56:42.000+06:00"}}]},{"id":8196,"warehouse_id":100,"pick_list_type":20,"pickup_agent_id":null,"status":"created","vaccount_id":1,"created_at":"2020-06-28T19:46:53.000+06:00","updated_at":"2020-06-28T19:46:53.000+06:00","status_code":"CREATED","reason_code":"UNICORN","total_quantity":8,"pick_list_items":[{"id":99450,"pick_list_id":8196,"warehouse_bin_id":3287,"variant_id":7767,"quantity":2,"picked_quantity":0,"status":"open_items","parent_id":null,"vaccount_id":1,"created_at":"2020-06-28T19:46:55.000+06:00","updated_at":"2020-06-28T19:46:56.000+06:00","warehouse_bin":{"id":3287,"warehouse_id":100,"zone_type":10,"bin_type":20,"floor_id":2,"row_id":1,"column_id":1,"rack_id":3,"bin_id":32,"bin_code":"W100F2R1C1RA3B32","capacity":10,"packages_assignable":0,"active":true,"vaccount_id":1,"created_at":"2020-02-10T17:49:16.000+06:00","updated_at":"2020-06-29T20:55:01.000+06:00"},"variant":{"id":7767,"seller_id":29,"category_id":1892,"sku_code":"139744","notes":"Maroon Men's Full Sleeve T-Shirt - DFW1334 - 5LJ1 2813 1A00","price":"250.0","mrp":"300.0","reorder_point":20,"active":true,"vaccount_id":1,"created_at":"2020-05-04T12:51:56.000+06:00","updated_at":"2020-05-04T12:51:56.000+06:00"}},{"id":99453,"pick_list_id":8196,"warehouse_bin_id":3302,"variant_id":7773,"quantity":2,"picked_quantity":0,"status":"open_items","parent_id":null,"vaccount_id":1,"created_at":"2020-06-28T19:46:59.000+06:00","updated_at":"2020-06-28T19:47:00.000+06:00","warehouse_bin":{"id":3302,"warehouse_id":100,"zone_type":10,"bin_type":20,"floor_id":2,"row_id":1,"column_id":1,"rack_id":3,"bin_id":82,"bin_code":"W100F2R1C1RA3B82","capacity":10,"packages_assignable":5,"active":true,"vaccount_id":1,"created_at":"2020-02-10T17:49:20.000+06:00","updated_at":"2020-06-22T09:48:47.000+06:00"},"variant":{"id":7773,"seller_id":29,"category_id":1892,"sku_code":"139750","notes":"Men's Cotton Full Sleeve T-Shirt Black with Ash Neck Border Design  - DFW1339 - 5LJ1 2818 1A00","price":"299.0","mrp":"350.0","reorder_point":20,"active":true,"vaccount_id":1,"created_at":"2020-05-04T12:52:00.000+06:00","updated_at":"2020-05-04T12:52:00.000+06:00"}},{"id":99452,"pick_list_id":8196,"warehouse_bin_id":3321,"variant_id":7773,"quantity":3,"picked_quantity":0,"status":"open_items","parent_id":null,"vaccount_id":1,"created_at":"2020-06-28T19:46:57.000+06:00","updated_at":"2020-06-28T19:46:59.000+06:00","warehouse_bin":{"id":3321,"warehouse_id":100,"zone_type":10,"bin_type":20,"floor_id":2,"row_id":1,"column_id":1,"rack_id":4,"bin_id":63,"bin_code":"W100F2R1C1RA4B63","capacity":10,"packages_assignable":2,"active":true,"vaccount_id":1,"created_at":"2020-02-10T17:49:24.000+06:00","updated_at":"2020-06-30T19:05:46.000+06:00"},"variant":{"id":7773,"seller_id":29,"category_id":1892,"sku_code":"139750","notes":"Men's Cotton Full Sleeve T-Shirt Black with Ash Neck Border Design  - DFW1339 - 5LJ1 2818 1A00","price":"299.0","mrp":"350.0","reorder_point":20,"active":true,"vaccount_id":1,"created_at":"2020-05-04T12:52:00.000+06:00","updated_at":"2020-05-04T12:52:00.000+06:00"}},{"id":99451,"pick_list_id":8196,"warehouse_bin_id":3322,"variant_id":7767,"quantity":1,"picked_quantity":0,"status":"open_items","parent_id":null,"vaccount_id":1,"created_at":"2020-06-28T19:46:56.000+06:00","updated_at":"2020-06-28T19:46:56.000+06:00","warehouse_bin":{"id":3322,"warehouse_id":100,"zone_type":10,"bin_type":20,"floor_id":2,"row_id":1,"column_id":1,"rack_id":4,"bin_id":71,"bin_code":"W100F2R1C1RA4B71","capacity":10,"packages_assignable":6,"active":true,"vaccount_id":1,"created_at":"2020-02-10T17:49:24.000+06:00","updated_at":"2020-06-22T09:43:55.000+06:00"},"variant":{"id":7767,"seller_id":29,"category_id":1892,"sku_code":"139744","notes":"Maroon Men's Full Sleeve T-Shirt - DFW1334 - 5LJ1 2813 1A00","price":"250.0","mrp":"300.0","reorder_point":20,"active":true,"vaccount_id":1,"created_at":"2020-05-04T12:51:56.000+06:00","updated_at":"2020-05-04T12:51:56.000+06:00"}}]},{"id":8195,"warehouse_id":100,"pick_list_type":20,"pickup_agent_id":null,"status":"created","vaccount_id":1,"created_at":"2020-06-28T16:27:50.000+06:00","updated_at":"2020-06-28T16:27:50.000+06:00","status_code":"CREATED","reason_code":"UNICORN","total_quantity":0,"pick_list_items":[]},{"id":8194,"warehouse_id":100,"pick_list_type":20,"pickup_agent_id":null,"status":"created","vaccount_id":1,"created_at":"2020-06-28T16:21:42.000+06:00","updated_at":"2020-06-28T16:21:42.000+06:00","status_code":"CREATED","reason_code":"UNICORN","total_quantity":0,"pick_list_items":[]},{"id":8193,"warehouse_id":100,"pick_list_type":20,"pickup_agent_id":null,"status":"out_for_pickup","vaccount_id":1,"created_at":"2020-06-28T16:15:14.000+06:00","updated_at":"2020-06-28T16:15:21.000+06:00","status_code":"OUT_FOR_PICKUP","reason_code":"UNICORN","total_quantity":0,"pick_list_items":[]},{"id":8192,"warehouse_id":100,"pick_list_type":20,"pickup_agent_id":null,"status":"out_for_pickup","vaccount_id":1,"created_at":"2020-06-28T10:40:41.000+06:00","updated_at":"2020-06-28T10:40:47.000+06:00","status_code":"OUT_FOR_PICKUP","reason_code":"UNICORN","total_quantity":0,"pick_list_items":[]},{"id":8191,"warehouse_id":100,"pick_list_type":20,"pickup_agent_id":null,"status":"out_for_pickup","vaccount_id":1,"created_at":"2020-06-28T10:38:20.000+06:00","updated_at":"2020-06-28T10:39:48.000+06:00","status_code":"OUT_FOR_PICKUP","reason_code":"UNICORN","total_quantity":2,"pick_list_items":[{"id":99448,"pick_list_id":8191,"warehouse_bin_id":3311,"variant_id":7768,"quantity":1,"picked_quantity":0,"status":"open_items","parent_id":null,"vaccount_id":1,"created_at":"2020-06-28T10:38:21.000+06:00","updated_at":"2020-06-28T10:38:21.000+06:00","warehouse_bin":{"id":3311,"warehouse_id":100,"zone_type":10,"bin_type":20,"floor_id":2,"row_id":1,"column_id":1,"rack_id":4,"bin_id":32,"bin_code":"W100F2R1C1RA4B32","capacity":10,"packages_assignable":0,"active":true,"vaccount_id":1,"created_at":"2020-02-10T17:49:22.000+06:00","updated_at":"2020-06-29T21:11:07.000+06:00"},"variant":{"id":7768,"seller_id":29,"category_id":1892,"sku_code":"139745","notes":"Red Men's  Full Sleeve T-Shirt - DFW1333","price":"250.0","mrp":"300.0","reorder_point":20,"active":true,"vaccount_id":1,"created_at":"2020-05-04T12:51:57.000+06:00","updated_at":"2020-05-04T12:51:57.000+06:00"}},{"id":99449,"pick_list_id":8191,"warehouse_bin_id":3313,"variant_id":7768,"quantity":1,"picked_quantity":0,"status":"open_items","parent_id":null,"vaccount_id":1,"created_at":"2020-06-28T10:38:21.000+06:00","updated_at":"2020-06-28T10:38:21.000+06:00","warehouse_bin":{"id":3313,"warehouse_id":100,"zone_type":10,"bin_type":20,"floor_id":2,"row_id":1,"column_id":1,"rack_id":4,"bin_id":41,"bin_code":"W100F2R1C1RA4B41","capacity":10,"packages_assignable":0,"active":true,"vaccount_id":1,"created_at":"2020-02-10T17:49:22.000+06:00","updated_at":"2020-06-24T15:39:25.000+06:00"},"variant":{"id":7768,"seller_id":29,"category_id":1892,"sku_code":"139745","notes":"Red Men's  Full Sleeve T-Shirt - DFW1333","price":"250.0","mrp":"300.0","reorder_point":20,"active":true,"vaccount_id":1,"created_at":"2020-05-04T12:51:57.000+06:00","updated_at":"2020-05-04T12:51:57.000+06:00"}}]},{"id":8190,"warehouse_id":100,"pick_list_type":20,"pickup_agent_id":null,"status":"closed","vaccount_id":1,"created_at":"2020-06-28T10:35:12.000+06:00","updated_at":"2020-06-28T10:35:39.000+06:00","status_code":"CLOSED","reason_code":"UNICORN","total_quantity":4,"pick_list_items":[{"id":99444,"pick_list_id":8190,"warehouse_bin_id":3241,"variant_id":7767,"quantity":1,"picked_quantity":1,"status":"picked","parent_id":null,"vaccount_id":1,"created_at":"2020-06-28T10:35:13.000+06:00","updated_at":"2020-06-28T10:35:39.000+06:00","warehouse_bin":{"id":3241,"warehouse_id":100,"zone_type":10,"bin_type":20,"floor_id":2,"row_id":1,"column_id":1,"rack_id":1,"bin_id":41,"bin_code":"W100F2R1C1RA1B41","capacity":150,"packages_assignable":150,"active":true,"vaccount_id":1,"created_at":"2020-02-10T17:49:05.000+06:00","updated_at":"2020-06-28T10:35:37.000+06:00"},"variant":{"id":7767,"seller_id":29,"category_id":1892,"sku_code":"139744","notes":"Maroon Men's Full Sleeve T-Shirt - DFW1334 - 5LJ1 2813 1A00","price":"250.0","mrp":"300.0","reorder_point":20,"active":true,"vaccount_id":1,"created_at":"2020-05-04T12:51:56.000+06:00","updated_at":"2020-05-04T12:51:56.000+06:00"}},{"id":99445,"pick_list_id":8190,"warehouse_bin_id":3287,"variant_id":7767,"quantity":1,"picked_quantity":1,"status":"picked","parent_id":null,"vaccount_id":1,"created_at":"2020-06-28T10:35:13.000+06:00","updated_at":"2020-06-28T10:35:39.000+06:00","warehouse_bin":{"id":3287,"warehouse_id":100,"zone_type":10,"bin_type":20,"floor_id":2,"row_id":1,"column_id":1,"rack_id":3,"bin_id":32,"bin_code":"W100F2R1C1RA3B32","capacity":10,"packages_assignable":0,"active":true,"vaccount_id":1,"created_at":"2020-02-10T17:49:16.000+06:00","updated_at":"2020-06-29T20:55:01.000+06:00"},"variant":{"id":7767,"seller_id":29,"category_id":1892,"sku_code":"139744","notes":"Maroon Men's Full Sleeve T-Shirt - DFW1334 - 5LJ1 2813 1A00","price":"250.0","mrp":"300.0","reorder_point":20,"active":true,"vaccount_id":1,"created_at":"2020-05-04T12:51:56.000+06:00","updated_at":"2020-05-04T12:51:56.000+06:00"}},{"id":99447,"pick_list_id":8190,"warehouse_bin_id":3306,"variant_id":7771,"quantity":1,"picked_quantity":1,"status":"picked","parent_id":null,"vaccount_id":1,"created_at":"2020-06-28T10:35:13.000+06:00","updated_at":"2020-06-28T10:35:39.000+06:00","warehouse_bin":{"id":3306,"warehouse_id":100,"zone_type":10,"bin_type":20,"floor_id":2,"row_id":1,"column_id":1,"rack_id":4,"bin_id":13,"bin_code":"W100F2R1C1RA4B13","capacity":10,"packages_assignable":0,"active":true,"vaccount_id":1,"created_at":"2020-02-10T17:49:20.000+06:00","updated_at":"2020-06-30T19:05:46.000+06:00"},"variant":{"id":7771,"seller_id":29,"category_id":1892,"sku_code":"139748","notes":"White Men's  Full Sleeve T-Shirt - DFW1337","price":"250.0","mrp":"300.0","reorder_point":20,"active":true,"vaccount_id":1,"created_at":"2020-05-04T12:51:59.000+06:00","updated_at":"2020-05-04T12:51:59.000+06:00"}},{"id":99446,"pick_list_id":8190,"warehouse_bin_id":3311,"variant_id":7771,"quantity":1,"picked_quantity":1,"status":"picked","parent_id":null,"vaccount_id":1,"created_at":"2020-06-28T10:35:13.000+06:00","updated_at":"2020-06-28T10:35:39.000+06:00","warehouse_bin":{"id":3311,"warehouse_id":100,"zone_type":10,"bin_type":20,"floor_id":2,"row_id":1,"column_id":1,"rack_id":4,"bin_id":32,"bin_code":"W100F2R1C1RA4B32","capacity":10,"packages_assignable":0,"active":true,"vaccount_id":1,"created_at":"2020-02-10T17:49:22.000+06:00","updated_at":"2020-06-29T21:11:07.000+06:00"},"variant":{"id":7771,"seller_id":29,"category_id":1892,"sku_code":"139748","notes":"White Men's  Full Sleeve T-Shirt - DFW1337","price":"250.0","mrp":"300.0","reorder_point":20,"active":true,"vaccount_id":1,"created_at":"2020-05-04T12:51:59.000+06:00","updated_at":"2020-05-04T12:51:59.000+06:00"}}]},{"id":8189,"warehouse_id":100,"pick_list_type":20,"pickup_agent_id":null,"status":"closed","vaccount_id":1,"created_at":"2020-06-22T09:50:39.000+06:00","updated_at":"2020-06-22T09:51:38.000+06:00","status_code":"CLOSED","reason_code":"UNICORN","total_quantity":15,"pick_list_items":[{"id":99438,"pick_list_id":8189,"warehouse_bin_id":3238,"variant_id":7766,"quantity":2,"picked_quantity":2,"status":"picked","parent_id":null,"vaccount_id":1,"created_at":"2020-06-22T09:50:39.000+06:00","updated_at":"2020-06-22T09:51:35.000+06:00","warehouse_bin":{"id":3238,"warehouse_id":100,"zone_type":10,"bin_type":20,"floor_id":2,"row_id":1,"column_id":1,"rack_id":1,"bin_id":31,"bin_code":"W100F2R1C1RA1B31","capacity":10,"packages_assignable":0,"active":true,"vaccount_id":1,"created_at":"2020-02-10T17:49:04.000+06:00","updated_at":"2020-06-24T15:39:30.000+06:00"},"variant":{"id":7766,"seller_id":29,"category_id":1892,"sku_code":"139743","notes":"Gray Men's  Full Sleeve T-Shirt - DFW1332","price":"250.0","mrp":"300.0","reorder_point":20,"active":true,"vaccount_id":1,"created_at":"2020-05-04T12:51:46.000+06:00","updated_at":"2020-05-04T12:51:46.000+06:00"}},{"id":99439,"pick_list_id":8189,"warehouse_bin_id":3238,"variant_id":7769,"quantity":1,"picked_quantity":1,"status":"picked","parent_id":null,"vaccount_id":1,"created_at":"2020-06-22T09:50:40.000+06:00","updated_at":"2020-06-22T09:51:38.000+06:00","warehouse_bin":{"id":3238,"warehouse_id":100,"zone_type":10,"bin_type":20,"floor_id":2,"row_id":1,"column_id":1,"rack_id":1,"bin_id":31,"bin_code":"W100F2R1C1RA1B31","capacity":10,"packages_assignable":0,"active":true,"vaccount_id":1,"created_at":"2020-02-10T17:49:04.000+06:00","updated_at":"2020-06-24T15:39:30.000+06:00"},"variant":{"id":7769,"seller_id":29,"category_id":1892,"sku_code":"139746","notes":"Navy Blue Men's  Full Sleeve T-Shirt - DFW1336","price":"250.0","mrp":"300.0","reorder_point":20,"active":true,"vaccount_id":1,"created_at":"2020-05-04T12:51:57.000+06:00","updated_at":"2020-05-04T12:51:57.000+06:00"}},{"id":99437,"pick_list_id":8189,"warehouse_bin_id":3240,"variant_id":7766,"quantity":2,"picked_quantity":1,"status":"closed","parent_id":null,"vaccount_id":1,"created_at":"2020-06-22T09:50:39.000+06:00","updated_at":"2020-06-22T09:51:36.000+06:00","warehouse_bin":{"id":3240,"warehouse_id":100,"zone_type":10,"bin_type":20,"floor_id":2,"row_id":1,"column_id":1,"rack_id":1,"bin_id":33,"bin_code":"W100F2R1C1RA1B33","capacity":10,"packages_assignable":0,"active":true,"vaccount_id":1,"created_at":"2020-02-10T17:49:04.000+06:00","updated_at":"2020-06-24T15:39:39.000+06:00"},"variant":{"id":7766,"seller_id":29,"category_id":1892,"sku_code":"139743","notes":"Gray Men's  Full Sleeve T-Shirt - DFW1332","price":"250.0","mrp":"300.0","reorder_point":20,"active":true,"vaccount_id":1,"created_at":"2020-05-04T12:51:46.000+06:00","updated_at":"2020-05-04T12:51:46.000+06:00"}},{"id":99440,"pick_list_id":8189,"warehouse_bin_id":3242,"variant_id":7769,"quantity":3,"picked_quantity":2,"status":"closed","parent_id":null,"vaccount_id":1,"created_at":"2020-06-22T09:50:40.000+06:00","updated_at":"2020-06-22T09:51:37.000+06:00","warehouse_bin":{"id":3242,"warehouse_id":100,"zone_type":10,"bin_type":20,"floor_id":2,"row_id":1,"column_id":1,"rack_id":1,"bin_id":42,"bin_code":"W100F2R1C1RA1B42","capacity":10,"packages_assignable":0,"active":true,"vaccount_id":1,"created_at":"2020-02-10T17:49:05.000+06:00","updated_at":"2020-06-22T09:52:10.000+06:00"},"variant":{"id":7769,"seller_id":29,"category_id":1892,"sku_code":"139746","notes":"Navy Blue Men's  Full Sleeve T-Shirt - DFW1336","price":"250.0","mrp":"300.0","reorder_point":20,"active":true,"vaccount_id":1,"created_at":"2020-05-04T12:51:57.000+06:00","updated_at":"2020-05-04T12:51:57.000+06:00"}},{"id":99443,"pick_list_id":8189,"warehouse_bin_id":3306,"variant_id":7771,"quantity":5,"picked_quantity":2,"status":"closed","parent_id":null,"vaccount_id":1,"created_at":"2020-06-22T09:50:40.000+06:00","updated_at":"2020-06-22T09:51:38.000+06:00","warehouse_bin":{"id":3306,"warehouse_id":100,"zone_type":10,"bin_type":20,"floor_id":2,"row_id":1,"column_id":1,"rack_id":4,"bin_id":13,"bin_code":"W100F2R1C1RA4B13","capacity":10,"packages_assignable":0,"active":true,"vaccount_id":1,"created_at":"2020-02-10T17:49:20.000+06:00","updated_at":"2020-06-30T19:05:46.000+06:00"},"variant":{"id":7771,"seller_id":29,"category_id":1892,"sku_code":"139748","notes":"White Men's  Full Sleeve T-Shirt - DFW1337","price":"250.0","mrp":"300.0","reorder_point":20,"active":true,"vaccount_id":1,"created_at":"2020-05-04T12:51:59.000+06:00","updated_at":"2020-05-04T12:51:59.000+06:00"}},{"id":99441,"pick_list_id":8189,"warehouse_bin_id":3306,"variant_id":7769,"quantity":1,"picked_quantity":0,"status":"closed","parent_id":null,"vaccount_id":1,"created_at":"2020-06-22T09:50:40.000+06:00","updated_at":"2020-06-22T09:51:37.000+06:00","warehouse_bin":{"id":3306,"warehouse_id":100,"zone_type":10,"bin_type":20,"floor_id":2,"row_id":1,"column_id":1,"rack_id":4,"bin_id":13,"bin_code":"W100F2R1C1RA4B13","capacity":10,"packages_assignable":0,"active":true,"vaccount_id":1,"created_at":"2020-02-10T17:49:20.000+06:00","updated_at":"2020-06-30T19:05:46.000+06:00"},"variant":{"id":7769,"seller_id":29,"category_id":1892,"sku_code":"139746","notes":"Navy Blue Men's  Full Sleeve T-Shirt - DFW1336","price":"250.0","mrp":"300.0","reorder_point":20,"active":true,"vaccount_id":1,"created_at":"2020-05-04T12:51:57.000+06:00","updated_at":"2020-05-04T12:51:57.000+06:00"}},{"id":99442,"pick_list_id":8189,"warehouse_bin_id":3311,"variant_id":7771,"quantity":1,"picked_quantity":0,"status":"closed","parent_id":null,"vaccount_id":1,"created_at":"2020-06-22T09:50:40.000+06:00","updated_at":"2020-06-22T09:51:38.000+06:00","warehouse_bin":{"id":3311,"warehouse_id":100,"zone_type":10,"bin_type":20,"floor_id":2,"row_id":1,"column_id":1,"rack_id":4,"bin_id":32,"bin_code":"W100F2R1C1RA4B32","capacity":10,"packages_assignable":0,"active":true,"vaccount_id":1,"created_at":"2020-02-10T17:49:22.000+06:00","updated_at":"2020-06-29T21:11:07.000+06:00"},"variant":{"id":7771,"seller_id":29,"category_id":1892,"sku_code":"139748","notes":"White Men's  Full Sleeve T-Shirt - DFW1337","price":"250.0","mrp":"300.0","reorder_point":20,"active":true,"vaccount_id":1,"created_at":"2020-05-04T12:51:59.000+06:00","updated_at":"2020-05-04T12:51:59.000+06:00"}}]},{"id":8188,"warehouse_id":100,"pick_list_type":20,"pickup_agent_id":null,"status":"closed","vaccount_id":1,"created_at":"2020-06-22T09:48:17.000+06:00","updated_at":"2020-06-22T09:48:48.000+06:00","status_code":"CLOSED","reason_code":"UNICORN","total_quantity":4,"pick_list_items":[{"id":99435,"pick_list_id":8188,"warehouse_bin_id":3302,"variant_id":8928,"quantity":1,"picked_quantity":1,"status":"picked","parent_id":null,"vaccount_id":1,"created_at":"2020-06-22T09:48:17.000+06:00","updated_at":"2020-06-22T09:48:48.000+06:00","warehouse_bin":{"id":3302,"warehouse_id":100,"zone_type":10,"bin_type":20,"floor_id":2,"row_id":1,"column_id":1,"rack_id":3,"bin_id":82,"bin_code":"W100F2R1C1RA3B82","capacity":10,"packages_assignable":5,"active":true,"vaccount_id":1,"created_at":"2020-02-10T17:49:20.000+06:00","updated_at":"2020-06-22T09:48:47.000+06:00"},"variant":{"id":8928,"seller_id":33,"category_id":1892,"sku_code":"156020","notes":"Fepic Sanober Blockbuster Vol-4 Suits 0050B Net with Pink Color-ASI1589-G77O 7961 1A00","price":"2120.0","mrp":"2544.0","reorder_point":20,"active":true,"vaccount_id":1,"created_at":"2020-06-03T13:27:03.000+06:00","updated_at":"2020-06-03T13:27:03.000+06:00"}},{"id":99436,"pick_list_id":8188,"warehouse_bin_id":3304,"variant_id":8928,"quantity":3,"picked_quantity":2,"status":"closed","parent_id":null,"vaccount_id":1,"created_at":"2020-06-22T09:48:18.000+06:00","updated_at":"2020-06-22T09:48:48.000+06:00","warehouse_bin":{"id":3304,"warehouse_id":100,"zone_type":10,"bin_type":20,"floor_id":2,"row_id":1,"column_id":1,"rack_id":4,"bin_id":11,"bin_code":"W100F2R1C1RA4B11","capacity":10,"packages_assignable":0,"active":true,"vaccount_id":1,"created_at":"2020-02-10T17:49:20.000+06:00","updated_at":"2020-06-24T15:39:41.000+06:00"},"variant":{"id":8928,"seller_id":33,"category_id":1892,"sku_code":"156020","notes":"Fepic Sanober Blockbuster Vol-4 Suits 0050B Net with Pink Color-ASI1589-G77O 7961 1A00","price":"2120.0","mrp":"2544.0","reorder_point":20,"active":true,"vaccount_id":1,"created_at":"2020-06-03T13:27:03.000+06:00","updated_at":"2020-06-03T13:27:03.000+06:00"}}]},{"id":8187,"warehouse_id":100,"pick_list_type":20,"pickup_agent_id":null,"status":"closed","vaccount_id":1,"created_at":"2020-06-22T09:42:23.000+06:00","updated_at":"2020-06-22T09:43:55.000+06:00","status_code":"CLOSED","reason_code":"UNICORN","total_quantity":13,"pick_list_items":[{"id":99429,"pick_list_id":8187,"warehouse_bin_id":3238,"variant_id":7769,"quantity":1,"picked_quantity":1,"status":"picked","parent_id":null,"vaccount_id":1,"created_at":"2020-06-22T09:42:24.000+06:00","updated_at":"2020-06-22T09:43:55.000+06:00","warehouse_bin":{"id":3238,"warehouse_id":100,"zone_type":10,"bin_type":20,"floor_id":2,"row_id":1,"column_id":1,"rack_id":1,"bin_id":31,"bin_code":"W100F2R1C1RA1B31","capacity":10,"packages_assignable":0,"active":true,"vaccount_id":1,"created_at":"2020-02-10T17:49:04.000+06:00","updated_at":"2020-06-24T15:39:30.000+06:00"},"variant":{"id":7769,"seller_id":29,"category_id":1892,"sku_code":"139746","notes":"Navy Blue Men's  Full Sleeve T-Shirt - DFW1336","price":"250.0","mrp":"300.0","reorder_point":20,"active":true,"vaccount_id":1,"created_at":"2020-05-04T12:51:57.000+06:00","updated_at":"2020-05-04T12:51:57.000+06:00"}},{"id":99433,"pick_list_id":8187,"warehouse_bin_id":3287,"variant_id":7767,"quantity":3,"picked_quantity":2,"status":"closed","parent_id":null,"vaccount_id":1,"created_at":"2020-06-22T09:42:25.000+06:00","updated_at":"2020-06-22T09:43:53.000+06:00","warehouse_bin":{"id":3287,"warehouse_id":100,"zone_type":10,"bin_type":20,"floor_id":2,"row_id":1,"column_id":1,"rack_id":3,"bin_id":32,"bin_code":"W100F2R1C1RA3B32","capacity":10,"packages_assignable":0,"active":true,"vaccount_id":1,"created_at":"2020-02-10T17:49:16.000+06:00","updated_at":"2020-06-29T20:55:01.000+06:00"},"variant":{"id":7767,"seller_id":29,"category_id":1892,"sku_code":"139744","notes":"Maroon Men's Full Sleeve T-Shirt - DFW1334 - 5LJ1 2813 1A00","price":"250.0","mrp":"300.0","reorder_point":20,"active":true,"vaccount_id":1,"created_at":"2020-05-04T12:51:56.000+06:00","updated_at":"2020-05-04T12:51:56.000+06:00"}},{"id":99430,"pick_list_id":8187,"warehouse_bin_id":3306,"variant_id":7769,"quantity":3,"picked_quantity":1,"status":"closed","parent_id":null,"vaccount_id":1,"created_at":"2020-06-22T09:42:24.000+06:00","updated_at":"2020-06-22T09:43:53.000+06:00","warehouse_bin":{"id":3306,"warehouse_id":100,"zone_type":10,"bin_type":20,"floor_id":2,"row_id":1,"column_id":1,"rack_id":4,"bin_id":13,"bin_code":"W100F2R1C1RA4B13","capacity":10,"packages_assignable":0,"active":true,"vaccount_id":1,"created_at":"2020-02-10T17:49:20.000+06:00","updated_at":"2020-06-30T19:05:46.000+06:00"},"variant":{"id":7769,"seller_id":29,"category_id":1892,"sku_code":"139746","notes":"Navy Blue Men's  Full Sleeve T-Shirt - DFW1336","price":"250.0","mrp":"300.0","reorder_point":20,"active":true,"vaccount_id":1,"created_at":"2020-05-04T12:51:57.000+06:00","updated_at":"2020-05-04T12:51:57.000+06:00"}},{"id":99432,"pick_list_id":8187,"warehouse_bin_id":3306,"variant_id":7771,"quantity":3,"picked_quantity":1,"status":"closed","parent_id":null,"vaccount_id":1,"created_at":"2020-06-22T09:42:24.000+06:00","updated_at":"2020-06-22T09:43:54.000+06:00","warehouse_bin":{"id":3306,"warehouse_id":100,"zone_type":10,"bin_type":20,"floor_id":2,"row_id":1,"column_id":1,"rack_id":4,"bin_id":13,"bin_code":"W100F2R1C1RA4B13","capacity":10,"packages_assignable":0,"active":true,"vaccount_id":1,"created_at":"2020-02-10T17:49:20.000+06:00","updated_at":"2020-06-30T19:05:46.000+06:00"},"variant":{"id":7771,"seller_id":29,"category_id":1892,"sku_code":"139748","notes":"White Men's  Full Sleeve T-Shirt - DFW1337","price":"250.0","mrp":"300.0","reorder_point":20,"active":true,"vaccount_id":1,"created_at":"2020-05-04T12:51:59.000+06:00","updated_at":"2020-05-04T12:51:59.000+06:00"}},{"id":99431,"pick_list_id":8187,"warehouse_bin_id":3311,"variant_id":7771,"quantity":1,"picked_quantity":0,"status":"closed","parent_id":null,"vaccount_id":1,"created_at":"2020-06-22T09:42:24.000+06:00","updated_at":"2020-06-22T09:43:54.000+06:00","warehouse_bin":{"id":3311,"warehouse_id":100,"zone_type":10,"bin_type":20,"floor_id":2,"row_id":1,"column_id":1,"rack_id":4,"bin_id":32,"bin_code":"W100F2R1C1RA4B32","capacity":10,"packages_assignable":0,"active":true,"vaccount_id":1,"created_at":"2020-02-10T17:49:22.000+06:00","updated_at":"2020-06-29T21:11:07.000+06:00"},"variant":{"id":7771,"seller_id":29,"category_id":1892,"sku_code":"139748","notes":"White Men's  Full Sleeve T-Shirt - DFW1337","price":"250.0","mrp":"300.0","reorder_point":20,"active":true,"vaccount_id":1,"created_at":"2020-05-04T12:51:59.000+06:00","updated_at":"2020-05-04T12:51:59.000+06:00"}},{"id":99434,"pick_list_id":8187,"warehouse_bin_id":3322,"variant_id":7767,"quantity":2,"picked_quantity":2,"status":"picked","parent_id":null,"vaccount_id":1,"created_at":"2020-06-22T09:42:25.000+06:00","updated_at":"2020-06-22T09:43:55.000+06:00","warehouse_bin":{"id":3322,"warehouse_id":100,"zone_type":10,"bin_type":20,"floor_id":2,"row_id":1,"column_id":1,"rack_id":4,"bin_id":71,"bin_code":"W100F2R1C1RA4B71","capacity":10,"packages_assignable":6,"active":true,"vaccount_id":1,"created_at":"2020-02-10T17:49:24.000+06:00","updated_at":"2020-06-22T09:43:55.000+06:00"},"variant":{"id":7767,"seller_id":29,"category_id":1892,"sku_code":"139744","notes":"Maroon Men's Full Sleeve T-Shirt - DFW1334 - 5LJ1 2813 1A00","price":"250.0","mrp":"300.0","reorder_point":20,"active":true,"vaccount_id":1,"created_at":"2020-05-04T12:51:56.000+06:00","updated_at":"2020-05-04T12:51:56.000+06:00"}}]},{"id":8186,"warehouse_id":100,"pick_list_type":20,"pickup_agent_id":null,"status":"closed","vaccount_id":1,"created_at":"2020-06-22T09:40:40.000+06:00","updated_at":"2020-06-22T09:41:17.000+06:00","status_code":"CLOSED","reason_code":"UNICORN","total_quantity":9,"pick_list_items":[{"id":99426,"pick_list_id":8186,"warehouse_bin_id":3240,"variant_id":7766,"quantity":4,"picked_quantity":2,"status":"closed","parent_id":null,"vaccount_id":1,"created_at":"2020-06-22T09:40:40.000+06:00","updated_at":"2020-06-22T09:41:16.000+06:00","warehouse_bin":{"id":3240,"warehouse_id":100,"zone_type":10,"bin_type":20,"floor_id":2,"row_id":1,"column_id":1,"rack_id":1,"bin_id":33,"bin_code":"W100F2R1C1RA1B33","capacity":10,"packages_assignable":0,"active":true,"vaccount_id":1,"created_at":"2020-02-10T17:49:04.000+06:00","updated_at":"2020-06-24T15:39:39.000+06:00"},"variant":{"id":7766,"seller_id":29,"category_id":1892,"sku_code":"139743","notes":"Gray Men's  Full Sleeve T-Shirt - DFW1332","price":"250.0","mrp":"300.0","reorder_point":20,"active":true,"vaccount_id":1,"created_at":"2020-05-04T12:51:46.000+06:00","updated_at":"2020-05-04T12:51:46.000+06:00"}},{"id":99427,"pick_list_id":8186,"warehouse_bin_id":3287,"variant_id":7767,"quantity":3,"picked_quantity":0,"status":"closed","parent_id":null,"vaccount_id":1,"created_at":"2020-06-22T09:40:41.000+06:00","updated_at":"2020-06-22T09:41:16.000+06:00","warehouse_bin":{"id":3287,"warehouse_id":100,"zone_type":10,"bin_type":20,"floor_id":2,"row_id":1,"column_id":1,"rack_id":3,"bin_id":32,"bin_code":"W100F2R1C1RA3B32","capacity":10,"packages_assignable":0,"active":true,"vaccount_id":1,"created_at":"2020-02-10T17:49:16.000+06:00","updated_at":"2020-06-29T20:55:01.000+06:00"},"variant":{"id":7767,"seller_id":29,"category_id":1892,"sku_code":"139744","notes":"Maroon Men's Full Sleeve T-Shirt - DFW1334 - 5LJ1 2813 1A00","price":"250.0","mrp":"300.0","reorder_point":20,"active":true,"vaccount_id":1,"created_at":"2020-05-04T12:51:56.000+06:00","updated_at":"2020-05-04T12:51:56.000+06:00"}},{"id":99428,"pick_list_id":8186,"warehouse_bin_id":3322,"variant_id":7767,"quantity":2,"picked_quantity":2,"status":"picked","parent_id":null,"vaccount_id":1,"created_at":"2020-06-22T09:40:41.000+06:00","updated_at":"2020-06-22T09:41:17.000+06:00","warehouse_bin":{"id":3322,"warehouse_id":100,"zone_type":10,"bin_type":20,"floor_id":2,"row_id":1,"column_id":1,"rack_id":4,"bin_id":71,"bin_code":"W100F2R1C1RA4B71","capacity":10,"packages_assignable":6,"active":true,"vaccount_id":1,"created_at":"2020-02-10T17:49:24.000+06:00","updated_at":"2020-06-22T09:43:55.000+06:00"},"variant":{"id":7767,"seller_id":29,"category_id":1892,"sku_code":"139744","notes":"Maroon Men's Full Sleeve T-Shirt - DFW1334 - 5LJ1 2813 1A00","price":"250.0","mrp":"300.0","reorder_point":20,"active":true,"vaccount_id":1,"created_at":"2020-05-04T12:51:56.000+06:00","updated_at":"2020-05-04T12:51:56.000+06:00"}}]},{"id":8185,"warehouse_id":100,"pick_list_type":20,"pickup_agent_id":null,"status":"out_for_pickup","vaccount_id":1,"created_at":"2020-06-21T20:57:01.000+06:00","updated_at":"2020-06-21T20:57:09.000+06:00","status_code":"OUT_FOR_PICKUP","reason_code":"UNICORN","total_quantity":6,"pick_list_items":[{"id":99423,"pick_list_id":8185,"warehouse_bin_id":3240,"variant_id":7766,"quantity":1,"picked_quantity":0,"status":"open_items","parent_id":null,"vaccount_id":1,"created_at":"2020-06-21T20:57:01.000+06:00","updated_at":"2020-06-21T20:57:01.000+06:00","warehouse_bin":{"id":3240,"warehouse_id":100,"zone_type":10,"bin_type":20,"floor_id":2,"row_id":1,"column_id":1,"rack_id":1,"bin_id":33,"bin_code":"W100F2R1C1RA1B33","capacity":10,"packages_assignable":0,"active":true,"vaccount_id":1,"created_at":"2020-02-10T17:49:04.000+06:00","updated_at":"2020-06-24T15:39:39.000+06:00"},"variant":{"id":7766,"seller_id":29,"category_id":1892,"sku_code":"139743","notes":"Gray Men's  Full Sleeve T-Shirt - DFW1332","price":"250.0","mrp":"300.0","reorder_point":20,"active":true,"vaccount_id":1,"created_at":"2020-05-04T12:51:46.000+06:00","updated_at":"2020-05-04T12:51:46.000+06:00"}},{"id":99422,"pick_list_id":8185,"warehouse_bin_id":3267,"variant_id":7766,"quantity":2,"picked_quantity":0,"status":"open_items","parent_id":null,"vaccount_id":1,"created_at":"2020-06-21T20:57:01.000+06:00","updated_at":"2020-06-21T20:57:01.000+06:00","warehouse_bin":{"id":3267,"warehouse_id":100,"zone_type":10,"bin_type":20,"floor_id":2,"row_id":1,"column_id":1,"rack_id":2,"bin_id":43,"bin_code":"W100F2R1C1RA2B43","capacity":10,"packages_assignable":0,"active":true,"vaccount_id":1,"created_at":"2020-02-10T17:49:11.000+06:00","updated_at":"2020-06-24T15:39:23.000+06:00"},"variant":{"id":7766,"seller_id":29,"category_id":1892,"sku_code":"139743","notes":"Gray Men's  Full Sleeve T-Shirt - DFW1332","price":"250.0","mrp":"300.0","reorder_point":20,"active":true,"vaccount_id":1,"created_at":"2020-05-04T12:51:46.000+06:00","updated_at":"2020-05-04T12:51:46.000+06:00"}},{"id":99425,"pick_list_id":8185,"warehouse_bin_id":3287,"variant_id":7767,"quantity":1,"picked_quantity":0,"status":"open_items","parent_id":null,"vaccount_id":1,"created_at":"2020-06-21T20:57:02.000+06:00","updated_at":"2020-06-21T20:57:02.000+06:00","warehouse_bin":{"id":3287,"warehouse_id":100,"zone_type":10,"bin_type":20,"floor_id":2,"row_id":1,"column_id":1,"rack_id":3,"bin_id":32,"bin_code":"W100F2R1C1RA3B32","capacity":10,"packages_assignable":0,"active":true,"vaccount_id":1,"created_at":"2020-02-10T17:49:16.000+06:00","updated_at":"2020-06-29T20:55:01.000+06:00"},"variant":{"id":7767,"seller_id":29,"category_id":1892,"sku_code":"139744","notes":"Maroon Men's Full Sleeve T-Shirt - DFW1334 - 5LJ1 2813 1A00","price":"250.0","mrp":"300.0","reorder_point":20,"active":true,"vaccount_id":1,"created_at":"2020-05-04T12:51:56.000+06:00","updated_at":"2020-05-04T12:51:56.000+06:00"}},{"id":99424,"pick_list_id":8185,"warehouse_bin_id":4186,"variant_id":7767,"quantity":2,"picked_quantity":0,"status":"open_items","parent_id":null,"vaccount_id":1,"created_at":"2020-06-21T20:57:02.000+06:00","updated_at":"2020-06-21T20:57:02.000+06:00","warehouse_bin":{"id":4186,"warehouse_id":100,"zone_type":10,"bin_type":20,"floor_id":2,"row_id":1,"column_id":3,"rack_id":16,"bin_id":71,"bin_code":"W100F2R1C3RA16B71","capacity":10,"packages_assignable":3,"active":true,"vaccount_id":1,"created_at":"2020-02-10T17:52:55.000+06:00","updated_at":"2020-06-21T20:11:54.000+06:00"},"variant":{"id":7767,"seller_id":29,"category_id":1892,"sku_code":"139744","notes":"Maroon Men's Full Sleeve T-Shirt - DFW1334 - 5LJ1 2813 1A00","price":"250.0","mrp":"300.0","reorder_point":20,"active":true,"vaccount_id":1,"created_at":"2020-05-04T12:51:56.000+06:00","updated_at":"2020-05-04T12:51:56.000+06:00"}}]},{"id":8184,"warehouse_id":100,"pick_list_type":20,"pickup_agent_id":null,"status":"closed","vaccount_id":1,"created_at":"2020-06-21T20:11:14.000+06:00","updated_at":"2020-06-21T20:11:55.000+06:00","status_code":"CLOSED","reason_code":"UNICORN","total_quantity":9,"pick_list_items":[{"id":99419,"pick_list_id":8184,"warehouse_bin_id":3267,"variant_id":7766,"quantity":2,"picked_quantity":1,"status":"closed","parent_id":null,"vaccount_id":1,"created_at":"2020-06-21T20:11:14.000+06:00","updated_at":"2020-06-21T20:11:51.000+06:00","warehouse_bin":{"id":3267,"warehouse_id":100,"zone_type":10,"bin_type":20,"floor_id":2,"row_id":1,"column_id":1,"rack_id":2,"bin_id":43,"bin_code":"W100F2R1C1RA2B43","capacity":10,"packages_assignable":0,"active":true,"vaccount_id":1,"created_at":"2020-02-10T17:49:11.000+06:00","updated_at":"2020-06-24T15:39:23.000+06:00"},"variant":{"id":7766,"seller_id":29,"category_id":1892,"sku_code":"139743","notes":"Gray Men's  Full Sleeve T-Shirt - DFW1332","price":"250.0","mrp":"300.0","reorder_point":20,"active":true,"vaccount_id":1,"created_at":"2020-05-04T12:51:46.000+06:00","updated_at":"2020-05-04T12:51:46.000+06:00"}},{"id":99421,"pick_list_id":8184,"warehouse_bin_id":3287,"variant_id":7767,"quantity":2,"picked_quantity":2,"status":"picked","parent_id":null,"vaccount_id":1,"created_at":"2020-06-21T20:11:15.000+06:00","updated_at":"2020-06-21T20:11:52.000+06:00","warehouse_bin":{"id":3287,"warehouse_id":100,"zone_type":10,"bin_type":20,"floor_id":2,"row_id":1,"column_id":1,"rack_id":3,"bin_id":32,"bin_code":"W100F2R1C1RA3B32","capacity":10,"packages_assignable":0,"active":true,"vaccount_id":1,"created_at":"2020-02-10T17:49:16.000+06:00","updated_at":"2020-06-29T20:55:01.000+06:00"},"variant":{"id":7767,"seller_id":29,"category_id":1892,"sku_code":"139744","notes":"Maroon Men's Full Sleeve T-Shirt - DFW1334 - 5LJ1 2813 1A00","price":"250.0","mrp":"300.0","reorder_point":20,"active":true,"vaccount_id":1,"created_at":"2020-05-04T12:51:56.000+06:00","updated_at":"2020-05-04T12:51:56.000+06:00"}},{"id":99418,"pick_list_id":8184,"warehouse_bin_id":3311,"variant_id":7766,"quantity":1,"picked_quantity":1,"status":"picked","parent_id":null,"vaccount_id":1,"created_at":"2020-06-21T20:11:14.000+06:00","updated_at":"2020-06-21T20:11:54.000+06:00","warehouse_bin":{"id":3311,"warehouse_id":100,"zone_type":10,"bin_type":20,"floor_id":2,"row_id":1,"column_id":1,"rack_id":4,"bin_id":32,"bin_code":"W100F2R1C1RA4B32","capacity":10,"packages_assignable":0,"active":true,"vaccount_id":1,"created_at":"2020-02-10T17:49:22.000+06:00","updated_at":"2020-06-29T21:11:07.000+06:00"},"variant":{"id":7766,"seller_id":29,"category_id":1892,"sku_code":"139743","notes":"Gray Men's  Full Sleeve T-Shirt - DFW1332","price":"250.0","mrp":"300.0","reorder_point":20,"active":true,"vaccount_id":1,"created_at":"2020-05-04T12:51:46.000+06:00","updated_at":"2020-05-04T12:51:46.000+06:00"}},{"id":99417,"pick_list_id":8184,"warehouse_bin_id":3313,"variant_id":7766,"quantity":1,"picked_quantity":1,"status":"picked","parent_id":null,"vaccount_id":1,"created_at":"2020-06-21T20:11:14.000+06:00","updated_at":"2020-06-21T20:11:54.000+06:00","warehouse_bin":{"id":3313,"warehouse_id":100,"zone_type":10,"bin_type":20,"floor_id":2,"row_id":1,"column_id":1,"rack_id":4,"bin_id":41,"bin_code":"W100F2R1C1RA4B41","capacity":10,"packages_assignable":0,"active":true,"vaccount_id":1,"created_at":"2020-02-10T17:49:22.000+06:00","updated_at":"2020-06-24T15:39:25.000+06:00"},"variant":{"id":7766,"seller_id":29,"category_id":1892,"sku_code":"139743","notes":"Gray Men's  Full Sleeve T-Shirt - DFW1332","price":"250.0","mrp":"300.0","reorder_point":20,"active":true,"vaccount_id":1,"created_at":"2020-05-04T12:51:46.000+06:00","updated_at":"2020-05-04T12:51:46.000+06:00"}},{"id":99420,"pick_list_id":8184,"warehouse_bin_id":4186,"variant_id":7767,"quantity":3,"picked_quantity":1,"status":"closed","parent_id":null,"vaccount_id":1,"created_at":"2020-06-21T20:11:14.000+06:00","updated_at":"2020-06-21T20:11:54.000+06:00","warehouse_bin":{"id":4186,"warehouse_id":100,"zone_type":10,"bin_type":20,"floor_id":2,"row_id":1,"column_id":3,"rack_id":16,"bin_id":71,"bin_code":"W100F2R1C3RA16B71","capacity":10,"packages_assignable":3,"active":true,"vaccount_id":1,"created_at":"2020-02-10T17:52:55.000+06:00","updated_at":"2020-06-21T20:11:54.000+06:00"},"variant":{"id":7767,"seller_id":29,"category_id":1892,"sku_code":"139744","notes":"Maroon Men's Full Sleeve T-Shirt - DFW1334 - 5LJ1 2813 1A00","price":"250.0","mrp":"300.0","reorder_point":20,"active":true,"vaccount_id":1,"created_at":"2020-05-04T12:51:56.000+06:00","updated_at":"2020-05-04T12:51:56.000+06:00"}}]},{"id":8183,"warehouse_id":100,"pick_list_type":20,"pickup_agent_id":null,"status":"out_for_pickup","vaccount_id":1,"created_at":"2020-06-21T19:56:03.000+06:00","updated_at":"2020-06-21T19:56:11.000+06:00","status_code":"OUT_FOR_PICKUP","reason_code":"UNICORN","total_quantity":5,"pick_list_items":[{"id":99416,"pick_list_id":8183,"warehouse_bin_id":4181,"variant_id":7634,"quantity":5,"picked_quantity":0,"status":"open_items","parent_id":null,"vaccount_id":1,"created_at":"2020-06-21T19:56:04.000+06:00","updated_at":"2020-06-21T19:56:05.000+06:00","warehouse_bin":{"id":4181,"warehouse_id":100,"zone_type":10,"bin_type":20,"floor_id":2,"row_id":1,"column_id":3,"rack_id":16,"bin_id":52,"bin_code":"W100F2R1C3RA16B52","capacity":100,"packages_assignable":68,"active":true,"vaccount_id":1,"created_at":"2020-02-10T17:52:54.000+06:00","updated_at":"2020-06-18T17:51:25.000+06:00"},"variant":{"id":7634,"seller_id":28,"category_id":1892,"sku_code":"316796","notes":"Quechua Arpenaz 10L Backpack - 001 - IPC","price":"195.0","mrp":"280.0","reorder_point":20,"active":true,"vaccount_id":1,"created_at":"2020-04-21T14:52:59.000+06:00","updated_at":"2020-04-21T14:52:59.000+06:00"}}]},{"id":8182,"warehouse_id":100,"pick_list_type":20,"pickup_agent_id":null,"status":"created","vaccount_id":1,"created_at":"2020-06-21T19:55:59.000+06:00","updated_at":"2020-06-21T19:55:59.000+06:00","status_code":"CREATED","reason_code":"UNICORN","total_quantity":5,"pick_list_items":[{"id":99415,"pick_list_id":8182,"warehouse_bin_id":4181,"variant_id":7634,"quantity":5,"picked_quantity":0,"status":"open_items","parent_id":null,"vaccount_id":1,"created_at":"2020-06-21T19:56:00.000+06:00","updated_at":"2020-06-21T19:56:01.000+06:00","warehouse_bin":{"id":4181,"warehouse_id":100,"zone_type":10,"bin_type":20,"floor_id":2,"row_id":1,"column_id":3,"rack_id":16,"bin_id":52,"bin_code":"W100F2R1C3RA16B52","capacity":100,"packages_assignable":68,"active":true,"vaccount_id":1,"created_at":"2020-02-10T17:52:54.000+06:00","updated_at":"2020-06-18T17:51:25.000+06:00"},"variant":{"id":7634,"seller_id":28,"category_id":1892,"sku_code":"316796","notes":"Quechua Arpenaz 10L Backpack - 001 - IPC","price":"195.0","mrp":"280.0","reorder_point":20,"active":true,"vaccount_id":1,"created_at":"2020-04-21T14:52:59.000+06:00","updated_at":"2020-04-21T14:52:59.000+06:00"}}]},{"id":8181,"warehouse_id":100,"pick_list_type":20,"pickup_agent_id":null,"status":"created","vaccount_id":1,"created_at":"2020-06-21T19:55:54.000+06:00","updated_at":"2020-06-21T19:55:54.000+06:00","status_code":"CREATED","reason_code":"UNICORN","total_quantity":5,"pick_list_items":[{"id":99414,"pick_list_id":8181,"warehouse_bin_id":4181,"variant_id":7634,"quantity":5,"picked_quantity":0,"status":"open_items","parent_id":null,"vaccount_id":1,"created_at":"2020-06-21T19:55:56.000+06:00","updated_at":"2020-06-21T19:55:58.000+06:00","warehouse_bin":{"id":4181,"warehouse_id":100,"zone_type":10,"bin_type":20,"floor_id":2,"row_id":1,"column_id":3,"rack_id":16,"bin_id":52,"bin_code":"W100F2R1C3RA16B52","capacity":100,"packages_assignable":68,"active":true,"vaccount_id":1,"created_at":"2020-02-10T17:52:54.000+06:00","updated_at":"2020-06-18T17:51:25.000+06:00"},"variant":{"id":7634,"seller_id":28,"category_id":1892,"sku_code":"316796","notes":"Quechua Arpenaz 10L Backpack - 001 - IPC","price":"195.0","mrp":"280.0","reorder_point":20,"active":true,"vaccount_id":1,"created_at":"2020-04-21T14:52:59.000+06:00","updated_at":"2020-04-21T14:52:59.000+06:00"}}]},{"id":8180,"warehouse_id":100,"pick_list_type":20,"pickup_agent_id":null,"status":"closed","vaccount_id":1,"created_at":"2020-06-21T19:36:38.000+06:00","updated_at":"2020-06-21T19:37:07.000+06:00","status_code":"CLOSED","reason_code":"UNICORN","total_quantity":6,"pick_list_items":[{"id":99412,"pick_list_id":8180,"warehouse_bin_id":3239,"variant_id":7766,"quantity":3,"picked_quantity":0,"status":"closed","parent_id":null,"vaccount_id":1,"created_at":"2020-06-21T19:36:39.000+06:00","updated_at":"2020-06-21T19:36:39.000+06:00","warehouse_bin":{"id":3239,"warehouse_id":100,"zone_type":10,"bin_type":20,"floor_id":2,"row_id":1,"column_id":1,"rack_id":1,"bin_id":32,"bin_code":"W100F2R1C1RA1B32","capacity":10,"packages_assignable":11,"active":true,"vaccount_id":1,"created_at":"2020-02-10T17:49:04.000+06:00","updated_at":"2020-06-20T11:13:06.000+06:00"},"variant":{"id":7766,"seller_id":29,"category_id":1892,"sku_code":"139743","notes":"Gray Men's  Full Sleeve T-Shirt - DFW1332","price":"250.0","mrp":"300.0","reorder_point":20,"active":true,"vaccount_id":1,"created_at":"2020-05-04T12:51:46.000+06:00","updated_at":"2020-05-04T12:51:46.000+06:00"}},{"id":99413,"pick_list_id":8180,"warehouse_bin_id":4186,"variant_id":7767,"quantity":3,"picked_quantity":0,"status":"closed","parent_id":null,"vaccount_id":1,"created_at":"2020-06-21T19:36:39.000+06:00","updated_at":"2020-06-21T19:36:39.000+06:00","warehouse_bin":{"id":4186,"warehouse_id":100,"zone_type":10,"bin_type":20,"floor_id":2,"row_id":1,"column_id":3,"rack_id":16,"bin_id":71,"bin_code":"W100F2R1C3RA16B71","capacity":10,"packages_assignable":3,"active":true,"vaccount_id":1,"created_at":"2020-02-10T17:52:55.000+06:00","updated_at":"2020-06-21T20:11:54.000+06:00"},"variant":{"id":7767,"seller_id":29,"category_id":1892,"sku_code":"139744","notes":"Maroon Men's Full Sleeve T-Shirt - DFW1334 - 5LJ1 2813 1A00","price":"250.0","mrp":"300.0","reorder_point":20,"active":true,"vaccount_id":1,"created_at":"2020-05-04T12:51:56.000+06:00","updated_at":"2020-05-04T12:51:56.000+06:00"}}]},{"id":8179,"warehouse_id":100,"pick_list_type":20,"pickup_agent_id":null,"status":"closed","vaccount_id":1,"created_at":"2020-06-21T17:41:34.000+06:00","updated_at":"2020-06-21T17:44:56.000+06:00","status_code":"CLOSED","reason_code":"UNICORN","total_quantity":10,"pick_list_items":[{"id":99411,"pick_list_id":8179,"warehouse_bin_id":3237,"variant_id":7768,"quantity":1,"picked_quantity":1,"status":"picked","parent_id":null,"vaccount_id":1,"created_at":"2020-06-21T17:41:36.000+06:00","updated_at":"2020-06-21T17:44:55.000+06:00","warehouse_bin":{"id":3237,"warehouse_id":100,"zone_type":10,"bin_type":20,"floor_id":2,"row_id":1,"column_id":1,"rack_id":1,"bin_id":23,"bin_code":"W100F2R1C1RA1B23","capacity":10,"packages_assignable":0,"active":true,"vaccount_id":1,"created_at":"2020-02-10T17:49:04.000+06:00","updated_at":"2020-06-24T15:39:28.000+06:00"},"variant":{"id":7768,"seller_id":29,"category_id":1892,"sku_code":"139745","notes":"Red Men's  Full Sleeve T-Shirt - DFW1333","price":"250.0","mrp":"300.0","reorder_point":20,"active":true,"vaccount_id":1,"created_at":"2020-05-04T12:51:57.000+06:00","updated_at":"2020-05-04T12:51:57.000+06:00"}},{"id":99407,"pick_list_id":8179,"warehouse_bin_id":3239,"variant_id":7766,"quantity":4,"picked_quantity":0,"status":"closed","parent_id":null,"vaccount_id":1,"created_at":"2020-06-21T17:41:34.000+06:00","updated_at":"2020-06-21T17:44:53.000+06:00","warehouse_bin":{"id":3239,"warehouse_id":100,"zone_type":10,"bin_type":20,"floor_id":2,"row_id":1,"column_id":1,"rack_id":1,"bin_id":32,"bin_code":"W100F2R1C1RA1B32","capacity":10,"packages_assignable":11,"active":true,"vaccount_id":1,"created_at":"2020-02-10T17:49:04.000+06:00","updated_at":"2020-06-20T11:13:06.000+06:00"},"variant":{"id":7766,"seller_id":29,"category_id":1892,"sku_code":"139743","notes":"Gray Men's  Full Sleeve T-Shirt - DFW1332","price":"250.0","mrp":"300.0","reorder_point":20,"active":true,"vaccount_id":1,"created_at":"2020-05-04T12:51:46.000+06:00","updated_at":"2020-05-04T12:51:46.000+06:00"}},{"id":99409,"pick_list_id":8179,"warehouse_bin_id":3302,"variant_id":7767,"quantity":2,"picked_quantity":2,"status":"picked","parent_id":null,"vaccount_id":1,"created_at":"2020-06-21T17:41:35.000+06:00","updated_at":"2020-06-21T17:44:54.000+06:00","warehouse_bin":{"id":3302,"warehouse_id":100,"zone_type":10,"bin_type":20,"floor_id":2,"row_id":1,"column_id":1,"rack_id":3,"bin_id":82,"bin_code":"W100F2R1C1RA3B82","capacity":10,"packages_assignable":5,"active":true,"vaccount_id":1,"created_at":"2020-02-10T17:49:20.000+06:00","updated_at":"2020-06-22T09:48:47.000+06:00"},"variant":{"id":7767,"seller_id":29,"category_id":1892,"sku_code":"139744","notes":"Maroon Men's Full Sleeve T-Shirt - DFW1334 - 5LJ1 2813 1A00","price":"250.0","mrp":"300.0","reorder_point":20,"active":true,"vaccount_id":1,"created_at":"2020-05-04T12:51:56.000+06:00","updated_at":"2020-05-04T12:51:56.000+06:00"}},{"id":99408,"pick_list_id":8179,"warehouse_bin_id":3321,"variant_id":7767,"quantity":1,"picked_quantity":1,"status":"picked","parent_id":null,"vaccount_id":1,"created_at":"2020-06-21T17:41:35.000+06:00","updated_at":"2020-06-21T17:44:55.000+06:00","warehouse_bin":{"id":3321,"warehouse_id":100,"zone_type":10,"bin_type":20,"floor_id":2,"row_id":1,"column_id":1,"rack_id":4,"bin_id":63,"bin_code":"W100F2R1C1RA4B63","capacity":10,"packages_assignable":2,"active":true,"vaccount_id":1,"created_at":"2020-02-10T17:49:24.000+06:00","updated_at":"2020-06-30T19:05:46.000+06:00"},"variant":{"id":7767,"seller_id":29,"category_id":1892,"sku_code":"139744","notes":"Maroon Men's Full Sleeve T-Shirt - DFW1334 - 5LJ1 2813 1A00","price":"250.0","mrp":"300.0","reorder_point":20,"active":true,"vaccount_id":1,"created_at":"2020-05-04T12:51:56.000+06:00","updated_at":"2020-05-04T12:51:56.000+06:00"}},{"id":99410,"pick_list_id":8179,"warehouse_bin_id":4186,"variant_id":7767,"quantity":2,"picked_quantity":1,"status":"closed","parent_id":null,"vaccount_id":1,"created_at":"2020-06-21T17:41:35.000+06:00","updated_at":"2020-06-21T17:44:55.000+06:00","warehouse_bin":{"id":4186,"warehouse_id":100,"zone_type":10,"bin_type":20,"floor_id":2,"row_id":1,"column_id":3,"rack_id":16,"bin_id":71,"bin_code":"W100F2R1C3RA16B71","capacity":10,"packages_assignable":3,"active":true,"vaccount_id":1,"created_at":"2020-02-10T17:52:55.000+06:00","updated_at":"2020-06-21T20:11:54.000+06:00"},"variant":{"id":7767,"seller_id":29,"category_id":1892,"sku_code":"139744","notes":"Maroon Men's Full Sleeve T-Shirt - DFW1334 - 5LJ1 2813 1A00","price":"250.0","mrp":"300.0","reorder_point":20,"active":true,"vaccount_id":1,"created_at":"2020-05-04T12:51:56.000+06:00","updated_at":"2020-05-04T12:51:56.000+06:00"}}]},{"id":8178,"warehouse_id":100,"pick_list_type":20,"pickup_agent_id":null,"status":"closed","vaccount_id":1,"created_at":"2020-06-21T16:34:04.000+06:00","updated_at":"2020-06-21T16:35:51.000+06:00","status_code":"CLOSED","reason_code":"UNICORN","total_quantity":11,"pick_list_items":[{"id":99406,"pick_list_id":8178,"warehouse_bin_id":3237,"variant_id":7768,"quantity":2,"picked_quantity":1,"status":"closed","parent_id":null,"vaccount_id":1,"created_at":"2020-06-21T16:34:06.000+06:00","updated_at":"2020-06-21T16:35:48.000+06:00","warehouse_bin":{"id":3237,"warehouse_id":100,"zone_type":10,"bin_type":20,"floor_id":2,"row_id":1,"column_id":1,"rack_id":1,"bin_id":23,"bin_code":"W100F2R1C1RA1B23","capacity":10,"packages_assignable":0,"active":true,"vaccount_id":1,"created_at":"2020-02-10T17:49:04.000+06:00","updated_at":"2020-06-24T15:39:28.000+06:00"},"variant":{"id":7768,"seller_id":29,"category_id":1892,"sku_code":"139745","notes":"Red Men's  Full Sleeve T-Shirt - DFW1333","price":"250.0","mrp":"300.0","reorder_point":20,"active":true,"vaccount_id":1,"created_at":"2020-05-04T12:51:57.000+06:00","updated_at":"2020-05-04T12:51:57.000+06:00"}},{"id":99405,"pick_list_id":8178,"warehouse_bin_id":3238,"variant_id":7768,"quantity":1,"picked_quantity":1,"status":"picked","parent_id":null,"vaccount_id":1,"created_at":"2020-06-21T16:34:06.000+06:00","updated_at":"2020-06-21T16:35:51.000+06:00","warehouse_bin":{"id":3238,"warehouse_id":100,"zone_type":10,"bin_type":20,"floor_id":2,"row_id":1,"column_id":1,"rack_id":1,"bin_id":31,"bin_code":"W100F2R1C1RA1B31","capacity":10,"packages_assignable":0,"active":true,"vaccount_id":1,"created_at":"2020-02-10T17:49:04.000+06:00","updated_at":"2020-06-24T15:39:30.000+06:00"},"variant":{"id":7768,"seller_id":29,"category_id":1892,"sku_code":"139745","notes":"Red Men's  Full Sleeve T-Shirt - DFW1333","price":"250.0","mrp":"300.0","reorder_point":20,"active":true,"vaccount_id":1,"created_at":"2020-05-04T12:51:57.000+06:00","updated_at":"2020-05-04T12:51:57.000+06:00"}},{"id":99402,"pick_list_id":8178,"warehouse_bin_id":3239,"variant_id":7766,"quantity":4,"picked_quantity":0,"status":"closed","parent_id":null,"vaccount_id":1,"created_at":"2020-06-21T16:34:04.000+06:00","updated_at":"2020-06-21T16:35:49.000+06:00","warehouse_bin":{"id":3239,"warehouse_id":100,"zone_type":10,"bin_type":20,"floor_id":2,"row_id":1,"column_id":1,"rack_id":1,"bin_id":32,"bin_code":"W100F2R1C1RA1B32","capacity":10,"packages_assignable":11,"active":true,"vaccount_id":1,"created_at":"2020-02-10T17:49:04.000+06:00","updated_at":"2020-06-20T11:13:06.000+06:00"},"variant":{"id":7766,"seller_id":29,"category_id":1892,"sku_code":"139743","notes":"Gray Men's  Full Sleeve T-Shirt - DFW1332","price":"250.0","mrp":"300.0","reorder_point":20,"active":true,"vaccount_id":1,"created_at":"2020-05-04T12:51:46.000+06:00","updated_at":"2020-05-04T12:51:46.000+06:00"}},{"id":99404,"pick_list_id":8178,"warehouse_bin_id":3302,"variant_id":7767,"quantity":2,"picked_quantity":2,"status":"picked","parent_id":null,"vaccount_id":1,"created_at":"2020-06-21T16:34:05.000+06:00","updated_at":"2020-06-21T16:35:50.000+06:00","warehouse_bin":{"id":3302,"warehouse_id":100,"zone_type":10,"bin_type":20,"floor_id":2,"row_id":1,"column_id":1,"rack_id":3,"bin_id":82,"bin_code":"W100F2R1C1RA3B82","capacity":10,"packages_assignable":5,"active":true,"vaccount_id":1,"created_at":"2020-02-10T17:49:20.000+06:00","updated_at":"2020-06-22T09:48:47.000+06:00"},"variant":{"id":7767,"seller_id":29,"category_id":1892,"sku_code":"139744","notes":"Maroon Men's Full Sleeve T-Shirt - DFW1334 - 5LJ1 2813 1A00","price":"250.0","mrp":"300.0","reorder_point":20,"active":true,"vaccount_id":1,"created_at":"2020-05-04T12:51:56.000+06:00","updated_at":"2020-05-04T12:51:56.000+06:00"}},{"id":99403,"pick_list_id":8178,"warehouse_bin_id":3321,"variant_id":7767,"quantity":2,"picked_quantity":1,"status":"closed","parent_id":null,"vaccount_id":1,"created_at":"2020-06-21T16:34:05.000+06:00","updated_at":"2020-06-21T16:35:51.000+06:00","warehouse_bin":{"id":3321,"warehouse_id":100,"zone_type":10,"bin_type":20,"floor_id":2,"row_id":1,"column_id":1,"rack_id":4,"bin_id":63,"bin_code":"W100F2R1C1RA4B63","capacity":10,"packages_assignable":2,"active":true,"vaccount_id":1,"created_at":"2020-02-10T17:49:24.000+06:00","updated_at":"2020-06-30T19:05:46.000+06:00"},"variant":{"id":7767,"seller_id":29,"category_id":1892,"sku_code":"139744","notes":"Maroon Men's Full Sleeve T-Shirt - DFW1334 - 5LJ1 2813 1A00","price":"250.0","mrp":"300.0","reorder_point":20,"active":true,"vaccount_id":1,"created_at":"2020-05-04T12:51:56.000+06:00","updated_at":"2020-05-04T12:51:56.000+06:00"}}]}]
     * total : 1170
     */

    private int total;
    private List<PickListsDataBean> pick_lists_data;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<PickListsDataBean> getPick_lists_data() {
        return pick_lists_data;
    }

    public void setPick_lists_data(List<PickListsDataBean> pick_lists_data) {
        this.pick_lists_data = pick_lists_data;
    }

    public static class PickListsDataBean implements Serializable {
        /**
         * id : 8207
         * warehouse_id : 100
         * pick_list_type : 16
         * pickup_agent_id : null
         * status : created
         * vaccount_id : 1
         * created_at : 2020-06-29T12:46:24.000+06:00
         * updated_at : 2020-06-29T12:46:24.000+06:00
         * status_code : CREATED
         * reason_code : PHOTOSHOOT
         * total_quantity : 2
         * pick_list_items : [{"id":99466,"pick_list_id":8207,"warehouse_bin_id":3238,"variant_id":7766,"quantity":2,"picked_quantity":0,"status":"open_items","parent_id":null,"vaccount_id":1,"created_at":"2020-06-29T12:46:25.000+06:00","updated_at":"2020-06-29T12:46:25.000+06:00","warehouse_bin":{"id":3238,"warehouse_id":100,"zone_type":10,"bin_type":20,"floor_id":2,"row_id":1,"column_id":1,"rack_id":1,"bin_id":31,"bin_code":"W100F2R1C1RA1B31","capacity":10,"packages_assignable":0,"active":true,"vaccount_id":1,"created_at":"2020-02-10T17:49:04.000+06:00","updated_at":"2020-06-24T15:39:30.000+06:00"},"variant":{"id":7766,"seller_id":29,"category_id":1892,"sku_code":"139743","notes":"Gray Men's  Full Sleeve T-Shirt - DFW1332","price":"250.0","mrp":"300.0","reorder_point":20,"active":true,"vaccount_id":1,"created_at":"2020-05-04T12:51:46.000+06:00","updated_at":"2020-05-04T12:51:46.000+06:00"}}]
         */

        private int id;
        private int warehouse_id;
        private int pick_list_type;
        private Object pickup_agent_id;
        private String status;
        private int vaccount_id;
        private String created_at;
        private String updated_at;
        private String status_code;
        private String reason_code;
        private int total_quantity;
        private List<PickListItemsBean> pick_list_items;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getWarehouse_id() {
            return warehouse_id;
        }

        public void setWarehouse_id(int warehouse_id) {
            this.warehouse_id = warehouse_id;
        }

        public int getPick_list_type() {
            return pick_list_type;
        }

        public void setPick_list_type(int pick_list_type) {
            this.pick_list_type = pick_list_type;
        }

        public Object getPickup_agent_id() {
            return pickup_agent_id;
        }

        public void setPickup_agent_id(Object pickup_agent_id) {
            this.pickup_agent_id = pickup_agent_id;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public int getVaccount_id() {
            return vaccount_id;
        }

        public void setVaccount_id(int vaccount_id) {
            this.vaccount_id = vaccount_id;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }

        public String getStatus_code() {
            return status_code;
        }

        public void setStatus_code(String status_code) {
            this.status_code = status_code;
        }

        public String getReason_code() {
            return reason_code;
        }

        public void setReason_code(String reason_code) {
            this.reason_code = reason_code;
        }

        public int getTotal_quantity() {
            return total_quantity;
        }

        public void setTotal_quantity(int total_quantity) {
            this.total_quantity = total_quantity;
        }

        public List<PickListItemsBean> getPick_list_items() {
            return pick_list_items;
        }

        public void setPick_list_items(List<PickListItemsBean> pick_list_items) {
            this.pick_list_items = pick_list_items;
        }

        public static class PickListItemsBean implements Serializable {
            /**
             * id : 99466
             * pick_list_id : 8207
             * warehouse_bin_id : 3238
             * variant_id : 7766
             * quantity : 2
             * picked_quantity : 0
             * status : open_items
             * parent_id : null
             * vaccount_id : 1
             * created_at : 2020-06-29T12:46:25.000+06:00
             * updated_at : 2020-06-29T12:46:25.000+06:00
             * warehouse_bin : {"id":3238,"warehouse_id":100,"zone_type":10,"bin_type":20,"floor_id":2,"row_id":1,"column_id":1,"rack_id":1,"bin_id":31,"bin_code":"W100F2R1C1RA1B31","capacity":10,"packages_assignable":0,"active":true,"vaccount_id":1,"created_at":"2020-02-10T17:49:04.000+06:00","updated_at":"2020-06-24T15:39:30.000+06:00"}
             * variant : {"id":7766,"seller_id":29,"category_id":1892,"sku_code":"139743","notes":"Gray Men's  Full Sleeve T-Shirt - DFW1332","price":"250.0","mrp":"300.0","reorder_point":20,"active":true,"vaccount_id":1,"created_at":"2020-05-04T12:51:46.000+06:00","updated_at":"2020-05-04T12:51:46.000+06:00"}
             */

            private int id;
            private int pick_list_id;
            private int warehouse_bin_id;
            private int variant_id;
            private int quantity;
            private int picked_quantity;
            private String status;
            private Object parent_id;
            private int vaccount_id;
            private String created_at;
            private String updated_at;
            private WarehouseBinBean warehouse_bin;
            private VariantBean variant;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getPick_list_id() {
                return pick_list_id;
            }

            public void setPick_list_id(int pick_list_id) {
                this.pick_list_id = pick_list_id;
            }

            public int getWarehouse_bin_id() {
                return warehouse_bin_id;
            }

            public void setWarehouse_bin_id(int warehouse_bin_id) {
                this.warehouse_bin_id = warehouse_bin_id;
            }

            public int getVariant_id() {
                return variant_id;
            }

            public void setVariant_id(int variant_id) {
                this.variant_id = variant_id;
            }

            public int getQuantity() {
                return quantity;
            }

            public void setQuantity(int quantity) {
                this.quantity = quantity;
            }

            public int getPicked_quantity() {
                return picked_quantity;
            }

            public void setPicked_quantity(int picked_quantity) {
                this.picked_quantity = picked_quantity;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public Object getParent_id() {
                return parent_id;
            }

            public void setParent_id(Object parent_id) {
                this.parent_id = parent_id;
            }

            public int getVaccount_id() {
                return vaccount_id;
            }

            public void setVaccount_id(int vaccount_id) {
                this.vaccount_id = vaccount_id;
            }

            public String getCreated_at() {
                return created_at;
            }

            public void setCreated_at(String created_at) {
                this.created_at = created_at;
            }

            public String getUpdated_at() {
                return updated_at;
            }

            public void setUpdated_at(String updated_at) {
                this.updated_at = updated_at;
            }

            public WarehouseBinBean getWarehouse_bin() {
                return warehouse_bin;
            }

            public void setWarehouse_bin(WarehouseBinBean warehouse_bin) {
                this.warehouse_bin = warehouse_bin;
            }

            public VariantBean getVariant() {
                return variant;
            }

            public void setVariant(VariantBean variant) {
                this.variant = variant;
            }

            public static class WarehouseBinBean implements Serializable {
                /**
                 * id : 3238
                 * warehouse_id : 100
                 * zone_type : 10
                 * bin_type : 20
                 * floor_id : 2
                 * row_id : 1
                 * column_id : 1
                 * rack_id : 1
                 * bin_id : 31
                 * bin_code : W100F2R1C1RA1B31
                 * capacity : 10
                 * packages_assignable : 0
                 * active : true
                 * vaccount_id : 1
                 * created_at : 2020-02-10T17:49:04.000+06:00
                 * updated_at : 2020-06-24T15:39:30.000+06:00
                 */

                private int id;
                private int warehouse_id;
                private int zone_type;
                private int bin_type;
                private int floor_id;
                private int row_id;
                private int column_id;
                private int rack_id;
                private int bin_id;
                private String bin_code;
                private int capacity;
                private int packages_assignable;
                private boolean active;
                private int vaccount_id;
                private String created_at;
                private String updated_at;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getWarehouse_id() {
                    return warehouse_id;
                }

                public void setWarehouse_id(int warehouse_id) {
                    this.warehouse_id = warehouse_id;
                }

                public int getZone_type() {
                    return zone_type;
                }

                public void setZone_type(int zone_type) {
                    this.zone_type = zone_type;
                }

                public int getBin_type() {
                    return bin_type;
                }

                public void setBin_type(int bin_type) {
                    this.bin_type = bin_type;
                }

                public int getFloor_id() {
                    return floor_id;
                }

                public void setFloor_id(int floor_id) {
                    this.floor_id = floor_id;
                }

                public int getRow_id() {
                    return row_id;
                }

                public void setRow_id(int row_id) {
                    this.row_id = row_id;
                }

                public int getColumn_id() {
                    return column_id;
                }

                public void setColumn_id(int column_id) {
                    this.column_id = column_id;
                }

                public int getRack_id() {
                    return rack_id;
                }

                public void setRack_id(int rack_id) {
                    this.rack_id = rack_id;
                }

                public int getBin_id() {
                    return bin_id;
                }

                public void setBin_id(int bin_id) {
                    this.bin_id = bin_id;
                }

                public String getBin_code() {
                    return bin_code;
                }

                public void setBin_code(String bin_code) {
                    this.bin_code = bin_code;
                }

                public int getCapacity() {
                    return capacity;
                }

                public void setCapacity(int capacity) {
                    this.capacity = capacity;
                }

                public int getPackages_assignable() {
                    return packages_assignable;
                }

                public void setPackages_assignable(int packages_assignable) {
                    this.packages_assignable = packages_assignable;
                }

                public boolean isActive() {
                    return active;
                }

                public void setActive(boolean active) {
                    this.active = active;
                }

                public int getVaccount_id() {
                    return vaccount_id;
                }

                public void setVaccount_id(int vaccount_id) {
                    this.vaccount_id = vaccount_id;
                }

                public String getCreated_at() {
                    return created_at;
                }

                public void setCreated_at(String created_at) {
                    this.created_at = created_at;
                }

                public String getUpdated_at() {
                    return updated_at;
                }

                public void setUpdated_at(String updated_at) {
                    this.updated_at = updated_at;
                }
            }

            public static class VariantBean implements Serializable {
                /**
                 * id : 7766
                 * seller_id : 29
                 * category_id : 1892
                 * sku_code : 139743
                 * notes : Gray Men's  Full Sleeve T-Shirt - DFW1332
                 * price : 250.0
                 * mrp : 300.0
                 * reorder_point : 20
                 * active : true
                 * vaccount_id : 1
                 * created_at : 2020-05-04T12:51:46.000+06:00
                 * updated_at : 2020-05-04T12:51:46.000+06:00
                 */

                private int id;
                private int seller_id;
                private int category_id;
                private String sku_code;
                private String notes;
                private String price;
                private String mrp;
                private int reorder_point;
                private boolean active;
                private int vaccount_id;
                private String created_at;
                private String updated_at;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getSeller_id() {
                    return seller_id;
                }

                public void setSeller_id(int seller_id) {
                    this.seller_id = seller_id;
                }

                public int getCategory_id() {
                    return category_id;
                }

                public void setCategory_id(int category_id) {
                    this.category_id = category_id;
                }

                public String getSku_code() {
                    return sku_code;
                }

                public void setSku_code(String sku_code) {
                    this.sku_code = sku_code;
                }

                public String getNotes() {
                    return notes;
                }

                public void setNotes(String notes) {
                    this.notes = notes;
                }

                public String getPrice() {
                    return price;
                }

                public void setPrice(String price) {
                    this.price = price;
                }

                public String getMrp() {
                    return mrp;
                }

                public void setMrp(String mrp) {
                    this.mrp = mrp;
                }

                public int getReorder_point() {
                    return reorder_point;
                }

                public void setReorder_point(int reorder_point) {
                    this.reorder_point = reorder_point;
                }

                public boolean isActive() {
                    return active;
                }

                public void setActive(boolean active) {
                    this.active = active;
                }

                public int getVaccount_id() {
                    return vaccount_id;
                }

                public void setVaccount_id(int vaccount_id) {
                    this.vaccount_id = vaccount_id;
                }

                public String getCreated_at() {
                    return created_at;
                }

                public void setCreated_at(String created_at) {
                    this.created_at = created_at;
                }

                public String getUpdated_at() {
                    return updated_at;
                }

                public void setUpdated_at(String updated_at) {
                    this.updated_at = updated_at;
                }
            }
        }
    }
}
