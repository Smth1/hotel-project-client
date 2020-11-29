package com.roma.distr.serviceHandlers.grpc;

import com.roma.distr.api.grpc.*;
import com.roma.distr.entities.Administrator;
import com.roma.distr.entities.Cashier;
import com.roma.distr.entities.Maid;
import com.roma.distr.entities.Porter;
import com.roma.distr.entities.dto.AdministratorDTO;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import javax.annotation.PreDestroy;
import javax.net.ssl.SSLEngineResult;
import java.io.ObjectInputFilter;
import java.util.UUID;

public class AdminGrpcHandler {
    private final String URL = "localhost";

    private final ManagedChannel channel;
    private final AdminServiceGrpc.AdminServiceBlockingStub adminStub;
    private final CashierServiceGrpc.CashierServiceBlockingStub cashierStub;
    private final MaidServiceGrpc.MaidServiceBlockingStub maidStub;
    private final PorterServiceGrpc.PorterServiceBlockingStub porterStub;


    public AdminGrpcHandler() {
        channel = ManagedChannelBuilder.forAddress(URL, 6565).
                usePlaintext().build();
        adminStub = AdminServiceGrpc.newBlockingStub(channel);
        cashierStub = CashierServiceGrpc.newBlockingStub(channel);
        maidStub = MaidServiceGrpc.newBlockingStub(channel);
        porterStub = PorterServiceGrpc.newBlockingStub(channel);
    }

    public void addEmployees() {
        addAdmin();

        addCashier();

        addMaid();

        addPorter();
    }

    private void addAdmin() {
        AdministratorDTO admin = new AdministratorDTO("woeifj",234,"alksdjf");

        AdministratorTransfer administratorTransfer = AdministratorTransfer.newBuilder()
                .setAge(admin.getAge())
                .setName(admin.getName())
                .setTelephoneNumber(admin.getTelephoneNumber())
                .build();
        AdministratorRequestAdd administratorRequestAdd = AdministratorRequestAdd.newBuilder()
                .setAdmin(administratorTransfer)
                .build();

        AdministratorResponseAdd responseAdd = adminStub.addAdministrator(administratorRequestAdd);

        System.out.println("responseAdd = " + responseAdd);
    }

    private void addCashier() {
        Cashier cashier = new Cashier("Ella", 30);

        CashierTransfer cashierTransfer = CashierTransfer.newBuilder()
                .setName(cashier.getName())
                .setAge(cashier.getAge())
                .build();

        CashierRequestAdd cashierRequestAdd = CashierRequestAdd.newBuilder()
                .setCashier(cashierTransfer)
                .build();

        CashierResponseAdd cashierResponseAdd = cashierStub.addCashier(cashierRequestAdd);

        System.out.println("cashierResponseAdd = " + cashierResponseAdd);
    }

    private void addMaid() {
        Maid maid = new Maid("Amelia", 39);

        MaidTransfer maidTransfer = MaidTransfer.newBuilder()
                .setName(maid.getName())
                .setAge(maid.getAge())
                .build();

        MaidRequestAdd maidRequestAdd = MaidRequestAdd.newBuilder()
                .setMaid(maidTransfer)
                .build();

        MaidResponseAdd maidResponseAdd = maidStub.addMaid(maidRequestAdd);

        System.out.println("maidResponseAdd = " + maidResponseAdd);
    }

    private void addPorter() {
        Porter porter = new Porter("Jack", 25);

        PorterTransfer porterTransfer = PorterTransfer.newBuilder()
                .setName(porter.getName())
                .setAge(porter.getAge())
                .build();

        PorterRequestAdd porterRequestAdd = PorterRequestAdd.newBuilder()
                .setPorter(porterTransfer)
                .build();

        PorterResponseAdd porterResponseAdd = porterStub.addPorter(porterRequestAdd);

        System.out.println("porterResponseAdd = " + porterResponseAdd);
    }

    @PreDestroy
    public void close() {
        channel.shutdown();
    }
}
