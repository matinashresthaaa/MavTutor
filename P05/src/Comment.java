import java.util.ArrayList;

public class Comment {
    private String text;
    private Person author;
    private Comment inReplyTo;
    private ArrayList<Comment> replies;

    public Comment(String text, Person author, Comment inReplyTo){
        if(text==null || text.isEmpty()){
            throw new IllegalArgumentException("text is null or empty");
        }
        if(author==null || author.isEmpty()){
            throw new IllegalArgumentException("author is empty or null");
        }
        this.text=text;
        this.author=author;
        this.inReplyTo=inReplyTo;
        this.replies=new ArrayList<>();
    }



    
}
