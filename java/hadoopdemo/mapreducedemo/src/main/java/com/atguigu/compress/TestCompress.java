package com.atguigu.compress;

import com.jcraft.jsch.IO;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.compress.CompressionCodec;
import org.apache.hadoop.io.compress.CompressionCodecFactory;
import org.apache.hadoop.io.compress.CompressionInputStream;
import org.apache.hadoop.io.compress.CompressionOutputStream;
import org.apache.hadoop.util.ReflectionUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestCompress {

    private static void compress(String path, Class<? extends CompressionCodec> codecClass) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(path);
        CompressionCodec codec = ReflectionUtils.newInstance(codecClass, new Configuration());
        FileOutputStream fileOutputStream = new FileOutputStream(path + codec.getDefaultExtension());
        CompressionOutputStream compressionOutputStream = codec.createOutputStream(fileOutputStream);
        IOUtils.copyBytes(fileInputStream, compressionOutputStream, 1024);
        IOUtils.closeStream(compressionOutputStream);
        IOUtils.closeStream(fileInputStream);
        IOUtils.closeStream(fileOutputStream);
    }

    private static void decompress(String path) throws IOException {
        CompressionCodecFactory factory = new CompressionCodecFactory(new Configuration());
        CompressionCodec codec = factory.getCodec(new Path(path));
        CompressionInputStream compressionInputStream = codec.createInputStream(new FileInputStream(path));
        FileOutputStream fileOutputStream = new FileOutputStream(path.substring(0, path.length() - 4));

        IOUtils.copyBytes(compressionInputStream, fileOutputStream, 1024);
        IOUtils.closeStream(compressionInputStream);
        IOUtils.closeStream(fileOutputStream);


    }

}
