/**
 * @(#)Elektronik.java
 *
 *
 * @author 
 * @version 1.00 2020/6/29
 */


public abstract class Elektronik {
    protected String nama;
    protected int volume;

    public Elektronik(String nm, int vol){
        this.nama = nm;
        this.volume = vol;
    }

    public abstract int tmbhVolume();

    public String toString(){
        return "Nama : " + this.nama + "Volume : " + this.volume;
    }
}

class TV extends Elektronik{

    private int lbrlayar;

    public TV(String nm, int vol, int llyr) {
        super(nm, vol);
        this.lbrlayar = llyr;
    }

    @Override
    public int tmbhVolume() {
        return volume += 1;
    }
}

class Radio extends Elektronik{

    public Radio(String nm, int vol) {
        super(nm, vol);
    }

    @Override
    public int tmbhVolume() {
        return volume += 1;
    }

    public static void main(String[] args) {
        Radio RadioCoba = new Radio("cawang", 2);
        TV TVSonico = new TV("SONYA", 5, 32);
        RadioCoba.tmbhVolume();
        TVSonico.tmbhVolume();
        System.out.println(RadioCoba.toString());
        System.out.println(TVSonico.toString());
    }
}