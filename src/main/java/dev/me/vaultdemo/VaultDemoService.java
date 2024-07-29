package dev.me.vaultdemo;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import org.springframework.vault.core.VaultKeyValueOperations;
import org.springframework.vault.core.VaultKeyValueOperationsSupport.KeyValueBackend;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.support.VaultResponse;

import java.util.Objects;

@Service
public class VaultDemoService {

    private final VaultTemplate vaultTemplate;

    public VaultDemoService(VaultTemplate vaultTemplate) {
        this.vaultTemplate = vaultTemplate;
    }

    @PostConstruct
    public void init() {
        VaultKeyValueOperations secret = vaultTemplate.opsForKeyValue("secret", KeyValueBackend.KV_2);
        VaultResponse vaultDemo = secret.get("application");
        assert vaultDemo != null;
        System.out.println("spring.datasource.url: " + Objects.requireNonNull(vaultDemo.getData()).get("spring.datasource.url"));;
        System.out.println("spring.datasource.username: " + Objects.requireNonNull(vaultDemo.getData()).get("spring.datasource.username"));;
        System.out.println("spring.datasource.password: " + Objects.requireNonNull(vaultDemo.getData()).get("spring.datasource.password"));;
    }

}
