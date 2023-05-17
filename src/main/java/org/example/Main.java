package org.example;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException, NotSerializableException {
        boolean exit = true;
        Picture picture = new Picture();
        UniquePicture uniquePicture = new UniquePicture();
        StandarizedPicture standarizedPicture = new StandarizedPicture();
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("Menu\n" +
                    "1. Dodaj punkt\n" +
                    "2. Dodaj odcinek\n" +
                    "3. Dodaj okrag\n" +
                    "4. Wyswietl obraz\n" +
                    "5. Przesun obraz\n" +
                    "6. Suma pol obiektow\n" +
                    "7. Dodaj punkt z unikatowa etykieta\n" +
                    "8. Wyswietl\n" +
                    "9. Dodaj punkt z etykiete zgodnie ze wzorem\n" +
                    "10. Wyswietl\n" +
                    "11. Zamknij\n" +
                    "12. Wyswietl posortowana liste po label\n" +
                    "13. Wyswietl posortowana liste po nazwie klasy\n" +
                    "14. Posortowe wedlug odleglosci centroida od srodka osi wspolrzednych\n" +
                    "15. Skalowanie\n" +
                    "16. Zapis obrazu z pliku\n" +
                    "17. Wczytanie obrazu z pliku");

            int options = sc.nextInt();

            switch (options){
                case 1 -> {
                    double x,y;
                    String label;
                    System.out.println("Podaj nazwe etykiety\n");
                    label = sc.next();
                    System.out.println("Podaj wsprzolrzedna x: \n");
                    x = sc.nextDouble();
                    System.out.println("Podaj wspolrzedna y: \n");
                    y = sc.nextDouble();
                    Point p1 = new Point(x,y,label);
                    picture.addPoint(p1);

                }
                case 2 ->{
                    double x1,y1,x2,y2;
                    String label;
                    System.out.println("Podaj nazwe etykiety\n");
                    label = sc.next();
                    System.out.println("Podaj wspolrzednie poczatku linii\n");
                    System.out.println("Podaj wsprzolrzedna x1: \n");
                    x1=sc.nextDouble();
                    System.out.println("Podaj wspolrzedna y1: \n");
                    y1=sc.nextDouble();
                    System.out.println("Podaj wspolrzednie konca linii\n");
                    System.out.println("Podaj wsprzolrzedna x2: \n");
                    x2=sc.nextDouble();
                    System.out.println("Podaj wspolrzedna y2: \n");
                    y2=sc.nextDouble();
                    Point p1 = new Point(x1,y1);
                    Point p2 = new Point(x2,y2);
                    Section section = new Section(p1,p2,label);
                    picture.addSection(section);
                }
                case 3 ->{
                    double r;
                    Point o = new Point();
                    String label;
                    System.out.println("Podaj nazwe etykiety");
                    label = sc.next();
                    System.out.println("Podaj wspolrzedne srodka okregu\n");
                    System.out.println("Podaj wsprzolrzedna x: \n");
                    o.x = sc.nextDouble();
                    System.out.println("Podaj wspolrzedna y: \n");
                    o.y = sc.nextDouble();
                    System.out.println("Podaj promien okregu\n");
                    r = sc.nextDouble();
                    Circle circle = new Circle(o,r,label);
                    picture.addCircle(circle);
                }
                case 4 ->{
                    System.out.println(picture);
                }
                case 5->{
                    double dx,dy;
                    System.out.println("Podaj wartosci o ile chcesz przesunac\n");
                    System.out.println("Podaj wartosc przesuniecia x:\n");
                    dx =sc.nextDouble();
                    System.out.println("Podaj wartosc przesuniecia y:\n");
                    dy=sc.nextDouble();
                    picture.movePic(dx,dy);
                }
                case 6->{
                    System.out.println(picture.getArea());
                }
                case 7 ->{
                    double x,y;
                    String label;
                    System.out.println("Podaj etykiete\n");
                    label =sc.next();
                    System.out.println("Podaj wspolrzedna x:\n");
                    x=sc.nextDouble();
                    System.out.println("Podaj wspolrzedna y:\n");
                    y= sc.nextDouble();
                    Point point = new Point(x,y,label);
                    if (uniquePicture.add(point)){
                        System.out.println("Punkt został dodany poprawnie!");
                    } else {
                        System.out.println("Podana etykieta już występuje! Ustaw inna etykiete!");
                    }
                    sc.next();
                }
                case 8->{
                    System.out.println("Obraz punktow o unikatowych etykietach\n");
                    System.out.println(uniquePicture);
                }
                case 9 ->{
                    double x,y;
                    String label;
                    System.out.println("Podaj etykiete\n");
                    label = sc.next();
                    System.out.println("Podaj wspolrzedne punktu\n");
                    System.out.println("Podaj wspolrzedna x\n");
                    x=sc.nextDouble();
                    System.out.println("Podaj wspolrzedna y\n");
                    y=sc.nextDouble();
                    Point point = new Point(x,y,label);
                    if(standarizedPicture.add(point)){
                        System.out.println("Punkt został dodany");
                    } else {
                        System.out.println("Podana etykieta nie pasuje do wzorca");
                    }
                    sc.next();
                }
                case 10 ->{
                    System.out.println("Obraz punktow o okreslony wzorem etykiet\n");
                    System.out.println(standarizedPicture);
                }
                case 11 ->{
                    exit = false;
                }
                case 12 ->{
                    System.out.println(picture.toStringSortedByLabel(picture.objects));
                }
                case 13 ->{
                    System.out.println(picture.toStringSortedByClassName(picture.objects));
                }
                case 14 ->{
                    System.out.println(picture.toStringSortedByDistanceFromOrigin());
                }
                case 15 ->{
                    double k;
                    System.out.println("Podaj o ile chcesz przeskalowac");
                    k = sc.nextDouble();
                    picture.scaleObjetcs(k);
                    System.out.println(picture);
                }
                case 16 ->{
                    OutputStream fileOutput = new FileOutputStream(("picture.txt"));
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutput);
                    objectOutputStream.writeObject(picture);
                    objectOutputStream.close();
                }
                case 17 ->{
                    ObjectInputStream in = new ObjectInputStream(new FileInputStream("picture.txt"));
                    picture = (Picture)in.readObject();
                    in.close();
                    System.out.println(picture);
                }
            }
        }
        while (exit);

    }
//komentarz
}