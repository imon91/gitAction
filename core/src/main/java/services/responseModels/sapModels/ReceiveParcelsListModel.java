package services.responseModels.sapModels;

import java.io.Serializable;
import java.util.List;

public class ReceiveParcelsListModel {

    /**
     * error : false
     * count : 2
     * totalAmount : 120
     * parcels : [{"id":"21A310WE3K83V","shopId":648377,"shopName":"Bulk Parcel Status Update Test Shop","shopPhone":"8801401122188","adminNumber":null,"srNumber":null,"pickupAddress":"Address, Area, Code","pickupDate":"2021-03-11T05:30:00.000Z","deliveryDate":"2021-03-12T10:30:00.000Z","deliveryType":"regular","parcelPackageType":null,"invoiceNumber":"199171","shopupInvoiceNumber":null,"shopupInvoiceId":null,"customerName":"John Doe","customerPhone":"8801873445555","deliveryAddress":"50 Lake Circus (7th floor) Kalabagan","area":"Tejgaon","areaId":98,"sourceHubId":null,"destinationHubId":null,"paymentMethod":"cash on delivery","weight":500,"previousPrice":null,"value":"0","liftingPrice":0,"isCashDeposited":0,"paidAmount":0,"gatewayPaidAmount":null,"gatewayMedium":null,"isChargePaid":0,"isPartial":0,"parentParcelId":null,"parcelDeliveryType":"regular","isProblematic":0,"isReverseDelivery":0,"numberOfAttempts":0,"status":"pickup-pending","sellerStatus":"pickup-pending","partnerId":3,"partnerName":"ShopUp","buyerInstruction":null,"sellerInstruction":"Give cash amount zero if payment already done","shopupNote":null,"bulkId":"km3ah63p","bulkTransferId":null,"deliveryAgentId":null,"logisticsInvoiceId":null,"createdAt":"2021-03-10T10:18:11.000Z","updatedAt":"2021-03-10T10:18:11.000Z","isSettled":0,"isReturned":0,"firstMileReceivedTime":null,"packageType":null,"parcelDetailsJson":null,"returnReason":null,"returnComment":null,"holdReason":null,"holdComment":null,"comment":null,"compensateAmount":0,"cashUpdateInfo":null,"isExchanged":0,"exchangeFor":null,"partialReturnedParcelId":null,"exchangeReturnedParcelId":null,"exchangeDeliveredParcelId":null,"partialDeliveredParcelId":null,"isReseller":0,"isHyperLocal":0,"deliveryOtp":null,"isDeliveryOtpVerified":0,"merchantDeliveryCharge":0,"isIssueRaised":0,"currentIssueId":null,"returnOtp":null,"isReturnOtpVerified":0,"lineHaulId":null,"isReconcile":0,"isReconcilable":0,"pickupAreaId":2,"shopStoreId":64370,"cash":0,"shopupCharge":60,"shopupCodCharge":0,"shopupReturnCharge":0,"sellerPhone":"8801401122188","isResellerShop":0,"shopCreatedAt":"2021-03-10T06:50:04.000Z","otpEnabled":1,"merchantSmsEnabled":1,"customerSmsEnabled":1,"resellerId":null,"shopArea":"Dhanmondi","shopAreaId":2,"shopZone":"Dhaka City","shopZoneId":1,"hubId":2,"hubName":"Mohakhali Hub","shopPickupArea":"Dhanmondi","shopPickupAddress":"Address, Area, Code","deliveryAgentName":null,"lineHaulName":null,"parcelCategories":null,"merchantType":"b2c","deliveryZoneName":"ISD","zone":"ISD","routeName":"ISD","operationalDeliveryArea":0,"parcel_id":5982475},{"id":"21A310WE3K83U","shopId":648377,"shopName":"Bulk Parcel Status Update Test Shop","shopPhone":"8801401122188","adminNumber":null,"srNumber":null,"pickupAddress":"Address, Area, Code","pickupDate":"2021-03-11T05:30:00.000Z","deliveryDate":"2021-03-12T10:30:00.000Z","deliveryType":"regular","parcelPackageType":null,"invoiceNumber":"199170","shopupInvoiceNumber":null,"shopupInvoiceId":null,"customerName":"Jane Doe","customerPhone":"8801873445555","deliveryAddress":"House name (Apt number), Road number","area":"Tejgaon","areaId":98,"sourceHubId":null,"destinationHubId":null,"paymentMethod":"cash on delivery","weight":500,"previousPrice":null,"value":"0","liftingPrice":0,"isCashDeposited":0,"paidAmount":0,"gatewayPaidAmount":null,"gatewayMedium":null,"isChargePaid":0,"isPartial":0,"parentParcelId":null,"parcelDeliveryType":"regular","isProblematic":0,"isReverseDelivery":0,"numberOfAttempts":0,"status":"pickup-pending","sellerStatus":"pickup-pending","partnerId":3,"partnerName":"ShopUp","buyerInstruction":null,"sellerInstruction":"Comment regarding delivery","shopupNote":null,"bulkId":"km3ah63p","bulkTransferId":null,"deliveryAgentId":null,"logisticsInvoiceId":null,"createdAt":"2021-03-10T10:18:10.000Z","updatedAt":"2021-03-10T10:18:10.000Z","isSettled":0,"isReturned":0,"firstMileReceivedTime":null,"packageType":null,"parcelDetailsJson":null,"returnReason":null,"returnComment":null,"holdReason":null,"holdComment":null,"comment":null,"compensateAmount":0,"cashUpdateInfo":null,"isExchanged":0,"exchangeFor":null,"partialReturnedParcelId":null,"exchangeReturnedParcelId":null,"exchangeDeliveredParcelId":null,"partialDeliveredParcelId":null,"isReseller":0,"isHyperLocal":0,"deliveryOtp":null,"isDeliveryOtpVerified":0,"merchantDeliveryCharge":0,"isIssueRaised":0,"currentIssueId":null,"returnOtp":null,"isReturnOtpVerified":0,"lineHaulId":null,"isReconcile":0,"isReconcilable":0,"pickupAreaId":2,"shopStoreId":64370,"cash":120,"shopupCharge":60,"shopupCodCharge":0,"shopupReturnCharge":0,"sellerPhone":"8801401122188","isResellerShop":0,"shopCreatedAt":"2021-03-10T06:50:04.000Z","otpEnabled":1,"merchantSmsEnabled":1,"customerSmsEnabled":1,"resellerId":null,"shopArea":"Dhanmondi","shopAreaId":2,"shopZone":"Dhaka City","shopZoneId":1,"hubId":2,"hubName":"Mohakhali Hub","shopPickupArea":"Dhanmondi","shopPickupAddress":"Address, Area, Code","deliveryAgentName":null,"lineHaulName":null,"parcelCategories":null,"merchantType":"b2c","deliveryZoneName":"ISD","zone":"ISD","routeName":"ISD","operationalDeliveryArea":0,"parcel_id":5982474}]
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
         * id : 21A310WE3K83V
         * shopId : 648377
         * shopName : Bulk Parcel Status Update Test Shop
         * shopPhone : 8801401122188
         * adminNumber : null
         * srNumber : null
         * pickupAddress : Address, Area, Code
         * pickupDate : 2021-03-11T05:30:00.000Z
         * deliveryDate : 2021-03-12T10:30:00.000Z
         * deliveryType : regular
         * parcelPackageType : null
         * invoiceNumber : 199171
         * shopupInvoiceNumber : null
         * shopupInvoiceId : null
         * customerName : John Doe
         * customerPhone : 8801873445555
         * deliveryAddress : 50 Lake Circus (7th floor) Kalabagan
         * area : Tejgaon
         * areaId : 98
         * sourceHubId : null
         * destinationHubId : null
         * paymentMethod : cash on delivery
         * weight : 500
         * previousPrice : null
         * value : 0
         * liftingPrice : 0
         * isCashDeposited : 0
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
         * partnerId : 3
         * partnerName : ShopUp
         * buyerInstruction : null
         * sellerInstruction : Give cash amount zero if payment already done
         * shopupNote : null
         * bulkId : km3ah63p
         * bulkTransferId : null
         * deliveryAgentId : null
         * logisticsInvoiceId : null
         * createdAt : 2021-03-10T10:18:11.000Z
         * updatedAt : 2021-03-10T10:18:11.000Z
         * isSettled : 0
         * isReturned : 0
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
         * pickupAreaId : 2
         * shopStoreId : 64370
         * cash : 0
         * shopupCharge : 60
         * shopupCodCharge : 0
         * shopupReturnCharge : 0
         * sellerPhone : 8801401122188
         * isResellerShop : 0
         * shopCreatedAt : 2021-03-10T06:50:04.000Z
         * otpEnabled : 1
         * merchantSmsEnabled : 1
         * customerSmsEnabled : 1
         * resellerId : null
         * shopArea : Dhanmondi
         * shopAreaId : 2
         * shopZone : Dhaka City
         * shopZoneId : 1
         * hubId : 2
         * hubName : Mohakhali Hub
         * shopPickupArea : Dhanmondi
         * shopPickupAddress : Address, Area, Code
         * deliveryAgentName : null
         * lineHaulName : null
         * parcelCategories : null
         * merchantType : b2c
         * deliveryZoneName : ISD
         * zone : ISD
         * routeName : ISD
         * operationalDeliveryArea : 0
         * parcel_id : 5982475
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
        private String paymentMethod;
        private int weight;
        private Object previousPrice;
        private String value;
        private int liftingPrice;
        private int isCashDeposited;
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
        private int partnerId;
        private String partnerName;
        private Object buyerInstruction;
        private String sellerInstruction;
        private Object shopupNote;
        private String bulkId;
        private Object bulkTransferId;
        private Object deliveryAgentId;
        private Object logisticsInvoiceId;
        private String createdAt;
        private String updatedAt;
        private int isSettled;
        private int isReturned;
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
        private int shopStoreId;
        private int cash;
        private int shopupCharge;
        private int shopupCodCharge;
        private int shopupReturnCharge;
        private String sellerPhone;
        private int isResellerShop;
        private String shopCreatedAt;
        private int otpEnabled;
        private int merchantSmsEnabled;
        private int customerSmsEnabled;
        private Object resellerId;
        private String shopArea;
        private int shopAreaId;
        private String shopZone;
        private int shopZoneId;
        private int hubId;
        private String hubName;
        private String shopPickupArea;
        private String shopPickupAddress;
        private Object deliveryAgentName;
        private Object lineHaulName;
        private Object parcelCategories;
        private String merchantType;
        private String deliveryZoneName;
        private String zone;
        private String routeName;
        private int operationalDeliveryArea;
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

        public int getPartnerId() {
            return partnerId;
        }

        public void setPartnerId(int partnerId) {
            this.partnerId = partnerId;
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

        public int getShopStoreId() {
            return shopStoreId;
        }

        public void setShopStoreId(int shopStoreId) {
            this.shopStoreId = shopStoreId;
        }

        public int getCash() {
            return cash;
        }

        public void setCash(int cash) {
            this.cash = cash;
        }

        public int getShopupCharge() {
            return shopupCharge;
        }

        public void setShopupCharge(int shopupCharge) {
            this.shopupCharge = shopupCharge;
        }

        public int getShopupCodCharge() {
            return shopupCodCharge;
        }

        public void setShopupCodCharge(int shopupCodCharge) {
            this.shopupCodCharge = shopupCodCharge;
        }

        public int getShopupReturnCharge() {
            return shopupReturnCharge;
        }

        public void setShopupReturnCharge(int shopupReturnCharge) {
            this.shopupReturnCharge = shopupReturnCharge;
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

        public int getOtpEnabled() {
            return otpEnabled;
        }

        public void setOtpEnabled(int otpEnabled) {
            this.otpEnabled = otpEnabled;
        }

        public int getMerchantSmsEnabled() {
            return merchantSmsEnabled;
        }

        public void setMerchantSmsEnabled(int merchantSmsEnabled) {
            this.merchantSmsEnabled = merchantSmsEnabled;
        }

        public int getCustomerSmsEnabled() {
            return customerSmsEnabled;
        }

        public void setCustomerSmsEnabled(int customerSmsEnabled) {
            this.customerSmsEnabled = customerSmsEnabled;
        }

        public Object getResellerId() {
            return resellerId;
        }

        public void setResellerId(Object resellerId) {
            this.resellerId = resellerId;
        }

        public String getShopArea() {
            return shopArea;
        }

        public void setShopArea(String shopArea) {
            this.shopArea = shopArea;
        }

        public int getShopAreaId() {
            return shopAreaId;
        }

        public void setShopAreaId(int shopAreaId) {
            this.shopAreaId = shopAreaId;
        }

        public String getShopZone() {
            return shopZone;
        }

        public void setShopZone(String shopZone) {
            this.shopZone = shopZone;
        }

        public int getShopZoneId() {
            return shopZoneId;
        }

        public void setShopZoneId(int shopZoneId) {
            this.shopZoneId = shopZoneId;
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

        public String getShopPickupArea() {
            return shopPickupArea;
        }

        public void setShopPickupArea(String shopPickupArea) {
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

        public Object getLineHaulName() {
            return lineHaulName;
        }

        public void setLineHaulName(Object lineHaulName) {
            this.lineHaulName = lineHaulName;
        }

        public Object getParcelCategories() {
            return parcelCategories;
        }

        public void setParcelCategories(Object parcelCategories) {
            this.parcelCategories = parcelCategories;
        }

        public String getMerchantType() {
            return merchantType;
        }

        public void setMerchantType(String merchantType) {
            this.merchantType = merchantType;
        }

        public String getDeliveryZoneName() {
            return deliveryZoneName;
        }

        public void setDeliveryZoneName(String deliveryZoneName) {
            this.deliveryZoneName = deliveryZoneName;
        }

        public String getZone() {
            return zone;
        }

        public void setZone(String zone) {
            this.zone = zone;
        }

        public String getRouteName() {
            return routeName;
        }

        public void setRouteName(String routeName) {
            this.routeName = routeName;
        }

        public int getOperationalDeliveryArea() {
            return operationalDeliveryArea;
        }

        public void setOperationalDeliveryArea(int operationalDeliveryArea) {
            this.operationalDeliveryArea = operationalDeliveryArea;
        }

        public int getParcel_id() {
            return parcel_id;
        }

        public void setParcel_id(int parcel_id) {
            this.parcel_id = parcel_id;
        }
    }
}
