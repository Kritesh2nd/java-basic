package Assignmnet1;
public class TestClass extends Triangle{
    public static void main(String[] args) {
        Triangle tri1 = new Triangle();
        System.out.println("Semi Perimiter is "+tri1.getSemiPerimiter());
        System.out.println(tri1.toString());
        
        System.out.println("");
        
        Triangle tri2 = new Triangle(4,5,6);
        System.out.println("Semi Perimiter is "+tri2.getSemiPerimiter());
        System.out.println(tri2.toString(tri2));
        
        System.out.println("");
        
        Triangle tri3 = new Triangle(2,2,3,"GREEN");
        System.out.println("Semi Perimiter is "+tri3.getSemiPerimiter());
        System.out.println(tri2.toString(tri3));
    }
}
