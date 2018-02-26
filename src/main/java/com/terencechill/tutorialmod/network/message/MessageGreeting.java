package com.terencechill.tutorialmod.network.message;

import com.terencechill.tutorialmod.network.PacketHandler;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

/**
 * Created by Raphi on 16.02.2018.
 */
public class MessageGreeting implements IMessage, IMessageHandler<MessageGreeting, IMessage> {

    private boolean greeting;

    public MessageGreeting()
    {
    }

    public MessageGreeting(boolean greeting)
    {
        this.greeting = greeting;
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        buf.writeBoolean(greeting);
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        this.greeting = buf.readBoolean();
    }

    @Override
    public IMessage onMessage(MessageGreeting message, MessageContext ctx)
    {
        EntityPlayer player = ctx.getServerHandler().player;
        player.getEntityData().setBoolean("greeting", message.greeting);
        PacketHandler.INSTANCE.sendToAllAround(new MessageUpdate(player.getEntityId(), message.greeting), new NetworkRegistry.TargetPoint(player.dimension, player.posX, player.posY, player.posZ, 64));
        return null;
    }
}
