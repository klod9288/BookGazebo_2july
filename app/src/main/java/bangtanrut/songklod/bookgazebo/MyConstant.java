package bangtanrut.songklod.bookgazebo;

/**
 * Created by Administrator on 2/4/2560.
 */

public class MyConstant {

    //For URL
    private String urlPostUser = "http://coderobot.webstarterz.com/coderobot.webstarterz.com/bauy/app/postUser.php";
    private String urlGetUser = "http://coderobot.webstarterz.com/coderobot.webstarterz.com/bauy/app/getUser.php";
    private String urlPostProcess1 = "http://coderobot.webstarterz.com/coderobot.webstarterz.com/bauy/app/addProcess1.php";
    private String urlPostProcess2 = "http://swiftcodingthai.com/bow/addProcess2var3.php";
    private String urlPostProcess3 = "http://swiftcodingthai.com/bow/addProcess3.php";
    private String urlGetProcess1 = "http://swiftcodingthai.com/bow/getAllProcess2.php";
    private String urlGetProcess2 = "http://swiftcodingthai.com/bow/getAllProcess2.php";
    private String urlGetProcess3 = "http://swiftcodingthai.com/bow/getAllProcess3.php";

    //Column Process2
    private String[] colunmProcess2Strings = new String[]{"id", "cremation", "interment", "name",
            "pavilion", "showdate", "showTime", "setDateTime", "bodyWhere", "timeBodyWhere",
            "timeSong", "coffeeGroup", "amountBwchnafi", "timeBwchanafi", "bwchnafi",
            "amountChantPlant", "burnBuild", "burnOld", "burnBanana", "salaPrice",
            "manageBurnBuild", "carBody", "flower", "flower0", "flower1", "powerSound",
            "powerBand", "waterDrink", "ice", "food", "candy", "bow"};

    //Column Process3
    private String[] columnProcess3Strings = new String[]{"id", "dateString", "tumBunString",
            "salaString", "nameBodyString", "nameContactString", "phoneString", "timePhathed",
            "timeSungkatand", "amountSungkatand", "timeSundmonn", "amoundSundmonn",
            "timePackageBody", "amountKondin", "amountFlower", "amoundBucha", "amoundThaitan",
            "amoundWaterDrink", "amountIce", "amoundFood", "amoundBow"};

    //For General
    private String[] columnUserStrings = new String[]{
            "id",
            "Name",
            "Surname",
            "IdCard",
            "Address",
            "Phone",
            "User",
            "Password",
            "Status"};


    //ชื่อศาลา
    private String[] pavilionStrings = new String[]{"ศาลา 1 (2,200.00 บาท)",
            "ศาลา 2 (2,200.00 บาท)",
            "ศาลา 3 (2,200.00 บาท)",
            "ศาลา 4 (2,200.00 บาท)",
            "ศาลา 5 (2,200.00 บาท)",
            "ศาลา 6 (2,200.00 บาท)",
            "ศาลา 7 (2,200.00 บาท)",
            "ศาลา 8 (2,200.00 บาท)",
            "ศาลา 9 (2,200.00 บาท)",
            "ศาลา 10 (3,000.00 บาท)",
            "ศาลา 11 (2,200.00 บาท)",
            "ศาลา 12 (2,200.00 บาท)",};

    public String[] getColunmProcess2Strings() {
        return colunmProcess2Strings;
    }

    public String[] getColumnProcess3Strings() {
        return columnProcess3Strings;
    }

    public String getUrlGetProcess1() {
        return urlGetProcess1;
    }

    public String getUrlGetProcess2() {
        return urlGetProcess2;
    }

    public String getUrlGetProcess3() {
        return urlGetProcess3;
    }

    public String getUrlPostProcess3() {
        return urlPostProcess3;
    }

    public String getUrlPostProcess2() {
        return urlPostProcess2;
    }

    //เวลาสำหรับบวชหน้าไฟ
    private String[] bwchnafiStrings = new String[]{"10:00", "10:30", "14:00", "17:00", "18:00"};

    //เวลาในการตั้งสวด
    private String[] timeWork = new String[]{"3 คืน", "5 คืน", "7 คืน", "9 คืน"};

    //เวลาในการรดน้ำศพและเผาศพ
    private String[] timeWashAndBurn = new String[]{"16:30", "17:00", "17:30", "18:00"};

    //เวลาในการย้ายศพ
    private String[] timeMoveBody = new String[]{"15:30", "16:00", "16:30", "17:00"};

    //เวลาเชิญศพ
    private String[] timeBodyWhere = new String[]{"ก่อนเที่ยง", "หลังเที่ยง"};

    //เวลาสวดอภิธรรม
    private String[] timeSong = new String[]{"10:00", "14:30", "17:00", "19:00"};

    //เวลาบังสุกุล
    private String[] bungSagunStrings = new String[]{"14:00", "15:00", "16:00"};


    public String[] getBungSagunStrings() {
        return bungSagunStrings;
    }

    public String[] getBwchnafiStrings() {
        return bwchnafiStrings;
    }

    public String[] getTimeBodyWhere() {
        return timeBodyWhere;
    }

    public String[] getTimeSong() {
        return timeSong;
    }

    public String getUrlPostProcess1() {
        return urlPostProcess1;
    }

    public String[] getTimeMoveBody() {
        return timeMoveBody;
    }

    public String[] getTimeWashAndBurn() {
        return timeWashAndBurn;
    }

    public String[] getTimeWork() {
        return timeWork;
    }

    public String[] getPavilionStrings() {
        return pavilionStrings;
    }

    public String getUrlGetUser() {
        return urlGetUser;
    }

    public String[] getColumnUserStrings() {
        return columnUserStrings;
    }

    public String getUrlPostUser() {
        return urlPostUser;
    }
}//main class
