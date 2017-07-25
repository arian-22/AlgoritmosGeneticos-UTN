package greedy;

class Elemento {
    String nombre;
    double valor;
    double peso;
    Elemento(double p, double v) {
    
        valor =v;
        peso  =p;
    }
    public String toString() {
        return String.format(" %,12.2f %,12.2f", valor, peso);
    }
}
