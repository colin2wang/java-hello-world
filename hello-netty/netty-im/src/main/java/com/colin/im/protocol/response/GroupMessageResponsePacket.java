package com.colin.im.protocol.response;

import com.colin.im.protocol.Packet;
import com.colin.im.protocol.command.Command;
import com.colin.im.session.Session;
import lombok.Data;


@Data
public class GroupMessageResponsePacket extends Packet {

    private String fromGroupId;

    private Session fromUser;

    private String message;

    @Override
    public Byte getCommand() {

        return Command.GROUP_MESSAGE_RESPONSE;
    }
}
