package com.github.animetrity.voximplant.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CallsResponse {
    private boolean success;
    private List<Call> result;
    @JsonProperty("_meta") private Meta meta;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Call {
        private long id;
        @JsonProperty("attempt_num") private Integer attemptNum;
        @JsonProperty("calllist_item_id") private Integer calllistItemId;
        @JsonProperty("domain_id") private int domainId;
        @JsonProperty("session_id") private String sessionId;
        @JsonProperty("scenario_id") private Integer scenarioId;
        @JsonProperty("datetime_start") private String datetimeStart;
        @JsonProperty("phone_a") private String phoneA;
        @JsonProperty("phone_b") private String phoneB;
        @JsonProperty("is_incoming") private boolean isIncoming;
        @JsonProperty("call_result_code") private int callResultCode;
        private int duration;
        @JsonProperty("record_url") private String recordUrl;
        @JsonProperty("call_cost") private String callCost;
        @JsonProperty("call_data") private String callData;
        @JsonProperty("call_resources") private String callResources;
        @JsonProperty("call_calls") private String callCalls;
        @JsonProperty("call_records") private String callRecords;
        @JsonProperty("call_status") private boolean callStatus;
        private boolean recalc;
        @JsonProperty("campaign_id") private Integer campaignId;
        private boolean processing;
        @JsonProperty("scenario_version_id") private Integer scenarioVersionId;
        @JsonProperty("has_call_logs") private boolean hasCallLogs;
        @JsonProperty("user_id") private Integer userId;
        @JsonProperty("dialing_time") private int dialingTime;
        @JsonProperty("completion_code") private String completionCode;
        @JsonProperty("queue_id") private Integer queueId;
        @JsonProperty("user_group_id") private Integer userGroupId;
        @JsonProperty("callback_at") private String callbackAt;
        @JsonProperty("source_type") private String sourceType;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Meta {
        private int limit;
        private String cursor;
    }
}