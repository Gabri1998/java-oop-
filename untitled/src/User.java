import java.util.ArrayList;
import java.util.List;

public   class User {
     private int birthYear;
     private String username;
     private List<String> friends;
     private List<Post> posts;


     public  User(String username, int birthYear) throws NameCannotBeEmptyException {

       this.username=username;
         if (this.username.isEmpty()) { throw new NameCannotBeEmptyException("Invalid user information. User’s name cannot be empty.");}
          this.birthYear=birthYear;
         if (this.birthYear > 2004) {
             throw new NameCannotBeEmptyException("Invalid user information. The user must be born after 2004.");
         }
     }

     public void addFriend(String friendName ){

             friends.add(friendName);
         }

         public void removeFriend (String friendName){
             friends.remove(friendName);
         }

         public void createPost (String content){
             posts.add(new Post(content));
         }

         public void createSponsoredPost (String content, String sponsor){
             posts.add(new SponsoredPost(content, sponsor));
         }

         //You can assume that there are getters and setters for all attributes.

         public List<String> getFriends () {
             return friends;
         }

         public void setFriends (List < String > friends) {
             this.friends = friends;
         }

         public String getUsername () {
             return username;
         }

         public void setUsername (String username){
             this.username = username;
         }

         public int getBirthYear () {
             return birthYear;
         }

         public void setBirthYear ( int birthYear){
             this.birthYear = birthYear;
         }

         public List<Post> getPosts () {
             return posts;
         }

         public void setPosts (List < Post > posts) {
             this.posts = posts;
         }

    public static void main(String[] args)  throws NameCannotBeEmptyException {
        User Ahmed = new User("Ahmed", 2005);

     }
}
