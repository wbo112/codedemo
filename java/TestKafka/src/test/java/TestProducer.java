import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class TestProducer {
    public static void main(String[] args) {
//1、创建kafka的生产者
        Properties properties = new Properties();
        //设置集群属性
        properties.put("bootstrap.servers", "192.168.50.227:9092,192.168.50.12:9092,192.168.50.173:9092");
        //设置key value 序列化方式
        properties.put("key.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");
        KafkaProducer<String, String> kafkaProduce = new KafkaProducer<String, String>(properties);
        for (int i = 0; i < 5; i++) {
            //2、创建数据载体
            ProducerRecord<String, String> producerRecord = new ProducerRecord<>("test", "12345");

            //3、 发送数据
            kafkaProduce.send(producerRecord);
        }
        kafkaProduce.close();

    }
}
