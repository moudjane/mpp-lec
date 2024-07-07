package com.moudjane.mpplec.model;

import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MatchResponse {
    @JsonProperty("name")
    private String name;

    @JsonProperty("key")
    private String key;

    @JsonProperty("sport")
    private Sport sport;

    @JsonProperty("events")
    private List<Event> events;

    @Data
    public static class Sport {
        @JsonProperty("name")
        private String name;

        @JsonProperty("key")
        private String key;
    }

    @Data
    public static class Event {
        @JsonProperty("sequence")
        private String sequence;

        @JsonProperty("id")
        private long id;

        @JsonProperty("home")
        private Team home;

        @JsonProperty("away")
        private Team away;

        @JsonProperty("status")
        private String status;

        @JsonProperty("cutoffTime")
        private String cutoffTime;

        @JsonProperty("markets")
        private Map<String, Market> markets;

        @Data
        public static class Team {
            @JsonProperty("name")
            private String name;

            @JsonProperty("key")
            private String key;

            @JsonProperty("abbreviation")
            private String abbreviation;
        }

        @Data
        public static class Market {
            @JsonProperty("submarkets")
            private Map<String, SubMarket> submarkets;

            @Data
            public static class SubMarket {
                @JsonProperty("selections")
                private List<Selection> selections;

                @Data
                public static class Selection {
                    @JsonProperty("outcome")
                    private String outcome;

                    @JsonProperty("params")
                    private String params;

                    @JsonProperty("price")
                    private double price;

                    @JsonProperty("minStake")
                    private double minStake;

                    @JsonProperty("maxStake")
                    private double maxStake;

                    @JsonProperty("probability")
                    private double probability;

                    @JsonProperty("status")
                    private String status;

                    @JsonProperty("side")
                    private String side;
                }
            }
        }
    }
}
