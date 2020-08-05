package com.colin.iot.common.message;

import com.colin.iot.internal.InternalMessage;

/**
 * 消息转发,基于kafka
 *
 * @author james
 */
public interface GrozaKafkaService {
    void send(InternalMessage internalMessage);
}
