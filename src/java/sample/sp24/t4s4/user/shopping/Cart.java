/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.sp24.t4s4.user.shopping;

import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import static java.rmi.server.LogStream.log;
import java.util.HashMap;
import java.util.Map;

public class Cart {

    private Map<String, Computer> cart;

    public Cart() {

    }

    public Cart(Map<String, Computer> cart) {
        this.cart = cart;
    }

    public Map<String, Computer> getCart() {
        return cart;
    }
    

    public void setCart(Map<String, Computer> cart) {
        this.cart = cart;
    }

    public boolean add(Computer computer) {
        boolean check = false;
        try {
            if (this.cart == null) {
                this.cart = new HashMap<>();
            }
            if (this.cart.containsKey(computer.getId())) {
                int currenytuantity = this.cart.get(computer.getId()).getQuality();
                computer.setQuality(currenytuantity + computer.getQuality());
            }
            cart.put(computer.getId(), computer);
            check = true;
        } catch (Exception e) {

        }
        return check;
    }

    public boolean edit(String id, int quality) {
        boolean check = false;
        try{
            if(this.cart != null){
                if(this.cart.containsKey(id)){
                    Computer computer = this.cart.get(id);
                    computer.setQuality(quality);
                    this.cart.replace(id, computer);
                    check = true;
                }
            }
        }catch (Exception e) {
           
        }
        return check;
    }
        public boolean remove(String id) {
        boolean check = false;
        try{
            if(this.cart != null){
                if(this.cart.containsKey(id)){
                    Computer computer = this.cart.get(id);
                    this.cart.remove(id, computer);
                    check = true;
                }
            }
        }catch (Exception e) {
           
        }
        return check;
    }
}
