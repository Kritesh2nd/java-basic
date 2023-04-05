package com.mycompany.medical;
import java.util.Scanner;
public class Main {
    double totalAmount=0;
    double finalAmount=0;
    public void print(int option){
        switch (option) {
            case 1 -> System.out.println("Welcome to \"SYD Family Medical center\"");
            case 2 -> System.out.println("************************************************************");
            case 3 -> {
                System.out.println("Choose patient age: (type numbers from 1-6 to choose)");
                System.out.println("1) Babies aged 0-2");
                System.out.println("2) Toddlers aged 2-5");
                System.out.println("3) Kids aged 5-12");
                System.out.println("4) Teens aged 12-18");
                System.out.println("5) Adults aged 18-60");
                System.out.println("6) Pensioner aged - above 60");
            }
            case 4 -> {
                System.out.println("Choose Service level: (type numbers from 1-4 to choose)");
                System.out.println("1) GP service");
                System.out.println("2) Pathology");
                System.out.println("3) Eye-check up");
                System.out.println("4) Dental");
            }
            case 5 -> System.out.println("Does the patient have Medicare/private insurance? (Type yes/no)");
            case 6 -> System.out.println("Do you want to repeat for another customer? (Type yes/no)");
            case 7 -> System.out.print("Amount Payable = ");
            case 8 -> System.out.println("Invaild choice");
            case 9 -> System.out.print( "Total amount of service for today                           ");
            case 10 -> System.out.print( "Total amount of collected from patients                     ");
            default -> System.out.println("");
        }
    }
    public int getPatientAge(){
        Scanner sc = new Scanner(System.in);
        int option = 0;
        int ageNum = 0;
        while(option < 1 || option > 6){
            print(2);print(3);
            option = sc.nextInt();
            if(option > 0 && option < 7){
                ageNum = option;
            }
            else{
                print(8);
            }
        }
        return ageNum;
    }
    public int getServiceLevel(){
        Scanner sc = new Scanner(System.in);
        int option = 0;
        int serviceNum = 0;
        while(option < 1 || option > 4){
            print(4);
            option = sc.nextInt();
            if(option > 0 && option < 5){
                serviceNum = option;
            }
            else{
                print(8);
            }
        }
        return serviceNum;
    }
    public boolean checkInsurance(){
        Scanner sc = new Scanner(System.in);
        String insurance;
        boolean returnValue = false;
        print(5);
        insurance = sc.nextLine();
        if(insurance.equalsIgnoreCase("yes")){
            returnValue = true;
        }
        return returnValue;
    }
    public double calculatePayment(int ageOpt,int serviceOpt,boolean dis){
        int[][] ageOpts = {
            {100,350,200,250},
            {110,215,270,295},
            {95,315,215,315},
            {94,300,198,340},
            {88,320,212,318},
            {71,250,250,250}
        };
        int[][] disOpts = {
            {70,85,65,75},
            {91,79,88,55},
            {80,78,80,62},
            {87,80,70,57},
            {90,81,87,66},
            {95,80,95,85}
        };
        double returnValue = ageOpts[ageOpt-1][serviceOpt-1];
        totalAmount = totalAmount + returnValue;
        if(dis){
            double discount = (double) disOpts[ageOpt-1][serviceOpt-1] / 100;
            double discoutnAmount = (double) discount * returnValue;
            returnValue = (double) returnValue - discoutnAmount;
        }
        finalAmount = finalAmount + returnValue;
        return returnValue;
    }
    public void mainApp(){
        Scanner sc = new Scanner(System.in);
        String repeat = "yes";
        print(99);
        print(1);
        while(repeat.equalsIgnoreCase("yes")){
            print(99);
            int patientAge = getPatientAge();
            print(99);
            int serviceLevel = getServiceLevel();
            print(99);
            boolean haveInsurance = checkInsurance();
            double payAmount = calculatePayment(patientAge,serviceLevel,haveInsurance);
            print(7);
            System.out.println(payAmount);
            print(99);
            print(6);
            repeat = sc.nextLine();
        }
        print(9);
        System.out.println(totalAmount);
        print(10);
        System.out.println(finalAmount);
    }
    public static void main(String[] args) {
        Main m = new Main();
        m.mainApp();
    }
}