import java.util.Scanner;
public class Transcription {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Number: \n");		
		boolean durum =false;
		while(durum!=true) {
			int sayi = input.nextInt();
			if(sayi<=0) {
				System.out.println("Enter a positive number:");
			}else {
				yazdir(sayi);
				durum=true;
			}
		}	
	}
	public static void yazdir(int sayi) {
		int basamakSayisi = basamak_sayisi(sayi);
		String kat[] = {"","bin","milyon","milyar"};
		int blokSayisi = (basamakSayisi/3);// sayýyý 3'erli bloklara böleceðiz.Kaç blok olduðunu blokSayisi tutar.
		if(basamakSayisi==3) {//3 basamaklý sayý istisna
			blokSayisi=0;
		}
		/**
		 * BasamakSayýsý sayýnýn kaç basamaklý olduðunu bulur
		 * Örneðin sayýmýz 1502789.Basamak sayýsý 7.
		 * blokSayisi 2 olur ve burdaki 2, kat dizisindeki milyara denk gelir.
		 * Döngüye sokarak sayýyý baþtan okumaya baþlýyoruz.
		 * 
		 */
		while(blokSayisi>=0) {
			/**
			 * blokSayýsýný 1000'in üzerini alarak göndereceðimiz ilk 3lüyü seçiyoruz
			 * Döngü sonrasýnda 2. 3'lüyü alýr.Ve blokSayýsý 0'dan küçük olana kadar okumaya devam eder.
			 * Gönderilecek sayýyý belirledikten sonra mod iþlemi ile okumak için geriye kalan sayýyý belirliyoruz.
			 */
			int gönderilecekSayi = (int) (sayi / Math.pow(1000, blokSayisi));
			sayi = (int) (sayi%(Math.pow(1000, blokSayisi)));
		    ekranaBas(gönderilecekSayi);		
				if(gönderilecekSayi!=0) {// 0 deðilse okumaya devam ediyoruz.
						System.out.print(kat[blokSayisi]+" ");// kat dizisindeki dizi indexini basar.milyar,bin vs..
				}			
			blokSayisi--;
		}
	}
	
	public static int basamak_sayisi(int sayi) {/*Kaç basamaklý olduðunu belirler*/
		int x=1,y=1;
		while(sayi/x>9) {
			x=x*10;
			y++;
		}
		return y;
	}
	
	public static void ekranaBas(int sayi) {// Bölünen 3lülerin deðerini ekrana basar.
		switch(sayi/100) {// yüzler basamaðý
		case 1: System.out.print("yüz "); break;
		case 2: System.out.print("iki yüz "); break;
		case 3: System.out.print("üç yüz "); break;
		case 4: System.out.print("dört yüz "); break;
		case 5: System.out.print("beþ yüz "); break;
		case 6: System.out.print("altý yüz "); break;
		case 7: System.out.print("yedi yüz "); break;
		case 8: System.out.print("sekiz yüz "); break;
		case 9: System.out.print("dokuz yüz "); break;
		}
		switch((sayi%100)/10) {//onlar
		case 1: System.out.print("on "); break;
		case 2: System.out.print("yirmi "); break;
		case 3: System.out.print("otuz "); break;
		case 4: System.out.print("kýrk "); break;
		case 5: System.out.print("elli "); break;
		case 6: System.out.print("altmýþ "); break;
		case 7: System.out.print("yetmiþ "); break;
		case 8: System.out.print("seksen "); break;
		case 9: System.out.print("doksan "); break;
		}
		switch(sayi%10) {//birler
		case 1: System.out.print("bir "); break;
		case 2: System.out.print("iki "); break;
		case 3: System.out.print("üç "); break;
		case 4: System.out.print("dört "); break;
		case 5: System.out.print("beþ "); break;
		case 6: System.out.print("altý "); break;
		case 7: System.out.print("yedi "); break;
		case 8: System.out.print("sekiz "); break;
		case 9: System.out.print("dokuz "); break;
		
		}
	}
}