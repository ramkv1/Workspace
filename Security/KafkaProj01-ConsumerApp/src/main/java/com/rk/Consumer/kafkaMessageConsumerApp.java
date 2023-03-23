package com.rk.Consumer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

public class kafkaMessageConsumerApp 
{
    public static void main( String[] args )
    {
    	//create apache kafka properties
    	Properties props=new Properties();
    	props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
    	props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class.getName());
    	props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class.getName());
    	props.put(ConsumerConfig.GROUP_ID_CONFIG, "consumer_grp1");
    	//create kafka producer Object
    	KafkaConsumer<String, String> consumer=new KafkaConsumer<String, String>(props);
    	//create ProducerRecord<-,-> Obj respresenting the message
    	consumer.subscribe(Arrays.asList("nit-tpc1"));
    	//read the message through polling
    	while(true) {
    		ConsumerRecords<String, String> records=consumer.poll(Duration.ofMillis(1000));
    		for(ConsumerRecord record:records) {
    			System.out.println(record.value() );
    		}
    	}
    }
}
