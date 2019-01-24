package com.example.pchrp.newdashboard.Dao;



public class TestDao {

    public String Sj(){
        String JSON = "{\"pax\":110,\"cashPayments\":125783,\"creditPayments\":512747" +
                ",\"creditCardPayments\":1651255,\"memberDebitPayments\":268764,\"entertainPayments\"" +
                ":6763,\"income\":2565312,\"unpaid\":0,\"receipts\":0,\"revenue\":2289785,\"" +
                "totalServiceCharge\":546,\"incomeByCreditCardList\":[],\"invoice\":null,\"" +
                "memberNew\":0,\"memberRenew\":0,\"summaryUseProductList\":[],\"summaryOrderFoodList\"" +
                ":null,\"summaryServiceDrinkList\":null,\"serivceDrinkCharge\":1399920,\"" +
                "serviceDringQty\":3680,\"foodPrice\":106206,\"serviceCharge\":99650,\"" +
                "productPrice\":8990,\"memberCharge\":950000,\"openMemberAccount\":29,\"" +
                "openNewMemberAccount\":11,\"openRenewMemberAccount\":18}";
        return JSON;
    }

    public String jj(){
        /*String JSON = "{\"pax\":110,\"cashPayments\":125783,\"creditPayments\":512747" +
                ",\"creditCardPayments\":1651255,\"memberDebitPayments\":268764,\"entertainPayments\"" +
                ":6763,\"income\":2565312,\"unpaid\":0,\"receipts\":0,\"revenue\":2289785,\"" +
                "totalServiceCharge\":546,\"incomeByCreditCardList\":[],\"invoice\":null,\"" +
                "memberNew\":0,\"memberRenew\":0,\"summaryUseProductList\":[],\"summaryOrderFoodList\"" +
                ":null,\"summaryServiceDrinkList\":null,\"serivceDrinkCharge\":1399920,\"" +
                "serviceDringQty\":3680,\"foodPrice\":106206,\"serviceCharge\":99650,\"" +
                "productPrice\":8990,\"memberCharge\":950000,\"openMemberAccount\":29,\"" +
                "openNewMemberAccount\":11,\"openRenewMemberAccount\":18}";
          */
        String JSON = "{\n" +
                "    \"statusCode\": 200,\n" +
                "    \"message\": \"success\",\n" +
                "    \"object\": {\n" +
                "        \"pax\": 110,\n" +
                "        \"cashPayments\": 125783,\n" +
                "        \"creditPayments\": 512747,\n" +
                "        \"creditCardPayments\": 1651255,\n" +
                "        \"memberDebitPayments\": 268764,\n" +
                "        \"entertainPayments\": 6763,\n" +
                "        \"income\": 2565312,\n" +
                "        \"unpaid\": 0,\n" +
                "        \"receipts\": 0,\n" +
                "        \"revenue\": 2289785,\n" +
                "        \"totalServiceCharge\": 546,\n" +
                "        \"incomeByCreditCardList\": [\n" +
                "            {\n" +
                "                \"bank\": {\n" +
                "                    \"recorder\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 1,\n" +
                "                        \"userType\": null,\n" +
                "                        \"authentication\": null,\n" +
                "                        \"permissionGroup\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"createDate\": 1543525993000,\n" +
                "                    \"editor\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 1,\n" +
                "                        \"userType\": null,\n" +
                "                        \"authentication\": null,\n" +
                "                        \"permissionGroup\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"lastUpdate\": 1546428511000,\n" +
                "                    \"id\": 1,\n" +
                "                    \"bankName\": \"ธนาคารธนชาต (T-BANK)\",\n" +
                "                    \"image\": null,\n" +
                "                    \"active\": true,\n" +
                "                    \"deleted\": false\n" +
                "                },\n" +
                "                \"visa\": 974377,\n" +
                "                \"master\": 119601,\n" +
                "                \"jcb\": 0,\n" +
                "                \"amax\": 0,\n" +
                "                \"unipay\": 0\n" +
                "            },\n" +
                "            {\n" +
                "                \"bank\": {\n" +
                "                    \"recorder\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 1,\n" +
                "                        \"userType\": null,\n" +
                "                        \"authentication\": null,\n" +
                "                        \"permissionGroup\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"createDate\": 1543526013000,\n" +
                "                    \"editor\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 1,\n" +
                "                        \"userType\": null,\n" +
                "                        \"authentication\": null,\n" +
                "                        \"permissionGroup\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"lastUpdate\": 1543526097000,\n" +
                "                    \"id\": 2,\n" +
                "                    \"bankName\": \"ธนาคารกรุงเทพ (BBL)\",\n" +
                "                    \"image\": null,\n" +
                "                    \"active\": true,\n" +
                "                    \"deleted\": false\n" +
                "                },\n" +
                "                \"visa\": 428272,\n" +
                "                \"master\": 62335,\n" +
                "                \"jcb\": 0,\n" +
                "                \"amax\": 66670,\n" +
                "                \"unipay\": 0\n" +
                "            }\n" +
                "        ],\n" +
                "        \"invoice\": null,\n" +
                "        \"memberNew\": 0,\n" +
                "        \"memberRenew\": 0,\n" +
                "        \"summaryUseProductList\": [\n" +
                "            {\n" +
                "                \"product\": {\n" +
                "                    \"recorder\": null,\n" +
                "                    \"createDate\": 1542775346000,\n" +
                "                    \"editor\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 1,\n" +
                "                        \"userType\": null,\n" +
                "                        \"authentication\": null,\n" +
                "                        \"permissionGroup\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"lastUpdate\": 1546772614000,\n" +
                "                    \"id\": 2,\n" +
                "                    \"productCode\": \"P-002\",\n" +
                "                    \"productNameTh\": \"J.W.BLACK\",\n" +
                "                    \"productNameEn\": \"J.W.BLACK\",\n" +
                "                    \"shortName\": null,\n" +
                "                    \"description\": null,\n" +
                "                    \"priceForMember\": 4000,\n" +
                "                    \"priceForNoneMember\": 4000,\n" +
                "                    \"cost\": 0,\n" +
                "                    \"discountForMember\": 0,\n" +
                "                    \"discountForNoneMember\": 0,\n" +
                "                    \"discountType\": null,\n" +
                "                    \"image\": \"http://krystalclub.tk/images/drink/2.jpg\",\n" +
                "                    \"brand\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 1,\n" +
                "                        \"brandNameTh\": null,\n" +
                "                        \"brandNameEn\": null,\n" +
                "                        \"description\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"productCategory\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 2,\n" +
                "                        \"categoryNameTh\": null,\n" +
                "                        \"categoryNameEn\": null,\n" +
                "                        \"description\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"unit\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 1,\n" +
                "                        \"unitNameTh\": null,\n" +
                "                        \"unitNameEn\": null,\n" +
                "                        \"description\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"drink\": true,\n" +
                "                    \"active\": true,\n" +
                "                    \"deleted\": false\n" +
                "                },\n" +
                "                \"withdrawUse\": 88,\n" +
                "                \"purchaseAmount\": 89,\n" +
                "                \"entertainAmount\": 1,\n" +
                "                \"totalAll\": 178\n" +
                "            },\n" +
                "            {\n" +
                "                \"product\": {\n" +
                "                    \"recorder\": null,\n" +
                "                    \"createDate\": 1542775346000,\n" +
                "                    \"editor\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 4181,\n" +
                "                        \"userType\": null,\n" +
                "                        \"authentication\": null,\n" +
                "                        \"permissionGroup\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"lastUpdate\": 1546772616000,\n" +
                "                    \"id\": 3,\n" +
                "                    \"productCode\": \"P-003\",\n" +
                "                    \"productNameTh\": \"J.W. GOLD RESERVE\",\n" +
                "                    \"productNameEn\": \"J.W. GOLD RESERVE\",\n" +
                "                    \"shortName\": null,\n" +
                "                    \"description\": null,\n" +
                "                    \"priceForMember\": 6000,\n" +
                "                    \"priceForNoneMember\": 6000,\n" +
                "                    \"cost\": 0,\n" +
                "                    \"discountForMember\": 0,\n" +
                "                    \"discountForNoneMember\": 0,\n" +
                "                    \"discountType\": null,\n" +
                "                    \"image\": \"http://krystalclub.tk/images/drink/3.jpg\",\n" +
                "                    \"brand\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 1,\n" +
                "                        \"brandNameTh\": null,\n" +
                "                        \"brandNameEn\": null,\n" +
                "                        \"description\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"productCategory\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 2,\n" +
                "                        \"categoryNameTh\": null,\n" +
                "                        \"categoryNameEn\": null,\n" +
                "                        \"description\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"unit\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 1,\n" +
                "                        \"unitNameTh\": null,\n" +
                "                        \"unitNameEn\": null,\n" +
                "                        \"description\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"drink\": true,\n" +
                "                    \"active\": true,\n" +
                "                    \"deleted\": false\n" +
                "                },\n" +
                "                \"withdrawUse\": 40,\n" +
                "                \"purchaseAmount\": 41,\n" +
                "                \"entertainAmount\": 1,\n" +
                "                \"totalAll\": 82\n" +
                "            },\n" +
                "            {\n" +
                "                \"product\": {\n" +
                "                    \"recorder\": null,\n" +
                "                    \"createDate\": 1542775346000,\n" +
                "                    \"editor\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 4181,\n" +
                "                        \"userType\": null,\n" +
                "                        \"authentication\": null,\n" +
                "                        \"permissionGroup\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"lastUpdate\": 1546772617000,\n" +
                "                    \"id\": 4,\n" +
                "                    \"productCode\": \"P-004\",\n" +
                "                    \"productNameTh\": \"J.W. BLUE LABEL\",\n" +
                "                    \"productNameEn\": \"J.W. BLUE LABEL\",\n" +
                "                    \"shortName\": \"J.W. BLUE LABEL\",\n" +
                "                    \"description\": null,\n" +
                "                    \"priceForMember\": 20000,\n" +
                "                    \"priceForNoneMember\": 20000,\n" +
                "                    \"cost\": 0,\n" +
                "                    \"discountForMember\": 0,\n" +
                "                    \"discountForNoneMember\": 0,\n" +
                "                    \"discountType\": null,\n" +
                "                    \"image\": \"http://krystalclub.tk/images/drink/4.jpg\",\n" +
                "                    \"brand\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 2,\n" +
                "                        \"brandNameTh\": null,\n" +
                "                        \"brandNameEn\": null,\n" +
                "                        \"description\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"productCategory\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 2,\n" +
                "                        \"categoryNameTh\": null,\n" +
                "                        \"categoryNameEn\": null,\n" +
                "                        \"description\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"unit\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 1,\n" +
                "                        \"unitNameTh\": null,\n" +
                "                        \"unitNameEn\": null,\n" +
                "                        \"description\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"drink\": true,\n" +
                "                    \"active\": true,\n" +
                "                    \"deleted\": false\n" +
                "                },\n" +
                "                \"withdrawUse\": 2,\n" +
                "                \"purchaseAmount\": 2,\n" +
                "                \"entertainAmount\": 0,\n" +
                "                \"totalAll\": 4\n" +
                "            },\n" +
                "            {\n" +
                "                \"product\": {\n" +
                "                    \"recorder\": null,\n" +
                "                    \"createDate\": 1542775346000,\n" +
                "                    \"editor\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 1,\n" +
                "                        \"userType\": null,\n" +
                "                        \"authentication\": null,\n" +
                "                        \"permissionGroup\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"lastUpdate\": 1546772624000,\n" +
                "                    \"id\": 8,\n" +
                "                    \"productCode\": \"P-008\",\n" +
                "                    \"productNameTh\": \"HENNESSY VSOP.\",\n" +
                "                    \"productNameEn\": \"HENNESSY VSOP.\",\n" +
                "                    \"shortName\": null,\n" +
                "                    \"description\": null,\n" +
                "                    \"priceForMember\": 7000,\n" +
                "                    \"priceForNoneMember\": 7000,\n" +
                "                    \"cost\": 0,\n" +
                "                    \"discountForMember\": 0,\n" +
                "                    \"discountForNoneMember\": 0,\n" +
                "                    \"discountType\": null,\n" +
                "                    \"image\": \"http://krystalclub.tk/images/drink/8.jpg\",\n" +
                "                    \"brand\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 1,\n" +
                "                        \"brandNameTh\": null,\n" +
                "                        \"brandNameEn\": null,\n" +
                "                        \"description\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"productCategory\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 2,\n" +
                "                        \"categoryNameTh\": null,\n" +
                "                        \"categoryNameEn\": null,\n" +
                "                        \"description\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"unit\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 1,\n" +
                "                        \"unitNameTh\": null,\n" +
                "                        \"unitNameEn\": null,\n" +
                "                        \"description\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"drink\": true,\n" +
                "                    \"active\": true,\n" +
                "                    \"deleted\": false\n" +
                "                },\n" +
                "                \"withdrawUse\": 6,\n" +
                "                \"purchaseAmount\": 6,\n" +
                "                \"entertainAmount\": 0,\n" +
                "                \"totalAll\": 12\n" +
                "            },\n" +
                "            {\n" +
                "                \"product\": {\n" +
                "                    \"recorder\": null,\n" +
                "                    \"createDate\": 1542775346000,\n" +
                "                    \"editor\": null,\n" +
                "                    \"lastUpdate\": 1546772780000,\n" +
                "                    \"id\": 77,\n" +
                "                    \"productCode\": \"P-077\",\n" +
                "                    \"productNameTh\": \"ORANGE JUICE\",\n" +
                "                    \"productNameEn\": \"ORANGE JUICE\",\n" +
                "                    \"shortName\": null,\n" +
                "                    \"description\": null,\n" +
                "                    \"priceForMember\": 420,\n" +
                "                    \"priceForNoneMember\": 420,\n" +
                "                    \"cost\": 60,\n" +
                "                    \"discountForMember\": 0,\n" +
                "                    \"discountForNoneMember\": 0,\n" +
                "                    \"discountType\": null,\n" +
                "                    \"image\": \"http://krystalclub.tk/images/drink/77.jpg\",\n" +
                "                    \"brand\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 2,\n" +
                "                        \"brandNameTh\": null,\n" +
                "                        \"brandNameEn\": null,\n" +
                "                        \"description\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"productCategory\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 7,\n" +
                "                        \"categoryNameTh\": null,\n" +
                "                        \"categoryNameEn\": null,\n" +
                "                        \"description\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"unit\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 2,\n" +
                "                        \"unitNameTh\": null,\n" +
                "                        \"unitNameEn\": null,\n" +
                "                        \"description\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"drink\": true,\n" +
                "                    \"active\": true,\n" +
                "                    \"deleted\": false\n" +
                "                },\n" +
                "                \"withdrawUse\": 0,\n" +
                "                \"purchaseAmount\": 1,\n" +
                "                \"entertainAmount\": 0,\n" +
                "                \"totalAll\": 1\n" +
                "            },\n" +
                "            {\n" +
                "                \"product\": {\n" +
                "                    \"recorder\": null,\n" +
                "                    \"createDate\": 1542775346000,\n" +
                "                    \"editor\": null,\n" +
                "                    \"lastUpdate\": 1546772637000,\n" +
                "                    \"id\": 14,\n" +
                "                    \"productCode\": \"P-014\",\n" +
                "                    \"productNameTh\": \"MARTELL  VSOP.\",\n" +
                "                    \"productNameEn\": \"MARTELL  VSOP.\",\n" +
                "                    \"shortName\": null,\n" +
                "                    \"description\": null,\n" +
                "                    \"priceForMember\": 7000,\n" +
                "                    \"priceForNoneMember\": 7000,\n" +
                "                    \"cost\": 0,\n" +
                "                    \"discountForMember\": 0,\n" +
                "                    \"discountForNoneMember\": 0,\n" +
                "                    \"discountType\": null,\n" +
                "                    \"image\": \"http://krystalclub.tk/images/drink/14.jpg\",\n" +
                "                    \"brand\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 2,\n" +
                "                        \"brandNameTh\": null,\n" +
                "                        \"brandNameEn\": null,\n" +
                "                        \"description\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"productCategory\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 2,\n" +
                "                        \"categoryNameTh\": null,\n" +
                "                        \"categoryNameEn\": null,\n" +
                "                        \"description\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"unit\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 1,\n" +
                "                        \"unitNameTh\": null,\n" +
                "                        \"unitNameEn\": null,\n" +
                "                        \"description\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"drink\": true,\n" +
                "                    \"active\": true,\n" +
                "                    \"deleted\": false\n" +
                "                },\n" +
                "                \"withdrawUse\": 2,\n" +
                "                \"purchaseAmount\": 2,\n" +
                "                \"entertainAmount\": 0,\n" +
                "                \"totalAll\": 4\n" +
                "            },\n" +
                "            {\n" +
                "                \"product\": {\n" +
                "                    \"recorder\": null,\n" +
                "                    \"createDate\": 1542775346000,\n" +
                "                    \"editor\": null,\n" +
                "                    \"lastUpdate\": 1546772782000,\n" +
                "                    \"id\": 78,\n" +
                "                    \"productCode\": \"P-078\",\n" +
                "                    \"productNameTh\": \"PINEAPPLE JUICE\",\n" +
                "                    \"productNameEn\": \"PINEAPPLE JUICE\",\n" +
                "                    \"shortName\": null,\n" +
                "                    \"description\": null,\n" +
                "                    \"priceForMember\": 420,\n" +
                "                    \"priceForNoneMember\": 420,\n" +
                "                    \"cost\": 60,\n" +
                "                    \"discountForMember\": 0,\n" +
                "                    \"discountForNoneMember\": 0,\n" +
                "                    \"discountType\": null,\n" +
                "                    \"image\": \"http://krystalclub.tk/images/drink/78.jpg\",\n" +
                "                    \"brand\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 2,\n" +
                "                        \"brandNameTh\": null,\n" +
                "                        \"brandNameEn\": null,\n" +
                "                        \"description\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"productCategory\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 7,\n" +
                "                        \"categoryNameTh\": null,\n" +
                "                        \"categoryNameEn\": null,\n" +
                "                        \"description\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"unit\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 2,\n" +
                "                        \"unitNameTh\": null,\n" +
                "                        \"unitNameEn\": null,\n" +
                "                        \"description\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"drink\": true,\n" +
                "                    \"active\": true,\n" +
                "                    \"deleted\": false\n" +
                "                },\n" +
                "                \"withdrawUse\": 0,\n" +
                "                \"purchaseAmount\": 2,\n" +
                "                \"entertainAmount\": 0,\n" +
                "                \"totalAll\": 2\n" +
                "            },\n" +
                "            {\n" +
                "                \"product\": {\n" +
                "                    \"recorder\": null,\n" +
                "                    \"createDate\": 1542775346000,\n" +
                "                    \"editor\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 4181,\n" +
                "                        \"userType\": null,\n" +
                "                        \"authentication\": null,\n" +
                "                        \"permissionGroup\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"lastUpdate\": 1546772786000,\n" +
                "                    \"id\": 82,\n" +
                "                    \"productCode\": \"P-082\",\n" +
                "                    \"productNameTh\": \"REDBULL\",\n" +
                "                    \"productNameEn\": \"REDBULL\",\n" +
                "                    \"shortName\": null,\n" +
                "                    \"description\": null,\n" +
                "                    \"priceForMember\": 150,\n" +
                "                    \"priceForNoneMember\": 150,\n" +
                "                    \"cost\": 20,\n" +
                "                    \"discountForMember\": 0,\n" +
                "                    \"discountForNoneMember\": 0,\n" +
                "                    \"discountType\": null,\n" +
                "                    \"image\": \"http://krystalclub.tk/images/drink/82.jpg\",\n" +
                "                    \"brand\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 2,\n" +
                "                        \"brandNameTh\": null,\n" +
                "                        \"brandNameEn\": null,\n" +
                "                        \"description\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"productCategory\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 8,\n" +
                "                        \"categoryNameTh\": null,\n" +
                "                        \"categoryNameEn\": null,\n" +
                "                        \"description\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"unit\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 1,\n" +
                "                        \"unitNameTh\": null,\n" +
                "                        \"unitNameEn\": null,\n" +
                "                        \"description\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"drink\": true,\n" +
                "                    \"active\": true,\n" +
                "                    \"deleted\": false\n" +
                "                },\n" +
                "                \"withdrawUse\": 0,\n" +
                "                \"purchaseAmount\": 9,\n" +
                "                \"entertainAmount\": 0,\n" +
                "                \"totalAll\": 9\n" +
                "            },\n" +
                "            {\n" +
                "                \"product\": {\n" +
                "                    \"recorder\": null,\n" +
                "                    \"createDate\": 1542775346000,\n" +
                "                    \"editor\": null,\n" +
                "                    \"lastUpdate\": 1546772787000,\n" +
                "                    \"id\": 84,\n" +
                "                    \"productCode\": \"P-084\",\n" +
                "                    \"productNameTh\": \"SODA\",\n" +
                "                    \"productNameEn\": \"SODA\",\n" +
                "                    \"shortName\": null,\n" +
                "                    \"description\": null,\n" +
                "                    \"priceForMember\": 100,\n" +
                "                    \"priceForNoneMember\": 100,\n" +
                "                    \"cost\": 20,\n" +
                "                    \"discountForMember\": 0,\n" +
                "                    \"discountForNoneMember\": 0,\n" +
                "                    \"discountType\": null,\n" +
                "                    \"image\": \"http://krystalclub.tk/images/drink/84.jpg\",\n" +
                "                    \"brand\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 2,\n" +
                "                        \"brandNameTh\": null,\n" +
                "                        \"brandNameEn\": null,\n" +
                "                        \"description\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"productCategory\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 8,\n" +
                "                        \"categoryNameTh\": null,\n" +
                "                        \"categoryNameEn\": null,\n" +
                "                        \"description\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"unit\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 1,\n" +
                "                        \"unitNameTh\": null,\n" +
                "                        \"unitNameEn\": null,\n" +
                "                        \"description\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"drink\": true,\n" +
                "                    \"active\": true,\n" +
                "                    \"deleted\": false\n" +
                "                },\n" +
                "                \"withdrawUse\": 0,\n" +
                "                \"purchaseAmount\": 13,\n" +
                "                \"entertainAmount\": 0,\n" +
                "                \"totalAll\": 13\n" +
                "            },\n" +
                "            {\n" +
                "                \"product\": {\n" +
                "                    \"recorder\": null,\n" +
                "                    \"createDate\": 1542775346000,\n" +
                "                    \"editor\": null,\n" +
                "                    \"lastUpdate\": 1546772788000,\n" +
                "                    \"id\": 85,\n" +
                "                    \"productCode\": \"P-085\",\n" +
                "                    \"productNameTh\": \"WATER\",\n" +
                "                    \"productNameEn\": \"WATER\",\n" +
                "                    \"shortName\": null,\n" +
                "                    \"description\": null,\n" +
                "                    \"priceForMember\": 100,\n" +
                "                    \"priceForNoneMember\": 100,\n" +
                "                    \"cost\": 20,\n" +
                "                    \"discountForMember\": 0,\n" +
                "                    \"discountForNoneMember\": 0,\n" +
                "                    \"discountType\": null,\n" +
                "                    \"image\": \"http://krystalclub.tk/images/drink/85.jpg\",\n" +
                "                    \"brand\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 2,\n" +
                "                        \"brandNameTh\": null,\n" +
                "                        \"brandNameEn\": null,\n" +
                "                        \"description\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"productCategory\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 8,\n" +
                "                        \"categoryNameTh\": null,\n" +
                "                        \"categoryNameEn\": null,\n" +
                "                        \"description\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"unit\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 1,\n" +
                "                        \"unitNameTh\": null,\n" +
                "                        \"unitNameEn\": null,\n" +
                "                        \"description\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"drink\": true,\n" +
                "                    \"active\": true,\n" +
                "                    \"deleted\": false\n" +
                "                },\n" +
                "                \"withdrawUse\": 0,\n" +
                "                \"purchaseAmount\": 15,\n" +
                "                \"entertainAmount\": 0,\n" +
                "                \"totalAll\": 15\n" +
                "            },\n" +
                "            {\n" +
                "                \"product\": {\n" +
                "                    \"recorder\": null,\n" +
                "                    \"createDate\": 1542775346000,\n" +
                "                    \"editor\": null,\n" +
                "                    \"lastUpdate\": 1546772647000,\n" +
                "                    \"id\": 21,\n" +
                "                    \"productCode\": \"P-021\",\n" +
                "                    \"productNameTh\": \"CHIVAS 12Y\",\n" +
                "                    \"productNameEn\": \"CHIVAS 12Y\",\n" +
                "                    \"shortName\": null,\n" +
                "                    \"description\": null,\n" +
                "                    \"priceForMember\": 5500,\n" +
                "                    \"priceForNoneMember\": 5500,\n" +
                "                    \"cost\": 0,\n" +
                "                    \"discountForMember\": 0,\n" +
                "                    \"discountForNoneMember\": 0,\n" +
                "                    \"discountType\": null,\n" +
                "                    \"image\": \"http://krystalclub.tk/images/drink/21.jpg\",\n" +
                "                    \"brand\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 2,\n" +
                "                        \"brandNameTh\": null,\n" +
                "                        \"brandNameEn\": null,\n" +
                "                        \"description\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"productCategory\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 2,\n" +
                "                        \"categoryNameTh\": null,\n" +
                "                        \"categoryNameEn\": null,\n" +
                "                        \"description\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"unit\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 1,\n" +
                "                        \"unitNameTh\": null,\n" +
                "                        \"unitNameEn\": null,\n" +
                "                        \"description\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"drink\": true,\n" +
                "                    \"active\": true,\n" +
                "                    \"deleted\": false\n" +
                "                },\n" +
                "                \"withdrawUse\": 3,\n" +
                "                \"purchaseAmount\": 3,\n" +
                "                \"entertainAmount\": 0,\n" +
                "                \"totalAll\": 6\n" +
                "            },\n" +
                "            {\n" +
                "                \"product\": {\n" +
                "                    \"recorder\": null,\n" +
                "                    \"createDate\": 1542775346000,\n" +
                "                    \"editor\": null,\n" +
                "                    \"lastUpdate\": 1546772789000,\n" +
                "                    \"id\": 86,\n" +
                "                    \"productCode\": \"P-086\",\n" +
                "                    \"productNameTh\": \"COKE\",\n" +
                "                    \"productNameEn\": \"COKE\",\n" +
                "                    \"shortName\": null,\n" +
                "                    \"description\": null,\n" +
                "                    \"priceForMember\": 100,\n" +
                "                    \"priceForNoneMember\": 100,\n" +
                "                    \"cost\": 20,\n" +
                "                    \"discountForMember\": 0,\n" +
                "                    \"discountForNoneMember\": 0,\n" +
                "                    \"discountType\": null,\n" +
                "                    \"image\": \"http://krystalclub.tk/images/drink/86.jpg\",\n" +
                "                    \"brand\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 2,\n" +
                "                        \"brandNameTh\": null,\n" +
                "                        \"brandNameEn\": null,\n" +
                "                        \"description\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"productCategory\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 8,\n" +
                "                        \"categoryNameTh\": null,\n" +
                "                        \"categoryNameEn\": null,\n" +
                "                        \"description\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"unit\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 1,\n" +
                "                        \"unitNameTh\": null,\n" +
                "                        \"unitNameEn\": null,\n" +
                "                        \"description\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"drink\": true,\n" +
                "                    \"active\": true,\n" +
                "                    \"deleted\": false\n" +
                "                },\n" +
                "                \"withdrawUse\": 0,\n" +
                "                \"purchaseAmount\": 11,\n" +
                "                \"entertainAmount\": 0,\n" +
                "                \"totalAll\": 11\n" +
                "            },\n" +
                "            {\n" +
                "                \"product\": {\n" +
                "                    \"recorder\": null,\n" +
                "                    \"createDate\": 1542775346000,\n" +
                "                    \"editor\": null,\n" +
                "                    \"lastUpdate\": 1546772790000,\n" +
                "                    \"id\": 87,\n" +
                "                    \"productCode\": \"P-087\",\n" +
                "                    \"productNameTh\": \"ROCK ICE\",\n" +
                "                    \"productNameEn\": \"ROCK ICE\",\n" +
                "                    \"shortName\": null,\n" +
                "                    \"description\": null,\n" +
                "                    \"priceForMember\": 100,\n" +
                "                    \"priceForNoneMember\": 100,\n" +
                "                    \"cost\": 20,\n" +
                "                    \"discountForMember\": 0,\n" +
                "                    \"discountForNoneMember\": 0,\n" +
                "                    \"discountType\": null,\n" +
                "                    \"image\": \"http://krystalclub.tk/images/drink/87.jpg\",\n" +
                "                    \"brand\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 2,\n" +
                "                        \"brandNameTh\": null,\n" +
                "                        \"brandNameEn\": null,\n" +
                "                        \"description\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"productCategory\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 8,\n" +
                "                        \"categoryNameTh\": null,\n" +
                "                        \"categoryNameEn\": null,\n" +
                "                        \"description\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"unit\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 4,\n" +
                "                        \"unitNameTh\": null,\n" +
                "                        \"unitNameEn\": null,\n" +
                "                        \"description\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"drink\": true,\n" +
                "                    \"active\": true,\n" +
                "                    \"deleted\": false\n" +
                "                },\n" +
                "                \"withdrawUse\": 0,\n" +
                "                \"purchaseAmount\": 5,\n" +
                "                \"entertainAmount\": 0,\n" +
                "                \"totalAll\": 5\n" +
                "            },\n" +
                "            {\n" +
                "                \"product\": {\n" +
                "                    \"recorder\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 1,\n" +
                "                        \"userType\": null,\n" +
                "                        \"authentication\": null,\n" +
                "                        \"permissionGroup\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"createDate\": 1543531432000,\n" +
                "                    \"editor\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 4187,\n" +
                "                        \"userType\": null,\n" +
                "                        \"authentication\": null,\n" +
                "                        \"permissionGroup\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"lastUpdate\": 1546874005000,\n" +
                "                    \"id\": 88,\n" +
                "                    \"productCode\": \"P-088\",\n" +
                "                    \"productNameTh\": \"Marlbolo Arctic Black\",\n" +
                "                    \"productNameEn\": \"Marlbolo Arctic Black\",\n" +
                "                    \"shortName\": \"Marlbolo Arctic Black\",\n" +
                "                    \"description\": null,\n" +
                "                    \"priceForMember\": 220,\n" +
                "                    \"priceForNoneMember\": 220,\n" +
                "                    \"cost\": 0,\n" +
                "                    \"discountForMember\": 0,\n" +
                "                    \"discountForNoneMember\": 0,\n" +
                "                    \"discountType\": null,\n" +
                "                    \"image\": \"http://krystalclub.tk/images/drink/88.jpg\",\n" +
                "                    \"brand\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 2,\n" +
                "                        \"brandNameTh\": null,\n" +
                "                        \"brandNameEn\": null,\n" +
                "                        \"description\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"productCategory\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 1,\n" +
                "                        \"categoryNameTh\": null,\n" +
                "                        \"categoryNameEn\": null,\n" +
                "                        \"description\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"unit\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 5,\n" +
                "                        \"unitNameTh\": null,\n" +
                "                        \"unitNameEn\": null,\n" +
                "                        \"description\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"drink\": false,\n" +
                "                    \"active\": true,\n" +
                "                    \"deleted\": false\n" +
                "                },\n" +
                "                \"withdrawUse\": 0,\n" +
                "                \"purchaseAmount\": 4,\n" +
                "                \"entertainAmount\": 0,\n" +
                "                \"totalAll\": 4\n" +
                "            },\n" +
                "            {\n" +
                "                \"product\": {\n" +
                "                    \"recorder\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 1,\n" +
                "                        \"userType\": null,\n" +
                "                        \"authentication\": null,\n" +
                "                        \"permissionGroup\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"createDate\": 1543736153000,\n" +
                "                    \"editor\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 1,\n" +
                "                        \"userType\": null,\n" +
                "                        \"authentication\": null,\n" +
                "                        \"permissionGroup\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"lastUpdate\": 1546772791000,\n" +
                "                    \"id\": 89,\n" +
                "                    \"productCode\": \"P-089\",\n" +
                "                    \"productNameTh\": \"Regency\",\n" +
                "                    \"productNameEn\": \"Regency\",\n" +
                "                    \"shortName\": \"Regency\",\n" +
                "                    \"description\": \"Regency\",\n" +
                "                    \"priceForMember\": 0,\n" +
                "                    \"priceForNoneMember\": 0,\n" +
                "                    \"cost\": 0,\n" +
                "                    \"discountForMember\": 0,\n" +
                "                    \"discountForNoneMember\": 0,\n" +
                "                    \"discountType\": null,\n" +
                "                    \"image\": \"http://krystalclub.tk/images/drink/89.jpg\",\n" +
                "                    \"brand\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 2,\n" +
                "                        \"brandNameTh\": null,\n" +
                "                        \"brandNameEn\": null,\n" +
                "                        \"description\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"productCategory\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 2,\n" +
                "                        \"categoryNameTh\": null,\n" +
                "                        \"categoryNameEn\": null,\n" +
                "                        \"description\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"unit\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 1,\n" +
                "                        \"unitNameTh\": null,\n" +
                "                        \"unitNameEn\": null,\n" +
                "                        \"description\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"drink\": true,\n" +
                "                    \"active\": true,\n" +
                "                    \"deleted\": false\n" +
                "                },\n" +
                "                \"withdrawUse\": 2,\n" +
                "                \"purchaseAmount\": 2,\n" +
                "                \"entertainAmount\": 0,\n" +
                "                \"totalAll\": 4\n" +
                "            },\n" +
                "            {\n" +
                "                \"product\": {\n" +
                "                    \"recorder\": null,\n" +
                "                    \"createDate\": 1542775346000,\n" +
                "                    \"editor\": null,\n" +
                "                    \"lastUpdate\": 1546772659000,\n" +
                "                    \"id\": 29,\n" +
                "                    \"productCode\": \"P-029\",\n" +
                "                    \"productNameTh\": \"BELVE DERE VODKA \",\n" +
                "                    \"productNameEn\": \"BELVE DERE VODKA \",\n" +
                "                    \"shortName\": null,\n" +
                "                    \"description\": null,\n" +
                "                    \"priceForMember\": 5000,\n" +
                "                    \"priceForNoneMember\": 5000,\n" +
                "                    \"cost\": 0,\n" +
                "                    \"discountForMember\": 0,\n" +
                "                    \"discountForNoneMember\": 0,\n" +
                "                    \"discountType\": null,\n" +
                "                    \"image\": \"http://krystalclub.tk/images/drink/29.jpg\",\n" +
                "                    \"brand\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 1,\n" +
                "                        \"brandNameTh\": null,\n" +
                "                        \"brandNameEn\": null,\n" +
                "                        \"description\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"productCategory\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 3,\n" +
                "                        \"categoryNameTh\": null,\n" +
                "                        \"categoryNameEn\": null,\n" +
                "                        \"description\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"unit\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 1,\n" +
                "                        \"unitNameTh\": null,\n" +
                "                        \"unitNameEn\": null,\n" +
                "                        \"description\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"drink\": true,\n" +
                "                    \"active\": true,\n" +
                "                    \"deleted\": false\n" +
                "                },\n" +
                "                \"withdrawUse\": 1,\n" +
                "                \"purchaseAmount\": 1,\n" +
                "                \"entertainAmount\": 0,\n" +
                "                \"totalAll\": 2\n" +
                "            },\n" +
                "            {\n" +
                "                \"product\": {\n" +
                "                    \"recorder\": null,\n" +
                "                    \"createDate\": 1542775346000,\n" +
                "                    \"editor\": null,\n" +
                "                    \"lastUpdate\": 1546772662000,\n" +
                "                    \"id\": 31,\n" +
                "                    \"productCode\": \"P-031\",\n" +
                "                    \"productNameTh\": \"ABSOLUTE VODKA\",\n" +
                "                    \"productNameEn\": \"ABSOLUTE VODKA\",\n" +
                "                    \"shortName\": null,\n" +
                "                    \"description\": null,\n" +
                "                    \"priceForMember\": 3500,\n" +
                "                    \"priceForNoneMember\": 3500,\n" +
                "                    \"cost\": 0,\n" +
                "                    \"discountForMember\": 0,\n" +
                "                    \"discountForNoneMember\": 0,\n" +
                "                    \"discountType\": null,\n" +
                "                    \"image\": \"http://krystalclub.tk/images/drink/31.jpg\",\n" +
                "                    \"brand\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 2,\n" +
                "                        \"brandNameTh\": null,\n" +
                "                        \"brandNameEn\": null,\n" +
                "                        \"description\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"productCategory\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 3,\n" +
                "                        \"categoryNameTh\": null,\n" +
                "                        \"categoryNameEn\": null,\n" +
                "                        \"description\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"unit\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 1,\n" +
                "                        \"unitNameTh\": null,\n" +
                "                        \"unitNameEn\": null,\n" +
                "                        \"description\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"drink\": true,\n" +
                "                    \"active\": true,\n" +
                "                    \"deleted\": false\n" +
                "                },\n" +
                "                \"withdrawUse\": 1,\n" +
                "                \"purchaseAmount\": 1,\n" +
                "                \"entertainAmount\": 0,\n" +
                "                \"totalAll\": 2\n" +
                "            },\n" +
                "            {\n" +
                "                \"product\": {\n" +
                "                    \"recorder\": null,\n" +
                "                    \"createDate\": 1542775346000,\n" +
                "                    \"editor\": null,\n" +
                "                    \"lastUpdate\": 1546772664000,\n" +
                "                    \"id\": 32,\n" +
                "                    \"productCode\": \"P-032\",\n" +
                "                    \"productNameTh\": \"ABSOLUTE VODKA RASBERRY\",\n" +
                "                    \"productNameEn\": \"ABSOLUTE VODKA RASBERRY\",\n" +
                "                    \"shortName\": null,\n" +
                "                    \"description\": null,\n" +
                "                    \"priceForMember\": 3500,\n" +
                "                    \"priceForNoneMember\": 3500,\n" +
                "                    \"cost\": 0,\n" +
                "                    \"discountForMember\": 0,\n" +
                "                    \"discountForNoneMember\": 0,\n" +
                "                    \"discountType\": null,\n" +
                "                    \"image\": \"http://krystalclub.tk/images/drink/32.jpg\",\n" +
                "                    \"brand\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 2,\n" +
                "                        \"brandNameTh\": null,\n" +
                "                        \"brandNameEn\": null,\n" +
                "                        \"description\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"productCategory\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 3,\n" +
                "                        \"categoryNameTh\": null,\n" +
                "                        \"categoryNameEn\": null,\n" +
                "                        \"description\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"unit\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 1,\n" +
                "                        \"unitNameTh\": null,\n" +
                "                        \"unitNameEn\": null,\n" +
                "                        \"description\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"drink\": true,\n" +
                "                    \"active\": true,\n" +
                "                    \"deleted\": false\n" +
                "                },\n" +
                "                \"withdrawUse\": 2,\n" +
                "                \"purchaseAmount\": 2,\n" +
                "                \"entertainAmount\": 0,\n" +
                "                \"totalAll\": 4\n" +
                "            },\n" +
                "            {\n" +
                "                \"product\": {\n" +
                "                    \"recorder\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 4187,\n" +
                "                        \"userType\": null,\n" +
                "                        \"authentication\": null,\n" +
                "                        \"permissionGroup\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"createDate\": 1546791371000,\n" +
                "                    \"editor\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 4187,\n" +
                "                        \"userType\": null,\n" +
                "                        \"authentication\": null,\n" +
                "                        \"permissionGroup\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"lastUpdate\": 1546791712000,\n" +
                "                    \"id\": 100,\n" +
                "                    \"productCode\": \"P-091\",\n" +
                "                    \"productNameTh\": \"J.W.SWING\",\n" +
                "                    \"productNameEn\": \"J.W.SWING\",\n" +
                "                    \"shortName\": \"J.W.SWING\",\n" +
                "                    \"description\": \"J.W.SWING\",\n" +
                "                    \"priceForMember\": 6000,\n" +
                "                    \"priceForNoneMember\": 6000,\n" +
                "                    \"cost\": 0,\n" +
                "                    \"discountForMember\": 0,\n" +
                "                    \"discountForNoneMember\": 0,\n" +
                "                    \"discountType\": null,\n" +
                "                    \"image\": \"http://krystalclub.tk/images/drink/100.png\",\n" +
                "                    \"brand\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 2,\n" +
                "                        \"brandNameTh\": null,\n" +
                "                        \"brandNameEn\": null,\n" +
                "                        \"description\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"productCategory\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 2,\n" +
                "                        \"categoryNameTh\": null,\n" +
                "                        \"categoryNameEn\": null,\n" +
                "                        \"description\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"unit\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 1,\n" +
                "                        \"unitNameTh\": null,\n" +
                "                        \"unitNameEn\": null,\n" +
                "                        \"description\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"drink\": true,\n" +
                "                    \"active\": true,\n" +
                "                    \"deleted\": false\n" +
                "                },\n" +
                "                \"withdrawUse\": 1,\n" +
                "                \"purchaseAmount\": 1,\n" +
                "                \"entertainAmount\": 0,\n" +
                "                \"totalAll\": 2\n" +
                "            },\n" +
                "            {\n" +
                "                \"product\": {\n" +
                "                    \"recorder\": null,\n" +
                "                    \"createDate\": 1542775346000,\n" +
                "                    \"editor\": null,\n" +
                "                    \"lastUpdate\": 1546772671000,\n" +
                "                    \"id\": 37,\n" +
                "                    \"productCode\": \"P-037\",\n" +
                "                    \"productNameTh\": \"CAPE MENTELLE CARBERNET MEROT2014\",\n" +
                "                    \"productNameEn\": \"CAPE MENTELLE CARBERNET MEROT2014\",\n" +
                "                    \"shortName\": null,\n" +
                "                    \"description\": null,\n" +
                "                    \"priceForMember\": 5000,\n" +
                "                    \"priceForNoneMember\": 5000,\n" +
                "                    \"cost\": 0,\n" +
                "                    \"discountForMember\": 0,\n" +
                "                    \"discountForNoneMember\": 0,\n" +
                "                    \"discountType\": null,\n" +
                "                    \"image\": \"http://krystalclub.tk/images/drink/37.jpg\",\n" +
                "                    \"brand\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 1,\n" +
                "                        \"brandNameTh\": null,\n" +
                "                        \"brandNameEn\": null,\n" +
                "                        \"description\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"productCategory\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 4,\n" +
                "                        \"categoryNameTh\": null,\n" +
                "                        \"categoryNameEn\": null,\n" +
                "                        \"description\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"unit\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 1,\n" +
                "                        \"unitNameTh\": null,\n" +
                "                        \"unitNameEn\": null,\n" +
                "                        \"description\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"drink\": true,\n" +
                "                    \"active\": true,\n" +
                "                    \"deleted\": false\n" +
                "                },\n" +
                "                \"withdrawUse\": 2,\n" +
                "                \"purchaseAmount\": 2,\n" +
                "                \"entertainAmount\": 0,\n" +
                "                \"totalAll\": 4\n" +
                "            },\n" +
                "            {\n" +
                "                \"product\": {\n" +
                "                    \"recorder\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 4187,\n" +
                "                        \"userType\": null,\n" +
                "                        \"authentication\": null,\n" +
                "                        \"permissionGroup\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"createDate\": 1546874073000,\n" +
                "                    \"editor\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 4187,\n" +
                "                        \"userType\": null,\n" +
                "                        \"authentication\": null,\n" +
                "                        \"permissionGroup\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"lastUpdate\": 1546875907000,\n" +
                "                    \"id\": 102,\n" +
                "                    \"productCode\": \"MBR-002\",\n" +
                "                    \"productNameTh\": \"Marlbolo Red\",\n" +
                "                    \"productNameEn\": \"Marlbolo Red\",\n" +
                "                    \"shortName\": \"Marlbolo Red\",\n" +
                "                    \"description\": null,\n" +
                "                    \"priceForMember\": 220,\n" +
                "                    \"priceForNoneMember\": 220,\n" +
                "                    \"cost\": 0,\n" +
                "                    \"discountForMember\": 0,\n" +
                "                    \"discountForNoneMember\": 0,\n" +
                "                    \"discountType\": null,\n" +
                "                    \"image\": \"http://krystalclub.tk/images/drink/102.jpg\",\n" +
                "                    \"brand\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 2,\n" +
                "                        \"brandNameTh\": null,\n" +
                "                        \"brandNameEn\": null,\n" +
                "                        \"description\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"productCategory\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 1,\n" +
                "                        \"categoryNameTh\": null,\n" +
                "                        \"categoryNameEn\": null,\n" +
                "                        \"description\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"unit\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 5,\n" +
                "                        \"unitNameTh\": null,\n" +
                "                        \"unitNameEn\": null,\n" +
                "                        \"description\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"drink\": false,\n" +
                "                    \"active\": true,\n" +
                "                    \"deleted\": false\n" +
                "                },\n" +
                "                \"withdrawUse\": 0,\n" +
                "                \"purchaseAmount\": 3,\n" +
                "                \"entertainAmount\": 0,\n" +
                "                \"totalAll\": 3\n" +
                "            },\n" +
                "            {\n" +
                "                \"product\": {\n" +
                "                    \"recorder\": null,\n" +
                "                    \"createDate\": 1542775346000,\n" +
                "                    \"editor\": null,\n" +
                "                    \"lastUpdate\": 1546772673000,\n" +
                "                    \"id\": 38,\n" +
                "                    \"productCode\": \"P-038\",\n" +
                "                    \"productNameTh\": \"ALTOS DE PLATA CARBERNET SAUVINGON\",\n" +
                "                    \"productNameEn\": \"ALTOS DE PLATA CARBERNET SAUVINGON\",\n" +
                "                    \"shortName\": null,\n" +
                "                    \"description\": null,\n" +
                "                    \"priceForMember\": 3500,\n" +
                "                    \"priceForNoneMember\": 3500,\n" +
                "                    \"cost\": 0,\n" +
                "                    \"discountForMember\": 0,\n" +
                "                    \"discountForNoneMember\": 0,\n" +
                "                    \"discountType\": null,\n" +
                "                    \"image\": \"http://krystalclub.tk/images/drink/38.jpeg\",\n" +
                "                    \"brand\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 1,\n" +
                "                        \"brandNameTh\": null,\n" +
                "                        \"brandNameEn\": null,\n" +
                "                        \"description\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"productCategory\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 4,\n" +
                "                        \"categoryNameTh\": null,\n" +
                "                        \"categoryNameEn\": null,\n" +
                "                        \"description\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"unit\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 1,\n" +
                "                        \"unitNameTh\": null,\n" +
                "                        \"unitNameEn\": null,\n" +
                "                        \"description\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"drink\": true,\n" +
                "                    \"active\": true,\n" +
                "                    \"deleted\": false\n" +
                "                },\n" +
                "                \"withdrawUse\": 1,\n" +
                "                \"purchaseAmount\": 1,\n" +
                "                \"entertainAmount\": 0,\n" +
                "                \"totalAll\": 2\n" +
                "            },\n" +
                "            {\n" +
                "                \"product\": {\n" +
                "                    \"recorder\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 4187,\n" +
                "                        \"userType\": null,\n" +
                "                        \"authentication\": null,\n" +
                "                        \"permissionGroup\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"createDate\": 1546874162000,\n" +
                "                    \"editor\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 4187,\n" +
                "                        \"userType\": null,\n" +
                "                        \"authentication\": null,\n" +
                "                        \"permissionGroup\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"lastUpdate\": 1546875909000,\n" +
                "                    \"id\": 103,\n" +
                "                    \"productCode\": \"MBR-003\",\n" +
                "                    \"productNameTh\": \"Marlbolo Green\",\n" +
                "                    \"productNameEn\": \"Marlbolo Green\",\n" +
                "                    \"shortName\": \"Marlbolo Green\",\n" +
                "                    \"description\": null,\n" +
                "                    \"priceForMember\": 220,\n" +
                "                    \"priceForNoneMember\": 220,\n" +
                "                    \"cost\": 0,\n" +
                "                    \"discountForMember\": 0,\n" +
                "                    \"discountForNoneMember\": 0,\n" +
                "                    \"discountType\": null,\n" +
                "                    \"image\": \"http://krystalclub.tk/images/drink/103.jpg\",\n" +
                "                    \"brand\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 2,\n" +
                "                        \"brandNameTh\": null,\n" +
                "                        \"brandNameEn\": null,\n" +
                "                        \"description\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"productCategory\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 1,\n" +
                "                        \"categoryNameTh\": null,\n" +
                "                        \"categoryNameEn\": null,\n" +
                "                        \"description\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"unit\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 5,\n" +
                "                        \"unitNameTh\": null,\n" +
                "                        \"unitNameEn\": null,\n" +
                "                        \"description\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"drink\": false,\n" +
                "                    \"active\": true,\n" +
                "                    \"deleted\": false\n" +
                "                },\n" +
                "                \"withdrawUse\": 0,\n" +
                "                \"purchaseAmount\": 2,\n" +
                "                \"entertainAmount\": 0,\n" +
                "                \"totalAll\": 2\n" +
                "            },\n" +
                "            {\n" +
                "                \"product\": {\n" +
                "                    \"recorder\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 4187,\n" +
                "                        \"userType\": null,\n" +
                "                        \"authentication\": null,\n" +
                "                        \"permissionGroup\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"createDate\": 1546874390000,\n" +
                "                    \"editor\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 4187,\n" +
                "                        \"userType\": null,\n" +
                "                        \"authentication\": null,\n" +
                "                        \"permissionGroup\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"lastUpdate\": 1546875916000,\n" +
                "                    \"id\": 104,\n" +
                "                    \"productCode\": \"MBR-001\",\n" +
                "                    \"productNameTh\": \"Marlbolo Gold\",\n" +
                "                    \"productNameEn\": \"Marlbolo Gold\",\n" +
                "                    \"shortName\": \"Marlbolo Gold\",\n" +
                "                    \"description\": null,\n" +
                "                    \"priceForMember\": 220,\n" +
                "                    \"priceForNoneMember\": 220,\n" +
                "                    \"cost\": 0,\n" +
                "                    \"discountForMember\": 0,\n" +
                "                    \"discountForNoneMember\": 0,\n" +
                "                    \"discountType\": null,\n" +
                "                    \"image\": \"http://krystalclub.tk/images/drink/104.jpg\",\n" +
                "                    \"brand\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 2,\n" +
                "                        \"brandNameTh\": null,\n" +
                "                        \"brandNameEn\": null,\n" +
                "                        \"description\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"productCategory\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 1,\n" +
                "                        \"categoryNameTh\": null,\n" +
                "                        \"categoryNameEn\": null,\n" +
                "                        \"description\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"unit\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 5,\n" +
                "                        \"unitNameTh\": null,\n" +
                "                        \"unitNameEn\": null,\n" +
                "                        \"description\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"drink\": false,\n" +
                "                    \"active\": true,\n" +
                "                    \"deleted\": false\n" +
                "                },\n" +
                "                \"withdrawUse\": 0,\n" +
                "                \"purchaseAmount\": 2,\n" +
                "                \"entertainAmount\": 0,\n" +
                "                \"totalAll\": 2\n" +
                "            },\n" +
                "            {\n" +
                "                \"product\": {\n" +
                "                    \"recorder\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 4187,\n" +
                "                        \"userType\": null,\n" +
                "                        \"authentication\": null,\n" +
                "                        \"permissionGroup\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"createDate\": 1546874469000,\n" +
                "                    \"editor\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 4187,\n" +
                "                        \"userType\": null,\n" +
                "                        \"authentication\": null,\n" +
                "                        \"permissionGroup\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"lastUpdate\": 1546875920000,\n" +
                "                    \"id\": 105,\n" +
                "                    \"productCode\": \"MBR-004\",\n" +
                "                    \"productNameTh\": \"Marlbolo Cripmint\",\n" +
                "                    \"productNameEn\": \"Marlbolo Cripmint\",\n" +
                "                    \"shortName\": \"Marlbolo Cripmint\",\n" +
                "                    \"description\": null,\n" +
                "                    \"priceForMember\": 220,\n" +
                "                    \"priceForNoneMember\": 220,\n" +
                "                    \"cost\": 0,\n" +
                "                    \"discountForMember\": 0,\n" +
                "                    \"discountForNoneMember\": 0,\n" +
                "                    \"discountType\": null,\n" +
                "                    \"image\": \"http://krystalclub.tk/images/drink/105.jpg\",\n" +
                "                    \"brand\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 2,\n" +
                "                        \"brandNameTh\": null,\n" +
                "                        \"brandNameEn\": null,\n" +
                "                        \"description\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"productCategory\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 1,\n" +
                "                        \"categoryNameTh\": null,\n" +
                "                        \"categoryNameEn\": null,\n" +
                "                        \"description\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"unit\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 5,\n" +
                "                        \"unitNameTh\": null,\n" +
                "                        \"unitNameEn\": null,\n" +
                "                        \"description\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"drink\": false,\n" +
                "                    \"active\": true,\n" +
                "                    \"deleted\": false\n" +
                "                },\n" +
                "                \"withdrawUse\": 0,\n" +
                "                \"purchaseAmount\": 3,\n" +
                "                \"entertainAmount\": 0,\n" +
                "                \"totalAll\": 3\n" +
                "            },\n" +
                "            {\n" +
                "                \"product\": {\n" +
                "                    \"recorder\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 4187,\n" +
                "                        \"userType\": null,\n" +
                "                        \"authentication\": null,\n" +
                "                        \"permissionGroup\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"createDate\": 1546874556000,\n" +
                "                    \"editor\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 4187,\n" +
                "                        \"userType\": null,\n" +
                "                        \"authentication\": null,\n" +
                "                        \"permissionGroup\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"lastUpdate\": 1546875924000,\n" +
                "                    \"id\": 106,\n" +
                "                    \"productCode\": \"MBR-005\",\n" +
                "                    \"productNameTh\": \"Marlbolo Black\",\n" +
                "                    \"productNameEn\": \"Marlbolo Black\",\n" +
                "                    \"shortName\": \"Marlbolo Black\",\n" +
                "                    \"description\": null,\n" +
                "                    \"priceForMember\": 220,\n" +
                "                    \"priceForNoneMember\": 220,\n" +
                "                    \"cost\": 0,\n" +
                "                    \"discountForMember\": 0,\n" +
                "                    \"discountForNoneMember\": 0,\n" +
                "                    \"discountType\": null,\n" +
                "                    \"image\": \"http://krystalclub.tk/images/drink/106.jpg\",\n" +
                "                    \"brand\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 2,\n" +
                "                        \"brandNameTh\": null,\n" +
                "                        \"brandNameEn\": null,\n" +
                "                        \"description\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"productCategory\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 1,\n" +
                "                        \"categoryNameTh\": null,\n" +
                "                        \"categoryNameEn\": null,\n" +
                "                        \"description\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"unit\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 5,\n" +
                "                        \"unitNameTh\": null,\n" +
                "                        \"unitNameEn\": null,\n" +
                "                        \"description\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"drink\": false,\n" +
                "                    \"active\": true,\n" +
                "                    \"deleted\": false\n" +
                "                },\n" +
                "                \"withdrawUse\": 0,\n" +
                "                \"purchaseAmount\": 7,\n" +
                "                \"entertainAmount\": 0,\n" +
                "                \"totalAll\": 7\n" +
                "            },\n" +
                "            {\n" +
                "                \"product\": {\n" +
                "                    \"recorder\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 4187,\n" +
                "                        \"userType\": null,\n" +
                "                        \"authentication\": null,\n" +
                "                        \"permissionGroup\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"createDate\": 1546886996000,\n" +
                "                    \"editor\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 4187,\n" +
                "                        \"userType\": null,\n" +
                "                        \"authentication\": null,\n" +
                "                        \"permissionGroup\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"lastUpdate\": 1546887239000,\n" +
                "                    \"id\": 109,\n" +
                "                    \"productCode\": \"P-095\",\n" +
                "                    \"productNameTh\": \"Sprite\",\n" +
                "                    \"productNameEn\": \"Sprite\",\n" +
                "                    \"shortName\": \"Sprite\",\n" +
                "                    \"description\": null,\n" +
                "                    \"priceForMember\": 100,\n" +
                "                    \"priceForNoneMember\": 100,\n" +
                "                    \"cost\": 0,\n" +
                "                    \"discountForMember\": 0,\n" +
                "                    \"discountForNoneMember\": 0,\n" +
                "                    \"discountType\": null,\n" +
                "                    \"image\": \"http://krystalclub.tk/images/drink/109.jpg\",\n" +
                "                    \"brand\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 2,\n" +
                "                        \"brandNameTh\": null,\n" +
                "                        \"brandNameEn\": null,\n" +
                "                        \"description\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"productCategory\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 8,\n" +
                "                        \"categoryNameTh\": null,\n" +
                "                        \"categoryNameEn\": null,\n" +
                "                        \"description\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"unit\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 1,\n" +
                "                        \"unitNameTh\": null,\n" +
                "                        \"unitNameEn\": null,\n" +
                "                        \"description\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"drink\": true,\n" +
                "                    \"active\": true,\n" +
                "                    \"deleted\": false\n" +
                "                },\n" +
                "                \"withdrawUse\": 0,\n" +
                "                \"purchaseAmount\": 13,\n" +
                "                \"entertainAmount\": 0,\n" +
                "                \"totalAll\": 13\n" +
                "            },\n" +
                "            {\n" +
                "                \"product\": {\n" +
                "                    \"recorder\": null,\n" +
                "                    \"createDate\": 1542775346000,\n" +
                "                    \"editor\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 4187,\n" +
                "                        \"userType\": null,\n" +
                "                        \"authentication\": null,\n" +
                "                        \"permissionGroup\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"lastUpdate\": 1546880239000,\n" +
                "                    \"id\": 48,\n" +
                "                    \"productCode\": \"P-048\",\n" +
                "                    \"productNameTh\": \"HINEKEN BEER\",\n" +
                "                    \"productNameEn\": \"HINEKEN BEER\",\n" +
                "                    \"shortName\": null,\n" +
                "                    \"description\": null,\n" +
                "                    \"priceForMember\": 380,\n" +
                "                    \"priceForNoneMember\": 420,\n" +
                "                    \"cost\": 60,\n" +
                "                    \"discountForMember\": 0,\n" +
                "                    \"discountForNoneMember\": 0,\n" +
                "                    \"discountType\": null,\n" +
                "                    \"image\": \"http://krystalclub.tk/images/drink/48.jpg\",\n" +
                "                    \"brand\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 2,\n" +
                "                        \"brandNameTh\": null,\n" +
                "                        \"brandNameEn\": null,\n" +
                "                        \"description\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"productCategory\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 5,\n" +
                "                        \"categoryNameTh\": null,\n" +
                "                        \"categoryNameEn\": null,\n" +
                "                        \"description\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"unit\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 1,\n" +
                "                        \"unitNameTh\": null,\n" +
                "                        \"unitNameEn\": null,\n" +
                "                        \"description\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"drink\": true,\n" +
                "                    \"active\": true,\n" +
                "                    \"deleted\": false\n" +
                "                },\n" +
                "                \"withdrawUse\": 0,\n" +
                "                \"purchaseAmount\": 29,\n" +
                "                \"entertainAmount\": 0,\n" +
                "                \"totalAll\": 29\n" +
                "            },\n" +
                "            {\n" +
                "                \"product\": {\n" +
                "                    \"recorder\": null,\n" +
                "                    \"createDate\": 1542775346000,\n" +
                "                    \"editor\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 4187,\n" +
                "                        \"userType\": null,\n" +
                "                        \"authentication\": null,\n" +
                "                        \"permissionGroup\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"lastUpdate\": 1546880227000,\n" +
                "                    \"id\": 49,\n" +
                "                    \"productCode\": \"P-049\",\n" +
                "                    \"productNameTh\": \"SINGHA BEER\",\n" +
                "                    \"productNameEn\": \"SINGHA BEER\",\n" +
                "                    \"shortName\": null,\n" +
                "                    \"description\": null,\n" +
                "                    \"priceForMember\": 380,\n" +
                "                    \"priceForNoneMember\": 420,\n" +
                "                    \"cost\": 60,\n" +
                "                    \"discountForMember\": 0,\n" +
                "                    \"discountForNoneMember\": 0,\n" +
                "                    \"discountType\": null,\n" +
                "                    \"image\": \"http://krystalclub.tk/images/drink/49.jpg\",\n" +
                "                    \"brand\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 2,\n" +
                "                        \"brandNameTh\": null,\n" +
                "                        \"brandNameEn\": null,\n" +
                "                        \"description\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"productCategory\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 5,\n" +
                "                        \"categoryNameTh\": null,\n" +
                "                        \"categoryNameEn\": null,\n" +
                "                        \"description\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"unit\": {\n" +
                "                        \"recorder\": null,\n" +
                "                        \"createDate\": null,\n" +
                "                        \"editor\": null,\n" +
                "                        \"lastUpdate\": null,\n" +
                "                        \"id\": 1,\n" +
                "                        \"unitNameTh\": null,\n" +
                "                        \"unitNameEn\": null,\n" +
                "                        \"description\": null,\n" +
                "                        \"active\": null,\n" +
                "                        \"deleted\": null\n" +
                "                    },\n" +
                "                    \"drink\": true,\n" +
                "                    \"active\": true,\n" +
                "                    \"deleted\": false\n" +
                "                },\n" +
                "                \"withdrawUse\": 0,\n" +
                "                \"purchaseAmount\": 3,\n" +
                "                \"entertainAmount\": 3,\n" +
                "                \"totalAll\": 6\n" +
                "            }\n" +
                "        ],\n" +
                "        \"summaryOrderFoodList\": null,\n" +
                "        \"summaryServiceDrinkList\": null,\n" +
                "        \"serivceDrinkCharge\": 1399920,\n" +
                "        \"serviceDringQty\": 3680,\n" +
                "        \"foodPrice\": 106206,\n" +
                "        \"serviceCharge\": 99650,\n" +
                "        \"productPrice\": 8990,\n" +
                "        \"memberCharge\": 950000,\n" +
                "        \"openMemberAccount\": 29,\n" +
                "        \"openNewMemberAccount\": 11,\n" +
                "        \"openRenewMemberAccount\": 18\n" +
                "    }\n" +
                "}";

        return JSON;
    }



//    private float pax = 110;
//    private Double cashPayments = 125783D;
//    private Double creditPayments = 512747D;
//    private Double creditCardPayments = 1651255D;
//    private Double memberDebitPayments = 268764D;
//    private Double entertainPayments = 6763D;
//    private Double income = 2565312D;
//    private Double unpaid = 0D;
//    private Double receipts = 0D;
//    private Double revenue = 2289785D;
//    private Double totalServiceCharge = 546D;
//    private List<BankItemColleationDao> incomecredit = null;
//    private String invoice = null;
//    private Long memberNew = 0L;
//    private Long memberRenew = 0L;
//    private List<String> t = null;
//    private String summaryOrderFoodList = null;
//    private String summaryServiceDrinkList = null;
//    private Double serivceDrinkCharge = 1399920D;
//    private Double serviceDringQty = 3680D;
//    private Double foodPrice = 106206D;
//    private Double serviceCharge = 99650D;
//    private Double productPrice = 8990D;
//    private Double memberCharge = 950000D;
//    private Long openMemberAccount = 29L;
//    private Long openNewMemberAccount = 11L;
//    private Long openRenewMemberAccount = 18L;

}
