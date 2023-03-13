import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Scanner;

public class Blackjack {

    public static void main (String[] args) {

        //Wiadomość powitalna

        System.out.println("Witaj w Blackjacku!");

        //Tworzenie talii
        Talia grajacaTalia = new Talia();
        grajacaTalia.stworzPelenaTalie();

        grajacaTalia.potasuj();

        //Tworzenie talii dla gracza

        Talia taliaGracza = new Talia();
        Talia taliaKrupiera = new Talia();

        double pieniadzeGracza = 100.00;

        Scanner skan = new Scanner(System.in);

        //GRA - PETLA

        while (pieniadzeGracza > 0){

            //Zakład gracza
            System.out.println("Masz tyle PLN: " + pieniadzeGracza + " Ile chcesz obstawic?");
            double zaklad = skan.nextDouble();

            if(zaklad>pieniadzeGracza){
                System.out.println("Nie masz tyle pieniedzy!");
                break;
            }

            boolean koniecRundy = false;

            //Rozdawanie kart
            //Gracz otrzymuje 2 karty

            taliaGracza.dobierz(grajacaTalia);
            taliaGracza.dobierz(grajacaTalia);

            //Krupier dobiera 2 karty

            taliaKrupiera.dobierz(grajacaTalia);
            taliaKrupiera.dobierz(grajacaTalia);

            while(true){
                System.out.println("Twoja reka: ");
                System.out.println(taliaGracza.toString());
                System.out.println("Wartosc twoich kart to: " + taliaGracza.kartyWartosc());

                //Wyswietlenie reki krupiera
                System.out.println("Reka krupiera: " + taliaKrupiera.getKarte(0).toString() + " i [Ukryta]");

                System.out.println("Czy chcesz (1)dobrac czy (2)czekac");
                int odpowiedz = skan.nextInt();

                //dobranie
                if(odpowiedz==1){
                    taliaGracza.dobierz(grajacaTalia);
                    System.out.println("Dobrales: " + grajacaTalia.getKarte(taliaGracza.rozmiarTalii()-1).toString());
                    //
                    if (taliaGracza.kartyWartosc() > 21){
                        System.out.println("Zbyt duzo! Wartosc twoich kart to: " + taliaGracza.kartyWartosc());
                        pieniadzeGracza -=zaklad;
                        koniecRundy = true;
                        break;
                    }
                } if (odpowiedz==2){
                    break;
                }
            }

            //Ujawnienie kart krupiera
            System.out.println("Karty Krupiera: " + taliaKrupiera.toString());
            //Czy krupier ma więcej pkt niż gracz
            if ((taliaKrupiera.kartyWartosc() > taliaGracza.kartyWartosc()) && koniecRundy== false){
                System.out.println("Krupier Wygrywa!");
                pieniadzeGracza -= zaklad;
                koniecRundy = true;

            }

            //Jeżeli ręka krupiera jest mniejsza niż 17 dobiera, jeżeli nie to czeka
            while((taliaKrupiera.kartyWartosc() < 17) && koniecRundy == false){
                taliaKrupiera.dobierz(grajacaTalia);
                System.out.println("Krupier dobiera: " + taliaKrupiera.getKarte(taliaKrupiera.rozmiarTalii()-1).toString());

            }

            //Wypisanie wartości kart krupiera
            System.out.println("Reka Krupiera ma wartosc: " + taliaKrupiera.kartyWartosc());
            //Czy krupier ma więcej niż 21
            if ((taliaKrupiera.kartyWartosc() > 21) && koniecRundy == false){
                System.out.println("Krupier ma wiecej niz 21, wygrywa gracz");
                pieniadzeGracza += zaklad;
                koniecRundy = true;
            }

            if ((taliaGracza.kartyWartosc() == taliaKrupiera.kartyWartosc()) && koniecRundy == false){
                System.out.println("push");
                koniecRundy = true;

            }

            if ((taliaGracza.kartyWartosc() > taliaKrupiera.kartyWartosc()) && koniecRundy == false){
                System.out.println("Wygrywasz");
                pieniadzeGracza += zaklad;
                koniecRundy = true;

            }
            else if(koniecRundy==false){
                System.out.println("przegrywasz reke");
                pieniadzeGracza -= zaklad;
                koniecRundy = true;
            }
            taliaGracza.przeniesDoTalii(grajacaTalia);
            taliaKrupiera.przeniesDoTalii(grajacaTalia);
            System.out.println("Koniec ręki");

        }
        System.out.println("Przegrales!");


    }
}
