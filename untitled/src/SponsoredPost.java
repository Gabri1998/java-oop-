public class SponsoredPost extends Post {
    final String sponsor;

   public SponsoredPost(String content, String sponsor){
       super(content);
       this.sponsor = sponsor;
   }

}
