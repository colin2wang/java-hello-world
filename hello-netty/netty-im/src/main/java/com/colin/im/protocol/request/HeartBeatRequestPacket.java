package com.colin.im.protocol.request;


import com.colin.im.protocol.Packet;
import com.colin.im.protocol.command.Command;

public class HeartBeatRequestPacket extends Packet {
    @Override
    public Byte getCommand() {
        return Command.HEARTBEAT_REQUEST;
    }
}
