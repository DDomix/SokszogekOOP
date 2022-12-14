package hu.petrik.sokszögek;

public class Haromszog extends Sokszog{
    private double b;
    private double c;

    public Haromszog() {
        super(getVeletlenOldal());
        this.b=(getVeletlenOldal());
        this.c=(getVeletlenOldal());
        while (!isSzerkesztheto()){
            super.setA((getVeletlenOldal()));
            this.b=getVeletlenOldal();
            this.c=getVeletlenOldal();
        }
    }

    private static double getVeletlenOldal() {
        return Math.random()*10+5;
    }

    public Haromszog(double a, double b, double c) {
        super(a);
        this.b = b;
        this.c = c;
        if (!this.isSzerkesztheto()){
            throw new IllegalArgumentException("SZAR");
        }
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
        if (!this.isSzerkesztheto()){
            throw new IllegalArgumentException("SZAR");
        }
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
        if (!this.isSzerkesztheto()){
            throw new IllegalArgumentException("SZAR");
        }
    }

    @Override
    public void setA(double a) {
        super.setA(a);
        if (!this.isSzerkesztheto()){
            throw new IllegalArgumentException("SZAR");
        }
    }

    private boolean isSzerkesztheto(){
        boolean szerkesztheto=true;
        if ((this.getA()+this.getB())<=this.getC()||
            (this.getA()+this.getC())<=this.getB()||
            (this.getB()+this.getC())<=this.getA()){
            szerkesztheto=false;
        }
        return szerkesztheto;
    }
    public double getKerulet(){
        return  this.getA()+this.getB()+this.getC();
    }
    private double getS(){
        return getKerulet()/2;
    }
    public double getTerulet(){
        return Math.sqrt(this.getS()*(this.getS()-getA())*(this.getS()-this.getB())*(this.getS()-this.getC()));
    }

    @Override
    public String toString() {
        return String.format("Háromszög a = %10.3f, b = %10.3f, c = %10.3f, %s",this.getA(),this.getB(),this.getC(),super.toString());
    }
}
