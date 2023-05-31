/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Valuator;
/**
 *
 * @author ondre
 */
public class State {
    private String name;
    private double growth;

    public State(String name, double growth) {
        this.name = name;
        this.growth = growth;
    }

    public String getName() {
        return name;
    }

    public double getGrowth() {
        return growth;
    }

    @Override
    public String toString() {
        return name;
    }
    
}
