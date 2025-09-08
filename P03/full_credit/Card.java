public class Card{
    private String term;
    private String definition;
}

public Card(String term,String defination){
    if(term==null || term.trim().isEmpty() || definition ==null || definition.trim().isEmpty()){
    System.out.println("Error!! term and defination cannot be null or empty!!");
}
this.term=term;
this.defination=definition;
}

@Override
public String toString(){
    return definition;
}

