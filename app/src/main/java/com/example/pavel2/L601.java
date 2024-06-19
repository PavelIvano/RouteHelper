package com.example.pavel2;

public class L601 {
    public static void main(String[] args) {
        TV tv = new TV ();
        onSpeakable(tv);
        Unit[] units = new Unit[5];
        for (int i = 0; i < 5; i++) {
            int type = (int) Math.round(Math.random() * 2);
            switch (type) {
                case 0:
                    units[i] = new Robot("R2D2", 100,123);
                    break;
                case 1:
                    units[i] = new Unit("Vedmak", 100);
                    break;
                case 2:
                    units[i] = new Terminator("Arnold", 100,123);
                    break;
            }
            Unit u = units[i];
            u.printInfo();
            u.speak();
        }
    }
    public static void onSpeakable(Speakable o) {
        o.speak();
        if (o instanceof TV) {
            System.out.println("on tv");
        } else if (o instanceof Terminator) {
            Terminator t = ( Terminator) o;
            System.out.println("on" + t.gun);
        } else if (o instanceof Unit){
            Unit u = (Unit) o;
            System.out.println("on" + u.name);
        }
    }
}
