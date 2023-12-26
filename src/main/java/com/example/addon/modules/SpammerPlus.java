package com.example.addon.modules;

import com.example.addon.Addon;
import meteordevelopment.meteorclient.events.game.GameLeftEvent;
import meteordevelopment.meteorclient.events.world.TickEvent;
import meteordevelopment.meteorclient.settings.*;
import meteordevelopment.meteorclient.systems.modules.Module;
import meteordevelopment.meteorclient.utils.Utils;
import meteordevelopment.meteorclient.utils.player.ChatUtils;
import meteordevelopment.orbit.EventHandler;
import java.util.List;

public class SpammerPlus extends Module {
    public SpammerPlus() {
        super(Addon.CATEGORY, "Spammer++", "Не можешь победить врага силой - победи спамом.");
    }

    private final SettingGroup basic = settings.createGroup("Basic");
    private final SettingGroup msg = settings.createGroup("Spam modes");
    private final SettingGroup reply = settings.createGroup("Auto reply modes");

    //общее
    private final Setting<Boolean> disableOnLeave = basic.add(new BoolSetting.Builder()
        .name("Disable on leave")
        .description("Yes.")
        .defaultValue(true)
        .build()
    );
    private final Setting<String> msgcmd = basic.add(new StringSetting.Builder()
        .name("Private message command")
        .description("Command for private message")
        .defaultValue("/msg")
        .build()
    );
    private final Setting<String> rcmd = basic.add(new StringSetting.Builder()
        .name("Reply command")
        .description("Command for automatic response")
        .defaultValue("/r")
        .build()
    );
    //сообщения и игроки 1
    public final Setting<Boolean> mode1 = msg.add(new BoolSetting.Builder()
        .name("Mode 1")
        .description("")
        .defaultValue(false)
        .build()
    );
    private final Setting<Integer> delay1 = msg.add(new IntSetting.Builder()
        .name("Delay")
        .description("In ticks")
        .defaultValue(1000)
        .min(0)
        .sliderRange(0, 2000)
        .visible(() -> mode1.get())
        .build()
    );
    private final Setting<List<String>> msg1 = msg.add(new StringListSetting.Builder()
        .name("Messages")
        .description("")
        .defaultValue(List.of("Sup, pls kys, you fucking nazi, i fucked you and your pendos langue, learn russian nigga", "a? speak Russian sucker"))
        .visible(() -> mode1.get())
        .build()
    );
    private final Setting<List<String>> players1 = msg.add(new StringListSetting.Builder()
        .name("Players")
        .description("Spamming the players listed here")
        .defaultValue(List.of("qbasty"))
        .visible(() -> mode1.get())
        .build()
    );
    //сообщения и игроки 2
    public final Setting<Boolean> mode2 = msg.add(new BoolSetting.Builder()
        .name("Mode 2")
        .description("")
        .defaultValue(false)
        .build()
    );
    private final Setting<Integer> delay2 = msg.add(new IntSetting.Builder()
        .name("Delay")
        .description("In ticks")
        .defaultValue(1000)
        .min(0)
        .sliderRange(0, 2000)
        .visible(() -> mode2.get())
        .build()
    );
    private final Setting<List<String>> msg2 = msg.add(new StringListSetting.Builder()
        .name("Messages")
        .description("")
        .defaultValue(List.of("I fucked you and your pendos langue, kys nigga, hello from ZaMorgen and TheSemeen", "Glory to Russia мать вашу"))
        .visible(() -> mode2.get())
        .build()
    );
    private final Setting<List<String>> players2 = msg.add(new StringListSetting.Builder()
        .name("Players")
        .description("Spamming the players listed here")
        .defaultValue(List.of("qbasty"))
        .visible(() -> mode2.get())
        .build()
    );
    //сообщения и игроки 3
    public final Setting<Boolean> mode3 = msg.add(new BoolSetting.Builder()
        .name("Mode 3")
        .description("")
        .defaultValue(false)
        .build()
    );
    private final Setting<Integer> delay3 = msg.add(new IntSetting.Builder()
        .name("Delay")
        .description("In ticks")
        .defaultValue(1000)
        .min(0)
        .sliderRange(0, 2000)
        .visible(() -> mode3.get())
        .build()
    );
    private final Setting<List<String>> msg3 = msg.add(new StringListSetting.Builder()
        .name("Messages")
        .description("")
        .defaultValue(List.of("I speak Russian not your pendos launge.", "Stop hacking idiot"))
        .visible(() -> mode3.get())
        .build()
    );
    private final Setting<List<String>> players3 = msg.add(new StringListSetting.Builder()
        .name("Players")
        .description("Spamming the players listed here")
        .defaultValue(List.of("qbasty"))
        .visible(() -> mode3.get())
        .build()
    );
    //сообщения и игроки 4
    public final Setting<Boolean> mode4 = msg.add(new BoolSetting.Builder()
        .name("Mode 4")
        .description("")
        .defaultValue(false)
        .build()
    );
    private final Setting<Integer> delay4 = msg.add(new IntSetting.Builder()
        .name("Delay")
        .description("In ticks")
        .defaultValue(1000)
        .min(0)
        .sliderRange(0, 2000)
        .visible(() -> mode4.get())
        .build()
    );
    private final Setting<List<String>> msg4 = msg.add(new StringListSetting.Builder()
        .name("Messages")
        .description("")
        .defaultValue(List.of("kid, u loser", "Son of a Monkey Bar"))
        .visible(() -> mode4.get())
        .build()
    );
    private final Setting<List<String>> players4 = msg.add(new StringListSetting.Builder()
        .name("Players")
        .description("Spamming the players listed here")
        .defaultValue(List.of("qbasty"))
        .visible(() -> mode4.get())
        .build()
    );
    //сообщения и игроки 5
    public final Setting<Boolean> mode5 = msg.add(new BoolSetting.Builder()
        .name("Mode 5")
        .description("")
        .defaultValue(false)
        .build()
    );
    private final Setting<Integer> delay5 = msg.add(new IntSetting.Builder()
        .name("Delay")
        .description("In ticks")
        .defaultValue(1000)
        .min(0)
        .sliderRange(0, 2000)
        .visible(() -> mode5.get())
        .build()
    );
    private final Setting<List<String>> msg5 = msg.add(new StringListSetting.Builder()
        .name("Messages")
        .description("")
        .defaultValue(List.of("fan", "2 plus 2 is 4, minus 1 that's your IQ"))
        .visible(() -> mode5.get())
        .build()
    );
    private final Setting<List<String>> players5 = msg.add(new StringListSetting.Builder()
        .name("Players")
        .description("Spamming the players listed here")
        .defaultValue(List.of("qbasty"))
        .visible(() -> mode5.get())
        .build()
    );
    //сообщения и игроки 6
    public final Setting<Boolean> mode6 = msg.add(new BoolSetting.Builder()
        .name("Mode 6")
        .description("")
        .defaultValue(false)
        .build()
    );
    private final Setting<Integer> delay6 = msg.add(new IntSetting.Builder()
        .name("Delay")
        .description("In ticks")
        .defaultValue(1000)
        .min(0)
        .sliderRange(0, 2000)
        .visible(() -> mode6.get())
        .build()
    );
    private final Setting<List<String>> msg6 = msg.add(new StringListSetting.Builder()
        .name("Messages")
        .description("")
        .defaultValue(List.of("Your mom owned by chvk \"Semeen\"", "АЛО БОМЖАТИНА БЕЗ МАТЕРИ Я ТВОЮ МАТЬ ОБ СТОЛ УБИЛ ЧЕРЕП ЕЙ РАЗБИЛ НОГОЙ БАТЮ ТВОЕГО С ОКНА ВЫКИНУЛ СУКА ЧМО ЕБАННОЕ ОТВЕТЬ ЧМО ЕБЛАН ТВАРЬ ШАЛАВА"))
        .visible(() -> mode6.get())
        .build()
    );
    private final Setting<List<String>> players6 = msg.add(new StringListSetting.Builder()
        .name("Players")
        .description("Spamming the players listed here")
        .defaultValue(List.of("qbasty"))
        .visible(() -> mode6.get())
        .build()
    );

    // авто /r 1**********************************************************************************************

    public final Setting<Boolean> moder1 = reply.add(new BoolSetting.Builder()
        .name("Mode 1")
        .description("")
        .defaultValue(false)
        .build()
    );
    private final Setting<Integer> delayr1 = reply.add(new IntSetting.Builder()
        .name("Delay")
        .description("In ticks")
        .defaultValue(1000)
        .min(0)
        .sliderRange(0, 2000)
        .visible(() -> moder1.get())
        .build()
    );
    private final Setting<List<String>> msgr1 = reply.add(new StringListSetting.Builder()
        .name("Messages")
        .description("")
        .defaultValue(List.of("stfu and dont cry stupid pendos"))
        .visible(() -> moder1.get())
        .build()
    );
    // авто /r 2
    public final Setting<Boolean> moder2 = reply.add(new BoolSetting.Builder()
        .name("Mode 2")
        .description("")
        .defaultValue(false)
        .build()
    );
    private final Setting<Integer> delayr2 = reply.add(new IntSetting.Builder()
        .name("Delay")
        .description("In ticks")
        .defaultValue(1000)
        .min(0)
        .sliderRange(0, 2000)
        .visible(() -> moder2.get())
        .build()
    );
    private final Setting<List<String>> msgr2 = reply.add(new StringListSetting.Builder()
        .name("Messages")
        .description("")
        .defaultValue(List.of("lololololol mad? lololololol"))
        .visible(() -> moder2.get())
        .build()
    );
    // авто /r 3
    public final Setting<Boolean> moder3 = reply.add(new BoolSetting.Builder()
        .name("Mode 3")
        .description("")
        .defaultValue(false)
        .build()
    );
    private final Setting<Integer> delayr3 = reply.add(new IntSetting.Builder()
        .name("Delay")
        .description("In ticks")
        .defaultValue(1000)
        .min(0)
        .sliderRange(0, 2000)
        .visible(() -> moder3.get())
        .build()
    );
    private final Setting<List<String>> msgr3 = reply.add(new StringListSetting.Builder()
        .name("Messages")
        .description("")
        .defaultValue(List.of("Kid, isn't it time for you to go to bed? otherwise mom will scold"))
        .visible(() -> moder3.get())
        .build()
    );
    // авто /r 4
    public final Setting<Boolean> moder4 = reply.add(new BoolSetting.Builder()
        .name("Mode 4")
        .description("")
        .defaultValue(false)
        .build()
    );
    private final Setting<Integer> delayr4 = reply.add(new IntSetting.Builder()
        .name("Delay")
        .description("In ticks")
        .defaultValue(1000)
        .min(0)
        .sliderRange(0, 2000)
        .visible(() -> moder4.get())
        .build()
    );
    private final Setting<List<String>> msgr4 = reply.add(new StringListSetting.Builder()
        .name("Messages")
        .description("")
        .defaultValue(List.of("Does your mother allow you to communicate with strangers?"))
        .visible(() -> moder4.get())
        .build()
    );

    // код для авто вырубания
    @EventHandler
    private void onGameLeft(GameLeftEvent event) {
        if (disableOnLeave.get()) toggle();
    }
    // код для спама

    private int timer1, timer2, timer3, timer4, timer5, timer6, timerr1, timerr2, timerr3, timerr4;

    @Override
    public void onActivate() {
        timer1 = delay1.get();
        timer2 = delay2.get();
        timer3 = delay3.get();
        timer4 = delay4.get();
        timer5 = delay5.get();
        timer6 = delay6.get();
        timerr1 = delayr1.get();
        timerr2 = delayr2.get();
        timerr3 = delayr3.get();
        timerr4 = delayr4.get();
    }

    @EventHandler
    private void onTick1(TickEvent.Post event1) {
        if (msg1.get().isEmpty() || players1.get().isEmpty() || msgcmd.get().isEmpty() || !mode1.get()) return;
        if (timer1 <= 0) {
            int i1, j1;
            i1 = Utils.random(0, msg1.get().size());
            j1 = Utils.random(0, players1.get().size());
            String text1 = msgcmd.get() + " " + players1.get().get(j1) + " " + msg1.get().get(i1);
            ChatUtils.sendPlayerMsg(text1);
            timer1 = delay1.get();
        } else {
            timer1--;
        }
    }

    @EventHandler
    private void onTick2(TickEvent.Post event2) {
        if (msg2.get().isEmpty() || players2.get().isEmpty() || msgcmd.get().isEmpty() || !mode2.get()) return;
        if (timer2 <= 0) {
            int i2, j2;
            i2 = Utils.random(0, msg2.get().size());
            j2 = Utils.random(0, players2.get().size());
            String text2 = msgcmd.get() + " " + players2.get().get(j2) + " " + msg2.get().get(i2);
            ChatUtils.sendPlayerMsg(text2);
            timer2 = delay2.get();
        } else {
            timer2--;
        }
    }

    @EventHandler
    private void onTick3(TickEvent.Post event3) {
        if (msg3.get().isEmpty() || players3.get().isEmpty() || msgcmd.get().isEmpty() || !mode3.get()) return;
        if (timer3 <= 0) {
            int i3, j3;
            i3 = Utils.random(0, msg3.get().size());
            j3 = Utils.random(0, players3.get().size());
            String text3 = msgcmd.get() + " " + players3.get().get(j3) + " " + msg3.get().get(i3);
            ChatUtils.sendPlayerMsg(text3);
            timer3 = delay3.get();
        } else {
            timer3--;
        }
    }

    @EventHandler
    private void onTick4(TickEvent.Post event4) {
        if (msg4.get().isEmpty() || players4.get().isEmpty() || msgcmd.get().isEmpty() || !mode4.get()) return;
        if (timer4 <= 0) {
            int i4, j4;
            i4 = Utils.random(0, msg4.get().size());
            j4 = Utils.random(0, players4.get().size());
            String text4 = msgcmd.get() + " " + players4.get().get(j4) + " " + msg4.get().get(i4);
            ChatUtils.sendPlayerMsg(text4);
            timer4 = delay4.get();
        } else {
            timer4--;
        }
    }

    @EventHandler
    private void onTick5(TickEvent.Post event5) {
        if (msg5.get().isEmpty() || players5.get().isEmpty() || msgcmd.get().isEmpty() || !mode5.get()) return;
        if (timer5 <= 0) {
            int i5, j5;
            i5 = Utils.random(0, msg5.get().size());
            j5 = Utils.random(0, players5.get().size());
            String text5 = msgcmd.get() + " " + players5.get().get(j5) + " " + msg5.get().get(i5);
            ChatUtils.sendPlayerMsg(text5);
            timer5 = delay5.get();
        } else {
            timer5--;
        }
    }

    @EventHandler
    private void onTick6(TickEvent.Post event6) {
        if (msg6.get().isEmpty() || players6.get().isEmpty() || msgcmd.get().isEmpty() || !mode6.get()) return;
        if (timer6 <= 0) {
            int i6, j6;
            i6 = Utils.random(0, msg6.get().size());
            j6 = Utils.random(0, players6.get().size());
            String text6 = msgcmd.get() + " " + players6.get().get(j6) + " " + msg6.get().get(i6);
            ChatUtils.sendPlayerMsg(text6);
            timer6 = delay6.get();
        } else {
            timer6--;
        }
    }

    // код для авто ответа
    @EventHandler
    private void onTickr1(TickEvent.Post eventr1) {
        if (msgr1.get().isEmpty() || rcmd.get().isEmpty() || !moder1.get()) return;
        if (timerr1 <= 0) {
            int q1;
            q1 = Utils.random(0, msgr1.get().size());
            String textr1 = rcmd.get() + " " + msgr1.get().get(q1);
            ChatUtils.sendPlayerMsg(textr1);
            timerr1 = delayr1.get();
        } else {
            timerr1--;
        }
    }
    @EventHandler
    private void onTickr2(TickEvent.Post eventr2) {
        if (msgr2.get().isEmpty() || rcmd.get().isEmpty() || !moder2.get()) return;
        if (timerr2 <= 0) {
            int q2;
            q2 = Utils.random(0, msgr2.get().size());
            String textr2 = rcmd.get() + " " + msgr2.get().get(q2);
            ChatUtils.sendPlayerMsg(textr2);
            timerr2 = delayr2.get();
        } else {
            timerr2--;
        }
    }
    @EventHandler
    private void onTickr3(TickEvent.Post eventr3) {
        if (msgr3.get().isEmpty() || rcmd.get().isEmpty() || !moder3.get()) return;
        if (timerr3 <= 0) {
            int q3;
            q3 = Utils.random(0, msgr3.get().size());
            String textr3 = rcmd.get() + " " + msgr3.get().get(q3);
            ChatUtils.sendPlayerMsg(textr3);
            timerr3 = delayr3.get();
        } else {
            timerr3--;
        }
    }
    @EventHandler
    private void onTickr4(TickEvent.Post eventr4) {
        if (msgr4.get().isEmpty() || rcmd.get().isEmpty() || !moder4.get()) return;
        if (timerr4 <= 0) {
            int q4;
            q4 = Utils.random(0, msgr4.get().size());
            String textr4 = rcmd.get() + " " + msgr4.get().get(q4);
            ChatUtils.sendPlayerMsg(textr4);
            timerr4 = delayr4.get();
        } else {
            timerr4--;
        }
    }
}
