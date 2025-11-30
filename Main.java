import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // DATA MENU (ARRAY)
        Menu[] menu = {
            new Menu("Nasi Goreng", 25000, "Makanan"),
            new Menu("Ayam Bakar", 30000, "Makanan"),
            new Menu("Mie Ayam", 20000, "Makanan"),
            new Menu("Nasi Padang", 28000, "Makanan"),

            new Menu("Es Teh", 5000, "Minuman"),
            new Menu("Jus Jeruk", 10000, "Minuman"),
            new Menu("Kopi", 12000, "Minuman"),
            new Menu("Teh Manis", 6000, "Minuman")
        };

        // TAMPILKAN MENU
        System.out.println("===== MENU MAKANAN =====");
        tampilMenu(menu, "Makanan");

        System.out.println("\n===== MENU MINUMAN =====");
        tampilMenu(menu, "Minuman");

        // INPUT PESANAN
        System.out.println("\nMasukkan Pesanan Maks 4 Menu\n");

        System.out.print("Pesanan 1 (nama menu): ");
        String p1 = input.nextLine();
        System.out.print("Jumlah: ");
        int q1 = input.nextInt(); input.nextLine();

        System.out.print("Pesanan 2 (nama menu / kosongkan): ");
        String p2 = input.nextLine();
        int q2 = 0;
        if (!p2.equals("")) {
            System.out.print("Jumlah: ");
            q2 = input.nextInt(); input.nextLine();
        }

        System.out.print("Pesanan 3 (nama menu / kosongkan): ");
        String p3 = input.nextLine();
        int q3 = 0;
        if (!p3.equals("")) {
            System.out.print("Jumlah: ");
            q3 = input.nextInt(); input.nextLine();
        }

        System.out.print("Pesanan 4 (nama menu / kosongkan): ");
        String p4 = input.nextLine();
        int q4 = 0;
        if (!p4.equals("")) {
            System.out.print("Jumlah: ");
            q4 = input.nextInt();
        }

        // HITUNG HARGA
        int total1 = hitungHarga(menu, p1, q1);
        int total2 = hitungHarga(menu, p2, q2);
        int total3 = hitungHarga(menu, p3, q3);
        int total4 = hitungHarga(menu, p4, q4);

        int subtotal = total1 + total2 + total3 + total4;

        // PROMO BELI 1 GRATIS 1 UNTUK MINUMAN (JIKA TOTAL > 50000)
        int promoMinuman = 0;
        if (subtotal > 50000) {
            promoMinuman = getMinumanTermurah(menu);
        }

        // DISKON 10% JIKA >100000
        double diskon = 0;
        if (subtotal > 100000) {
            diskon = subtotal * 0.10;
        }

        double hargaSetelahDiskon = subtotal - diskon - promoMinuman;

        // PAJAK DAN SERVICE
        double pajak = hargaSetelahDiskon * 0.10;
        int service = 20000;

        double totalBayar = hargaSetelahDiskon + pajak + service;

        // CETAK STRUK
        System.out.println("\n========== STRUK PEMBAYARAN ==========");
        cetakItem(menu, p1, q1);
        cetakItem(menu, p2, q2);
        cetakItem(menu, p3, q3);
        cetakItem(menu, p4, q4);

        System.out.println("-------------------------------------");
        System.out.println("Subtotal           : Rp " + subtotal);
        System.out.println("Diskon             : Rp " + diskon);
        System.out.println("Promo Minuman      : Rp " + promoMinuman);
        System.out.println("Harga Setelah Disk : Rp " + hargaSetelahDiskon);
        System.out.println("Pajak 10%          : Rp " + pajak);
        System.out.println("Biaya Pelayanan    : Rp " + service);
        System.out.println("TOTAL BAYAR        : Rp " + totalBayar);
        System.out.println("=====================================");

        input.close();
    }

    // METHOD MENAMPILKAN MENU
    static void tampilMenu(Menu[] menu, String kategori) {
        for (int i = 0; i < menu.length; i++) {
            if (menu[i].kategori.equalsIgnoreCase(kategori)) {
                System.out.println("- " + menu[i].nama + " : Rp " + menu[i].harga);
            }
        }
    }

    // METHOD HITUNG HARGA
    static int hitungHarga(Menu[] menu, String nama, int qty) {
        for (int i = 0; i < menu.length; i++) {
            if (menu[i].nama.equalsIgnoreCase(nama)) {
                return menu[i].harga * qty;
            }
        }
        return 0;
    }

    // MENCARI MINUMAN TERMURAH
    static int getMinumanTermurah(Menu[] menu) {
        int termurah = 999999;
        for (int i = 0; i < menu.length; i++) {
            if (menu[i].kategori.equals("Minuman")) {
                if (menu[i].harga < termurah) {
                    termurah = menu[i].harga;
                }
            }
        }
        return termurah;
    }

    // CETAK ITEM STRUK
    static void cetakItem(Menu[] menu, String nama, int qty) {
        if (!nama.equals("")) {
            for (int i = 0; i < menu.length; i++) {
                if (menu[i].nama.equalsIgnoreCase(nama)) {
                    int total = menu[i].harga * qty;
                    System.out.println(nama + " x " + qty + " = Rp " + total);
                }
            }
        }
    }
}
