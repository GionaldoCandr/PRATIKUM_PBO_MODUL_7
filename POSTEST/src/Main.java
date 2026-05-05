import java.util.ArrayList;


public class Main {
    public static void main(String[] args) throws Exception {

        ArrayList<MetodePembayaran> daftarPembayaran = new ArrayList<>();

        daftarPembayaran.add(new KartuKredit());
        daftarPembayaran.add(new EWallet());

        MetodePembayaran ovo = new EWallet();
        MetodePembayaran cc = new KartuKredit();

        daftarPembayaran.add(ovo);
        daftarPembayaran.add(cc);

        int urutan = 1;
        for (MetodePembayaran metode : daftarPembayaran) {
            System.out.println("\n--- Memproses Transaksi " + urutan + " ---");

            metode.bayar(100000);

            if (metode instanceof EWallet) {
                EWallet dompetDigital = (EWallet) metode;
                
                dompetDigital.bayar(100000, "088888888880");
                
            } else if (metode instanceof KartuKredit) {
                KartuKredit kartu = (KartuKredit) metode;
                
                kartu.verifikasiPIN();
            }
            urutan++;
        }



    }
}
