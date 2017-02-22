package org.kaddiya.mqgror

import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.apache.kafka.clients.consumer.ConsumerRecords
import org.apache.kafka.clients.consumer.KafkaConsumer
import org.apache.kafka.common.serialization.StringDeserializer
import org.kaddiya.mqgror.tasks.OrchestrationTask

import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.Future

/*
 * This Groovy source file was auto generated by running 'gradle buildInit --type groovy-library'
 * by 'Webonise' at '22/2/17 6:02 PM' with Gradle 2.3
 *
 * @author Webonise, @date 22/2/17 6:02 PM
 */
@CompileStatic
@Slf4j
class MQGror {


    public static void main(String[] args){
        ExecutorService orchestratorService = Executors.newFixedThreadPool(10);
        Long taskId = 0;
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", "some!");
        props.put("key.deserializer", StringDeserializer.class.getName());
        props.put("value.deserializer", StringDeserializer.class.getName());
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);

        List<String> topics = Arrays.asList("test")

        consumer.subscribe(topics)

        while(true){
            ConsumerRecords<String, String> records = consumer.poll(10);
            for (ConsumerRecord<String, String> record : records) {
                Map<String, Object> data = new HashMap<>();
                data.put("partition", record.partition());
                data.put("offset", record.offset());
                data.put("value", record.value());
                log.info("hello")
                OrchestrationTask task = new OrchestrationTask(++taskId)
                Future result = orchestratorService.submit(task)
                log.info("tasks with id : {} has been executed {}",result.get().taskId,result.get().sucess)
            }
        }

    }
}
