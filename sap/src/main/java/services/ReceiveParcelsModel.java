package services;

import java.io.Serializable;
import java.util.List;

public class ReceiveParcelsModel {


    /**
     * error : false
     * count : 19
     * totalAmount : 1200
     * parcels : [{"id":"21A2A3WE3K462","shopId":648106,"shopName":"Bulk Issue Test Shop","shopPhone":"8801401122188","adminNumber":null,"srNumber":null,"pickupAddress":"CWH","pickupDate":"2021-02-03T05:30:00.000Z","deliveryDate":"2021-02-04T10:30:00.000Z","deliveryType":"regular","parcelPackageType":null,"invoiceNumber":"123471","shopupInvoiceNumber":null,"shopupInvoiceId":null,"customerName":"Jane Doe","customerPhone":"8801873445555","deliveryAddress":"50 Lake Circus (7th floor) Kalabagan","area":"Tejgaon","areaId":98,"sourceHubId":null,"destinationHubId":null,"countryCode":"BD","country":null,"postCode":"1208","city":null,"state":"","paymentMethod":"cash on delivery","weight":500,"cash":0,"previousPrice":null,"value":"0","liftingPrice":0,"isCashDeposited":0,"shopupCharge":60,"shopupCodCharge":0,"subsidyAmount":0,"partnerCodCharge":0,"partnerReturnCharge":0,"shopupReturnCharge":0,"paidAmount":0,"gatewayPaidAmount":null,"gatewayMedium":null,"isChargePaid":0,"isPartial":0,"parentParcelId":null,"parcelDeliveryType":"regular","isProblematic":0,"isReverseDelivery":0,"numberOfAttempts":0,"status":"pickup-pending","sellerStatus":"pickup-pending","partnerStatus":null,"partnerId":3,"partnerTrakingId":null,"partnerCharge":0,"partnerName":"ShopUp","buyerInstruction":null,"sellerInstruction":"Give cash amount zero if payment already done","shopupNote":null,"sellerNote":null,"isDeleted":0,"isChecked":0,"isHidden":0,"bulkId":"kkov9t9j","bulkTransferId":null,"agentId":null,"deliveryAgentId":null,"logisticsInvoiceId":null,"resellerSettlementId":null,"createdAt":"2021-02-03T03:24:06.000Z","updatedAt":"2021-02-03T03:24:06.000Z","isSettled":0,"isReturned":0,"deliveryReadyTime":null,"firstMileReceivedTime":null,"packageType":null,"parcelDetailsJson":null,"returnReason":null,"returnComment":null,"holdReason":null,"holdComment":null,"comment":null,"compensateAmount":0,"cashUpdateInfo":null,"isExchanged":0,"exchangeFor":null,"partialReturnedParcelId":null,"exchangeReturnedParcelId":null,"exchangeDeliveredParcelId":null,"partialDeliveredParcelId":null,"isShawnirbhor":0,"isReseller":0,"isHyperLocal":0,"deliveryOtp":null,"isDeliveryOtpVerified":0,"merchantDeliveryCharge":0,"isIssueRaised":0,"currentIssueId":null,"returnOtp":null,"isReturnOtpVerified":0,"lineHaulId":null,"isReconcile":0,"isReconcilable":0,"pickupAreaId":448,"processIdentifier":null,"trackingId":"21A2A3WE3K462","parcelType":"regular","parentParcelTrackingId":null,"pickupStoreId":64107,"sellerPhone":"8801401122188","isResellerShop":0,"shopCreatedAt":"2021-01-28T05:41:07.000Z","resellerId":null,"hubId":2,"hubName":"Mohakhali Hub","shopPickupArea":null,"shopPickupAddress":"CWH","deliveryAgentName":null,"parcel_id":5977370},{"id":"21A2A3WE3K463","shopId":648106,"shopName":"Bulk Issue Test Shop","shopPhone":"8801401122188","adminNumber":null,"srNumber":null,"pickupAddress":"CWH","pickupDate":"2021-02-03T05:30:00.000Z","deliveryDate":"2021-02-04T10:30:00.000Z","deliveryType":"regular","parcelPackageType":null,"invoiceNumber":"123472","shopupInvoiceNumber":null,"shopupInvoiceId":null,"customerName":"John Doe","customerPhone":"8801873445555","deliveryAddress":"House name (Apt number), Road number ","area":"Tejgaon","areaId":98,"sourceHubId":null,"destinationHubId":null,"countryCode":"BD","country":null,"postCode":"1208","city":null,"state":"","paymentMethod":"cash on delivery","weight":500,"cash":120,"previousPrice":null,"value":"0","liftingPrice":0,"isCashDeposited":0,"shopupCharge":60,"shopupCodCharge":0,"subsidyAmount":1.2,"partnerCodCharge":0,"partnerReturnCharge":0,"shopupReturnCharge":0,"paidAmount":0,"gatewayPaidAmount":null,"gatewayMedium":null,"isChargePaid":0,"isPartial":0,"parentParcelId":null,"parcelDeliveryType":"regular","isProblematic":0,"isReverseDelivery":0,"numberOfAttempts":0,"status":"pickup-pending","sellerStatus":"pickup-pending","partnerStatus":null,"partnerId":3,"partnerTrakingId":null,"partnerCharge":0,"partnerName":"ShopUp","buyerInstruction":null,"sellerInstruction":"Comment regarding delivery","shopupNote":null,"sellerNote":null,"isDeleted":0,"isChecked":0,"isHidden":0,"bulkId":"kkov9t9j","bulkTransferId":null,"agentId":null,"deliveryAgentId":null,"logisticsInvoiceId":null,"resellerSettlementId":null,"createdAt":"2021-02-03T03:24:06.000Z","updatedAt":"2021-02-03T03:24:06.000Z","isSettled":0,"isReturned":0,"deliveryReadyTime":null,"firstMileReceivedTime":null,"packageType":null,"parcelDetailsJson":null,"returnReason":null,"returnComment":null,"holdReason":null,"holdComment":null,"comment":null,"compensateAmount":0,"cashUpdateInfo":null,"isExchanged":0,"exchangeFor":null,"partialReturnedParcelId":null,"exchangeReturnedParcelId":null,"exchangeDeliveredParcelId":null,"partialDeliveredParcelId":null,"isShawnirbhor":0,"isReseller":0,"isHyperLocal":0,"deliveryOtp":null,"isDeliveryOtpVerified":0,"merchantDeliveryCharge":0,"isIssueRaised":0,"currentIssueId":null,"returnOtp":null,"isReturnOtpVerified":0,"lineHaulId":null,"isReconcile":0,"isReconcilable":0,"pickupAreaId":448,"processIdentifier":null,"trackingId":"21A2A3WE3K463","parcelType":"regular","parentParcelTrackingId":null,"pickupStoreId":64107,"sellerPhone":"8801401122188","isResellerShop":0,"shopCreatedAt":"2021-01-28T05:41:07.000Z","resellerId":null,"hubId":2,"hubName":"Mohakhali Hub","shopPickupArea":null,"shopPickupAddress":"CWH","deliveryAgentName":null,"parcel_id":5977371},{"id":"21A2A3WE3K464","shopId":648106,"shopName":"Bulk Issue Test Shop","shopPhone":"8801401122188","adminNumber":null,"srNumber":null,"pickupAddress":"CWH","pickupDate":"2021-02-03T05:30:00.000Z","deliveryDate":"2021-02-04T10:30:00.000Z","deliveryType":"regular","parcelPackageType":null,"invoiceNumber":"123473","shopupInvoiceNumber":null,"shopupInvoiceId":null,"customerName":"Jane Doe","customerPhone":"8801873445555","deliveryAddress":"50 Lake Circus (7th floor) Kalabagan","area":"Tejgaon","areaId":98,"sourceHubId":null,"destinationHubId":null,"countryCode":"BD","country":null,"postCode":"1208","city":null,"state":"","paymentMethod":"cash on delivery","weight":500,"cash":0,"previousPrice":null,"value":"0","liftingPrice":0,"isCashDeposited":0,"shopupCharge":60,"shopupCodCharge":0,"subsidyAmount":0,"partnerCodCharge":0,"partnerReturnCharge":0,"shopupReturnCharge":0,"paidAmount":0,"gatewayPaidAmount":null,"gatewayMedium":null,"isChargePaid":0,"isPartial":0,"parentParcelId":null,"parcelDeliveryType":"regular","isProblematic":0,"isReverseDelivery":0,"numberOfAttempts":0,"status":"pickup-pending","sellerStatus":"pickup-pending","partnerStatus":null,"partnerId":3,"partnerTrakingId":null,"partnerCharge":0,"partnerName":"ShopUp","buyerInstruction":null,"sellerInstruction":"Give cash amount zero if payment already done","shopupNote":null,"sellerNote":null,"isDeleted":0,"isChecked":0,"isHidden":0,"bulkId":"kkov9t9j","bulkTransferId":null,"agentId":null,"deliveryAgentId":null,"logisticsInvoiceId":null,"resellerSettlementId":null,"createdAt":"2021-02-03T03:24:06.000Z","updatedAt":"2021-02-03T03:24:06.000Z","isSettled":0,"isReturned":0,"deliveryReadyTime":null,"firstMileReceivedTime":null,"packageType":null,"parcelDetailsJson":null,"returnReason":null,"returnComment":null,"holdReason":null,"holdComment":null,"comment":null,"compensateAmount":0,"cashUpdateInfo":null,"isExchanged":0,"exchangeFor":null,"partialReturnedParcelId":null,"exchangeReturnedParcelId":null,"exchangeDeliveredParcelId":null,"partialDeliveredParcelId":null,"isShawnirbhor":0,"isReseller":0,"isHyperLocal":0,"deliveryOtp":null,"isDeliveryOtpVerified":0,"merchantDeliveryCharge":0,"isIssueRaised":0,"currentIssueId":null,"returnOtp":null,"isReturnOtpVerified":0,"lineHaulId":null,"isReconcile":0,"isReconcilable":0,"pickupAreaId":448,"processIdentifier":null,"trackingId":"21A2A3WE3K464","parcelType":"regular","parentParcelTrackingId":null,"pickupStoreId":64107,"sellerPhone":"8801401122188","isResellerShop":0,"shopCreatedAt":"2021-01-28T05:41:07.000Z","resellerId":null,"hubId":2,"hubName":"Mohakhali Hub","shopPickupArea":null,"shopPickupAddress":"CWH","deliveryAgentName":null,"parcel_id":5977372},{"id":"21A2A3WE3K45W","shopId":648106,"shopName":"Bulk Issue Test Shop","shopPhone":"8801401122188","adminNumber":null,"srNumber":null,"pickupAddress":"CWH","pickupDate":"2021-02-03T05:30:00.000Z","deliveryDate":"2021-02-04T10:30:00.000Z","deliveryType":"regular","parcelPackageType":null,"invoiceNumber":"123465","shopupInvoiceNumber":null,"shopupInvoiceId":null,"customerName":"Jane Doe","customerPhone":"8801873445555","deliveryAddress":"50 Lake Circus (7th floor) Kalabagan","area":"Tejgaon","areaId":98,"sourceHubId":null,"destinationHubId":null,"countryCode":"BD","country":null,"postCode":"1208","city":null,"state":"","paymentMethod":"cash on delivery","weight":500,"cash":0,"previousPrice":null,"value":"0","liftingPrice":0,"isCashDeposited":0,"shopupCharge":60,"shopupCodCharge":0,"subsidyAmount":0,"partnerCodCharge":0,"partnerReturnCharge":0,"shopupReturnCharge":0,"paidAmount":0,"gatewayPaidAmount":null,"gatewayMedium":null,"isChargePaid":0,"isPartial":0,"parentParcelId":null,"parcelDeliveryType":"regular","isProblematic":0,"isReverseDelivery":0,"numberOfAttempts":0,"status":"pickup-pending","sellerStatus":"pickup-pending","partnerStatus":null,"partnerId":3,"partnerTrakingId":null,"partnerCharge":0,"partnerName":"ShopUp","buyerInstruction":null,"sellerInstruction":"Give cash amount zero if payment already done","shopupNote":null,"sellerNote":null,"isDeleted":0,"isChecked":0,"isHidden":0,"bulkId":"kkov9t9j","bulkTransferId":null,"agentId":null,"deliveryAgentId":null,"logisticsInvoiceId":null,"resellerSettlementId":null,"createdAt":"2021-02-03T03:24:05.000Z","updatedAt":"2021-02-03T03:24:05.000Z","isSettled":0,"isReturned":0,"deliveryReadyTime":null,"firstMileReceivedTime":null,"packageType":null,"parcelDetailsJson":null,"returnReason":null,"returnComment":null,"holdReason":null,"holdComment":null,"comment":null,"compensateAmount":0,"cashUpdateInfo":null,"isExchanged":0,"exchangeFor":null,"partialReturnedParcelId":null,"exchangeReturnedParcelId":null,"exchangeDeliveredParcelId":null,"partialDeliveredParcelId":null,"isShawnirbhor":0,"isReseller":0,"isHyperLocal":0,"deliveryOtp":null,"isDeliveryOtpVerified":0,"merchantDeliveryCharge":0,"isIssueRaised":0,"currentIssueId":null,"returnOtp":null,"isReturnOtpVerified":0,"lineHaulId":null,"isReconcile":0,"isReconcilable":0,"pickupAreaId":448,"processIdentifier":null,"trackingId":"21A2A3WE3K45W","parcelType":"regular","parentParcelTrackingId":null,"pickupStoreId":64107,"sellerPhone":"8801401122188","isResellerShop":0,"shopCreatedAt":"2021-01-28T05:41:07.000Z","resellerId":null,"hubId":2,"hubName":"Mohakhali Hub","shopPickupArea":null,"shopPickupAddress":"CWH","deliveryAgentName":null,"parcel_id":5977364},{"id":"21A2A3WE3K45X","shopId":648106,"shopName":"Bulk Issue Test Shop","shopPhone":"8801401122188","adminNumber":null,"srNumber":null,"pickupAddress":"CWH","pickupDate":"2021-02-03T05:30:00.000Z","deliveryDate":"2021-02-04T10:30:00.000Z","deliveryType":"regular","parcelPackageType":null,"invoiceNumber":"123466","shopupInvoiceNumber":null,"shopupInvoiceId":null,"customerName":"John Doe","customerPhone":"8801873445555","deliveryAddress":"House name (Apt number), Road number ","area":"Tejgaon","areaId":98,"sourceHubId":null,"destinationHubId":null,"countryCode":"BD","country":null,"postCode":"1208","city":null,"state":"","paymentMethod":"cash on delivery","weight":500,"cash":120,"previousPrice":null,"value":"0","liftingPrice":0,"isCashDeposited":0,"shopupCharge":60,"shopupCodCharge":0,"subsidyAmount":1.2,"partnerCodCharge":0,"partnerReturnCharge":0,"shopupReturnCharge":0,"paidAmount":0,"gatewayPaidAmount":null,"gatewayMedium":null,"isChargePaid":0,"isPartial":0,"parentParcelId":null,"parcelDeliveryType":"regular","isProblematic":0,"isReverseDelivery":0,"numberOfAttempts":0,"status":"pickup-pending","sellerStatus":"pickup-pending","partnerStatus":null,"partnerId":3,"partnerTrakingId":null,"partnerCharge":0,"partnerName":"ShopUp","buyerInstruction":null,"sellerInstruction":"Comment regarding delivery","shopupNote":null,"sellerNote":null,"isDeleted":0,"isChecked":0,"isHidden":0,"bulkId":"kkov9t9j","bulkTransferId":null,"agentId":null,"deliveryAgentId":null,"logisticsInvoiceId":null,"resellerSettlementId":null,"createdAt":"2021-02-03T03:24:05.000Z","updatedAt":"2021-02-03T03:24:05.000Z","isSettled":0,"isReturned":0,"deliveryReadyTime":null,"firstMileReceivedTime":null,"packageType":null,"parcelDetailsJson":null,"returnReason":null,"returnComment":null,"holdReason":null,"holdComment":null,"comment":null,"compensateAmount":0,"cashUpdateInfo":null,"isExchanged":0,"exchangeFor":null,"partialReturnedParcelId":null,"exchangeReturnedParcelId":null,"exchangeDeliveredParcelId":null,"partialDeliveredParcelId":null,"isShawnirbhor":0,"isReseller":0,"isHyperLocal":0,"deliveryOtp":null,"isDeliveryOtpVerified":0,"merchantDeliveryCharge":0,"isIssueRaised":0,"currentIssueId":null,"returnOtp":null,"isReturnOtpVerified":0,"lineHaulId":null,"isReconcile":0,"isReconcilable":0,"pickupAreaId":448,"processIdentifier":null,"trackingId":"21A2A3WE3K45X","parcelType":"regular","parentParcelTrackingId":null,"pickupStoreId":64107,"sellerPhone":"8801401122188","isResellerShop":0,"shopCreatedAt":"2021-01-28T05:41:07.000Z","resellerId":null,"hubId":2,"hubName":"Mohakhali Hub","shopPickupArea":null,"shopPickupAddress":"CWH","deliveryAgentName":null,"parcel_id":5977365},{"id":"21A2A3WE3K45Y","shopId":648106,"shopName":"Bulk Issue Test Shop","shopPhone":"8801401122188","adminNumber":null,"srNumber":null,"pickupAddress":"CWH","pickupDate":"2021-02-03T05:30:00.000Z","deliveryDate":"2021-02-04T10:30:00.000Z","deliveryType":"regular","parcelPackageType":null,"invoiceNumber":"123467","shopupInvoiceNumber":null,"shopupInvoiceId":null,"customerName":"Jane Doe","customerPhone":"8801873445555","deliveryAddress":"50 Lake Circus (7th floor) Kalabagan","area":"Tejgaon","areaId":98,"sourceHubId":null,"destinationHubId":null,"countryCode":"BD","country":null,"postCode":"1208","city":null,"state":"","paymentMethod":"cash on delivery","weight":500,"cash":0,"previousPrice":null,"value":"0","liftingPrice":0,"isCashDeposited":0,"shopupCharge":60,"shopupCodCharge":0,"subsidyAmount":0,"partnerCodCharge":0,"partnerReturnCharge":0,"shopupReturnCharge":0,"paidAmount":0,"gatewayPaidAmount":null,"gatewayMedium":null,"isChargePaid":0,"isPartial":0,"parentParcelId":null,"parcelDeliveryType":"regular","isProblematic":0,"isReverseDelivery":0,"numberOfAttempts":0,"status":"pickup-pending","sellerStatus":"pickup-pending","partnerStatus":null,"partnerId":3,"partnerTrakingId":null,"partnerCharge":0,"partnerName":"ShopUp","buyerInstruction":null,"sellerInstruction":"Give cash amount zero if payment already done","shopupNote":null,"sellerNote":null,"isDeleted":0,"isChecked":0,"isHidden":0,"bulkId":"kkov9t9j","bulkTransferId":null,"agentId":null,"deliveryAgentId":null,"logisticsInvoiceId":null,"resellerSettlementId":null,"createdAt":"2021-02-03T03:24:05.000Z","updatedAt":"2021-02-03T03:24:05.000Z","isSettled":0,"isReturned":0,"deliveryReadyTime":null,"firstMileReceivedTime":null,"packageType":null,"parcelDetailsJson":null,"returnReason":null,"returnComment":null,"holdReason":null,"holdComment":null,"comment":null,"compensateAmount":0,"cashUpdateInfo":null,"isExchanged":0,"exchangeFor":null,"partialReturnedParcelId":null,"exchangeReturnedParcelId":null,"exchangeDeliveredParcelId":null,"partialDeliveredParcelId":null,"isShawnirbhor":0,"isReseller":0,"isHyperLocal":0,"deliveryOtp":null,"isDeliveryOtpVerified":0,"merchantDeliveryCharge":0,"isIssueRaised":0,"currentIssueId":null,"returnOtp":null,"isReturnOtpVerified":0,"lineHaulId":null,"isReconcile":0,"isReconcilable":0,"pickupAreaId":448,"processIdentifier":null,"trackingId":"21A2A3WE3K45Y","parcelType":"regular","parentParcelTrackingId":null,"pickupStoreId":64107,"sellerPhone":"8801401122188","isResellerShop":0,"shopCreatedAt":"2021-01-28T05:41:07.000Z","resellerId":null,"hubId":2,"hubName":"Mohakhali Hub","shopPickupArea":null,"shopPickupAddress":"CWH","deliveryAgentName":null,"parcel_id":5977366},{"id":"21A2A3WE3K45Z","shopId":648106,"shopName":"Bulk Issue Test Shop","shopPhone":"8801401122188","adminNumber":null,"srNumber":null,"pickupAddress":"CWH","pickupDate":"2021-02-03T05:30:00.000Z","deliveryDate":"2021-02-04T10:30:00.000Z","deliveryType":"regular","parcelPackageType":null,"invoiceNumber":"123468","shopupInvoiceNumber":null,"shopupInvoiceId":null,"customerName":"John Doe","customerPhone":"8801873445555","deliveryAddress":"House name (Apt number), Road number ","area":"Tejgaon","areaId":98,"sourceHubId":null,"destinationHubId":null,"countryCode":"BD","country":null,"postCode":"1208","city":null,"state":"","paymentMethod":"cash on delivery","weight":500,"cash":120,"previousPrice":null,"value":"0","liftingPrice":0,"isCashDeposited":0,"shopupCharge":60,"shopupCodCharge":0,"subsidyAmount":1.2,"partnerCodCharge":0,"partnerReturnCharge":0,"shopupReturnCharge":0,"paidAmount":0,"gatewayPaidAmount":null,"gatewayMedium":null,"isChargePaid":0,"isPartial":0,"parentParcelId":null,"parcelDeliveryType":"regular","isProblematic":0,"isReverseDelivery":0,"numberOfAttempts":0,"status":"pickup-pending","sellerStatus":"pickup-pending","partnerStatus":null,"partnerId":3,"partnerTrakingId":null,"partnerCharge":0,"partnerName":"ShopUp","buyerInstruction":null,"sellerInstruction":"Comment regarding delivery","shopupNote":null,"sellerNote":null,"isDeleted":0,"isChecked":0,"isHidden":0,"bulkId":"kkov9t9j","bulkTransferId":null,"agentId":null,"deliveryAgentId":null,"logisticsInvoiceId":null,"resellerSettlementId":null,"createdAt":"2021-02-03T03:24:05.000Z","updatedAt":"2021-02-03T03:24:05.000Z","isSettled":0,"isReturned":0,"deliveryReadyTime":null,"firstMileReceivedTime":null,"packageType":null,"parcelDetailsJson":null,"returnReason":null,"returnComment":null,"holdReason":null,"holdComment":null,"comment":null,"compensateAmount":0,"cashUpdateInfo":null,"isExchanged":0,"exchangeFor":null,"partialReturnedParcelId":null,"exchangeReturnedParcelId":null,"exchangeDeliveredParcelId":null,"partialDeliveredParcelId":null,"isShawnirbhor":0,"isReseller":0,"isHyperLocal":0,"deliveryOtp":null,"isDeliveryOtpVerified":0,"merchantDeliveryCharge":0,"isIssueRaised":0,"currentIssueId":null,"returnOtp":null,"isReturnOtpVerified":0,"lineHaulId":null,"isReconcile":0,"isReconcilable":0,"pickupAreaId":448,"processIdentifier":null,"trackingId":"21A2A3WE3K45Z","parcelType":"regular","parentParcelTrackingId":null,"pickupStoreId":64107,"sellerPhone":"8801401122188","isResellerShop":0,"shopCreatedAt":"2021-01-28T05:41:07.000Z","resellerId":null,"hubId":2,"hubName":"Mohakhali Hub","shopPickupArea":null,"shopPickupAddress":"CWH","deliveryAgentName":null,"parcel_id":5977367},{"id":"21A2A3WE3K460","shopId":648106,"shopName":"Bulk Issue Test Shop","shopPhone":"8801401122188","adminNumber":null,"srNumber":null,"pickupAddress":"CWH","pickupDate":"2021-02-03T05:30:00.000Z","deliveryDate":"2021-02-04T10:30:00.000Z","deliveryType":"regular","parcelPackageType":null,"invoiceNumber":"123469","shopupInvoiceNumber":null,"shopupInvoiceId":null,"customerName":"Jane Doe","customerPhone":"8801873445555","deliveryAddress":"50 Lake Circus (7th floor) Kalabagan","area":"Tejgaon","areaId":98,"sourceHubId":null,"destinationHubId":null,"countryCode":"BD","country":null,"postCode":"1208","city":null,"state":"","paymentMethod":"cash on delivery","weight":500,"cash":0,"previousPrice":null,"value":"0","liftingPrice":0,"isCashDeposited":0,"shopupCharge":60,"shopupCodCharge":0,"subsidyAmount":0,"partnerCodCharge":0,"partnerReturnCharge":0,"shopupReturnCharge":0,"paidAmount":0,"gatewayPaidAmount":null,"gatewayMedium":null,"isChargePaid":0,"isPartial":0,"parentParcelId":null,"parcelDeliveryType":"regular","isProblematic":0,"isReverseDelivery":0,"numberOfAttempts":0,"status":"pickup-pending","sellerStatus":"pickup-pending","partnerStatus":null,"partnerId":3,"partnerTrakingId":null,"partnerCharge":0,"partnerName":"ShopUp","buyerInstruction":null,"sellerInstruction":"Give cash amount zero if payment already done","shopupNote":null,"sellerNote":null,"isDeleted":0,"isChecked":0,"isHidden":0,"bulkId":"kkov9t9j","bulkTransferId":null,"agentId":null,"deliveryAgentId":null,"logisticsInvoiceId":null,"resellerSettlementId":null,"createdAt":"2021-02-03T03:24:05.000Z","updatedAt":"2021-02-03T03:24:05.000Z","isSettled":0,"isReturned":0,"deliveryReadyTime":null,"firstMileReceivedTime":null,"packageType":null,"parcelDetailsJson":null,"returnReason":null,"returnComment":null,"holdReason":null,"holdComment":null,"comment":null,"compensateAmount":0,"cashUpdateInfo":null,"isExchanged":0,"exchangeFor":null,"partialReturnedParcelId":null,"exchangeReturnedParcelId":null,"exchangeDeliveredParcelId":null,"partialDeliveredParcelId":null,"isShawnirbhor":0,"isReseller":0,"isHyperLocal":0,"deliveryOtp":null,"isDeliveryOtpVerified":0,"merchantDeliveryCharge":0,"isIssueRaised":0,"currentIssueId":null,"returnOtp":null,"isReturnOtpVerified":0,"lineHaulId":null,"isReconcile":0,"isReconcilable":0,"pickupAreaId":448,"processIdentifier":null,"trackingId":"21A2A3WE3K460","parcelType":"regular","parentParcelTrackingId":null,"pickupStoreId":64107,"sellerPhone":"8801401122188","isResellerShop":0,"shopCreatedAt":"2021-01-28T05:41:07.000Z","resellerId":null,"hubId":2,"hubName":"Mohakhali Hub","shopPickupArea":null,"shopPickupAddress":"CWH","deliveryAgentName":null,"parcel_id":5977368},{"id":"21A2A3WE3K461","shopId":648106,"shopName":"Bulk Issue Test Shop","shopPhone":"8801401122188","adminNumber":null,"srNumber":null,"pickupAddress":"CWH","pickupDate":"2021-02-03T05:30:00.000Z","deliveryDate":"2021-02-04T10:30:00.000Z","deliveryType":"regular","parcelPackageType":null,"invoiceNumber":"123470","shopupInvoiceNumber":null,"shopupInvoiceId":null,"customerName":"John Doe","customerPhone":"8801873445555","deliveryAddress":"House name (Apt number), Road number ","area":"Tejgaon","areaId":98,"sourceHubId":null,"destinationHubId":null,"countryCode":"BD","country":null,"postCode":"1208","city":null,"state":"","paymentMethod":"cash on delivery","weight":500,"cash":120,"previousPrice":null,"value":"0","liftingPrice":0,"isCashDeposited":0,"shopupCharge":60,"shopupCodCharge":0,"subsidyAmount":1.2,"partnerCodCharge":0,"partnerReturnCharge":0,"shopupReturnCharge":0,"paidAmount":0,"gatewayPaidAmount":null,"gatewayMedium":null,"isChargePaid":0,"isPartial":0,"parentParcelId":null,"parcelDeliveryType":"regular","isProblematic":0,"isReverseDelivery":0,"numberOfAttempts":0,"status":"pickup-pending","sellerStatus":"pickup-pending","partnerStatus":null,"partnerId":3,"partnerTrakingId":null,"partnerCharge":0,"partnerName":"ShopUp","buyerInstruction":null,"sellerInstruction":"Comment regarding delivery","shopupNote":null,"sellerNote":null,"isDeleted":0,"isChecked":0,"isHidden":0,"bulkId":"kkov9t9j","bulkTransferId":null,"agentId":null,"deliveryAgentId":null,"logisticsInvoiceId":null,"resellerSettlementId":null,"createdAt":"2021-02-03T03:24:05.000Z","updatedAt":"2021-02-03T03:24:06.000Z","isSettled":0,"isReturned":0,"deliveryReadyTime":null,"firstMileReceivedTime":null,"packageType":null,"parcelDetailsJson":null,"returnReason":null,"returnComment":null,"holdReason":null,"holdComment":null,"comment":null,"compensateAmount":0,"cashUpdateInfo":null,"isExchanged":0,"exchangeFor":null,"partialReturnedParcelId":null,"exchangeReturnedParcelId":null,"exchangeDeliveredParcelId":null,"partialDeliveredParcelId":null,"isShawnirbhor":0,"isReseller":0,"isHyperLocal":0,"deliveryOtp":null,"isDeliveryOtpVerified":0,"merchantDeliveryCharge":0,"isIssueRaised":0,"currentIssueId":null,"returnOtp":null,"isReturnOtpVerified":0,"lineHaulId":null,"isReconcile":0,"isReconcilable":0,"pickupAreaId":448,"processIdentifier":null,"trackingId":"21A2A3WE3K461","parcelType":"regular","parentParcelTrackingId":null,"pickupStoreId":64107,"sellerPhone":"8801401122188","isResellerShop":0,"shopCreatedAt":"2021-01-28T05:41:07.000Z","resellerId":null,"hubId":2,"hubName":"Mohakhali Hub","shopPickupArea":null,"shopPickupAddress":"CWH","deliveryAgentName":null,"parcel_id":5977369},{"id":"21A2A3WE3K45R","shopId":648106,"shopName":"Bulk Issue Test Shop","shopPhone":"8801401122188","adminNumber":null,"srNumber":null,"pickupAddress":"CWH","pickupDate":"2021-02-03T05:30:00.000Z","deliveryDate":"2021-02-04T10:30:00.000Z","deliveryType":"regular","parcelPackageType":null,"invoiceNumber":"123460","shopupInvoiceNumber":null,"shopupInvoiceId":null,"customerName":"John Doe","customerPhone":"8801873445555","deliveryAddress":"House name (Apt number), Road number ","area":"Tejgaon","areaId":98,"sourceHubId":null,"destinationHubId":null,"countryCode":"BD","country":null,"postCode":"1208","city":null,"state":"","paymentMethod":"cash on delivery","weight":500,"cash":120,"previousPrice":null,"value":"0","liftingPrice":0,"isCashDeposited":0,"shopupCharge":60,"shopupCodCharge":0,"subsidyAmount":1.2,"partnerCodCharge":0,"partnerReturnCharge":0,"shopupReturnCharge":0,"paidAmount":0,"gatewayPaidAmount":null,"gatewayMedium":null,"isChargePaid":0,"isPartial":0,"parentParcelId":null,"parcelDeliveryType":"regular","isProblematic":0,"isReverseDelivery":0,"numberOfAttempts":0,"status":"pickup-pending","sellerStatus":"pickup-pending","partnerStatus":null,"partnerId":3,"partnerTrakingId":null,"partnerCharge":0,"partnerName":"ShopUp","buyerInstruction":null,"sellerInstruction":"Comment regarding delivery","shopupNote":null,"sellerNote":null,"isDeleted":0,"isChecked":0,"isHidden":0,"bulkId":"kkov9t9j","bulkTransferId":null,"agentId":null,"deliveryAgentId":null,"logisticsInvoiceId":null,"resellerSettlementId":null,"createdAt":"2021-02-03T03:24:04.000Z","updatedAt":"2021-02-03T03:24:04.000Z","isSettled":0,"isReturned":0,"deliveryReadyTime":null,"firstMileReceivedTime":null,"packageType":null,"parcelDetailsJson":null,"returnReason":null,"returnComment":null,"holdReason":null,"holdComment":null,"comment":null,"compensateAmount":0,"cashUpdateInfo":null,"isExchanged":0,"exchangeFor":null,"partialReturnedParcelId":null,"exchangeReturnedParcelId":null,"exchangeDeliveredParcelId":null,"partialDeliveredParcelId":null,"isShawnirbhor":0,"isReseller":0,"isHyperLocal":0,"deliveryOtp":null,"isDeliveryOtpVerified":0,"merchantDeliveryCharge":0,"isIssueRaised":0,"currentIssueId":null,"returnOtp":null,"isReturnOtpVerified":0,"lineHaulId":null,"isReconcile":0,"isReconcilable":0,"pickupAreaId":448,"processIdentifier":null,"trackingId":"21A2A3WE3K45R","parcelType":"regular","parentParcelTrackingId":null,"pickupStoreId":64107,"sellerPhone":"8801401122188","isResellerShop":0,"shopCreatedAt":"2021-01-28T05:41:07.000Z","resellerId":null,"hubId":2,"hubName":"Mohakhali Hub","shopPickupArea":null,"shopPickupAddress":"CWH","deliveryAgentName":null,"parcel_id":5977359},{"id":"21A2A3WE3K45S","shopId":648106,"shopName":"Bulk Issue Test Shop","shopPhone":"8801401122188","adminNumber":null,"srNumber":null,"pickupAddress":"CWH","pickupDate":"2021-02-03T05:30:00.000Z","deliveryDate":"2021-02-04T10:30:00.000Z","deliveryType":"regular","parcelPackageType":null,"invoiceNumber":"123461","shopupInvoiceNumber":null,"shopupInvoiceId":null,"customerName":"Jane Doe","customerPhone":"8801873445555","deliveryAddress":"50 Lake Circus (7th floor) Kalabagan","area":"Tejgaon","areaId":98,"sourceHubId":null,"destinationHubId":null,"countryCode":"BD","country":null,"postCode":"1208","city":null,"state":"","paymentMethod":"cash on delivery","weight":500,"cash":0,"previousPrice":null,"value":"0","liftingPrice":0,"isCashDeposited":0,"shopupCharge":60,"shopupCodCharge":0,"subsidyAmount":0,"partnerCodCharge":0,"partnerReturnCharge":0,"shopupReturnCharge":0,"paidAmount":0,"gatewayPaidAmount":null,"gatewayMedium":null,"isChargePaid":0,"isPartial":0,"parentParcelId":null,"parcelDeliveryType":"regular","isProblematic":0,"isReverseDelivery":0,"numberOfAttempts":0,"status":"pickup-pending","sellerStatus":"pickup-pending","partnerStatus":null,"partnerId":3,"partnerTrakingId":null,"partnerCharge":0,"partnerName":"ShopUp","buyerInstruction":null,"sellerInstruction":"Give cash amount zero if payment already done","shopupNote":null,"sellerNote":null,"isDeleted":0,"isChecked":0,"isHidden":0,"bulkId":"kkov9t9j","bulkTransferId":null,"agentId":null,"deliveryAgentId":null,"logisticsInvoiceId":null,"resellerSettlementId":null,"createdAt":"2021-02-03T03:24:04.000Z","updatedAt":"2021-02-03T03:24:04.000Z","isSettled":0,"isReturned":0,"deliveryReadyTime":null,"firstMileReceivedTime":null,"packageType":null,"parcelDetailsJson":null,"returnReason":null,"returnComment":null,"holdReason":null,"holdComment":null,"comment":null,"compensateAmount":0,"cashUpdateInfo":null,"isExchanged":0,"exchangeFor":null,"partialReturnedParcelId":null,"exchangeReturnedParcelId":null,"exchangeDeliveredParcelId":null,"partialDeliveredParcelId":null,"isShawnirbhor":0,"isReseller":0,"isHyperLocal":0,"deliveryOtp":null,"isDeliveryOtpVerified":0,"merchantDeliveryCharge":0,"isIssueRaised":0,"currentIssueId":null,"returnOtp":null,"isReturnOtpVerified":0,"lineHaulId":null,"isReconcile":0,"isReconcilable":0,"pickupAreaId":448,"processIdentifier":null,"trackingId":"21A2A3WE3K45S","parcelType":"regular","parentParcelTrackingId":null,"pickupStoreId":64107,"sellerPhone":"8801401122188","isResellerShop":0,"shopCreatedAt":"2021-01-28T05:41:07.000Z","resellerId":null,"hubId":2,"hubName":"Mohakhali Hub","shopPickupArea":null,"shopPickupAddress":"CWH","deliveryAgentName":null,"parcel_id":5977360},{"id":"21A2A3WE3K45T","shopId":648106,"shopName":"Bulk Issue Test Shop","shopPhone":"8801401122188","adminNumber":null,"srNumber":null,"pickupAddress":"CWH","pickupDate":"2021-02-03T05:30:00.000Z","deliveryDate":"2021-02-04T10:30:00.000Z","deliveryType":"regular","parcelPackageType":null,"invoiceNumber":"123462","shopupInvoiceNumber":null,"shopupInvoiceId":null,"customerName":"John Doe","customerPhone":"8801873445555","deliveryAddress":"House name (Apt number), Road number ","area":"Tejgaon","areaId":98,"sourceHubId":null,"destinationHubId":null,"countryCode":"BD","country":null,"postCode":"1208","city":null,"state":"","paymentMethod":"cash on delivery","weight":500,"cash":120,"previousPrice":null,"value":"0","liftingPrice":0,"isCashDeposited":0,"shopupCharge":60,"shopupCodCharge":0,"subsidyAmount":1.2,"partnerCodCharge":0,"partnerReturnCharge":0,"shopupReturnCharge":0,"paidAmount":0,"gatewayPaidAmount":null,"gatewayMedium":null,"isChargePaid":0,"isPartial":0,"parentParcelId":null,"parcelDeliveryType":"regular","isProblematic":0,"isReverseDelivery":0,"numberOfAttempts":0,"status":"pickup-pending","sellerStatus":"pickup-pending","partnerStatus":null,"partnerId":3,"partnerTrakingId":null,"partnerCharge":0,"partnerName":"ShopUp","buyerInstruction":null,"sellerInstruction":"Comment regarding delivery","shopupNote":null,"sellerNote":null,"isDeleted":0,"isChecked":0,"isHidden":0,"bulkId":"kkov9t9j","bulkTransferId":null,"agentId":null,"deliveryAgentId":null,"logisticsInvoiceId":null,"resellerSettlementId":null,"createdAt":"2021-02-03T03:24:04.000Z","updatedAt":"2021-02-03T03:24:04.000Z","isSettled":0,"isReturned":0,"deliveryReadyTime":null,"firstMileReceivedTime":null,"packageType":null,"parcelDetailsJson":null,"returnReason":null,"returnComment":null,"holdReason":null,"holdComment":null,"comment":null,"compensateAmount":0,"cashUpdateInfo":null,"isExchanged":0,"exchangeFor":null,"partialReturnedParcelId":null,"exchangeReturnedParcelId":null,"exchangeDeliveredParcelId":null,"partialDeliveredParcelId":null,"isShawnirbhor":0,"isReseller":0,"isHyperLocal":0,"deliveryOtp":null,"isDeliveryOtpVerified":0,"merchantDeliveryCharge":0,"isIssueRaised":0,"currentIssueId":null,"returnOtp":null,"isReturnOtpVerified":0,"lineHaulId":null,"isReconcile":0,"isReconcilable":0,"pickupAreaId":448,"processIdentifier":null,"trackingId":"21A2A3WE3K45T","parcelType":"regular","parentParcelTrackingId":null,"pickupStoreId":64107,"sellerPhone":"8801401122188","isResellerShop":0,"shopCreatedAt":"2021-01-28T05:41:07.000Z","resellerId":null,"hubId":2,"hubName":"Mohakhali Hub","shopPickupArea":null,"shopPickupAddress":"CWH","deliveryAgentName":null,"parcel_id":5977361},{"id":"21A2A3WE3K45U","shopId":648106,"shopName":"Bulk Issue Test Shop","shopPhone":"8801401122188","adminNumber":null,"srNumber":null,"pickupAddress":"CWH","pickupDate":"2021-02-03T05:30:00.000Z","deliveryDate":"2021-02-04T10:30:00.000Z","deliveryType":"regular","parcelPackageType":null,"invoiceNumber":"123463","shopupInvoiceNumber":null,"shopupInvoiceId":null,"customerName":"Jane Doe","customerPhone":"8801873445555","deliveryAddress":"50 Lake Circus (7th floor) Kalabagan","area":"Tejgaon","areaId":98,"sourceHubId":null,"destinationHubId":null,"countryCode":"BD","country":null,"postCode":"1208","city":null,"state":"","paymentMethod":"cash on delivery","weight":500,"cash":0,"previousPrice":null,"value":"0","liftingPrice":0,"isCashDeposited":0,"shopupCharge":60,"shopupCodCharge":0,"subsidyAmount":0,"partnerCodCharge":0,"partnerReturnCharge":0,"shopupReturnCharge":0,"paidAmount":0,"gatewayPaidAmount":null,"gatewayMedium":null,"isChargePaid":0,"isPartial":0,"parentParcelId":null,"parcelDeliveryType":"regular","isProblematic":0,"isReverseDelivery":0,"numberOfAttempts":0,"status":"pickup-pending","sellerStatus":"pickup-pending","partnerStatus":null,"partnerId":3,"partnerTrakingId":null,"partnerCharge":0,"partnerName":"ShopUp","buyerInstruction":null,"sellerInstruction":"Give cash amount zero if payment already done","shopupNote":null,"sellerNote":null,"isDeleted":0,"isChecked":0,"isHidden":0,"bulkId":"kkov9t9j","bulkTransferId":null,"agentId":null,"deliveryAgentId":null,"logisticsInvoiceId":null,"resellerSettlementId":null,"createdAt":"2021-02-03T03:24:04.000Z","updatedAt":"2021-02-03T03:24:04.000Z","isSettled":0,"isReturned":0,"deliveryReadyTime":null,"firstMileReceivedTime":null,"packageType":null,"parcelDetailsJson":null,"returnReason":null,"returnComment":null,"holdReason":null,"holdComment":null,"comment":null,"compensateAmount":0,"cashUpdateInfo":null,"isExchanged":0,"exchangeFor":null,"partialReturnedParcelId":null,"exchangeReturnedParcelId":null,"exchangeDeliveredParcelId":null,"partialDeliveredParcelId":null,"isShawnirbhor":0,"isReseller":0,"isHyperLocal":0,"deliveryOtp":null,"isDeliveryOtpVerified":0,"merchantDeliveryCharge":0,"isIssueRaised":0,"currentIssueId":null,"returnOtp":null,"isReturnOtpVerified":0,"lineHaulId":null,"isReconcile":0,"isReconcilable":0,"pickupAreaId":448,"processIdentifier":null,"trackingId":"21A2A3WE3K45U","parcelType":"regular","parentParcelTrackingId":null,"pickupStoreId":64107,"sellerPhone":"8801401122188","isResellerShop":0,"shopCreatedAt":"2021-01-28T05:41:07.000Z","resellerId":null,"hubId":2,"hubName":"Mohakhali Hub","shopPickupArea":null,"shopPickupAddress":"CWH","deliveryAgentName":null,"parcel_id":5977362},{"id":"21A2A3WE3K45V","shopId":648106,"shopName":"Bulk Issue Test Shop","shopPhone":"8801401122188","adminNumber":null,"srNumber":null,"pickupAddress":"CWH","pickupDate":"2021-02-03T05:30:00.000Z","deliveryDate":"2021-02-04T10:30:00.000Z","deliveryType":"regular","parcelPackageType":null,"invoiceNumber":"123464","shopupInvoiceNumber":null,"shopupInvoiceId":null,"customerName":"John Doe","customerPhone":"8801873445555","deliveryAddress":"House name (Apt number), Road number ","area":"Tejgaon","areaId":98,"sourceHubId":null,"destinationHubId":null,"countryCode":"BD","country":null,"postCode":"1208","city":null,"state":"","paymentMethod":"cash on delivery","weight":500,"cash":120,"previousPrice":null,"value":"0","liftingPrice":0,"isCashDeposited":0,"shopupCharge":60,"shopupCodCharge":0,"subsidyAmount":1.2,"partnerCodCharge":0,"partnerReturnCharge":0,"shopupReturnCharge":0,"paidAmount":0,"gatewayPaidAmount":null,"gatewayMedium":null,"isChargePaid":0,"isPartial":0,"parentParcelId":null,"parcelDeliveryType":"regular","isProblematic":0,"isReverseDelivery":0,"numberOfAttempts":0,"status":"pickup-pending","sellerStatus":"pickup-pending","partnerStatus":null,"partnerId":3,"partnerTrakingId":null,"partnerCharge":0,"partnerName":"ShopUp","buyerInstruction":null,"sellerInstruction":"Comment regarding delivery","shopupNote":null,"sellerNote":null,"isDeleted":0,"isChecked":0,"isHidden":0,"bulkId":"kkov9t9j","bulkTransferId":null,"agentId":null,"deliveryAgentId":null,"logisticsInvoiceId":null,"resellerSettlementId":null,"createdAt":"2021-02-03T03:24:04.000Z","updatedAt":"2021-02-03T03:24:05.000Z","isSettled":0,"isReturned":0,"deliveryReadyTime":null,"firstMileReceivedTime":null,"packageType":null,"parcelDetailsJson":null,"returnReason":null,"returnComment":null,"holdReason":null,"holdComment":null,"comment":null,"compensateAmount":0,"cashUpdateInfo":null,"isExchanged":0,"exchangeFor":null,"partialReturnedParcelId":null,"exchangeReturnedParcelId":null,"exchangeDeliveredParcelId":null,"partialDeliveredParcelId":null,"isShawnirbhor":0,"isReseller":0,"isHyperLocal":0,"deliveryOtp":null,"isDeliveryOtpVerified":0,"merchantDeliveryCharge":0,"isIssueRaised":0,"currentIssueId":null,"returnOtp":null,"isReturnOtpVerified":0,"lineHaulId":null,"isReconcile":0,"isReconcilable":0,"pickupAreaId":448,"processIdentifier":null,"trackingId":"21A2A3WE3K45V","parcelType":"regular","parentParcelTrackingId":null,"pickupStoreId":64107,"sellerPhone":"8801401122188","isResellerShop":0,"shopCreatedAt":"2021-01-28T05:41:07.000Z","resellerId":null,"hubId":2,"hubName":"Mohakhali Hub","shopPickupArea":null,"shopPickupAddress":"CWH","deliveryAgentName":null,"parcel_id":5977363},{"id":"21A2A3WE3K45N","shopId":648106,"shopName":"Bulk Issue Test Shop","shopPhone":"8801401122188","adminNumber":null,"srNumber":null,"pickupAddress":"CWH","pickupDate":"2021-02-03T05:30:00.000Z","deliveryDate":"2021-02-04T10:30:00.000Z","deliveryType":"regular","parcelPackageType":null,"invoiceNumber":"123456","shopupInvoiceNumber":null,"shopupInvoiceId":null,"customerName":"John Doe","customerPhone":"8801873445555","deliveryAddress":"House name (Apt number), Road number ","area":"Tejgaon","areaId":98,"sourceHubId":null,"destinationHubId":null,"countryCode":"BD","country":null,"postCode":"1208","city":null,"state":"","paymentMethod":"cash on delivery","weight":500,"cash":120,"previousPrice":null,"value":"0","liftingPrice":0,"isCashDeposited":0,"shopupCharge":60,"shopupCodCharge":0,"subsidyAmount":1.2,"partnerCodCharge":0,"partnerReturnCharge":0,"shopupReturnCharge":0,"paidAmount":0,"gatewayPaidAmount":null,"gatewayMedium":null,"isChargePaid":0,"isPartial":0,"parentParcelId":null,"parcelDeliveryType":"regular","isProblematic":0,"isReverseDelivery":0,"numberOfAttempts":0,"status":"pickup-pending","sellerStatus":"pickup-pending","partnerStatus":null,"partnerId":3,"partnerTrakingId":null,"partnerCharge":0,"partnerName":"ShopUp","buyerInstruction":null,"sellerInstruction":"Comment regarding delivery","shopupNote":null,"sellerNote":null,"isDeleted":0,"isChecked":0,"isHidden":0,"bulkId":"kkov9t9j","bulkTransferId":null,"agentId":null,"deliveryAgentId":null,"logisticsInvoiceId":null,"resellerSettlementId":null,"createdAt":"2021-02-03T03:24:03.000Z","updatedAt":"2021-02-03T03:24:03.000Z","isSettled":0,"isReturned":0,"deliveryReadyTime":null,"firstMileReceivedTime":null,"packageType":null,"parcelDetailsJson":null,"returnReason":null,"returnComment":null,"holdReason":null,"holdComment":null,"comment":null,"compensateAmount":0,"cashUpdateInfo":null,"isExchanged":0,"exchangeFor":null,"partialReturnedParcelId":null,"exchangeReturnedParcelId":null,"exchangeDeliveredParcelId":null,"partialDeliveredParcelId":null,"isShawnirbhor":0,"isReseller":0,"isHyperLocal":0,"deliveryOtp":null,"isDeliveryOtpVerified":0,"merchantDeliveryCharge":0,"isIssueRaised":0,"currentIssueId":null,"returnOtp":null,"isReturnOtpVerified":0,"lineHaulId":null,"isReconcile":0,"isReconcilable":0,"pickupAreaId":448,"processIdentifier":null,"trackingId":"21A2A3WE3K45N","parcelType":"regular","parentParcelTrackingId":null,"pickupStoreId":64107,"sellerPhone":"8801401122188","isResellerShop":0,"shopCreatedAt":"2021-01-28T05:41:07.000Z","resellerId":null,"hubId":2,"hubName":"Mohakhali Hub","shopPickupArea":null,"shopPickupAddress":"CWH","deliveryAgentName":null,"parcel_id":5977355},{"id":"21A2A3WE3K45O","shopId":648106,"shopName":"Bulk Issue Test Shop","shopPhone":"8801401122188","adminNumber":null,"srNumber":null,"pickupAddress":"CWH","pickupDate":"2021-02-03T05:30:00.000Z","deliveryDate":"2021-02-04T10:30:00.000Z","deliveryType":"regular","parcelPackageType":null,"invoiceNumber":"123457","shopupInvoiceNumber":null,"shopupInvoiceId":null,"customerName":"Jane Doe","customerPhone":"8801873445555","deliveryAddress":"50 Lake Circus (7th floor) Kalabagan","area":"Tejgaon","areaId":98,"sourceHubId":null,"destinationHubId":null,"countryCode":"BD","country":null,"postCode":"1208","city":null,"state":"","paymentMethod":"cash on delivery","weight":500,"cash":0,"previousPrice":null,"value":"0","liftingPrice":0,"isCashDeposited":0,"shopupCharge":60,"shopupCodCharge":0,"subsidyAmount":0,"partnerCodCharge":0,"partnerReturnCharge":0,"shopupReturnCharge":0,"paidAmount":0,"gatewayPaidAmount":null,"gatewayMedium":null,"isChargePaid":0,"isPartial":0,"parentParcelId":null,"parcelDeliveryType":"regular","isProblematic":0,"isReverseDelivery":0,"numberOfAttempts":0,"status":"pickup-pending","sellerStatus":"pickup-pending","partnerStatus":null,"partnerId":3,"partnerTrakingId":null,"partnerCharge":0,"partnerName":"ShopUp","buyerInstruction":null,"sellerInstruction":"Give cash amount zero if payment already done","shopupNote":null,"sellerNote":null,"isDeleted":0,"isChecked":0,"isHidden":0,"bulkId":"kkov9t9j","bulkTransferId":null,"agentId":null,"deliveryAgentId":null,"logisticsInvoiceId":null,"resellerSettlementId":null,"createdAt":"2021-02-03T03:24:03.000Z","updatedAt":"2021-02-03T03:24:03.000Z","isSettled":0,"isReturned":0,"deliveryReadyTime":null,"firstMileReceivedTime":null,"packageType":null,"parcelDetailsJson":null,"returnReason":null,"returnComment":null,"holdReason":null,"holdComment":null,"comment":null,"compensateAmount":0,"cashUpdateInfo":null,"isExchanged":0,"exchangeFor":null,"partialReturnedParcelId":null,"exchangeReturnedParcelId":null,"exchangeDeliveredParcelId":null,"partialDeliveredParcelId":null,"isShawnirbhor":0,"isReseller":0,"isHyperLocal":0,"deliveryOtp":null,"isDeliveryOtpVerified":0,"merchantDeliveryCharge":0,"isIssueRaised":0,"currentIssueId":null,"returnOtp":null,"isReturnOtpVerified":0,"lineHaulId":null,"isReconcile":0,"isReconcilable":0,"pickupAreaId":448,"processIdentifier":null,"trackingId":"21A2A3WE3K45O","parcelType":"regular","parentParcelTrackingId":null,"pickupStoreId":64107,"sellerPhone":"8801401122188","isResellerShop":0,"shopCreatedAt":"2021-01-28T05:41:07.000Z","resellerId":null,"hubId":2,"hubName":"Mohakhali Hub","shopPickupArea":null,"shopPickupAddress":"CWH","deliveryAgentName":null,"parcel_id":5977356},{"id":"21A2A3WE3K45P","shopId":648106,"shopName":"Bulk Issue Test Shop","shopPhone":"8801401122188","adminNumber":null,"srNumber":null,"pickupAddress":"CWH","pickupDate":"2021-02-03T05:30:00.000Z","deliveryDate":"2021-02-04T10:30:00.000Z","deliveryType":"regular","parcelPackageType":null,"invoiceNumber":"123458","shopupInvoiceNumber":null,"shopupInvoiceId":null,"customerName":"John Doe","customerPhone":"8801873445555","deliveryAddress":"House name (Apt number), Road number ","area":"Tejgaon","areaId":98,"sourceHubId":null,"destinationHubId":null,"countryCode":"BD","country":null,"postCode":"1208","city":null,"state":"","paymentMethod":"cash on delivery","weight":500,"cash":120,"previousPrice":null,"value":"0","liftingPrice":0,"isCashDeposited":0,"shopupCharge":60,"shopupCodCharge":0,"subsidyAmount":1.2,"partnerCodCharge":0,"partnerReturnCharge":0,"shopupReturnCharge":0,"paidAmount":0,"gatewayPaidAmount":null,"gatewayMedium":null,"isChargePaid":0,"isPartial":0,"parentParcelId":null,"parcelDeliveryType":"regular","isProblematic":0,"isReverseDelivery":0,"numberOfAttempts":0,"status":"pickup-pending","sellerStatus":"pickup-pending","partnerStatus":null,"partnerId":3,"partnerTrakingId":null,"partnerCharge":0,"partnerName":"ShopUp","buyerInstruction":null,"sellerInstruction":"Comment regarding delivery","shopupNote":null,"sellerNote":null,"isDeleted":0,"isChecked":0,"isHidden":0,"bulkId":"kkov9t9j","bulkTransferId":null,"agentId":null,"deliveryAgentId":null,"logisticsInvoiceId":null,"resellerSettlementId":null,"createdAt":"2021-02-03T03:24:03.000Z","updatedAt":"2021-02-03T03:24:03.000Z","isSettled":0,"isReturned":0,"deliveryReadyTime":null,"firstMileReceivedTime":null,"packageType":null,"parcelDetailsJson":null,"returnReason":null,"returnComment":null,"holdReason":null,"holdComment":null,"comment":null,"compensateAmount":0,"cashUpdateInfo":null,"isExchanged":0,"exchangeFor":null,"partialReturnedParcelId":null,"exchangeReturnedParcelId":null,"exchangeDeliveredParcelId":null,"partialDeliveredParcelId":null,"isShawnirbhor":0,"isReseller":0,"isHyperLocal":0,"deliveryOtp":null,"isDeliveryOtpVerified":0,"merchantDeliveryCharge":0,"isIssueRaised":0,"currentIssueId":null,"returnOtp":null,"isReturnOtpVerified":0,"lineHaulId":null,"isReconcile":0,"isReconcilable":0,"pickupAreaId":448,"processIdentifier":null,"trackingId":"21A2A3WE3K45P","parcelType":"regular","parentParcelTrackingId":null,"pickupStoreId":64107,"sellerPhone":"8801401122188","isResellerShop":0,"shopCreatedAt":"2021-01-28T05:41:07.000Z","resellerId":null,"hubId":2,"hubName":"Mohakhali Hub","shopPickupArea":null,"shopPickupAddress":"CWH","deliveryAgentName":null,"parcel_id":5977357},{"id":"21A2A3WE3K45Q","shopId":648106,"shopName":"Bulk Issue Test Shop","shopPhone":"8801401122188","adminNumber":null,"srNumber":null,"pickupAddress":"CWH","pickupDate":"2021-02-03T05:30:00.000Z","deliveryDate":"2021-02-04T10:30:00.000Z","deliveryType":"regular","parcelPackageType":null,"invoiceNumber":"123459","shopupInvoiceNumber":null,"shopupInvoiceId":null,"customerName":"Jane Doe","customerPhone":"8801873445555","deliveryAddress":"50 Lake Circus (7th floor) Kalabagan","area":"Tejgaon","areaId":98,"sourceHubId":null,"destinationHubId":null,"countryCode":"BD","country":null,"postCode":"1208","city":null,"state":"","paymentMethod":"cash on delivery","weight":500,"cash":0,"previousPrice":null,"value":"0","liftingPrice":0,"isCashDeposited":0,"shopupCharge":60,"shopupCodCharge":0,"subsidyAmount":0,"partnerCodCharge":0,"partnerReturnCharge":0,"shopupReturnCharge":0,"paidAmount":0,"gatewayPaidAmount":null,"gatewayMedium":null,"isChargePaid":0,"isPartial":0,"parentParcelId":null,"parcelDeliveryType":"regular","isProblematic":0,"isReverseDelivery":0,"numberOfAttempts":0,"status":"pickup-pending","sellerStatus":"pickup-pending","partnerStatus":null,"partnerId":3,"partnerTrakingId":null,"partnerCharge":0,"partnerName":"ShopUp","buyerInstruction":null,"sellerInstruction":"Give cash amount zero if payment already done","shopupNote":null,"sellerNote":null,"isDeleted":0,"isChecked":0,"isHidden":0,"bulkId":"kkov9t9j","bulkTransferId":null,"agentId":null,"deliveryAgentId":null,"logisticsInvoiceId":null,"resellerSettlementId":null,"createdAt":"2021-02-03T03:24:03.000Z","updatedAt":"2021-02-03T03:24:04.000Z","isSettled":0,"isReturned":0,"deliveryReadyTime":null,"firstMileReceivedTime":null,"packageType":null,"parcelDetailsJson":null,"returnReason":null,"returnComment":null,"holdReason":null,"holdComment":null,"comment":null,"compensateAmount":0,"cashUpdateInfo":null,"isExchanged":0,"exchangeFor":null,"partialReturnedParcelId":null,"exchangeReturnedParcelId":null,"exchangeDeliveredParcelId":null,"partialDeliveredParcelId":null,"isShawnirbhor":0,"isReseller":0,"isHyperLocal":0,"deliveryOtp":null,"isDeliveryOtpVerified":0,"merchantDeliveryCharge":0,"isIssueRaised":0,"currentIssueId":null,"returnOtp":null,"isReturnOtpVerified":0,"lineHaulId":null,"isReconcile":0,"isReconcilable":0,"pickupAreaId":448,"processIdentifier":null,"trackingId":"21A2A3WE3K45Q","parcelType":"regular","parentParcelTrackingId":null,"pickupStoreId":64107,"sellerPhone":"8801401122188","isResellerShop":0,"shopCreatedAt":"2021-01-28T05:41:07.000Z","resellerId":null,"hubId":2,"hubName":"Mohakhali Hub","shopPickupArea":null,"shopPickupAddress":"CWH","deliveryAgentName":null,"parcel_id":5977358},{"id":"21A2A2TU3K443","shopId":648106,"shopName":"Bulk Issue Test Shop","shopPhone":"8801401122188","adminNumber":null,"srNumber":null,"pickupAddress":"CWH","pickupDate":"2021-02-03T05:30:00.000Z","deliveryDate":"2021-02-04T10:30:00.000Z","deliveryType":"regular","parcelPackageType":null,"invoiceNumber":"199170","shopupInvoiceNumber":null,"shopupInvoiceId":null,"customerName":"John Doe","customerPhone":"8801873445555","deliveryAddress":"House name (Apt number), Road number ","area":"Alfadanga","areaId":638,"sourceHubId":null,"destinationHubId":null,"countryCode":"BD","country":null,"postCode":"7870","city":null,"state":"","paymentMethod":"cash on delivery","weight":500,"cash":120,"previousPrice":null,"value":"0","liftingPrice":0,"isCashDeposited":0,"shopupCharge":130,"shopupCodCharge":1.2,"subsidyAmount":0,"partnerCodCharge":0,"partnerReturnCharge":65,"shopupReturnCharge":65,"paidAmount":0,"gatewayPaidAmount":null,"gatewayMedium":null,"isChargePaid":0,"isPartial":0,"parentParcelId":null,"parcelDeliveryType":"regular","isProblematic":0,"isReverseDelivery":0,"numberOfAttempts":0,"status":"pickup-pending","sellerStatus":"pickup-pending","partnerStatus":null,"partnerId":3,"partnerTrakingId":null,"partnerCharge":130,"partnerName":"ShopUp","buyerInstruction":null,"sellerInstruction":"Comment regarding delivery","shopupNote":null,"sellerNote":null,"isDeleted":0,"isChecked":0,"isHidden":0,"bulkId":"kknznkpt","bulkTransferId":null,"agentId":null,"deliveryAgentId":null,"logisticsInvoiceId":null,"resellerSettlementId":null,"createdAt":"2021-02-02T12:39:01.000Z","updatedAt":"2021-02-02T12:39:02.000Z","isSettled":0,"isReturned":0,"deliveryReadyTime":null,"firstMileReceivedTime":null,"packageType":null,"parcelDetailsJson":null,"returnReason":null,"returnComment":null,"holdReason":null,"holdComment":null,"comment":null,"compensateAmount":0,"cashUpdateInfo":null,"isExchanged":0,"exchangeFor":null,"partialReturnedParcelId":null,"exchangeReturnedParcelId":null,"exchangeDeliveredParcelId":null,"partialDeliveredParcelId":null,"isShawnirbhor":0,"isReseller":0,"isHyperLocal":0,"deliveryOtp":null,"isDeliveryOtpVerified":0,"merchantDeliveryCharge":0,"isIssueRaised":0,"currentIssueId":null,"returnOtp":null,"isReturnOtpVerified":0,"lineHaulId":null,"isReconcile":0,"isReconcilable":0,"pickupAreaId":448,"processIdentifier":null,"trackingId":"21A2A2TU3K443","parcelType":"regular","parentParcelTrackingId":null,"pickupStoreId":64107,"sellerPhone":"8801401122188","isResellerShop":0,"shopCreatedAt":"2021-01-28T05:41:07.000Z","resellerId":null,"hubId":26,"hubName":"Faridpur Hub","shopPickupArea":null,"shopPickupAddress":"CWH","deliveryAgentName":null,"parcel_id":5977299}]
     */

    private boolean error;
    private int count;
    private int totalAmount;
    private List<ParcelsBean> parcels;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<ParcelsBean> getParcels() {
        return parcels;
    }

    public void setParcels(List<ParcelsBean> parcels) {
        this.parcels = parcels;
    }

    public static class ParcelsBean implements Serializable {
        /**
         * id : 21A2A3WE3K462
         * shopId : 648106
         * shopName : Bulk Issue Test Shop
         * shopPhone : 8801401122188
         * adminNumber : null
         * srNumber : null
         * pickupAddress : CWH
         * pickupDate : 2021-02-03T05:30:00.000Z
         * deliveryDate : 2021-02-04T10:30:00.000Z
         * deliveryType : regular
         * parcelPackageType : null
         * invoiceNumber : 123471
         * shopupInvoiceNumber : null
         * shopupInvoiceId : null
         * customerName : Jane Doe
         * customerPhone : 8801873445555
         * deliveryAddress : 50 Lake Circus (7th floor) Kalabagan
         * area : Tejgaon
         * areaId : 98
         * sourceHubId : null
         * destinationHubId : null
         * countryCode : BD
         * country : null
         * postCode : 1208
         * city : null
         * state :
         * paymentMethod : cash on delivery
         * weight : 500
         * cash : 0
         * previousPrice : null
         * value : 0
         * liftingPrice : 0
         * isCashDeposited : 0
         * shopupCharge : 60
         * shopupCodCharge : 0
         * subsidyAmount : 0
         * partnerCodCharge : 0
         * partnerReturnCharge : 0
         * shopupReturnCharge : 0
         * paidAmount : 0
         * gatewayPaidAmount : null
         * gatewayMedium : null
         * isChargePaid : 0
         * isPartial : 0
         * parentParcelId : null
         * parcelDeliveryType : regular
         * isProblematic : 0
         * isReverseDelivery : 0
         * numberOfAttempts : 0
         * status : pickup-pending
         * sellerStatus : pickup-pending
         * partnerStatus : null
         * partnerId : 3
         * partnerTrakingId : null
         * partnerCharge : 0
         * partnerName : ShopUp
         * buyerInstruction : null
         * sellerInstruction : Give cash amount zero if payment already done
         * shopupNote : null
         * sellerNote : null
         * isDeleted : 0
         * isChecked : 0
         * isHidden : 0
         * bulkId : kkov9t9j
         * bulkTransferId : null
         * agentId : null
         * deliveryAgentId : null
         * logisticsInvoiceId : null
         * resellerSettlementId : null
         * createdAt : 2021-02-03T03:24:06.000Z
         * updatedAt : 2021-02-03T03:24:06.000Z
         * isSettled : 0
         * isReturned : 0
         * deliveryReadyTime : null
         * firstMileReceivedTime : null
         * packageType : null
         * parcelDetailsJson : null
         * returnReason : null
         * returnComment : null
         * holdReason : null
         * holdComment : null
         * comment : null
         * compensateAmount : 0
         * cashUpdateInfo : null
         * isExchanged : 0
         * exchangeFor : null
         * partialReturnedParcelId : null
         * exchangeReturnedParcelId : null
         * exchangeDeliveredParcelId : null
         * partialDeliveredParcelId : null
         * isShawnirbhor : 0
         * isReseller : 0
         * isHyperLocal : 0
         * deliveryOtp : null
         * isDeliveryOtpVerified : 0
         * merchantDeliveryCharge : 0
         * isIssueRaised : 0
         * currentIssueId : null
         * returnOtp : null
         * isReturnOtpVerified : 0
         * lineHaulId : null
         * isReconcile : 0
         * isReconcilable : 0
         * pickupAreaId : 448
         * processIdentifier : null
         * trackingId : 21A2A3WE3K462
         * parcelType : regular
         * parentParcelTrackingId : null
         * pickupStoreId : 64107
         * sellerPhone : 8801401122188
         * isResellerShop : 0
         * shopCreatedAt : 2021-01-28T05:41:07.000Z
         * resellerId : null
         * hubId : 2
         * hubName : Mohakhali Hub
         * shopPickupArea : null
         * shopPickupAddress : CWH
         * deliveryAgentName : null
         * parcel_id : 5977370
         */

        private String id;
        private int shopId;
        private String shopName;
        private String shopPhone;
        private Object adminNumber;
        private Object srNumber;
        private String pickupAddress;
        private String pickupDate;
        private String deliveryDate;
        private String deliveryType;
        private Object parcelPackageType;
        private String invoiceNumber;
        private Object shopupInvoiceNumber;
        private Object shopupInvoiceId;
        private String customerName;
        private String customerPhone;
        private String deliveryAddress;
        private String area;
        private int areaId;
        private Object sourceHubId;
        private Object destinationHubId;
        private String countryCode;
        private Object country;
        private String postCode;
        private Object city;
        private String state;
        private String paymentMethod;
        private int weight;
        private int cash;
        private Object previousPrice;
        private String value;
        private int liftingPrice;
        private int isCashDeposited;
        private int shopupCharge;
        private float shopupCodCharge;
        private float subsidyAmount;
        private int partnerCodCharge;
        private int partnerReturnCharge;
        private int shopupReturnCharge;
        private int paidAmount;
        private Object gatewayPaidAmount;
        private Object gatewayMedium;
        private int isChargePaid;
        private int isPartial;
        private Object parentParcelId;
        private String parcelDeliveryType;
        private int isProblematic;
        private int isReverseDelivery;
        private int numberOfAttempts;
        private String status;
        private String sellerStatus;
        private Object partnerStatus;
        private int partnerId;
        private Object partnerTrakingId;
        private int partnerCharge;
        private String partnerName;
        private Object buyerInstruction;
        private String sellerInstruction;
        private Object shopupNote;
        private Object sellerNote;
        private int isDeleted;
        private int isChecked;
        private int isHidden;
        private String bulkId;
        private Object bulkTransferId;
        private Object agentId;
        private Object deliveryAgentId;
        private Object logisticsInvoiceId;
        private Object resellerSettlementId;
        private String createdAt;
        private String updatedAt;
        private int isSettled;
        private int isReturned;
        private Object deliveryReadyTime;
        private Object firstMileReceivedTime;
        private Object packageType;
        private Object parcelDetailsJson;
        private Object returnReason;
        private Object returnComment;
        private Object holdReason;
        private Object holdComment;
        private Object comment;
        private int compensateAmount;
        private Object cashUpdateInfo;
        private int isExchanged;
        private Object exchangeFor;
        private Object partialReturnedParcelId;
        private Object exchangeReturnedParcelId;
        private Object exchangeDeliveredParcelId;
        private Object partialDeliveredParcelId;
        private int isShawnirbhor;
        private int isReseller;
        private int isHyperLocal;
        private Object deliveryOtp;
        private int isDeliveryOtpVerified;
        private int merchantDeliveryCharge;
        private int isIssueRaised;
        private Object currentIssueId;
        private Object returnOtp;
        private int isReturnOtpVerified;
        private Object lineHaulId;
        private int isReconcile;
        private int isReconcilable;
        private int pickupAreaId;
        private Object processIdentifier;
        private String trackingId;
        private String parcelType;
        private Object parentParcelTrackingId;
        private int pickupStoreId;
        private String sellerPhone;
        private int isResellerShop;
        private String shopCreatedAt;
        private Object resellerId;
        private int hubId;
        private String hubName;
        private Object shopPickupArea;
        private String shopPickupAddress;
        private Object deliveryAgentName;
        private int parcel_id;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getShopId() {
            return shopId;
        }

        public void setShopId(int shopId) {
            this.shopId = shopId;
        }

        public String getShopName() {
            return shopName;
        }

        public void setShopName(String shopName) {
            this.shopName = shopName;
        }

        public String getShopPhone() {
            return shopPhone;
        }

        public void setShopPhone(String shopPhone) {
            this.shopPhone = shopPhone;
        }

        public Object getAdminNumber() {
            return adminNumber;
        }

        public void setAdminNumber(Object adminNumber) {
            this.adminNumber = adminNumber;
        }

        public Object getSrNumber() {
            return srNumber;
        }

        public void setSrNumber(Object srNumber) {
            this.srNumber = srNumber;
        }

        public String getPickupAddress() {
            return pickupAddress;
        }

        public void setPickupAddress(String pickupAddress) {
            this.pickupAddress = pickupAddress;
        }

        public String getPickupDate() {
            return pickupDate;
        }

        public void setPickupDate(String pickupDate) {
            this.pickupDate = pickupDate;
        }

        public String getDeliveryDate() {
            return deliveryDate;
        }

        public void setDeliveryDate(String deliveryDate) {
            this.deliveryDate = deliveryDate;
        }

        public String getDeliveryType() {
            return deliveryType;
        }

        public void setDeliveryType(String deliveryType) {
            this.deliveryType = deliveryType;
        }

        public Object getParcelPackageType() {
            return parcelPackageType;
        }

        public void setParcelPackageType(Object parcelPackageType) {
            this.parcelPackageType = parcelPackageType;
        }

        public String getInvoiceNumber() {
            return invoiceNumber;
        }

        public void setInvoiceNumber(String invoiceNumber) {
            this.invoiceNumber = invoiceNumber;
        }

        public Object getShopupInvoiceNumber() {
            return shopupInvoiceNumber;
        }

        public void setShopupInvoiceNumber(Object shopupInvoiceNumber) {
            this.shopupInvoiceNumber = shopupInvoiceNumber;
        }

        public Object getShopupInvoiceId() {
            return shopupInvoiceId;
        }

        public void setShopupInvoiceId(Object shopupInvoiceId) {
            this.shopupInvoiceId = shopupInvoiceId;
        }

        public String getCustomerName() {
            return customerName;
        }

        public void setCustomerName(String customerName) {
            this.customerName = customerName;
        }

        public String getCustomerPhone() {
            return customerPhone;
        }

        public void setCustomerPhone(String customerPhone) {
            this.customerPhone = customerPhone;
        }

        public String getDeliveryAddress() {
            return deliveryAddress;
        }

        public void setDeliveryAddress(String deliveryAddress) {
            this.deliveryAddress = deliveryAddress;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public int getAreaId() {
            return areaId;
        }

        public void setAreaId(int areaId) {
            this.areaId = areaId;
        }

        public Object getSourceHubId() {
            return sourceHubId;
        }

        public void setSourceHubId(Object sourceHubId) {
            this.sourceHubId = sourceHubId;
        }

        public Object getDestinationHubId() {
            return destinationHubId;
        }

        public void setDestinationHubId(Object destinationHubId) {
            this.destinationHubId = destinationHubId;
        }

        public String getCountryCode() {
            return countryCode;
        }

        public void setCountryCode(String countryCode) {
            this.countryCode = countryCode;
        }

        public Object getCountry() {
            return country;
        }

        public void setCountry(Object country) {
            this.country = country;
        }

        public String getPostCode() {
            return postCode;
        }

        public void setPostCode(String postCode) {
            this.postCode = postCode;
        }

        public Object getCity() {
            return city;
        }

        public void setCity(Object city) {
            this.city = city;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getPaymentMethod() {
            return paymentMethod;
        }

        public void setPaymentMethod(String paymentMethod) {
            this.paymentMethod = paymentMethod;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public int getCash() {
            return cash;
        }

        public void setCash(int cash) {
            this.cash = cash;
        }

        public Object getPreviousPrice() {
            return previousPrice;
        }

        public void setPreviousPrice(Object previousPrice) {
            this.previousPrice = previousPrice;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public int getLiftingPrice() {
            return liftingPrice;
        }

        public void setLiftingPrice(int liftingPrice) {
            this.liftingPrice = liftingPrice;
        }

        public int getIsCashDeposited() {
            return isCashDeposited;
        }

        public void setIsCashDeposited(int isCashDeposited) {
            this.isCashDeposited = isCashDeposited;
        }

        public int getShopupCharge() {
            return shopupCharge;
        }

        public void setShopupCharge(int shopupCharge) {
            this.shopupCharge = shopupCharge;
        }

        public float getShopupCodCharge() {
            return shopupCodCharge;
        }

        public void setShopupCodCharge(float shopupCodCharge) {
            this.shopupCodCharge = shopupCodCharge;
        }

        public float getSubsidyAmount() {
            return subsidyAmount;
        }

        public void setSubsidyAmount(float subsidyAmount) {
            this.subsidyAmount = subsidyAmount;
        }

        public int getPartnerCodCharge() {
            return partnerCodCharge;
        }

        public void setPartnerCodCharge(int partnerCodCharge) {
            this.partnerCodCharge = partnerCodCharge;
        }

        public int getPartnerReturnCharge() {
            return partnerReturnCharge;
        }

        public void setPartnerReturnCharge(int partnerReturnCharge) {
            this.partnerReturnCharge = partnerReturnCharge;
        }

        public int getShopupReturnCharge() {
            return shopupReturnCharge;
        }

        public void setShopupReturnCharge(int shopupReturnCharge) {
            this.shopupReturnCharge = shopupReturnCharge;
        }

        public int getPaidAmount() {
            return paidAmount;
        }

        public void setPaidAmount(int paidAmount) {
            this.paidAmount = paidAmount;
        }

        public Object getGatewayPaidAmount() {
            return gatewayPaidAmount;
        }

        public void setGatewayPaidAmount(Object gatewayPaidAmount) {
            this.gatewayPaidAmount = gatewayPaidAmount;
        }

        public Object getGatewayMedium() {
            return gatewayMedium;
        }

        public void setGatewayMedium(Object gatewayMedium) {
            this.gatewayMedium = gatewayMedium;
        }

        public int getIsChargePaid() {
            return isChargePaid;
        }

        public void setIsChargePaid(int isChargePaid) {
            this.isChargePaid = isChargePaid;
        }

        public int getIsPartial() {
            return isPartial;
        }

        public void setIsPartial(int isPartial) {
            this.isPartial = isPartial;
        }

        public Object getParentParcelId() {
            return parentParcelId;
        }

        public void setParentParcelId(Object parentParcelId) {
            this.parentParcelId = parentParcelId;
        }

        public String getParcelDeliveryType() {
            return parcelDeliveryType;
        }

        public void setParcelDeliveryType(String parcelDeliveryType) {
            this.parcelDeliveryType = parcelDeliveryType;
        }

        public int getIsProblematic() {
            return isProblematic;
        }

        public void setIsProblematic(int isProblematic) {
            this.isProblematic = isProblematic;
        }

        public int getIsReverseDelivery() {
            return isReverseDelivery;
        }

        public void setIsReverseDelivery(int isReverseDelivery) {
            this.isReverseDelivery = isReverseDelivery;
        }

        public int getNumberOfAttempts() {
            return numberOfAttempts;
        }

        public void setNumberOfAttempts(int numberOfAttempts) {
            this.numberOfAttempts = numberOfAttempts;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getSellerStatus() {
            return sellerStatus;
        }

        public void setSellerStatus(String sellerStatus) {
            this.sellerStatus = sellerStatus;
        }

        public Object getPartnerStatus() {
            return partnerStatus;
        }

        public void setPartnerStatus(Object partnerStatus) {
            this.partnerStatus = partnerStatus;
        }

        public int getPartnerId() {
            return partnerId;
        }

        public void setPartnerId(int partnerId) {
            this.partnerId = partnerId;
        }

        public Object getPartnerTrakingId() {
            return partnerTrakingId;
        }

        public void setPartnerTrakingId(Object partnerTrakingId) {
            this.partnerTrakingId = partnerTrakingId;
        }

        public int getPartnerCharge() {
            return partnerCharge;
        }

        public void setPartnerCharge(int partnerCharge) {
            this.partnerCharge = partnerCharge;
        }

        public String getPartnerName() {
            return partnerName;
        }

        public void setPartnerName(String partnerName) {
            this.partnerName = partnerName;
        }

        public Object getBuyerInstruction() {
            return buyerInstruction;
        }

        public void setBuyerInstruction(Object buyerInstruction) {
            this.buyerInstruction = buyerInstruction;
        }

        public String getSellerInstruction() {
            return sellerInstruction;
        }

        public void setSellerInstruction(String sellerInstruction) {
            this.sellerInstruction = sellerInstruction;
        }

        public Object getShopupNote() {
            return shopupNote;
        }

        public void setShopupNote(Object shopupNote) {
            this.shopupNote = shopupNote;
        }

        public Object getSellerNote() {
            return sellerNote;
        }

        public void setSellerNote(Object sellerNote) {
            this.sellerNote = sellerNote;
        }

        public int getIsDeleted() {
            return isDeleted;
        }

        public void setIsDeleted(int isDeleted) {
            this.isDeleted = isDeleted;
        }

        public int getIsChecked() {
            return isChecked;
        }

        public void setIsChecked(int isChecked) {
            this.isChecked = isChecked;
        }

        public int getIsHidden() {
            return isHidden;
        }

        public void setIsHidden(int isHidden) {
            this.isHidden = isHidden;
        }

        public String getBulkId() {
            return bulkId;
        }

        public void setBulkId(String bulkId) {
            this.bulkId = bulkId;
        }

        public Object getBulkTransferId() {
            return bulkTransferId;
        }

        public void setBulkTransferId(Object bulkTransferId) {
            this.bulkTransferId = bulkTransferId;
        }

        public Object getAgentId() {
            return agentId;
        }

        public void setAgentId(Object agentId) {
            this.agentId = agentId;
        }

        public Object getDeliveryAgentId() {
            return deliveryAgentId;
        }

        public void setDeliveryAgentId(Object deliveryAgentId) {
            this.deliveryAgentId = deliveryAgentId;
        }

        public Object getLogisticsInvoiceId() {
            return logisticsInvoiceId;
        }

        public void setLogisticsInvoiceId(Object logisticsInvoiceId) {
            this.logisticsInvoiceId = logisticsInvoiceId;
        }

        public Object getResellerSettlementId() {
            return resellerSettlementId;
        }

        public void setResellerSettlementId(Object resellerSettlementId) {
            this.resellerSettlementId = resellerSettlementId;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public int getIsSettled() {
            return isSettled;
        }

        public void setIsSettled(int isSettled) {
            this.isSettled = isSettled;
        }

        public int getIsReturned() {
            return isReturned;
        }

        public void setIsReturned(int isReturned) {
            this.isReturned = isReturned;
        }

        public Object getDeliveryReadyTime() {
            return deliveryReadyTime;
        }

        public void setDeliveryReadyTime(Object deliveryReadyTime) {
            this.deliveryReadyTime = deliveryReadyTime;
        }

        public Object getFirstMileReceivedTime() {
            return firstMileReceivedTime;
        }

        public void setFirstMileReceivedTime(Object firstMileReceivedTime) {
            this.firstMileReceivedTime = firstMileReceivedTime;
        }

        public Object getPackageType() {
            return packageType;
        }

        public void setPackageType(Object packageType) {
            this.packageType = packageType;
        }

        public Object getParcelDetailsJson() {
            return parcelDetailsJson;
        }

        public void setParcelDetailsJson(Object parcelDetailsJson) {
            this.parcelDetailsJson = parcelDetailsJson;
        }

        public Object getReturnReason() {
            return returnReason;
        }

        public void setReturnReason(Object returnReason) {
            this.returnReason = returnReason;
        }

        public Object getReturnComment() {
            return returnComment;
        }

        public void setReturnComment(Object returnComment) {
            this.returnComment = returnComment;
        }

        public Object getHoldReason() {
            return holdReason;
        }

        public void setHoldReason(Object holdReason) {
            this.holdReason = holdReason;
        }

        public Object getHoldComment() {
            return holdComment;
        }

        public void setHoldComment(Object holdComment) {
            this.holdComment = holdComment;
        }

        public Object getComment() {
            return comment;
        }

        public void setComment(Object comment) {
            this.comment = comment;
        }

        public int getCompensateAmount() {
            return compensateAmount;
        }

        public void setCompensateAmount(int compensateAmount) {
            this.compensateAmount = compensateAmount;
        }

        public Object getCashUpdateInfo() {
            return cashUpdateInfo;
        }

        public void setCashUpdateInfo(Object cashUpdateInfo) {
            this.cashUpdateInfo = cashUpdateInfo;
        }

        public int getIsExchanged() {
            return isExchanged;
        }

        public void setIsExchanged(int isExchanged) {
            this.isExchanged = isExchanged;
        }

        public Object getExchangeFor() {
            return exchangeFor;
        }

        public void setExchangeFor(Object exchangeFor) {
            this.exchangeFor = exchangeFor;
        }

        public Object getPartialReturnedParcelId() {
            return partialReturnedParcelId;
        }

        public void setPartialReturnedParcelId(Object partialReturnedParcelId) {
            this.partialReturnedParcelId = partialReturnedParcelId;
        }

        public Object getExchangeReturnedParcelId() {
            return exchangeReturnedParcelId;
        }

        public void setExchangeReturnedParcelId(Object exchangeReturnedParcelId) {
            this.exchangeReturnedParcelId = exchangeReturnedParcelId;
        }

        public Object getExchangeDeliveredParcelId() {
            return exchangeDeliveredParcelId;
        }

        public void setExchangeDeliveredParcelId(Object exchangeDeliveredParcelId) {
            this.exchangeDeliveredParcelId = exchangeDeliveredParcelId;
        }

        public Object getPartialDeliveredParcelId() {
            return partialDeliveredParcelId;
        }

        public void setPartialDeliveredParcelId(Object partialDeliveredParcelId) {
            this.partialDeliveredParcelId = partialDeliveredParcelId;
        }

        public int getIsShawnirbhor() {
            return isShawnirbhor;
        }

        public void setIsShawnirbhor(int isShawnirbhor) {
            this.isShawnirbhor = isShawnirbhor;
        }

        public int getIsReseller() {
            return isReseller;
        }

        public void setIsReseller(int isReseller) {
            this.isReseller = isReseller;
        }

        public int getIsHyperLocal() {
            return isHyperLocal;
        }

        public void setIsHyperLocal(int isHyperLocal) {
            this.isHyperLocal = isHyperLocal;
        }

        public Object getDeliveryOtp() {
            return deliveryOtp;
        }

        public void setDeliveryOtp(Object deliveryOtp) {
            this.deliveryOtp = deliveryOtp;
        }

        public int getIsDeliveryOtpVerified() {
            return isDeliveryOtpVerified;
        }

        public void setIsDeliveryOtpVerified(int isDeliveryOtpVerified) {
            this.isDeliveryOtpVerified = isDeliveryOtpVerified;
        }

        public int getMerchantDeliveryCharge() {
            return merchantDeliveryCharge;
        }

        public void setMerchantDeliveryCharge(int merchantDeliveryCharge) {
            this.merchantDeliveryCharge = merchantDeliveryCharge;
        }

        public int getIsIssueRaised() {
            return isIssueRaised;
        }

        public void setIsIssueRaised(int isIssueRaised) {
            this.isIssueRaised = isIssueRaised;
        }

        public Object getCurrentIssueId() {
            return currentIssueId;
        }

        public void setCurrentIssueId(Object currentIssueId) {
            this.currentIssueId = currentIssueId;
        }

        public Object getReturnOtp() {
            return returnOtp;
        }

        public void setReturnOtp(Object returnOtp) {
            this.returnOtp = returnOtp;
        }

        public int getIsReturnOtpVerified() {
            return isReturnOtpVerified;
        }

        public void setIsReturnOtpVerified(int isReturnOtpVerified) {
            this.isReturnOtpVerified = isReturnOtpVerified;
        }

        public Object getLineHaulId() {
            return lineHaulId;
        }

        public void setLineHaulId(Object lineHaulId) {
            this.lineHaulId = lineHaulId;
        }

        public int getIsReconcile() {
            return isReconcile;
        }

        public void setIsReconcile(int isReconcile) {
            this.isReconcile = isReconcile;
        }

        public int getIsReconcilable() {
            return isReconcilable;
        }

        public void setIsReconcilable(int isReconcilable) {
            this.isReconcilable = isReconcilable;
        }

        public int getPickupAreaId() {
            return pickupAreaId;
        }

        public void setPickupAreaId(int pickupAreaId) {
            this.pickupAreaId = pickupAreaId;
        }

        public Object getProcessIdentifier() {
            return processIdentifier;
        }

        public void setProcessIdentifier(Object processIdentifier) {
            this.processIdentifier = processIdentifier;
        }

        public String getTrackingId() {
            return trackingId;
        }

        public void setTrackingId(String trackingId) {
            this.trackingId = trackingId;
        }

        public String getParcelType() {
            return parcelType;
        }

        public void setParcelType(String parcelType) {
            this.parcelType = parcelType;
        }

        public Object getParentParcelTrackingId() {
            return parentParcelTrackingId;
        }

        public void setParentParcelTrackingId(Object parentParcelTrackingId) {
            this.parentParcelTrackingId = parentParcelTrackingId;
        }

        public int getPickupStoreId() {
            return pickupStoreId;
        }

        public void setPickupStoreId(int pickupStoreId) {
            this.pickupStoreId = pickupStoreId;
        }

        public String getSellerPhone() {
            return sellerPhone;
        }

        public void setSellerPhone(String sellerPhone) {
            this.sellerPhone = sellerPhone;
        }

        public int getIsResellerShop() {
            return isResellerShop;
        }

        public void setIsResellerShop(int isResellerShop) {
            this.isResellerShop = isResellerShop;
        }

        public String getShopCreatedAt() {
            return shopCreatedAt;
        }

        public void setShopCreatedAt(String shopCreatedAt) {
            this.shopCreatedAt = shopCreatedAt;
        }

        public Object getResellerId() {
            return resellerId;
        }

        public void setResellerId(Object resellerId) {
            this.resellerId = resellerId;
        }

        public int getHubId() {
            return hubId;
        }

        public void setHubId(int hubId) {
            this.hubId = hubId;
        }

        public String getHubName() {
            return hubName;
        }

        public void setHubName(String hubName) {
            this.hubName = hubName;
        }

        public Object getShopPickupArea() {
            return shopPickupArea;
        }

        public void setShopPickupArea(Object shopPickupArea) {
            this.shopPickupArea = shopPickupArea;
        }

        public String getShopPickupAddress() {
            return shopPickupAddress;
        }

        public void setShopPickupAddress(String shopPickupAddress) {
            this.shopPickupAddress = shopPickupAddress;
        }

        public Object getDeliveryAgentName() {
            return deliveryAgentName;
        }

        public void setDeliveryAgentName(Object deliveryAgentName) {
            this.deliveryAgentName = deliveryAgentName;
        }

        public int getParcel_id() {
            return parcel_id;
        }

        public void setParcel_id(int parcel_id) {
            this.parcel_id = parcel_id;
        }
    }
}