package org.betpawa.cards.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;



@Getter
@Setter
public class Properties {
    private String msg;
    private String buildVersion;
    private Map<String, String> mailDetails;
    private List<String> activeBranches;

    private Properties(CardsBuilder cardsBuilder) {
        this.msg = cardsBuilder.getMsg();
        this.buildVersion = cardsBuilder.getBuildVersion();
        this.mailDetails = cardsBuilder.getMailDetails();
        this.activeBranches = cardsBuilder.getActiveBranches();

    }

    @Getter
    @Setter
    public static class CardsBuilder {
        private String msg;
        private String buildVersion;
        private Map<String, String> mailDetails;
        private List<String> activeBranches;

        public CardsBuilder msg(String msg) {
            this.msg = msg;
            return this;
        }

        public CardsBuilder buildVersion(String buildVersion) {
            this.buildVersion = buildVersion;
            return this;
        }

        public CardsBuilder mailDetails(Map<String, String> mailDetails) {
            this.mailDetails = mailDetails;
            return this;
        }

        public CardsBuilder activeBranches(List<String> activeBranches) {
            this.activeBranches = activeBranches;
            return this;
        }

        public Properties build() {
            return new Properties(this);
        }

    }
}
