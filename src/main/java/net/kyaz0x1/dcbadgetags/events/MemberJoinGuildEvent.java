package net.kyaz0x1.dcbadgetags.events;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.kyaz0x1.dcbadgetags.config.ConfigAttributes;
import net.kyaz0x1.dcbadgetags.controller.BadgeController;
import org.jetbrains.annotations.NotNull;

public class MemberJoinGuildEvent extends ListenerAdapter {

    private final BadgeController controller;

    public MemberJoinGuildEvent(){
        this.controller = BadgeController.getInstance();
    }

    @Override
    public void onGuildMemberJoin(@NotNull GuildMemberJoinEvent event) {
        final Guild guild = event.getGuild();
        final Member member = event.getMember();

        if(!guild.getId().equals(ConfigAttributes.GUILD_ID))
            return;

        controller.addRolesByBadges(guild, member);
    }

}