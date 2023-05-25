package com.network13.hotfi.web;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.network13.hotfi.domain.Router;
import com.network13.hotfi.domain.RouterLog;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class LogList{
        private String ip;

        private String locateName;

        private Double longitude;

        private Double latitude;

        private Double downloadSpeedAvr;

        private Double uploadSpeedAvr;

        private Double gitterAvr;

        private Double pingAvr;

        private List<Log> logs;

        public static LogList fromRouter(Router router){
            List<Log> logs = new ArrayList<>();
            Double downloadSpeedSum = 0.0;
            Double uploadSpeedSum = 0.0;
            Double gitterSum = 0.0;
            Double pingSum = 0.0;

            for(RouterLog routerLog : router.getRouterLogList()){
                logs.add(Log.fromRouterLog(routerLog));
                downloadSpeedSum+= routerLog.getDownloadSpeed();
                uploadSpeedSum+= routerLog.getUploadSpeed();
                gitterSum+= routerLog.getGitter();
                pingSum+= routerLog.getPing();
            }
            int logCount = router.getRouterLogList().size();
            Double downloadSpeedAvr = downloadSpeedSum/logCount;
            Double uploadSpeedAvr = uploadSpeedSum/logCount;
            Double gitterAvr = gitterSum/logCount;
            Double pingAvr = pingSum/logCount;
            return new LogList(router.getIp(), router.getLocateName(), router.getLongitude(), router.getLatitude(),
                    downloadSpeedAvr, uploadSpeedAvr, gitterAvr, pingAvr, logs);
        }
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class Log{

        private Double downloadSpeed;

        private Double uploadSpeed;

        private Double gitter;

        private Double ping;

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
        private LocalDateTime time;

        public static Log fromRouterLog(RouterLog routerLog){
            return new Log(routerLog.getDownloadSpeed(), routerLog.getUploadSpeed(), routerLog.getGitter(),
                    routerLog.getPing(), routerLog.getCreatedDate());
        }
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class AllList{

        List<LogList> allIp;
    }
}
