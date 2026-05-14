class LayananInternasional extends LayananEkspedisi {
    // Atribut tambahan spesifik 
    private String negaraTujuan;
    private double nilaiBarangUSD;

    public LayananInternasional(String nomorResi, double beratAktualKg, double panjang, double lebar, double tinggi, String negaraTujuan, double nilaiBarangUSD) {
        super(nomorResi, beratAktualKg, panjang, lebar, tinggi);
        this.negaraTujuan = negaraTujuan;
        this.nilaiBarangUSD = nilaiBarangUSD;
    }

    // Overriding: Tarif Rp 200.000/Kg dan logika pajak 
    @Override
    public double hitungOngkir() {
        double ongkirDasar = 200000 * hitungBeratEfektif();
        
        // Pajak Bea Cukai 20% jika barang > 50 USD
        if (nilaiBarangUSD > 50) {
            double pajak = 0.20 * ongkirDasar;
            return ongkirDasar + pajak;
        }
        
        return ongkirDasar;
    }

    // Metode Spesifik kelas Internasional
    public void cetakManifest() {
        System.out.println("Manifest Internasional ke " + negaraTujuan + " - Deklarasi Nilai: $" + nilaiBarangUSD);
    }
}