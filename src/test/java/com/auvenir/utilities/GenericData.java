package com.auvenir.utilities;

/**
 * Created by thuan.duong on 7/7/2017.
 */
public class GenericData {
    public enum UserStatus {
        ONBOARDING("Onboarding"),
        ACTIVE("Active"),
        INACTIVE("Inactive"),
        LOCKED("Locked"),
        WAITLISTED("Wait Listed"),
        PENDING("Pending");

        public String value;

        private UserStatus(String value) {
            this.value = value;
        }
    }
}
