package com.colin.im.protocol.response;

import com.colin.im.protocol.Packet;
import com.colin.im.protocol.command.Command;
import com.colin.im.session.Session;
import lombok.Data;

import java.util.List;


@Data
public class ListGroupMembersResponsePacket extends Packet {

    private String groupId;

    private List<Session> sessionList;

    @Override
    public Byte getCommand() {

        return Command.LIST_GROUP_MEMBERS_RESPONSE;
    }
}
