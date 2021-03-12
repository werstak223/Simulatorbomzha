package space.mark.simulatorbomzha.General;

import java.io.Serializable;

public class Person extends Game implements Serializable {
    public int energy=50;
    public int money=50;
    public int prestizh=0;
    public int obrazovanie=0;
    public int lucky=0;
    public int golod=10;
    public int dosug=20;
    public int obchenie=50;
    public int health=20;
    public Person(){
        super();
    }
}
