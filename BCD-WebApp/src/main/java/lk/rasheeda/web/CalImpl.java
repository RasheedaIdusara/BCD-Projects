package lk.rasheeda.web;

import jakarta.ejb.Stateless;

@Stateless
public class CalImpl implements Cal {

    public void getResult(int i1, int i2){
        System.out.println("Cal : getResult");
        System.out.println(i1 + i2);
    }
}
