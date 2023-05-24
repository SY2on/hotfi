package com.network13.hotfi.web;

import lombok.Getter;
import lombok.NoArgsConstructor;

public class Dto {

    @NoArgsConstructor
    @Getter
    public static class uploadLog{
        private String ip;

        private String locateName;

        private Double longitude;

        private Double latitude;

        private Double downloadSpeed;

        private Double uploadSpeed;

        private Double gitter;

        private Double ping;
    }
}
