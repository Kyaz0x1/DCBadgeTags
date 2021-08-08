package net.kyaz0x1.dcbadgetags.config;

import net.dv8tion.jda.api.entities.User;

import java.util.HashMap;
import java.util.Map;

public class ConfigAttributes {

    // Guild id to add roles and verify
    public static final String GUILD_ID = "";

    // Map containing the ids of all roles by type
    public static final Map<User.UserFlag, String> ROLES = new HashMap<>();

    static {
        /*
        ROLES.put(User.UserFlag.EARLY_SUPPORTER, "");
        ROLES.put(User.UserFlag.VERIFIED_DEVELOPER, "");
         */
    }

}