package cn.ksmcbrigade.el.interfaces;

import net.minecraft.client.User;

public interface MinecraftFieldsX {
    User getUser();
    int getRightClickDelay();
    int getMissTime();

    void setUser(User user);
    void setRightClickDelay(int delay);
    void setMissTime(int time);
}
