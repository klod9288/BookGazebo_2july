package bangtanrut.songklod.bookgazebo;

/**
 * Created by Administrator on 2/4/2560.
 */

public class MyConstant {

    //For URL
    private String urlPostUser = "http://coderobot.webstarterz.com/coderobot.webstarterz.com/bauy/app/postUser.php";
    private String urlGetUser = "http://coderobot.webstarterz.com/coderobot.webstarterz.com/bauy/app/getUser.php";
    private String urlPostProcess1 = "http://coderobot.webstarterz.com/coderobot.webstarterz.com/bauy/app/addProcess1.php";

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

    public String getUrlPostProcess1() {
        return urlPostProcess1;
    }

    //ชื่อศาลา
    private String[] pavilionStrings = new String[]{"ศาลา 1","ศาลา 2","ศาลา 3","ศาลา 4","ศาลา 5"};

    //เวลาในการตั้งสวด
    private String[]timeWork =new String[]{"3 คืน","5 คืน","7 คืน","9 คืน"};

    //เวลาในการรดน้ำศพและเผาศพ
    private String[] timeWashAndBurn = new String[]{"16:30", "17:00", "17:30", "18:00"};

    //เวลาในการย้ายศพ
    private String[] timeMoveBody = new String[]{"15:30","16:00","16:30","17:00"};

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
