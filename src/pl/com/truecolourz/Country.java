package pl.com.truecolourz;

import javax.swing.*;

public class Country {

   private String name;
   private String capital;
   private int population;
   private ImageIcon img;

    public Country(String name, String capital, int population, ImageIcon img) {
        this.name = name;
        this.capital = capital;
        this.population = population;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public ImageIcon getImg() {
        return img;
    }

    public void setImg(ImageIcon img) {
        this.img = img;
    }
}
