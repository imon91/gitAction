package services.responseModels.sapModels;

import java.io.Serializable;
import java.util.List;

public class AgentControlListModel {

    /**
     * error : false
     * agents : [{"id":3681,"userId":907134,"name":"Return/pickup agent","hubId":1,"hubName":"Kalabagan Hub","isActive":1,"agentType":"pickup","vehicleType":"bike","basicSalary":0,"isCountCommissionApplicable":1,"isRangeCommissionApplicable":0,"phoneNumber":"8801842640174","shopId":11509,"shopName":"AJ Collection","employeeId":9103681,"agentPhoto":null,"dateOfBirth":"1991-06-05T18:00:00.000Z","bikeRegistrationNumber":null,"email":null,"bkashNumber":"01842640174","nid":"2397058427","nidPhoto":null,"birthCertificateNo":null,"permanentAddress":"kakradah dharabarish","presentAddress":"nobinagar houssing m","guarantorName":"ramjan ali","guarantorNid":"6914140029394","guarantorNidPhoto":null,"guarantorRelation":"father","assignedShops":[{"id":11509,"name":"AJ Collection"}]},{"id":3652,"userId":903095,"name":"Md Nazmoul Haque  PA","hubId":1,"hubName":"Kalabagan Hub","isActive":1,"agentType":"pickup","vehicleType":"bicycle","basicSalary":0,"isCountCommissionApplicable":1,"isRangeCommissionApplicable":0,"phoneNumber":"8801781036703","shopId":16247,"shopName":"My Little Shop","employeeId":9103652,"agentPhoto":null,"dateOfBirth":"1996-12-30T18:00:00.000Z","bikeRegistrationNumber":null,"email":null,"bkashNumber":"01781036703","nid":"3282620164","nidPhoto":null,"birthCertificateNo":null,"permanentAddress":"barerbari dhunot  ba","presentAddress":"adabor ring road sho","guarantorName":"md shadat hossan","guarantorNid":"19741012795000007","guarantorNidPhoto":null,"guarantorRelation":"father","assignedShops":[{"id":16247,"name":"My Little Shop"}]},{"id":2428,"userId":836128,"name":"Exchange agent","hubId":1,"hubName":"Kalabagan Hub","isActive":1,"agentType":"delivery","vehicleType":"bike","basicSalary":11000,"isCountCommissionApplicable":1,"isRangeCommissionApplicable":0,"phoneNumber":"8801670110429","shopId":13702,"shopName":"premiumbuy.com.bd","employeeId":9102428,"agentPhoto":null,"dateOfBirth":"1992-12-26T00:00:00.000Z","bikeRegistrationNumber":null,"email":null,"bkashNumber":"01670110429","nid":"7758496447","nidPhoto":null,"birthCertificateNo":null,"permanentAddress":"382, jemeva camp,  M","presentAddress":"382, jemeva camp,  M","guarantorName":"Ezaz ahmed raj","guarantorNid":"8705199407","guarantorNidPhoto":null,"guarantorRelation":"Brother","assignedShops":[{"id":13702,"name":"premiumbuy.com.bd"},{"id":5474,"name":"Shahin  Bag Collection"}]},{"id":3569,"userId":288365,"name":"Partial agent","hubId":1,"hubName":"Kalabagan Hub","isActive":1,"agentType":"delivery","vehicleType":"bike","basicSalary":0,"isCountCommissionApplicable":1,"isRangeCommissionApplicable":0,"phoneNumber":"8801776906402","shopId":10039,"shopName":"শারদী sharodi","employeeId":9103569,"agentPhoto":null,"dateOfBirth":"1997-03-25T18:00:00.000Z","bikeRegistrationNumber":null,"email":null,"bkashNumber":"01629063350","nid":"4652810609","nidPhoto":null,"birthCertificateNo":null,"permanentAddress":"gobindopur nilphamar","presentAddress":"shamoly road no 2  h","guarantorName":"md mozammel hossain","guarantorNid":"9125679838","guarantorNidPhoto":null,"guarantorRelation":"father","assignedShops":[{"id":10039,"name":"শারদী sharodi"}]},{"id":3663,"userId":906864,"name":"Exchange Agent-2","hubId":1,"hubName":"Kalabagan Hub","isActive":1,"agentType":"delivery","vehicleType":"bike","basicSalary":0,"isCountCommissionApplicable":1,"isRangeCommissionApplicable":0,"phoneNumber":"8801648163364","shopId":103515,"shopName":"WoW Mall","employeeId":9103663,"agentPhoto":null,"dateOfBirth":"1986-07-14T18:00:00.000Z","bikeRegistrationNumber":null,"email":null,"bkashNumber":"01789378814","nid":"2691651201193","nidPhoto":null,"birthCertificateNo":null,"permanentAddress":"kachuahat, khamardho","presentAddress":"bagun bari tejgaon","guarantorName":"Md Ruhul Islam","guarantorNid":"3218885086201","guarantorNidPhoto":null,"guarantorRelation":"father","assignedShops":[{"id":103515,"name":"WoW Mall"}]},{"id":3640,"userId":905597,"name":"CashReceived to Unblock agent","hubId":1,"hubName":"Kalabagan Hub","isActive":1,"agentType":"delivery","vehicleType":"bike","basicSalary":0,"isCountCommissionApplicable":1,"isRangeCommissionApplicable":0,"phoneNumber":"8801761206013","shopId":114866,"shopName":"Crystal Gallery","employeeId":9103640,"agentPhoto":null,"dateOfBirth":"1991-01-31T18:00:00.000Z","bikeRegistrationNumber":null,"email":null,"bkashNumber":"01761206013","nid":"5514922748","nidPhoto":null,"birthCertificateNo":null,"permanentAddress":"sherir chala mahona ","presentAddress":"sukrabad  katcha baz","guarantorName":"md faruq","guarantorNid":"5065751397","guarantorNidPhoto":null,"guarantorRelation":"father","assignedShops":[{"id":114866,"name":"Crystal Gallery"},{"id":132368,"name":"Happy Shopping Store"},{"id":530787,"name":"Bd gadget Store"}]},{"id":3500,"userId":392346,"name":"Monir hossain PA","hubId":1,"hubName":"Kalabagan Hub","isActive":1,"agentType":"pickup","vehicleType":"bicycle","basicSalary":0,"isCountCommissionApplicable":1,"isRangeCommissionApplicable":0,"phoneNumber":"8801866782957","shopId":17112,"shopName":"Bag & lifestyle","employeeId":9103500,"agentPhoto":null,"dateOfBirth":"1995-12-16T18:00:00.000Z","bikeRegistrationNumber":null,"email":null,"bkashNumber":"01866782957","nid":"2857813741","nidPhoto":null,"birthCertificateNo":null,"permanentAddress":"munshir char madarip","presentAddress":"chand uddan mohammad","guarantorName":"nazma khatun","guarantorNid":"2832389858","guarantorNidPhoto":null,"guarantorRelation":"mother","assignedShops":[{"id":17112,"name":"Bag & lifestyle"},{"id":14899,"name":"Moushum Boutique & Collection"}]},{"id":3416,"userId":898995,"name":"Farid Mia PA","hubId":1,"hubName":"Kalabagan Hub","isActive":1,"agentType":"pickup","vehicleType":"bicycle","basicSalary":0,"isCountCommissionApplicable":1,"isRangeCommissionApplicable":0,"phoneNumber":"8801641991866","shopId":191610,"shopName":"Anha Exclusive","employeeId":9103416,"agentPhoto":null,"dateOfBirth":"1996-04-02T18:00:00.000Z","bikeRegistrationNumber":null,"email":null,"bkashNumber":"01821322459","nid":"1909915942","nidPhoto":null,"birthCertificateNo":null,"permanentAddress":"atsottipara, pirgach","presentAddress":"106, East Razabazer","guarantorName":"MD ilias Ali","guarantorNid":"8241421421","guarantorNidPhoto":null,"guarantorRelation":"Father","assignedShops":[{"id":191610,"name":"Anha Exclusive"},{"id":6538,"name":"Femalo-ফিমেলো"}]},{"id":3674,"userId":906985,"name":"Agent from RedX","hubId":1,"hubName":"Kalabagan Hub","isActive":1,"agentType":"pickup","vehicleType":"bike","basicSalary":0,"isCountCommissionApplicable":1,"isRangeCommissionApplicable":0,"phoneNumber":"8801893595085","shopId":10419,"shopName":"Hidden Beauty Gallery","employeeId":9103674,"agentPhoto":null,"dateOfBirth":"1998-12-05T18:00:00.000Z","bikeRegistrationNumber":null,"email":null,"bkashNumber":"01893595085","nid":"7810903869","nidPhoto":null,"birthCertificateNo":null,"permanentAddress":"hatgopalpur jhenidah","presentAddress":"kallyanpur house 51/","guarantorName":"lipi khatun","guarantorNid":"4197116645","guarantorNidPhoto":null,"guarantorRelation":"mother","assignedShops":[{"id":10419,"name":"Hidden Beauty Gallery"}]},{"id":3127,"userId":879977,"name":"Nadim Uddin Rimon PA","hubId":1,"hubName":"Kalabagan Hub","isActive":1,"agentType":"pickup","vehicleType":"bicycle","basicSalary":0,"isCountCommissionApplicable":1,"isRangeCommissionApplicable":0,"phoneNumber":"8801997625368","shopId":35193,"shopName":"Dhaka NewMarket","employeeId":9103127,"agentPhoto":null,"dateOfBirth":"1999-12-31T18:00:00.000Z","bikeRegistrationNumber":null,"email":null,"bkashNumber":"01997625368","nid":null,"nidPhoto":null,"birthCertificateNo":null,"permanentAddress":"tajmohol  road block","presentAddress":"tajmohol  road block","guarantorName":"nazma khatun","guarantorNid":"7339612942","guarantorNidPhoto":null,"guarantorRelation":"mother","assignedShops":[{"id":35193,"name":"Dhaka NewMarket"}]},{"id":2702,"userId":845394,"name":"Jony PA","hubId":1,"hubName":"Kalabagan Hub","isActive":1,"agentType":"pickup","vehicleType":"bicycle","basicSalary":0,"isCountCommissionApplicable":1,"isRangeCommissionApplicable":0,"phoneNumber":"8801913503579","shopId":222104,"shopName":"monforing","employeeId":9102702,"agentPhoto":null,"dateOfBirth":"1995-04-03T18:00:00.000Z","bikeRegistrationNumber":null,"email":null,"bkashNumber":"01913503579","nid":null,"nidPhoto":null,"birthCertificateNo":null,"permanentAddress":"3/2A shoidnagar 4 no","presentAddress":"3/2A shoidnagar 4 no","guarantorName":null,"guarantorNid":null,"guarantorNidPhoto":null,"guarantorRelation":null,"assignedShops":[{"id":222104,"name":"monforing"}]},{"id":3517,"userId":902355,"name":"agent abdul","hubId":1,"hubName":"Kalabagan Hub","isActive":1,"agentType":"delivery","vehicleType":"bike","basicSalary":0,"isCountCommissionApplicable":1,"isRangeCommissionApplicable":0,"phoneNumber":"8801932437651","shopId":9374,"shopName":"GEM Fashion","employeeId":9103517,"agentPhoto":null,"dateOfBirth":"2001-03-31T18:00:00.000Z","bikeRegistrationNumber":null,"email":null,"bkashNumber":"01936569994","nid":"20013090642175356","nidPhoto":null,"birthCertificateNo":null,"permanentAddress":"humaiyan road mohamm","presentAddress":"humaiyan road mohamm","guarantorName":"md shamim","guarantorNid":"5100295657","guarantorNidPhoto":null,"guarantorRelation":"father","assignedShops":[{"id":9374,"name":"GEM Fashion"}]},{"id":3556,"userId":903385,"name":"Masud Ahmed PA","hubId":1,"hubName":"Kalabagan Hub","isActive":1,"agentType":"pickup","vehicleType":"bicycle","basicSalary":0,"isCountCommissionApplicable":1,"isRangeCommissionApplicable":0,"phoneNumber":"8801620892755","shopId":111336,"shopName":"Crystalline","employeeId":9103556,"agentPhoto":null,"dateOfBirth":"1996-03-22T18:00:00.000Z","bikeRegistrationNumber":null,"email":null,"bkashNumber":"01753998271","nid":"19966118831000111","nidPhoto":null,"birthCertificateNo":null,"permanentAddress":"badrakanda tarakanga","presentAddress":"73/b bou bazar hazar","guarantorName":"marzina khatun","guarantorNid":"1968611813000003","guarantorNidPhoto":null,"guarantorRelation":"mother","assignedShops":[{"id":111336,"name":"Crystalline"}]},{"id":2477,"userId":837002,"name":"Saddam Khan PA","hubId":1,"hubName":"Kalabagan Hub","isActive":1,"agentType":"pickup","vehicleType":"bicycle","basicSalary":11000,"isCountCommissionApplicable":1,"isRangeCommissionApplicable":0,"phoneNumber":"8801967995799","shopId":227412,"shopName":"Imported Ladies Item","employeeId":9102477,"agentPhoto":null,"dateOfBirth":null,"bikeRegistrationNumber":null,"email":null,"bkashNumber":null,"nid":null,"nidPhoto":null,"birthCertificateNo":null,"permanentAddress":null,"presentAddress":null,"guarantorName":null,"guarantorNid":null,"guarantorNidPhoto":null,"guarantorRelation":null,"assignedShops":[{"id":227412,"name":"Imported Ladies Item"}]},{"id":2743,"userId":848457,"name":"Rana Gazi PA","hubId":1,"hubName":"Kalabagan Hub","isActive":1,"agentType":"pickup","vehicleType":"bicycle","basicSalary":0,"isCountCommissionApplicable":1,"isRangeCommissionApplicable":0,"phoneNumber":"8801600295580","shopId":250430,"shopName":"Adorable","employeeId":9102743,"agentPhoto":null,"dateOfBirth":"2017-08-26T18:00:00.000Z","bikeRegistrationNumber":null,"email":null,"bkashNumber":"01789377773","nid":null,"nidPhoto":null,"birthCertificateNo":null,"permanentAddress":null,"presentAddress":"bijli moholla 1/30 h","guarantorName":null,"guarantorNid":null,"guarantorNidPhoto":null,"guarantorRelation":null,"assignedShops":[{"id":250430,"name":"Adorable"},{"id":45485,"name":"Lucky Star - You're Beautiful"}]},{"id":3653,"userId":905812,"name":"Sakibul Islam Shourov PA","hubId":1,"hubName":"Kalabagan Hub","isActive":1,"agentType":"pickup","vehicleType":"bicycle","basicSalary":0,"isCountCommissionApplicable":1,"isRangeCommissionApplicable":0,"phoneNumber":"8801760431805","shopId":252870,"shopName":"Fairytale","employeeId":9103653,"agentPhoto":null,"dateOfBirth":"1996-12-30T18:00:00.000Z","bikeRegistrationNumber":null,"email":null,"bkashNumber":"01760431805","nid":"1024655928","nidPhoto":null,"birthCertificateNo":null,"permanentAddress":"nizgram bagbari gabt","presentAddress":"adabor ring road hou","guarantorName":"md shajan ali","guarantorNid":"19621014067001701","guarantorNidPhoto":null,"guarantorRelation":"father","assignedShops":[{"id":252870,"name":"Fairytale"},{"id":100176,"name":"Sharee bilash"}]},{"id":1147,"userId":562705,"name":"Rofiqul islam","hubId":1,"hubName":"Kalabagan Hub","isActive":1,"agentType":"delivery","vehicleType":"bike","basicSalary":5000,"isCountCommissionApplicable":1,"isRangeCommissionApplicable":0,"phoneNumber":"8801307958456","shopId":439794,"shopName":"Gifts & Glam","employeeId":9101147,"agentPhoto":null,"dateOfBirth":"1970-01-01T00:00:00.000Z","bikeRegistrationNumber":null,"email":null,"bkashNumber":null,"nid":null,"nidPhoto":null,"birthCertificateNo":null,"permanentAddress":null,"presentAddress":null,"guarantorName":null,"guarantorNid":null,"guarantorNidPhoto":null,"guarantorRelation":null,"assignedShops":[{"id":439794,"name":"Gifts & Glam"}]},{"id":3117,"userId":878858,"name":"Sarfaraj Fahim PA","hubId":1,"hubName":"Kalabagan Hub","isActive":1,"agentType":"pickup","vehicleType":"bicycle","basicSalary":0,"isCountCommissionApplicable":1,"isRangeCommissionApplicable":0,"phoneNumber":"8801932727178","shopId":453061,"shopName":"Ubique Choice","employeeId":9103117,"agentPhoto":null,"dateOfBirth":"2000-06-24T18:00:00.000Z","bikeRegistrationNumber":null,"email":null,"bkashNumber":"01932727178","nid":"5561399816","nidPhoto":null,"birthCertificateNo":null,"permanentAddress":"house no 182 gojnobi","presentAddress":"house no 182 gojnobi","guarantorName":"md mukter","guarantorNid":"1934081629","guarantorNidPhoto":null,"guarantorRelation":"father","assignedShops":[{"id":453061,"name":"Ubique Choice"}]},{"id":1266,"userId":807132,"name":"Faysal Ahmed...PA","hubId":1,"hubName":"Kalabagan Hub","isActive":1,"agentType":"pickup","vehicleType":"bike","basicSalary":0,"isCountCommissionApplicable":1,"isRangeCommissionApplicable":0,"phoneNumber":"8801760043984","shopId":439158,"shopName":"MoreGirly","employeeId":9101266,"agentPhoto":"https://d118vismjsp9sl.cloudfront.net/agent/documents/1595155746169-1e5bc2d4367aa314e87ca774dbde08be.jpg","dateOfBirth":"1994-12-30T00:00:00.000Z","bikeRegistrationNumber":null,"email":null,"bkashNumber":"01637555684","nid":"4619777230","nidPhoto":null,"birthCertificateNo":null,"permanentAddress":"District:pirojpur, T","presentAddress":"16/17tajmohol road, ","guarantorName":"Jahanara begum","guarantorNid":"19762699040708818","guarantorNidPhoto":null,"guarantorRelation":"Mother","assignedShops":[{"id":439158,"name":"MoreGirly"}]},{"id":3457,"userId":900482,"name":"Shariful Islam PA","hubId":1,"hubName":"Kalabagan Hub","isActive":1,"agentType":"pickup","vehicleType":"bicycle","basicSalary":0,"isCountCommissionApplicable":1,"isRangeCommissionApplicable":0,"phoneNumber":"8801993478651","shopId":469672,"shopName":"Britto","employeeId":9103457,"agentPhoto":null,"dateOfBirth":"1999-09-19T18:00:00.000Z","bikeRegistrationNumber":null,"email":null,"bkashNumber":"01993478651","nid":"19993514347010332","nidPhoto":null,"birthCertificateNo":null,"permanentAddress":"kolshi nijamkandi ka","presentAddress":"kamrangir chor jhawl","guarantorName":"abul bashar mondol","guarantorNid":"3514347389460","guarantorNidPhoto":null,"guarantorRelation":"father","assignedShops":[{"id":469672,"name":"Britto"},{"id":507993,"name":"My Choice"}]},{"id":3673,"userId":906976,"name":"Jamil Hosen PA","hubId":1,"hubName":"Kalabagan Hub","isActive":1,"agentType":"pickup","vehicleType":"bicycle","basicSalary":0,"isCountCommissionApplicable":1,"isRangeCommissionApplicable":0,"phoneNumber":"8801780617830","shopId":24169,"shopName":"GlamZ N Style","employeeId":9103673,"agentPhoto":null,"dateOfBirth":"1996-01-04T18:00:00.000Z","bikeRegistrationNumber":null,"email":null,"bkashNumber":"01780617830","nid":"19968113457006969","nidPhoto":null,"birthCertificateNo":null,"permanentAddress":"deir mobbhutpur  gho","presentAddress":"tejgoan  house no 18","guarantorName":"shohana khatun","guarantorNid":"3283788085","guarantorNidPhoto":null,"guarantorRelation":"wife","assignedShops":[{"id":24169,"name":"GlamZ N Style"},{"id":529501,"name":"Parentscare"}]},{"id":3553,"userId":903259,"name":"Roman Ahmmed PA","hubId":1,"hubName":"Kalabagan Hub","isActive":1,"agentType":"pickup","vehicleType":"bike","basicSalary":0,"isCountCommissionApplicable":1,"isRangeCommissionApplicable":0,"phoneNumber":"8801785972566","shopId":2487,"shopName":"Rehman's In TruBeauty","employeeId":9103553,"agentPhoto":null,"dateOfBirth":null,"bikeRegistrationNumber":null,"email":null,"bkashNumber":null,"nid":null,"nidPhoto":null,"birthCertificateNo":null,"permanentAddress":null,"presentAddress":null,"guarantorName":null,"guarantorNid":null,"guarantorNidPhoto":null,"guarantorRelation":null,"assignedShops":[{"id":2487,"name":"Rehman's In TruBeauty"}]},{"id":3570,"userId":903904,"name":"MH Mehedi Hasan PA","hubId":1,"hubName":"Kalabagan Hub","isActive":1,"agentType":"pickup","vehicleType":"bicycle","basicSalary":0,"isCountCommissionApplicable":1,"isRangeCommissionApplicable":0,"phoneNumber":"8801730226961","shopId":2210,"shopName":"Safe Haven","employeeId":9103570,"agentPhoto":null,"dateOfBirth":"2000-03-10T18:00:00.000Z","bikeRegistrationNumber":null,"email":null,"bkashNumber":"01730226961","nid":"20004218481001469","nidPhoto":null,"birthCertificateNo":null,"permanentAddress":"keota rajapur jhalak","presentAddress":"tali office boubazar","guarantorName":"md sultan","guarantorNid":"9136597490","guarantorNidPhoto":null,"guarantorRelation":"father","assignedShops":[{"id":2210,"name":"Safe Haven"},{"id":530173,"name":"Priodesh Shop"}]},{"id":3506,"userId":902293,"name":"Julhas Uddin PA","hubId":1,"hubName":"Kalabagan Hub","isActive":1,"agentType":"pickup","vehicleType":"bicycle","basicSalary":0,"isCountCommissionApplicable":1,"isRangeCommissionApplicable":0,"phoneNumber":"8801625592094","shopId":256371,"shopName":"Apple Gadgets BD","employeeId":9103506,"agentPhoto":null,"dateOfBirth":"1999-09-26T18:00:00.000Z","bikeRegistrationNumber":null,"email":null,"bkashNumber":"01625592094","nid":"19992692533228186","nidPhoto":null,"birthCertificateNo":null,"permanentAddress":"khanshorok rukotoli ","presentAddress":"chaduddan mohammadpu","guarantorName":"Md obaidul talukder","guarantorNid":"4643983572","guarantorNidPhoto":null,"guarantorRelation":"father","assignedShops":[{"id":256371,"name":"Apple Gadgets BD"},{"id":529911,"name":"GADGET VANDAR"}]},{"id":2482,"userId":837267,"name":"Zahirul islam PA","hubId":1,"hubName":"Kalabagan Hub","isActive":1,"agentType":"pickup","vehicleType":"bicycle","basicSalary":11000,"isCountCommissionApplicable":1,"isRangeCommissionApplicable":0,"phoneNumber":"8801567884215","shopId":251294,"shopName":"Style & Splash","employeeId":9102482,"agentPhoto":null,"dateOfBirth":"1970-01-01T00:00:00.000Z","bikeRegistrationNumber":null,"email":null,"bkashNumber":null,"nid":null,"nidPhoto":null,"birthCertificateNo":null,"permanentAddress":null,"presentAddress":null,"guarantorName":null,"guarantorNid":null,"guarantorNidPhoto":null,"guarantorRelation":null,"assignedShops":[{"id":251294,"name":"Style & Splash"}]},{"id":3584,"userId":903965,"name":"Gm Rabby Hasan PA","hubId":1,"hubName":"Kalabagan Hub","isActive":1,"agentType":"pickup","vehicleType":"bicycle","basicSalary":0,"isCountCommissionApplicable":1,"isRangeCommissionApplicable":0,"phoneNumber":"8801308786156","shopId":495480,"shopName":"Wardrobe By Syra","employeeId":9103584,"agentPhoto":null,"dateOfBirth":"2000-04-06T18:00:00.000Z","bikeRegistrationNumber":null,"email":null,"bkashNumber":"01308786156","nid":"2007017776000932","nidPhoto":null,"birthCertificateNo":null,"permanentAddress":"rayanda  shoronkhola","presentAddress":"razabazar  mosjid","guarantorName":"habib munshi","guarantorNid":"0117776574006","guarantorNidPhoto":null,"guarantorRelation":"father","assignedShops":[{"id":495480,"name":"Wardrobe By Syra"}]},{"id":564,"userId":422413,"name":"Rajib Hossain PA","hubId":1,"hubName":"Kalabagan Hub","isActive":1,"agentType":"pickup","vehicleType":"bicycle","basicSalary":0,"isCountCommissionApplicable":1,"isRangeCommissionApplicable":0,"phoneNumber":"8801580849334","shopId":18898,"shopName":"Wings Flavored Sanitary Napkin & কলাগাছ - Kolagach","employeeId":9100564,"agentPhoto":null,"dateOfBirth":"1970-01-01T00:00:00.000Z","bikeRegistrationNumber":null,"email":null,"bkashNumber":null,"nid":null,"nidPhoto":null,"birthCertificateNo":null,"permanentAddress":null,"presentAddress":null,"guarantorName":null,"guarantorNid":null,"guarantorNidPhoto":null,"guarantorRelation":null,"assignedShops":[{"id":18898,"name":"Wings Flavored Sanitary Napkin & কলাগাছ - Kolagach"},{"id":530429,"name":"Season"}]},{"id":491,"userId":174556,"name":"Alhaj Ahmed..PA","hubId":1,"hubName":"Kalabagan Hub","isActive":1,"agentType":"pickup","vehicleType":"bicycle","basicSalary":15000,"isCountCommissionApplicable":1,"isRangeCommissionApplicable":0,"phoneNumber":"8801404055481","shopId":506054,"shopName":"Rakay Service ","employeeId":9100491,"agentPhoto":null,"dateOfBirth":"1970-01-01T00:00:00.000Z","bikeRegistrationNumber":null,"email":null,"bkashNumber":null,"nid":null,"nidPhoto":null,"birthCertificateNo":null,"permanentAddress":null,"presentAddress":null,"guarantorName":null,"guarantorNid":null,"guarantorNidPhoto":null,"guarantorRelation":null,"assignedShops":[{"id":506054,"name":"Rakay Service "}]},{"id":3554,"userId":903314,"name":"Muhibbullah PA","hubId":1,"hubName":"Kalabagan Hub","isActive":1,"agentType":"pickup","vehicleType":"bicycle","basicSalary":0,"isCountCommissionApplicable":1,"isRangeCommissionApplicable":0,"phoneNumber":"8801928577125","shopId":7675,"shopName":"নীল পদ্ম NEEL PODDO","employeeId":9103554,"agentPhoto":null,"dateOfBirth":"2000-05-05T18:00:00.000Z","bikeRegistrationNumber":null,"email":null,"bkashNumber":"01928577125","nid":"6460752279","nidPhoto":null,"birthCertificateNo":null,"permanentAddress":"moddhodhulgram kalki","presentAddress":"kaderabad housing ho","guarantorName":"md  shajalal","guarantorNid":"8251358431","guarantorNidPhoto":null,"guarantorRelation":"father","assignedShops":[{"id":7675,"name":"নীল পদ্ম NEEL PODDO"},{"id":221135,"name":"Torunima"},{"id":528549,"name":"La Superba Israt"}]},{"id":3667,"userId":906914,"name":"Eyashin  gazi PA","hubId":1,"hubName":"Kalabagan Hub","isActive":1,"agentType":"pickup","vehicleType":"bicycle","basicSalary":0,"isCountCommissionApplicable":1,"isRangeCommissionApplicable":0,"phoneNumber":"8801829172954","shopId":118511,"shopName":"Pink Territory ","employeeId":9103667,"agentPhoto":null,"dateOfBirth":"2001-01-02T18:00:00.000Z","bikeRegistrationNumber":null,"email":null,"bkashNumber":"01829172954","nid":"20017815504007964","nidPhoto":null,"birthCertificateNo":null,"permanentAddress":"dumki shatani  angar","presentAddress":"18/d bagun bari  tej","guarantorName":"md harun gazi","guarantorNid":"2699237579387","guarantorNidPhoto":null,"guarantorRelation":"father","assignedShops":[{"id":118511,"name":"Pink Territory "}]},{"id":3668,"userId":906926,"name":"Md Rakibul Hasan PA","hubId":1,"hubName":"Kalabagan Hub","isActive":1,"agentType":"pickup","vehicleType":"bicycle","basicSalary":0,"isCountCommissionApplicable":1,"isRangeCommissionApplicable":0,"phoneNumber":"8801636636283","shopId":466956,"shopName":"A Stitch In Time","employeeId":9103668,"agentPhoto":null,"dateOfBirth":"1998-12-28T18:00:00.000Z","bikeRegistrationNumber":null,"email":null,"bkashNumber":"01735534082","nid":"5104994479","nidPhoto":null,"birthCertificateNo":null,"permanentAddress":"sorfabad kashabpur j","presentAddress":"dhanmondi  15 house ","guarantorName":"abdul bari","guarantorNid":"1936414356","guarantorNidPhoto":null,"guarantorRelation":"father","assignedShops":[{"id":466956,"name":"A Stitch In Time"},{"id":11081,"name":"Bd Craft Corner"}]},{"id":1873,"userId":826095,"name":"Shoyab Hasan PA","hubId":1,"hubName":"Kalabagan Hub","isActive":1,"agentType":"pickup","vehicleType":"bicycle","basicSalary":11000,"isCountCommissionApplicable":1,"isRangeCommissionApplicable":0,"phoneNumber":"8801979878787","shopId":528227,"shopName":"Gadget Root BD","employeeId":9101873,"agentPhoto":null,"dateOfBirth":null,"bikeRegistrationNumber":null,"email":null,"bkashNumber":null,"nid":null,"nidPhoto":null,"birthCertificateNo":null,"permanentAddress":null,"presentAddress":null,"guarantorName":null,"guarantorNid":null,"guarantorNidPhoto":null,"guarantorRelation":null,"assignedShops":[{"id":528227,"name":"Gadget Root BD"}]},{"id":3514,"userId":902336,"name":"Bayzid Bin Lejon PA","hubId":1,"hubName":"Kalabagan Hub","isActive":1,"agentType":"delivery","vehicleType":"bike","basicSalary":0,"isCountCommissionApplicable":1,"isRangeCommissionApplicable":0,"phoneNumber":"8801987055043","shopId":760,"shopName":"দরকারি ডট কম//dorkaree.com","employeeId":9103514,"agentPhoto":null,"dateOfBirth":"1996-08-25T18:00:00.000Z","bikeRegistrationNumber":null,"email":null,"bkashNumber":"01987055042","nid":"1957705542","nidPhoto":null,"birthCertificateNo":null,"permanentAddress":"dorichor lokkipur ba","presentAddress":"dhanmondi staff quat","guarantorName":"md  humayan kabir","guarantorNid":"4623130269","guarantorNidPhoto":null,"guarantorRelation":"father","assignedShops":[{"id":760,"name":"দরকারি ডট কম//dorkaree.com"}]},{"id":1964,"userId":828644,"name":"Md Wasifur PA","hubId":1,"hubName":"Kalabagan Hub","isActive":1,"agentType":"pickup","vehicleType":"bicycle","basicSalary":11000,"isCountCommissionApplicable":1,"isRangeCommissionApplicable":0,"phoneNumber":"8801675648074","shopId":529961,"shopName":"Hi Lady Sanitary Pad","employeeId":9101964,"agentPhoto":null,"dateOfBirth":null,"bikeRegistrationNumber":null,"email":null,"bkashNumber":null,"nid":null,"nidPhoto":null,"birthCertificateNo":null,"permanentAddress":null,"presentAddress":null,"guarantorName":null,"guarantorNid":null,"guarantorNidPhoto":null,"guarantorRelation":null,"assignedShops":[{"id":529961,"name":"Hi Lady Sanitary Pad"}]},{"id":3675,"userId":906991,"name":"Md Sani PA","hubId":1,"hubName":"Kalabagan Hub","isActive":1,"agentType":"pickup","vehicleType":"bicycle","basicSalary":0,"isCountCommissionApplicable":1,"isRangeCommissionApplicable":0,"phoneNumber":"8801647688976","shopId":23640,"shopName":"MyOrganicbd.com","employeeId":9103675,"agentPhoto":null,"dateOfBirth":"2000-06-24T18:00:00.000Z","bikeRegistrationNumber":null,"email":null,"bkashNumber":"01959135301","nid":"20088916766017055","nidPhoto":null,"birthCertificateNo":null,"permanentAddress":"nokla  sharpur","presentAddress":"shukrabad  house no ","guarantorName":"arifa begum","guarantorNid":"3280417076","guarantorNidPhoto":null,"guarantorRelation":"mother","assignedShops":[{"id":23640,"name":"MyOrganicbd.com"}]}]
     */

    private boolean error;
    private List<AgentsBean> agents;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<AgentsBean> getAgents() {
        return agents;
    }

    public void setAgents(List<AgentsBean> agents) {
        this.agents = agents;
    }

    public static class AgentsBean implements Serializable {
        /**
         * id : 3681
         * userId : 907134
         * name : Return/pickup agent
         * hubId : 1
         * hubName : Kalabagan Hub
         * isActive : 1
         * agentType : pickup
         * vehicleType : bike
         * basicSalary : 0
         * isCountCommissionApplicable : 1
         * isRangeCommissionApplicable : 0
         * phoneNumber : 8801842640174
         * shopId : 11509
         * shopName : AJ Collection
         * employeeId : 9103681
         * agentPhoto : null
         * dateOfBirth : 1991-06-05T18:00:00.000Z
         * bikeRegistrationNumber : null
         * email : null
         * bkashNumber : 01842640174
         * nid : 2397058427
         * nidPhoto : null
         * birthCertificateNo : null
         * permanentAddress : kakradah dharabarish
         * presentAddress : nobinagar houssing m
         * guarantorName : ramjan ali
         * guarantorNid : 6914140029394
         * guarantorNidPhoto : null
         * guarantorRelation : father
         * assignedShops : [{"id":11509,"name":"AJ Collection"}]
         */

        private int id;
        private int userId;
        private String name;
        private int hubId;
        private String hubName;
        private int isActive;
        private String agentType;
        private String vehicleType;
        private int basicSalary;
        private int isCountCommissionApplicable;
        private int isRangeCommissionApplicable;
        private String phoneNumber;
        private int shopId;
        private String shopName;
        private int employeeId;
        private Object agentPhoto;
        private String dateOfBirth;
        private Object bikeRegistrationNumber;
        private Object email;
        private String bkashNumber;
        private String nid;
        private Object nidPhoto;
        private Object birthCertificateNo;
        private String permanentAddress;
        private String presentAddress;
        private String guarantorName;
        private String guarantorNid;
        private Object guarantorNidPhoto;
        private String guarantorRelation;
        private List<AssignedShopsBean> assignedShops;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
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

        public int getIsActive() {
            return isActive;
        }

        public void setIsActive(int isActive) {
            this.isActive = isActive;
        }

        public String getAgentType() {
            return agentType;
        }

        public void setAgentType(String agentType) {
            this.agentType = agentType;
        }

        public String getVehicleType() {
            return vehicleType;
        }

        public void setVehicleType(String vehicleType) {
            this.vehicleType = vehicleType;
        }

        public int getBasicSalary() {
            return basicSalary;
        }

        public void setBasicSalary(int basicSalary) {
            this.basicSalary = basicSalary;
        }

        public int getIsCountCommissionApplicable() {
            return isCountCommissionApplicable;
        }

        public void setIsCountCommissionApplicable(int isCountCommissionApplicable) {
            this.isCountCommissionApplicable = isCountCommissionApplicable;
        }

        public int getIsRangeCommissionApplicable() {
            return isRangeCommissionApplicable;
        }

        public void setIsRangeCommissionApplicable(int isRangeCommissionApplicable) {
            this.isRangeCommissionApplicable = isRangeCommissionApplicable;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
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

        public int getEmployeeId() {
            return employeeId;
        }

        public void setEmployeeId(int employeeId) {
            this.employeeId = employeeId;
        }

        public Object getAgentPhoto() {
            return agentPhoto;
        }

        public void setAgentPhoto(Object agentPhoto) {
            this.agentPhoto = agentPhoto;
        }

        public String getDateOfBirth() {
            return dateOfBirth;
        }

        public void setDateOfBirth(String dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
        }

        public Object getBikeRegistrationNumber() {
            return bikeRegistrationNumber;
        }

        public void setBikeRegistrationNumber(Object bikeRegistrationNumber) {
            this.bikeRegistrationNumber = bikeRegistrationNumber;
        }

        public Object getEmail() {
            return email;
        }

        public void setEmail(Object email) {
            this.email = email;
        }

        public String getBkashNumber() {
            return bkashNumber;
        }

        public void setBkashNumber(String bkashNumber) {
            this.bkashNumber = bkashNumber;
        }

        public String getNid() {
            return nid;
        }

        public void setNid(String nid) {
            this.nid = nid;
        }

        public Object getNidPhoto() {
            return nidPhoto;
        }

        public void setNidPhoto(Object nidPhoto) {
            this.nidPhoto = nidPhoto;
        }

        public Object getBirthCertificateNo() {
            return birthCertificateNo;
        }

        public void setBirthCertificateNo(Object birthCertificateNo) {
            this.birthCertificateNo = birthCertificateNo;
        }

        public String getPermanentAddress() {
            return permanentAddress;
        }

        public void setPermanentAddress(String permanentAddress) {
            this.permanentAddress = permanentAddress;
        }

        public String getPresentAddress() {
            return presentAddress;
        }

        public void setPresentAddress(String presentAddress) {
            this.presentAddress = presentAddress;
        }

        public String getGuarantorName() {
            return guarantorName;
        }

        public void setGuarantorName(String guarantorName) {
            this.guarantorName = guarantorName;
        }

        public String getGuarantorNid() {
            return guarantorNid;
        }

        public void setGuarantorNid(String guarantorNid) {
            this.guarantorNid = guarantorNid;
        }

        public Object getGuarantorNidPhoto() {
            return guarantorNidPhoto;
        }

        public void setGuarantorNidPhoto(Object guarantorNidPhoto) {
            this.guarantorNidPhoto = guarantorNidPhoto;
        }

        public String getGuarantorRelation() {
            return guarantorRelation;
        }

        public void setGuarantorRelation(String guarantorRelation) {
            this.guarantorRelation = guarantorRelation;
        }

        public List<AssignedShopsBean> getAssignedShops() {
            return assignedShops;
        }

        public void setAssignedShops(List<AssignedShopsBean> assignedShops) {
            this.assignedShops = assignedShops;
        }

        public static class AssignedShopsBean implements Serializable {
            /**
             * id : 11509
             * name : AJ Collection
             */

            private int id;
            private String name;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }
}
