package RetroalimentacionLineal;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class RetroalimentacionLineall {

	public static void main(String[] args) throws FileNotFoundException, IOException {
        String linea;
        
        
        FileInputStream fis = new FileInputStream("src/lfsr/EVideo.mp4");
        FileOutputStream wr = new FileOutputStream("src/lfsr/UEVideo.mp4");
        byte[] array = new byte[1];// 63,38,37,33,23,16,0
        long bit1, bit2, bit3, bit4, bit5, bit6, bit7,bitlfsr, lfsr = 785123, bitnuevo;
        while (fis.read(array) != -1) {
            bit1 = (lfsr >> 63)& 1;//tap 0
            bit2 = (lfsr >> 47) & 1;//tap 16
            bit3 = (lfsr >> 40) & 1;//tap 23
            bit4 = (lfsr >> 30) & 1;//tap 33
            bit5 = (lfsr >> 26) & 1;//tap 37
            bit6 = (lfsr >> 25) & 1;//tap 38
            bit7 = lfsr & 1;//tap 63
            bitnuevo = bit1 ^ bit2 ^ bit3 ^ bit4 ^ bit5 ^ bit6 ^ bit7;
            lfsr = lfsr >> 1;
            bitlfsr = lfsr & 1;
            lfsr = (lfsr & 9223372036854775807L) | (bitnuevo << 63);
            byte leido = array[0];
            if (bitlfsr == 1) {
                wr.write(leido ^ 255);
            } else {
                wr.write(leido ^ 0);
            }
        }

    }

}