package com.terencechill.tutorialmod.network.message;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

/**
 * Created by Raphi on 16.02.2018.
 */
public class MessageUpdate implements IMessage, IMessageHandler<MessageUpdate, IMessage> {

    private int playerId;
    private boolean greeting;

    public MessageUpdate()
    {
    }

    public MessageUpdate(int playerId, boolean greeting)
    {
        this.playerId = playerId;
        this.greeting = greeting;
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        buf.writeInt(playerId);
        buf.writeBoolean(greeting);
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        this.playerId = buf.readInt();
        this.greeting = buf.readBoolean();
    }

    @Override
    public IMessage onMessage(MessageUpdate message, MessageContext ctx)
    {
        Entity entity = Minecraft.getMinecraft().world.getEntityByID(message.playerId);
        if(entity instanceof EntityPlayer)
        {
            entity.getEntityData().setBoolean("greeting", message.greeting);
        }
        return null;
    }
}
