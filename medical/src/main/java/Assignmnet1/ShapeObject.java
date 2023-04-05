package Assignmnet1;
public class ShapeObject {
    String color;
    public ShapeObject(){
        this.color = "RED";
    }
    public ShapeObject(String newcolor){
        this.color = newcolor;
    }
    public String toString(){
        Triangle tr = new Triangle();
        String returnval = "Side 1 is "+tr.side1+", side 2 is "+tr.side2+
                ", side 3 is "+tr.side3+" and color is "+this.color+
                " and the Semi Perimiter is "+tr.getSemiPerimiter();
        return returnval;
    }
}
