package com.colin.iot.store.kafka;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.colin.iot.common.message.GrozaKafkaService;
import com.colin.iot.internal.InternalMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * @author james
 * @description kafka消息生产者处理类
 */
@Service
public class KafkaServiceImpl implements GrozaKafkaService {

    private static Gson gson = new GsonBuilder().create();
    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Override
    public void send(InternalMessage internalMessage) {
        kafkaTemplate.send(internalMessage.getTopic(), gson.toJson(internalMessage));
    }
}
