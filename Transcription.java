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
		int blokSayisi = (basamakSayisi/3);// sayıyı 3'erli bloklara böleceğiz.Kaç blok olduğunu blokSayisi tutar.
		/**
		 * BasamakSayısı sayının kaç basamaklı olduğunu bulur
		 * Örneğin sayımız 1502789.Basamak sayısı 7.
		 * blokSayisi 2 olur ve burdaki 2, kat dizisindeki milyara denk gelir.
		 * Döngüye sokarak sayıyı baştan okumaya başlıyoruz.
		 * 
		 */
		while(blokSayisi>=0) {
			/**
			 * blokSayısını 1000'in üzerini alarak göndereceğimiz ilk 3lüyü seçiyoruz
			 * Döngü sonrasında 2. 3'lüyü alır.Ve blokSayısı 0'dan küçük olana kadar okumaya devam eder.
			 * Gönderilecek sayıyı belirledikten sonra mod işlemi ile okumak için geriye kalan sayıyı belirliyoruz.
			 */
			int gönderilecekSayi = (int) (sayi / Math.pow(1000, blokSayisi));
			sayi = (int) (sayi%(Math.pow(1000, blokSayisi)));
		    ekranaBas(gönderilecekSayi);		
				if(gönderilecekSayi!=0) {// 0 değilse okumaya devam ediyoruz.
						System.out.print(kat[blokSayisi]+" ");// kat dizisindeki dizi indexini basar.milyar,bin vs..
				}			
			blokSayisi--;
		}
	}
	
	public static int basamak_sayisi(int sayi) {/*Kaç basamaklı olduğunu belirler*/
		int x=1,y=1;
		while(sayi/x>9) {
			x=x*10;
			y++;
		}
		return y;
	}
	
	public static void ekranaBas(int sayi) {// Bölünen 3lülerin değerini ekrana basar.
		switch(sayi/100) {// yüzler basamağı
		case 1: System.out.print("yüz "); break;
		case 2: System.out.print("iki yüz "); break;
		case 3: System.out.print("üç yüz "); break;
		case 4: System.out.print("dört yüz "); break;
		case 5: System.out.print("beş yüz "); break;
		case 6: System.out.print("altı yüz "); break;
		case 7: System.out.print("yedi yüz "); break;
		case 8: System.out.print("sekiz yüz "); break;
		case 9: System.out.print("dokuz yüz "); break;
		}
		switch((sayi%100)/10) {//onlar
		case 1: System.out.print("on "); break;
		case 2: System.out.print("yirmi "); break;
		case 3: System.out.print("otuz "); break;
		case 4: System.out.print("kırk "); break;
		case 5: System.out.print("elli "); break;
		case 6: System.out.print("altmış "); break;
		case 7: System.out.print("yetmiş "); break;
		case 8: System.out.print("seksen "); break;
		case 9: System.out.print("doksan "); break;
		}
		switch(sayi%10) {//birler
		case 1: System.out.print("bir "); break;
		case 2: System.out.print("iki "); break;
		case 3: System.out.print("üç "); break;
		case 4: System.out.print("dört "); break;
		case 5: System.out.print("beş "); break;
		case 6: System.out.print("altı "); break;
		case 7: System.out.print("yedi "); break;
		case 8: System.out.print("sekiz "); break;
		case 9: System.out.print("dokuz "); break;
		
		}
	}
}
