package Assignmnet_A;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Subject {
    private String name,code;

    public Subject(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isValidCode(String code){
        
        boolean returnValue = false,checkString=false,checkInt=false;
        int codeLength = code.length(), a;
        char[] singleChar = new char[7];
        if(codeLength == 7){
            for(a=0;a<7;a++){
                singleChar[a] = code.charAt(a);
            }
            for(a=0;a<3;a++){
                checkString = singleChar[a] >= 'A' && singleChar[a] <= 'Z';
                if(checkString==false){
                    break;
                }
            }
            for(a=3;a<7;a++){
                checkInt = singleChar[a] >= '0' && singleChar[a] <= '9';
                if(checkInt==false){
                    break;
                }
            }
            returnValue = checkString && checkInt;
        }
        return returnValue;
    }
    
    public boolean codeExists(ArrayList<Subject> subjectArr, String code){
        boolean returnValue = true;
        int len = subjectArr.size(),a;
        String subjCode;
        if(len == 0){
            returnValue = false;
        }
        else{
            for(a=0;a<len;a++){
                subjCode = subjectArr.get(a).code;
                returnValue = subjCode.equals(code);
                if(returnValue==true){
                    break;
                }
            }
        }
        return returnValue;
    }
    
    public void toString(ArrayList<Subject> subjectList){
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
    
    public ArrayList<Subject> sortDisciplines(ArrayList<Subject> subjectArrayList){
        ArrayList sortedArrayList = (ArrayList) subjectArrayList.clone();
        Collections.sort(sortedArrayList, new Comparator<Subject>() {
            public int compare(Subject c1, Subject c2) {
                return c1.getCode().compareTo(c2.getCode());
            }
        });
        return sortedArrayList;
    }
}
