import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;

public class MainApp {
    private static int maxService = 56;
    public static void main(String[] args) throws IOException {
        LocalDateTime now = LocalDateTime.now();
        if (now.getHour() < 8) {
            System.out.println("the program is not working !!!");
            return;
        }
        showDayMessage(now);

        Integer max = 56;
        String[] numbers = new String[maxService];
        String[] FullName = new String[maxService];
        String[] mobils = new String[maxService];
        Boolean[] ExitedList = new Boolean[maxService];
        Long[][] InvoicPrice = new Long[maxService][];
        String[][] InvoicTitle = new String[maxService][];
        Integer current = 0;

        while (true){
            showMenu();
            int menu = getmenu();
            switch (menu){
                case 1:
                    print("Please enter the NO car : ");
                    numbers[current] = getInput();
                    print("Please enter the driver name of car : ");
                    FullName[current] = getInput();
                    print("Please enter your Mobils Number : ");
                    mobils[current] = getInput();
                    print("car is Exited??");
                    ExitedList[current] = false;
                    print("your service number is  : " + (current + 1));
                    current++;
                    break;
                case 2:
                    int remains = maxService - current;
                    int exited = 0 , entered = 0;
                    for (Boolean item : ExitedList){
                        if (item == null) continue;
                        if (item){
                            exited++;
                        }else {
                            entered++;
                        }
                    }
                    print("Remains : " + remains);
                    print("Entered : " + entered);
                    print("Exited : " + exited);
                    break;
                case 3:
                    print("please enter the service Number : ");
                    int Number = Integer.parseInt(getInput());
                    Number--;
                    if (!checkNumberValidity(Number)){
                        print("the Number is Invalid : ");
                        break;
                    }
                    print("Number : " + numbers[Number]);
                    print("Name : " + FullName[Number]);
                    print("mobile : " + mobils[Number]);
                    print("Status : " + (ExitedList[Number] ? "Serviced" : "InService"));
                    break;
                case 4:
                    print("please enter the service Number : ");
                    int ServiceNumber = Integer.parseInt(getInput());
                    ServiceNumber--;
                    if (!checkNumberValidity(ServiceNumber)){
                        print("the Number is Invalid : ");
                        break;
                    }
                    print("Please enter the Invoic Item count : ");
                    int  InvoicItemcount = Integer.parseInt(getInput());
                    Long totalPrice = 0l;
                    InvoicTitle[ServiceNumber] = new String[InvoicItemcount];
                    InvoicPrice[ServiceNumber] = new Long[InvoicItemcount];
                    for (int currentInvoic = 0 ; currentInvoic < InvoicItemcount ; currentInvoic++){
                        print("[" + (currentInvoic + 1 ) + "] -> please enter the Invoic item Title : ");
                        InvoicTitle[ServiceNumber][currentInvoic] = getInput();
                        print("[" + (currentInvoic + 1 ) + "] -> please enter the Invoic item Price : ");
                        InvoicPrice[ServiceNumber][currentInvoic] = Long.parseLong(getInput());
                        totalPrice += InvoicPrice[ServiceNumber][currentInvoic];
                    }
                    ExitedList[ServiceNumber] = true;
                    print("the total Price is : " + totalPrice);
                    break;
                case 0:
                    System.out.println("Exit the Program ");
                    return;
            }
        }
    }

    private static boolean checkNumberValidity(Integer serviceNumber) {
        return serviceNumber >= 0 && serviceNumber <= maxService;
    }

    private static int getmenu() throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in)
        );
        try {
            return Integer.parseInt(reader.readLine());
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    private static void showMenu() {
        print("Please enter the Menu to continue : ");
        print("1 : ENTER THE CAR INFORMATION");
        print("2 : SHOW REMAIN & EXITED & ENTERED");
        print("3 : SHOW CAR DETAIL");
        print("4 : EXIT THE CAR");
        print("0 : EXIT");
    }

    private static void showDayMessage(LocalDateTime data) {
        switch (data.getDayOfWeek()) {

            case MONDAY:
                System.out.println("Doshanbe bekhir");
                break;
            case TUESDAY:
                print("seshanbe bekhir");
                break;
            case WEDNESDAY:
                print("charshanbe bekhir");
                break;
            case THURSDAY:
                print("Panjshanbe bekhir");
                break;
            case FRIDAY:
                print("jome bekhir");
                break;
            case SATURDAY:
                print("shanbe bekhir");
                break;
            case SUNDAY:
                print("yekshanbe bekhir");
                break;
        }
    }

    private static void print(String message){
        System.out.println(message);
    }

    private static String getInput() throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in)
        );
        try {
            return reader.readLine();
        }catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }
}