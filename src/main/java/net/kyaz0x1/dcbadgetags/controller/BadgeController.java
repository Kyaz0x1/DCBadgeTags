package net.kyaz0x1.dcbadgetags.controller;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.User;
import net.kyaz0x1.dcbadgetags.config.ConfigAttributes;

import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class BadgeController {

    private static BadgeController INSTANCE;

    private BadgeController(){}

    public void addRolesByBadges(Guild guild, Member member){
        final EnumSet<User.UserFlag> flags = member.getUser().getFlags();
        final Map<User.UserFlag, String> roles = ConfigAttributes.ROLES;

        if(roles.isEmpty())
            return;

        final List<User.UserFlag> flagsToAdd = roles.keySet().stream()
                .filter(flag -> flags.stream().anyMatch($ -> $ == flag))
                .collect(Collectors.toList());

        for(User.UserFlag flag : flagsToAdd){
            try {
                final Role role = guild.getRoleById(roles.get(flag));
                guild.addRoleToMember(member, role).queue();
                System.out.printf("[Bot] Adicionado o cargo %s para o membro %s\n",
                        role.getName(), member.getEffectiveName());
            }catch(Exception e){
                System.err.printf("[Bot] Ocorreu um erro ao adicionar o cargo para o membro %s! Erro: %s\n",
                        member.getEffectiveName(), e.getMessage());
            }
        }
    }

    public static BadgeController getInstance(){
        if(INSTANCE == null){
            synchronized(BadgeController.class){
                if(INSTANCE == null){
                    INSTANCE = new BadgeController();
                }
            }
        }
        return INSTANCE;
    }

}