package Assignmnet1;
public class Triangle extends ShapeObject{
    double side1,side2,side3;
    
    public Triangle(){
        this.side1 = 1;
        this.side2 = 1;
        this.side3 = 1;
    }
    public Triangle(double s1,double s2,double s3){
        this.side1 = s1;
        this.side2 = s2;
        this.side3 = s3;
    }
    public Triangle(double s1,double s2,double s3,String color){
        this.side1 = s1;
        this.side2 = s2;
        this.side3 = s3;
        this.color = color;
    }
    
    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }
    
    public double getSemiPerimiter(){
        double semiperimiter = (this.side1+this.side2+this.side3)/2;
        return semiperimiter;
    }
    public String toString(Triangle tr){
        String returnval = "Side 1 is "+tr.side1+", side 2 is "+tr.side2+
                ", side 3 is "+tr.side3+" and color is "+tr.color+
                " and the Semi Perimiter is "+tr.getSemiPerimiter();
        return returnval;
    }
}
