import java.util.Scanner;

//Портей, ЗИТ-21, вариант 6, задание 1
class Triangle{
    int line0, line1, line2;
    public Triangle(int[] lines){
        this.line0 = lines[0];
        this.line1 = lines[1];
        this.line2 = lines[2];
    }

    boolean isPossible(){
        return line0+line1>line2&&line0+line2>line1&&line1+line2>line0;
    }

    double maxOutsideAngle(){
        //a2 = b2 + c2 - 2bc·cos α
        //line0^2 = line1^2+line2^2 - 2*line1*line2*cos(?)
        //2*line1*line2*cos(?) = line1^2+line2^2 - line0^2
        //cos(?) = (line1^2+line2^2 - line0^2)/(2*line1*line2)
        return (180.0/Math.PI)*Math.acos((Math.pow(line1, 2)+Math.pow(line2, 2) - Math.pow(line0, 2))/(2*line1*line2));
    }
}

class Sorter{

    private static void swap(int[] nums, int one, int two){
        int reserve = nums[one];
        nums[one] = nums[two];
        nums[two] = reserve;
    }
    public static void sort(int[] lines){
        int reserve;
        if (lines[0] > lines[1])
            Sorter.swap(lines, 0, 1);
        if (lines[1] > lines[2])
            Sorter.swap(lines, 1, 2);
        if (lines[0] > lines[1])
            Sorter.swap(lines, 0, 1);
    }
}

public class Main {
    public static void main(String[] args) {
        int[] lines = new int[3];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i<3; i++) {
            System.out.println("Введите длину " + (i + 1) + "-й стороны треугольника: ");
            lines[i] = sc.nextInt();
        }
        Sorter.sort(lines);
        Triangle triangle = new Triangle(lines);
        if (triangle.isPossible()) {
            System.out.println("Из таких сторон МОЖНО сложить треугольник");
            System.out.println("Величина его максимального внешнего угла = " + triangle.maxOutsideAngle());
        }
        else
            System.out.println("Из таких сторон нельзя сложить треугольник");
    }

}