public class Card {
    private String term;
    private String definition;


public Card(String term,String definition){
    if(term==null || term.trim().isEmpty() || definition ==null || definition.trim().isEmpty()){
    throw new IllegalArgumentException("Error!! term and defination cannot be null or empty!!");
}
this.term=term;
this.definition=definition;
}

@Override
public String toString(){
    return definition;
}

public boolean attempt(String reply){
    if(reply==null){
    return false;
    }
    else{
        return reply.trim().toUpperCase().equals(term.toUpperCase());
    }
}

public String getTerm(){
    return term;
}
}



