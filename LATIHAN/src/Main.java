import java.util.ArrayList;
class Main {
    public static void main(String[] args) {

        LampuPintar lampuKamar = new LampuPintar();
        PerangkatPintar acRuangTamu = new AcPintar();  
        
        System.out.println("--- PUSAT KONTROL PERANGKAT ---");
        lampuKamar.aktifkan(); 
        lampuKamar.aturKecerahan(80); 
        lampuKamar.aturKecerahan(45, "Merah"); 
       
        ArrayList<PerangkatPintar> daftarPerangkat = new ArrayList<>();


        daftarPerangkat.add(lampuKamar);
        daftarPerangkat.add(acRuangTamu);

        System.out.println("\n--- Menelusuri Koleksi Perangkat ---");
        for (PerangkatPintar perangkat : daftarPerangkat) {
            perangkat.aktifkan();
            if (perangkat instanceof AcPintar) {
                AcPintar ac = (AcPintar) perangkat; 
                ac.aturSuhu(22);
            }
        }

        // No 3 ini dapat terjadi karena kombinasi dari 
        // konsep Upcasting dan Runtime Polymorphism di dalam Java
        // Upcasting Saat kita menugaskan objek LampuPintar 
        // dan AcPintar ke dalam variabel bertipe PerangkatPintar, kita melakukan upcasting. 
        // Ini adalah konversi yang aman dan otomatis di mana referensi dari subclass disimpan 
        // di dalam variabel superclass. Oleh karena itu, ArrayList melihat kumpulan objek tersebut secara seragam sebagai PerangkatPintar
        // dan Kecerdasan Runtime Polymorphism: Meskipun referensi variabelnya adalah superclass, 
        // Java menentukan versi metode mana yang akan dieksekusi pada saat program berjalan (runtime) 
        // berdasarkan wujud asli objek di dalam memori, bukan berdasarkan tipe referensinya
        // Efek Method Overriding: Karena kelas LampuPintar dan AcPintar telah menyediakan 
        // implementasi spesifik dengan menimpa (override) metode aktifkan() milik induknya, 
        // maka saat perulangan memanggil perangkat.aktifkan(), Java secara otomatis mengeksekusi 
        // logika fungsi dari masing-masing subclass tersebut. Sinergi antara ArrayList dan Inheritance 
        // inilah yang membuat program menjadi fleksibel dan dinamis




        System.out.println("---Orang Junior---");

       PerangkatPintar alat1 = new LampuPintar();
       // 5. alat1.aturKecerahan(75, "Putih");
       // "cannot find symbol" terjadi karena adanya 
       // aturan ketat dari kompiler Java terkait konsep 
       // Upcasting pada saat Compile-time 
       //Karena metode aturKecerahan() adalah hasil Method Overloading (fitur spesifik) 
       // yang hanya ada di kelas LampuPintar dan tidak pernah dideklarasikan di dalam kelas 
       // induk PerangkatPintar, kompiler langsung menolaknya dengan error "cannot find symbol" 
       // karena metode tersebut dianggap tidak ada pada referensi yang digunakan.
       // Variabel dengan referensi Superclass hanya diizinkan untuk memanggil metode milik Superclass itu sendiri

       // cara perbaiki kode
        
        if (alat1 instanceof LampuPintar) {
            LampuPintar lampu = (LampuPintar) alat1; 
            lampu.aturKecerahan(75, "Putih"); 
        }

        
    }
}