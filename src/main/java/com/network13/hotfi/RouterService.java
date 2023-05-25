package com.network13.hotfi;

import com.network13.hotfi.domain.Router;
import com.network13.hotfi.domain.RouterLog;
import com.network13.hotfi.domain.RouterLogRepository;
import com.network13.hotfi.domain.RouterRepository;
import com.network13.hotfi.web.Dto.uploadLog;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static com.network13.hotfi.web.Dto.*;

@Service
@Transactional
@RequiredArgsConstructor
public class RouterService {

    private final RouterRepository routerRepository;
    private final RouterLogRepository routerLogRepository;

    public void upload(uploadLog uploadLog) {
        Router router;
        //이미 등록된 공유기
        if(routerRepository.existsByIp(uploadLog.getIp())){
            router = routerRepository.findByIp(uploadLog.getIp()).orElseThrow(() -> new RuntimeException("Not found " +
                    "router"));

        }else{
            router = Router.builder().ip(uploadLog.getIp()).latitude(uploadLog.getLatitude())
                            .longitude(uploadLog.getLongitude()).locateName(uploadLog.getLocateName())
                            .build();
            routerRepository.save(router);
        }
        RouterLog routerLog = RouterLog.builder().router(router).downloadSpeed(uploadLog.getDownloadSpeed())
                .uploadSpeed(uploadLog.getUploadSpeed()).gitter(uploadLog.getGitter()).ping(uploadLog.getPing())
                .build();
        routerLogRepository.save(routerLog);
    }

    public LogList findLogListByIp(String ip) {
        if(!routerRepository.existsByIp(ip)){
            return new LogList();
        }
        Router router = routerRepository.findByIp(ip).orElseThrow(()-> new RuntimeException("Not found router"));
        return LogList.fromRouter(router);
    }

    public AllList findAll() {
        List<Router> allRouters = routerRepository.findAll();
        List<LogList> allList = new ArrayList<>();
        for(Router router : allRouters){
            allList.add(LogList.fromRouter(router));
        }
        return new AllList(allList);
    }
}
