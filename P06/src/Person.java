import java.util.Objects;

public class Person{
    private String name;
    private String email;

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

    public String getName(){
        return name;
    }

    @Override
    public boolean equals(Object o){
        if(this==o) return true;
        if(o==null || this.getClass()!=o.getClass())
        return false;
        Person p=(Person) o;
        return(p.name ==this.name) && (p.email==this.email);
    }

    @Override
    public int hashCode(){
        return Objects.hash(name,email);
    }

    @Override
    public String toString(){
        return name + " (" + email + ")";
    }
}
    