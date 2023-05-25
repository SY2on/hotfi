package com.network13.hotfi.web;

import com.network13.hotfi.RouterService;
import com.network13.hotfi.web.Dto.uploadLog;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.network13.hotfi.web.Dto.*;

@RestController
@RequiredArgsConstructor
public class RouterController {

    private final RouterService routerService;

    @PostMapping("/upload")
    public ResponseEntity<String> upload(@RequestBody uploadLog uploadLog){
        routerService.upload(uploadLog);
        return ResponseEntity.ok("Success");
    }


    @GetMapping("/log-list/{ip}")
    public ResponseEntity<LogList> logListByIp(@PathVariable String ip){
        LogList logList = routerService.findLogListByIp(ip);
        return ResponseEntity.ok(logList);
    }

}
