package com.wbo112.javabase;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class DecompressDemo {


    public static void main(String[] args) {
        MyFunction findStrFunction = (zipInputStream, str) -> {
            try {
                return findStr(zipInputStream, "abc");
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        };
        Predicate<String> predicate = (str) -> str.endsWith("txt");

        //查找压缩包中txt文件包含关键字的文件
        List<String> list = decompress(Paths.get("a.zip"), predicate, findStrFunction);


        MyFunction saveFunction = (zipInputStream, str) -> {
            try {
                return saveFile(zipInputStream, str);
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        };
        Predicate<String> predicate1 = (str) -> true;
        //解压文件到本地
        List<String> list1 = decompress(Paths.get("a.zip"), predicate1, saveFunction);
    }


    public static List<String> decompress(Path path, Predicate<String> predicate, MyFunction myFunction) {
        ZipInputStream zipInputStream = null;

        List<String> zipFilePath = new ArrayList<>();
        try {
            zipInputStream = new ZipInputStream(Files.newInputStream(path));
            zipFilePath.addAll(decompressZipInputStream(predicate, myFunction, zipInputStream));

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (Objects.nonNull(zipInputStream)) {
                try {
                    zipInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return zipFilePath;
    }

    private static List<String> decompressZipInputStream(Predicate<String> predicate, MyFunction myFunction, ZipInputStream zipInputStream) throws IOException {
        List<String> zipFilePath = new ArrayList<>();
        ZipEntry nextEntry;
        nextEntry = zipInputStream.getNextEntry();
        Boolean result;
        while (Objects.nonNull(nextEntry)) {
            if (nextEntry.isDirectory()) {
                nextEntry = zipInputStream.getNextEntry();
                continue;

                //压缩包中的压缩包处理
            } else if (nextEntry.getName().endsWith(".zip")) {
                ZipInputStream subZipInputStream = new ZipInputStream(zipInputStream);
                decompressZipInputStream(predicate, myFunction, subZipInputStream);
                subZipInputStream.closeEntry();

            } else if (predicate.test(nextEntry.getName())) {

                result = myFunction.processInputStream(zipInputStream, nextEntry.getName().toString());

                if (result) {
                    zipFilePath.add(nextEntry.getName());
                }

            }
            System.out.println(nextEntry.getName());

            nextEntry = zipInputStream.getNextEntry();
        }
        return zipFilePath;
    }

    private static boolean findStr(InputStream zipInputStream, String str) throws IOException {
        {            //System.out.println(nextEntry.getName());
            byte[] bytes = new byte[1024];
            int len = 0;
            StringBuffer stringBuffer = new StringBuffer();

            len = zipInputStream.read(bytes, 0, bytes.length);

            while (len != -1) {
                stringBuffer.append(new String(bytes, 0, len));
                bytes = new byte[1024];
                len = zipInputStream.read(bytes, 0, bytes.length);
            }


            if (stringBuffer.indexOf(str) != -1) {
                return true;
            }
            return false;
        }
    }

    private static boolean saveFile(InputStream zipInputStream, String path) throws IOException {
        {            //System.out.println(nextEntry.getName());

            if (!Files.isDirectory(Paths.get(path).getParent())) {
                Files.createDirectories(Paths.get(path).getParent());
            }
            Files.copy(zipInputStream, Paths.get(path));


            return true;
        }
    }


}
