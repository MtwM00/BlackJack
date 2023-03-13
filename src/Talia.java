import java.util.ArrayList;
import java.util.Random;

public class Talia {

    //ZMIENNE

    private ArrayList<Karta>karty;

    //KONSTURKTOR

    public Talia(){
        this.karty = new ArrayList<>();

    }

    public void stworzPelenaTalie(){

        //Generowanie kart

        for(Kolor kolorKarty : Kolor.values()){

            for(Wartosc wartoscKart : Wartosc.values()){

                this.karty.add(new Karta(kolorKarty,wartoscKart));

            }
        }
    }

    public void potasuj(){

        ArrayList<Karta>tymczasowaTalia = new ArrayList<>();

        Random random = new Random();
        int losowaKartaIndex = 0;
        int oryginalnyRozmiar = this.karty.size();

        for (int i = 0; i<oryginalnyRozmiar; i++){

            losowaKartaIndex = random.nextInt((this.karty.size()-1 - 0) + 1) + 0;
            tymczasowaTalia.add(this.karty.get(losowaKartaIndex));

            //USUNIECIE Z ORYGINALNEJ TALII

            this.karty.remove(losowaKartaIndex);

        }
        this.karty = tymczasowaTalia;
    }



    public String toString(){

        String listaKartWyjscie = "";

        for(Karta karta : this.karty){

            listaKartWyjscie += "\n " + "-" + karta.toString();

        }
        return listaKartWyjscie;
    }

    public void usunKarte(int i){
        this.karty.remove(i);

    }

    public Karta getKarte(int i){
        return this.karty.get(i);

    }

    public void dodajKarte(Karta dodajKarte){
        this.karty.add(dodajKarte);

    }

    //DOBIERA Z TALII

    public void dobierz(Talia przychodzaca){

        //GORA TALII = POCZATEK ARRAYLISTY dlatego index 0
        this.karty.add(przychodzaca.getKarte(0));
        przychodzaca.usunKarte(0);


    }

    public int rozmiarTalii(){
        return this.karty.size();

    }

    public void przeniesDoTalii(Talia przeniesDo){

        int rozmiarTejTalii = this.karty.size();

        //PRZENOSI KARTY DO PRZENIESDO TALII
        for (int i = 0; i< rozmiarTejTalii;i++){
            przeniesDo.dodajKarte(this.getKarte(i));
        }

        for (int i = 0; i< rozmiarTejTalii;i++){
            this.usunKarte(0);
        }
    }


    //Zwraca calkowita wartosc kart w talii
    public int kartyWartosc(){
        int wartoscCalkowita = 0;
        int asy = 0;

        for(Karta karta : this.karty){
            switch (karta.getWartosc()){
                case DWA:
                    wartoscCalkowita += 2;
                break;

                case TRZY:
                    wartoscCalkowita += 3;
                break;

                case CZTERY:
                    wartoscCalkowita += 4;
                    break;

                case PIEC:
                    wartoscCalkowita += 5;
                    break;

                case SZESC:
                    wartoscCalkowita += 6;
                    break;

                case SIEDEM:
                    wartoscCalkowita += 7;
                    break;

                case OSIEM:
                    wartoscCalkowita += 8;
                    break;

                case DZIEWIEC:
                    wartoscCalkowita += 9;
                    break;

                case DZIESIEC:
                    wartoscCalkowita += 10;
                    break;

                case WALET:
                    wartoscCalkowita += 10;
                    break;

                case DAMA:
                    wartoscCalkowita += 10;
                    break;

                case KROL:
                    wartoscCalkowita += 10;
                    break;

                case AS:
                    wartoscCalkowita += 1;
                    break;

            }

        }
        for (int i = 0; i< asy; i++){
            if(wartoscCalkowita>10){
                wartoscCalkowita +=1;

            }else {
                wartoscCalkowita +=11;
            }

        }

    return wartoscCalkowita;
    }


}
