package xsj.auto.ops.plat.domain.repository;

import xsj.auto.ops.plat.domain.entity.PromptBinding;

import java.util.List;
import java.util.Optional;

public interface PromptBindingRepository {

    void save(PromptBinding binding);

    Optional<PromptBinding> findById(Long id);

    List<PromptBinding> findAll();

    void deleteById(Long id);

    List<PromptBinding> findByBindType(String bindType);

    List<PromptBinding> findByBindId(Long bindId);

    List<PromptBinding> findByPromptId(Long promptId);

    List<PromptBinding> findByBindTypeAndBindId(String bindType, Long bindId);

    List<PromptBinding> findByEnabled(Boolean enabled);
}
