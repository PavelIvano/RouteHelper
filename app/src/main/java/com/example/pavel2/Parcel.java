package com.example.pavel2;

import android.view.View;

public class Parcel {
    private int w, h, l, weight;
    Destination address;

    public Parcel() {
        this.address = this.new Destination();
    }

    public class Destination {
        public String street;
        public int homeNumber;
        public int roomNumber;

        public boolean canBigParcel() {
            return weight <= 10;
        }
    }

    public static void main(String[] args) {
        Parcel p = new Parcel();
        p.address.street = "ленина";
        p.address.homeNumber = 10;
        p.address.homeNumber = 5;

        Speakable o = new Speakable() {
            @Override
            public void speak() {
                System.out.println("Hello");

            }
        };
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("I clicked");
            }
        };
    }
}

