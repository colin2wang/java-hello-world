package com.colin.im.protocol.response;

import com.colin.im.protocol.Packet;
import com.colin.im.protocol.command.Command;
import lombok.Data;


@Data
public class LogoutResponsePacket extends Packet {

    private boolean success;

    private String reason;


    @Override
    public Byte getCommand() {

        return Command.LOGOUT_RESPONSE;
    }
}
