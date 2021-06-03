package services.responseModels.sapModels;

import java.io.Serializable;
import java.util.List;

public class HubListModel {

    /**
     * error : false
     * hubs : [{"id":1,"hubName":"Kalabagan Hub","isPickup":1,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2018-10-03T02:48:45.000Z","updatedAt":"2018-10-03T02:48:45.000Z","isC2cAvailable":1,"address":"8/11, Peradise Bhobon, Box Culvert Road, Dhaka","phoneNumber":"8801731310966","routeId":20,"routeType":"ISD"},{"id":2,"hubName":"Mohakhali Hub","isPickup":1,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2018-10-03T02:48:55.000Z","updatedAt":"2018-10-03T02:48:55.000Z","isC2cAvailable":1,"address":"Road-15, House-46, Banani","phoneNumber":"8801401122135","routeId":20,"routeType":"ISD"},{"id":3,"hubName":"Mirpur Hub","isPickup":1,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2018-10-03T02:49:03.000Z","updatedAt":"2018-10-03T02:49:03.000Z","isC2cAvailable":1,"address":"213/214, Bashati Housing, Gate number - 2, Borobagh, Mirpur 2, Dhaka","phoneNumber":"8801844944917","routeId":20,"routeType":"ISD"},{"id":4,"hubName":"Malibagh Hub","isPickup":1,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2018-10-03T02:49:16.000Z","updatedAt":"2018-10-03T02:49:16.000Z","isC2cAvailable":1,"address":"698/C, Hazi Anwar Complex, Khilgoan, Dhaka","phoneNumber":"8801401122138","routeId":20,"routeType":"ISD"},{"id":5,"hubName":"Uttora Hub","isPickup":1,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2018-10-03T05:04:54.000Z","updatedAt":"2018-10-03T05:04:54.000Z","isC2cAvailable":1,"address":"House-A, Road-16, Sector-4, Uttara, Dhaka","phoneNumber":"8801401122142","routeId":20,"routeType":"ISD"},{"id":6,"hubName":"Puran Dhaka Hub","isPickup":1,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2018-10-03T05:18:47.000Z","updatedAt":"2018-10-03T05:18:47.000Z","isC2cAvailable":1,"address":"3/4A, Gopinath Kabiraz Street, Babubazar, Dhaka","phoneNumber":"8801877755619","routeId":20,"routeType":"ISD"},{"id":8,"hubName":"Tejgaon Hub (Mother Hub)","isPickup":1,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2018-07-31T16:43:00.000Z","updatedAt":"2018-07-31T16:43:00.000Z","isC2cAvailable":0,"address":null,"phoneNumber":null,"routeId":20,"routeType":"ISD"},{"id":9,"hubName":"Jatrabari Hub","isPickup":1,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2019-08-29T12:26:10.000Z","updatedAt":"2019-08-29T12:26:10.000Z","isC2cAvailable":1,"address":"Old Anabil Hospital Building(3rd Floor), Kajla, Jatrabari, Dhaka","phoneNumber":"8801401122141","routeId":20,"routeType":"ISD"},{"id":11,"hubName":"Tongi","isPickup":1,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-01-01T06:38:37.000Z","updatedAt":"2020-01-01T06:38:37.000Z","isC2cAvailable":1,"address":"Boardbazar,Alhera cng pamp,besides Gazipur city Corporation office","phoneNumber":"8801711220594","routeId":20,"routeType":"ISD"},{"id":12,"hubName":"Savar","isPickup":1,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-01-01T06:38:52.000Z","updatedAt":"2020-01-01T06:38:52.000Z","isC2cAvailable":1,"address":"Chapain Road, Beside of Matribagan Masque, Savar New Market, Dhaka","phoneNumber":"8801515696472","routeId":20,"routeType":"ISD"},{"id":13,"hubName":"Keraniganj","isPickup":1,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-01-01T06:39:19.000Z","updatedAt":"2020-01-01T06:39:19.000Z","isC2cAvailable":0,"address":null,"phoneNumber":null,"routeId":20,"routeType":"ISD"},{"id":14,"hubName":"Narayanganj","isPickup":1,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-01-01T06:39:52.000Z","updatedAt":"2020-01-01T06:39:52.000Z","isC2cAvailable":1,"address":"Shahin Mansion, Holding Number- 7/1 North Chasara, Jamtola, Narayanganj","phoneNumber":"8801786716490","routeId":20,"routeType":"ISD"},{"id":22,"hubName":"Munshiganj Hub","isPickup":1,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-01-18T09:16:12.000Z","updatedAt":"2020-01-18T09:16:12.000Z","isC2cAvailable":1,"address":"Mushiganj Main sadar, Beside of Thana, Munshiganj","phoneNumber":"8801921014136","routeId":20,"routeType":"ISD"},{"id":81,"hubName":"Sreenagar Hub","isPickup":0,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-02-11T14:42:07.000Z","updatedAt":"2020-02-11T14:42:07.000Z","isC2cAvailable":1,"address":"Area:- Jusuorgao, Union:- Sreenagar, Thana:- Sreenagar, Dristrict:- Munshigonj","phoneNumber":"8801909511901","routeId":20,"routeType":"ISD"},{"id":10,"hubName":"Sylhet Hub","isPickup":1,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2019-09-02T14:03:44.000Z","updatedAt":"2019-09-02T14:03:44.000Z","isC2cAvailable":1,"address":"48/A, Al Helal R/A, Shachan Gazi road, Noya Sarak, Sylhet","phoneNumber":"8801681788292","routeId":3,"routeType":"OSD"},{"id":29,"hubName":"Moulvibazar Hub","isPickup":1,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-01-18T09:21:32.000Z","updatedAt":"2020-01-18T09:21:32.000Z","isC2cAvailable":1,"address":"Opposite Chandranath Primary School, Thana: sreemangal","phoneNumber":"8801818706060","routeId":3,"routeType":"OSD"},{"id":93,"hubName":"Sunamganj HUB","isPickup":0,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-02-25T15:04:40.000Z","updatedAt":"2020-02-25T15:04:40.000Z","isC2cAvailable":1,"address":"House/Holding- Pollabi 27/Aa/A, Vill/Road- Alipara Sologor, Post-Sunamganj-3000, Sunamganj Sadar, Sunamganj Pouroshova, Sunamganj","phoneNumber":"8801751055264","routeId":3,"routeType":"OSD"},{"id":105,"hubName":"Beanibazar HUB","isPickup":0,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-09-23T12:14:47.000Z","updatedAt":"2020-09-23T12:14:47.000Z","isC2cAvailable":0,"address":null,"phoneNumber":null,"routeId":3,"routeType":"OSD"},{"id":112,"hubName":"chatak","isPickup":0,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2021-01-18T10:57:24.000Z","updatedAt":"2021-01-18T10:57:24.000Z","isC2cAvailable":0,"address":null,"phoneNumber":null,"routeId":3,"routeType":"OSD"},{"id":38,"hubName":"Sirajganj Hub","isPickup":0,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-01-18T12:18:25.000Z","updatedAt":"2020-01-18T12:18:25.000Z","isC2cAvailable":1,"address":"Vasani Road, Soyadangora Uttor, Post- Sirajganj, Sirajganj Sadar","phoneNumber":"8801721101706","routeId":11,"routeType":"OSD"},{"id":41,"hubName":"Naogaon Hub","isPickup":0,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-01-18T12:19:03.000Z","updatedAt":"2020-01-18T12:19:03.000Z","isC2cAvailable":1,"address":"Vill: Master para, P:O: Chakdate, P:S: Naogaon Sadar, Dist: Naogaon (Beside of Naogaon Muktir mor Shahid miner er pichoney Hoq Sayeb er bari), Naogaon","phoneNumber":"8801762335063, 8801303946317","routeId":11,"routeType":"OSD"},{"id":42,"hubName":"Joypurhat Hub","isPickup":0,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-01-18T12:19:35.000Z","updatedAt":"2020-01-18T12:19:35.000Z","isC2cAvailable":1,"address":"Zilla: Joypurhat,Thana: Joypurhat sadar, Area: Sagorpara, Word No: 04, Road No: 06, 5900","phoneNumber":"8801708755926","routeId":11,"routeType":"OSD"},{"id":54,"hubName":"Dinajpur Hub","isPickup":0,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-01-20T05:49:38.000Z","updatedAt":"2020-01-20T05:49:38.000Z","isC2cAvailable":1,"address":"Vill/Road-Fakirpara, Post- Dinajpur, Thana: Dinajpur sadar, Dinajpur-5200","phoneNumber":"8801710186365","routeId":11,"routeType":"OSD"},{"id":69,"hubName":"Bogra Hub","isPickup":1,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-02-02T14:12:05.000Z","updatedAt":"2020-02-02T14:12:05.000Z","isC2cAvailable":1,"address":"Vill/ Road- Thonthonia, shahidnagar, Post-Bogura-5800, Bogura Sadar   Bogura Pouroshova, Bogura","phoneNumber":"8801707900221","routeId":11,"routeType":"OSD"},{"id":108,"hubName":"Birampur Hub","isPickup":0,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-10-04T12:30:06.000Z","updatedAt":"2020-10-04T12:30:06.000Z","isC2cAvailable":0,"address":null,"phoneNumber":null,"routeId":11,"routeType":"OSD"},{"id":18,"hubName":"Barishal Hub","isPickup":1,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-01-17T11:18:01.000Z","updatedAt":"2020-01-17T11:18:01.000Z","isC2cAvailable":1,"address":"Richon Villa, Road-Eidgoan Lane, Novogram Raod, Post- Barishal Sadar, Thana: Barishal Sadar, Barishal-8200","phoneNumber":"8801718164796","routeId":14,"routeType":"OSD"},{"id":21,"hubName":"Madaripur Hub","isPickup":0,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-01-18T09:15:26.000Z","updatedAt":"2020-01-18T09:15:26.000Z","isC2cAvailable":1,"address":"Madaripur sodor, Zilla :-Madaripur, Thana:- Madaripur, Pablik Laibyrir samne","phoneNumber":"8801799340376","routeId":14,"routeType":"OSD"},{"id":36,"hubName":"Bhola Hub","isPickup":0,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-01-18T12:15:43.000Z","updatedAt":"2020-01-18T12:15:43.000Z","isC2cAvailable":1,"address":"House:474, Mohajon Potti, Road: Ochin kumar road, Thana: Bhola Sadar, Bhola","phoneNumber":"8801743412008","routeId":14,"routeType":"OSD"},{"id":45,"hubName":"Shariatpur Hub","isPickup":0,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-01-18T12:23:05.000Z","updatedAt":"2020-01-18T12:23:05.000Z","isC2cAvailable":1,"address":"House: Speen Building, Behind Palong Thana, Road: Kotowali Bari Road, Thana: Palong, Dist.: Shariatpur, Post Code: 8000","phoneNumber":"8801618911404","routeId":14,"routeType":"OSD"},{"id":107,"hubName":"Gournadi HUB","isPickup":0,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-10-03T10:15:18.000Z","updatedAt":"2020-10-03T10:15:18.000Z","isC2cAvailable":0,"address":null,"phoneNumber":null,"routeId":14,"routeType":"OSD"},{"id":31,"hubName":"Rangpur Hub","isPickup":1,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-01-18T09:22:55.000Z","updatedAt":"2020-01-18T09:22:55.000Z","isC2cAvailable":1,"address":"House-233, Holding No-36, Ward-26, Road-3, Thikadar Para, Rangpur Citycorporation, Rangpur","phoneNumber":"8801764888359","routeId":17,"routeType":"OSD"},{"id":34,"hubName":"Nilphamari Hub","isPickup":0,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-01-18T12:14:30.000Z","updatedAt":"2020-01-18T12:14:30.000Z","isC2cAvailable":0,"address":null,"phoneNumber":null,"routeId":17,"routeType":"OSD"},{"id":86,"hubName":"Saidpur HUB","isPickup":0,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-02-16T09:56:17.000Z","updatedAt":"2020-02-16T09:56:17.000Z","isC2cAvailable":0,"address":null,"phoneNumber":null,"routeId":17,"routeType":"OSD"},{"id":16,"hubName":"Khulna Hub","isPickup":1,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-01-13T12:25:17.000Z","updatedAt":"2020-01-13T12:25:17.000Z","isC2cAvailable":1,"address":"House-282, 15 Nur Nagar, Nur nagar Mosjid Raod, Post- GPO- 9000, Sosnadanga Khulna citycorporation Khulna","phoneNumber":"8801741823343","routeId":2,"routeType":"OSD"},{"id":24,"hubName":"Perojpur Hub","isPickup":0,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-01-18T09:17:18.000Z","updatedAt":"2020-01-18T09:17:18.000Z","isC2cAvailable":1,"address":"No Office Yet","phoneNumber":"8801913811620","routeId":2,"routeType":"OSD"},{"id":26,"hubName":"Faridpur Hub","isPickup":0,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-01-18T09:20:00.000Z","updatedAt":"2020-01-18T09:20:00.000Z","isC2cAvailable":1,"address":"House: Babu advocate bari,East shabajpur, Thana: Kotowali, Faridpur","phoneNumber":"8801722118090","routeId":2,"routeType":"OSD"},{"id":47,"hubName":"Rajbari Hub","isPickup":0,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-01-18T12:25:11.000Z","updatedAt":"2020-01-18T12:25:11.000Z","isC2cAvailable":1,"address":"House-126 vill/ Road Dhokhine vobanipur Rajbari sador.post -rajbari 7700","phoneNumber":"8801300691062","routeId":2,"routeType":"OSD"},{"id":49,"hubName":"Gopalganj","isPickup":0,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-01-18T12:27:57.000Z","updatedAt":"2020-01-18T12:27:57.000Z","isC2cAvailable":1,"address":"Vill/ Road- Goserchar, Post-Gopalganj Sadar-8100, Gopalgonj","phoneNumber":"8801923144537","routeId":2,"routeType":"OSD"},{"id":91,"hubName":"Bagerhat HUB","isPickup":0,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-02-22T13:46:09.000Z","updatedAt":"2020-02-22T13:46:09.000Z","isC2cAvailable":1,"address":"Kazipara, Vill/Road-Ronbijoypur, Post-K ali Dargah-9300, Bagerhat","phoneNumber":"8801710260985","routeId":2,"routeType":"OSD"},{"id":20,"hubName":"Patuakhali Hub","isPickup":1,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-01-18T09:14:58.000Z","updatedAt":"2020-01-18T09:14:58.000Z","isC2cAvailable":1,"address":"House-791/A, Sadar road patuakhali sadar, ,post-patuakhali-8600 Patuakhali sadar,Patuakhali pourashava manikgonj","phoneNumber":"8801714041633","routeId":19,"routeType":"OSD"},{"id":28,"hubName":"Jalokathi Hub","isPickup":0,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-01-18T09:20:58.000Z","updatedAt":"2020-01-18T09:20:58.000Z","isC2cAvailable":0,"address":null,"phoneNumber":null,"routeId":19,"routeType":"OSD"},{"id":37,"hubName":"Barguna Hub","isPickup":0,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-01-18T12:17:04.000Z","updatedAt":"2020-01-18T12:17:04.000Z","isC2cAvailable":1,"address":"Sumaiya Mansion  House No.: 29, Sadar Road, Barguna Sadar, Barguna-8700 (Beside of LG showroom)","phoneNumber":"8801712814567","routeId":19,"routeType":"OSD"},{"id":39,"hubName":"Pabna Hub","isPickup":0,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-01-18T12:18:35.000Z","updatedAt":"2020-01-18T12:18:35.000Z","isC2cAvailable":1,"address":"House- 126/2 ,Road begom rokeye soroni,Porchim senpara porbta, Post mirpur 1216","phoneNumber":"8801794545688","routeId":7,"routeType":"OSD"},{"id":40,"hubName":"Natore Hub","isPickup":0,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-01-18T12:18:47.000Z","updatedAt":"2020-01-18T12:18:47.000Z","isC2cAvailable":1,"address":"House-364, Vill/ Road- Dakkhin Borogasa,Post-Natore Sadar 6400,   Natore PouroShova, Natoe","phoneNumber":"8801774195947","routeId":7,"routeType":"OSD"},{"id":57,"hubName":"Rajshahi Hub","isPickup":0,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-01-21T09:07:03.000Z","updatedAt":"2020-01-21T09:07:03.000Z","isC2cAvailable":1,"address":"House-407, Ward-28, Sweet er More, Ektormore road, kajla, Motiar Rajshahi","phoneNumber":"8801728365560","routeId":7,"routeType":"OSD"},{"id":63,"hubName":"Chapai Nawabganj Hub","isPickup":0,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-01-26T06:44:25.000Z","updatedAt":"2020-01-26T06:44:25.000Z","isC2cAvailable":1,"address":"Vill/Raod- Shantibag, Post- Chapainawabganj-6300, Chapainawabganj Sadar  Chapainawabganj pouroshova, Chapainawabganj","phoneNumber":"8801791719369","routeId":7,"routeType":"OSD"},{"id":51,"hubName":"Netrokona Hub","isPickup":0,"isDelivery":1,"isSorting":0,"isSoho":1,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-01-20T05:26:22.000Z","updatedAt":"2020-01-20T05:26:22.000Z","isC2cAvailable":1,"address":"Holding No:- 0094-00 Word No:- 01 Post- 2400 Fond of Gov.College Netrakona satpi / Netrakona sodor","phoneNumber":"8801712765430","routeId":12,"routeType":"OSD"},{"id":52,"hubName":"Narsingdi Hub","isPickup":0,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-01-20T05:32:18.000Z","updatedAt":"2020-01-20T05:32:18.000Z","isC2cAvailable":1,"address":"Sujan Enterprise Bakul Tower, Dhaka Bus stand, Velanagar, Narshingdi-1600","phoneNumber":"8801711393581","routeId":12,"routeType":"OSD"},{"id":68,"hubName":"Kishorganj Hub","isPickup":0,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-01-30T14:18:18.000Z","updatedAt":"2020-01-30T14:18:18.000Z","isC2cAvailable":1,"address":"House/ Holding-1518,Vill/ Road- AKhra Bazar Binna gaon, Post- Kishorgonj   Sadar-2300, Kishorgonj Pouro shova ,Kishorgonj","phoneNumber":"8801712992311","routeId":12,"routeType":"OSD"},{"id":109,"hubName":"Bhairab Hub","isPickup":0,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-10-28T09:05:15.000Z","updatedAt":"2020-10-28T09:05:15.000Z","isC2cAvailable":0,"address":null,"phoneNumber":null,"routeId":12,"routeType":"OSD"},{"id":32,"hubName":"Jessore Hub","isPickup":0,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-01-18T12:13:35.000Z","updatedAt":"2020-01-18T12:13:35.000Z","isC2cAvailable":1,"address":"House-41, Holding-1469,Vill/Road- Rail Road,Post-Jashore-7400, Kotoali  Jassore Pourosova, Jassore","phoneNumber":"8801969803946","routeId":10,"routeType":"OSD"},{"id":43,"hubName":"Satkhira Hub","isPickup":0,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-01-18T12:22:14.000Z","updatedAt":"2020-01-18T12:22:14.000Z","isC2cAvailable":1,"address":"সাতক্ষীরা সদর, নিউ মার্কেট,আল বারাকা শপিং সেন্টারের অপজিটে, কামালনগর রোড, ৮ নম্বর ওয়ার্ড, খোকা সাহেবের বাড়ির পাশের বিল্ডিং","phoneNumber":"8801670707446","routeId":10,"routeType":"OSD"},{"id":58,"hubName":"Magura Hub","isPickup":0,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-01-21T09:15:46.000Z","updatedAt":"2020-01-21T09:15:46.000Z","isC2cAvailable":1,"address":"House:206 Road:jhenidha-Magura High way Magura:7600 Word no:2  Magura shodor Magura Police line","phoneNumber":"8801995015625","routeId":10,"routeType":"OSD"},{"id":71,"hubName":"Jessore Noapara Hub","isPickup":1,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-02-03T15:37:54.000Z","updatedAt":"2020-02-03T15:37:54.000Z","isC2cAvailable":1,"address":"L.B. Tower. Noapara Bazar. Avoynagar. Jessore","phoneNumber":"8801717495901","routeId":10,"routeType":"OSD"},{"id":44,"hubName":"Meherpur Hub","isPickup":0,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-01-18T12:22:36.000Z","updatedAt":"2020-01-18T12:22:36.000Z","isC2cAvailable":1,"address":"Govt College more Post office para #9 no word Meherpur Sadar Meherpur 7100","phoneNumber":"8801313718002","routeId":8,"routeType":"OSD"},{"id":56,"hubName":"Chuadanga Hub","isPickup":0,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-01-20T05:52:33.000Z","updatedAt":"2020-01-20T05:52:33.000Z","isC2cAvailable":1,"address":"Road/Vill- Delotdear kourear para, Post-Chuadanga-7200, Chuadanga Sadar, Chuadanga","phoneNumber":"8801980555657","routeId":8,"routeType":"OSD"},{"id":59,"hubName":"Narail Hub","isPickup":0,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-01-21T09:16:01.000Z","updatedAt":"2020-01-21T09:16:01.000Z","isC2cAvailable":1,"address":"House :sajeb abashik vill/Road-old bus terminal Narail sadar,-post-Ratangonj-7500  Narail Sadar, Pouroshova Narail","phoneNumber":"8801732700074","routeId":8,"routeType":"OSD"},{"id":61,"hubName":"Kushtia Hub","isPickup":1,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-01-23T05:29:28.000Z","updatedAt":"2020-01-23T05:29:28.000Z","isC2cAvailable":1,"address":"Vill-Purbo Mozumpur, Post- Kustia-7000, Kustia Sadar, Kustia Pouroshova,Kustia","phoneNumber":"8801967221122","routeId":8,"routeType":"OSD"},{"id":64,"hubName":"Jhenaidah Hub","isPickup":0,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-01-26T06:45:58.000Z","updatedAt":"2020-01-26T06:45:58.000Z","isC2cAvailable":1,"address":"Vill/Raod-Dori Gobindopur, Bishpara, Post-Kalicharnpur-7300, Jhenaidah Sadar, Jhenaidah Pouroshova, Jhenaidah","phoneNumber":"8801742675980","routeId":8,"routeType":"OSD"},{"id":35,"hubName":"Cox's Bazar Hub","isPickup":1,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-01-18T12:14:57.000Z","updatedAt":"2020-01-18T12:14:57.000Z","isC2cAvailable":1,"address":"House-203, Vill/Road-Dakkhin tekpara prodhan sorok, Post-Coxbazar, Coxbazar sadar, Coxbazar","phoneNumber":"8801813907552","routeId":5,"routeType":"OSD"},{"id":101,"hubName":"Hathazari Hub","isPickup":1,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-06-22T04:22:43.000Z","updatedAt":"2020-06-22T04:22:43.000Z","isC2cAvailable":1,"address":"Hathazari,11 Mile,Sabor Manson","phoneNumber":"8801828634272","routeId":5,"routeType":"OSD"},{"id":103,"hubName":"Patiya Hub","isPickup":1,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-06-22T04:26:55.000Z","updatedAt":"2020-06-22T04:26:55.000Z","isC2cAvailable":1,"address":"চিশতিয়া মঞ্জিল মুন্সেফ বাজার চট্টগ্রাম।","phoneNumber":"8801848108676","routeId":5,"routeType":"OSD"},{"id":104,"hubName":"Chakaria HUB","isPickup":1,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-09-23T12:12:45.000Z","updatedAt":"2020-09-23T12:12:45.000Z","isC2cAvailable":0,"address":null,"phoneNumber":null,"routeId":5,"routeType":"OSD"},{"id":33,"hubName":"Panchagarh Hub","isPickup":0,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-01-18T12:13:55.000Z","updatedAt":"2020-01-18T12:13:55.000Z","isC2cAvailable":1,"address":"House -41/5 vill/Road- Rosonabag, tunihat road panchagarh sadar,-post-Panchagarh-5000, Panchagarh Sadar, Panchagarh Pouroshova Panchagarh","phoneNumber":"8801744921550","routeId":18,"routeType":"OSD"},{"id":50,"hubName":"Thakurgaon Hub","isPickup":0,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-01-18T12:28:26.000Z","updatedAt":"2020-01-18T12:28:26.000Z","isC2cAvailable":1,"address":"Vill: Tatipara, P:O: Thakurgaon sadar, P:S: Thakurgaon, Dist: Thakurgaon, Amtoli road, Tatipara, House name: Halim Enterprise, Beside of Royal Kinter Garden school, Thakurgaon","phoneNumber":"8801713550829","routeId":18,"routeType":"OSD"},{"id":55,"hubName":"Gaibandha Hub","isPickup":0,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-01-20T05:50:11.000Z","updatedAt":"2020-01-20T05:50:11.000Z","isC2cAvailable":1,"address":"Vill-Road-Uttar Baniar Jan, Post-Gaibandha-5700, Gaibandha Sadar, Gaibandha Pourashova, Gaibandha","phoneNumber":"8801883466248","routeId":18,"routeType":"OSD"},{"id":67,"hubName":"Kurigram","isPickup":1,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-01-30T09:34:27.000Z","updatedAt":"2020-01-30T09:34:27.000Z","isC2cAvailable":1,"address":"Vill: Kisnopur paik para, P:O: Kurigram, P:S: Kurigram sadar, Dist: Kurigram","phoneNumber":"8801723120611","routeId":18,"routeType":"OSD"},{"id":92,"hubName":"Lalmonirhat HUB","isPickup":0,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-02-24T15:33:53.000Z","updatedAt":"2020-02-24T15:33:53.000Z","isC2cAvailable":1,"address":"Vocational rood, Lalmonirhat, Boisakhi Clinic (Side Building)","phoneNumber":"8801727855734","routeId":18,"routeType":"OSD"},{"id":60,"hubName":"Rangamati Hub","isPickup":0,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-01-21T09:16:19.000Z","updatedAt":"2020-01-21T09:16:19.000Z","isC2cAvailable":1,"address":"House-4th Class Club, Vill/Road-Uttar Kalindipur, Post-Rangamati-4500, Rangamati Sadar, Rangamati Pouroshova, Rangamati","phoneNumber":"8801646743377","routeId":16,"routeType":"OSD"},{"id":80,"hubName":"Khagrachari Hub","isPickup":0,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-02-11T11:00:00.000Z","updatedAt":"2020-02-11T11:00:00.000Z","isC2cAvailable":1,"address":"Khagrachori engineering workshop building, Opposite Khagrachori Eye Hospital, Khagrachori-4400","phoneNumber":"8801517113663","routeId":16,"routeType":"OSD"},{"id":94,"hubName":"Bandarban HUB","isPickup":1,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-02-28T04:06:55.000Z","updatedAt":"2020-02-28T04:06:55.000Z","isC2cAvailable":0,"address":null,"phoneNumber":null,"routeId":16,"routeType":"OSD"},{"id":25,"hubName":"Chadpur Hub","isPickup":1,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-01-18T09:19:30.000Z","updatedAt":"2020-01-18T09:19:30.000Z","isC2cAvailable":1,"address":"House- 582/525, Vill/Road- Koralia Road,koralia, Post-Chandpur-3600,Chandpur Sadar, Chandpur Pourasova, Chandpur","phoneNumber":"8801688129908","routeId":6,"routeType":"OSD"},{"id":65,"hubName":"Noakhali Hub","isPickup":0,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-01-26T06:46:54.000Z","updatedAt":"2020-01-26T06:46:54.000Z","isC2cAvailable":1,"address":"House-Satani Bari,Vill/ Road- Notun College Road, Maijdi (Part-B)   Post- Maijdi Cort -3800,Noakhali Sadar, Noakhali Pouroshova, Noakhali","phoneNumber":"8801845887908","routeId":6,"routeType":"OSD"},{"id":66,"hubName":"Lakshmipur Hub","isPickup":0,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-01-26T06:49:46.000Z","updatedAt":"2020-01-26T06:49:46.000Z","isC2cAvailable":1,"address":"House/Holding-1215,Vill/Road- Banchanagar, Post-Laxipur-3700, Laxipur Sodar, Laxipur Pourosova, Laxipur","phoneNumber":"8801755007500","routeId":6,"routeType":"OSD"},{"id":17,"hubName":"Mymensingh Hub","isPickup":1,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-01-17T10:42:41.000Z","updatedAt":"2020-01-17T10:42:41.000Z","isC2cAvailable":1,"address":"Vill/ Road- Pahar Anantopur, Post- Babuganj Bazar-2216,Fulbaria  Mymensingh","phoneNumber":"8801761877713","routeId":13,"routeType":"OSD"},{"id":19,"hubName":"Jamalpur Hub","isPickup":1,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-01-18T09:14:05.000Z","updatedAt":"2020-01-18T09:14:05.000Z","isC2cAvailable":1,"address":"Rahman Plaza, Tamaltola, Jamalpur sadar thana, Jamalpur-2000","phoneNumber":"8801772380333","routeId":13,"routeType":"OSD"},{"id":23,"hubName":"Sherpur Hub","isPickup":0,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-01-18T09:16:47.000Z","updatedAt":"2020-01-18T09:16:47.000Z","isC2cAvailable":1,"address":"Holding no: 101/1,  Gopalbari Battala, Sherpur Sadar, Sherpur-2100","phoneNumber":"8801716956088","routeId":13,"routeType":"OSD"},{"id":7,"hubName":"Chittagong Hub","isPickup":1,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2018-10-24T07:24:16.000Z","updatedAt":"2018-10-24T07:24:16.000Z","isC2cAvailable":1,"address":"O R Nizam R/A, Road#01, House# 07, Monowar Villa, Ground Floor,GEC, Panchlaish, Chittagong-4203","phoneNumber":"8801313717926","routeId":1,"routeType":"OSD"},{"id":102,"hubName":"Miresorai Hub","isPickup":1,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-06-22T04:25:37.000Z","updatedAt":"2020-06-22T04:25:37.000Z","isC2cAvailable":1,"address":"House: Daroga bari, Union: 12 No. Koisora, Thana: Miresorai-8320","phoneNumber":"8801686234407","routeId":1,"routeType":"OSD"},{"id":27,"hubName":"Tangail Hub","isPickup":0,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-01-18T09:20:25.000Z","updatedAt":"2020-01-18T09:20:25.000Z","isC2cAvailable":1,"address":"House/Holding-Block-A/5, House-1,Vill/ Road-Biswas Betka sibnathpara, Post-Tangail-1900, Thana: Tangil Sador, Tangil Pouroshova, Tangail","phoneNumber":"8801731185091","routeId":15,"routeType":"OSD"},{"id":48,"hubName":"Manikganj Hub","isPickup":0,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-01-18T12:26:16.000Z","updatedAt":"2020-01-18T12:26:16.000Z","isC2cAvailable":1,"address":"House-87/7 vill/Road-porra manikganj sadar, Post-Manikganj-1800, Manikganj Sadar, Manikganj Pouroshova, Manikganj","phoneNumber":"8801682687111","routeId":15,"routeType":"OSD"},{"id":15,"hubName":"Comilla Hub","isPickup":1,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-01-12T08:11:33.000Z","updatedAt":"2020-01-12T08:11:33.000Z","isC2cAvailable":1,"address":"367/335, Momena Monjil , Jawtola, Cumilla Adsharo Nagar Cumilla","phoneNumber":"8801861548104","routeId":4,"routeType":"OSD"},{"id":53,"hubName":"Feni Hub","isPickup":0,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-01-20T05:38:18.000Z","updatedAt":"2020-01-20T05:38:18.000Z","isC2cAvailable":1,"address":"House-H-73, Chewria House, Vill/ Road- College Road, masterpara,Post- Feni-3900, Feni Sadar, Feni Pouroshova, Feni","phoneNumber":"8801825214248","routeId":4,"routeType":"OSD"},{"id":110,"hubName":"Gouripur Hub","isPickup":1,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-11-11T12:13:23.000Z","updatedAt":"2020-11-11T12:13:23.000Z","isC2cAvailable":0,"address":null,"phoneNumber":null,"routeId":4,"routeType":"OSD"},{"id":30,"hubName":"Habiganj Hub","isPickup":1,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-01-18T09:22:30.000Z","updatedAt":"2020-01-18T09:22:30.000Z","isC2cAvailable":1,"address":"শায়েস্তানগর, চৌধুরী কুটির, (১ম তলা), পো.+ থানা+ জেলা : হবিগঞ্জ (টেলিটক অফিসের গেইটের বিপরিতে)","phoneNumber":"8801717926876","routeId":9,"routeType":"OSD"},{"id":85,"hubName":"Brahmanbaria Hub","isPickup":1,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-02-13T15:49:29.000Z","updatedAt":"2020-02-13T15:49:29.000Z","isC2cAvailable":1,"address":"House- 1438/1, Laila Bhaban, Vill/ Road- Kawtali, Post- B.Baria-3400  B.Baria Pouroshova, B.Baria","phoneNumber":"8801718528504","routeId":9,"routeType":"OSD"},{"id":106,"hubName":"Nabinagar HUB","isPickup":1,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-09-28T13:48:38.000Z","updatedAt":"2020-09-28T13:48:38.000Z","isC2cAvailable":0,"address":null,"phoneNumber":null,"routeId":9,"routeType":"OSD"},{"id":113,"hubName":"Wari Test Hubss","isPickup":1,"isDelivery":1,"isSorting":1,"isSoho":1,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2021-03-09T12:24:18.000Z","updatedAt":"2021-03-14T09:11:54.000Z","isC2cAvailable":1,"address":"123,lake road,lake.123,lake road,lake.123,lake road,lake.123,lake road,lake.123,lake road,lake.123,lake road,lake.123,lake road,lake.123,lake road,lake.123,lake road,lake.123,lake road,lake.123,lake road,lake.123,lake road,lake.123,lake road,lake.","phoneNumber":"8801756223666","routeId":20,"routeType":"ISD"},{"id":46,"hubName":"Sherpur Depricated Hub","isPickup":0,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"inactive","lat":null,"lon":null,"createdAt":"2020-01-18T12:24:16.000Z","updatedAt":"2020-01-18T12:24:16.000Z","isC2cAvailable":0,"address":null,"phoneNumber":null,"routeId":null,"routeType":null},{"id":62,"hubName":"Sreemangal Hub","isPickup":0,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-01-25T10:04:55.000Z","updatedAt":"2020-01-25T10:04:55.000Z","isC2cAvailable":0,"address":null,"phoneNumber":null,"routeId":null,"routeType":null},{"id":70,"hubName":"Abhoynagar Jessore Hub","isPickup":0,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-02-03T15:31:28.000Z","updatedAt":"2020-02-03T15:31:28.000Z","isC2cAvailable":0,"address":null,"phoneNumber":null,"routeId":null,"routeType":null},{"id":72,"hubName":"Barlekha Hub","isPickup":0,"isDelivery":0,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-02-04T07:47:16.000Z","updatedAt":"2020-02-04T07:47:16.000Z","isC2cAvailable":0,"address":null,"phoneNumber":null,"routeId":null,"routeType":null},{"id":73,"hubName":"Kalkini Hub","isPickup":0,"isDelivery":0,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-02-06T06:41:29.000Z","updatedAt":"2020-02-06T06:41:29.000Z","isC2cAvailable":0,"address":null,"phoneNumber":null,"routeId":null,"routeType":null},{"id":74,"hubName":"Rajoir Hub","isPickup":0,"isDelivery":0,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-02-06T06:42:19.000Z","updatedAt":"2020-02-06T06:42:19.000Z","isC2cAvailable":0,"address":null,"phoneNumber":null,"routeId":null,"routeType":null},{"id":75,"hubName":"Debigonj","isPickup":0,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-02-07T11:00:24.000Z","updatedAt":"2020-02-07T11:00:24.000Z","isC2cAvailable":0,"address":null,"phoneNumber":null,"routeId":null,"routeType":null},{"id":76,"hubName":"Shibchar","isPickup":0,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-02-07T11:03:39.000Z","updatedAt":"2020-02-07T11:03:39.000Z","isC2cAvailable":0,"address":null,"phoneNumber":null,"routeId":null,"routeType":null},{"id":77,"hubName":"Santhia","isPickup":0,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-02-07T11:06:24.000Z","updatedAt":"2020-02-07T11:06:24.000Z","isC2cAvailable":0,"address":null,"phoneNumber":null,"routeId":null,"routeType":null},{"id":78,"hubName":"Bera","isPickup":0,"isDelivery":0,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-02-07T11:09:13.000Z","updatedAt":"2020-02-07T11:09:13.000Z","isC2cAvailable":0,"address":null,"phoneNumber":null,"routeId":null,"routeType":null},{"id":79,"hubName":"Nakla","isPickup":0,"isDelivery":0,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-02-07T11:11:27.000Z","updatedAt":"2020-02-07T11:11:27.000Z","isC2cAvailable":0,"address":null,"phoneNumber":null,"routeId":null,"routeType":null},{"id":82,"hubName":"Tangibari Hub","isPickup":0,"isDelivery":0,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-02-11T14:43:36.000Z","updatedAt":"2020-02-11T14:43:36.000Z","isC2cAvailable":0,"address":null,"phoneNumber":null,"routeId":null,"routeType":null},{"id":83,"hubName":"Durgapur Netrokona Hub","isPickup":0,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-02-11T14:45:25.000Z","updatedAt":"2020-02-11T14:45:25.000Z","isC2cAvailable":0,"address":null,"phoneNumber":null,"routeId":null,"routeType":null},{"id":84,"hubName":"SOHO Area","isPickup":0,"isDelivery":0,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-02-13T14:02:14.000Z","updatedAt":"2020-02-13T14:02:14.000Z","isC2cAvailable":0,"address":null,"phoneNumber":null,"routeId":null,"routeType":null},{"id":87,"hubName":"Kalmakanda HUB ( Netrokona)","isPickup":0,"isDelivery":0,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-02-19T08:42:37.000Z","updatedAt":"2020-02-19T08:42:37.000Z","isC2cAvailable":0,"address":null,"phoneNumber":null,"routeId":null,"routeType":null},{"id":88,"hubName":"Ishwardi HUB ( Pabna )","isPickup":0,"isDelivery":0,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-02-19T12:19:38.000Z","updatedAt":"2020-02-19T12:19:38.000Z","isC2cAvailable":0,"address":null,"phoneNumber":null,"routeId":null,"routeType":null},{"id":89,"hubName":"Gurudaspur Hub","isPickup":0,"isDelivery":0,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-02-20T09:29:57.000Z","updatedAt":"2020-02-20T09:29:57.000Z","isC2cAvailable":0,"address":null,"phoneNumber":null,"routeId":null,"routeType":null},{"id":90,"hubName":"Sreenagar HUB","isPickup":0,"isDelivery":0,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-02-22T07:20:54.000Z","updatedAt":"2020-02-22T07:20:54.000Z","isC2cAvailable":0,"address":null,"phoneNumber":null,"routeId":null,"routeType":null},{"id":95,"hubName":"Dispatch Hub","isPickup":0,"isDelivery":0,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-03-02T12:46:15.000Z","updatedAt":"2020-03-02T12:46:15.000Z","isC2cAvailable":0,"address":null,"phoneNumber":null,"routeId":null,"routeType":null},{"id":96,"hubName":"Kulaura","isPickup":0,"isDelivery":0,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-03-04T14:18:57.000Z","updatedAt":"2020-03-04T14:18:57.000Z","isC2cAvailable":0,"address":null,"phoneNumber":null,"routeId":null,"routeType":null},{"id":97,"hubName":"Amtali HUB","isPickup":0,"isDelivery":0,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-03-14T06:47:27.000Z","updatedAt":"2020-03-14T06:47:27.000Z","isC2cAvailable":0,"address":null,"phoneNumber":null,"routeId":null,"routeType":null},{"id":98,"hubName":"Outside Dhaka Hub","isPickup":0,"isDelivery":0,"isSorting":0,"isSoho":0,"isVirtual":1,"status":"active","lat":null,"lon":null,"createdAt":"0000-00-00 00:00:00","updatedAt":"0000-00-00 00:00:00","isC2cAvailable":0,"address":null,"phoneNumber":null,"routeId":null,"routeType":null},{"id":99,"hubName":"Mirzapur HUB","isPickup":0,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-04-25T05:03:04.000Z","updatedAt":"2020-04-25T05:03:04.000Z","isC2cAvailable":0,"address":null,"phoneNumber":null,"routeId":null,"routeType":null},{"id":100,"hubName":"mohakhali","isPickup":0,"isDelivery":0,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-06-20T03:46:42.000Z","updatedAt":"2020-06-20T03:46:42.000Z","isC2cAvailable":0,"address":null,"phoneNumber":null,"routeId":null,"routeType":null},{"id":111,"hubName":"Central Documents Hub","isPickup":1,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2020-12-02T10:53:33.000Z","updatedAt":"2020-12-02T10:53:33.000Z","isC2cAvailable":0,"address":null,"phoneNumber":null,"routeId":null,"routeType":null},{"id":114,"hubName":"Offline C2C","isPickup":1,"isDelivery":1,"isSorting":0,"isSoho":0,"isVirtual":0,"status":"active","lat":null,"lon":null,"createdAt":"2021-04-01T09:36:47.000Z","updatedAt":"2021-04-01T09:36:47.000Z","isC2cAvailable":1,"address":"Tejgaon","phoneNumber":null,"routeId":null,"routeType":null}]
     */

    private boolean error;
    private List<HubsBean> hubs;
    private List<BodyBean> body;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<HubsBean> getHubs() {
        return hubs;
    }

    public void setHubs(List<HubsBean> hubs) {
        this.hubs = hubs;
    }

    public List<BodyBean> getBody() {
        return body;
    }

    public void setBody(List<BodyBean> body) {
        this.body = body;
    }

    public static class BodyBean implements Serializable {
        /**
         * ID : 101
         * HUB_NAME : Hathazari Hub
         * IS_MH : 0
         */

        private int ID;
        private String HUB_NAME;
        private int IS_MH;

        public int getID() {
            return ID;
        }

        public void setID(int ID) {
            this.ID = ID;
        }

        public String getHUB_NAME() {
            return HUB_NAME;
        }

        public void setHUB_NAME(String HUB_NAME) {
            this.HUB_NAME = HUB_NAME;
        }

        public int getIS_MH() {
            return IS_MH;
        }

        public void setIS_MH(int IS_MH) {
            this.IS_MH = IS_MH;
        }
    }

    public static class HubsBean implements Serializable {
        /**
         * id : 1
         * hubName : Kalabagan Hub
         * isPickup : 1
         * isDelivery : 1
         * isSorting : 0
         * isSoho : 0
         * isVirtual : 0
         * status : active
         * lat : null
         * lon : null
         * createdAt : 2018-10-03T02:48:45.000Z
         * updatedAt : 2018-10-03T02:48:45.000Z
         * isC2cAvailable : 1
         * address : 8/11, Peradise Bhobon, Box Culvert Road, Dhaka
         * phoneNumber : 8801731310966
         * routeId : 20
         * routeType : ISD
         */

        private int id;
        private String hubName;
        private int isPickup;
        private int isDelivery;
        private int isSorting;
        private int isSoho;
        private int isVirtual;
        private String status;
        private Object lat;
        private Object lon;
        private String createdAt;
        private String updatedAt;
        private int isC2cAvailable;
        private String address;
        private String phoneNumber;
        private int routeId;
        private String routeType;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getHubName() {
            return hubName;
        }

        public void setHubName(String hubName) {
            this.hubName = hubName;
        }

        public int getIsPickup() {
            return isPickup;
        }

        public void setIsPickup(int isPickup) {
            this.isPickup = isPickup;
        }

        public int getIsDelivery() {
            return isDelivery;
        }

        public void setIsDelivery(int isDelivery) {
            this.isDelivery = isDelivery;
        }

        public int getIsSorting() {
            return isSorting;
        }

        public void setIsSorting(int isSorting) {
            this.isSorting = isSorting;
        }

        public int getIsSoho() {
            return isSoho;
        }

        public void setIsSoho(int isSoho) {
            this.isSoho = isSoho;
        }

        public int getIsVirtual() {
            return isVirtual;
        }

        public void setIsVirtual(int isVirtual) {
            this.isVirtual = isVirtual;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public Object getLat() {
            return lat;
        }

        public void setLat(Object lat) {
            this.lat = lat;
        }

        public Object getLon() {
            return lon;
        }

        public void setLon(Object lon) {
            this.lon = lon;
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

        public int getIsC2cAvailable() {
            return isC2cAvailable;
        }

        public void setIsC2cAvailable(int isC2cAvailable) {
            this.isC2cAvailable = isC2cAvailable;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public int getRouteId() {
            return routeId;
        }

        public void setRouteId(int routeId) {
            this.routeId = routeId;
        }

        public String getRouteType() {
            return routeType;
        }

        public void setRouteType(String routeType) {
            this.routeType = routeType;
        }
    }
}
