package com.ericliu.grpc.client.service;

import com.ericliu.grpc.common.dto.AppUserGrpc;
import com.ericliu.grpc.common.dto.AppUserReq;
import com.ericliu.grpc.common.dto.AppUserResp;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class AppUserService {

    @GrpcClient("appuser-grpc-server")
    private AppUserGrpc.AppUserBlockingStub appUserBlockingStub;

    public String getByName(String name) {
        AppUserResp appUserResp = appUserBlockingStub.getUser(AppUserReq.newBuilder().setName(name).build());
        return appUserResp.getMessage();
    }
}
