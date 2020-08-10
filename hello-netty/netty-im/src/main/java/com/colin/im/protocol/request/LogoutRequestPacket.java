package com.colin.im.protocol.request;

import com.colin.im.protocol.Packet;
import com.colin.im.protocol.command.Command;

public class LogoutRequestPacket extends Packet {
    @Override
    public Byte getCommand() {

        return Command.LOGOUT_REQUEST;
    }
}
