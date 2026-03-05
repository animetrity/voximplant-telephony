package com.github.animetrity.voximplant.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UsersResponse {
    private boolean success;
    private List<User> result;
    @JsonProperty("_meta") private Meta meta;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class User {
        private int id;
        private String username;
        private String email;
        private long createdon;
        @JsonProperty("date_update") private String dateUpdate;
        @JsonProperty("role_id") private int roleId;
        private long lastlogin;
        private int logincount;
        private String permissions;
        @JsonProperty("blocked_date") private String blockedDate;
        @JsonProperty("blocked_until") private String blockedUntil;
        @JsonProperty("blocked_by") private Integer blockedBy;
        @JsonProperty("is_blocked") private boolean isBlocked;
        @JsonProperty("group_id") private Integer groupId;
        private boolean deleted;
        private String deletedon;
        @JsonProperty("messaging_user_id") private int messagingUserId;
        @JsonProperty("vox_id") private long voxId;
        @JsonProperty("is_2fa_enabled") private boolean is2faEnabled;
        @JsonProperty("call_status") private String callStatus;
        @JsonProperty("call_status_change_time") private String callStatusChangeTime;
        @JsonProperty("im_status") private String imStatus;
        @JsonProperty("im_status_change_time") private String imStatusChangeTime;
        @JsonProperty("max_simultaneous_conversations") private int maxSimultaneousConversations;
        @JsonProperty("full_name") private String fullName;
        private Profile profile;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Profile {
        private String utc;
        private String lang;
        private String email;
        private String avatar;
        @JsonProperty("full_name") private String fullName;
        @JsonProperty("last_name") private String lastName;
        @JsonProperty("first_name") private String firstName;
        @JsonProperty("middle_name") private String middleName;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Meta {
        private int totalCount;
        private int pageCount;
        private int currentPage;
        private int perPage;
    }
}