package poo.study.carro;

public class Carro {
    
//    boolean ehEletrico;
    String status = "parado";
    double kmRodados = 0;
    boolean ligado = false;
    String cor;
    double tanque; //em litros
    double combustivel = 1; //percentagem
    int numPortas;
    double autonomia; //km por litro
    int marchaAtual; //0 para ré
    private boolean embreagemApertada = false;
    
    public Carro() {
        cor = "azul";
        numPortas = 4;
    }
    
    public void ligar() {
        if(marchaAtual == 0 && !ligado) {
            ligado = true;    
        }
    };
    
    public void desligar() {
        if(ligado) {
            ligado = false;    
        }
    };
    
    public void setMarchaAtual(int marcha) { //privar e mudar o nome, soltar a embreagem
        if(embreagemApertada) {
            marchaAtual = marcha;
        }
    };
    
    public void setEmbreagemApertada(boolean embreagem) {  //privar e mudar o nome
        embreagemApertada = embreagem;
    }
       
    public void andar() { //anda com base na autonomia, consumindo sempre um ponto do tanque
        status = "andando";
        kmRodados += autonomia;
        tanque--;
    };
    
    public void freiar() {
        if(!embreagemApertada) {
            desligar();
        }
        status = "parado";
    }
    
    public double getKmRodados() {
        return kmRodados;
    }
    
//    public void abastecer(double qtdCombustivel) {
//        if(tanque < maxTanque) {
//            double restante = maxTanque - tanque;
//            
//            double recarga = 0.1;
//            while(tanque < maxTanque && recarga < qtdCombustivel) {
//                tanque += recarga;
//                
//            }
//        }
//    }
    
    public static void main(String[] args) {
        Carro t = new Carro();
        System.out.println(t.cor);
    }
}
