/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.sp24.t4s4.user.shopping;

public class Computer {

    private String id;
    private String name;
    private double price;
    private int quality;

    public Computer() {
        this.id = "";
        this.name = "";
        this.price = 0;
        this.quality = 0;
    }

    public Computer(String id, String name, double price, int quality) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quality = quality;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

}
