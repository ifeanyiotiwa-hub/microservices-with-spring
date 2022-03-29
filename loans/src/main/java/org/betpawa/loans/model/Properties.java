package org.betpawa.loans.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@ToString
public class Properties {
    private String msg;
    private String buildVersion;
    private Map<String, String> mailDetails;
    private List<String> activeBranches;

    private Properties(LoansBuilder loansBuilder) {
        this.msg = loansBuilder.getMsg();
        this.buildVersion = loansBuilder.getBuildVersion();
        this.mailDetails = loansBuilder.getMailDetails();
        this.activeBranches = loansBuilder.getActiveBranches();
    }

    @Getter
    @Setter
    public static class LoansBuilder {
        private String msg;
        private String buildVersion;
        private Map<String, String> mailDetails;
        private List<String> activeBranches;

        public LoansBuilder msg(String msg) {
            this.msg = msg;
            return this;
        }

        public LoansBuilder buildVersion(String buildVersion) {
            this.buildVersion = buildVersion;
            return this;
        }

        public LoansBuilder mailDetails(Map<String, String> mailDetails) {
            this.mailDetails = mailDetails;
            return this;
        }

        public LoansBuilder activeBranches(List<String> activeBranches) {
            this.activeBranches = activeBranches;
            return this;
        }


        public Properties build() {
            return new Properties(this);
        }
    }

}
