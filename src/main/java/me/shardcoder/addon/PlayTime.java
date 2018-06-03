package me.shardcoder.addon;

import cc.hyperium.Hyperium;
import cc.hyperium.event.*;
import cc.hyperium.internal.addons.IAddon;

import java.sql.Time;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class PlayTime implements IAddon {
    static int secondsCountInt;

    public static int getSecondsCountInt() {
        return secondsCountInt;
    }

    Timer secondsCounterTimer = new Timer();
    TimerTask secondsCountIncrement = new TimerTask() {
        @Override
        public void run() {
            secondsCountInt++;
        }
    };

    @Override
    public void onLoad() {
        System.out.println("[PlayTime] Addon loaded");
        EventBus.INSTANCE.register(this);
    }

    @InvokeEvent
    private void init(InitializationEvent event) {
        Hyperium.INSTANCE.getHandlers().getHyperiumCommandHandler().registerCommand(new PlayTimeCommand());
        secondsCounterTimer.scheduleAtFixedRate(secondsCountIncrement, 1000, 1000);
    }

    @Override
    public void onClose() {
        System.out.println("[PlayTime] Addon closed");
    }
    
    @Override
    public void sendDebugInfo() {
    }
}
