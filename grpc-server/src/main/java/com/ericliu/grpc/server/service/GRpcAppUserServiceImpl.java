package com.ericliu.grpc.server.service;

import com.ericliu.grpc.common.dto.AppUserGrpc;
import com.ericliu.grpc.common.dto.AppUserReq;
import com.ericliu.grpc.common.dto.AppUserResp;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

import java.util.HashMap;
import java.util.Map;

@GrpcService
public class GRpcAppUserServiceImpl extends AppUserGrpc.AppUserImplBase {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void getUser(AppUserReq request, StreamObserver<AppUserResp> responseObserver) {

        String userName = request.getName();
        //todo selectBy userName

        Map<String, String> m = new HashMap<>();
        m.put("name", "userName");
        m.put("id", "0");
        m.put("password", "good-job");
        String s = null;
        try {
            s = objectMapper.writeValueAsString(m);
        } catch (JsonProcessingException e) {
            s = e.getMessage();
        }

        AppUserResp reply = AppUserResp.newBuilder().setCode(0).setMessage(s).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
