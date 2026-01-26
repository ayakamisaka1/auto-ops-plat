package xsj.auto.ops.plat.trigger.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import xsj.auto.ops.plat.api.common.ResultBody;
import xsj.auto.ops.plat.api.http.ConversationServiceApi;
import xsj.auto.ops.plat.api.request.ConversationRequest;
import xsj.auto.ops.plat.api.response.ConversationResponse;
import xsj.auto.ops.plat.application.entityCase.ConversationCase;

import java.util.List;

@RestController
@RequestMapping("/memory/conversation")
@RequiredArgsConstructor
public class ConversationController implements ConversationServiceApi {

    private final ConversationCase conversationCase;

    @Override
    @GetMapping("/list")
    public ResultBody<List<ConversationResponse>> list() {
        return conversationCase.list();
    }

    @Override
    @GetMapping("/{id}")
    public ResultBody<ConversationResponse> getById(@PathVariable Long id) {
        return conversationCase.getById(id);
    }

    @Override
    @PostMapping
    public ResultBody<ConversationResponse> create(@RequestBody ConversationRequest request) {
        return conversationCase.create(request);
    }

    @Override
    @PutMapping
    public ResultBody<ConversationResponse> update(@RequestBody ConversationRequest request) {
        return conversationCase.update(request);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResultBody<Void> delete(@PathVariable Long id) {
        return conversationCase.delete(id);
    }
}
