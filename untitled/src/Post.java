public class Post {
    private String content;
    private int numOfLikes=0 ;

public  Post(String content) {
    this.content = content;

}
 public void like(){
     this.numOfLikes = getNumOfLikes()+1 ;
 }
public void disLike(){
    if( this.numOfLikes<0) {
    this.numOfLikes = getNumOfLikes() - 1; }
    else this.numOfLikes= 0;

}
public void editPost (String newContent){
    this.content = newContent;
}
public int getLength(String content){
    return  content.length();
}
public String toString(){
    return  getContent() + getNumOfLikes() +" Like.";
}

    public int getNumOfLikes() {
        return numOfLikes;
    }

    public void setNumOfLikes(int numOfLikes) {
        this.numOfLikes = numOfLikes;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
