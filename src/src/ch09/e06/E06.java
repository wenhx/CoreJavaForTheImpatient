package ch09.e06;

import java.io.IOException;
import java.io.RandomAccessFile;

public class E06 {
    public static void run() {
        String filePath = "src\\ch09\\e06\\sample.bmp";
        //The code was generated by ChatGPT-4.
        //this program assumes that BMP file has a BITMAPINFOHEADER (40 bytes size of header) and uses 24 bits per pixel.
        //Actual BMP files can have different formats and this code may not work correctly with them.
        try (RandomAccessFile raf = new RandomAccessFile(filePath, "rw")) {
            // Read header
            byte[] header = new byte[54];
            raf.read(header);

            // Get important data
            int dataOffset = getIntLittleEndian(header, 10);
            int width = getIntLittleEndian(header, 18);
            int height = getIntLittleEndian(header, 22);
            int rowSize = ((width * 24 + 31) / 32) * 4;
            int pixelArraySize = rowSize * Math.abs(height);

            byte[] pixels = new byte[pixelArraySize];

            // Read pixel data
            raf.seek(dataOffset);
            raf.read(pixels);

            // Reflect pixels horizontally
            for (int y = 0; y < Math.abs(height); y++) {
                for (int x = 0; x < width / 2; x++) {
                    // Swap pixels at positions x and (width - x - 1)
                    int pos1 = y * rowSize + 3 * x;
                    int pos2 = y * rowSize + 3 * (width - x - 1);

                    byte tmp = pixels[pos1];
                    pixels[pos1] = pixels[pos2];
                    pixels[pos2] = tmp;

                    tmp = pixels[pos1 + 1];
                    pixels[pos1 + 1] = pixels[pos2 + 1];
                    pixels[pos2 + 1] = tmp;

                    tmp = pixels[pos1 + 2];
                    pixels[pos1 + 2] = pixels[pos2 + 2];
                    pixels[pos2 + 2] = tmp;
                }
            }

            // Write pixel data back
            raf.seek(dataOffset);
            raf.write(pixels);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int getIntLittleEndian(byte[] array, int offset) {
        return (array[offset] & 0xff) | ((array[offset + 1] & 0xff) << 8) |
                ((array[offset + 2] & 0xff) << 16) | ((array[offset + 3] & 0xff) << 24);
    }
}
