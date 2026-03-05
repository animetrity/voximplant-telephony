package com.github.animetrity.voximplant.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class AccountInfoResponse {
    private boolean success;
    private Result result;

    @Data
    public static class Result {
        private Domain domain;
        @JsonProperty("cc_enabled") private boolean ccEnabled;
        @JsonProperty("cc_enabled_date") private String ccEnabledDate;
        @JsonProperty("cc_demo_mode") private boolean ccDemoMode;
        @JsonProperty("function_enabled") private boolean functionEnabled;
        @JsonProperty("max_users") private int maxUsers;
        @JsonProperty("max_trial_users") private int maxTrialUsers;
        @JsonProperty("need_reg_form") private boolean needRegForm;
        @JsonProperty("reg_form_completed") private boolean regFormCompleted;
        @JsonProperty("agent_campaigns_enabled") private boolean agentCampaignsEnabled;
        @JsonProperty("can_sip_refer") private boolean canSipRefer;
        @JsonProperty("enable_2fa") private boolean enable2fa;
        @JsonProperty("max_attachments_in_storage") private int maxAttachmentsInStorage;
        @JsonProperty("attachments_on_account") private int attachmentsOnAccount;
        @JsonProperty("application_id") private int applicationId;
        @JsonProperty("account_id") private int accountId;
        @JsonProperty("internal_chat_enabled") private boolean internalChatEnabled;
        @JsonProperty("blending_enabled") private boolean blendingEnabled;
        @JsonProperty("media_servers_regions") private List<String> mediaServersRegions;
        @JsonProperty("max_queues") private int maxQueues;
        @JsonProperty("account_region") private String accountRegion;
        @JsonProperty("full_name_mode") private String fullNameMode;
        private int node;
        @JsonProperty("fullcode_enabled") private boolean fullcodeEnabled;
        @JsonProperty("available_lines_count") private int availableLinesCount;
        @JsonProperty("outbound_dialer_enabled") private boolean outboundDialerEnabled;
        @JsonProperty("waf_enabled") private boolean wafEnabled;
        @JsonProperty("max_queues_per_agent") private int maxQueuesPerAgent;
        @JsonProperty("enable_scripting_scenarios") private boolean enableScriptingScenarios;
    }

    @Data
    public static class Domain {
        private int id;
        private String name;
        private double balance;
        private double credit;
        private String currency;
        @JsonProperty("max_lines_count") private int maxLinesCount;
        private Partner partner;
        private Tariff tariff;
        @JsonProperty("can_change_tariff") private boolean canChangeTariff;
        @JsonProperty("cc_settings") private CcSettings ccSettings;
    }

    @Data
    public static class Partner {
        private String name;
        private String theme;
        private String blocks;
        @JsonProperty("default_balance") private String defaultBalance;
        @JsonProperty("default_currency") private String defaultCurrency;
        @JsonProperty("media_servers_regions") private List<String> mediaServersRegions;
    }

    @Data
    public static class Tariff {
        private int id;
    }

    @Data
    public static class CcSettings {
        @JsonProperty("can_inbound_calls") private boolean canInboundCalls;
        @JsonProperty("can_outbound_calls") private boolean canOutboundCalls;
        @JsonProperty("outbound_phone_id") private Integer outboundPhoneId;
        @JsonProperty("outbound_caller_id") private Integer outboundCallerId;
        @JsonProperty("card_load_type") private String cardLoadType;
        @JsonProperty("card_load_url") private String cardLoadUrl;
        @JsonProperty("card_load_function_id") private Integer cardLoadFunctionId;
        @JsonProperty("card_load_enabled") private boolean cardLoadEnabled;
        @JsonProperty("can_internal_calls") private boolean canInternalCalls;
        @JsonProperty("outbound_record_notification_type") private String outboundRecordNotificationType;
        @JsonProperty("tts_language") private String ttsLanguage;
        @JsonProperty("tts_voice") private String ttsVoice;
        @JsonProperty("tts_text") private String ttsText;
        @JsonProperty("can_outbound_record") private boolean canOutboundRecord;
        @JsonProperty("media_id") private Integer mediaId;
        @JsonProperty("can_change_caller_id") private boolean canChangeCallerId;
        @JsonProperty("can_hold_record") private boolean canHoldRecord;
        @JsonProperty("hold_media_id") private Integer holdMediaId;
        @JsonProperty("outbound_record_notification_duration") private String outboundRecordNotificationDuration;
        @JsonProperty("agent_dialing_max_waiting_time_sec") private int agentDialingMaxWaitingTimeSec;
        @JsonProperty("agent_dialing_media_enabled") private boolean agentDialingMediaEnabled;
        @JsonProperty("agent_dialing_media_id") private int agentDialingMediaId;
        @JsonProperty("group_dialing_media_enabled") private boolean groupDialingMediaEnabled;
        @JsonProperty("group_dialing_media_id") private int groupDialingMediaId;
        @JsonProperty("queue_dialing_media_enabled") private boolean queueDialingMediaEnabled;
        @JsonProperty("queue_dialing_media_id") private int queueDialingMediaId;
        @JsonProperty("outbound_sip_number_id") private int outboundSipNumberId;
        @JsonProperty("can_internal_record") private boolean canInternalRecord;
        @JsonProperty("hold_notification_enabled") private boolean holdNotificationEnabled;
        @JsonProperty("hold_notification_time_sec") private int holdNotificationTimeSec;
        @JsonProperty("internal_record_storage_duration") private String internalRecordStorageDuration;
        @JsonProperty("can_agent_access_calls_recordings") private boolean canAgentAccessCallsRecordings;
        @JsonProperty("outbound_record_mode") private String outboundRecordMode;
        @JsonProperty("can_agent_access_calls_history") private boolean canAgentAccessCallsHistory;
        @JsonProperty("can_agent_access_messaging_history") private boolean canAgentAccessMessagingHistory;
        @JsonProperty("can_agent_access_outgoing_message") private boolean canAgentAccessOutgoingMessage;
        @JsonProperty("afterservice_enabled") private boolean afterserviceEnabled;
        @JsonProperty("max_outbound_afterservice_timer_enabled") private boolean maxOutboundAfterserviceTimerEnabled;
        @JsonProperty("max_incoming_afterservice_timer_enabled") private boolean maxIncomingAfterserviceTimerEnabled;
        @JsonProperty("max_outbound_afterservice_time_sec") private int maxOutboundAfterserviceTimeSec;
        @JsonProperty("max_incoming_afterservice_time_sec") private int maxIncomingAfterserviceTimeSec;
        @JsonProperty("external_statistic_enabled") private boolean externalStatisticEnabled;
        @JsonProperty("external_statistics") private List<String> externalStatistics;
        @JsonProperty("enable_routing_rules") private boolean enableRoutingRules;
        @JsonProperty("routing_rule_id") private Integer routingRuleId;
        @JsonProperty("scripting_scenario_in_id") private Integer scriptingScenarioInId;
        @JsonProperty("secure_call_recording") private boolean secureCallRecording;
        @JsonProperty("outbound_phone_number_ids") private List<Integer> outboundPhoneNumberIds;
        @JsonProperty("outbound_sip_number_ids") private List<Integer> outboundSipNumberIds;
        @JsonProperty("outbound_caller_ids") private List<Integer> outboundCallerIds;
        @JsonProperty("automatic_rules_enabled") private boolean automaticRulesEnabled;
        @JsonProperty("scripting_scenario_out_id") private Integer scriptingScenarioOutId;
    }
}