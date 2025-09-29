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


    public void addReply(String text, Person author){
        if(text==null || text.isEmpty()){
            throw new IllegalArgumentException("Text must not be empty or null");
        }
        if(author==null){
            throw new IllegalArgumentException("author must not be null");
        }
    }


    public int numReplies(){
            return replies.size();
        }

    public Comment getReply(int index){
        return replies.get(index);
    }

    public Comment getInReplyTo(){
        return inReplyTo;
    }

    




        
    }



    

