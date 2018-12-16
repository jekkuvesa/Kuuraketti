import java.util.*;

public class Ohjelma {

    public static void main(String[] args) {
        double r0 = 100000;
        double rm = 6371000;
        double R = 384000000;
        double G = 6.67384 * Math.pow(10, -11);
        double Mm = 5.974 * Math.pow(10, 24);
        double Mk = 7.342 * Math.pow(10, 22);

        double r = (2 * R * Mm - Math.sqrt(Math.pow(2 * R * Mm, 2) - 4 * Mm * Math.pow(R, 2) * (Mm - Mk))) / (2 * (Mm - Mk));
        double v0 = Math.sqrt(2 * G * ((-Mm) / r + Mk / (R - r) + Mm / (r0 + rm) - Mk / R));
        double dt = 2; // aikaaskeleen valitseminen
        double t = 0.0;
        double v1 = v0 ;
        double RR = 384000000;
        double a = 0.0;

        System.out.println("Matka pisteeseen jossa maan ja kuun gravitaativoimat ovat yhtä suuret "+ r+" m");
        System.out.println("Minimilähtönopeus " + v0+" m/s");
        ArrayList<Double> aika = new ArrayList<>();
        ArrayList<Double> matka = new ArrayList<>();
        ArrayList<Double> aika2 = new ArrayList<>();
        ArrayList<Double> matka2 = new ArrayList<>();
        r0 = 6471000;
        double v2;
        System.out.println("Aika minimilähtönopeudella ");
        // looppi laskee aika-askeleen välein aluksen kiihtyvyyden(a), hetkellisen nopeuden(v2) ja kuljetun matkan(r0) maan keskipisteestä
        // loopin lopussa aika ja matka lisätään vielä kahdelle listalle johon kaikki ajat ja nopeudet tallentuu 
        
        // laskee minimialkunopeudella ajan ja matkan
        while (r0 < RR) {
            a = -G * Mm / Math.pow(r0, 2) + G * Mk / Math.pow(RR - r0, 2);
            v2 = (v1 + dt * a);
            r0 += (v1 + v2) * dt / 2;
            t += dt;
            v1 += dt * a;
            aika2.add(t);
            matka2.add(r0);
            //System.out.println("r0= "+r0+" v1= "+v1+" t= "+t);

        }
        r0 = 6471000;
        v1 = v0*1.1;
        t = 0;
        a = 0;
        
        System.out.println("aika = " + aika2.get(aika2.size() - 1)+" s");
        System.out.println("matka = " + matka2.get(matka2.size() - 1)+" m");
         
        System.out.println("");
        System.out.println("Aika nopeudella "+v1+" m/s");
        // looppi laskee aika-askeleen välein aluksen kiihtyvyyden(a), hetkellisen nopeuden(v2) ja kuljetun matkan(r0) maan keskipisteestä
        // loopin lopussa aika ja matka lisätään vielä kahdelle listalle johon kaikki ajat ja nopeudet tallentuu 
        
        // laskee 1.1 kertaisella miniminopeudella matkan ja ajan
        while (r0 < RR) {
            a = -G * Mm / Math.pow(r0, 2) + G * Mk / Math.pow(RR - r0, 2);
            v2 = (v1 + dt * a);
            r0 += (v1 + v2) * dt / 2;
            t += dt;
            v1 += dt * a;
            aika.add(t);
            matka.add(r0);
            //System.out.println("r0= "+r0+" v1= "+v1+" t= "+t);

        }
        // kokonaisaika saadaan aika-listan viimeisestä indeksistä
        System.out.println("aika = " + aika.get(aika.size() - 1)+" s");
        // Kokonaismatka saadaan matka-lista viimeisestä indeksistä
        System.out.println("matka = " + matka.get(matka.size() - 1)+" m");
        
        
        
    }

}
