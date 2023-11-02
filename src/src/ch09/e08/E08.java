package ch09.e08;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class E08 {
    public static void run() {
        System.out.print("Which folder do you want to zip: ");
        Scanner scanner = new Scanner(System.in);
        String folderToBeZip = scanner.nextLine();
        File toBeZipFolder = new File(folderToBeZip);
        if (!toBeZipFolder.isDirectory()) {
            System.out.println("Please input a folder.");
            return;
        }

        String zipFile = toBeZipFolder.getParent() + File.separator + toBeZipFolder.getName() + ".zip";
        try {
            zipDirectory(toBeZipFolder, zipFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Done!");
    }

    public static void zipDirectory(File sourceDir, String zipFilePath) throws IOException {
        try(FileOutputStream fos = new FileOutputStream(zipFilePath);
        ZipOutputStream zos = new ZipOutputStream(fos)) {
            zipFiles(sourceDir, sourceDir, zos);
        }
    }

    private static void zipFiles(File rootDir, File currentFile, ZipOutputStream zos) throws IOException {
        if (currentFile.isDirectory()) {
            File[] files = currentFile.listFiles();
            if (files != null) {
                for (File file : files) {
                    zipFiles(rootDir, file, zos);
                }
            }
        } else {
            byte[] buffer = new byte[1024];

            FileInputStream fis = new FileInputStream(currentFile);
            String relativePath = currentFile.getCanonicalPath().substring(rootDir.getCanonicalPath().length() + 1);
            ZipEntry ze = new ZipEntry(relativePath);
            zos.putNextEntry(ze);

            int length;
            while ((length = fis.read(buffer)) > 0) {
                zos.write(buffer, 0, length);
            }

            zos.closeEntry();
            fis.close();
        }
    }
}
