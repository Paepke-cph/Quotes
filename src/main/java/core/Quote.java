package core;
public class Quote {
    private int id;
    private String author, text;
    public Quote(int id, String author, String text) {;
        this.id = id;
        this.author = author;
        this.text = text;
    }
    
    public int getID() {
        return id;
    }
    
    public String getAuthor() { return author;}
    public String getText() { return text;}
    
    @Override
    public String toString() {
        return author + ": " + text;
    }
}
