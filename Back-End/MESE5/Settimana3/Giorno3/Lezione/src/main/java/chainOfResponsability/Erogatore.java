package chainOfResponsability;

public abstract class Erogatore {
    private Erogatore erogatoreSuccessivo;

    private int valoreBanconota;

    public Erogatore(Erogatore erogatoreSuccessivo, int valoreBanconota) {
        this.erogatoreSuccessivo = erogatoreSuccessivo;
        this.valoreBanconota = valoreBanconota;
    }

    public Erogatore() {
    }

    public Erogatore getErogatoreSuccessivo() {
        return erogatoreSuccessivo;
    }

    public void setErogatoreSuccessivo(Erogatore erogatoreSuccessivo) {
        this.erogatoreSuccessivo = erogatoreSuccessivo;
    }

    public int getValoreBanconota() {
        return valoreBanconota;
    }

    public void setValoreBanconota(int valoreBanconota) {
        this.valoreBanconota = valoreBanconota;
    }

    public void eroga(ContoBancario contoBancario){
       int saldo = contoBancario.getSaldo();
       int prelievoRimanente= contoBancario.getPrelievoRimanente();

       if(saldo>=valoreBanconota) {
           if(prelievoRimanente>=valoreBanconota) {
              int numeroBanconote=prelievoRimanente/valoreBanconota;
              contoBancario.setPrelievoRimanente(prelievoRimanente%valoreBanconota);
              contoBancario.setSaldo(saldo-numeroBanconote*valoreBanconota);
              System.out.println("Erogate "+numeroBanconote+" banconote di "+valoreBanconota+" €");
           }else {
               System.out.println("Erogate 0 banconote da " + valoreBanconota+" €");
           }
       }else {
           System.out.println("Saldo insufficiente");
       }

       if(erogatoreSuccessivo!=null){
           erogatoreSuccessivo.eroga(contoBancario);
       }
    }
}
