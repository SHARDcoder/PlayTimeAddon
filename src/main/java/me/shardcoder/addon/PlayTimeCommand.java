package me.shardcoder.addon;

import cc.hyperium.Hyperium;
import cc.hyperium.commands.BaseCommand;
import cc.hyperium.utils.ChatColor;
import tv.twitch.chat.Chat;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

public class PlayTimeCommand implements BaseCommand {
    @Override
    public String getName() {
        return "myplaytime";
    }

    @Override
    public String getUsage() {
        return "/myplaytime";
    }

    @Override
    public void onExecute(String[] args) {
        String messageToSend = ChatColor.translateAlternateColorCodes('&', "&9[PlayTime] &f");

        if (PlayTime.getSecondsCountInt() / 86400 != 0) {
            messageToSend = messageToSend.concat(String.valueOf((PlayTime.getSecondsCountInt() / 86400))).concat("d ");
        }

        if (PlayTime.getSecondsCountInt() / 3600 != 0) {
            messageToSend = messageToSend.concat(String.valueOf((PlayTime.getSecondsCountInt() / 3600) - ((PlayTime.getSecondsCountInt() / 86400) * 24))).concat("h ");
        }

        if (PlayTime.getSecondsCountInt() / 60 != 0) {
            messageToSend = messageToSend.concat(String.valueOf((PlayTime.getSecondsCountInt() / 60) - ((PlayTime.getSecondsCountInt() / 3600) * 60))).concat("m ");
        }

        if (PlayTime.getSecondsCountInt() != 0) {
            messageToSend = messageToSend.concat(String.valueOf((PlayTime.getSecondsCountInt()) - ((PlayTime.getSecondsCountInt() / 60) * 60))).concat("s ");
        }

        Hyperium.INSTANCE.getHandlers().getGeneralChatHandler().sendMessage(messageToSend, false);
    }

    @Override
    public List<String> getCommandAliases() {
        return Collections.singletonList("mpt");
    }

    @Override
    public List<String> onTabComplete(String[] args) {
        return Collections.singletonList("myplaytime");
    }
}
