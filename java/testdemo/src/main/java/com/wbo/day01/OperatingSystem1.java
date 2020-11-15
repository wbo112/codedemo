package com.wbo.day01;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class OperatingSystem1 {


    public OperatingSystem1() {


    }

    private List<Integer> imgByteToWrite1 = new ArrayList<>();

    private void readKernelFromFile(Path path) {

        try (InputStream inputStream = Files.newInputStream(path)) {
            int tempbyte;
            while ((tempbyte = inputStream.read()) != -1) {
                imgByteToWrite1.add(tempbyte);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        int len = 0x1fe;
        int curSize = imgByteToWrite1.size();
        for (int k = 0; k < len - curSize; k++) {
            imgByteToWrite1.add(0);
        }

        imgByteToWrite1.add(0x55);
        imgByteToWrite1.add(0xaa);
        imgByteToWrite1.add(0xf0);
        imgByteToWrite1.add(0xff);
        imgByteToWrite1.add(0xff);
        len = 0x168000;
        curSize = imgByteToWrite1.size();
        for (int l = 0; l < len - curSize; l++) {
            imgByteToWrite1.add(0);
        }
    }


    public void makeFllopy1() {
        try {
            DataOutputStream out = new DataOutputStream(new FileOutputStream("system1.img"));
            for (int i = 0; i < imgByteToWrite1.size(); i++) {
                out.writeByte(imgByteToWrite1.get(i).byteValue());
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        OperatingSystem1 op = new OperatingSystem1();

        op.readKernelFromFile(Paths.get("D:\\work\\code\\operationsystem\\2\\boot1.bat"));
        op.makeFllopy1();
    }
}