package com.lambdaschool.countries;

public class Country {
    public String name;
    public int population;
    public int mass;
    public int medianAge;

    public Country(String name, int population, int mass, int medianAge) {
        this.name = name;
        this.population = population;
        this.mass = mass;
        this.medianAge = medianAge;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getMass() {
        return mass;
    }

    public void setMass(int mass) {
        this.mass = mass;
    }

    public int getMedianAge() {
        return medianAge;
    }

    public void setMedianAge(int medianAge) {
        this.medianAge = medianAge;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", population=" + population +
                ", mass=" + mass +
                ", medianAge=" + medianAge +
                '}';
    }
}
