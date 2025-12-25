package xsj.auto.ops.plat.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xsj.auto.ops.plat.domain.entity.AiLlmProvider;
import xsj.auto.ops.plat.domain.repository.AiLlmProviderRepository;

@Service
@RequiredArgsConstructor
public class AiLlmProviderDomainServiceImpl implements AiLlmProviderDomainService {
    private final AiLlmProviderRepository aiLlmProviderRepository;

    @Override
    public void checkCreate(AiLlmProvider aiLlmProvider) {
        if (aiLlmProviderRepository.existsByProviderCode(aiLlmProvider.getProviderCode())) {
            throw new RuntimeException("提供方已存在");
        }
    }
}
