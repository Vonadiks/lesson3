import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            /*задание1*/
            //firstReadingFile();
            /*задание2*/
            //fiveFilesReadingAsOne();
            /*задание3*/
            readingFromPage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void firstReadingFile() throws Exception {
       BufferedInputStream bis = new BufferedInputStream(new FileInputStream("dir/1.txt"));
       ByteArrayOutputStream baos = new ByteArrayOutputStream();
       int x;
       while ((x = bis.read()) != -1) {
           baos.write(x);
       }
       byte[] arr = baos.toByteArray();
       System.out.println(Arrays.toString(arr));
       bis.close();
       baos.close();
    }

    public static void fiveFilesReadingAsOne() throws Exception {
        ArrayList<InputStream> al = new ArrayList();
        al.add(new FileInputStream("dir/1.txt"));
        al.add(new FileInputStream("dir/2.txt"));
        al.add(new FileInputStream("dir/3.txt"));
        al.add(new FileInputStream("dir/4.txt"));
        al.add(new FileInputStream("dir/5.txt"));

        Enumeration<InputStream> e = Collections.enumeration(al);
        BufferedInputStream bis = new BufferedInputStream(new SequenceInputStream(e));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("dir/6.txt"));

        int x;
        while ((x = bis.read()) != -1) {
            bos.write(x);
            System.out.print((char) x);
        }
        bis.close();
        bos.close();
    }

    public static void readingFromPage() throws Exception {
        final int PAGE_LENGTH = 1800;
        RandomAccessFile raf = new RandomAccessFile("dir/7.txt", "r");
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите номер страницы:");
        int nPage = sc.nextInt();
        raf.seek(PAGE_LENGTH * nPage);
        byte[] arr = new byte[1800];
        raf.read(arr);
        String s = new String(arr);
        System.out.println(s);
        raf.close();
    }



}
