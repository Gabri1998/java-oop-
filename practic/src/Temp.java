  public class Temp{
    private double cel;
    private double far;


    // public Temp(double cel , double far) {
    //  this.cel=cel;
     // this.far=far;
   //}


    public double getCel(){
        return ((far-32)*5/9);
    }
    public void setCel(double cel){
        this.cel=cel;
    }
    public double getFar(){
        return ((cel*9/5)+32);
    }
    public void setFar(double far){
       this.far=far;
    }
}
