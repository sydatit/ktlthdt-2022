package Ex5_ChuViChuNhat;

public class Rectange {
    private double width;
    private double height;
    private String color;

    public Rectange() {
        this.width =1;
        this.height =1;
    }

    public Rectange(double width, double height, String color) {
        this.width = width;
        this.height = height;
        this.color = formatColor(color);
    }
    private String formatColor( String word){
        StringBuilder sb = new StringBuilder();
        sb.append(Character.toUpperCase(word.charAt(0)));
        int i = 1;
        while (i < word.length()){
            sb.append(Character.toLowerCase(word.charAt(i++)));
        }
        return sb.toString();
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public boolean isValid(){
        if( width <= 0 || height <= 0) return false;
        return true;
    }
    public double findArea(){
        return width * height;
    }
    public double findPerimeter(){
        return (width + height) * 2;
    }

}
