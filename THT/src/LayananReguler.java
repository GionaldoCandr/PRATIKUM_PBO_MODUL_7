class LayananReguler extends LayananEkspedisi {
    
    // Konstruktor memanggil super() 
    public LayananReguler(String nomorResi, double beratAktualKg, double panjang, double lebar, double tinggi) {
        super(nomorResi, beratAktualKg, panjang, lebar, tinggi);
    }

    // Overriding: Menimpa metode induk dengan tarif Rp 15.000/Kg 
    @Override
    public double hitungOngkir() {
        return 15000 * hitungBeratEfektif();
    }

    // Overloading: Nama metode sama (hitungOngkir) tapi memiliki parameter berbeda 
    public double hitungOngkir(boolean isMember, int jarakKm) {
        // Ambil tarif dasar dengan memanggil metode override
        double tarifDasar = hitungOngkir();
        
        // Diskon 10% jika member
        if (isMember) {
            tarifDasar -= (0.10 * tarifDasar);
        }
        
        // Tambahan surcharge jarak jauh
        double totalOngkir = tarifDasar + (500 * jarakKm);
        return totalOngkir;
    }
}
