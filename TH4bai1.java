import java.util.ArrayList;
import java.util.Scanner;
 
class GiaoDich {
    private String maGiaoDich, ngayGiaoDich;
    private long donGia;
    private float dienTich;
    Scanner scanner = new Scanner(System.in);
     
    public GiaoDich() {
        super();
    }
 
    public GiaoDich(String maGiaoDich, String ngayGiaoDich, long donGia, float dienTich) {
        super();
        this.maGiaoDich = maGiaoDich;
        this.ngayGiaoDich = ngayGiaoDich;
        this.donGia = donGia;
        this.dienTich = dienTich;
    }
 
    public String getMaGiaoDich() {
        return maGiaoDich;
    }
 
    public void setMaGiaoDich(String maGiaoDich) {
        this.maGiaoDich = maGiaoDich;
    }
 
    public String getNgayGiaoDich() {
        return ngayGiaoDich;
    }
 
    public void setNgayGiaoDich(String ngayGiaoDich) {
        this.ngayGiaoDich = ngayGiaoDich;
    }
 
    public long getDonGia() {
        return donGia;
    }
 
    public void setDonGia(long donGia) {
        this.donGia = donGia;
    }
 
    public float getDienTich() {
        return dienTich;
    }
 
    public void setDienTich(float dienTich) {
        this.dienTich = dienTich;
    }
     
    public void nhap() {
        System.out.print("Nhap ma giao dich: ");
        maGiaoDich = scanner.nextLine();
        System.out.print("Nhap ngay giao dich (ngay/thang/nam): ");
        ngayGiaoDich = scanner.nextLine();
        System.out.print("Nhap don gia: ");
        donGia = Long.parseLong(scanner.nextLine());
        System.out.print("Nhap dien tich: ");
        dienTich = Float.parseFloat(scanner.nextLine());
    }
     
    @Override
    public String toString() {
        return "Ma Giao Dich: " + this.maGiaoDich + ", Ngay Giao Dich: " + this.ngayGiaoDich + 
            ", Don Gia: " + this.donGia + ", Dien Tich: " + this.dienTich;
    }
}
class GiaoDichDat extends GiaoDich {
    private String loaiDat;
 
    public GiaoDichDat() {
        super();
    }
 
    public GiaoDichDat(String loaiDat) {
        super();
        this.loaiDat = loaiDat;
    }
 
    public String getLoaiDat() {
        return loaiDat;
    }
 
    public void setLoaiDat(String loaiDat) {
        this.loaiDat = loaiDat;
    }
     
    public void nhap() {
        super.nhap();
        System.out.print("Nhap loai dat (A/B/C): ");
        loaiDat = scanner.nextLine();
    }
 
    @Override
    public String toString() {
        return super.toString() + ", loai dat: " + this.loaiDat;
    }
}

 
class GiaoDichNha extends GiaoDich {
    private String loaiNha, diaChi;
    private int choose;
     
    public GiaoDichNha() {
        super();
    }
 
    public GiaoDichNha(String loaiNha, String diaChi) {
        super();
        this.loaiNha = loaiNha;
        this.diaChi = diaChi;
    }
 
    public String getLoaiNha() {
        return loaiNha;
    }
 
    public void setLoaiNha(String loaiNha) {
        this.loaiNha = loaiNha;
    }
 
    public String getDiaChi() {
        return diaChi;
    }
 
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
     
    public void nhap() {
        super.nhap();
        System.out.print("Nhap dia chi: ");
        diaChi = scanner.nextLine();
        System.out.print("Nhap loai nha (0: cao cap, 1: thuong): ");
        choose = scanner.nextInt();
        switch (choose) {
            case 0:
                loaiNha = "cao cap";
                break;
            case 1: 
                loaiNha = "thuong";
                break;
            default:
                System.out.println("Chon so khong hop le.");
                break;
        }
    }
     
    @Override
    public String toString() {
        return super.toString() + ", Loai Nha: " + this.loaiNha + ", DiaChi: " + this.diaChi;
    }
}


 
public class TH4bai1 {
 
    public static void main(String[] args) {
        ArrayList<GiaoDichNha> arrGiaoDichNha = new ArrayList<>();
        ArrayList<GiaoDichDat> arrGiaoDichDat = new ArrayList<>();
        int soGiaoDichDat = 0, soGiaoDichNha = 0;
        long tongTienGiaoDichDat = 0, trungBinhThanhTien = 0;
        Scanner scanner = new Scanner(System.in);
         
        System.out.print("Nhap so giao dich dat: ");
        soGiaoDichDat = scanner.nextInt();
        System.out.print("Nhap so giao dich nha: ");
        soGiaoDichNha = scanner.nextInt();
         
        System.out.println("Nhap thong tin giao dich dat:");
        for (int i = 0; i < soGiaoDichDat; i++) {
            System.out.println("Nhap thong tin giao dich dat thu " + (i + 1) + ":");
            GiaoDichDat giaoDichDat = new GiaoDichDat();
            giaoDichDat.nhap();
            arrGiaoDichDat.add(giaoDichDat);
        }
         
        System.out.println("Nhap thong tin giao dich nha:");
        for (int i = 0; i < soGiaoDichNha; i++) {
            System.out.println("Nhap thong tin giao dich nha thu " + (i + 1) + ":");
            GiaoDichNha giaoDichNha = new GiaoDichNha();
            giaoDichNha.nhap();
            arrGiaoDichNha.add(giaoDichNha);
        }
         
        System.out.println("---Thong tin giao dich dat---");
        for (int i = 0; i < arrGiaoDichNha.size(); i++) {
            System.out.println(arrGiaoDichDat.get(i).toString());
        }
         
        System.out.println("---Thong tin giao dich nha---");
        for (int i = 0; i < arrGiaoDichNha.size(); i++) {
            System.out.println(arrGiaoDichNha.get(i).toString());
        }
         
        for (int i = 0; i < arrGiaoDichDat.size(); i++) {
            if (arrGiaoDichDat.get(i).getLoaiDat().equalsIgnoreCase("A")) {
                tongTienGiaoDichDat += arrGiaoDichDat.get(i).getDienTich() * 
                    arrGiaoDichDat.get(i).getDonGia() * 1.5;
            } else if (arrGiaoDichDat.get(i).getLoaiDat().equalsIgnoreCase("B") || 
                    arrGiaoDichDat.get(i).getLoaiDat().equalsIgnoreCase("C")) {
                tongTienGiaoDichDat += arrGiaoDichDat.get(i).getDienTich() * 
                    arrGiaoDichDat.get(i).getDonGia();
            }
        }
        trungBinhThanhTien = tongTienGiaoDichDat / (arrGiaoDichDat.size());
        System.out.println("Trung binh thanh tien giao dich dat = " + trungBinhThanhTien);
         
        // xuất ra các giao dịch của tháng 9 năm 2013
        System.out.println("Cac giao dich dat cua thang 9 nam 2013: ");
        for (int i = 0; i < arrGiaoDichDat.size(); i++) {
            String[] dateGiaoDichDat = arrGiaoDichDat.get(i).getNgayGiaoDich().split("/");
            if (dateGiaoDichDat[1].equals("9") && dateGiaoDichDat[2].equals("2013")) {
                System.out.println(arrGiaoDichDat.get(i).toString());
            }
        }
         
        System.out.println("Cac giao dich nha cua thang 9 nam 2013: ");
        for (int i = 0; i < arrGiaoDichNha.size(); i++) {
            String[] dateGiaoDichNha = arrGiaoDichNha.get(i).getNgayGiaoDich().split("/");
            if (dateGiaoDichNha[1].equals("9") && dateGiaoDichNha[2].equals("2013")) {
                System.out.println(arrGiaoDichNha.get(i).toString());
            }
        }
    }
 
}