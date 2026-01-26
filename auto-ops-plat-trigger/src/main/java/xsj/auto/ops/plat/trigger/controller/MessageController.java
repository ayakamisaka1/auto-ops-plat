package xsj.auto.ops.plat.trigger.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import xsj.auto.ops.plat.api.common.ResultBody;
import xsj.auto.ops.plat.api.http.MessageServiceApi;
import xsj.auto.ops.plat.api.request.MessageRequest;
import xsj.auto.ops.plat.api.response.MessageResponse;
import xsj.auto.ops.plat.application.entityCase.MessageCase;

import java.util.List;

@RestController
@RequestMapping("/memory/message")
@RequiredArgsConstructor
public class MessageController implements MessageServiceApi {

    private final MessageCase messageCase;

    @Override
    @GetMapping("/list")
    public ResultBody<List<MessageResponse>> list() {
        return messageCase.list();
    }

    @Override
    @GetMapping("/{id}")
    public ResultBody<MessageResponse> getById(@PathVariable Long id) {
        return messageCase.getById(id);
    }

    @Override
    @PostMapping
    public ResultBody<MessageResponse> create(@RequestBody MessageRequest request) {
        return messageCase.create(request);
    }

    @Override
    @PutMapping
    public ResultBody<MessageResponse> update(@RequestBody MessageRequest request) {
        return messageCase.update(request);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResultBody<Void> delete(@PathVariable Long id) {
        return messageCase.delete(id);
    }
}
