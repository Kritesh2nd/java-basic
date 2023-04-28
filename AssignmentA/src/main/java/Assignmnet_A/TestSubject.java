package Assignmnet_A;
import java.util.*; 
import java.util.ArrayList;

public class TestSubject extends Subject{
    ArrayList <Subject> subjectList = new ArrayList<>();
    int num=10;

    public TestSubject(String name, String code) {
        super(name, code);
    }
    
    public boolean addSubjecToArrayList(Subject sub){
        boolean returnValue = false;
        boolean validCode = isValidCode(sub.getCode());
        boolean codeExists = codeExists(subjectList,sub.getCode());
        if(validCode && !codeExists){
            subjectList.add(sub);
            returnValue = true;
        }
        return returnValue;
    }
    
    public void printSortedSubject(){
        ArrayList<Subject> sortedArray = sortDisciplines(subjectList);
        System.out.println("-------------------------------------------------------------------");
        System.out.println("| SN | Subject name                                     |  Code   |");
        System.out.println("-------------------------------------------------------------------");
        for(int a=0;a<sortedArray.size();a++){
            if(a==9){System.out.print("| "+(a+1)+" | ");}
            else{System.out.print("| "+(a+1)+"  | ");}
            System.out.print(subjectList.get(a).getName());
            for(int b=0;b<=(50-subjectList.get(a).getName().length()-2);b++){
                System.out.print(" ");
            }
            System.out.println("| "+subjectList.get(a).getCode()+" |");
        }
        System.out.println("-------------------------------------------------------------------");
    }
    
    public static void main(String[] args){
        TestSubject ts = new TestSubject("Subject Name","COD1234");
        Scanner sc = new Scanner(System.in);
        int turn;
        char add;
        String subject,code;
        boolean subjectAdded;
        System.out.println("\n\n");
        for(turn=0;turn<ts.num;turn++){
            System.out.println("Do you want to add subject to the data structure(Y/N)");
            add = sc.next().charAt(0);
            if(add == 'Y' || add == 'y'){
                if(ts.subjectList.size()>0){
                    ts.printSortedSubject();
                }
                System.out.println("Enter subject name: ");
                subject = sc.nextLine();
                subject = sc.nextLine();
                System.out.println("Enter subject code: ");
                code = sc.nextLine();
                Subject s = new Subject(subject,code);
                subjectAdded = ts.addSubjecToArrayList(s);
                if(subjectAdded){
                    System.out.println("New subject added successfully.");
                }
                else{
                    turn--;
                    System.out.println("Invalid code. Couldn't add new subject.");
                }
            }
            else{
                break;
            }
        }
        System.out.println(turn);
        if(turn==ts.num){
            ts.toString(ts.subjectList);
        }
    }
}
