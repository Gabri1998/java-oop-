package products;

public class Review
{
 private  final String comment;
 private final int grade;

 public Review(int grade, String comment)
 {
  this.comment = comment;
  this.grade = grade;
 }

 public  int getGrade()
 {
  return  this.grade;
 }
 public  String getComment()
 {
  return  this.comment;
 }

    public boolean equals(Object objOther) {
        if(this == objOther) {
            return true;
        } else if(objOther == null) {
            return false;
        } else if(objOther instanceof Review) {
            Review review = (Review) objOther;
            return this.grade == review.grade && this.comment.equals(review.comment);
        }
        return false;
    }

    public String toString() {
        return String.format("Grade: %d.%s", this.grade, this.comment);
    }

}
