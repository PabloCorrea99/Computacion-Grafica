public class EcParSegReg{
    private double x1,y1,x2,y2;

    public EcParSegReg(double x1, double y1, double x2, double y2){
        this.x1=x1;
        this.y1=y1;
        this.x2=x2;
        this.y2=y2;
    }

    public EcParSegReg(){
        this.x1 = 0;
        this.y1 = 0;
        this.x2 = 0;
        this.y2 = 0;

    }

    public double getX1(){
        return x1;
    }
    public double getY1(){
        return y1;
    }
    public double getX2(){
        return x2;
    }
    public double getY2(){
        return y2;
    }

    public void setX1(double x1){
        this.x1=x1;
    }
    public void setY1(double y1){
        this.y1=y1;
    }
    public void setX2(double x2){
        this.x2=x2;
    }
    public void setY2(double y2){
        this.y2=y2;
    }

    public static double [] solve (EcParSegReg e1, EcParSegReg e2){
        
        double [] result = {0,0};

        double ecu1X1 = e1.getX1();
        double ecu1Y1 = e1.getY1();
        double ecu1X2 = e1.getX2();
        double ecu1Y2 = e1.getY2();
        double ecu2X1 = e2.getX1();
        double ecu2Y1 = e2.getY1();
        double ecu2X2 = e2.getX2();
        double ecu2Y2 = e2.getY2();

        double ecu1M = (ecu1Y2-ecu1Y1)/(ecu1X2-ecu1X1);
        double ecu2M = (ecu2Y2-ecu2Y1)/(ecu2X2-ecu2X1);
        double ecu1b, ecu2b;
        double x, y;

        double u1, u2;

        if(ecu1M != ecu2M){

            ecu1b = ((ecu1Y2 - ecu1Y1)*((0-ecu1X1)/(ecu1X2-ecu1X1)))+ecu1Y1; 
            ecu2b = ((ecu2Y2 - ecu2Y1)*((0-ecu2X1)/(ecu2X2-ecu2X1)))+ecu2Y1;
            x = (ecu2b-ecu1b)/(ecu1M-ecu2M);//Coordenada en X donde se cruzan
            y = (ecu1M*x)+ecu1b;//Coordenada en Y donde se cruzan 

            u1 = (x-ecu1X1)/(ecu1X2-ecu1X1);
            u2 = (y-ecu2Y1)/(ecu2Y2-ecu2Y1);

            result[0]=u1;
            result[1]=u2;

        }
        else{
            System.out.println("Son Paralelas, no hay solución!");
        }
        return result;
        
        
    }



}