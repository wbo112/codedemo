package com.atguigu.wordcount.mapperjoin;

import org.apache.commons.io.IOUtils;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MJMapper extends Mapper<LongWritable, Text, Text, NullWritable> {
    private Map<String, String> pMap = new HashMap<>();

    @Override
    protected void setup(Context context) throws IOException, InterruptedException {
        URI[] cacheFiles = context.getCacheFiles();
        String path = cacheFiles[0].getPath();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        String line;
        while (Objects.nonNull(line = bufferedReader.readLine())) {
            String[] fields = line.split("\t");
            pMap.put(fields[0], fields[1]);
        }
        IOUtils.closeQuietly(bufferedReader);
    }

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] fields = value.toString().split("\t");
        String pname = pMap.get(fields[1]);
        Text text = new Text(fields[0] + "\t" + pname + "\t" + fields[2]);
        context.write(text, NullWritable.get());
    }
}
