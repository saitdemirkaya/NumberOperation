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
		int blokSayisi = (basamakSayisi/3);// say�y� 3'erli bloklara b�lece�iz.Ka� blok oldu�unu blokSayisi tutar.
		if(basamakSayisi==3) {//3 basamakl� say� istisna
			blokSayisi=0;
		}
		/**
		 * BasamakSay�s� say�n�n ka� basamakl� oldu�unu bulur
		 * �rne�in say�m�z 1502789.Basamak say�s� 7.
		 * blokSayisi 2 olur ve burdaki 2, kat dizisindeki milyara denk gelir.
		 * D�ng�ye sokarak say�y� ba�tan okumaya ba�l�yoruz.
		 * 
		 */
		while(blokSayisi>=0) {
			/**
			 * blokSay�s�n� 1000'in �zerini alarak g�nderece�imiz ilk 3l�y� se�iyoruz
			 * D�ng� sonras�nda 2. 3'l�y� al�r.Ve blokSay�s� 0'dan k���k olana kadar okumaya devam eder.
			 * G�nderilecek say�y� belirledikten sonra mod i�lemi ile okumak i�in geriye kalan say�y� belirliyoruz.
			 */
			int g�nderilecekSayi = (int) (sayi / Math.pow(1000, blokSayisi));
			sayi = (int) (sayi%(Math.pow(1000, blokSayisi)));
		    ekranaBas(g�nderilecekSayi);		
				if(g�nderilecekSayi!=0) {// 0 de�ilse okumaya devam ediyoruz.
						System.out.print(kat[blokSayisi]+" ");// kat dizisindeki dizi indexini basar.milyar,bin vs..
				}			
			blokSayisi--;
		}
	}
	
	public static int basamak_sayisi(int sayi) {/*Ka� basamakl� oldu�unu belirler*/
		int x=1,y=1;
		while(sayi/x>9) {
			x=x*10;
			y++;
		}
		return y;
	}
	
	public static void ekranaBas(int sayi) {// B�l�nen 3l�lerin de�erini ekrana basar.
		switch(sayi/100) {// y�zler basama��
		case 1: System.out.print("y�z "); break;
		case 2: System.out.print("iki y�z "); break;
		case 3: System.out.print("�� y�z "); break;
		case 4: System.out.print("d�rt y�z "); break;
		case 5: System.out.print("be� y�z "); break;
		case 6: System.out.print("alt� y�z "); break;
		case 7: System.out.print("yedi y�z "); break;
		case 8: System.out.print("sekiz y�z "); break;
		case 9: System.out.print("dokuz y�z "); break;
		}
		switch((sayi%100)/10) {//onlar
		case 1: System.out.print("on "); break;
		case 2: System.out.print("yirmi "); break;
		case 3: System.out.print("otuz "); break;
		case 4: System.out.print("k�rk "); break;
		case 5: System.out.print("elli "); break;
		case 6: System.out.print("altm�� "); break;
		case 7: System.out.print("yetmi� "); break;
		case 8: System.out.print("seksen "); break;
		case 9: System.out.print("doksan "); break;
		}
		switch(sayi%10) {//birler
		case 1: System.out.print("bir "); break;
		case 2: System.out.print("iki "); break;
		case 3: System.out.print("�� "); break;
		case 4: System.out.print("d�rt "); break;
		case 5: System.out.print("be� "); break;
		case 6: System.out.print("alt� "); break;
		case 7: System.out.print("yedi "); break;
		case 8: System.out.print("sekiz "); break;
		case 9: System.out.print("dokuz "); break;
		
		}
	}
}