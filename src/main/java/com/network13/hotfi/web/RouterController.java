package com.network13.hotfi.web;

import com.network13.hotfi.RouterService;
import com.network13.hotfi.web.Dto.uploadLog;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class RouterController {

    private final RouterService routerService;

    @PostMapping("/upload")
    public ResponseEntity<String> upload(@RequestBody uploadLog uploadLog){
        routerService.upload(uploadLog);
        return ResponseEntity.ok("Success");
    }

}
