package xsj.auto.ops.plat.trigger.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import xsj.auto.ops.plat.api.common.ResultBody;
import xsj.auto.ops.plat.api.http.ConversationSummaryServiceApi;
import xsj.auto.ops.plat.api.request.ConversationSummaryRequest;
import xsj.auto.ops.plat.api.response.ConversationSummaryResponse;
import xsj.auto.ops.plat.application.entityCase.ConversationSummaryService;

import java.util.List;

@RestController
@RequestMapping("/memory/conversation-summary")
@RequiredArgsConstructor
public class ConversationSummaryController implements ConversationSummaryServiceApi {

    private final ConversationSummaryService conversationSummaryService;

    @Override
    @GetMapping("/list")
    public ResultBody<List<ConversationSummaryResponse>> list() {
        return ResultBody.ok(conversationSummaryService.list());
    }

    @Override
    @GetMapping("/{id}")
    public ResultBody<ConversationSummaryResponse> getById(@PathVariable Long id) {
        return ResultBody.ok(conversationSummaryService.getById(id));
    }

    @Override
    @PostMapping
    public ResultBody<ConversationSummaryResponse> create(@RequestBody ConversationSummaryRequest request) {
        return ResultBody.ok(conversationSummaryService.create(request));
    }

    @Override
    @PutMapping
    public ResultBody<ConversationSummaryResponse> update(@RequestBody ConversationSummaryRequest request) {
        return ResultBody.ok(conversationSummaryService.update(request));
    }

    @Override
    @DeleteMapping("/{id}")
    public ResultBody<Void> delete(@PathVariable Long id) {
        conversationSummaryService.delete(id);
        return ResultBody.ok();
    }
}
