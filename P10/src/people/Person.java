package people;

import java.util.ArrayList;
import java.util.Objects;
import java.util.List;
import java.io.PrintStream;

import rating.Rateable;
import rating.Rating;

import java.util.Scanner;

public class Person implements Rateable{
    private String name;
    private String email;
    private List <Rating> ratings=new ArrayList<>();


    public Person(String name, String email){
        if(name==null || name.isEmpty()){
            throw new IllegalArgumentException("Name is empty or null");
        }
        if(email==null || email.isEmpty()){
            throw new IllegalArgumentException("Email is empty or null");
        }

        this.name=name;
        this.email=email;
    }

    public Person(Scanner in){
        this.name=in.nextLine();
        this.email=in.nextLine();
    }

    public void save (PrintStream out){
        out.println(name);
        out.println(email);
    }

    public String getName(){
        return name;
    }

    @Override
    public boolean equals(Object o){
        if(this==o) return true;
        if(o==null || this.getClass()!=o.getClass())
        return false;
        Person p=(Person) o;
        return name.equals(p.name) && email.equals(p.email);
    }

    @Override
    public int hashCode(){
        return Objects.hash(name,email);
    }

    @Override
    public String toString(){
        return name + " (" + email + ")";
    }

    @Override
    public void addRating(Rating rating) {
        ratings.add(rating);
    }
    @Override
    public double getAverageRating() {
        double sum = 0;
        for(Rating r : ratings) sum += r.getStars();
        return sum / ratings.size();
    }
    @Override
    public Rating[] getRatings() {
        return ratings.toArray(new Rating[ratings.size()]);
    }

    }

    