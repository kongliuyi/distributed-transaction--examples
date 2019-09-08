package net.riking.provider.wallet.service;

import net.riking.provider.wallet.entity.Wallet;

public interface IWalletService {

    Wallet add(Double balance);

    void updateByUserId(Double balance);
}
