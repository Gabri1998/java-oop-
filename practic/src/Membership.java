


public class Membership {

         private String userName;
         private double storeCredit;
         private int memberPoints;

         public Membership(String userName, double initialCredit) {
         storeCredit = initialCredit;
         userName = userName;
         memberPoints = 0;
         }

         public void addCredit(double addedCredit) {
         this.storeCredit = this.storeCredit + addedCredit;
}

         public void addMemberPoints(int addedPoints) {
         this.memberPoints += addedPoints;
        }

         public void convertPoints(int numOfPoints) throws Exception {
                 if(this.memberPoints < numOfPoints || numOfPoints < 50) {
                     throw new Exception("Not enough points to convert.");
                     }
                 // Deduct points, convert to the corresponding credit
                 // value and add that credit to the membership.
                 this.memberPoints = this.memberPoints - numOfPoints;
                 double convertedCredits = numOfPoints * 0.20;
                 this.addCredit(convertedCredits);
                 }

         public String toString(){
                 String result = userName + ": Points = " + memberPoints + ". ";
                 result += "Credits: " + storeCredit;
                 return result;
                 }

         // getters.
         public String getUsername() { return this.userName; }
         public double getStoreCredit() { return storeCredit; }
         public int getMemberPoints() { return memberPoints; }
         }


