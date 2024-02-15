package org.example;
import java.util.Scanner;
public class Main {
    //Задаем радиус Земли
    static double Radius = 6372.7950;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Получение координат 1 точки
        System.out.println("Введите широту 1 точки");
        double shirota = scanner.nextDouble();
        System.out.println("Введите долготу 1 точки");
        double dolgota = scanner.nextDouble();
        //Получение координат 2 точки
        System.out.println("Введите широту 2 точки");
        double shirota2 = scanner.nextDouble();
        System.out.println("Введите долготу 2 точки");
        double dolgota2 = scanner.nextDouble();
        //Получение расстояния между точками
        double distancia = Rachetdistancii(shirota, dolgota, shirota2, dolgota2);
        System.out.println("Расстояние между двумя точками нашей круглой Земельки равно: " + distancia + " км");
    }

    public static double Rachetdistancii(double shirota, double dolgota, double shirota2, double dolgota2){
        // Градусы конвертируем в радианы
        double shirotaRad = Math.toRadians(shirota);
        double dolgotaRad = Math.toRadians(dolgota);
        double shirota2Rad = Math.toRadians(shirota2);
        double dolgota2Rad = Math.toRadians(dolgota2);

        // Косинусы и синусы сторон
        double cosshirota = Math.cos(shirotaRad);
        double cosshirota2 = Math.cos(shirota2Rad);
        double sindolgota = Math.sin(dolgotaRad);
        double sindolgota2 = Math.sin(dolgota2Rad);

        // Разница широт и долгот
        double delta = dolgotaRad - dolgota2Rad;
        double cosDelta = Math.cos(delta);
        double sinDelta = Math.sin(delta);

        // Формула гаверсинусов
        double formula = Math.sqrt(Math.pow(cosshirota2 * sinDelta, 2) + Math.pow(cosshirota * sindolgota2 - sindolgota * cosshirota2 * cosDelta,2));
        double formula2 = sindolgota * sindolgota2 + cosshirota * cosshirota2 * cosDelta;
        double itog = Math.atan2(formula, formula2);
        // Возвращаем значения
        return Radius * itog;
    }
}


