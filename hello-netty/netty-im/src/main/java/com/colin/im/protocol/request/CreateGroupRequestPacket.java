package com.colin.im.protocol.request;

import com.colin.im.protocol.Packet;
import lombok.Data;

import java.util.List;

import static com.colin.im.protocol.command.Command.CREATE_GROUP_REQUEST;


@Data
public class CreateGroupRequestPacket extends Packet {

    private List<String> userIdList;

    @Override
    public Byte getCommand() {

        return CREATE_GROUP_REQUEST;
    }
}
