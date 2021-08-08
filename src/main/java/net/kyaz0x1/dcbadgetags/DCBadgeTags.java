package net.kyaz0x1.dcbadgetags;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.kyaz0x1.dcbadgetags.auth.AuthCredentials;
import net.kyaz0x1.dcbadgetags.events.MemberJoinGuildEvent;

import javax.security.auth.login.LoginException;

public class DCBadgeTags {

    public static void main(String[] args) throws LoginException, InterruptedException {
        final JDA bot = JDABuilder.createDefault(AuthCredentials.TOKEN)
                .enableIntents(GatewayIntent.GUILD_MEMBERS)
                .addEventListeners(new MemberJoinGuildEvent())
                .build()
                .awaitReady();

        bot.getPresence().setActivity(Activity.watching("github.com/Kyaz0x1"));

        System.out.println("[Bot] Bot iniciado com sucesso!");
    }

}