public class Karta {

    private Kolor kolor;
    private Wartosc wartosc;

    public Karta(Kolor kolor, Wartosc wartosc){

        this.kolor = kolor;
        this.wartosc = wartosc;

    }

    public String toString(){
        return this.kolor.toString() +"-"+ this.wartosc.toString();

    }

    public Wartosc getWartosc () {
        return this.wartosc;
    }
}
